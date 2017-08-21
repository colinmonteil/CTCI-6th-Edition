package Chapter_4;

import java.util.*;

/**
 * Created by Colin on 8/20/2017.
 */
public class Graph {
    public Map<Integer,Node> nodesMap;

    public Graph() {
        this.nodesMap = new LinkedHashMap<>();
    }
    public Graph(Node... nodes) {
        this();
        for (Node node : nodes)
            this.addNode(node);
    }

    public void addNode(Node node) {
        if (!nodesMap.containsKey(node.value))
            nodesMap.put(node.value, node);
    }
    public Node addNode(int value) {
        if (!nodesMap.containsKey(value))
            nodesMap.put(value, new Node(value));

        return nodesMap.get(value);
    }
    public void addDirEdge(Node source, Node dest) {
        addNode(source);
        addNode(dest);
        source.addChild(dest);
    }
    public void addDirEdge(int sourceVal, int destVal) {
        Node source = addNode(sourceVal);
        Node dest = addNode(destVal);
        source.addChild(dest);
    }

    public static void depthFirstSearch(Node root) {
        if (root == null)
            return;

        root.visited = true;
        System.out.print(root.value + " ");

        for (Node node : root.childMap.values()) {
            if (!node.visited)
                depthFirstSearch(node);
        }
    }
    public static void breadthFirstSearch(Node root) {
        Queue<Node> toVisit = new LinkedList<>();
        root.visited = true;
        toVisit.add(root);

        while (!toVisit.isEmpty()) {
            Node curr = toVisit.remove();
            System.out.print(curr.value + " ");

            for (Node neighbor : curr.childMap.values()) {
                if (!neighbor.visited) {
                    neighbor.visited = true;
                    toVisit.add(neighbor);
                }
            }

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph:\n");
        for (Node node : nodesMap.values())
            sb.append("\t" + node + "\n");

        return sb.toString();
    }
}
