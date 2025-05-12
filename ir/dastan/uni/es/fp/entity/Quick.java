package ir.dastan.uni.es.fp.entity;

public class Quick extends Algorithm{
    @Override
    public void sort() {
        sort(0, list.size() - 1);
        isSorted = true;
    }

    private void sort(int low, int high) {
        if (low < high) {
            int partition = partition(low, high);
            sort(low, partition - 1);
            sort(partition + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = list.get(high);
        int index = low - 1;
        for (int j = low; j <= high; j++) {
            if (list.get(j) < pivot) {
                index++;
                swap(index, j);
            }
        }

        swap(index + 1, high);
        return index+1;
    }

    private void swap(int index, int j) {
        int temp = list.get(index);
        list.set(index, list.get(j));
        list.set(j, temp);
    }
}
