package lets_grow_more;
import java.util.*;
public class Task2
{
		    static String[] brd;

		    static String turn;

		    static String checkWinner()
		    {
		        for (int a = 0; a < 8; a++) {

		            String line = null;

		            switch (a) {

		            case 0:
		                line = brd[0] + brd[1] + brd[2];
		                break;
		            case 1:

		                line = brd[3] + brd[4] + brd[5];

		                break;

		            case 2:

		                line = brd[6] + brd[7] + brd[8];

		                break;

		            case 3:

		                line = brd[0] + brd[3] + brd[6];

		                break;

		            case 4:

		                line = brd[1] + brd[4] + brd[7];

		                break;

		            case 5:

		                line = brd[2] + brd[5] + brd[8];

		                break;

		            case 6:

		                line = brd[0] + brd[4] + brd[8];

		                break;

		            case 7:

		                line = brd[2] + brd[4] + brd[6];

		                break;

		            }

		            //For X winner

		            if (line.equals("XXX")) {

		                return "X";

		            }

		            // For O winner

		            else if (line.equals("OOO")) {

		                return "O";

		            }

		        }

		        for (int a = 0; a < 9; a++) {

		            if (Arrays.asList(brd).contains( String.valueOf(a + 1))) {

		                break;

		            }

		            else if (a == 8) {

		                return "draw";

		            }

		        }
		 
		       // To enter the X Or O at the exact place on brd.

		        System.out.println("It's "+

				turn + "'s turn; to place, type a slot number " 

		           );

		        return null;

		    }
		   
		    static void printbrd()

		    {

		        System.out.println("|---|---|---|");

		        System.out.println("| " + brd[0] + " | "+ brd[1] + " | " + brd[2]  + " |");

		        System.out.println("|-----------|");

		        System.out.println("| " + brd[3] + " | " + brd[4] + " | " + brd[5] + " |");

		        System.out.println("|-----------|");

		        System.out.println("| " + brd[6] + " | " + brd[7] + " | " + brd[8] + " |");

		        System.out.println("|---|---|---|");

		    }
		 

		    public static void main(String[] args)

		    {

		        Scanner in = new Scanner(System.in);

		        brd = new String[9];

		        turn = "X";

		        String winner = null;
		 

		        for (int a = 0; a < 9; a++) {

		            brd[a] = String.valueOf(a + 1);

		        }
		        System.out.println("Welcome to 3x3 Tic Tac Toe.");

		        printbrd();
		 

		        System.out.println("X will play first. Enter a slot number to place X in:");
		 
		        while (winner == null) {

		            int numInput;
		           
		           // Exception handling.
		           // numInput will take input from user like from 1 to 9.
		           // If it is not in range from 1 to 9.
		           // then it will show you an error "Invalid input."

		            try {

		                numInput = in.nextInt();

		                if (!(numInput > 0 && numInput <= 9)) {

		                    System.out.println("Invalid slot number; choose another number : ");

		                    continue;

		                }

		            }

		            catch (InputMismatchException e) {

		                System.out.println("Invalid slot number; choose another number:");

		                continue;

		            }

		 
		            if (brd[numInput - 1].equals(

		                    String.valueOf(numInput))) {

		                brd[numInput - 1] = turn;

		                if (turn.equals("X")) {

		                    turn = "O";

		                }

		                else {

		                    turn = "X";

		                }
		 
		                printbrd();

		                winner = checkWinner();
		            }

		            else {
		                
		                System.out.println("Slot already taken; re-enter another slot number:");
		            }

		        }
		        
		       
		        if (winner.equalsIgnoreCase("draw")) {

		            System.out.println("OOPS! It's draw! Thanks for playing.");
		        }
		       

		        else {

		            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		        }

		      in.close();

		    }
}

