package DataStructures;

public class Vertex {
    public String name;
    public float weight;
    public float cost;
    public boolean visited;

    public Vertex(String name) {
        this.name = name;
        weight = 0;
    }

    public Vertex(String name, float weight) {
        this.name = name;
        this.weight = weight;
        visited = false;
    }
}
