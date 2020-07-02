package JohnsonHarleyR.SudokuWeb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import JohnsonHarleyR.SudokuWeb.Sudoku.CompleteBoard;
import JohnsonHarleyR.SudokuWeb.Sudoku.CompleteBoardDao;
import JohnsonHarleyR.SudokuWeb.Sudoku.Cell;
import JohnsonHarleyR.SudokuWeb.Sudoku.Game;
import JohnsonHarleyR.SudokuWeb.Sudoku.SortByCellName;
import JohnsonHarleyR.SudokuWeb.Sudoku.Tests;
import JohnsonHarleyR.SudokuWeb.Sudoku.UnsolvedBoard;
import JohnsonHarleyR.SudokuWeb.Sudoku.UnsolvedBoardDao;

@Controller
public class SudokuController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CompleteBoardDao completeRepo;
	
	@Autowired
	UnsolvedBoardDao unsolvedRepo;
	
	//Page with sudoku game on it
	@RequestMapping("/sudoku")
	public String sudoku(Model model) {
		
		//Set up the board
		
		UnsolvedBoard board = Game.newUnsolvedBoard();
		
		//Attempt to get board from the session
		try {
			//board = (Board)session.getAttribute("board");
		} catch (Exception e) {
			board = Game.newUnsolvedBoard();
		}
		
		//Create empty list to store cells in
		List<Cell> cells = new ArrayList<>();
		
		//If there is no board in the session, create an empty
		if (board == null) {
			board = Game.newUnsolvedBoard();
		}
		
		
		
		
		//TEST AREA TO TEST GAME METHODS
		
		//board = Tests.easyPuzzle1(board);
		board = Tests.mediumPuzzle1(board);
		//board = Tests.hardPuzzle1(board);
		
		//Test isSolvable - doesn't work correctly
		//int solvable = Game.isSolvableSimple(board, true);
		//System.out.println("Solvable? " + solvable);
		
		//test solve()
		//boolean canSolve = Game.solve(Game.changeUnsolvedToArray(board));
		//System.out.println("Can solve with solve(): " + canSolve);
		
		//GET BOARD READY FOR DISPLAY - CHECK FOR 0s
		
		//Get hashmap from board
		HashMap<String, Cell> map = board.getCellMap();
		
		//Now add board values to cell list
		for (String cellName: map.keySet()) {
			
			//set all cells invisible that have a 0 value
			if (map.get(cellName).getValue() == 0) {
				map.get(cellName).setVisible(false);
			} else {
				map.get(cellName).setVisible(true);
			}
			
			
			cells.add(map.get(cellName));
			//System.out.println(map.get(cellName).isVisible());
		}
		
		//sort cell list
		Collections.sort(cells, new SortByCellName());
		
		
		//Now add cells to model
		model.addAttribute("cells", cells);
		/*for (Cell cell: cells) {
			model.addAttribute(cell.getName(), cell);
			//System.out.println(map.get(cell.getName()).getName());
		}*/
		
		session.setAttribute("board", board);
		
		return "sudoku";
	}
	
	//Start a new game
	@RequestMapping("/new")
	public String newGame() {
		
		//Generate new game board
		
		//add board to session
		
		
		return "redirect:/sudoku";
	}
	
	//Generate a complete board
	@RequestMapping("/generate/complete")
	public String generateComplete() {
		
		
		
		return "redirect:/sudoku";
	}
	
	//Generate a complete board
	@RequestMapping("/generate/unsolved")
	public String generateUnsolved() {
		
		
		
		return "redirect:/sudoku";
	}
	
	
	//Control a cell 
	@RequestMapping("/cell")
	public String cell(
			@RequestParam("id") int id,
			Model model) {
		
		//Names of Cells
		
		
		
		return "partials/cell";
	}
	
	//Map the board 
	@RequestMapping("/board")
	public String board(
			Model model) {
		
		//Attempt to get board from the session
		CompleteBoard board = (CompleteBoard)session.getAttribute("board");
		
		//Create empty list to store cells in
		List<Cell> cells = new ArrayList<>();
		
		//If there is no board in the session, create an empty
		if (board == null) {
			board = Game.newCompleteBoard();
		}
		
		//Get hashmap from board
		HashMap<String, Cell> map = board.getCellMap();
		
		//Now add board values to cell list
		for (String cellName: map.keySet()) {
			cells.add(map.get(cellName));
		}
		
		//Now add cells to model
		for (Cell cell: cells) {
			model.addAttribute(cell.getName(), cell);
		}
		
		return "partials/board";
	}
	
	
	

}
