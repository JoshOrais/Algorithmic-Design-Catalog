package DataStructures;

import java.util.ArrayList;

public class InsertionSort {
    private ArrayList<Integer> numList;
    private int[] sorted = null;

    public InsertionSort() {
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
        for (int i=1; i<size; i++) {
            int j=i;
            while(j>0 && (numArray[j-1]>numArray[j])) {
                int temp = numArray[j-1];
                numArray[j-1] = numArray[j];
                numArray[j] = temp;
                j--;
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
