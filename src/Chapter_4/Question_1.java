package Chapter_4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodesMap.
 */
public class Question_1 {
    public static void main(String[] args) {
        Graph<Integer> dirGraph = new Graph<>();
        dirGraph.addDirEdge(0,1);
        dirGraph.addDirEdge(0,2);
        dirGraph.addDirEdge(0,3);
        dirGraph.addDirEdge(1,4);
        dirGraph.addDirEdge(1,5);
        dirGraph.addDirEdge(2,6);
        dirGraph.addDirEdge(6,0);

        System.out.println(dirGraph);

        int sourceVal = 2;
        int destVal = 4;
        Node<Integer> source = dirGraph.nodesMap.get(sourceVal);
        Node<Integer> dest = dirGraph.nodesMap.get(destVal);
        System.out.println("There is a path from node " + sourceVal + " to node " + destVal + ": "
                + isPath(source, dest));
    }

    private static boolean isPath(Node<Integer> source, Node<Integer> dest) {
        // If we are starting on our goal node, then there is a path
        if (source == dest)
            return true;

        // Perform a breadth-first search of the graph and stop if the goal node is found
        Queue<Node<Integer>> nodesToVisit = new LinkedList<>();
        source.visited = true;
        nodesToVisit.add(source);
        while (!nodesToVisit.isEmpty()) {
            Node<Integer> curr = nodesToVisit.remove();
            for (Node<Integer> neighbor : curr.childMap.values()) {
                if (!neighbor.visited) {
                    if (neighbor == dest)
                        return true;
                    neighbor.visited = true;
                    nodesToVisit.add(neighbor);
                }
            }
        }

        return false;
    }
}
