# sudoku_web

<i>(Not yet complete)</i><br>
A Sudoku project created in Spring MVC.
<br><br>
See another version here, one with a generator: https://github.com/JohnsonHarleyR/Sudoku_Revised
<br><i>(The solver is better on this one though.)</i>

<h2>Notes</h2>
<ul>
  <li><i>I made a mistake with the .gitignore that I'll be careful about in future projects. The password is from class anyway though and will likely change in the future.</i></li>
</ul>

<h1>Finished</h1>
<ul>
  <li>Completed the POJOs and classes for cells, incomplete boards, and complete boards.</li>
  <li>Set up the display for the board, allowing a user to enter numbers where a square is blank.</li>
  <li>Created method that can find all possible solutions for a cell.</li>
  <li>Created algorithms that are capable of solving easy and medium level puzzles.</li>
</ul>


<h1>To Do</h1>
<ol>
  <li>Improve puzzle solver so that it can solve harder puzzles. <i>(There's a bug to fix in "betterSolver" which might help.)</i></li>
  <li>Copy the basic algorithm from my sudoku_revised project that can generate a full Sudoku grid. <i>(Use the solvers with this.)</i></li>
  <li>Create a method to copy the new generated puzzle onto a CompleteBoard object and store it in the database, in order that the original UnfinishedBoard object may be 
  turned into a puzzle for the player to solve.</li>
  <li>Create a point counting system to determine the level of difficulty in solving a puzzle.</li>
  <li>Observe and write out the ranges of points to determine each difficulty level. <i>(Test with pre-made puzzles to help determine these ranges.)</i></li>
  <li>Create a method that will generate a new puzzle, then remove cells until the new unfinished puzzle matches a desired difficulty range. Test solvability as you go. <i>(Note: The simplerSolver should be able to solve easy puzzles while the betterSolver should be able to solve medium level puzzles, etc.)</i></li>
  <li>After all this, create a RequestMapping method <i>(in SudokuController)</i> that allows a player to submit answers to a puzzle after solving it. This method should compare their answers to the complete version of the puzzle to determine if it's correct or not.</li>
  <li>Tie everything together to create a playable game! Create all the buttons and wire them together for the player.</li>
  <li>Allow player to select the puzzle difficulty.</li>
  <li>Create methods and buttons to allow the player to save their game for later.</li>
  <li>Store created puzzles in database. Later allow program to select from database of pre-created puzzles sometimes. <i>(Determine when and why.)</i> This may make the program quicker.</li>
  <li><b>Validation, testing, bug fixing.</b> <i>(Ideally, this should be done as it goes too.)</i></li>
</ol>

<h1>Extended/Extras</h2>
<ul>
  <li>Create a nice layout, work on the appearance.</li>
  <li>Find ways to speed up the algorithms! <i>(Look over notes about storage, datatypes, processing, etc.)</i></li>
  <li><i>(Maybe)</i> Allow player to select a button to change the cell entry instead of having to type it? <i>(Haven't decided.)</i></li>
  <li>Implement some javaScript!</li>
  <li>Allow user to store possible solutions in cell with small text. <i>(They can kinda type those in already, but not very well.)</i></li>
  <li>Only allow user to input one character in a cell. <i>(They can only submit one character by now, but only allow them to type one... If this is done, definitely work 
  on allowing the player to store possible solutions as they go.)</i></li>
  <li>Create a point system/high score table for the player to keep track of their stats.</li>
  <li>Implement some animation and sound! <i>(Gotta learn to do this first lol. Maybe javaScript? I have a new book.)</i></li>
</ul>

<p>#sudoku #java #SpringMVC #project</p>
