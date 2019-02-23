/*

Problem: Given 2d array, with negative and positive integers. Count the number of
negative integers. 0 is not negative. It is always square. The array is in ascending
order from left to right, and top to bottom.

*/

public class Array2DCount {
    public static void main(String[] args) {
        int[][] array = { { -4, -3, -1, 1 }, { -2, -2, 1, 2 }, { -1, 1, 2, 3 }, { 1, 2, 4, 5 } };
        int[][] array2 = {{0}};

        System.out.println("Using O(n^2) solution, count is " + countNegONxN(array));
        System.out.println("Using O(n) solution, count is " + countNegON(array));
        System.out.println("Using O(n) solution, count is " + countNegON(array2));
    }

    //Go through whole array, count negs
    static int countNegONxN(int[][] array) {
        int count = 0;
        for (int[] i : array) {
            for (int j : i) {
                if (j < 0)
                    count++;
            }
        }
        return count;
    }

    //Start from last column, if neg found, do math count difference
    //Then jump down one row, continue from same column
    //At most checks 2n cells
    static int countNegON(int[][]array) {
        int count = 0;
        int len = array.length;
        int i = 0;
        for (int j = len - 1; j >= 0; --j) {
            if (array[i][j] < 0) {
                count += j + 1;
                ++i;
                continue;
            }
        }        
        return count;
    }
}