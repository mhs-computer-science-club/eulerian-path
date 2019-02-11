import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GraphTest
{
    private static Graph createSampleGraph() {
        final Map<String, Set<String>> graph = new HashMap<>();

        graph.put("L", createConnections("M", "N"));
        graph.put("M", createConnections("L", "N", "P"));
        graph.put("N", createConnections("L", "M"));
        graph.put("P", createConnections("M"));

        return new Graph(graph);
    }

    private static List<String> createPath(final String... vertices)
    {
        return Arrays.asList(vertices);
    }

    private static Set<String> createConnections(final String... targets)
    {
        return new HashSet<>(Arrays.asList(targets));
    }

    private static Stream<Arguments> containsEulerianPathProvider()
    {
        final Graph g = createSampleGraph();
        return Stream.of(
                Arguments.of(g, "L", false),
                Arguments.of(g, "M", true),
                Arguments.of(g, "N", false),
                Arguments.of(g, "P", true));
    }

    @ParameterizedTest
    @MethodSource("containsEulerianPathProvider")
    void testContainsEulerianPath(
            final Graph graph,
            final String vStart,
            final boolean expected)
    {
        assertEquals(expected, graph.containsEulerianPath(vStart));
    }

    private static Stream<Arguments> countEulerianPathsProvider()
    {
        final Graph g = createSampleGraph();
        return Stream.of(
                Arguments.of(g, "L", 0),
                Arguments.of(g, "M", 2),
                Arguments.of(g, "N", 0),
                Arguments.of(g, "P", 2));
    }

    @ParameterizedTest
    @MethodSource("countEulerianPathsProvider")
    void testCountEulerianPaths(
            final Graph graph,
            final String vStart,
            final int expected)
    {
        assertEquals(expected, graph.countEulerianPaths(vStart));
    }

    private static Stream<Arguments> getEulerianPathsProvider()
    {
        final Graph g = createSampleGraph();
        return Stream.of(
                Arguments.of(g, "L", Collections.emptySet()),
                Arguments.of(g, "M", createResultSet(createPath("M", "L", "N", "M", "P"),
                                                     createPath("M", "N", "L", "M" ,"P"))),
                Arguments.of(g, "N", Collections.emptySet()),
                Arguments.of(g, "P", createResultSet(createPath("P", "M", "N", "L", "M"),
                                                     createPath("P", "M", "L", "N", "M"))));
    }

    private static Set<List<String>> createResultSet(final List<String>... paths) {
        final Set<List<String>> results = new HashSet<>(paths.length);

        results.addAll(Arrays.asList(paths));

        return results;
    }

    @ParameterizedTest
    @MethodSource("getEulerianPathsProvider")
    void testGetEulerianPaths(
            final Graph graph,
            final String vStart,
            final Set<List<String>> expected)
    {
        assertEquals(expected, graph.getEulerianPaths(vStart));
    }
}
