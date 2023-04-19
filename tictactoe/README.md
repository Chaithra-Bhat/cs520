# TicTacToe

### Documentation

Undo Functionality

* Model: Using the Composite design pattern principles, created a class called "UndoHistory" to store the undo history in a stack and access and modify it using various methods. The stack will contain arrays (of integer type), each of which will contain details such as row, column and player.

* View: Using the Composite design pattern principles, created a class called "UndoView" to create a JButton for Undo and perform various actions on it using defined methods. "RowGameGUI" retrieves the undo button and displays it next to the reset button. At first, the undo button is diabled since there are no moves made, however, the controller component enables it as and when a valid undo move can be made.

* Controller: On clicking the undo button, the Controller calls the undo method to remove the last move made and updates the game board accordingly. Every player is allowed to undo only their move as many times as they want, as long as its their turn to play. In other words, the pop from stack operation is allowed as long as the topmost element in the stack has the same player number as the one whose turn it is. One player is not allowed to undo the move of another player (button is disabled). If there are no moves in the stack, the undo button is disabled.

* Test Cases: Two test cases were also added, one of which was if the user has not done at least one move, the user is not permitted to undo and the other one was if the user has done at least one move, the user is permitted to undo and the game is updated appropriately.

### How to build and test (from Terminal):

1. Make sure that you have Apache Ant installed. Run each ant command in the tictactoe folder, which contains the `build.xml` build file.

2. Run `ant document` to generate the javadoc (a hypertext description) for all of the java classes. Generated hypertext description will be in the `jdoc` folder. Open the `index.html` file. 

3. Run `ant compile` to compile all of the java classes. Compiled classes will be in the `bin` folder.

4. Run `ant test` to run all unit tests.

### How to run (from Terminal):

1. After building the project (i.e., running `ant`), run the following command in the tictactoe folder:
   `java -cp bin RowGameApp`

### How to clean up (from Terminal):

1. Run `ant clean` to clean the project (i.e., delete all generated files).
