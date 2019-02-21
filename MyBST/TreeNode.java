class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode (int data) {
        this.data = data;
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @return the left
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * @param right the right to set
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }
}