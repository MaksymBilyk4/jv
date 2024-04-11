package datasctructures.graph.djkstra;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class WeightedGraph<E> {

    private HashMap<E, Node<E>> graph;

    public WeightedGraph() {
        this.graph = new HashMap<>();
    }

    public void add(E from, E to, int weight) {
        if (from == null || to == null) return;

        if (!this.graph.containsKey(from) && !this.graph.containsKey(to)) {
            Node<E> parentNode = new Node<>(from);
            Node<E> adjacentNode = new Node<>(to);

            addRelation(parentNode, adjacentNode, weight);

            this.graph.put(from, parentNode);
            this.graph.put(to, adjacentNode);
            return;
        } else if (this.graph.containsKey(from) && !this.graph.containsKey(to)) {
            Node<E> parentNode = this.graph.get(from);
            Node<E> adjacentNode = new Node<>(to);
            addRelation(parentNode, adjacentNode, weight);

            this.graph.put(to, adjacentNode);
            return;
        } else if (!this.graph.containsKey(from) && this.graph.containsKey(to)) {
            Node<E> parentNode = new Node<>(from);
            Node<E> adjacentNode = this.graph.get(to);

            addRelation(parentNode, adjacentNode, weight);

            this.graph.put(from, parentNode);
            return;
        } else if (this.graph.containsKey(from) && this.graph.containsKey(to)) {
            Node<E> parentNode = this.graph.get(from);
            Node<E> adjacetNode = this.graph.get(to);

            for (Edge<E> edge : parentNode.getEdges())
                if (edge.getAdjacentNode().getElement().equals(adjacetNode.getElement())) {
                    System.out.println("Edge from " + from + " to " + to + " already exists.");
                    return;
                }

            addRelation(parentNode, adjacetNode, weight);
        }

    }

    public Node<E> getNode(E element) {
        return this.graph.get(element);
    }

    private void addRelation(Node<E> parentNode, Node<E> adjacentNode, int edgeWeight) {
        Edge<E> edge = new Edge<>(adjacentNode, edgeWeight);
        parentNode.addEdge(edge);
        adjacentNode.addParent(parentNode, edge);
    }

    public HashMap<E, Node<E>> getGraph() {
        return this.graph;
    }

    // DIJKSTRA =======================================================================================================

    public LinkedList<E> getShortestPath(E start, E end) {
        Node<E> startNode = this.graph.get(start); // start node
        Node<E> endNode = this.graph.get(end); // end node

        HashSet<Node<E>> unprocessedNodes = new HashSet<>(); // not processed nodes
        HashMap<Node<E>, Integer> timeToNodes = new HashMap<>(); // time to nodes
        initHashTables(startNode, unprocessedNodes, timeToNodes); // unprocessed nodes - all, time to nodes (all - Integer.MAX_VALUE)
        calculateTimeToEachNode(unprocessedNodes, timeToNodes); // calculating time for each node
        if (timeToNodes.get(endNode) == Integer.MAX_VALUE) return null; // we didn't reach this node
        return getShortestPath(startNode, endNode, timeToNodes); // path
    }

    private LinkedList<E> getShortestPath(Node<E> start, Node<E> end, HashMap<Node<E>, Integer> timeToNodes) {
        LinkedList<E> path = new LinkedList<>(); // initializing path
        Node<E> node = end; // current node is end node
        while (node != start) {
            int minTimeToNode = timeToNodes.get(node); // get time to this node
            path.addFirst(node.getElement()); // write to path node that we entered
            for (Map.Entry<Node<E>, Edge<E>> parentEntry : node.getParents().entrySet()) {
                Node<E> parent = parentEntry.getKey(); // parent of current node
                Edge<E> parentEdge = parentEntry.getValue(); // edge to CURRENT node, parent -> current node
                if (!timeToNodes.containsKey(parent)) continue; // if we already processed this node
                boolean prevNodeFound = (parentEdge.getWeight() + timeToNodes.get(parent)) == minTimeToNode; // if weight from parent edge + time to parent == currentNode min time
                if (prevNodeFound) {
                    timeToNodes.remove(node);
                    node = parent; // we found previous node in the shortest path
                    break;
                }
            }
        }
        path.addFirst(node.getElement());
        return path;
    }


    private void calculateTimeToEachNode(HashSet<Node<E>> unprocessedNodes, HashMap<Node<E>, Integer> timeToNodes) {
        while (!unprocessedNodes.isEmpty()) {
            Node<E> node = getNodeWithMinTimeToIt(unprocessedNodes, timeToNodes);
            if (timeToNodes.get(node) == Integer.MAX_VALUE) return;
            for (Edge<E> edge : node.getEdges()) { // get edges that point to next nodes
                Node<E> adjacentNode = edge.getAdjacentNode();
                if (unprocessedNodes.contains(adjacentNode)) { // if we still didn't go through this node
                    int timeToCheck = timeToNodes.get(node) + edge.getWeight(); // time from parent + edge weight
                    if (timeToCheck < timeToNodes.get(adjacentNode)) { // if time to adjacent node less than in hash map - rewrite it
                        timeToNodes.put(adjacentNode, timeToCheck);
                    }
                }
            }
            unprocessedNodes.remove(node); // remove processed node
        }
    }


    private Node<E> getNodeWithMinTimeToIt(HashSet<Node<E>> unprocessedNodes, HashMap<Node<E>, Integer> timeToNodes) {
        Node<E> nodeWithMinTimeToIt = null;
        int minTime = Integer.MAX_VALUE;
        for (Node<E> node : unprocessedNodes) { // for all unprocessed nodes
            int time = timeToNodes.get(node); // get its current time that wrote in hash map
            if (time < minTime) { // if it less then initial/prev min time rewrite
                minTime = time;
                nodeWithMinTimeToIt = node;
            }
        }
        return nodeWithMinTimeToIt; // return node with min time to it
    }

    // setting time for all nodes - Integer.MAX_VALUE, fill unprocessed nodes
    private void initHashTables(Node<E> start, HashSet<Node<E>> unprocessedNodes, HashMap<Node<E>, Integer> timeToNode) {
        for (Node<E> node : this.graph.values()) {
            timeToNode.put(node, Integer.MAX_VALUE);
            unprocessedNodes.add(node);
        }
        timeToNode.put(start, 0); // setting time for start node - 0
    }

}
