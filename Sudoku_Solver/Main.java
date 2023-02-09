package Sudoku_Solver;

public class Main {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {

        //  https://www.websudoku.com/?select=1&level=1 Here we take sudoku.... every zero is empty spot

        int[][] board = {
                {0, 7, 0, 0, 2, 0, 0, 0, 0},
                {4, 2, 0, 5, 0, 1, 0, 0, 3},
                {5, 0, 9, 3, 0, 7, 4, 0, 0},
                {7, 6, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 8, 6, 0, 9, 3, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 1, 2},
                {0, 0, 4, 7, 0, 2, 1, 0, 6},
                {6, 0, 0, 8, 0, 3, 0, 7, 9},
                {0, 0, 0, 0, 9, 0, 0, 4, 0}
        };
        printBoard(board);

        if (solveBoard(board)) {
            System.out.println("Solved successfully!");
        } else {
            System.out.println("Unsolvable board :(");
        }

        printBoard(board);
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            //разделяме квадратчета в судокото
            if (row % 3 == 0 && row != 0){
                System.out.println("-----------");
            }
                for (int colm = 0; colm < GRID_SIZE; colm++) {
                    //разделяме квадратчета в судокото
                    if (colm % 3 == 0 && colm != 0){
                        System.out.print("|");
                    }
                    System.out.print(board[row][colm]);
                }
            System.out.println();
        }
    }

    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInCol(int[][] board, int number, int col) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int col) {
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;
        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxCol; j < localBoxCol + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int number, int row, int col) {
        return !isNumberInRow(board, number, row) &&
                !isNumberInCol(board, number, col) &&
                !isNumberInBox(board, number, row, col);
    }

    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int colm = 0; colm < GRID_SIZE; colm++) {
                if (board[row][colm] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, colm)) {
                            board[row][colm] = numberToTry;

                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][colm] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}

