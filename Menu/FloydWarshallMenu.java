package Menu;

import java.util.Scanner;
import DataStructures.*;

public class FloydWarshallMenu {
    public FloydWarshallMenu() {
        Scanner scan = new Scanner(System.in);
        FloydWarshall fw;
        Graph graph = new Graph(); 
        int choice = 0;

        while (true) {
            System.out.println("\nFLOYD-WARSHALL ALGORITHM");
            System.out.println("\t1. Add Vertex");
            System.out.println("\t2. Connect Vertices/ Add Edge");
            System.out.println("\t3. Find Shortest Path for All Pairs");
            System.out.println("\t0. Go back to Main Menu");

            System.out.print("Enter Choice: ");
            choice = scan.nextInt();

            if (choice == 1) {
                System.out.print("Enter Vertex Name: ");
                graph.addVertex(scan.next());
                graph.display();
            }
            if (choice == 2) {
                System.out.print("Enter 1st Vertex Name: ");
                String nameA = scan.next();
                System.out.print("Enter 2nd Vertex Name: ");
                String nameB = scan.next();
                System.out.print("Enter Weight: ");
                float weight = scan.nextFloat();
                graph.addEdge(nameA, nameB, weight);
                graph.display();
            }
            if (choice == 3) {
                fw = new FloydWarshall(graph);
                fw.start();
                fw.display();
            }
            if (choice == 0) {
                break;
            }
        }
    }
}
