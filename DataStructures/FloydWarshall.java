package DataStructures;

public class FloydWarshall {
    private Graph graph;
    private String[] vertexNames;
    private float[][] distance = null;

    public FloydWarshall(Graph graph) {
        this.graph = graph;
        vertexNames = graph.getVertexNames();
    }
    
    public void start(){
        float[][] matrix = graph.getMatrix();
        int size = matrix.length;

        distance = new float[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (i==j) {
                    distance[i][j] = 0;
                }
                else if (matrix[i][j] != 0) {
                    distance[i][j] = matrix[i][j];
                }
                else {
                    distance[i][j] = Float.POSITIVE_INFINITY;
                }
            }
        }

        for (int k=0; k<size; k++) {
            for (int i=0; i<size; i++) {
                for (int j=0; j<size; j++) {
                    if (distance[i][j] > (distance[i][k] + distance[k][j])) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }

    public float[][] getMatrix() {
        return distance;
    }

    public void display() {
        System.out.println("\n\t\tSHORTEST DISTANCE MATRIX:");
        System.out.print("\t\t\t");
        for(int i=0; i<vertexNames.length; i++) {
            System.out.print(vertexNames[i] + "\t");
        }
        System.out.println();

        for (int i=0; i<distance.length; i++) {
            System.out.print("\t\t" + vertexNames[i] + "\t");
            for (int j=0; j<distance[0].length; j++) {
                System.out.print(distance[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
