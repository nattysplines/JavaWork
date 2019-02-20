import java.util.Scanner;

public class StringCompression {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String str = scanner.nextLine();

    System.out.println(compressString(str));

  }

  static String compressString(String str) {

    StringBuilder sb = new StringBuilder();

    int counter = 0;

    for (int i = 0; i < str.length(); i++) {
      counter++;
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        sb.append(str.charAt(i));
        sb.append(counter);
        counter = 0;
      }
    }

    return (str.length() <= sb.length()) ? str : sb.toString();

  }

}