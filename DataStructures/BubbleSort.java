package DataStructures;

import java.util.ArrayList;

public class BubbleSort {
    private ArrayList<Integer> numList;
    private int[] sorted = null;

    public BubbleSort() {
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

        int size = numArray.length;
        for (int i=0; i<size-1; i++) {
            for (int j=0; j<size-i-1; j++) {
                if(numArray[j] > numArray[j+1]) {
                    int temp = numArray[j];
                    numArray[j] = numArray[j+1];
                    numArray[j+1] = temp;
                }
            }
        }

        sorted = numArray;
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
