package datasctructures.graph.noweight;


// Non weighted edge
public class Edge<E> {

    private GraphNode<E> adjacentNode;

    public Edge(GraphNode<E> adjacentNode) {
        this.adjacentNode = adjacentNode;
    }


    public GraphNode<E> getAdjacentNode() {
        return this.adjacentNode;
    }

    public void setAdjacentNode(GraphNode<E> adjacentNode) {
        this.adjacentNode = adjacentNode;
    }



    @Override
    public String toString() {
        return "->" + this.adjacentNode.getElement();
    }
}
