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

    public boolean containsEulerianPath(final String vStart)
    {
        // TODO - complete.
        return false;
    }

    public int countEulerianPaths(final String vStart) {
        // TODO - complete.
        return 0;
    }

    public Set<List<String>> getEulerianPaths(final String vStart) {
        // TODO - complete.
        return Collections.emptySet();
    }

    private int degree(final String vertex) {
        // TODO - complete.
        return 0;
    }

    private boolean isEven(final int number) {
        // TODO - complete.
        return false;
    }

    private boolean hasVertex(final String vertex) {
        // TODO - complete.
        return false;
    }

    private boolean isEmpty() {
        // TODO - complete.
        return false;
    }

    private List<String> prepend(final String vertex, final List<String> path)
    {
        // TODO - complete.
        return Collections.emptyList();
    }

    private void removeEdge(final String v1, final String v2) {
        // TODO - complete.
    }

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
