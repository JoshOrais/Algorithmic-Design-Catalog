package DataStructures;

public class Dijkstra {
    Graph graph;
    String start;
    PriorityQueue queue;

    public Dijkstra(Graph g) {
        graph = g;
        queue = new PriorityQueue();

        graph.setCostAll(Float.POSITIVE_INFINITY);
    }

    public void setSource(String vertex) {
        start = vertex;
        graph.setCost(start, 0);
        queue.enqueue(start, 0);
    }

    public void start() {
        while (!queue.isEmpty()) {
            String vertex = queue.dequeue();

            //test
            // System.out.println("\n-----dequeued: " + vertex);

            String[] neighbors = graph.getAdjacentVertices(vertex);

            // //test
            // System.out.print("-----neighbors: ");
            // for (int i=0; i<neighbors.length; i++) { System.out.print(neighbors[i] + " "); }
            // System.out.println();

            for(int i=0; i<neighbors.length; i++) {
                float newCost = graph.getCost(vertex) + graph.getEdge(vertex, neighbors[i]);
                if (newCost < graph.getCost(neighbors[i])) {
                    graph.setCost(neighbors[i], newCost);
                    queue.enqueue(neighbors[i], newCost);
                }
            }
        }
    }

    public void display() {
        Vertex[] vertices = graph.getVertices();
        System.out.println("All vertex shortest path from vertex " + start + " :");
        for(int i=0; i<vertices.length; i++) {
            System.out.println("\t" + start + " to " + vertices[i].name + " : " + vertices[i].cost);
        }
    }
}
