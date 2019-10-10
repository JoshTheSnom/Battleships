import java.util.*;
public class Lode {
		public static int rows = 10;
	public static int columns = 10;
	public static String grid[][] = new String[columns][rows];
	public static String grid2[][] = new String[columns][rows];
	public static String battlegrid[][] = new String[columns][rows];
	public static String battlegrid2[][] = new String[columns][rows];
	public static int playerOneShips;
	public static int playerTwoShips;
	public static void main(String args[]){
		
		placeOneShips();	
		placeTwoShips();		
		
		createBattleMaps();
		do {
            Battle();
        }while(Lode.playerOneShips != 0 && Lode.playerTwoShips != 0);
		
		gameOver();
	}
	public static void createBattleMaps() {
		for(int i = 0; i < battlegrid.length;i++) {
			for(int j = 0; j < battlegrid[i].length;j++) {
				battlegrid[i][j] = " ";
			}
		}
		for(int i = 0; i < battlegrid2.length;i++) {
			for(int j = 0; j < battlegrid2[i].length;j++) {
				battlegrid2[i][j] = " ";
			}
		}
	}
	public static void printOneBattleMap() {
		System.out.println("\nHere is the battle map for Player 1");

        System.out.print("  ");
        for(int i = 0; i < rows; i++)
            System.out.print(i);
        System.out.println();

        for(int y = 0; y < battlegrid.length; y++) {
            System.out.print(y + "|");

            for (int x = 0; x < battlegrid[y].length; x++){
                System.out.print(battlegrid[x][y]);
            }

            System.out.println("|" + y);
        }

        System.out.print("  ");
        for(int i = 0; i < rows; i++)
            System.out.print(i);
        System.out.println();
    }
	public static void printTwoBattleMap() {
		System.out.println("\nHere is the battle map for Player 2");

        System.out.print("  ");
        for(int i = 0; i < rows; i++)
            System.out.print(i);
        System.out.println();

        for(int y = 0; y < battlegrid2.length; y++) {
            System.out.print(y + "|");

            for (int x = 0; x < battlegrid2[y].length; x++){
                System.out.print(battlegrid2[x][y]);
            }

            System.out.println("|" + y);
        }

        System.out.print("  ");
        for(int i = 0; i < rows; i++)
            System.out.print(i);
        System.out.println();
    }
	
	public static void placeOneShips() {
		
		for(int i = 0; i < grid.length;i++) {
			for(int j = 0; j < grid[i].length;j++) {
				grid[i][j] = " ";
			}
		}
		
		//letadlova lod
        grid[0][0] = "@";
        grid[0][1] = "@";
        grid[0][2] = "@";
        grid[0][3] = "@";
        grid[0][4] = "@";

        //bitevni lod
        grid[5][2] = "@";
        grid[6][2] = "@";
        grid[7][2] = "@";
        grid[8][2] = "@";

        //kriznik 1
        grid[3][6] = "@";
        grid[4][6] = "@";
        grid[5][6] = "@";

        //kriznik 2
        grid[7][4] = "@";
        grid[8][4] = "@";
        grid[9][4] = "@";

        //hlidkova lod 1
        grid[8][0] = "@";
        grid[9][0] = "@";

        //hlidkova lod 2
        grid[1][5] = "@";
        grid[1][6] = "@";
		
		Lode.playerOneShips = 19;
	}
	public static void placeTwoShips() {
		
		for(int i = 0; i < grid2.length;i++) {
			for(int j = 0; j < grid2[i].length;j++) {
				grid2[i][j] = " ";
			}
		}
		
		//letadlova lod
        grid2[5][9] = "@";
        grid2[6][9] = "@";
        grid2[7][9] = "@";
        grid2[8][9] = "@";
        grid2[9][9] = "@";

        //bitevni lod
        grid2[0][2] = "@";
        grid2[0][3] = "@";
        grid2[0][4] = "@";
        grid2[0][5] = "@";

        //kriznik 1
        grid2[5][2] = "@";
        grid2[6][2] = "@";
        grid2[7][2] = "@";

        //kriznik 2
        grid2[9][5] = "@";
        grid2[9][6] = "@";
        grid2[9][7] = "@";

        //hlidkova lod 1
        grid2[0][7] = "@";
        grid2[1][7] = "@";

        //hlidkova lod 2
        grid2[5][5] = "@";
        grid2[5][6] = "@";
			Lode.playerOneShips = 19;
	}
	
	public static void Battle(){
		printOneMap();
		printOneBattleMap();
		playerOneTurn();
		
		printTwoMap();
		printTwoBattleMap();
		playerTwoTurn();
		
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
                    battlegrid[x][y] = "!";
					grid2[x][y] = "X";
                    --Lode.playerTwoShips;
                }
                else if (grid2[x][y] == " ") {
                    System.out.println("Sorry, you missed.");
                    battlegrid[x][y] = "-";
					grid2[x][y] = "-";
                }
            }
            else if ((x < 0 || x >= columns) || (y < 0 || y >= rows))
                System.out.println("You can't place ships outside the " + columns + " by " + rows + " grid");
        }while((x < 0 || x >= columns) || (y < 0 || y >= rows));
		enter.nextLine();
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
                    battlegrid2[x][y] = "!";
					grid[x][y] = "X";
                    --Lode.playerTwoShips;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Sorry, you missed.");
                    battlegrid2[x][y] = "-";
					grid[x][y] = "-";
                }
            }
            else if ((x < 0 || x >= columns) || (y < 0 || y >= rows))
                System.out.println("You can't place ships outside the " + columns + " by " + rows + " grid");
        }while((x < 0 || x >= columns) || (y < 0 || y >= rows));
		
		enter.nextLine();
		
    }
	
	public static void gameOver(){
        if(Lode.playerOneShips > Lode.playerTwoShips)
            System.out.println("Player 1 won the battle. Congratulations!");
        else
            System.out.println("Player 2 won the battle. Congratulations!");
        System.out.println();
   }
	
	public static void printOneMap(){
        System.out.println("\nHere is the map of Player 1");
		Scanner enter = new Scanner(System.in);
		enter.nextLine();

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
		
		enter.nextLine();
		
    }
	public static void printTwoMap(){
        System.out.println("\nHere is the map of Player 2");
		Scanner enter = new Scanner(System.in);
		enter.nextLine();

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
		
		enter.nextLine();
		
    }
}