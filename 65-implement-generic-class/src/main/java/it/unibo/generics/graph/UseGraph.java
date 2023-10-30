package it.unibo.generics.graph;

import it.unibo.generics.graph.api.Graph;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 */
public final class UseGraph implements Graph{

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
    public void addNode(Object node) {
        if (node == null || myGraph.nodeSet().contains(node)) {
            return;
        } else {
            myGraph.nodeSet().add((String) node);
        }
    }

    @Override
    public void addEdge(Object source, Object target) {
        if (target == null || source == null) {
            return;
        } else {
            
        }
    }

    @Override
    public Set<String> nodeSet() {
        return this.myGraph.nodeSet();
    }

    @Override
    public Set<String> linkedNodes(Object node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'linkedNodes'");
    }

    @Override
    public List<String> getPath(Object source, Object target) {
        return null;
    }
}
