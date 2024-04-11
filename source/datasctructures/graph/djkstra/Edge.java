package datasctructures.graph.djkstra;

public class Edge<E> {

    private int weight;

    private Node<E> adjacentNode;

    public Edge(Node<E> adjacentNode, int weight) {
        this.adjacentNode = adjacentNode;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node<E> getAdjacentNode() {
        return adjacentNode;
    }

    public void setAdjacentNode(Node<E> adjacentNode) {
        this.adjacentNode = adjacentNode;
    }

    @Override
    public String toString() {
        return "Edge: " + this.weight + " " + this.adjacentNode;
    }

}
