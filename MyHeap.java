public class MyHeap {

    private int[] heapArray;
    private int currentPosition = -1;

    public MyHeap(int size) {
        this.heapArray = new int[size];
    }

    public void insert(int data) {
        if (this.currentPosition > heapArray.length - 1) {
            System.out.println("Heap is full");
        } else {
            this.heapArray[++this.currentPosition] = data;
            percUp(this.currentPosition);
        }
    }

    private void percUp(int index) {
        int parent = (index % 2 == 1) ? (index - 1) / 2 : (index - 2) / 2;
        while (parent > 0 && heapArray[parent] > heapArray[index]) {
            int temp = heapArray[parent];
            heapArray[parent] = heapArray[index];
            heapArray[index] = temp;
            index = parent;
            parent = (index % 2 == 1) ? (index - 1) / 2 : (index - 2) / 2;
        }
    }

    private void swapInt(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {

    }

}