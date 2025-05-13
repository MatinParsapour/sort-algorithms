package ir.dastan.uni.es.fp.services.impl;

import ir.dastan.uni.es.fp.entity.Algorithm;
import ir.dastan.uni.es.fp.services.Service;
import ir.dastan.uni.es.fp.util.ContextUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static ir.dastan.uni.es.fp.constant.Constant.GROUP_SIZE;

public class ExcelServiceImpl implements Service<ExcelServiceImpl, Boolean, List<? extends Number>> {

    private List<? extends Number> list;
    private XSSFWorkbook workbook;
    private long sampleNumber = 1;
    private Algorithm algorithm;
    private boolean isDurations = false;
    private int size = 0;

    @Override
    public ExcelServiceImpl set(List<? extends Number> value) {
        this.list = value;
        return this;
    }

    public ExcelServiceImpl set(Algorithm algorithm) {
        this.algorithm = algorithm;
        this.list = algorithm.getList();
        return this;
    }

    public ExcelServiceImpl set(long sampleNumber) {
        this.sampleNumber = sampleNumber;
        return this;
    }

    public ExcelServiceImpl set(boolean isDurations) {
        this.isDurations = isDurations;
        return this;
    }

    public ExcelServiceImpl set(int size) {
        this.size = size;
        return this;
    }

    @Override
    public Boolean perform() {
        boolean result = false;
        try {
            if (workbook == null) {
                workbook = new XSSFWorkbook();
            }
            String sheetName = getSheetName();
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
            }

            int rowNumber = 0;
            if (sheet.getLastRowNum() + 1 != 0) {
                rowNumber = sheet.getLastRowNum() + 2;
            }
            header(sheet, rowNumber);
            rowNumber++;
            for (int index = 0; index < list.size(); index+=10) {
                Row row = sheet.createRow(rowNumber);
                for (int tempIndex = 0; tempIndex < GROUP_SIZE; tempIndex++) {
                    int sum = index + tempIndex;
                    if (sum >= list.size()) {
                        break;
                    }
                    row.createCell(tempIndex).setCellValue(list.get(sum).longValue());
                }
                rowNumber++;
            }

            FileOutputStream excel = new FileOutputStream(algorithm.getClass().getSimpleName() + "_" + size + ".xlsx");
            workbook.write(excel);
            excel.close();
        } catch (IOException exception) {
            ContextUtil.getDisplayTextServiceImpl().set("An error occurred : " + exception.getMessage()).perform();
        } finally {
            isDurations = false;
        }
        return result;
    }

    private void header(Sheet sheet, int rowNumber) {
        Row row = sheet.createRow(rowNumber);
        Cell cell = row.createCell(0);
        if (isDurations) {
            cell.setCellValue("Durations");
        } else {
            cell.setCellValue("Sample Number " + sampleNumber);
        }
        sheet.addMergedRegion(new CellRangeAddress(rowNumber, rowNumber, 0, 9));
        CellStyle style = sheet.getWorkbook().createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
    }

    private String getSheetName() {
        StringBuilder name = new StringBuilder();
        name.append(list.size());
        if (isDurations) {
            name.append("_durations");
            return name.toString();
        }
        if (algorithm.isSorted()) {
            name.append("_sorted");
        } else {
            name.append("_unsorted");
        }
        return name.toString();
    }

    public void clear() {
        workbook = null;
    }
}
