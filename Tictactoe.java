/*
gameBoard is a 5X5 2D character array full of hyphen [ - ], vertical bars [ | ], plus [+] and spaces [' ']
    0 1 2 3 4
0   1 | 2 | 3
1   _ + _ + _
2   4 | 5 | 6
3   _ + _ + _
4   7 | 8 | 9

   indices where piece 'X' or 'O' can be placed
         [0][0] =1, [0][2]=2 , [0][4]=3
         [2][0] =4 , [2][2]=5 , [2][4]=6
         [4][0]= 7 , [2][2]=8 , [2][4]=9
   created functions:
     1)  printGameBoard(char[][] board)- used to print the game board. 
     2)  isAvailable(char board[][] ,int pos )- used to check the position is available or not. returns true if available else false.
     3)  placepiece(char[][] gameBoard,int pos,String usr)- is used to place the piece in the board 
            The player will be represented by the symbal 'X' 
            The computer will be represented by the symbal 'O'  
     4)  checkwinner(char[][] board,char symbol)- checks player/computer wins the game or not. return true if wins else returns false.
            Winning : Whenever any of the two players has fully filled one row/ column/ diagonal with his symbol (X/ O), he wins and the game ends.
     5)  isGameOver(char[][] board) - checks whether the game board is full or not , returns true if the board is full of values else false.
	 
         
*/


import java.util.Random;
import java.util.Scanner;

public class Tictactoe {
	//main function
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		/*5X5 2D character array 
		  |   | 
                _ + _ + _
                  |   | 
                _ + _ + _
                  |   |     */
		char[][] gameBoard= { {' ','|',' ','|',' '},
				      {'-','+','-','+','-' },
				      {' ','|',' ','|',' '},
				      {'-','+','-','+','-' },
				      {' ','|',' ','|',' '} };
		
		printGameBoard(gameBoard);
		String winner="";
		
		while(true) {
			System.out.println("enter the place(1-9):");
			int player_pos=sc.nextInt();
			
			while(!isAvailable(gameBoard,player_pos)) {
				System.out.println(player_pos+"not available");
				System.out.println("enter the place(1-9):");
				player_pos=sc.nextInt();
			}
		    placepiece(gameBoard,player_pos,"player");
		    if(checkwinner(gameBoard,'X')) {
		    	winner="player";
		    	break;
		    }
			 if(isGameOver(gameBoard) ){
				 winner="Tie";
				 break;
			 }
			
			int cpu_pos=rand.nextInt(9)+1;
			while(!isAvailable(gameBoard,cpu_pos)) {
				cpu_pos=rand.nextInt(9)+1;
			}
			placepiece(gameBoard,cpu_pos,"cpu");
			 if(checkwinner(gameBoard,'O')) {
				 winner="CPU";
			    	break;
			    }
			 if(isGameOver(gameBoard) ){
				 winner="Tie";
				 break;
			 }
			 
			printGameBoard(gameBoard);
			
		}
		
		//print the game result
		printGameBoard(gameBoard);
		System.out.println("game over");
		if(winner=="Tie") {
			System.out.println("THE GAME IS TIE");
		}
		else {
			System.out.println(winner+ "is the winner");
			
		}
		
	}
	
//print game board
	
	public static void printGameBoard(char[][] Board) {
		for (char[] i : Board) {
			for(char c:i) {
				System.out.print(c+" ");
			}
			System.out.println();	
		}
	 }

 //check the place is empty/available	
    	public static boolean isAvailable(char board[][],int pos )  {
    		switch(pos) {
    		case 1:
    			 return (board[0][0]==' ');  //returns true if space available  			
    		case 2:
    			return (board[0][2]==' ');
    		
    		case 3:
    			return (board[0][4]==' ');
    		
    		case 4:
    			return (board[2][0]==' ');
    		
    		case 5:
    			return (board[2][2]==' ');
    		
    		case 6:
    			return (board[2][4]==' ');
    			
    	        case 7:
    		       return (board[4][0]==' ');
    		
    	        case 8:
    		       return ( board[4][2]==' ');
    		 
    	        case 9:
    	               return (board[4][4]==' ');
    	        default:
    	    	    return true;
    	    
    		}
    	}
	

	
 //place the  piece
    public static void placepiece(char[][] gameBoard,int pos,String usr) {
    	char symbol=' ';
    	if(usr.equals("player")) {
    		symbol='X';
    	}
    	else {
    		symbol='O';
    	}
    	switch(pos) {
		case 1:
			gameBoard[0][0]=symbol;
			break;
		case 2:
			gameBoard[0][2]=symbol;
			break;
		case 3:
			gameBoard[0][4]=symbol;
			break;
		case 4:
			gameBoard[2][0]=symbol;
			break;
		case 5:
			gameBoard[2][2]=symbol;
			break;
		case 6:
			gameBoard[2][4]=symbol;
			break;
	        case 7:
		       gameBoard[4][0]=symbol;
		       break;
	        case 8:
		       gameBoard[4][2]=symbol;
		       break;
	        case 9:
	              gameBoard[4][4]=symbol;
	              break;
	  }
    }
	
	
 //check winner
    	public static boolean checkwinner(char[][] board,char symbol) {
    		if ((board[0][0] == symbol && board [0][2] == symbol && board [0][4] == symbol) ||
    		    (board[2][0] == symbol && board [2][2] == symbol && board [2][4] == symbol) ||
    		    (board[4][0] == symbol && board [4][2] == symbol && board [4][4] == symbol) ){
    			//row
    			return true;
    		}
    				
    		else if((board[0][0] == symbol && board [2][0] == symbol && board [4][0] == symbol) ||
    		        (board[0][2] == symbol && board [2][2] == symbol && board [4][2] == symbol) ||
    			(board[0][4] == symbol && board [2][4] == symbol && board [4][4] == symbol) ) {
    			//column
    			return true;
    		}
    				
    		else if	((board[0][0] == symbol && board [2][2] == symbol && board [4][4] == symbol) ||
    		         (board[0][4] == symbol && board [2][2] == symbol && board [4][0] == symbol) ) {
    			//cross
    				return true;
    			}
    		else {
    			return false;
    		}  		
    	}
   
 
   //check game over
    	public static boolean isGameOver(char[][] b) {
    	   int c=0;
    	    for(int i=0;i<b.length;i++) {
    	    	for(int j=0;j<b[i].length;j++) {
    	    		if(b[i][j]==' ') {
    	    			return false;
    	    		}
    	    	}
    	    }
    	    	return true;
    	}
	
    	
}

    
	


