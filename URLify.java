import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class URLify {

  static String strEdit(String str, int length) {

    int spaceCount = 0;
    char[] strArr = str.toCharArray();

    for (int i = 0; i < length; i++) {
      if (strArr[i] == ' ')
        spaceCount++;
    }

    for (int i = length - 1; i >= 0; i--) {
      if (spaceCount == 0) {
        break;
      }
      else if (strArr[i] == ' ') {
        spaceCount--;
        strArr[i+spaceCount*2] = '%';
        strArr[i+spaceCount*2+1] = '2';
        strArr[i+spaceCount*2+2] = '0';
      }
      else {
        strArr[i+spaceCount*2] = strArr[i];
      }
    }

    return new String(strArr);

  }

  static String strEditBookVersion(String str, int length) {
    
    int spaceCount = 0;
    char[] strArr = str.toCharArray();

    for (int i = 0; i < length; i++) {
      if (strArr[i] == ' ')
        spaceCount++;
    }

    int index = length + spaceCount * 2 - 1;

    for (int i = length - 1; i >= 0; i--) {
      if (strArr[i] == ' ') {
        strArr[index] = '0';
        strArr[index-1] = '2';
        strArr[index-2] = '%';
        index -= 3;
      } else {
        strArr[index] = strArr[i];
        index--;
      }
    }

    return new String(strArr);
  }
  
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    int length = scanner.nextInt();
    
    System.out.println(strEdit(str, length));
    System.out.println(strEditBookVersion(str, length));

  }

}