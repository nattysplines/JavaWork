public class BSTTest {
    public static void main(String[] args) {

        MyBST tree = new MyBST();
        tree.insert(10);
        tree.insert(13);
        tree.insert(15);
        tree.insert(14);
        tree.insert(16);
        tree.insert(12);
        tree.insert(6);
        tree.insert(8);
        // tree.insert(7);
        tree.insert(9);
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        tree.delete(2);

        tree.printTree();

    }
}