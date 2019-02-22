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
            int result = this.heapArray[0];
            this.heapArray[0] = this.heapArray[this.currentPosition--];
            this.heapArray[currentPosition+1] = Integer.MAX_VALUE;
            percDown(0);
            return result;
        }
    }

    private void percDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (index < this.heapArray.length - 1 && (this.heapArray[left] <= this.heapArray[this.currentPosition] || this.heapArray[right] <= this.heapArray[this.currentPosition])) {
            if (left < this.heapArray.length - 1 && right < this.heapArray.length - 1 && this.heapArray[left] <= this.heapArray[this.currentPosition] && this.heapArray[right] <= this.heapArray[this.currentPosition] ) {
                int choice = (this.heapArray[left] - this.heapArray[right] > 0) ? left : right;
                int temp = this.heapArray[index];
                this.heapArray[index] = this.heapArray[choice];
                this.heapArray[choice] = temp;
                index = choice;
            } else if (left < this.heapArray.length - 1 && this.heapArray[left] <= this.heapArray[this.currentPosition]) {
                int temp = this.heapArray[index];
                this.heapArray[index] = this.heapArray[left];
                this.heapArray[left] = temp;
                index = left;
            } else if (right < this.heapArray.length - 1 && this.heapArray[right] <= this.heapArray[this.currentPosition]) {
                int temp = this.heapArray[index];
                this.heapArray[index] = this.heapArray[right];
                this.heapArray[right] = temp;
                index = right;
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
        heap.insert(13);

        System.out.println(heap.showArray());
        
        System.out.println(heap.remove());
        
        System.out.println(heap.showArray());
        // System.out.println(heap.remove());
        // System.out.println(heap.remove());
        // System.out.println(heap.remove());

    }

}