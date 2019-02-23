import java.util.HashSet;

/*
Given array of integers, print a pair that adds to ten.
If multiple, choose a pair and print them.
If no pair, print "No pair adds to 10"
*/

public class PairSumsToTen {
    public static void main(String[] args) {
        int[] array = { 3, 4, 1, 2, 9 };
        int[] array2 = {-11, -20, 2, 4, 30 };
        int[] array3 = {1, 2, 3, 4, 5};
        int[] array4 = {1, 2, 3, 4, 5, 5};
        printPair(array);
        printPair(array2);
        printPair(array3);
        printPair(array4);

    }

    static void printPair(int[] array) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : array) {
            if (set.contains(10 - i)) {
                System.out.println(i + ", " + (10 - i));
                return;
            } else {
                set.add(i);
            }
        }
        System.out.println("No pair adds to 10");

    }
}