package datasctructures.graph.noweight;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class GraphNode<E> {

    private E element;

    private LinkedHashSet<Edge<E>> edges;
    private LinkedHashMap<GraphNode<E>, Edge<E>> parents;

    public GraphNode(E element) {
        this.element = element;
        this.edges = new LinkedHashSet<>();
        this.parents = new LinkedHashMap<>();
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public LinkedHashSet<Edge<E>> getEdges() {
        return this.edges;
    }

    public LinkedHashMap<GraphNode<E>, Edge<E>> getParents() {
        return parents;
    }

    public void addEdge(Edge<E> edge) {
        this.edges.add(edge);
    }

    public void addParent(GraphNode<E> parentNode, Edge<E> edge) {
        this.parents.put(parentNode, edge);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [Parents]: ");
        for (Map.Entry<GraphNode<E>, Edge<E>> entry: this.parents.entrySet()) {
            sb.append(entry.getKey().getElement()).append(" ");
        }

        sb.append(" [Children]: ");
        for (Edge<E> e : this.edges) {
            sb.append(this.element).append(e.toString()).append(" ");
        }
        return sb.toString();
    }
}
