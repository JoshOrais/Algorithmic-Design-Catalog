package Menu;

import java.util.Scanner;
import DataStructures.*;

public class MergeSortMenu {
    public MergeSortMenu() {
        Scanner scan = new Scanner(System.in);
        MergeSort sort = new MergeSort();
        int choice = 0;

        while (true) {
            System.out.println("\nMERGE SORT ALGORITHM");
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
                System.out.print("Merge Sorted List: ");
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
}
