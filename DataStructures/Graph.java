package DataStructures;

import java.util.ArrayList;

public class Graph {
    private Vertex[] vertexArray = new Vertex[0];
    private float[][] matrix = new float[0][0];

    public void addVertex(String name) {
        int arrLength = vertexArray.length;
        Vertex[] newArr = new Vertex[arrLength+1];
        float[][] newMatrix = new float[arrLength+1][arrLength+1];

        if(exists(name)){
            System.out.println("Vertex already exists!!!");
        }
        else{
            for(int i=0; i<arrLength; i++){
                newArr[i] = vertexArray[i];
                for(int j=0; j<arrLength; j++){
                    newMatrix[i][j] = matrix[i][j];
                }
            }

            Vertex newVert = new Vertex(name);
            newArr[arrLength] = newVert;
            vertexArray = newArr;
            
            for(int i=0; i<=arrLength; i++){
                newMatrix[arrLength][i] = 0;
                newMatrix[i][arrLength] = 0;
            }
            matrix = newMatrix;
        }
    }
    public void addEdge(String nameA, String nameB, float weight) {
        int indexA = findPos(nameA);
        int indexB = findPos(nameB);

        if(indexA == -1){
            System.out.println("1st Vertex does not exist!!!");
        }
        if(indexB == -1){
            System.out.println("2nd Vertex does not exist!!!");
        }
        else{
            matrix[indexA][indexB] = weight;
        }
    }

    public Vertex[] getVertices() {
        return vertexArray;
    }

    public String[] getVertexNames() {
        String[] vertexNames = new String[vertexArray.length];
        for (int i=0; i<vertexArray.length; i++) {
            vertexNames[i] = vertexArray[i].name;
        }
        return vertexNames;
    }

    public float getEdge(String vertexA, String vertexB) {
        int posA = -1;
        int posB = -1;

        if(!exists(vertexA)){
            System.out.println("Vertex " + vertexA + " does not exist!!!");
        }
        if(!exists(vertexB)){
            System.out.println("Vertex " + vertexB + " does not exist!!!");
        }
        else{
            posA = findPos(vertexA);
            posB = findPos(vertexB);
        }
        return matrix[posA][posB];
    }

    public float[][] getMatrix() {
        return matrix;
    }

    public String[] getAdjacentVertices(String vertex) {
        ArrayList<String> adjacentList = new ArrayList<String>();

        if(!exists(vertex)){
            System.out.println("Vertex does not exist!!!");
        }
        else{
            int pos = findPos(vertex);

            for(int i=0; i<vertexArray.length; i++){
                if(matrix[pos][i] != 0){
                    adjacentList.add(vertexArray[i].name);

                    //test
                    // System.out.println(vertexArray[i].name + " is connected");
                }

                //test
                // else {
                //     System.out.println(vertexArray[i].name + " is not connected");
                // }
            }
        }

        String[] adjacentVertices = new String[adjacentList.size()];
        for (int i=0; i<adjacentList.size(); i++) {
            adjacentVertices[i] = adjacentList.get(i);
        }

        return adjacentVertices;
    }


    public void setCost(String vertex, float cost) {
        int pos = findPos(vertex);
        vertexArray[pos].cost = cost;
    }
    public void setCostAll(float cost) {
        for (int i=0; i<vertexArray.length; i++) {
            vertexArray[i].cost = cost;
        }
    }
    public float getCost(String vertex) {
        int pos = findPos(vertex);
        return vertexArray[pos].cost;
    }

    //---------------------------------------------

    public boolean exists(String name) {
        boolean status = false;
        for(int i=0; i<vertexArray.length; i++){
            if(vertexArray[i].name.equals(name)){
                status = true;
            }
        }
        return status;
    }
    public int findPos(String name){
        int position = -1;
        for(int i=0; i<vertexArray.length; i++){
            if(vertexArray[i].name.equals(name)){
                position = i;
            }
        }
        return position;
    }

    public void display() {
        System.out.println("\n\t\tGRAPH MATRIX:");
        System.out.print("\t\t\t");
        for(int i=0; i<vertexArray.length; i++) {
            System.out.print(vertexArray[i].name + "\t");
        }
        System.out.println();

        for (int i=0; i<matrix.length; i++) {
            System.out.print("\t\t" + vertexArray[i].name + "\t");
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
