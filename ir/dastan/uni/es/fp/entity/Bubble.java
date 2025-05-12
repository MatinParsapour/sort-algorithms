package ir.dastan.uni.es.fp.entity;

public class Bubble extends Algorithm {

    @Override
    public void sort() {
        if (isSorted) {
            return;
        }
        int pointer,index,temp = 0;
        boolean swapped;
        for (pointer = 0; pointer < list.size(); pointer++) {
            swapped = false;
            for (index = 0; index < list.size() - pointer - 1; index++) {
                if (list.get(index) > list.get(index + 1)) {
                    temp = list.get(index);
                    list.set(index, list.get(index + 1));
                    list.set(index + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        isSorted = true;
    }
}
