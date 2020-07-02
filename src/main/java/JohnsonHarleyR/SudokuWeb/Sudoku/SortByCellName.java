package JohnsonHarleyR.SudokuWeb.Sudoku;

import java.util.Comparator;

public class SortByCellName implements Comparator<Cell> 
{ 
    // Used for sorting in ascending order of 
    // roll name 
    public int compare(Cell a, Cell b) 
    { 
        return a.getName().compareTo(b.getName()); 
    } 
}