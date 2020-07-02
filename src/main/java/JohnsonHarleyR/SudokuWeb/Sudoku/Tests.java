package JohnsonHarleyR.SudokuWeb.Sudoku;

import java.util.Collections;
import java.util.List;

// A place to do tests

public class Tests {
	
	//Generate an easy test puzzle to solve
	public static UnsolvedBoard easyPuzzle1(UnsolvedBoard board) {
		
		board.setA3(3);board.setA7(2);board.setB2(6);board.setB4(9);
		board.setB5(8);board.setB8(4);board.setB9(3);board.setC1(4);
		board.setC2(9);board.setC5(3);board.setC6(1);board.setC9(6);
		board.setD1(9);board.setD3(7);board.setD7(8);board.setD8(6);
		board.setE2(4);board.setE5(9);board.setE6(8);board.setF3(5);
		board.setF4(4);board.setF6(7);board.setF7(1);board.setF9(9);
		board.setG1(6);board.setG6(3);board.setG7(9);board.setG9(5);
		board.setH3(8);board.setH4(1);board.setH8(7);
		board.setH9(2);board.setI1(2);board.setI3(9);board.setI5(5);
		board.setI6(6);board.setI8(3);board.setI9(8);board.setH1(5);
		
		
		//solve where possible
		int solvable = Game.simplerSolver(board, board.getCellMap());
		if (solvable == -1) {
			System.out.println("\nImpossible to solve.");
		} else if (solvable == 1) {
			System.out.println("\nCould not fully solve.");
		} else {
			System.out.println("Solved!");
		}
		
		return board;
		
	}
	
	//Generate a medium test puzzle to solve
	public static UnsolvedBoard mediumPuzzle1(UnsolvedBoard board) {
		
		board.setA8(2);board.setA9(8);
		board.setB2(6);board.setB9(7);
		board.setC4(4);board.setC6(1);
		board.setD1(5);board.setD4(9);board.setD5(7);board.setD7(3);
		board.setE1(2);board.setE3(4);board.setE6(8);
		board.setF1(3);board.setF6(4);board.setF7(5);
		board.setG1(1);board.setG2(3);board.setG5(9);
		board.setH2(5);board.setH3(7);board.setH8(9);
		board.setI3(8);board.setI4(3);board.setI5(1);board.setI6(7);
		
		
		
		//solve where possible
		//int solvable = Game.simplerSolver(board, board.getCellMap());
		int solvable = Game.betterSolver(board, board.getCellMap());
		if (solvable == -1) {
			System.out.println("\nImpossible to solve.");
		} else if (solvable == 1) {
			System.out.println("\nCould not fully solve.");
		} else {
			System.out.println("Solved!");
		}
		
		return board;
		
	}
	
	//Generate a hard test puzzle to solve
	public static UnsolvedBoard hardPuzzle1(UnsolvedBoard board) {
		
		board.setA4(7);
		board.setB1(1);
		board.setC4(4);board.setC5(3);board.setC7(2);
		board.setD9(6);
		board.setE4(5);board.setE6(9);
		board.setF7(4);board.setF8(1);board.setF9(8);
		board.setG5(8);board.setG6(1);
		board.setH3(3);board.setH8(5);
		board.setI2(4);board.setI7(3);
		
		
		
		//solve where possible
		//int solvable = Game.simplerSolver(board, board.getCellMap());
		int solvable = Game.betterSolver(board, board.getCellMap());
		if (solvable == -1) {
			System.out.println("\nImpossible to solve.");
		} else if (solvable == 1) {
			System.out.println("\nCould not fully solve.");
		} else {
			System.out.println("Solved!");
		}
		
		return board;
		
	}
	
	
	
	
	
	/*
	//see if solutions are generated correctly
	public static void testSolutionsMethod(UnsolvedBoard board) {
		List<Integer> cellSolutions = Game.genSolutions(board.getCellMap().get("a3"), board);
		//print out solutions
		System.out.println("\nTest solutions:");
		for (Integer sol: cellSolutions) {
			System.out.print(sol + ", ");
		}
		System.out.println();
	}*/
	

}
