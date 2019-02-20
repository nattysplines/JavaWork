import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class AirbnbTree {
    /**
     *
     */

    private static final String[][] STRINGS = { { "MEX", "OAX", "PUEB" }, { "USA", "CA", "NV", "MD" },
            { "SA", "BRZ", "ARG", "COL" }, { "NA", "USA", "CAN", "MEX" }, { "Earth", "NA", "SA" } };

    public static void main(String[] args) {

        Node root = rootOfTree();
        Node node1 = findNode(root, "MEX");
        Node node2 = findNode(root, "USA");

        Node ancestor = closestCommonAncestory(node1, node2);

        System.out.println("Closest common ancestor of " + node1.data + " & " + node2.data + " is " + ancestor.data + ".");

        // printTree(root, 0);

    }

    static int depth(Node node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    static Node goUpBy(Node node, int diff) {
        while (diff > 0 && node != null) {
            node = node.parent;
            diff--;
        }
        return node;
    }

    static Node closestCommonAncestory(Node a, Node b) {
        int diff = depth(a) - depth(b);
        Node first = diff > 0 ? b : a;
        Node second = diff > 0 ? a : b;
        second = goUpBy(second, Math.abs(diff));

        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : first;
    }

    static Node findNode(Node root, String str) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            for (Node node : current.children) {
                queue.add(node);
            }
            if (current.data == str) {
                return current;
            }
        }
        return null;
    }

    static void printTree(Node root, int level) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " " + level);
        for(Node node : root.children) {
            printTree(node, level+1);
        }

    }

    static Node rootOfTree() {

        ArrayList<Node> nodes = new ArrayList<Node>();
        for (String[] arr : STRINGS) {
            Node current = new Node();
            for (int i = 0; i < arr.length; i++)  {
                if (i == 0) {
                    current.data = arr[i];
                } else {
                    Node childNode = new Node();
                    for(Node node : nodes) {
                        if (node.data == arr[i]) {
                            childNode = node;
                        }
                    }
                    if (childNode.data == null) {
                        childNode.data = arr[i];
                    }
                    childNode.parent = current;
                    current.children.add(childNode);
                }
            }
            nodes.add(current);
        }
        return nodes.get(nodes.size()-1);
    }

}

class Node {
    String data;
    Node parent;
    ArrayList<Node> children = new ArrayList<Node>();
}