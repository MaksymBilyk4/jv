package datasctructures.graph.noweight;

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
                {8, 10},
                {7, 6},
                {6, 7},
                {6, 4},
                {7, 2},
                {2, 1},
                {5, 9},
                {7, 5}
        };
        Graph<Integer> graph = new Graph<>(matrix);
        System.out.println(graph);

    }

}
