public class CountPairsLessThanX {
    /*
    given sorted array, count pairs < target
    */
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = {2, 4, 6, 8, 9};

        System.out.println("Pairs that equal < 6: " + count(array, 6));
        System.out.println("Pairs that equal < 14: " + count(array2, 14));

        
    }

    static int count(int[] arr, int target) {
        int count = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] >= target) {
                right--;
            } else {
                count += right - left;
                left++;
            }
        }

        
        return count;
    }

}