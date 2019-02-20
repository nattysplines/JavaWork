import java.util.Scanner;

public class IsPermutation {

  static Scanner scanner = new Scanner(System.in);

  static boolean checkPermutation(String first, String second) {

    if (first.length() != second.length())
      return false;

    int[] charCounter = new int[128];

    for (int i = 0; i < first.length(); i++) {
      charCounter[first.charAt(i)]++;
    }

    for (int i = 0; i < second.length(); i++) {
      charCounter[second.charAt(i)]--;
      if (charCounter[second.charAt(i)] < 0)
        return false;
    }

    return true;

  }

  public static void main(String[] args) {
    String first = scanner.nextLine();
    String second = scanner.nextLine();

    System.out.println(checkPermutation(first, second));
  }

}