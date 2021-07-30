# Coditation_Assignment
-Imagine an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two
possible states, live or dead. Every cell interacts with its eight neighbors, which are the cells that are
directly horizontally, vertically, or diagonally adjacent.
At each step in time (tick), the following transitions occur:
1. Any live cell with fewer than two live neighbors dies, as if by loneliness.
2. Any live cell with more than three live neighbors dies, as if by overcrowding.
3. Any live cell with two or three live neighbors lives, unchanged, to the next generation.
4. Any dead cell with exactly three live neighbors comes to life.
The initial pattern constitutes the 'seed' (randomly placed 500 cells) of the system. The first generation is
created by applying the above rules simultaneously to every cell in the seed — births and deaths happen
simultaneously, and the discrete moment at which this happens is called a tick. (In other words, each
generation is a pure function of the one before.)

#FILES : 
1. Console.java (Main driver file)
2. InputClass.java : To take inputs
3. Dish.java : Contains dish of cells 

#Console.java
1. This contains the main function and has to be compiled before all the other files.
2. Initialises the dish , with a seed of 500 and height and width of 100x100
3. Calls the input function
4. Updates the dish 
5. Exits the program

#InputClass.java
1. This contains the function for input such as inputVariable to input number of variables and searchVariables to search the input variables as per the rules
2. I have used pair class with Hashmap to store xy coordinates and the name
3. The same has been used to search the variables later 

#Dish.java
