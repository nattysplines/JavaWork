import java.util.Arrays;

public class MyHeap {

    private int[] heapArray;
    private int currentPosition = -1;

    public MyHeap(int size) {
        this.heapArray = new int[size];
        // Arrays.fill(this.heapArray, Integer.MAX_VALUE);
    }

    public void insert(int data) {
        if (this.currentPosition > this.heapArray.length - 2) {
            System.out.println("Heap is full");
        } else {
            this.heapArray[++this.currentPosition] = data;
            percUp(this.currentPosition);
        }
    }

    private void percUp(int index) {
        int parent = (index % 2 == 1) ? (index - 1) / 2 : (index - 2) / 2;
        while (parent >= 0 && this.heapArray[parent] > this.heapArray[index]) {
            int temp = this.heapArray[parent];
            this.heapArray[parent] = this.heapArray[index];
            this.heapArray[index] = temp;
            index = parent;
            parent = (index % 2 == 1) ? (index - 1) / 2 : (index - 2) / 2;
        }
    }

    public int remove() {
        if (this.currentPosition < 0) {
            System.out.println("Heap is empty!");
            return -1;
        } else {
            System.out.println("Before remove: " + this.showArray());
            int result = this.heapArray[0];
            this.heapArray[0] = this.heapArray[this.currentPosition--];
            this.heapArray[this.currentPosition + 1] = 0;
            percDown(0);
            System.out.println("After remove: " + this.showArray());
            return result;
        }
    }

    private void percDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        while (left <= this.currentPosition || right <= this.currentPosition) {
            if (left <= this.currentPosition && right <= this.currentPosition) {
                if (this.heapArray[left] <= this.heapArray[index]
                        && this.heapArray[right] <= this.heapArray[index]) {
                    int choice = (this.heapArray[left] - this.heapArray[right] < 0) ? left : right;
                    int temp = this.heapArray[index];
                    this.heapArray[index] = this.heapArray[choice];
                    this.heapArray[choice] = temp;
                    index = choice;
                } else if (this.heapArray[left] <= this.heapArray[index]) {
                    int temp = this.heapArray[index];
                    this.heapArray[index] = this.heapArray[left];
                    this.heapArray[left] = temp;
                    index = left;
                } else if (this.heapArray[right] <= this.heapArray[index]) {
                    int temp = this.heapArray[index];
                    this.heapArray[index] = this.heapArray[right];
                    this.heapArray[right] = temp;
                    index = right;
                } else {
                    index = this.currentPosition;
                }
            } else if (left <= this.currentPosition) {
                if (this.heapArray[left] <= this.heapArray[index]) {
                    int temp = this.heapArray[index];
                    this.heapArray[index] = this.heapArray[left];
                    this.heapArray[left] = temp;
                    index = left;
                } else {
                    index = this.currentPosition;
                }
            } else if (right <= this.currentPosition) {
                if (this.heapArray[right] <= this.heapArray[index]) {
                    int temp = this.heapArray[index];
                    this.heapArray[index] = this.heapArray[right];
                    this.heapArray[right] = temp;
                    index = right;
                } else {
                    index = this.currentPosition;
                }
            }
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    public String showArray() {
        StringBuilder sb = new StringBuilder();

        for (int i : this.heapArray) {
            sb.append("[" + i + "] ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        MyHeap heap = new MyHeap(7);

        heap.insert(7);
        heap.insert(5);
        heap.insert(6);
        heap.insert(11);
        heap.insert(17);
        heap.insert(2);
        heap.insert(4);

        heap.remove();
        System.out.println();
        heap.remove();
        System.out.println();
        heap.remove();
        System.out.println();
        heap.remove();
        System.out.println();
        heap.remove();
        System.out.println();
        heap.remove();
        System.out.println();
        heap.remove();


    }

}