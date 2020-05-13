package DailyCoding400;

public class LockableTree {

    Node root;
    public LockableTree() {
        this.root = null;
    }

    public boolean isLocked(Node node) {
        return node.locked;
    }

    public boolean lock(Node node) {
        if (node.locked || node.childIsLocked > 0) {
            return false;
        }

        // check if ancestors are locked – O(h)
        Node curr = node;
        while (curr != null) {
            if (curr.locked) {
                return false;
            }
            curr = curr.parent;
        }

        // tell ancestors a child is locked – O(h)
        curr = node.parent;
        while (curr != null) {
            curr.childIsLocked++;
            curr = curr.parent;
        }

        node.locked = true;
        return true;
    }

    public boolean unlock(Node node) {
        if (node.locked || node.childIsLocked > 0) {
            return false;
        }

        // check if ancestors are locked – O(h)
        Node curr = node;
        while (curr != null) {
            if (curr.locked) {
                return false;
            }
            curr = curr.parent;
        }

        // tell ancestors a child is locked – O(h)
        curr = node.parent;
        while (curr != null) {
            curr.childIsLocked--;
            curr = curr.parent;
        }

        node.locked = false;
        return true;
    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        }
        
        Node node = root;
        while (true) {
            if (value < node.value) {
                if (node.left == null) {
                    node.left = new Node(value);
                    node.left.parent = node;
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new Node(value);
                    node.right.parent = node;
                    break;
                }
                node = node.right;
            }
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;
        Node parent;
        boolean locked = false; // some subtrees are locked if true
        int childIsLocked = 0;
        public Node(int value) {
            this.value = value;
        }
    }
}