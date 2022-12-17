import java.util.Scanner;

public class Sudoku
{
               
	public static final int emptyCell = 0;
	public static final int sudokuSize = 9;
	
	private static boolean checkRow(int[][] board, int row, int number) {
		for(int i=0; i<sudokuSize; i++) {
			if(board[row][i]==number) {
				return true;
			}		 
		}
		return false;
	}
	
	private static boolean checkColumn(int[][] board, int col, int number) {
		for(int i=0; i<sudokuSize; i++) {
			if(board[i][col]==number) {
				return true;
			}		 
		}
		return false;
	}
	
	private static boolean checkSquare(int[][] board, int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				if(board[i][j]== number)
					return true;
			}
			
	}
		return false;
	
	}
	private static boolean checkValid(int[][] board, int row, int col, int number) {
		return !checkRow(board,row, number) && !checkColumn(board, col, number) && !checkSquare(board,row, col, number);
	}
	
	private static boolean solveSudoku(int[][] board) {
		for(int row = 0; row<sudokuSize; row++) {
			for(int col = 0; col<sudokuSize; col++) {
				if(board[row][col]== emptyCell) {
					for(int number = 1; number<=sudokuSize; number++) {
						if(checkValid(board, row, col, number)) {
							board[row][col] = number;
							if(solveSudoku(board)) {
								return true;
							}
							else {
								board[row][col] = emptyCell;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static void printSudoku(int[][] board) {
		for(int i = 0; i< sudokuSize; i++) {
			if(i % 3 == 0 && i != 0) {
				System.out.println("----------------------");
			}
			for(int j = 0; j< sudokuSize; j++) {
				if(j % 3 == 0 && j != 0) {
					System.out.print(" |");
				}
				System.out.print(" "+ board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Sudoku");
		int board[][] = new int [9][9];
		for(int i = 0; i<sudokuSize; i++) {
			for(int j = 0; j<sudokuSize; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		
		System.out.println("Given Sudoku");
		System.out.println();
		printSudoku(board);
		if (solveSudoku(board)){
			System.out.println("Solved Sudoku\n");
			printSudoku(board);
		}
		else {
			System.out.println("Sudoku not Solvable");
		}
		sc.close();
		}
	
}


	



