public class RotateMatrix {
  
  public static void main(String[] args) {

    int[][] arr4 = {{00,01,02,03}, 
                    {10,11,12,13}, 
                    {20,21,22,23}, 
                    {30,31,32,33}};

    int[][] arr5 = {{0,0,0,0,0}, 
                    {1,1,1,1,1}, 
                    {2,2,2,2,2}, 
                    {3,3,3,3,3}, 
                    {4,4,4,4,4}};

    System.out.println(printMatrix(arr4));
    System.out.println("After rotation");
    rotateMatrix(arr4);
    System.out.println(printMatrix(arr4));

  }

  static void rotateMatrix(int[][] arr) {

    for (int layer = 0; layer < arr.length / 2; layer++) {
      int end = arr.length - layer - 1;
      for (int i = layer; i < end; i++) {

        // System.out.println("Temp = " + arr[layer][layer+i]);
        int temp = arr[layer][layer+i];
        
        // System.out.println( arr[layer][layer+i] + " <- " + arr[layer+i][end]);
        arr[layer][layer+i] = arr[layer+i][end];
        
        // System.out.println( arr[layer+i][end] + " <- " + arr[end][end-i]);
        arr[layer+i][end] = arr[end][end-i];
        
        // System.out.println( arr[end][end-i] + " <- " + arr[end-i][layer]);
        arr[end][end-i] = arr[end-i][layer];
        
        // System.out.println( arr[end-i][layer] + " <- Temp");
        arr[end-i][layer] = temp;
        
      }
      
    }

  }

  static String printMatrix(int[][] arr) {

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        sb.append("[" + arr[i][j] + "] ");
      }
      sb.append(System.getProperty("line.separator"));
    }

    return sb.toString();
  }

}