import java.util.Scanner;

public class PermutationPalindrome {

  static boolean checkPalindrome(String str) {

    String modStr = str.toLowerCase().replaceAll("\\s+", "");
    int[] charCounter = new int[128];

    for (int i = 0; i < modStr.length(); i++) {
      charCounter[modStr.charAt(i)]++;
    }

    boolean middleFound = false;

    for (int element : charCounter) {
      if (element % 2 == 1) {
        if (middleFound) {
          return false;
        }
        middleFound = true;
      }
    }

    return true;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String str = scanner.nextLine();

    System.out.println(checkPalindrome(str));

  }

}