package datasctructures.graph.noweight;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO BFS, DFS, find, path, path all, weighted graph impl

public class Graph<E> {

    private HashMap<E, GraphNode<E>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public Graph(E[][] matrix) {
        this.graph = fromMatrix(matrix);
    }

    /*
         Matrix type:
         -------------
         [ from , to ]
         [ from , to ]
         [ from , to ]
         [ from , to ]
         [ from , to ]
         -------------
    */

    public HashMap<E, GraphNode<E>> fromMatrix(E[][] matrix) {
        this.graph = new HashMap<>();

        for (E[] row : matrix) {
            this.add(row[0], row[1]);
        }

        return this.graph;
    }

    public boolean add(E element) {
        if (this.graph.containsKey(element)) throw new IllegalArgumentException(element + " already exists");
        if (element == null) throw new IllegalArgumentException("Null could not be added");

        GraphNode<E> node = new GraphNode<>(element);
        this.graph.put(element, node);
        return true;
    }

    public boolean add(E from, E to) {
        if (from == null || to == null) throw new IllegalArgumentException("Null could not be added");

        if (!this.graph.containsKey(from) && !this.graph.containsKey(to)) {
            GraphNode<E> node = new GraphNode<>(from);
            GraphNode<E> adjacentNode = new GraphNode<>(to);

            Edge<E> edge = new Edge<>(adjacentNode);
            node.addEdge(edge);
            adjacentNode.addParent(node, edge);

            this.graph.put(from, node);
            this.graph.put(to, adjacentNode);

            return true;
        } else if (this.graph.containsKey(from) && !this.graph.containsKey(to)) {
            GraphNode<E> node = this.graph.get(from);
            GraphNode<E> adjacentNode = new GraphNode<>(to);

            Edge<E> edge = new Edge<>(adjacentNode);
            node.addEdge(edge);
            adjacentNode.addParent(node, edge);

            this.graph.put(to, adjacentNode);

            return true;
        } else if (!this.graph.containsKey(from) && this.graph.containsKey(to)) {
            GraphNode<E> node = new GraphNode<>(from);
            GraphNode<E> adjacentNode = this.graph.get(to);

            Edge<E> edge = new Edge<>(adjacentNode);
            node.addEdge(edge);
            adjacentNode.addParent(node, edge);

            this.graph.put(from, node);
            return true;
        } else if (this.graph.containsKey(from) && this.graph.containsKey(to)) {
            GraphNode<E> node = this.graph.get(from);
            GraphNode<E> adjacentNode = this.graph.get(to);

            for (Edge<E> edge : node.getEdges()) {
                if (edge.getAdjacentNode().getElement().equals(adjacentNode.getElement())) {
                    System.out.println("Edge already exists. " + node.getElement() + " ---> " + adjacentNode.getElement());
                    return false;
                }
            }

            Edge<E> edge = new Edge<>(adjacentNode);
            node.addEdge(edge);
            adjacentNode.addParent(node, edge);
            return true;
        }

        return false;
    }

    public int size() {
        return this.graph.size();
    }

    public boolean isEmpty() {
        return this.graph.isEmpty();
    }

    public boolean contains(E element) {
        return this.graph.containsKey(element);
    }

    public List<E> getParent(E element) {
        if (!this.graph.containsKey(element)) return null;

        List<E> parents = new ArrayList<>();
        GraphNode<E> node = this.graph.get(element);

        for (Map.Entry<GraphNode<E>, Edge<E>> entry : node.getParents().entrySet()) {
            parents.add(entry.getKey().getElement());
        }

        return parents;

    }

    public List<E> getChildren(E element) {
        if (!this.graph.containsKey(element)) return null;

        List<E> children = new ArrayList<>();
        GraphNode<E> node = this.graph.get(element);

        for (Edge<E> edge : node.getEdges()) {
            children.add(edge.getAdjacentNode().getElement());
        }

        return children;
    }

    public E get(E element) {
        return this.graph.containsKey(element) ? this.graph.get(element).getElement() : null;
    }


    public HashMap<E, GraphNode<E>> getGraph() {
        return this.graph;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<E, GraphNode<E>> entry : this.graph.entrySet()) {
            sb.append("Element ").append(entry.getKey().toString()).append(" :{").append(entry.getValue().toString()).append(" }").append("\n");
        }
        return sb.toString();
    }
}
