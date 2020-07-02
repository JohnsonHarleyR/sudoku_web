# sudoku_web
(Not yet complete)
A Sudoku project created in Spring MVC.

<h1>Finished</h1>
<ul>
  <li>Completed the POJOs and classes for cells, incomplete boards, and complete boards.</li>
  <li>Set up the display for the board, allowing a user to enter numbers where a square is blank.</li>
  <li>Created method that can find all possible solutions for a cell.</li>
  <li>Created algorithms that are capable of solving easy and medium level puzzles.</li>
</ul>


<h1>To Do</h1>
<ol>
  <li>Improve puzzle solver so that it can solve harder puzzles. (There's a bug to fix in "betterSolver" which might help.</li>
  <li>Copy the basic algorithm from my sudoku_revised project that can generate a full Sudoku grid. (Use the solvers with this.)</li>
  <li>Create a method to copy the new generated puzzle onto a CompleteBoard object and store it in the database, in order that original UnfinishedBoard object may be 
  turned into a puzzle for the player to solve.</li>
  <li>Create a point counting system to determine the level of difficulty in solving a puzzle.</li>
  <li>Observe and write out the ranges of points to determine each difficulty level. (Test with pre-made puzzles to help determine these ranges.)</li>
  <li>Create a method that will generate a new puzzle, then remove cells until the new unfinished puzzle matches a desired difficutly range. Test solvability as you go. 
  (Note: The simplerSolver should be able to solve easy puzzles while the betterSolver should be able to solve medium level puzzles, etc.)</li>
  <li>After all this, create a RequestMapping method (sudokuController) that allows a player to submit answers to a puzzle after solving it. This method should compare 
  their answers to the complete version of the puzzle to determine if it's correct or not.</li>
  <li>Tie everything together to create playable game! Create all the buttons and wire them together for the player.</li>
  <li>Allow player to select the puzzle difficulty.</li>
  <li>Create methods and buttons to allow the player to save their game for later.</li>
  <li>Store created puzzles in database. Later allow program to select from database of pre-created puzzles sometimes. (Determine when and why.) This may make the program 
  quicker.</li>
  <li><b>Validation, testing, bug fixing.</b> (Ideally, this should be done as it goes too.)</li>
</ol>

<h1>Extended/Extras</h2>
<ul>
  <li>Create a nice layout, work on the appearance.</li>
  <li>Find ways to speed up the algorithms! (Look over notes about storage, datatypes, processing, etc.)</li>
  <li>(Maybe)Allow player to select a button to change the cell entry instead of having to type it? (Haven't decided.)</li>
  <li>Implement some javaScript!</li>
  <li>Allow user to store possible solutions in cell with small text. (They can kinda type those in already, but not very well.)</li>
  <li>Only allow user to input one character in a cell. (They can only submit one character by now, but only allow them to type one... If this is done, definitely work 
  on allowing the player to store possible solutions as they go.)</li>
  <li>Create a point system/high score table for the player to keep track of their stats.</li>
  <li>Implement some animation and sound! (Gotta learn to do this first lol. Maybe javaScript? I have a new book.)</li>
</ul>
