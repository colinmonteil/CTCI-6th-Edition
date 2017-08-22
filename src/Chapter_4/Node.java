package Chapter_4;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Colin on 8/20/2017.
 */
public class Node<T> {
    public T value;
    public Map<T,Node<T>> childMap;
    public boolean visited;

    public Node() {
        this.visited = false;
        this.childMap = new LinkedHashMap<>();
    }
    public Node(T value) {
        this();
        this.value = value;
    }

    public void addChild(T value) {
        this.childMap.put(value, new Node<>(value));
    }
    public void addChild(Node<T> node) {
        this.childMap.put(node.value, node);
    }
    public void addChildren(T... values) {
        for (T value : values)
            this.addChild(value);
    }
    public void addChildren(Node<T>... nodes) {
        for (Node<T> node : nodes)
            this.addChild(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node ").append(this.value).append(": ");
        for (T childVal : childMap.keySet())
            sb.append(childVal).append(" ");

        return sb.toString();
    }
}
