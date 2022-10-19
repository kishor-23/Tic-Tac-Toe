import java.util.Random;
import java.util.Scanner;

public class Tictactoe {
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		
		char[][] gameBoard= {{' ','|',' ','|',' '},
				             {'-','+','-','+','-' },
				             {' ','|',' ','|',' '},
				             {'-','+','-','+','-' },
				             {' ','|',' ','|',' '} };
		
		printGameBoard(gameBoard);
		String winner="";
		while(true) {
			System.out.println("enter the place(1-9):");
			int player_pos=sc.nextInt();
			
			while(!isValid(gameBoard,player_pos)) {
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
			while(!isValid(gameBoard,cpu_pos)) {
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
	public static void printGameBoard(char[][] a) {
		for (char[] i : a) {
			for(char c:i) {
				System.out.print(c+" ");
			}
			System.out.println();
			
		}
	}
	
//place piece
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
  //check the place is empty	
    	public static boolean isValid (char board[][],int pos )  {
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
 
        //game over
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
  
    	
    	
    	
    	
}

    
	


