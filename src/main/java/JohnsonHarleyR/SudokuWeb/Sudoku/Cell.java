package JohnsonHarleyR.SudokuWeb.Sudoku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cell implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int value;
	private String group;
	private boolean visible;
	
	private List<Integer> solutions = new ArrayList<>();
	
	public Cell() {
	}
	
	public Cell(String name, int value) {
		super();
		this.name = name;
		this.value = value;
		this.group = getGroupName();
		
		//default visible is true (may change)
		visible = true;
		
	}
	
	//Get what group name a cell belongs to
	public String getGroupName() {
		
		String groupName = "";
		
		if (name.equals("a1") || name.equals("a2") || name.equals("a3") ||
			name.equals("b1") || name.equals("b2") || name.equals("b3") ||
			name.equals("c1") || name.equals("c2") || name.equals("c3")) {
			groupName = "A1";
		} else if (name.equals("a4") || name.equals("a5") || name.equals("a6") ||
				   name.equals("b4") || name.equals("b5") || name.equals("b6") ||
				   name.equals("c4") || name.equals("c5") || name.equals("c6")) {
			groupName = "A2";
		} else if (name.equals("a7") || name.equals("a8") || name.equals("a9") ||
				   name.equals("b7") || name.equals("b8") || name.equals("b9") ||
				   name.equals("c7") || name.equals("c8") || name.equals("c9")) {
			groupName = "A3";
		} else if (name.equals("d1") || name.equals("d2") || name.equals("d3") ||
				   name.equals("e1") || name.equals("e2") || name.equals("e3") ||
				   name.equals("f1") || name.equals("f2") || name.equals("f3")) {
			groupName = "B1";
		} else if (name.equals("d4") || name.equals("d5") || name.equals("d6") ||
				   name.equals("e4") || name.equals("e5") || name.equals("e6") ||
				   name.equals("f4") || name.equals("f5") || name.equals("f6")) {
			groupName = "B2";
		} else if (name.equals("d7") || name.equals("d8") || name.equals("d9") ||
				   name.equals("e7") || name.equals("e8") || name.equals("e9") ||
				   name.equals("f7") || name.equals("f8") || name.equals("f9")) {
			groupName = "B3";
		} else if (name.equals("g1") || name.equals("g2") || name.equals("g3") ||
				   name.equals("h1") || name.equals("h2") || name.equals("h3") ||
				   name.equals("i1") || name.equals("i2") || name.equals("i3")) {
			groupName = "C1";
		} else if (name.equals("g4") || name.equals("g5") || name.equals("g6") ||
				   name.equals("h4") || name.equals("h5") || name.equals("h6") ||
				   name.equals("i4") || name.equals("i5") || name.equals("i6")) {
			groupName = "C2";
		} else if (name.equals("g7") || name.equals("g8") || name.equals("g9") ||
				   name.equals("h7") || name.equals("h8") || name.equals("h9") ||
				   name.equals("i7") || name.equals("i8") || name.equals("i9")) {
			groupName = "C3";
		}
			
		return groupName;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	

	public List<Integer> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Integer> solutions) {
		this.solutions = solutions;
	}

	@Override
	public String toString() {
		return "Cell [name=" + name + ", value=" + value + ", group=" + group + ", visible=" + visible + ", solutions="
				+ solutions + "]";
	}

	

}
