package datasctructures.graph;

import datasctructures.graph.noweight.Graph;
import datasctructures.graph.noweight.PathNode;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {


//        Graph<String> graph = new Graph<>();
//
//        graph.add("A");
//        graph.add("B");
//        graph.add("C");
//
//        graph.add("A", "B");
//        graph.add("X", "B");
//        graph.add("X", "B");
//        System.out.println(graph);
        Integer[][] matrix = {
                {7, 6},
                {6, 7},
                {6, 4},
                {7, 2},
                {2, 1},
                {5, 9},
                {7, 5},
                {8, 10},
        };
        Graph<Integer> graph = new Graph<>(matrix);
//        HashSet<Integer> passed = new HashSet<>();
//        graph.DFSRecursive(7, passed);
        graph.DFSRecursiveWrap(); // use it disjoint graph
        System.out.println();
        graph.DFSWrap(); // use it with disjoint graph


        LinkedList<Integer> path = new LinkedList<>();
        path = graph.findPathWrap(7, 1);
        System.out.println();
        System.out.println(path);

        graph.BFSWrap();

        PathNode<Integer> pathNode = graph.findShortestPath(7, 1);
        LinkedList<Integer> p = graph.extractPath(pathNode);

        System.out.println(p);

    }

}
