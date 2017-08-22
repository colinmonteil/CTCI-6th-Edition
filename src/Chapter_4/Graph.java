package Chapter_4;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Colin on 8/20/2017.
 */
public class Graph<T> {
    public Map<T,Node<T>> nodesMap;

    public Graph() {
        this.nodesMap = new LinkedHashMap<>();
    }
    public Graph(Node<T>... nodes) {
        this();
        for (Node<T> node : nodes)
            this.addNode(node);
    }

    public void addNode(Node<T> node) {
        if (!nodesMap.containsKey(node.value))
            nodesMap.put(node.value, node);
    }
    public Node<T> addNode(T value) {
        if (!nodesMap.containsKey(value))
            nodesMap.put(value, new Node<>(value));

        return nodesMap.get(value);
    }
    public void addDirEdge(Node<T> source, Node<T> dest) {
        addNode(source);
        addNode(dest);
        source.addChild(dest);
    }
    public void addDirEdge(T sourceVal, T destVal) {
        Node<T> source = addNode(sourceVal);
        Node<T> dest = addNode(destVal);
        source.addChild(dest);
    }

    public static void depthFirstSearch(Node root) {
        if (root == null)
            return;

        root.visited = true;
        System.out.print(root.value + " ");

        for (Object node : root.childMap.values()) {
            Node realNode = (Node)node;
            if (!realNode.visited)
                depthFirstSearch(realNode);
        }
    }
    public static void breadthFirstSearch(Node root) {
        Queue<Node> toVisit = new LinkedList<>();
        root.visited = true;
        toVisit.add(root);

        while (!toVisit.isEmpty()) {
            Node curr = toVisit.remove();
            System.out.print(curr.value + " ");

            for (Object neighbor : curr.childMap.values()) {
                Node realNeighbor = (Node)neighbor;
                if (!realNeighbor.visited) {
                    realNeighbor.visited = true;
                    toVisit.add(realNeighbor);
                }
            }

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph:\n");
        for (Node node : nodesMap.values())
            sb.append("\t").append(node).append("\n");

        return sb.toString();
    }
}
