package a04;

/**
 * Creates a board of size n*n that will store an instance of a slider puzzle board, 
 * and keep track of hamming & manhattan numbers in order to solve the board. 
 * Also keep track if the board is solved, or if it is solvable. 
 * @author Hai Le & Cory Britton
 */
public class Board {
	private final int n; //Create an immutable int named n in order to keep track of the size
	private final int[] tiles; //Create an immutable int array named tiles to create the board
	private int manhattan = -1; //Create an int named manhattan with value -1 to keep track of the manhattan number
	private int hamming = -1; //Create an int named hamming with value -1 to keep track of the hamming number
	private int zeroLocation; //Create an int named zeroLocation in order to keep track of the empty board
	
	/**
	 * Create a constructor that will take a 2D array of type int
	 * and utilize that parameter to create the board
	 * @param blocks is the 2d array
	 */
	public Board(int[][] blocks) {
		if (blocks == null) throw new NullPointerException(); //If blocks is null, throw a null error
		n = blocks.length; //Initialize immutable n with the length of the parameter
		tiles = new int[n*n]; //Initialize tiles variable with a new int 1d array of n*n

		int tileInside = 0; //Create a new int named tileInside with the value of 0

		//Nested for loop that will loop through each element in the tile
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (blocks[i][j] == 0) zeroLocation = tileInside; //If the current element is 0, then set zeroLocation to the value of tileInside
				tiles[tileInside++] = blocks[i][j]; //Increment the element of tiles with tileInside++, and set it to the current element of parameter blocks
			}
		}		
	}
	 
	 /**
	  * Returns the size of the board
	  * @return n AKA length of one side
	  */
	 public int size() {
		 return n;
	 }
	 
	 /**
	  * Returns the hamming number
	  * @return hamming number which is the number that keeps track of blocks that are out of place
	  */
	 public int hamming() {
		 //If hamming is not -1, then return its value
		 if(hamming != -1) {
			 return hamming;
		 }
		 hamming = 0; //Set hamming to 0 if it passes the first check.
		 //Increment through the tiles with a for loop, taking in the length of the tiles
		 for (int i = 0; i < tiles.length; i++) {
			 if (tiles[i] != 0 && tiles[i] != (i + 1)) hamming++; //If the current element is not 0, and it is not current element + 1, this means it's not in place. Then increment the hamming number
		 }
		 return hamming; //Return the hamming number
	 }
	 
	 /**
	  * Returns the manhattan number
	  * @return sum of Manhattan distances between blocks and goal
	  */
	 public int manhattan() {
		 //If mahattan number is not -1, then return the value, this means it's been solved.
		 if (manhattan != -1) {
			 return manhattan;
		 }
		 //Increment through the values, using a for loop taking in the tiles length
		 for (int i = 0; i < tiles.length; i++) {
			 
			 //If the current element of tiles is i + 1 AKA its goal, or it is 0, then we can interate to next element
			 if (tiles[i] == (i + 1) || i == zeroLocation) continue;
			 
			 //Make the value of manhattan number equal to manhattan plus i / n(length), and subtract current element of tiles minus one divided by length from it.
			 manhattan += Math.abs((i / n) - ((tiles[i] - 1) / n)); // count rows displaced;
			 
			 //Make the value of manhattan number equal to manhattan plus i modulus length, and subtract current element of tiles minus one modulus length from it.
			 manhattan += Math.abs((i % n) - ((tiles[i] - 1) % n)); // count columns displaced;
		 }
		 return manhattan;
	 }
	 
	 /**
	  * Returns if this board is a goal board with a boolean value
	  * @return a boolean value stating if it's a goal board
	  */
	 public boolean isGoal() {
		 //If the last element of tiles is not 0, then we know it's not the blank tile, so it's not goal.
		 if (tiles[tiles.length - 1] != 0) {
			 return false;
		 }
		 //Increment through the tiles with a for loop, taking in length of tiles -1, because we already checked that element
		 for (int i = 0; i < tiles.length - 1; i++)
			 //If the current tile is not i + 1, then it's false.
			 if (tiles[i] != (i + 1)) {
				 return false;
			 }
		 //If all the above fails, then it is true, so return true.
		 return true;
	 }

	 /**
	  * Returns if this board is solvable
	  * @return a boolean value stating if the board is solvable
	  */
	 public boolean isSolvable() {
		 //If size is an odd number AND number of inversions is odd, then it cannot be solved
		 return false;
	 }
	 
	 /**
	  * Returns if this board is equal to y
	  * @return a boolean value if the board is equal to parameter Y
	  */
	 public boolean equals(Object y) {
		 return false;
	 }
	 
	 /**
	  * Keeps track of the neighbors for all the boards
	  * @return all neighboring boards
	  */
	 public Iterable<Board> neighbors(){
		 return null;
	 }
	 
	 /**
	  * toString method that will return the board
	  */
	 public String toString() {
		 return null;
	 }
}
