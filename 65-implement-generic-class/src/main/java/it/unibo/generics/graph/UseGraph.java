package it.unibo.generics.graph;

import it.unibo.generics.graph.api.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 */
public final class UseGraph implements Graph<String>{

    private UseGraph() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        /*
         * Test your graph implementation(s) by calling testGraph
         */
        testGraph(null);
    }

    Graph<String> myGraph = null;
    Map<String, String> supportMap = new HashMap<>();


    private static void testGraph(final Graph<String> graph) {
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        graph.addEdge("c", "d");
        graph.addEdge("d", "e");
        graph.addEdge("c", "a");
        graph.addEdge("e", "a");
        /*
         * Should be ["a","b","c","d","e"], in any order
         */
        assertIsAnyOf(graph.nodeSet(), Set.of(splitOnWhiteSpace("a b c d e")));
        /*
         * ["d","a"], in any order
         */
        assertIsAnyOf(graph.linkedNodes("c"), Set.of(splitOnWhiteSpace("a d")));
        /*
         * Either the path b,c,a or b,c,d,e,a
         */
        assertIsAnyOf(
            graph.getPath("b", "a"),
            Arrays.asList(splitOnWhiteSpace("b c a")),
            Arrays.asList(splitOnWhiteSpace("b c d e a"))
        );
    }

    private static void assertIsAnyOf(final Object actual, final Object... valid) {
        for (final var target: Objects.requireNonNull(valid)) {
            if (Objects.equals(target, actual)) {
                System.out.println("OK: " + actual + " matches " + target); // NOPMD
                return;
            }
        }
        throw new AssertionError("None of " + Arrays.asList(valid) + " matches " + actual);
    }

    private static String[] splitOnWhiteSpace(final String target) {
        return target.split("\\s+");
    }

    @Override
    public void addNode(String node) {
        if (node == null || myGraph.nodeSet().contains(node)) {
            return;
        } else {
            myGraph.nodeSet().add(node);
        }
    }

    @Override
    public void addEdge(String source, String target) {
        this.supportMap.put(source, target);
    }

    @Override
    public Set<String> nodeSet() {
        return this.myGraph.nodeSet();
    }

    @Override
    public Set<String> linkedNodes(String node) {
        Set<String> supportSet = new HashSet<>();
        for (String elem : supportMap.values()) {
            if (elem == node) {
                supportSet.add(elem);
            }
        }
        return supportSet;
    }

    @Override
    public List<String> getPath(String source, String target) {
        return null;
    }
}
