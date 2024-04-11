package datasctructures.graph.noweight;

public class PathNode<E> {

    private GraphNode<E> node;

    private PathNode<E> parent;

    public PathNode(GraphNode<E> node, PathNode<E> parent) {
        this.node = node;
        this.parent = parent;
    }

    public GraphNode<E> getNode() {
        return node;
    }

    public void setNode(GraphNode<E> node) {
        this.node = node;
    }

    public PathNode<E> getParent() {
        return parent;
    }

    public void setParent(PathNode<E> parent) {
        this.parent = parent;
    }
}
