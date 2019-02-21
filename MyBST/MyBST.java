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

        //Find the node
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

        //Not found, return
        if (current == null)
            return;

        //If node is a leaf, easy to delete
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
        //If node has left branch, easy    
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
        //If node has right branch, easy    
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
        /*If node has two branches, PITA
        * Algorithm: Find node, move right, then find left most if possible, then swap with node to delete
        * Root case, non-root case left, and non-root case right
        * In all above cases, separate behavior for whether or not there was left travel
        * Fun, but working
        */
        } else {
            //Root
            if (current == root) {
                current = current.getRight();
                boolean movedLeft = false;
                while (current.getLeft() != null) {
                    parent = current;
                    current = current.getLeft();
                    movedLeft = true;
                }
                //If left travel
                if(movedLeft) {
                    if (current.getRight() != null) 
                        parent.setLeft(current.getRight());
                    else
                        parent.setLeft(null);
                    current.setRight(root.getRight());
                }
                //No left travel
                current.setLeft(root.getLeft());                
                root = parent = current;
            } else {
                //Non-root left case
                if (isLeft) {
                    TreeNode parent2 = current;
                    current = current.getRight();
                    boolean movedLeft = false;
                    while (current.getLeft() != null) {
                        parent2 = current;
                        current = current.getLeft();
                        movedLeft = true;
                    }
                    //Left travel
                    if (movedLeft) {
                        current.setLeft(parent.getLeft().getLeft());
                        if(current.getRight() != null)
                            parent2.setLeft(current.getRight());
                        else
                            parent2.setLeft(null);
                        parent.setLeft(current);
                        current.setRight(parent2);
                    //No left travel
                    } else {
                        current.setLeft(parent2.getLeft());
                        parent.setLeft(current);
                    }
                //Non-root right case
                } else {
                    TreeNode parent2 = current;
                    current = current.getRight();
                    boolean movedLeft = false;
                    while (current.getLeft() != null) {
                        parent2 = current;
                        current = current.getLeft();
                        movedLeft = true;
                    }
                    //Left travel
                    if (movedLeft) {
                        current.setLeft(parent.getRight().getLeft());
                        if(current.getRight() != null)
                            parent2.setLeft(current.getRight());
                        else
                            parent2.setLeft(null);
                        parent.setRight(current);
                        current.setRight(parent2);
                    //No left travel
                    } else {
                        current.setLeft(parent2.getLeft());
                        parent.setRight(current);
                    }
                }
            }
        }
    }

    public void printSortedTree() {
        printSortedTree(root);
    }

    private void printSortedTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printSortedTree(node.getLeft());
        System.out.println(node.getData());
        printSortedTree(node.getRight());
    }

    public int minValue() {
        if (root != null)
            return minValue(root);
        return -1;
    }

    private int minValue(TreeNode node) {
        if (node.getLeft() == null) {
            return node.getData();
        } else {
            minValue(node.getLeft());
        }
        return node.getData();
    }

    public int maxValue() {
        if (root != null)
            return maxValue(root);
        return -1;
    }

    private int maxValue(TreeNode node) {
        if (node.getRight() == null) {
            return node.getData();
        } else {
            minValue(node.getLeft());
        }
        return node.getData();
    }

}