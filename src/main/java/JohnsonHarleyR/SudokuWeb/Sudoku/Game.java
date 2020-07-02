package JohnsonHarleyR.SudokuWeb.Sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

//Methods for the game

//STEPS
//1. Solution finder - done
//2. Regular simple solver - done
//3. Better puzzle solver - done
//4. Complete board generator
//5. Way to calculate difficulty
//6. Method to change unsolved board into complete board

public class Game {
	
	//Create a blank complete board
	public static CompleteBoard newCompleteBoard() {
		CompleteBoard board = new CompleteBoard();
		return board;
	}
	
	//Create a blank unsolved board
	public static UnsolvedBoard newUnsolvedBoard() {
		UnsolvedBoard board = new UnsolvedBoard();
		return board;
	}
	
	//1 means not solved yet, 0 means solved, -1 means cannot solve
	
	
	//copy hashmap method - DONE
	//add solution list to cells - DONE
	//find solutions for each cell - DONE
	//find single solutions, set those cells to the single solution, empty solution list - DONE
	//remove that solution from list in all cells in same row, column and group - DONE
	//repeat previous 2 (or 3) until no more solutions can be found (use boolean) - DONE
	//create method to do all this, then it guesses with cell with least number of solutions
	//keeps repeating until map is filled, if a negative 1 is ever returned it's not solveable
	
	//Add method that checks a group for all the possible values. If there's only one cell where the - DONE
	//solution can be that number, then that cell IS that number. - DONE
	
	
	//This one is risky, it may create an infinite loop. We'll see.
	public static int bestSolver(UnsolvedBoard board, HashMap<String, Cell> map) {
		int cont = 1;
		while (cont == 1) {
			cont = betterSolver(board, map);
		}
		return cont;
	}
	
	
	
	//Slightly more complicated solver. -- Works with medium puzzle
	public static int betterSolver(UnsolvedBoard board, HashMap<String, Cell> map) {
		
		int returnNum = 1;
		String guessName = "";
		
		//LOOP HERE - do while return num == 1
		while (returnNum == 1) {
			returnNum = simplerSolver(board, map);
			
			//If the return number is -1 (impossible to solve) or 0 (solved), return that number
			if (returnNum == -1 || returnNum == 0) {
				return returnNum;
			} 
			
			System.out.println("Simple solver did not work. Moving on to guessing.");
			//Otherwise, find the cell with the least number of solutions
			//do while test number is not equal to -1
			int counter = 0; //this counts the solutions
			int testNum = 1;
			List<String> attemptedCells = new ArrayList<>(); //add to this list after a failed solutions guess
			List<Integer> solutions = new ArrayList<>();
			guessName = findLeastSolutionsCell(map, attemptedCells);
			do {
				
				System.out.println("Attempting guess solutions with cell " + guessName);
				//This is for testing to not affect display board
				HashMap<String, Cell> testMap = copyHashMap(map);
				
				String current = guessName;
				
				System.out.println("There are " + testMap.get(guessName).getSolutions().size() + " possible solutions.");
				solutions = testMap.get(guessName).getSolutions(); //so this keeps referring to the map?
				System.out.println(solutions);
				
				//I think I just learned that copying one HashMap onto another keeps the same reference?
				
				
				//set testMap cell value to counter solution
				int tempInt = solutions.get(counter);
				System.out.println("Attempting solution: " + tempInt);
				testMap.get(guessName).setValue(tempInt);
				//attempt to solve puzzle again with this cell value
				testNum = simplerSolver(board, testMap);
				
				//if puzzle is solved, set map to testMap and return 0
				if (testNum == 0) {
					map = testMap;
					System.out.println("Solved");
					return 0;
				} else if (counter < solutions.size() - 1) { //else if it's -1 or 1 but there's still more solutions to test
					counter++;
					System.out.println("Solution " + solutions.get(counter) +
							" didn't work for cell " + guessName + ". Trying next.");
					System.out.println("Counter: " + (counter - 1) + 
							". There are " + solutions.size() + " solutions in cell.");
					testNum = 1;
				} else if (!guessName.equals(findLastEmpty(testMap))) { //else if it's the last solution but not the last empty cell...
					//if it's the last solution in list, move on to next cell.
					if (counter == testMap.get(guessName).getSolutions().size() ||
							counter == solutions.size() - 1) {
						System.out.println("Test: " + solutions.size() + " size and " +
							counter + " counter");
						attemptedCells.add(guessName);
						counter = 0; //reset counter for next cell
						solutions.clear();
						System.out.println("Testing with " + guessName + " did not work. Moving to next.");
						testMap.get(guessName).setValue(0);
						setMapSolutions(board, testMap);
						setMapSolutions(board, map);
					} else {
						counter++;
					}
					
					
					testNum = 1;
					
					guessName = findLeastSolutionsCell(testMap, attemptedCells);
				} else {
					return 1;
				}
				
				if (guessName.equals("(No name found)")) {
					System.out.println("Cannot continue - no name found.");
					
					//I got this to solve a puzzle but it returned the wrong result here
					//test for empties, then return based on that
					if (!hasEmptiesInMap(map) || !hasEmptiesInMap(testMap)) {
						if (hasEmptiesInMap(map)) {
							map = testMap; //this is ensuring that the test map isn't complete but the real map needs to be changed
						}
						return 0;
					}
					
					
					
					simplerSolver(board, testMap);
					simplerSolver(board, map);
					
					//now test for empties again
					if (hasEmptiesInMap(map) || hasEmptiesInMap(testMap) ) {
						return 1;
					} else {
						return 0;
					}
				}
				
				if (current.equals(guessName)) {
					
					setMapSolutions(board, testMap);
					setMapSolutions(board, map);
					counter++;
				}
				
			} while (testNum == 1);
		
		}
		
		//I got this to solve a puzzle but it returned the wrong result
		
		
		return returnNum;
		
		//Something is still funky but if it becomes a problem, I'll come back to it.
		//Apparently it's harder to copy a hashmap than I thought.
		
		//It should be iterating through all cell solutions though, not going to next cell after first solution attempt.
	}
	
	
	
	//Method to find last empty on board
	public static String findLastEmpty(HashMap<String, Cell> map) {
		String cellName = "";
		for (String name: map.keySet()) {
			if (map.get(name).getValue() == 0) {
				cellName = map.get(name).getName();
			}
		}
		return cellName;
	}
	
	
	//Method to set solutions, find single solutions, set solutions, etc. It keeps going
	//until there are no more single solutions. Then it return -1 if unsolvable (cell exists with no
	//solution), 0 if board is completely solved, and 1 if there are still 0s left.
	public static int simplerSolver(UnsolvedBoard board, HashMap<String, Cell> map) {
		
		//This one changes the display board - without making a copy of the map
		
		int returnNum = 1;
		boolean conti = false;
		
		//Do this once at beginning
		if (hasEmptiesInMap(map)) {
			//Get the solutions for all cells in copied map, store them
			setMapSolutions(board, map);
		} else if (returnNum != -1) {
			if (returnNum == 0) {
				System.out.println("\nSolved!");
			}
			return 0; //meaning it's already solved, basically
		}
		
		//do next part as long as some solutions are found
		do {
			conti = false;
			//System.out.println("Empties in map?: " + hasEmptiesInMap(map));
			//If the copied map still has empties
			if (hasEmptiesInMap(map)) {
				
				//if it doesn't contain single solutions, return negative 1
				if (!containsCellWithSingleSolution(map)) {
					return 1;
				}
				
				//loop through map, setting all single solutions
				for (String name: map.keySet()) {
					int cont = setSingleSolutions(map.get(name), map);
					if (cont == -1) {
						return -1;
					} else if (cont == 0) {
						removeImpossibleSolutionsAroundCell(board, map.get(name), map);
						//System.out.println("Removin'");
					}
				}
				
				//System.out.println("Out of loop");
				
				//Check groups for single solutions
				conti = checkGroupsForSingleValues(board, map);
				//System.out.println("conti: " + conti);
				
				//find all solutions again before looping again
				setMapSolutions(board, map);
			} else if (returnNum != -1) {
				
				System.out.println("\nSolved!");
				
				return 0;
			}
		} while (containsCellWithSingleSolution(map) || conti);
		
		//Test
		//System.out.println("After solving map where possible:");
		for (String name: map.keySet()) {
			//System.out.print(name + ": " + map.get(name).getValue() + ", ");
		}
		
		if (returnNum == 0) {
			System.out.println("\nSolved!");
		}
		
		
		return returnNum;
	}
	
	
	//Test solver - like simplerSolver except it won't change the actual board, just return a value to say if it's solveable yet
	public static int testSolver(UnsolvedBoard board, HashMap<String, Cell> prep) {
		
		//This one does not change display board
		HashMap<String, Cell> map = copyHashMap(prep);
		
		int returnNum = 1;
		boolean conti = false;
		
		//Do this once at beginning
		if (hasEmptiesInMap(map)) {
			//Get the solutions for all cells in copied map, store them
			setMapSolutions(board, map);
		} else if (returnNum != -1) {
			if (returnNum == 0) {
				System.out.println("\nSolved!");
			}
			return 0; //meaning it's already solved, basically
		}
		
		//do next part as long as some solutions are found
		do {
			conti = false;
			//System.out.println("Empties in map?: " + hasEmptiesInMap(map));
			//If the copied map still has empties
			if (hasEmptiesInMap(map)) {
				
				//if it doesn't contain single solutions, return negative 1
				if (!containsCellWithSingleSolution(map)) {
					return 1;
				}
				
				//loop through map, setting all single solutions
				for (String name: map.keySet()) {
					int cont = setSingleSolutions(map.get(name), map);
					if (cont == -1) {
						return -1;
					} else if (cont == 0) {
						removeImpossibleSolutionsAroundCell(board, map.get(name), map);
						//System.out.println("Removin'");
					}
				}
				
				//System.out.println("Out of loop");
				
				//Check groups for single solutions
				conti = checkGroupsForSingleValues(board, map);
				//System.out.println("conti: " + conti);
				
				//find all solutions again before looping again
				setMapSolutions(board, map);
			} else if (returnNum != -1) {
				
				System.out.println("\nSolved!");
				
				return 0;
			}
		} while (containsCellWithSingleSolution(map) || conti);
		
		//Test
		//System.out.println("After solving map where possible:");
		for (String name: map.keySet()) {
			//System.out.print(name + ": " + map.get(name).getValue() + ", ");
		}
		
		if (returnNum == 0) {
			System.out.println("\nSolved!");
		}
		
		
		return returnNum;
	}
	
	
	
	//Find the cell with the least number of solutions
	public static String findLeastSolutionsCell(HashMap<String, Cell> map, List<String> attempted) {
		
		//It doesn't matter if more than one cell has the same number of solutions, just return one of them.
		int lowestNum = 10;
		String cellName = "(No name found)";
		
		//Loop through map to find least number of solutions
		for (String name: map.keySet()) {
			if (!map.get(name).getSolutions().isEmpty() && map.get(name).getSolutions().size() < lowestNum &&
					!attempted.contains(name)) {
				lowestNum = map.get(name).getSolutions().size();
				cellName = map.get(name).getName();
			}
		}
		//store numbers
		return cellName;
	}
	
	
	//method that checks a group for all the possible values. If there's only one cell where the
	//solution can be that number, then that cell IS that number.
	public static boolean checkGroupsForSingleValues(UnsolvedBoard board, HashMap<String, Cell> map) {
		
		final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		boolean hasSingle = false;
		
		//System.out.println("Reached checkGroups start");
		
		String[] groupA1 = board.getGroupA1();
		String[] groupA2 = board.getGroupA2();
		String[] groupA3 = board.getGroupA3();
		String[] groupB1 = board.getGroupB1();
		String[] groupB2 = board.getGroupB2();
		String[] groupB3 = board.getGroupB3();
		String[] groupC1 = board.getGroupC1();
		String[] groupC2 = board.getGroupC2();
		String[] groupC3 = board.getGroupC3();
		
		//store all cells in different groups
		//loop through values
		for (int v = 0; v < VALUES.length; v++) {
			
			//Check all groups
			
			//(I originally stored all these groups in a list to loop through, but then
			//I listed them out individually to help me figure out my mistake. Turns out I
			//didn't need to list them out, the looping was fine. Haha so funny.
			
			//Group A1
			int numOfTimes = 0;
			String nameOfCell = "";
			for (int i = 0; i < groupA1.length; i++) {
				if(map.get(groupA1[i]).getValue() != 0 && 
						map.get(groupA1[i]).getSolutions().contains(VALUES[v])) {
					numOfTimes++;
					nameOfCell = map.get(groupA1[i]).getName();
				}
			}
			//System.out.println("Number of times in group:" + numOfTimes + " for " + v);
			//if that solution only appeared one time in a group, set corresponding cell to value
			if (numOfTimes == 1) {
				//System.out.println("Found once, setting new value: " + nameOfCell);
				map.get(nameOfCell).setValue(v);
				map.get(nameOfCell).getSolutions().clear();
				removeImpossibleSolutionsAroundCell(board, map.get(nameOfCell), map);
				hasSingle = true;
			}
			numOfTimes = 0;
			nameOfCell = "";
			
			//I'm doing it the long way because I found a bug and want to make it less complicated
			//to figure out for a second. Clear thinkin' y'all.
			
			//(And it still didn't work, AAARGH!!)
			
			//GroupA2
			numOfTimes = 0;
			nameOfCell = "";
			for (int i = 0; i < groupA2.length; i++) {
				if(map.get(groupA2[i]).getValue() != 0 && 
						map.get(groupA2[i]).getSolutions().contains(VALUES[v])) {
					numOfTimes++;
					nameOfCell = map.get(groupA2[i]).getName();
				}
			}
			//System.out.println("Number of times in group:" + numOfTimes + " for " + v);
			//if that solution only appeared one time in a group, set corresponding cell to value
			if (numOfTimes == 1) {
				//System.out.println("Found once, setting new value: " + nameOfCell);
				map.get(nameOfCell).setValue(v);
				map.get(nameOfCell).getSolutions().clear();
				removeImpossibleSolutionsAroundCell(board, map.get(nameOfCell), map);
				hasSingle = true;
			}
			numOfTimes = 0;
			nameOfCell = "";
			
			//GroupA3
			numOfTimes = 0;
			nameOfCell = "";
			for (int i = 0; i < groupA3.length; i++) {
				if(map.get(groupA3[i]).getValue() != 0 && 
						map.get(groupA3[i]).getSolutions().contains(VALUES[v])) {
					numOfTimes++;
					nameOfCell = map.get(groupA3[i]).getName();
				}
			}
			//System.out.println("Number of times in group:" + numOfTimes + " for " + v);
			//if that solution only appeared one time in a group, set corresponding cell to value
			if (numOfTimes == 1) {
				//System.out.println("Found once, setting new value: " + nameOfCell);
				map.get(nameOfCell).setValue(v);
				map.get(nameOfCell).getSolutions().clear();
				removeImpossibleSolutionsAroundCell(board, map.get(nameOfCell), map);
				hasSingle = true;
			}
			numOfTimes = 0;
			nameOfCell = "";
			
			//GroupB1
			numOfTimes = 0;
			nameOfCell = "";
			for (int i = 0; i < groupB1.length; i++) {
				if(map.get(groupB1[i]).getValue() != 0 && 
						map.get(groupB1[i]).getSolutions().contains(VALUES[v])) {
					numOfTimes++;
					nameOfCell = map.get(groupB1[i]).getName();
				}
			}
			//System.out.println("Number of times in group:" + numOfTimes + " for " + v);
			//if that solution only appeared one time in a group, set corresponding cell to value
			if (numOfTimes == 1) {
				//System.out.println("Found once, setting new value: " + nameOfCell);
				map.get(nameOfCell).setValue(v);
				map.get(nameOfCell).getSolutions().clear();
				removeImpossibleSolutionsAroundCell(board, map.get(nameOfCell), map);
				hasSingle = true;
			}
			numOfTimes = 0;
			nameOfCell = "";
			
			//GroupB2
			numOfTimes = 0;
			nameOfCell = "";
			for (int i = 0; i < groupB2.length; i++) {
				if(map.get(groupB2[i]).getValue() != 0 && 
						map.get(groupB2[i]).getSolutions().contains(VALUES[v])) {
					numOfTimes++;
					nameOfCell = map.get(groupB2[i]).getName();
				}
			}
			//System.out.println("Number of times in group:" + numOfTimes + " for " + v);
			//if that solution only appeared one time in a group, set corresponding cell to value
			if (numOfTimes == 1) {
				//System.out.println("Found once, setting new value: " + nameOfCell);
				map.get(nameOfCell).setValue(v);
				map.get(nameOfCell).getSolutions().clear();
				removeImpossibleSolutionsAroundCell(board, map.get(nameOfCell), map);
				hasSingle = true;
			}
			numOfTimes = 0;
			nameOfCell = "";
			
			//GroupB3
			numOfTimes = 0;
			nameOfCell = "";
			for (int i = 0; i < groupB3.length; i++) {
				if(map.get(groupB3[i]).getValue() != 0 && 
						map.get(groupB3[i]).getSolutions().contains(VALUES[v])) {
					numOfTimes++;
					nameOfCell = map.get(groupB3[i]).getName();
				}
			}
			//System.out.println("Number of times in group:" + numOfTimes + " for " + v);
			//if that solution only appeared one time in a group, set corresponding cell to value
			if (numOfTimes == 1) {
				//System.out.println("Found once, setting new value: " + nameOfCell);
				map.get(nameOfCell).setValue(v);
				map.get(nameOfCell).getSolutions().clear();
				removeImpossibleSolutionsAroundCell(board, map.get(nameOfCell), map);
				hasSingle = true;
			}
			numOfTimes = 0;
			nameOfCell = "";
			
			//GroupC1
			numOfTimes = 0;
			nameOfCell = "";
			for (int i = 0; i < groupC1.length; i++) {
				if(map.get(groupC1[i]).getValue() != 0 && 
						map.get(groupC1[i]).getSolutions().contains(VALUES[v])) {
					numOfTimes++;
					nameOfCell = map.get(groupC1[i]).getName();
				}
			}
			//System.out.println("Number of times in group:" + numOfTimes + " for " + v);
			//if that solution only appeared one time in a group, set corresponding cell to value
			if (numOfTimes == 1) {
				//System.out.println("Found once, setting new value: " + nameOfCell);
				map.get(nameOfCell).setValue(v);
				map.get(nameOfCell).getSolutions().clear();
				removeImpossibleSolutionsAroundCell(board, map.get(nameOfCell), map);
				hasSingle = true;
			}
			numOfTimes = 0;
			nameOfCell = "";
			
			//GroupC2
			numOfTimes = 0;
			nameOfCell = "";
			for (int i = 0; i < groupC2.length; i++) {
				if(map.get(groupC2[i]).getValue() != 0 && 
						map.get(groupC2[i]).getSolutions().contains(VALUES[v])) {
					numOfTimes++;
					nameOfCell = map.get(groupC2[i]).getName();
				}
			}
			//System.out.println("Number of times in group:" + numOfTimes + " for " + v);
			//if that solution only appeared one time in a group, set corresponding cell to value
			if (numOfTimes == 1) {
				//System.out.println("Found once, setting new value: " + nameOfCell);
				map.get(nameOfCell).setValue(v);
				map.get(nameOfCell).getSolutions().clear();
				removeImpossibleSolutionsAroundCell(board, map.get(nameOfCell), map);
				hasSingle = true;
			}
			numOfTimes = 0;
			nameOfCell = "";
			
			//GroupC3
			numOfTimes = 0;
			nameOfCell = "";
			for (int i = 0; i < groupC3.length; i++) {
				if(map.get(groupC3[i]).getValue() != 0 && 
						map.get(groupC3[i]).getSolutions().contains(VALUES[v])) {
					numOfTimes++;
					nameOfCell = map.get(groupC3[i]).getName();
				}
			}
			//System.out.println("Number of times in group:" + numOfTimes + " for " + v);
			//if that solution only appeared one time in a group, set corresponding cell to value
			if (numOfTimes == 1) {
				//System.out.println("Found once, setting new value: " + nameOfCell);
				map.get(nameOfCell).setValue(v);
				map.get(nameOfCell).getSolutions().clear();
				removeImpossibleSolutionsAroundCell(board, map.get(nameOfCell), map);
				hasSingle = true;
			}
			numOfTimes = 0;
			nameOfCell = "";
			
		}
		board.setCellMap(map);
		return hasSingle;
		
	}
	
	
	
	//Method looks for 0s in hashmap. Returns true if there are
	public static boolean hasEmptiesInMap(HashMap<String, Cell> map) {
		for (String name: map.keySet()) {
			if (map.get(name).getValue() == 0) {
				return true;
			}
		}
		return false;
	}
	
	
	//find single solutions, set those cells to that solution. 
	//Return 0 if successful, return -1 if -1 is found anywhere, return 1 if not single
	public static int setSingleSolutions(Cell cell, HashMap<String, Cell> map) {
		String name = cell.getName();
		if (cell.getSolutions().size() == 1) {
			//return -1 if list contains -1, meaning no solutions
			if (map.get(name).getSolutions().contains(-1)) {
				return -1;
			}
			//set cell value to single solution
			int value = map.get(name).getSolutions().get(0);
			map.get(name).setValue(value);
			//clear the solution list
			map.get(name).getSolutions().clear();
			return 0;
		} else {
			return 1;
		}
}
	
	
	//method to remove solution from all cells in same row, column, group
	public static void removeImpossibleSolutionsAroundCell(UnsolvedBoard board,
			Cell cell, HashMap<String, Cell> map) {
		int remove = cell.getValue();
		String groupName = cell.getGroup();
		String row = cell.getName().substring(0, 1);
		int col = Integer.parseInt(cell.getName().substring(1));
		
		//Get row, col cells
		Cell[] rowCells = findRowCells(board, row, map);
		Cell[] colCells = findColCells(board, col, map);
		
		//Get group cells by looping and finding cells in group
		List<Cell> groupCells = new ArrayList<>();
		for (String name: map.keySet()) {
			if (map.get(name).getGroup().equals(groupName)) {
				groupCells.add(map.get(name));
			}
		}
		
		//remove from same row
		for (int i = 0; i < rowCells.length; i++) {
			for (int n = 0; n < rowCells[i].getSolutions().size(); n++ ) {
				if (rowCells[i].getSolutions().get(n) == remove) {
					rowCells[i].getSolutions().remove(n);
				}
			}
		}
		
		//remove from same col
		for (int i = 0; i < colCells.length; i++) {
			for (int n = 0; n < colCells[i].getSolutions().size(); n++ ) {
				if (colCells[i].getSolutions().get(n) == remove) {
					colCells[i].getSolutions().remove(n);
				}
			}
			
		}
		
		for (Cell c: groupCells) {
			for (int n = 0; n < c.getSolutions().size(); n++ ) {
				if (c.getSolutions().get(n) == remove) {
					c.getSolutions().remove(n);
				}
			}
		}
		
	}
	
	
	//Find out if map has any cells with only one solution
	public static boolean containsCellWithSingleSolution(HashMap<String, Cell> map) {
		//loop through map
		for (String name: map.keySet()) {
			if (!map.get(name).getSolutions().isEmpty() && 
					map.get(name).getSolutions().size() == 1) {
				return true;
			}
		}
		//return false if not returned yet
		return false;
	}
	
	//Store all map solutions
	public static void setMapSolutions(UnsolvedBoard board, HashMap<String, Cell> map) {
		//loop through map
		for (String name: map.keySet()) {
			//find solutions for cell
			List<Integer> list = genSolutions(board, map.get(name), map);
			
			//if cell value equals 0
			if (map.get(name).getValue() == 0) {
				//store solutions in cell
				map.get(name).setSolutions(list);
			} else {
				//else clear solutions
				map.get(name).getSolutions().clear();
			}
			
		}
		
	}
	
	//Copy cell hashmap
	public static HashMap<String, Cell> copyHashMap(HashMap<String, Cell> map) {
		HashMap<String, Cell> newMap = new HashMap<>();
		
		for (String name: map.keySet()) {
			Cell cell = map.get(name);
			newMap.put(name, cell);
		}
		
		return newMap;
		
	}
	
	
	
	
	//Find possible solutions for a cell square
	public static List<Integer> genSolutions(UnsolvedBoard board,
			Cell cell, HashMap<String, Cell> cellMap) {
		
		final int[] CELL_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		//String position = cell.getName();
		
		//Are these parts necessary?
		String rowLetter = cell.getName().substring(0, 1);
		int colNum = Integer.parseInt(cell.getName().substring(1));
		
		//Lists
		List<Integer> solutions = new ArrayList<>();
		List<Integer> usedValues = new ArrayList<>();
		
		//Hashmaps
		//HashMap<String, Cell[]> groupMap = board.getGroupMap(); //all groups of cells
		
		//To get row and column name references, call the Board class
		
		//find cells in the same row and col
		Cell[] rowCells = findRowCells(board, rowLetter, cellMap);
		Cell[] colCells = findColCells(board, colNum, cellMap);
		
		Cell[] groupCells = new Cell[9];
		
		//test
		//System.out.println("\nSolution cell: " + cell.getName());
		
		//find cells in same group
		int n = 0;
		for (String c: cellMap.keySet()) {
			//System.out.println("Loop: " + cellMap.get(c).getName());
			if ( cellMap.get(c).getGroupName().equals(cell.getGroupName()) ) {
				Cell tempCell = cellMap.get(c);
				//System.out.println("Temp Cell: " + tempCell.getName());
				groupCells[n] = tempCell;
				//test
				//System.out.println("Group cell: " + groupCells[n]);
				
				n++;
			}
		}
		
		//Find out used numbers in same row
		for (int i = 0; i < rowCells.length; i++) {
			if (rowCells[i].getName() != cell.getName()) {
				int num = cellMap.get(rowCells[i].getName()).getValue();
				if (num != 0 && !usedValues.contains(num)) {
					usedValues.add(num);
				}
			}
		}
		//Find out used numbers in same column
		for (int i = 0; i < colCells.length; i++) {
			if (colCells[i].getName() != cell.getName()) {
				int num = cellMap.get(colCells[i].getName()).getValue();
				if (num != 0 && !usedValues.contains(num)) {
					usedValues.add(num);
				}
			}
		}
		
		//Find out used numbers in same group
		//System.out.print("Used group numbers:");
		for (int i = 0; i < groupCells.length; i++) {
			
			//System.out.print(groupCells[i].getName());
			
			if (!groupCells[i].getName().equals(cell.getName())) {
				int num = cellMap.get(groupCells[i].getName()).getValue();
				if (num != 0 && !usedValues.contains(num)) {
					usedValues.add(num);
				}
			}
		}
		
		//Find out what solutions are left
		for (int i = 0; i < CELL_VALUES.length; i++) {
			if (!usedValues.contains(CELL_VALUES[i])) {
				solutions.add(CELL_VALUES[i]);
			}
		}
		//return list
		if (solutions.isEmpty()) {
			solutions.add(-1);
			System.out.println("/nCannot solve: cell " + cell.getName());
		}
		
		//show solutions
		//System.out.print("\nSolutions: ");
		for (Integer s: solutions) {
			//System.out.print(s + ",");
		}
		
		return solutions;
	}
	
	
	
	//This changes an unsolved board into a double array
	public static int[][] changeUnsolvedToArray(UnsolvedBoard board) {
		int[][] arrayBoard = new int[9][9];
			
		for (String name: board.getCellMap().keySet()) {
			int row = 0;
			String letter = name.substring(0, 1);
			int col = Integer.parseInt(name.substring(1)) - 1;
			
			//get row num based on letter in name
			switch(letter) {
			case ("a"):
				row = 0;
				break;
			case ("b"):
				row = 1;
				break;
			case ("c"):
				row = 2;
				break;
			case ("d"):
				row = 3;
				break;
			case ("e"):
				row = 4;
				break;
			case ("f"):
				row = 5;
				break;
			case ("g"):
				row = 6;
				break;
			case ("h"):
				row = 7;
				break;
			case ("i"):
				row = 8;
				break;
			}
			
			//now store everything in the array
			arrayBoard[row][col] = board.getCellMap().get(name).getValue();
			System.out.println("Pos " + row + col + ": " + arrayBoard[row][col]);
		}
		
		return arrayBoard;
	}
		
		
		
	
	
	
	
	//THIS SECTION USES A BACKTRACKING ALGORITHM - taken from https://www.baeldung.com/java-sudoku
	
	//Solve board - return true or false
	public static boolean solve(int[][] board) {
		
		
		final int BOARD_SIZE = 9;
		final int BOARD_START_INDEX = 0;
		final int NO_VALUE = 0;
		final int MIN_VALUE = 1;
		final int MAX_VALUE = 9;
		
	    for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
	        for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
	            if (board[row][column] == NO_VALUE) {
	                for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
	                    board[row][column] = k;
	                    if (isValid(board, row, column) && solve(board)) {
	                        return true;
	                    }
	                    board[row][column] = NO_VALUE;
	                }
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	//Check if valid (Similar to elements in my solution finder)
	public static boolean isValid(int[][] board, int row, int column) {
	    return (rowConstraint(board, row)
	      && columnConstraint(board, column) 
	      && subsectionConstraint(board, row, column));
	}
	
	
	//Check Contraint
	public static boolean checkConstraint(
	  int[][] board, int row,boolean[] constraint, int column) {
		
		final int NO_VALUE = 0;
		
	    if (board[row][column] != NO_VALUE) {
	        if (!constraint[board[row][column] - 1]) {
	            constraint[board[row][column] - 1] = true;
	        } else {
	            return false;
	        }
	    }
	    return true;
	}
	
	//check row is valid
	public static boolean rowConstraint(int[][] board, int row) {
		final int BOARD_SIZE = 9;
		final int BOARD_START_INDEX = 0;
		
	    boolean[] constraint = new boolean[BOARD_SIZE];
	    return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
	      .allMatch(column -> checkConstraint(board, row, constraint, column));
	}
	
	//check column is valid
	public static boolean columnConstraint(int[][] board, int column) {
		final int BOARD_SIZE = 9;
		final int BOARD_START_INDEX = 0;
		
	    boolean[] constraint = new boolean[BOARD_SIZE];
	    return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
	      .allMatch(row -> checkConstraint(board, row, constraint, column));
	}
	
	//Check groups are valid
	public static boolean subsectionConstraint(int[][] board, int row, int column) {
		final int BOARD_SIZE = 9;
		final int SUBSECTION_SIZE = 3;
		
		boolean[] constraint = new boolean[BOARD_SIZE];
	    int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
	    int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;
	 
	    int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
	    int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;
	 
	    for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
	        for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
	            if (!checkConstraint(board, r, constraint, c)) return false;
	        }
	    }
	    return true;
	}
	
	
	
	
	
	//Generate populated board (not yet solvable for user)
	public static void genCompleteBoard(CompleteBoard board, CompleteBoardDao repo) {
		
		int counter = 0; //counting steps
		int spot = 0;
		int solution = 0;
		int num = 0;
		boolean isSolved = false;
		List<Integer> spotsLeft = new ArrayList<>();
		List<String> positionsGenerated = new ArrayList<>(); //keep track of nums
		List<Integer> numsGenerated = new ArrayList<>();
		List<Integer> solutions = new ArrayList<>();
		
		//Board's hashmap
		HashMap<String, Cell> map = board.getCellMap();
		
		//Reset board to 0s
		for (String n: map.keySet()) {
			map.get(n).setValue(0);
		}
		board.setCellMap(map);
		repo.save(board);
		
		
		//finish the rest...
		
		
	}
	
	
	//Method to generate unsolved board from complete board by level
	public static UnsolvedBoard genUnsolvedPuzzle(CompleteBoard board,
			String level) {
		UnsolvedBoard puzzleBoard = new UnsolvedBoard();
		
		
		return puzzleBoard;
	}
	
	
	
	
	
	
	
	
	
	//Method to check if it's possible to solve board
	//Return -1 if there's no solution, 1 if there's not enough info, 0 if solvable
	public static int isSolvableSimple(UnsolvedBoard board, boolean tryIt) {
		UnsolvedBoard tempBoard = new UnsolvedBoard();
		tempBoard.setCellMap(board.getCellMap());
		HashMap<String,Cell> cellMap = tempBoard.getCellMap();
		
		boolean solvableCell = false;
		List<Integer> solutions = new ArrayList<>();
		List<Cell> emptyCells = new ArrayList<>();
		
		//set variable to return
		int returnInt = 0;
		
		//Loop this
		//1. if it gets through board with no solvable cells, return 1
		//2. if all squares are solved, return 0
		//3. if there comes a cell with no solution, return -1
		while (true) {
			//clear it all
			solvableCell = false;
			solutions.clear();
			emptyCells.clear();
			boolean solvedNew = false;
			
			
			
			//populate empty square list
			for (String name: cellMap.keySet()) {
				if (cellMap.get(name).getValue() == 0) {
					emptyCells.add(cellMap.get(name));
				}
			}
			
			//sort cells
			Collections.sort(emptyCells, new SortByCellName());
			
			//if emptySquares is empty, the puzzle is solvable so return 0
			if (emptyCells.isEmpty()) {
				returnInt = 0;
				System.out.println("Return:" + returnInt);
				
				
				return returnInt;
			} else { //not solved yet, do this
				for (Cell cell: emptyCells) { //loop through empty squares
					solutions.clear();
					solutions = genSolutions(board, cell, tempBoard.getCellMap());
					if (solutions.contains(-1)) { //If the solution comes back as -1,
						returnInt = -1;
						System.out.println("\nReturn:" + returnInt);
						
						return returnInt;               // then the square is unsolvable and
					                              //so is the puzzle.
					} else if (solutions.size() == 1) {
						tempBoard.changeCell(cell.getName(), solutions.get(0));
						solvableCell = true;
						solvedNew = true;
						System.out.println("\nFound a solution.");
						//If there's only one solution though, set that square to it
					} 
					
					
					if (!solvableCell) {
						returnInt = 1;
						
						//if it's the last one then return it
						if (cell.getName().equals(emptyCells.get(emptyCells.size() - 1).getName())
								&& !solvedNew) {
							return returnInt;
						}
						
						
					}
				}
				//If solvableCell is still false at this point, there's not enough
				//info to solve the puzzle, so return 1
				
			}
			//If a cell was solved this round, keep looping.
			//Otherwise, return as 1.
			if (!solvedNew) {
				System.out.println("Return:" + returnInt);
				
				return returnInt;
			}
		}
		
		
		
	}
	
	
	
	
	
		
	
	
	
	
	//Generate position
	public static int genPos(int row, int col) {
		String sNum = row + "" + col;
		return Integer.parseInt(sNum);
	}
	
	
	
	//Generate position number
	public static int genPosNum(String letter) {
		
		//create new String according to row num
		int num = 0;
		switch (letter) {
		case "a":
			num = 1;
			break;
		case "b":
			num = 2;
			break;
		case "c":
			num = 3;
			break;
		case "d":
			num = 4;
			break;
		case "e":
			num = 5;
			break;
		case "f":
			num = 6;
			break;
		case "g":
			num = 7;
			break;
		case "h":
			num = 8;
			break;
		case "i":
			num = 9;
			break;
		}
		return num;
	}

	//Generate position name
	public static String genPosName(int row, int col) {
		
		//create new String according to row num
		String sRow = "";
		switch (row) {
		case 1:
			sRow = "a";
			break;
		case 2:
			sRow = "b";
			break;
		case 3:
			sRow = "c";
			break;
		case 4:
			sRow = "d";
			break;
		case 5:
			sRow = "e";
			break;
		case 6:
			sRow = "f";
			break;
		case 7:
			sRow = "g";
			break;
		case 8:
			sRow = "h";
			break;
		case 9:
			sRow = "i";
			break;
		}
		
		String sNum = sRow + col;
		return sNum;
	}
	
	
	//find out what col a cell is in, return cells
	public static Cell[] findColCells(UnsolvedBoard board, int colNum,
			HashMap<String,Cell> cellMap) {
		Cell[] colCells = new Cell[9];
		
		switch (colNum) {
		case(1):
			//grab names of row cells
			String[] tempNames1 = board.getCol1();
			//store those cells into the row list
			for (int i = 0; i < tempNames1.length; i++) {
				colCells[i] = cellMap.get(tempNames1[i]);
			}
			break;
		case(2):
			//grab names of row cells
			String[] tempNames2 = board.getCol2();
			//store those cells into the row list
			for (int i = 0; i < tempNames2.length; i++) {
				colCells[i] = cellMap.get(tempNames2[i]);
			}
			break;
		case(3):
			//grab names of row cells
			String[] tempNames3 = board.getCol3();
			//store those cells into the row list
			for (int i = 0; i < tempNames3.length; i++) {
				colCells[i] = cellMap.get(tempNames3[i]);
			}
			break;
		case(4):
			//grab names of row cells
			String[] tempNames4 = board.getCol4();
			//store those cells into the row list
			for (int i = 0; i < tempNames4.length; i++) {
				colCells[i] = cellMap.get(tempNames4[i]);
			}
			break;
		case(5):
			//grab names of row cells
			String[] tempNames5 = board.getCol5();
			//store those cells into the row list
			for (int i = 0; i < tempNames5.length; i++) {
				colCells[i] = cellMap.get(tempNames5[i]);
			}
			break;
		case(6):
			//grab names of row cells
			String[] tempNames6 = board.getCol6();
			//store those cells into the row list
			for (int i = 0; i < tempNames6.length; i++) {
				colCells[i] = cellMap.get(tempNames6[i]);
			}
			break;
		case(7):
			//grab names of row cells
			String[] tempNames7 = board.getCol7();
			//store those cells into the row list
			for (int i = 0; i < tempNames7.length; i++) {
				colCells[i] = cellMap.get(tempNames7[i]);
			}
			break;
		case(8):
			//grab names of row cells
			String[] tempNames8 = board.getCol8();
			//store those cells into the row list
			for (int i = 0; i < tempNames8.length; i++) {
				colCells[i] = cellMap.get(tempNames8[i]);
			}
			break;
		case(9):
			//grab names of row cells
			String[] tempNames9 = board.getCol9();
			//store those cells into the row list
			for (int i = 0; i < tempNames9.length; i++) {
				colCells[i] = cellMap.get(tempNames9[i]);
			}
			break;
		}
		return colCells;
		
	}
	
	
	//find out what row a cell is in, return cells
	public static Cell[] findRowCells(UnsolvedBoard board, String rowLetter,
			HashMap<String,Cell> cellMap) {
		Cell[] rowCells = new Cell[9];
		
		switch (rowLetter) {
		case("a"):
			//grab names of row cells
			String[] tempNamesA = board.getRowA();
			//store those cells into the row list
			for (int i =0; i < tempNamesA.length; i++) {
				rowCells[i] = cellMap.get(tempNamesA[i]);
			}
			break;
		case("b"):
			//grab names of row cells
			String[] tempNamesB = board.getRowB();
			//store those cells into the row list
			for (int i =0; i < tempNamesB.length; i++) {
				rowCells[i] = cellMap.get(tempNamesB[i]);
			}
			break;
		case("c"):
			//grab names of row cells
			String[] tempNamesC = board.getRowC();
			//store those cells into the row list
			for (int i =0; i < tempNamesC.length; i++) {
				rowCells[i] = cellMap.get(tempNamesC[i]);
			}
			break;
		case("d"):
			//grab names of row cells
			String[] tempNamesD = board.getRowD();
			//store those cells into the row list
			for (int i =0; i < tempNamesD.length; i++) {
				rowCells[i] = cellMap.get(tempNamesD[i]);
			}
			break;
		case("e"):
			//grab names of row cells
			String[] tempNamesE = board.getRowE();
			//store those cells into the row list
			for (int i =0; i < tempNamesE.length; i++) {
				rowCells[i] = cellMap.get(tempNamesE[i]);
			}
			break;
		case("f"):
			//grab names of row cells
			String[] tempNamesF = board.getRowF();
			//store those cells into the row list
			for (int i =0; i < tempNamesF.length; i++) {
				rowCells[i] = cellMap.get(tempNamesF[i]);
			}
			break;
		case("g"):
			//grab names of row cells
			String[] tempNamesG = board.getRowG();
			//store those cells into the row list
			for (int i =0; i < tempNamesG.length; i++) {
				rowCells[i] = cellMap.get(tempNamesG[i]);
			}
			break;
		case("h"):
			//grab names of row cells
			String[] tempNamesH = board.getRowH();
			//store those cells into the row list
			for (int i =0; i < tempNamesH.length; i++) {
				rowCells[i] = cellMap.get(tempNamesH[i]);
			}
			break;
		case("i"):
			//grab names of row cells
			String[] tempNamesI = board.getRowI();
			//store those cells into the row list
			for (int i =0; i < tempNamesI.length; i++) {
				rowCells[i] = cellMap.get(tempNamesI[i]);
			}
			break;
		}
		return rowCells;
	}
	
}
