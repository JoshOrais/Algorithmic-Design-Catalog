package Testers;

import java.util.Scanner;
import DataStructures.*;

public class InsertionSortTester {
    public InsertionSortTester() {
        Scanner scan = new Scanner(System.in);
        InsertionSort sort = new InsertionSort();
        int choice = 0;

        while (true) {
            System.out.println("\nInsertion Sort Algorithm");
            System.out.println("\t1. Add number");
            System.out.println("\t2. Sort");
            System.out.println("\t0. Go back to Main Menu");

            System.out.print("Enter Choice: ");
            choice = scan.nextInt();

            if (choice == 1) {
                System.out.print("Enter input number: ");
                sort.add(scan.nextInt());
                sort.display();
            }
            if (choice == 2) {
                sort.sort();
                int[] sorted = sort.getSorted();
                System.out.println();
                sort.display();
                System.out.print("Insertion Sorted List: ");
                for (int i=0; i<sorted.length; i++) {
                    System.out.print(sorted[i] + " ");
                }
                System.out.println();
            }
            if (choice == 0) {
                break;
            }
        }   
    }

    public static void main (String [] args) {
        new InsertionSortTester();
    }
}
