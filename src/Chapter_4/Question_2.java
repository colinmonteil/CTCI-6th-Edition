package Chapter_4;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algo-
 * rithm to create a binary search tree with minimal height.
 */
public class Question_2 {
    public static void main(String[] args) {
        int[] sorted = {1, 3, 4, 5, 11, 15, 27, 33};
        BinaryNode root = createMinimalBST(sorted);
        System.out.print("In-order traversal of generated BST: ");
        BinaryNode.inOrder(root);
    }

    private static BinaryNode createMinimalBST(int[] sorted) {
        return createMinimalBSTHelper(sorted, 0, sorted.length - 1);
    }

    private static BinaryNode createMinimalBSTHelper(int[] array, int startIdx, int endIdx) {
        if (startIdx > endIdx)
            return null;

        // Create root node of this subtree
        int midIdx = (startIdx + endIdx) / 2;
        BinaryNode root = new BinaryNode(array[midIdx]);

        // Create child trees of the root
        root.left = createMinimalBSTHelper(array, startIdx, midIdx - 1);
        root.right = createMinimalBSTHelper(array, midIdx + 1, endIdx);

        // Return the root
        return root;
    }
}
