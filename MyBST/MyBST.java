public class MyBST {

    private TreeNode root;

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            TreeNode parent = root;
            TreeNode current = root;
            while (current != null) {
                parent = current;
                if (data > current.getData()) {
                    current = current.getRight();
                } else if (data < current.getData()) {
                    current = current.getLeft();
                } else {
                    //If here, duplicate
                    return;
                }
            }
            if (data > parent.getData()) {
                parent.setRight(new TreeNode(data));
            } else if (data < parent.getData()) {
                parent.setLeft(new TreeNode(data));
            }
        }
        
    }

    public TreeNode find(int data) {
        TreeNode current = root;
        while (current != null) {
            if (data > current.getData()) {
                current = current.getRight();
            } else if (data < current.getData()) {
                current = current.getLeft();
            } else {
                return current;
            }
        }
        return null;
    }

    public void delete(int data) {
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeft = false;

        while (current != null && current.getData() != data) {
            parent = current;
            if (data > current.getData()) {
                current = current.getRight();
                isLeft = false;
            } else if (data < current.getData()) {
                current = current.getLeft();
                isLeft = true;
            } else {
                break;
            }
        }

        if (current == null)
            return;

        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeft) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
            
        } else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else {
                if (isLeft) {
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            }
        } else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else {
                if (isLeft) {
                    parent.setLeft(current.getRight());
                } else {
                    parent.setRight(current.getRight());
                }
            }
        } else {
            if (current == root) {
                current = current.getRight();
                boolean movedLeft = false;
                while (current.getLeft() != null) {
                    parent = current;
                    current = current.getLeft();
                    movedLeft = true;
                }
                current.setLeft(root.getLeft());
                if(movedLeft) {
                    if (current.getRight() != null) 
                        parent.setLeft(current.getRight());
                    else
                        parent.setLeft(null);
                    current.setRight(root.getRight());
                }                
                root = parent = current;
            } else {
                if (isLeft) {
                    TreeNode parent2 = current;
                    current = current.getRight();
                    boolean movedLeft = false;
                    while (current.getLeft() != null) {
                        parent2 = current;
                        current = current.getLeft();
                        movedLeft = true;
                    }
                    if (movedLeft) {
                        current.setLeft(parent.getLeft().getLeft());
                        if(current.getRight() != null)
                            parent2.setLeft(current.getRight());
                        else
                            parent2.setLeft(null);
                        parent.setLeft(current);
                        current.setRight(parent2);
                    } else {
                        current.setLeft(parent2.getLeft());
                        parent.setLeft(current);
                    }
                } else {
                    TreeNode parent2 = current;
                    current = current.getRight();
                    boolean movedLeft = false;
                    while (current.getLeft() != null) {
                        parent2 = current;
                        current = current.getLeft();
                        movedLeft = true;
                    }
                    if (movedLeft) {
                        current.setLeft(parent.getRight().getLeft());
                        if(current.getRight() != null)
                            parent2.setLeft(current.getRight());
                        else
                            parent2.setLeft(null);
                        parent.setRight(current);
                        current.setRight(parent2);
                    } else {
                        current.setLeft(parent2.getLeft());
                        parent.setRight(current);
                    }
                }
            }
        }
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.getLeft());
        System.out.println(node.getData());
        printTree(node.getRight());
    }

}