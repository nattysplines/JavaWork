public class ChessRookProblem {

    /*
    Given a 2d array representing a chess board,
    1 = rook, 0 = empty;
    Create a function which checks if the rooks are safe
    Can the rooks attack each other with the current board state?
    Assume nxn chessboard
    */

    public static void main(String[] args) {
        int[][] chessT = {{1,0,0},{0,1,0},{0,0,1}};
        int[][] chessF = {{1,0,0},{1,0,0},{0,0,1}};

        System.out.println("First board check: " + rooksAreSafe(chessT));
        System.out.println("First board check: " + rooksAreSafe(chessF));
        
    }

    //Lynda solution different, checks if each row/column has more than 1 rook
    //n^2 vs 2n^2, so the same
    //Same runtime, mine uses extra space
    static boolean rooksAreSafe(int[][] chess) {
        //Row and col array, represent each row and column,
        //whether the row or col is true or "dangerous"
        boolean[] row = new boolean[chess.length];
        boolean[] col = new boolean[chess.length];

        for (int i = 0; i < chess.length; ++i) {
            for (int j = 0; j < chess[i].length; ++j) {
                //Rook found
                if (chess[i][j] == 1) {
                    //If in danger, return false, since rook is not safe
                    if (row[i] || col[j])
                        return false;
                    //If false, time to make row and col dangerous =)
                    else
                        row[i] = col[j] = true;
                }
            }
        }

        return true;
    }



}