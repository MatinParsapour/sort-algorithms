package ir.dastan.uni.es.fp.util;

import ir.dastan.uni.es.fp.services.impl.*;

public class ContextUtil {

    private static final ChronometerServiceImpl CHRONOMETER_SERVICE_IMPL = new ChronometerServiceImpl();
    private static final DisplayListServiceImpl DISPLAY_LIST_SERVICE_IMPL = new DisplayListServiceImpl();
    private static final DisplayNumberServiceImpl DISPLAY_NUMBER_SERVICE_IMPL = new DisplayNumberServiceImpl();
    private static final ExcelServiceImpl EXCEL_SERVICE_IMPL = new ExcelServiceImpl();
    private static final DisplayTextServiceImpl DISPLAY_TEXT_SERVICE_IMPL = new DisplayTextServiceImpl();

    public static ChronometerServiceImpl getChronometerServiceImpl() {
        return CHRONOMETER_SERVICE_IMPL;
    }

    public static DisplayListServiceImpl getDisplayListService() {
        return DISPLAY_LIST_SERVICE_IMPL;
    }

    public static DisplayNumberServiceImpl getDisplayNumberService() {
        return DISPLAY_NUMBER_SERVICE_IMPL;
    }

    public static ExcelServiceImpl getExcelServiceImpl() {
        return EXCEL_SERVICE_IMPL;
    }

    public static DisplayTextServiceImpl getDisplayTextServiceImpl() {
        return DISPLAY_TEXT_SERVICE_IMPL;
    }
}
