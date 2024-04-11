package datasctructures.graph.noweight;


import java.util.*;

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

    public LinkedList<E> extractPath(PathNode<E> pathNode) {
        LinkedList<E> path = new LinkedList<>();
        while (pathNode != null) {
            path.addFirst(pathNode.getNode().getElement());
            pathNode = pathNode.getParent();
        }

        return path;
    }

    public PathNode<E> findShortestPath(E start, E end) {
        HashSet<E> passed = new HashSet<>();
        LinkedList<PathNode<E>> queue = new LinkedList<>();
        queue.add(new PathNode<>(this.graph.get(start), null));
        passed.add(start);

        while (!queue.isEmpty()) {
            PathNode<E> pathNode = queue.removeFirst();
            if (pathNode.getNode().getElement().equals(end)) return pathNode;
            for (Edge<E> edge : pathNode.getNode().getEdges()) {
                if (passed.contains(edge.getAdjacentNode().getElement())) continue;
                if (edge.getAdjacentNode().getElement().equals(end))
                    return new PathNode<>(edge.getAdjacentNode(), pathNode);
                queue.addLast(new PathNode<>(edge.getAdjacentNode(), pathNode));
                passed.add(pathNode.getNode().getElement());
            }
        }
        return null;
    }

    public void BFSWrap() {
        HashSet<E> passed = new HashSet<>();

        for (Map.Entry<E, GraphNode<E>> entry : this.graph.entrySet()) {
            if (!passed.contains(entry.getKey()))
                BFS(entry.getValue(), passed);
        }

    }

    public void BFS(GraphNode<E> node, HashSet<E> passed) {
        Deque<GraphNode<E>> deque = new ArrayDeque<>();

        deque.add(node);
        while (!deque.isEmpty()) {
            node = deque.removeFirst();
            System.out.println(node.getElement());
            passed.add(node.getElement());

            for (Edge<E> edge : node.getEdges()) {
                if (!passed.contains(edge.getAdjacentNode().getElement())) {
                    deque.addLast(edge.getAdjacentNode());
                }
            }
        }

    }

    public E get(E element) {
        return this.graph.containsKey(element) ? this.graph.get(element).getElement() : null;
    }

    public void DFSWrap() {
        HashSet<E> passed = new HashSet<>();

        for (Map.Entry<E, GraphNode<E>> entry : this.graph.entrySet()) {
            if (!passed.contains(entry.getValue().getElement())) DFS(entry.getValue().getElement(), passed);
        }

    }


    public void DFS(E element, HashSet<E> passed) {
        GraphNode<E> node = this.graph.get(element);
        Stack<GraphNode<E>> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.peek();
            if (!passed.contains(node.getElement())) {
                System.out.print(node.getElement() + " ");
                passed.add(node.getElement());
            }
            boolean hasChildren = false;
            for (Edge<E> edge : node.getEdges()) {
                if (!passed.contains(edge.getAdjacentNode().getElement())) {
                    stack.push(edge.getAdjacentNode());
                    hasChildren = true;
                    break;
                }
            }

            if (!hasChildren) stack.pop();
        }

    }


    public void DFSRecursiveWrap() {
        HashSet<E> passed = new HashSet<>();

        for (Map.Entry<E, GraphNode<E>> entry : this.graph.entrySet()) {
            if (!passed.contains(entry.getValue().getElement())) DFSRecursive(entry.getValue().getElement(), passed);
        }

    }

    public void DFSRecursive(E element, HashSet<E> passed) {
        GraphNode<E> node = this.graph.get(element);

        System.out.print(node.getElement() + " ");
        passed.add(node.getElement());

        for (Edge<E> edge : node.getEdges()) {
            if (!passed.contains(edge.getAdjacentNode().getElement())) {
                DFSRecursive(edge.getAdjacentNode().getElement(), passed);
            }
        }

    }

    public LinkedList<E> findPathWrap(E start, E end) {
        HashSet<E> passed = new HashSet<>();
        LinkedList<E> path = new LinkedList<>();
        return this.findPath(start, end, passed, path).getKey();
    }

    public Map.Entry<LinkedList<E>, Boolean> findPath(E start, E end, HashSet<E> passed, LinkedList<E> path) {
        if (start.equals(end)) {
            path.addFirst(start);
            return new EntryPath<E>(path, true);
        }

        GraphNode<E> startNode = this.graph.get(start);
        GraphNode<E> endNode = this.graph.get(end);

        passed.add(start);

        for (Edge<E> edge : startNode.getEdges()) {
            if (!passed.contains(edge.getAdjacentNode().getElement())) {
                if (findPath(edge.getAdjacentNode().getElement(), end, passed, path).getValue()) {
                    path.addFirst(start);
                    return new EntryPath<>(path, true);
                }
            }
        }

        return new EntryPath<>(path, false);
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
