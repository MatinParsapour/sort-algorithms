package ir.dastan.uni.es.fp.entity;

public class Insertion extends Algorithm{
    @Override
    public void sort() {
        for (int pointer = 1; pointer < list.size(); pointer++) {
            int key = list.get(pointer);
            int index = pointer - 1;

            while (index >= 0 && list.get(index) > key) {
                list.set(index + 1, list.get(index));
                index--;
            }
            list.set(index + 1, key);
        }
        isSorted = true;
    }
}
