package DataStructures;

import java.util.ArrayList;

public class MergeSort {
    private ArrayList<Integer> numList;
    private int[] sorted = null;

    public MergeSort() {
        numList = new ArrayList<Integer>();
    }

    public void add(int newNum) {
        numList.add(newNum);
    }

    public void sort() {
        int[] numArray = new int[numList.size()];
        for (int i=0; i<numList.size(); i++) {
            numArray[i] = numList.get(i);
        }

        sorted = mergeSort(numArray);
    }

    public int[] mergeSort(int[] numArray) {
        int size = numArray.length;

        if (size == 1) { return numArray;}

        int sizeLeft = size/2;
        int sizeRight = size - (size/2);

        int[] leftArray = new int[sizeLeft];
        int[] rightArray = new int[sizeRight];

        for (int i=0; i<sizeLeft; i++) {
            leftArray[i] = numArray[i];
        }
        for (int i=0; i<sizeRight; i++) {
            rightArray[i] = numArray[sizeLeft+i];
        }

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        return merge(leftArray, rightArray);
    }
    public int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int mergedPointer = 0;

        while ((leftPointer < left.length) && (rightPointer < right.length)) {
            if(left[leftPointer] > right[rightPointer]){
                merged[mergedPointer] = right[rightPointer];
                rightPointer++;
                mergedPointer++;
            }
            else {
                merged[mergedPointer] = left[leftPointer];
                leftPointer++;
                mergedPointer++;
            }
        }

        while (leftPointer < left.length) {
            merged[mergedPointer] = left[leftPointer];
            leftPointer++;
            mergedPointer++;
        }

        while (rightPointer < right.length) {
            merged[mergedPointer] = right[rightPointer];
            rightPointer++;
            mergedPointer++;
        }

        return merged;
    }

    public int[] getSorted() {
        return sorted;
    }

    public void display() {
        System.out.print("List: ");
        for (Integer num : numList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }    
}
