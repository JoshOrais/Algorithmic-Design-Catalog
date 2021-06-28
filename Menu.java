import java.util.Scanner;

import Menu.*;

public class Menu {
    public Menu() {
        Scanner scan = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("----------------------------------------");
            System.out.println("\nALGORITHM DESIGN CATALOG");
            System.out.println("\t1. Brute Force");
            System.out.println("\t2. Decrease and Conquer");
            System.out.println("\t3. Divide and Conquer");
            System.out.println("\t4. Transform and Conquer");
            System.out.println("\t5. Dynamic Programming");
            System.out.println("\t6. Greedy Technique");
            System.out.println("\t0. Exit");
            
            System.out.print("\nEnter choice: ");
            choice = scan.nextInt();

            if (choice == 1) {
                new BubbleSortMenu();
            }
            if (choice == 2) {
                new InsertionSortMenu();
            }
            if (choice == 3) {
                new MergeSortMenu();
            }
            if (choice == 4) {
                new HeapSortMenu();
            }
            if (choice == 5) {
                new FloydWarshallMenu();
            }
            if (choice == 6) {
                new DijkstraMenu();
            }

            if (choice == 0) {
                break;
            }
        }
    }
}