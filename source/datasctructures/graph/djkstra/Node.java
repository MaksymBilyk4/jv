package datasctructures.graph.djkstra;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class Node<E> {

    private E element;

    private LinkedHashSet<Edge<E>> edges;

    private LinkedHashMap<Node<E>, Edge<E>> parents;

    public Node(E element) {
        this.element = element;
        this.edges = new LinkedHashSet<>();
        this.parents = new LinkedHashMap<>();
    }

    public E getElement() {
        return element;
    }

    public LinkedHashSet<Edge<E>> getEdges() {
        return edges;
    }

    public LinkedHashMap<Node<E>, Edge<E>> getParents() {
        return parents;
    }

    public void addParent(Node<E> parent, Edge<E> edge) {
        this.parents.put(parent, edge);
    }

    public void addEdge(Edge<E> edge) {
        this.edges.add(edge);
    }

    @Override
    public String toString() {
        return this.element.toString();
    }

}
