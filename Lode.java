import java.util.*;
public class Lode {
	public static int rows = 10;
	public static int columns = 10;
	public static String grid[][] = new String[columns][rows];
	public static String grid2[][] = new String[columns][rows];
	public static int playerOneShips;
	public static int playerTwoShips;
	public static void main(String args[]){
		
		createOneMap();
		placeOneShips();
		
		createTwoMap();
		placeTwoShips();
		
		do {
            Battle();
        }while(Lode.playerOneShips != 0 && Lode.playerTwoShips != 0);
		
		gameOver();
	}
	
	public static void createOneMap() {
		System.out.print("  ");
		for(int i = 0; i < rows; i++) System.out.print(i);
		System.out.println();
		
		for(int i = 0; i < grid.length;i++) {
			for(int j = 0; j < grid[i].length;j++) {
				grid[i][j] = " ";	
				if(j == 0) System.out.print(i + "|" + grid[i][j]);
				else if(j == grid[i].length - 1) System.out.print(grid[i][j] + "|" + i);
				else System.out.print(grid[i][j]);	
			}
			System.out.println();
		}
		
		System.out.print("  ");
		for(int i = 0; i < rows; i++) System.out.print(i);
		System.out.println();
	}
	public static void createTwoMap() {
		System.out.print("  ");
		for(int i = 0; i < rows; i++) System.out.print(i);
		System.out.println();
		
		for(int i = 0; i < grid2.length;i++) {
			for(int j = 0; j < grid2[i].length;j++) {
				grid2[i][j] = " ";	
				if(j == 0) System.out.print(i + "|" + grid2[i][j]);
				else if(j == grid2[i].length - 1) System.out.print(grid2[i][j] + "|" + i);
				else System.out.print(grid2[i][j]);	
			}
			System.out.println();
		}
		
		System.out.print("  ");
		for(int i = 0; i < rows; i++) System.out.print(i);
		System.out.println();
	}
	
	public static void placeOneShips() {
		Scanner input = new Scanner(System.in);
		Lode.playerOneShips = 19;
		for(int i = 1; i <= 6; ) {
			if(i==1) System.out.print("Enter X coordinate for the tail of your five tiles long ship: ");
			else if(i==2) System.out.print("Enter X coordinate for the tail of your four tiles long ship: ");
			else if(i<=4) System.out.print("Enter X coordinate for the tail of your three tiles long ship: ");
			else System.out.print("Enter X coordinate for the tail of your two tiles spaces long ship: ");
			int x = input.nextInt();
			
			if(i==1) System.out.print("Enter Y coordinate for the tail of your five tiles long ship: ");
			else if(i==2) System.out.print("Enter Y coordinate for the tail of your four tiles long ship: ");
			else if(i<=4) System.out.print("Enter Y coordinate for the tail of your three tiles long ship: ");
			else System.out.print("Enter Y coordinate for the tail of your two tiles long ship: ");
			int y = input.nextInt();
			
			boolean check = false;
			if((x >= 0 && x < columns) && (y >= 0 && y < rows) && (grid[x][y] == " ")) {
				grid[x][y] = "@";
				check = true;
			}
			else if((x >= 0 && x < columns) && (y >= 0 && y < rows) && (grid[x][y] == "@")) {
				System.out.println("You can't place two or more ships in the same location.");
			}
			else if((x < 0 && x >= columns) && (y < 0 && y >= rows)) {
				System.out.println("You can't place ships outside the " + columns + " by " + rows + " grid");
			}
			
			if(i==1) System.out.print("Enter X coordinate for the front of your five tiles long ship: ");
			else if(i==2) System.out.print("Enter X coordinate for the front of your four tiles long ship: ");
			else if(i<=4) System.out.print("Enter X coordinate for the front of your three tiles long ship: ");
			else System.out.print("Enter X coordinate for the front of your two tiles spaces long ship: ");
			int x2 = input.nextInt();
			
			if(i==1) System.out.print("Enter Y coordinate for the front of your five tiles long ship: ");
			else if(i==2) System.out.print("Enter Y coordinate for the front of your four tiles long ship: ");
			else if(i<=4) System.out.print("Enter Y coordinate for the front of your three tiles long ship: ");
			else System.out.print("Enter Y coordinate for the front of your two tiles long ship: ");
			int y2 = input.nextInt();
			
			if((x2 >= 0 && x2 < columns) && (y2 >= 0 && y2 < rows) && (grid[x2][y2] == " ") && (x2 == x) || (y2 == y)){
				if(i==1) {
					if(x2 == x) {
						if(y+4 == y2) for(int a = y; a <= y2; a++) grid[x][a] = "@";
						else if(y2+4 == y) for(int a = y2; a <= y; a++) grid[x][a] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else if(y2 == y){
						if(x+4 == x2) for(int a = x; a <= x2; a++) grid[a][y] = "@";
						else if(x2+4 == x) for(int a = x2; a <= x; a++) grid[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else {
						System.out.println("The ship is not straight.");
						check = false;
					}
				}
				else if(i==2) {
					if(x2 == x) {
						if(y+3 == y2) for(int a = y; a <= y2; a++) grid[x][a] = "@";
						else if(y2+3 == y) for(int a = y2; a <= y; a++) grid[x][a] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else if(y2 == y){
						if(x+3 == x2) for(int a = x; a <= x2; a++) grid[a][y] = "@";
						else if(x2+3 == x) for(int a = x2; a <= x; a++) grid[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else {
						System.out.println("The ship is not straight.");
						check = false;
					}
				}
				else if (i <= 4) {
					if(x2 == x) {
						if(y+2 == y2) for(int a = y; a <= y2; a++) grid[a][y] = "@";
						else if(y2+2 == y) for(int a = y2; a <= y; a++) grid[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else if(y2 == y){
						if(x+2 == x2) for(int a = x; a <= x2; a++) grid[a][y] = "@";
						else if(x2+2 == x) for(int a = x2; a <= x; a++) grid[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else {
						System.out.println("The ship is not straight.");
						check = false;
					}
				}
				else{
					if(x2 == x) {
						if(y+1 == y2) for(int a = y; a <= y2; a++) grid[a][y] = "@";
						else if(y2+1 == y) for(int a = y2; a <= y; a++) grid[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else if(y2 == y){
						if(x+1 == x2) for(int a = x; a <= x2; a++) grid[a][y] = "@";
						else if(x2+1 == x) for(int a = x2; a <= x; a++) grid[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else {
						System.out.println("The ship is not straight.");
						check = false;
					}
				}
				if(check == true) i++;
			}
			else if((x2 >= 0 && x2 < columns) && (y2 >= 0 && y2 < rows) && (grid[x2][y2] == "@")) {
				System.out.println("You can't place two or more ships in the same location.");
			}
			else if((x2 < 0 && x2 >= columns) && (y2 < 0 && y2 >= rows)) {
				System.out.println("You can't place ships outside the " + columns + " by " + rows + " grid");
			}
			printOneMap();
		}
	}
	public static void placeTwoShips() {
		Scanner input = new Scanner(System.in);
		Lode.playerTwoShips = 19;
		for(int i = 1; i <= 6; ) {
			if(i==1) System.out.print("Enter X coordinate for the tail of your five tiles long ship: ");
			else if(i==2) System.out.print("Enter X coordinate for the tail of your four tiles long ship: ");
			else if(i<=4) System.out.print("Enter X coordinate for the tail of your three tiles long ship: ");
			else System.out.print("Enter X coordinate for the tail of your two tiles spaces long ship: ");
			int x = input.nextInt();
			
			if(i==1) System.out.print("Enter Y coordinate for the tail of your five tiles long ship: ");
			else if(i==2) System.out.print("Enter Y coordinate for the tail of your four tiles long ship: ");
			else if(i<=4) System.out.print("Enter Y coordinate for the tail of your three tiles long ship: ");
			else System.out.print("Enter Y coordinate for the tail of your two tiles long ship: ");
			int y = input.nextInt();
			
			boolean check = false;
			if((x >= 0 && x < columns) && (y >= 0 && y < rows) && (grid2[x][y] == " ")) {
				grid2[x][y] = "@";
				check = true;
			}
			else if((x >= 0 && x < columns) && (y >= 0 && y < rows) && (grid2[x][y] == "@")) {
				System.out.print("You can't place two or more ships in the same location.");
			}
			else if((x < 0 && x >= columns) && (y < 0 && y >= rows)) {
				System.out.print("You can't place ships outside the " + columns + " by " + rows + " grid");
			}
			
			if(i==1) System.out.print("Enter X coordinate for the front of your five tiles long ship: ");
			else if(i==2) System.out.print("Enter X coordinate for the front of your four tiles long ship: ");
			else if(i<=4) System.out.print("Enter X coordinate for the front of your three tiles long ship: ");
			else System.out.print("Enter X coordinate for the front of your two tiles spaces long ship: ");
			int x2 = input.nextInt();
			
			if(i==1) System.out.print("Enter Y coordinate for the front of your five tiles long ship: ");
			else if(i==2) System.out.print("Enter Y coordinate for the front of your four tiles long ship: ");
			else if(i<=4) System.out.print("Enter Y coordinate for the front of your three tiles long ship: ");
			else System.out.print("Enter Y coordinate for the front of your two tiles long ship: ");
			int y2 = input.nextInt();
			
			if((x2 >= 0 && x2 < columns) && (y2 >= 0 && y2 < rows) && (grid2[x2][y2] == " ") && (x2 == x) || (y2 == y)){
				if(i==1) {
					if(x2 == x) {
						if(y+4 == y2) for(int a = y; a <= y2; a++) grid2[x][a] = "@";
						else if(y2+4 == y) for(int a = y2; a <= y; a++) grid2[x][a] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else if(y2 == y){
						if(x+4 == x2) for(int a = x; a <= x2; a++) grid2[a][y] = "@";
						else if(x2+4 == x) for(int a = x2; a <= x; a++) grid2[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else {
						System.out.println("The ship is not straight.");
						check = false;
					}
				}
				else if(i==2) {
					if(x2 == x) {
						if(y+3 == y2) for(int a = y; a <= y2; a++) grid2[x][a] = "@";
						else if(y2+3 == y) for(int a = y2; a <= y; a++) grid2[x][a] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else if(y2 == y){
						if(x+3 == x2) for(int a = x; a <= x2; a++) grid2[a][y] = "@";
						else if(x2+3 == x) for(int a = x2; a <= x; a++) grid2[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else {
						System.out.println("The ship is not straight.");
						check = false;
					}
				}
				else if (i <= 4) {
					if(x2 == x) {
						if(y+2 == y2) for(int a = y; a <= y2; a++) grid2[a][y] = "@";
						else if(y2+2 == y) for(int a = y2; a <= y; a++) grid2[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else if(y2 == y){
						if(x+2 == x2) for(int a = x; a <= x2; a++) grid2[a][y] = "@";
						else if(x2+2 == x) for(int a = x2; a <= x; a++) grid2[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else {
						System.out.println("The ship is not straight.");
						check = false;
					}
				}
				else{
					if(x2 == x) {
						if(y+1 == y2) for(int a = y; a <= y2; a++) grid2[a][y] = "@";
						else if(y2+1 == y) for(int a = y2; a <= y; a++) grid2[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else if(y2 == y){
						if(x+1 == x2) for(int a = x; a <= x2; a++) grid2[a][y] = "@";
						else if(x2+1 == x) for(int a = x2; a <= x; a++) grid2[a][y] = "@";
						else {
							System.out.println("The ship is not the correct size.");
							check = false;
						}
					}
					else {
						System.out.println("The ship is not straight.");
						check = false;
					}
				}
				if(check == true) i++;
			}
			else if((x2 >= 0 && x2 < columns) && (y2 >= 0 && y2 < rows) && (grid2[x2][y2] == "@")) {
				System.out.println("You can't place two or more ships in the same location.");
			}
			else if((x2 < 0 && x2 >= columns) && (y2 < 0 && y2 >= rows)) {
				System.out.println("You can't place ships outside the " + columns + " by " + rows + " grid");
			}
			printTwoMap();
		}
	}
	
	public static void Battle(){
		playerOneTurn();
		printOneMap();
		
		playerTwoTurn();
		printTwoMap();
	}
    public static void playerOneTurn(){
        System.out.println("\nTURN OF PLAYER 1");
		Scanner enter = new Scanner(System.in);
		enter.nextLine();
        int x = -1, y = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();

            if ((x >= 0 && x < columns) && (y >= 0 && y < rows))
            {
                if (grid2[x][y] == "@")
                {
                    System.out.println("You hit the ship!");
                    grid2[x][y] = "!";
                    --BattleShips.computerShips;
                }
                else if (grid2[x][y] == " ") {
                    System.out.println("Sorry, you missed.");
                    grid2[x][y] = "-";
                }
            }
            else if ((x < 0 || x >= columns) || (y < 0 || y >= rows))
                System.out.println("You can't place ships outside the " + columns + " by " + rows + " grid");
        }while((x < 0 || x >= columns) || (y < 0 || y >= rows));
    }
	public static void playerTwoTurn(){
        System.out.println("\nTURN OF PLAYER 2");
		Scanner enter = new Scanner(System.in);
		enter.nextLine();
        int x = -1, y = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();

            if ((x >= 0 && x < columns) && (y >= 0 && y < rows))
            {
                if (grid[x][y] == "@")
                {
                    System.out.println("You hit the ship!");
                    grid[x][y] = "!";
                    --BattleShips.computerShips;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Sorry, you missed.");
                    grid[x][y] = "-";
                }
            }
            else if ((x < 0 || x >= columns) || (y < 0 || y >= rows))
                System.out.println("You can't place ships outside the " + columns + " by " + rows + " grid");
        }while((x < 0 || x >= columns) || (y < 0 || y >= rows));
    }
	
	public static void gameOver(){
        if(Lode.playerOneShips > Lode.playerTwoShips)
            System.out.println("Player 1 won the battle. Congratulations!");
        else
            System.out.println("Player 2 won the battle. Congratulations!");
        System.out.println();
   }
	
	public static void printOneMap(){
        System.out.println();

        System.out.print("  ");
        for(int i = 0; i < rows; i++)
            System.out.print(i);
        System.out.println();

        for(int y = 0; y < grid.length; y++) {
            System.out.print(y + "|");

            for (int x = 0; x < grid[y].length; x++){
                System.out.print(grid[x][y]);
            }

            System.out.println("|" + y);
        }

        System.out.print("  ");
        for(int i = 0; i < rows; i++)
            System.out.print(i);
        System.out.println();
    }
	public static void printTwoMap(){
        System.out.println();

        System.out.print("  ");
        for(int i = 0; i < rows; i++)
            System.out.print(i);
        System.out.println();

        for(int y = 0; y < grid2.length; y++) {
            System.out.print(y + "|");

            for (int x = 0; x < grid2[y].length; x++){
                System.out.print(grid2[x][y]);
            }

            System.out.println("|" + y);
        }

        System.out.print("  ");
        for(int i = 0; i < rows; i++)
            System.out.print(i);
        System.out.println();
    }
}