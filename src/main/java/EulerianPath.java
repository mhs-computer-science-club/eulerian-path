import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EulerianPath
{
    public static void main(final String[] args) {
        final EulerianPath eulerianPath = new EulerianPath();
        eulerianPath.readInputData(args[0]);
    }

    private void readInputData(final String inputDataFileName)
    {
        try (final Scanner in = new Scanner(new File(inputDataFileName)))
        {
            final int numberOfGraphs = in.nextInt();
            for (int index = 0; index < numberOfGraphs; ++index) {
                final int numberOfVertices = in.nextInt();
                final String vStart = in.next();

                final Graph graph = parseGraph(in, numberOfVertices);

                graph.printGraph();
                graph.printForGraphViz();

                if (graph.containsEulerianPath(vStart)) {
                    System.out.println("YES " + graph.countEulerianPaths(vStart));
                }
                else {
                    System.out.println("NO");
                }
            }
        }
        catch (final FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private Graph parseGraph(final Scanner in, final int numberOfVertices) {
        final Map<String, Set<String>> graph = new HashMap<>(numberOfVertices);

        for (int index = 0; index < numberOfVertices; ++index) {
            graph.put(in.next(), parseConnections(in.nextLine()));
        }

        return new Graph(graph);
    }

    private Set<String> parseConnections(final String line) {
        final Set<String> connections = new HashSet<>((line.length() + 1) / 2);

        try (final Scanner connectionsLine = new Scanner(line)) {
            while (connectionsLine.hasNext()) {
                connections.add(connectionsLine.next());
            }
        }

        return connections;
    }
}
