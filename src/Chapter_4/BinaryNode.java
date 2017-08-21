package Chapter_4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Colin on 8/20/2017.
 */
public class BinaryNode extends Node {
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int value) {
        super(value);
        this.left = null;
        this.right = null;
    }

    // Produces a binary tree given the in-order list of values
    public static BinaryNode makeBinaryTree(int[] nodeValues) {
        Map<Integer, BinaryNode> nodeMap = new HashMap<>();
        for (int val : nodeValues)
            nodeMap.put(val, new BinaryNode(val));

        for (int i = 0; i < nodeValues.length; i++) {
            BinaryNode curr = nodeMap.get(nodeValues[i]);

            int k;
            if ((k = (i * 2) + 1) < nodeValues.length) {
                BinaryNode leftNode = nodeMap.get(nodeValues[k]);
                curr.left = leftNode;
                curr.addChild(leftNode);
            }
            if ((k = (i * 2) + 2) < nodeValues.length) {
                BinaryNode rightNode = nodeMap.get(nodeValues[k]);
                curr.right = rightNode;
                curr.addChild(rightNode);
            }
        }

        return nodeMap.get(nodeValues[0]);
    }

    // Print out the value of the tree's nodesMap
    public static void inOrder(BinaryNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }
    public static void preOrder(BinaryNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void postOrder(BinaryNode root) {
        if (root != null) {
            postOrder(root.right);
            postOrder(root.left);
            System.out.print(root.value + " ");
        }
    }

}
