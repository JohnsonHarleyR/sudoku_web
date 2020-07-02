package JohnsonHarleyR.SudokuWeb.Sudoku;

import java.util.Arrays;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "complete_board")
public class CompleteBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int a1;
	private int a2;
	private int a3;
	private int a4;
	private int a5;
	private int a6;
	private int a7;
	private int a8;
	private int a9;
	
	private int b1;
	private int b2;
	private int b3;
	private int b4;
	private int b5;
	private int b6;
	private int b7;
	private int b8;
	private int b9;
	
	private int c1;
	private int c2;
	private int c3;
	private int c4;
	private int c5;
	private int c6;
	private int c7;
	private int c8;
	private int c9;
	
	private int d1;
	private int d2;
	private int d3;
	private int d4;
	private int d5;
	private int d6;
	private int d7;
	private int d8;
	private int d9;
	
	private int e1;
	private int e2;
	private int e3;
	private int e4;
	private int e5;
	private int e6;
	private int e7;
	private int e8;
	private int e9;
	
	private int f1;
	private int f2;
	private int f3;
	private int f4;
	private int f5;
	private int f6;
	private int f7;
	private int f8;
	private int f9;
	
	private int g1;
	private int g2;
	private int g3;
	private int g4;
	private int g5;
	private int g6;
	private int g7;
	private int g8;
	private int g9;
	
	private int h1;
	private int h2;
	private int h3;
	private int h4;
	private int h5;
	private int h6;
	private int h7;
	private int h8;
	private int h9;
	
	private int i1;
	private int i2;
	private int i3;
	private int i4;
	private int i5;
	private int i6;
	private int i7;
	private int i8;
	private int i9;
	
	@Column(name = "cells_id")
	private long cellsId;
	
	@Transient
	private HashMap <String, Cell> cellMap;
	
	@Transient
	private HashMap <String, Cell[]> groupMap;
	
	@Transient
	String[] rowA = {"a1","a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9"};
	@Transient
	String[] rowB = {"b1","b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9"};
	@Transient
	String[] rowC = {"c1","c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9"};
	@Transient
	String[] rowD = {"d1","d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9"};
	@Transient
	String[] rowE = {"e1","e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9"};
	@Transient
	String[] rowF = {"f1","f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9"};
	@Transient
	String[] rowG = {"g1","g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9"};
	@Transient
	String[] rowH = {"h1","h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9"};
	@Transient
	String[] rowI = {"i1","i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9"};
	
	
	@Transient
	String[] col1 = {"a1","b1", "c1", "d1", "e1", "f1", "g1", "h1", "i1"};
	@Transient
	String[] col2 = {"a2","b2", "c2", "d2", "e2", "f2", "g2", "h2", "i2"};
	@Transient
	String[] col3 = {"a3","b3", "c3", "d3", "e3", "f3", "g3", "h3", "i3"};
	@Transient
	String[] col4 = {"a4","b4", "c4", "d4", "e4", "f4", "g4", "h4", "i4"};
	@Transient
	String[] col5 = {"a5","b5", "c5", "d5", "e5", "f5", "g5", "h5", "i5"};
	@Transient
	String[] col6 = {"a6","b6", "c6", "d6", "e6", "f6", "g6", "h6", "i6"};
	@Transient
	String[] col7 = {"a7","b7", "c7", "d7", "e7", "f7", "g7", "h7", "i7"};
	@Transient
	String[] col8 = {"a8","b8", "c8", "d8", "e8", "f8", "g8", "h8", "i8"};
	@Transient
	String[] col9 = {"a9","b9", "c9", "d9", "e9", "f9", "g9", "h9", "i9"};
	
	@Transient
	String[] groupNames = {"A1", "A2", "A3",
			   "B1", "B2", "B3",
			   "C1", "C2", "C3"};
	
	@Transient
	String[] groupA1 = {"a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"};
	@Transient
	String[] groupA2 = {"a4", "a5", "a6", "b4", "b5", "b6", "c4", "c5", "c6"};
	@Transient
	String[] groupA3 = {"a7", "a8", "a9", "b7", "b8", "b9", "c7", "c8", "c9"};
	@Transient
	String[] groupB1 = {"d1", "d2", "d3", "e1", "e2", "e3", "f1", "f2", "f3"};
	@Transient
	String[] groupB2 = {"d4", "d5", "d6", "e4", "e5", "e6", "f4", "f5", "f6"};
	@Transient
	String[] groupB3 = {"d7", "d8", "d9", "e7", "e8", "e9", "f7", "f8", "f9"};
	@Transient
	String[] groupC1 = {"g1", "g2", "g3", "h1", "h2", "h3", "i1", "i2", "i3"};
	@Transient
	String[] groupC2 = {"g4", "g5", "g6", "h4", "h5", "h6", "i4", "i5", "i6"};
	@Transient
	String[] groupC3 = {"g7", "g8", "g9", "h7", "h8", "h9", "i7", "i8", "i9"};
	
	
	public CompleteBoard () {
		a1 = 0; a2 = 0; a3 = 0; a4 = 0; a5 = 0; a6 = 0; a7 = 0; a8 = 0; a9 = 0;
		b1 = 0; b2 = 0; b3 = 0; b4 = 0; b5 = 0; b6 = 0; b7 = 0; b8 = 0; b9 = 0;
		c1 = 0; c2 = 0; c3 = 0; c4 = 0; c5 = 0; c6 = 0; c7 = 0; c8 = 0; c9 = 0;
		d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0; d7 = 0; d8 = 0; d9 = 0;
		e1 = 0; e2 = 0; e3 = 0; e4 = 0; e5 = 0; e6 = 0; e7 = 0; e8 = 0; e9 = 0;
		f1 = 0; f2 = 0; f3 = 0; f4 = 0; f5 = 0; f6 = 0; f7 = 0; f8 = 0; f9 = 0;
		g1 = 0; g2 = 0; g3 = 0; g4 = 0; g5 = 0; g6 = 0; g7 = 0; g8 = 0; g9 = 0;
		h1 = 0; h2 = 0; h3 = 0; h4 = 0; h5 = 0; h6 = 0; h7 = 0; h8 = 0; h9 = 0;
		i1 = 0; i2 = 0; i3 = 0; i4 = 0; i5 = 0; i6 = 0; i7 = 0; i8 = 0; i9 = 0;
		
		cellMap = new HashMap<>();
		groupMap = new HashMap<>();
		
		createCellAndGroupMaps();
		
		//now establish rows and columns
		
		
		
	}
	
	public void createCellAndGroupMaps() {
		
		String[] names = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9",
						  "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9",
						  "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9",
						  "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9",
						  "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9",
						  "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9",
						  "g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9",
						  "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9",
						  "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9"};
		
		int[] values = {a1, a2, a3, a4, a5, a6, a7, a8, a9,
				        b1, b2, b3, b4, b5, b6, b7, b8, b9,
				        c1, c2, c3, c4, c5, c6, c7, c8, c9,
				        d1, d2, d3, d4, d5, d6, d7, d8, d9,
				        e1, e2, e3, e4, e5, e6, e7, e8, e9,
				        f1, f2, f3, f4, f5, f6, f7, f8, f9,
				        g1, g2, g3, g4, g5, g6, g7, g8, g9,
				        h1, h2, h3, h4, h5, h6, h7, h8, h9,
				        i1, i2, i3, i4, i5, i6, i7, i8, i9};
		
		
		
		//create hashman
		//loop through and add values
		for (int i = 0; i < names.length; i++) {
			
			//test
			//System.out.println("Name: " + names[i]);
			
			Cell cell = new Cell(names[i], values[i]);
			cellMap.put(cell.getName(), cell);
			
			//test
			//System.out.println("Put: " + cell.getName() + "," + cell.getValue());
			
		}
		
		//now create group maps
		for (int i = 0; i < groupNames.length; i++) {
			//create array
			Cell[] group = new Cell[9];
			//Loop through cells, compare names to group Names
			for (String name: cellMap.keySet()) {
				if (groupNames[i].equals(name)) {
					group[i] = cellMap.get(name);
				}
			}
			//now add that group to the groupMap
			groupMap.put(groupNames[i], group);
		}
		
		
	}
	
	//update a cell
	public void changeCell(String name, int value) {
		Cell cell = new Cell(name, value);
		cellMap.put(name, cell);
		updateGroup(cell);
	}
	
	
	
	//Method to update the group
	public void updateGroup(Cell cell) {
		String[] groupNames = {"A1", "A2", "A3",
	  			   "B1", "B2", "B3",
	  			   "C1", "C2", "C3"};
		
		//Store that group's cells into an array
		Cell[] groupCells = new Cell[9];
		//Loop through names to figure out which group to store
		for (int i = 0; i < groupNames.length; i++) {
			if (groupNames[i].equals(cell.getGroupName())) {
				groupCells = groupMap.get(cell.getGroupName());
			}
		}
		
		//now put result into groupMap
		groupMap.put(cell.getGroupName(), groupCells);
		
	}

	public String[] getGroupNames() {
		return groupNames;
	}

	public void setGroupNames(String[] groupNames) {
		this.groupNames = groupNames;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

	public String[] getGroupA1() {
		return groupA1;
	}

	public void setGroupA1(String[] groupA1) {
		this.groupA1 = groupA1;
	}

	public String[] getGroupA2() {
		return groupA2;
	}

	public void setGroupA2(String[] groupA2) {
		this.groupA2 = groupA2;
	}

	public String[] getGroupA3() {
		return groupA3;
	}

	public void setGroupA3(String[] groupA3) {
		this.groupA3 = groupA3;
	}

	public String[] getGroupB1() {
		return groupB1;
	}

	public void setGroupB1(String[] groupB1) {
		this.groupB1 = groupB1;
	}

	public String[] getGroupB2() {
		return groupB2;
	}

	public void setGroupB2(String[] groupB2) {
		this.groupB2 = groupB2;
	}

	public String[] getGroupB3() {
		return groupB3;
	}

	public void setGroupB3(String[] groupB3) {
		this.groupB3 = groupB3;
	}

	public String[] getGroupC1() {
		return groupC1;
	}

	public void setGroupC1(String[] groupC1) {
		this.groupC1 = groupC1;
	}

	public String[] getGroupC2() {
		return groupC2;
	}

	public void setGroupC2(String[] groupC2) {
		this.groupC2 = groupC2;
	}

	public String[] getGroupC3() {
		return groupC3;
	}

	public void setGroupC3(String[] groupC3) {
		this.groupC3 = groupC3;
	}

	public int getA1() {
		return a1;
	}

	public void setA1(int a1) {
		this.a1 = a1;
		
		String nName = "a1";
		Cell cell = new Cell(nName, a1);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getA2() {
		return a2;
	}

	public void setA2(int a2) {
		this.a2 = a2;
		
		String nName = "a2";
		Cell cell = new Cell(nName, a2);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getA3() {
		return a3;
	}

	public void setA3(int a3) {
		this.a3 = a3;
		
		String nName = "a3";
		Cell cell = new Cell(nName, a3);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getA4() {
		return a4;
	}

	public void setA4(int a4) {
		this.a4 = a4;
		
		String nName = "a4";
		Cell cell = new Cell(nName, a4);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getA5() {
		return a5;
	}

	public void setA5(int a5) {
		this.a5 = a5;
		
		String nName = "a5";
		Cell cell = new Cell(nName, a5);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getA6() {
		return a6;
	}

	public void setA6(int a6) {
		this.a6 = a6;
		
		String nName = "a6";
		Cell cell = new Cell(nName, a6);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getA7() {
		return a7;
	}

	public void setA7(int a7) {
		this.a7 = a7;
		
		String nName = "a7";
		Cell cell = new Cell(nName, a7);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getA8() {
		return a8;
	}

	public void setA8(int a8) {
		this.a8 = a8;
		
		String nName = "a8";
		Cell cell = new Cell(nName, a8);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getA9() {
		return a9;
	}

	public void setA9(int a9) {
		this.a9 = a9;
		
		String nName = "a9";
		Cell cell = new Cell(nName, a9);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getB1() {
		return b1;
	}

	public void setB1(int b1) {
		this.b1 = b1;
		
		String nName = "b1";
		Cell cell = new Cell(nName, b1);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getB2() {
		return b2;
	}

	public void setB2(int b2) {
		this.b2 = b2;
		
		String nName = "b2";
		Cell cell = new Cell(nName, b2);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getB3() {
		return b3;
	}

	public void setB3(int b3) {
		this.b3 = b3;
		
		String nName = "b3";
		Cell cell = new Cell(nName, b3);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getB4() {
		return b4;
	}

	public void setB4(int b4) {
		this.b4 = b4;
		
		String nName = "b4";
		Cell cell = new Cell(nName, b4);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getB5() {
		return b5;
	}

	public void setB5(int b5) {
		this.b5 = b5;
		
		String nName = "b5";
		Cell cell = new Cell(nName, b5);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getB6() {
		return b6;
	}

	public void setB6(int b6) {
		this.b6 = b6;
		
		String nName = "b6";
		Cell cell = new Cell(nName, b6);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getB7() {
		return b7;
	}

	public void setB7(int b7) {
		this.b7 = b7;
		
		String nName = "b7";
		Cell cell = new Cell(nName, b7);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getB8() {
		return b8;
	}

	public void setB8(int b8) {
		this.b8 = b8;
		
		String nName = "b8";
		Cell cell = new Cell(nName, b8);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getB9() {
		return b9;
	}

	public void setB9(int b9) {
		this.b9 = b9;
		
		String nName = "b9";
		Cell cell = new Cell(nName, b9);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getC1() {
		return c1;
	}

	public void setC1(int c1) {
		this.c1 = c1;
		
		String nName = "c1";
		Cell cell = new Cell(nName, c1);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
		
		String nName = "c2";
		Cell cell = new Cell(nName, c2);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getC3() {
		return c3;
	}

	public void setC3(int c3) {
		this.c3 = c3;
		
		String nName = "c3";
		Cell cell = new Cell(nName, c3);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getC4() {
		return c4;
	}

	public void setC4(int c4) {
		this.c4 = c4;
		
		String nName = "c4";
		Cell cell = new Cell(nName, c4);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getC5() {
		return c5;
	}

	public void setC5(int c5) {
		this.c5 = c5;
		
		String nName = "c5";
		Cell cell = new Cell(nName, c5);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getC6() {
		return c6;
	}

	public void setC6(int c6) {
		this.c6 = c6;
		
		String nName = "c6";
		Cell cell = new Cell(nName, c6);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getC7() {
		return c7;
	}

	public void setC7(int c7) {
		this.c7 = c7;
		
		String nName = "c7";
		Cell cell = new Cell(nName, c7);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getC8() {
		return c8;
	}

	public void setC8(int c8) {
		this.c8 = c8;
		
		String nName = "c8";
		Cell cell = new Cell(nName, c8);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getC9() {
		return c9;
	}

	public void setC9(int c9) {
		this.c9 = c9;
		
		String nName = "c9";
		Cell cell = new Cell(nName, c9);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getD1() {
		return d1;
	}

	public void setD1(int d1) {
		this.d1 = d1;
		
		String nName = "d1";
		Cell cell = new Cell(nName, d1);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getD2() {
		return d2;
	}

	public void setD2(int d2) {
		this.d2 = d2;
		
		String nName = "d2";
		Cell cell = new Cell(nName, d2);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getD3() {
		return d3;
	}

	public void setD3(int d3) {
		this.d3 = d3;
		
		String nName = "d3";
		Cell cell = new Cell(nName, d3);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getD4() {
		return d4;
	}

	public void setD4(int d4) {
		this.d4 = d4;
		
		String nName = "d4";
		Cell cell = new Cell(nName, d4);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getD5() {
		return d5;
	}

	public void setD5(int d5) {
		this.d5 = d5;
		
		String nName = "d5";
		Cell cell = new Cell(nName, d5);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getD6() {
		return d6;
	}

	public void setD6(int d6) {
		this.d6 = d6;
		
		String nName = "d6";
		Cell cell = new Cell(nName, d6);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getD7() {
		return d7;
	}

	public void setD7(int d7) {
		this.d7 = d7;
		
		String nName = "d7";
		Cell cell = new Cell(nName, d7);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getD8() {
		return d8;
	}

	public void setD8(int d8) {
		this.d8 = d8;
		
		String nName = "d8";
		Cell cell = new Cell(nName, d8);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getD9() {
		return d9;
	}

	public void setD9(int d9) {
		this.d9 = d9;
		
		String nName = "d9";
		Cell cell = new Cell(nName, d9);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getE1() {
		return e1;
	}

	public void setE1(int e1) {
		this.e1 = e1;
		
		String nName = "e1";
		Cell cell = new Cell(nName, e1);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getE2() {
		return e2;
	}

	public void setE2(int e2) {
		this.e2 = e2;
		
		String nName = "e2";
		Cell cell = new Cell(nName, e2);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getE3() {
		return e3;
	}

	public void setE3(int e3) {
		this.e3 = e3;
		
		String nName = "e3";
		Cell cell = new Cell(nName, e3);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getE4() {
		return e4;
	}

	public void setE4(int e4) {
		this.e4 = e4;
		
		String nName = "e4";
		Cell cell = new Cell(nName, e4);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getE5() {
		return e5;
	}

	public void setE5(int e5) {
		this.e5 = e5;
		
		String nName = "e5";
		Cell cell = new Cell(nName, e5);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getE6() {
		return e6;
	}

	public void setE6(int e6) {
		this.e6 = e6;
		
		String nName = "e6";
		Cell cell = new Cell(nName, e6);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getE7() {
		return e7;
	}

	public void setE7(int e7) {
		this.e7 = e7;
		
		String nName = "e7";
		Cell cell = new Cell(nName, e7);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getE8() {
		return e8;
	}

	public void setE8(int e8) {
		this.e8 = e8;
		
		String nName = "e8";
		Cell cell = new Cell(nName, e8);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getE9() {
		return e9;
	}

	public void setE9(int e9) {
		this.e9 = e9;
		
		String nName = "e9";
		Cell cell = new Cell(nName, e9);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getF1() {
		return f1;
	}

	public void setF1(int f1) {
		this.f1 = f1;
		
		String nName = "f1";
		Cell cell = new Cell(nName, f1);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getF2() {
		return f2;
	}

	public void setF2(int f2) {
		this.f2 = f2;
		
		String nName = "f2";
		Cell cell = new Cell(nName, f2);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getF3() {
		return f3;
	}

	public void setF3(int f3) {
		this.f3 = f3;
		
		String nName = "f3";
		Cell cell = new Cell(nName, f3);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getF4() {
		return f4;
	}

	public void setF4(int f4) {
		this.f4 = f4;
		
		String nName = "f4";
		Cell cell = new Cell(nName, f4);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getF5() {
		return f5;
	}

	public void setF5(int f5) {
		this.f5 = f5;
		
		String nName = "f5";
		Cell cell = new Cell(nName, f5);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getF6() {
		return f6;
	}

	public void setF6(int f6) {
		this.f6 = f6;
		
		String nName = "f6";
		Cell cell = new Cell(nName, f6);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getF7() {
		return f7;
	}

	public void setF7(int f7) {
		this.f7 = f7;
		
		String nName = "f7";
		Cell cell = new Cell(nName, f7);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getF8() {
		return f8;
	}

	public void setF8(int f8) {
		this.f8 = f8;
		
		String nName = "f8";
		Cell cell = new Cell(nName, f8);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getF9() {
		return f9;
	}

	public void setF9(int f9) {
		this.f9 = f9;
		
		String nName = "f9";
		Cell cell = new Cell(nName, f9);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getG1() {
		return g1;
	}

	public void setG1(int g1) {
		this.g1 = g1;
		
		String nName = "g1";
		Cell cell = new Cell(nName, g1);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getG2() {
		return g2;
	}

	public void setG2(int g2) {
		this.g2 = g2;
		
		String nName = "g2";
		Cell cell = new Cell(nName, g2);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getG3() {
		return g3;
	}

	public void setG3(int g3) {
		this.g3 = g3;
		
		String nName = "g3";
		Cell cell = new Cell(nName, g3);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getG4() {
		return g4;
	}

	public void setG4(int g4) {
		this.g4 = g4;
		
		String nName = "g4";
		Cell cell = new Cell(nName, g4);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getG5() {
		return g5;
	}

	public void setG5(int g5) {
		this.g5 = g5;
		
		String nName = "g5";
		Cell cell = new Cell(nName, g5);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getG6() {
		return g6;
	}

	public void setG6(int g6) {
		this.g6 = g6;
		
		String nName = "g6";
		Cell cell = new Cell(nName, g6);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getG7() {
		return g7;
	}

	public void setG7(int g7) {
		this.g7 = g7;
		
		String nName = "g7";
		Cell cell = new Cell(nName, g7);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getG8() {
		return g8;
	}

	public void setG8(int g8) {
		this.g8 = g8;
		
		String nName = "g8";
		Cell cell = new Cell(nName, g8);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getG9() {
		return g9;
	}

	public void setG9(int g9) {
		this.g9 = g9;
		
		String nName = "g9";
		Cell cell = new Cell(nName, g9);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getH1() {
		return h1;
	}

	public void setH1(int h1) {
		this.h1 = h1;
		
		String nName = "h1";
		Cell cell = new Cell(nName, h1);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getH2() {
		return h2;
	}

	public void setH2(int h2) {
		this.h2 = h2;
		
		String nName = "h2";
		Cell cell = new Cell(nName, h2);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getH3() {
		return h3;
	}

	public void setH3(int h3) {
		this.h3 = h3;
		
		String nName = "h3";
		Cell cell = new Cell(nName, h3);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getH4() {
		return h4;
	}

	public void setH4(int h4) {
		this.h4 = h4;
		
		String nName = "h4";
		Cell cell = new Cell(nName, h4);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getH5() {
		return h5;
	}

	public void setH5(int h5) {
		this.h5 = h5;
		
		String nName = "h5";
		Cell cell = new Cell(nName, h5);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getH6() {
		return h6;
	}

	public void setH6(int h6) {
		this.h6 = h6;
		
		String nName = "h6";
		Cell cell = new Cell(nName, h6);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getH7() {
		return h7;
	}

	public void setH7(int h7) {
		this.h7 = h7;
		
		String nName = "h7";
		Cell cell = new Cell(nName, h7);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getH8() {
		return h8;
	}

	public void setH8(int h8) {
		this.h8 = h8;
		
		String nName = "h8";
		Cell cell = new Cell(nName, h8);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getH9() {
		return h9;
	}

	public void setH9(int h9) {
		this.h9 = h9;
		
		String nName = "h9";
		Cell cell = new Cell(nName, h9);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getI1() {
		return i1;
	}

	public void setI1(int i1) {
		this.i1 = i1;
		
		String nName = "i1";
		Cell cell = new Cell(nName, i1);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getI2() {
		return i2;
	}

	public void setI2(int i2) {
		this.i2 = i2;
		
		String nName = "i2";
		Cell cell = new Cell(nName, i2);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getI3() {
		return i3;
	}

	public void setI3(int i3) {
		this.i3 = i3;
		
		String nName = "i3";
		Cell cell = new Cell(nName, i3);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getI4() {
		return i4;
	}

	public void setI4(int i4) {
		this.i4 = i4;
		
		String nName = "i4";
		Cell cell = new Cell(nName, i4);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getI5() {
		return i5;
	}

	public void setI5(int i5) {
		this.i5 = i5;
		
		String nName = "i5";
		Cell cell = new Cell(nName, i5);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getI6() {
		return i6;
	}

	public void setI6(int i6) {
		this.i6 = i6;
		
		String nName = "i6";
		Cell cell = new Cell(nName, i6);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getI7() {
		return i7;
	}

	public void setI7(int i7) {
		this.i7 = i7;
		
		String nName = "i7";
		Cell cell = new Cell(nName, i7);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getI8() {
		return i8;
	}

	public void setI8(int i8) {
		this.i8 = i8;
		
		String nName = "i8";
		Cell cell = new Cell(nName, i8);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public int getI9() {
		return i9;
	}

	public void setI9(int i9) {
		this.i9 = i9;
		
		String nName = "i9";
		Cell cell = new Cell(nName, i9);
		cellMap.put(nName, cell);
		updateGroup(cell);
	}

	public HashMap<String, Cell> getCellMap() {
		return cellMap;
	}

	public void setCellMap(HashMap<String, Cell> cellMap) {
		this.cellMap = cellMap;
		
		//update all variables as well
		for (String n: cellMap.keySet()) {
			
			switch (n) {
			
			case "a1":
				  a1 = cellMap.get(n).getValue();
				  break;
			case "b1":
				  b1 = cellMap.get(n).getValue();
				  break;
			case "c1":
				  c1 = cellMap.get(n).getValue();
				  break;
			case "d1":
				  d1 = cellMap.get(n).getValue();
				  break;
			case "e1":
				  e1 = cellMap.get(n).getValue();
				  break;
			case "f1":
				  f1 = cellMap.get(n).getValue();
				  break;
			case "g1":
				  g1 = cellMap.get(n).getValue();
				  break;
			case "h1":
				  h1 = cellMap.get(n).getValue();
				  break;
			case "i1":
				  i1 = cellMap.get(n).getValue();
				  break;
			case "a2":
				  a2 = cellMap.get(n).getValue();
				  break;
			case "b2":
				  b2 = cellMap.get(n).getValue();
				  break;
			case "c2":
				  c2 = cellMap.get(n).getValue();
				  break;
			case "d2":
				  d2 = cellMap.get(n).getValue();
				  break;
			case "e2":
				  e2 = cellMap.get(n).getValue();
				  break;
			case "f2":
				  f2 = cellMap.get(n).getValue();
				  break;
			case "g2":
				  g2 = cellMap.get(n).getValue();
				  break;
			case "h2":
				  h2 = cellMap.get(n).getValue();
				  break;
			case "i2":
				  i2 = cellMap.get(n).getValue();
				  break;
			case "a3":
				  a3 = cellMap.get(n).getValue();
				  break;
			case "b3":
				  b3 = cellMap.get(n).getValue();
				  break;
			case "c3":
				  c3 = cellMap.get(n).getValue();
				  break;
			case "d3":
				  d3 = cellMap.get(n).getValue();
				  break;
			case "e3":
				  e3 = cellMap.get(n).getValue();
				  break;
			case "f3":
				  f3 = cellMap.get(n).getValue();
				  break;
			case "g3":
				  g3 = cellMap.get(n).getValue();
				  break;
			case "h3":
				  h3 = cellMap.get(n).getValue();
				  break;
			case "i3":
				  i3 = cellMap.get(n).getValue();
				  break;
			case "a4":
				  a4 = cellMap.get(n).getValue();
				  break;
			case "b4":
				  b4 = cellMap.get(n).getValue();
				  break;
			case "c4":
				  c4 = cellMap.get(n).getValue();
				  break;
			case "d4":
				  d4 = cellMap.get(n).getValue();
				  break;
			case "e4":
				  e4 = cellMap.get(n).getValue();
				  break;
			case "f4":
				  f4 = cellMap.get(n).getValue();
				  break;
			case "g4":
				  g4 = cellMap.get(n).getValue();
				  break;
			case "h4":
				  h4 = cellMap.get(n).getValue();
				  break;
			case "i4":
				  i4 = cellMap.get(n).getValue();
				  break;
			case "a5":
				  a5 = cellMap.get(n).getValue();
				  break;
			case "b5":
				  b5 = cellMap.get(n).getValue();
				  break;
			case "c5":
				  c5 = cellMap.get(n).getValue();
				  break;
			case "d5":
				  d5 = cellMap.get(n).getValue();
				  break;
			case "e5":
				  e5 = cellMap.get(n).getValue();
				  break;
			case "f5":
				  f5 = cellMap.get(n).getValue();
				  break;
			case "g5":
				  g5 = cellMap.get(n).getValue();
				  break;
			case "h5":
				  h5 = cellMap.get(n).getValue();
				  break;
			case "i5":
				  i5 = cellMap.get(n).getValue();
				  break;
			case "a6":
				  a6 = cellMap.get(n).getValue();
				  break;
			case "b6":
				  b6 = cellMap.get(n).getValue();
				  break;
			case "c6":
				  c6 = cellMap.get(n).getValue();
				  break;
			case "d6":
				  d6 = cellMap.get(n).getValue();
				  break;
			case "e6":
				  e6 = cellMap.get(n).getValue();
				  break;
			case "f6":
				  f6 = cellMap.get(n).getValue();
				  break;
			case "g6":
				  g6 = cellMap.get(n).getValue();
				  break;
			case "h6":
				  h6 = cellMap.get(n).getValue();
				  break;
			case "i6":
				  i6 = cellMap.get(n).getValue();
				  break;
			case "a7":
				  a7 = cellMap.get(n).getValue();
				  break;
			case "b7":
				  b7 = cellMap.get(n).getValue();
				  break;
			case "c7":
				  c7 = cellMap.get(n).getValue();
				  break;
			case "d7":
				  d7 = cellMap.get(n).getValue();
				  break;
			case "e7":
				  e7 = cellMap.get(n).getValue();
				  break;
			case "f7":
				  f7 = cellMap.get(n).getValue();
				  break;
			case "g7":
				  g7 = cellMap.get(n).getValue();
				  break;
			case "h7":
				  h7 = cellMap.get(n).getValue();
				  break;
			case "i7":
				  i7 = cellMap.get(n).getValue();
				  break;
			case "a8":
				  a8 = cellMap.get(n).getValue();
				  break;
			case "b8":
				  b8 = cellMap.get(n).getValue();
				  break;
			case "c8":
				  c8 = cellMap.get(n).getValue();
				  break;
			case "d8":
				  d8 = cellMap.get(n).getValue();
				  break;
			case "e8":
				  e8 = cellMap.get(n).getValue();
				  break;
			case "f8":
				  f8 = cellMap.get(n).getValue();
				  break;
			case "g8":
				  g8 = cellMap.get(n).getValue();
				  break;
			case "h8":
				  h8 = cellMap.get(n).getValue();
				  break;
			case "i8":
				  i8 = cellMap.get(n).getValue();
				  break;
			case "a9":
				  a9 = cellMap.get(n).getValue();
				  break;
			case "b9":
				  b9 = cellMap.get(n).getValue();
				  break;
			case "c9":
				  c9 = cellMap.get(n).getValue();
				  break;
			case "d9":
				  d9 = cellMap.get(n).getValue();
				  break;
			case "e9":
				  e9 = cellMap.get(n).getValue();
				  break;
			case "f9":
				  f9 = cellMap.get(n).getValue();
				  break;
			case "g9":
				  g9 = cellMap.get(n).getValue();
				  break;
			case "h9":
				  h9 = cellMap.get(n).getValue();
				  break;
			case "i9":
				  i9 = cellMap.get(n).getValue();
				  break;
			default:
			}
			
			
			//update group map too
			updateGroup(cellMap.get(n));
		}
		
		
	}

	public HashMap<String, Cell[]> getGroupMap() {
		createCellAndGroupMaps();
		return groupMap;
	}
	
	//groupMap setter removed to avoid complications. Use "updateGroup(Cell cell)".
	

	public long getCellsId() {
		return cellsId;
	}

	public void setCellsId(long cellsId) {
		this.cellsId = cellsId;
	}
	

	public String[] getRowA() {
		return rowA;
	}

	public void setRowA(String[] rowA) {
		this.rowA = rowA;
	}

	public String[] getRowB() {
		return rowB;
	}

	public void setRowB(String[] rowB) {
		this.rowB = rowB;
	}

	public String[] getRowC() {
		return rowC;
	}

	public void setRowC(String[] rowC) {
		this.rowC = rowC;
	}

	public String[] getRowD() {
		return rowD;
	}

	public void setRowD(String[] rowD) {
		this.rowD = rowD;
	}

	public String[] getRowE() {
		return rowE;
	}

	public void setRowE(String[] rowE) {
		this.rowE = rowE;
	}

	public String[] getRowF() {
		return rowF;
	}

	public void setRowF(String[] rowF) {
		this.rowF = rowF;
	}

	public String[] getRowG() {
		return rowG;
	}

	public void setRowG(String[] rowG) {
		this.rowG = rowG;
	}

	public String[] getRowH() {
		return rowH;
	}

	public void setRowH(String[] rowH) {
		this.rowH = rowH;
	}

	public String[] getRowI() {
		return rowI;
	}

	public void setRowI(String[] rowI) {
		this.rowI = rowI;
	}

	public String[] getCol1() {
		return col1;
	}

	public void setCol1(String[] col1) {
		this.col1 = col1;
	}

	public String[] getCol2() {
		return col2;
	}

	public void setCol2(String[] col2) {
		this.col2 = col2;
	}

	public String[] getCol3() {
		return col3;
	}

	public void setCol3(String[] col3) {
		this.col3 = col3;
	}

	public String[] getCol4() {
		return col4;
	}

	public void setCol4(String[] col4) {
		this.col4 = col4;
	}

	public String[] getCol5() {
		return col5;
	}

	public void setCol5(String[] col5) {
		this.col5 = col5;
	}

	public String[] getCol6() {
		return col6;
	}

	public void setCol6(String[] col6) {
		this.col6 = col6;
	}

	public String[] getCol7() {
		return col7;
	}

	public void setCol7(String[] col7) {
		this.col7 = col7;
	}

	public String[] getCol8() {
		return col8;
	}

	public void setCol8(String[] col8) {
		this.col8 = col8;
	}

	public String[] getCol9() {
		return col9;
	}

	public void setCol9(String[] col9) {
		this.col9 = col9;
	}

	@Override
	public String toString() {
		return "CompleteBoard [id=" + id + ", a1=" + a1 + ", a2=" + a2 + ", a3=" + a3 + ", a4=" + a4 + ", a5=" + a5
				+ ", a6=" + a6 + ", a7=" + a7 + ", a8=" + a8 + ", a9=" + a9 + ", b1=" + b1 + ", b2=" + b2 + ", b3=" + b3
				+ ", b4=" + b4 + ", b5=" + b5 + ", b6=" + b6 + ", b7=" + b7 + ", b8=" + b8 + ", b9=" + b9 + ", c1=" + c1
				+ ", c2=" + c2 + ", c3=" + c3 + ", c4=" + c4 + ", c5=" + c5 + ", c6=" + c6 + ", c7=" + c7 + ", c8=" + c8
				+ ", c9=" + c9 + ", d1=" + d1 + ", d2=" + d2 + ", d3=" + d3 + ", d4=" + d4 + ", d5=" + d5 + ", d6=" + d6
				+ ", d7=" + d7 + ", d8=" + d8 + ", d9=" + d9 + ", e1=" + e1 + ", e2=" + e2 + ", e3=" + e3 + ", e4=" + e4
				+ ", e5=" + e5 + ", e6=" + e6 + ", e7=" + e7 + ", e8=" + e8 + ", e9=" + e9 + ", f1=" + f1 + ", f2=" + f2
				+ ", f3=" + f3 + ", f4=" + f4 + ", f5=" + f5 + ", f6=" + f6 + ", f7=" + f7 + ", f8=" + f8 + ", f9=" + f9
				+ ", g1=" + g1 + ", g2=" + g2 + ", g3=" + g3 + ", g4=" + g4 + ", g5=" + g5 + ", g6=" + g6 + ", g7=" + g7
				+ ", g8=" + g8 + ", g9=" + g9 + ", h1=" + h1 + ", h2=" + h2 + ", h3=" + h3 + ", h4=" + h4 + ", h5=" + h5
				+ ", h6=" + h6 + ", h7=" + h7 + ", h8=" + h8 + ", h9=" + h9 + ", i1=" + i1 + ", i2=" + i2 + ", i3=" + i3
				+ ", i4=" + i4 + ", i5=" + i5 + ", i6=" + i6 + ", i7=" + i7 + ", i8=" + i8 + ", i9=" + i9 + ", cellsId="
				+ cellsId + ", cellMap=" + cellMap + ", groupMap=" + groupMap + ", rowA=" + Arrays.toString(rowA)
				+ ", rowB=" + Arrays.toString(rowB) + ", rowC=" + Arrays.toString(rowC) + ", rowD="
				+ Arrays.toString(rowD) + ", rowE=" + Arrays.toString(rowE) + ", rowF=" + Arrays.toString(rowF)
				+ ", rowG=" + Arrays.toString(rowG) + ", rowH=" + Arrays.toString(rowH) + ", rowI="
				+ Arrays.toString(rowI) + ", col1=" + Arrays.toString(col1) + ", col2=" + Arrays.toString(col2)
				+ ", col3=" + Arrays.toString(col3) + ", col4=" + Arrays.toString(col4) + ", col5="
				+ Arrays.toString(col5) + ", col6=" + Arrays.toString(col6) + ", col7=" + Arrays.toString(col7)
				+ ", col8=" + Arrays.toString(col8) + ", col9=" + Arrays.toString(col9) + "]";
	}
	
	
	
	

}
