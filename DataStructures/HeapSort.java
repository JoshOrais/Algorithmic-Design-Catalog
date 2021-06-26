package DataStructures;

import java.util.ArrayList;

public class HeapSort {
    private ArrayList<Integer> numList;
    private int[] sorted = null;

    public HeapSort() {
        numList = new ArrayList<Integer>();
    }

    public void add(int newNum) {
        numList.add(newNum);
    }

    public void sort() {
        int[] numArray = new int[numList.size()+1];
        for (int i=0; i<numList.size(); i++) {
            numArray[i+1] = numList.get(i);
        }
        
        int[] heap = numArray;

        for (int i=(numList.size()/2); i>0; i--) {
            heap = heapify(heap, i);
        }

        sorted = new int[numList.size()];

        for(int i=(heap.length-1); i>0; i--) {
            sorted[i-1] = heap[1];
            int temp = heap[i];
            heap[i] = heap[1];
            heap[1] = temp;

            int[] newHeap = new int[heap.length-1];
            for(int j=0; j<newHeap.length; j++) {
                newHeap[j] = heap[j];
            }

            heap = heapify(newHeap, 1);
        }
    }

    public int[] heapify(int[] heap, int i) {
        int left = 2*i;
        int right = (2*i) + 1;

        if (right < heap.length) {
            if (heap[left] > heap[right] && heap[left] > heap[i]) {
                int temp = heap[i];
                heap[i] = heap[left];
                heap[left] = temp;
                heapify(heap, left);
            }
            else if (heap[right] >= heap[left] && heap[right] > heap[i]) {
                int temp = heap[i];
                heap[i] = heap[right];
                heap[right] = temp;
                heapify(heap, right);
            }
        }
        else if (left < heap.length && right >= heap.length && heap[left] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[left];
            heap[left] = temp;
            heapify(heap, left);
        }
        
        return heap;
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
