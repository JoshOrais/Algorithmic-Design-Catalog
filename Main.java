import java.util.Scanner;

import Testers.*;

public class Main {
    public Main() {
        Scanner scan = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("ALGORITHM DESIGN CATALOG");
            System.out.println("\t1. Brute Force");
            System.out.println("\t0. Exit");
            
            System.out.print("\nEnter choice: ");
            choice = scan.nextInt();

            if (choice == 1) {
                new BubbleSortTester();
            }
        }
    }
    public static void main (String [] args) {
        new Main();
    }
}