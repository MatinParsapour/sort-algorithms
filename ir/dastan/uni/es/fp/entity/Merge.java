package ir.dastan.uni.es.fp.entity;

public class Merge extends Algorithm{

    @Override
    public void sort() {
        sort(0, list.size() - 1);
        isSorted = true;
    }

    private void sort(int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {

            int middle = lowerBound + (upperBound - lowerBound) / 2;
            sort(lowerBound, middle);
            sort(middle + 1, upperBound);
            merge(lowerBound, middle, upperBound);
        }
    }

    private void merge(int lowerBound, int middleBound, int upperBound) {
        int firstSubArraySize = middleBound - lowerBound + 1;
        int secondSubArraySize = upperBound - middleBound;

        int[] leftSubArray = new int[firstSubArraySize];
        int[] rightSubArray = new int[secondSubArraySize];

        for (int index = 0; index < firstSubArraySize; index++) {
            leftSubArray[index] = list.get(lowerBound + index);
        }
        for (int index = 0; index < secondSubArraySize; index++) {
            rightSubArray[index] = list.get(middleBound + 1 + index);
        }

        int firstSubArrayIndex = 0, secondSubArrayIndex = 0;

        int initialIndexOfMergedArray = lowerBound;
        while (firstSubArrayIndex < firstSubArraySize && secondSubArrayIndex < secondSubArraySize) {
            if (leftSubArray[firstSubArrayIndex] <= rightSubArray[secondSubArrayIndex]) {
                list.set(initialIndexOfMergedArray, leftSubArray[firstSubArrayIndex]);
                firstSubArrayIndex++;
            } else {
                list.set(initialIndexOfMergedArray, rightSubArray[secondSubArrayIndex]);
                secondSubArrayIndex++;
            }
            initialIndexOfMergedArray++;
        }

        while (firstSubArrayIndex < firstSubArraySize) {
            list.set(initialIndexOfMergedArray, leftSubArray[firstSubArrayIndex]);
            firstSubArrayIndex++;
            initialIndexOfMergedArray++;
        }

        while (secondSubArrayIndex < secondSubArraySize) {
            list.set(initialIndexOfMergedArray, rightSubArray[secondSubArrayIndex]);
            secondSubArrayIndex++;
            initialIndexOfMergedArray++;
        }
    }
}
