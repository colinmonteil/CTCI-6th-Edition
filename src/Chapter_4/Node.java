package Chapter_4;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Colin on 8/20/2017.
 */
public class Node {
    public int value;
    public Map<Integer,Node> childMap;
    public boolean visited;

    public Node() {
        this.visited = false;
        this.childMap = new LinkedHashMap<>();
    }
    public Node(int value) {
        this();
        this.value = value;
    }

    public void addChild(int value) {
        this.childMap.put(value, new Node(value));
    }
    public void addChild(Node node) {
        this.childMap.put(node.value, node);
    }
    public void addChildren(int... values) {
        for (int value : values)
            this.addChild(value);
    }
    public void addChildren(Node... nodes) {
        for (Node node : nodes)
            this.addChild(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node " + this.value + ": ");
        for (int childVal : childMap.keySet())
            sb.append(childVal + " ");

        return sb.toString();
    }
}
