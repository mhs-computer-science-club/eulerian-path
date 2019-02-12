import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class Graph
{
    private final Map<String, Set<String>> graph;

    public Graph(final Map<String, Set<String>> graph) {
        this.graph = new HashMap<>(graph.size());
        for (final Map.Entry<String, Set<String>> entry : graph.entrySet()) {
            this.graph.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
    }

    /**
     * Determines whether the graph contains at least one Eulerian path
     * starting at the given vertex.
     *
     * <p>
     * TODO - CHECK POINT 4
     *
     * @param vStart The starting vertex.
     *
     * @return True if an Eulerian path exists; false otherwise.
     */
    public boolean containsEulerianPath(final String vStart)
    {
        // TODO - complete.
        return false;
    }

    /**
     * Determine the number of possible Eulerian paths starting from the given
     * vertex.
     *
     * <p>
     * TODO - CHECK POINT 6
     *
     * @param vStart The starting vertex.
     *
     * @return The number of Eulerian paths possible.
     */
    public int countEulerianPaths(final String vStart) {
        // TODO - complete.
        return 0;
    }

    /**
     * Get all the Eulerian paths that exist starting at the given vertex.
     *
     * <p>
     * TODO - CHECK POINT 5
     *
     * @param vStart The starting vertex.
     *
     * @return The set of Eulerian paths found.
     */
    public Set<List<String>> getEulerianPaths(final String vStart) {
        // TODO - complete.
        return Collections.emptySet();
    }

    /**
     * Returns the degree of the given vertex.
     *
     * <p>
     * TODO - CHECK POINT 4
     *
     * @param vertex The vertex for which to compute the degree.
     *
     * @return The degree of the given vertex.
     */
    private int degree(final String vertex) {
        // TODO - complete.
        return 0;
    }

    /**
     * TODO - CHECK POINT 4
     *
     * @return True if the number provided is even; false otherwise.
     */
    private boolean isEven(final int number) {
        // TODO - complete.
        return false;
    }

    /**
     * TODO - CHECK POINT 5
     *
     * @return True if the graph has the given vertex; false otherwise.
     */
    private boolean hasVertex(final String vertex) {
        // TODO - complete.
        return false;
    }

    /**
     * TODO - CHECK POINT 5
     *
     * @return True if the graph is empty; no remaining vertices.
     */
    private boolean isEmpty() {
        // TODO - complete.
        return false;
    }

    /**
     * Prepend the given vertex to a given list of vertices.
     *
     * <p>
     * TODO - CHECK POINT 5
     *
     * @param vertex The vertex to prepend.
     * @param path The list of vertices to prepend the new vertext to.
     *
     * @return The list after prepending the vertex.
     */
    private List<String> prepend(final String vertex, final List<String> path)
    {
        // TODO - complete.
        return Collections.emptyList();
    }

    /**
     * Remove the edge from v1 to v2 from the graph.
     *
     * <p>
     * TODO - CHECK POINT 5
     */
    private void removeEdge(final String v1, final String v2) {
        // TODO - complete.
    }

    /**
     * Remove the edge starting at v1 and ending at v2.
     *
     * <p>
     * TODO - CHECK POINT 5
     */
    private void removeDirectionalEdgeReference(final String v1, final String v2) {
        // TODO - complete.
    }

    public void printGraph() {
        System.out.println(graph);
    }

    public void printForGraphViz() {
        System.out.println(generateDotGraph());
    }

    private String generateDotGraph() {
        final StringBuilder dotGraph = new StringBuilder("graph {\n");
        for (final Edge edge : getAllEdges()) {
            final List<String> vertices = edge.getVertices();
            dotGraph.append("    ")
                    .append(vertices.get(0))
                    .append(" -- ")
                    .append(vertices.get(1))
                    .append(";\n");
        }
        return dotGraph.append("}").toString();
    }

    private Set<Edge> getAllEdges() {
        final Set<Edge> edges = new HashSet<>(2 * graph.size());
        for (final Map.Entry<String, Set<String>> node : graph.entrySet())
        {
            for (final String connection : node.getValue())
            {
                edges.add(new Edge(node.getKey(), connection));
            }
        }
        return edges;
    }

    private static class Edge
    {
        private final SortedSet<String> vertices = new TreeSet<>();

        private Edge(final String firstVertex, final String secondVertex)
        {
            vertices.add(firstVertex);
            vertices.add(secondVertex);
        }

        public List<String> getVertices() {
            return new ArrayList<>(vertices);
        }

        @Override
        public boolean equals(final Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (!(o instanceof Edge))
            {
                return false;
            }
            final Edge edge = (Edge) o;
            return vertices.equals(edge.vertices);
        }

        @Override
        public int hashCode()
        {
            return vertices.hashCode();
        }
    }
}
