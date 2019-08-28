/*
 * Game that randomly generates a character of the alphabet (Capital only) the
 * user is then prompted to enter a character, if the guess is correct, the game
 * will tell the user, if they are incorrect, the user is told if they are before
 * or after the guess and the user is prompted to make a new guess.
 *
 * @author Stewart
 * @version JAVA 8, 7/10/2019
 */

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class GuessALetter{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        ArrayList<Character> arr = new ArrayList<>();
        Random rand = new Random();

        System.out.println("Welcome to GuessALetter!");

        /* loops the game until the user says they want to exit the program at the end of the program */
        Boolean gameLoop = true;
        while(gameLoop){
            /* generates all values of the alphabet */
            arr.clear();
            for(char i = 'A'; i <= 'Z'; i++){
                arr.add(i);
            }
            /* generates a random index corasponding with a letter in the alphabet */
            int r = rand.nextInt(arr.size() - 1);
            char aws = arr.get(r);

            /* loops the game while the user guesses the value */
            char guess;
            Boolean loop = true;
            while(loop){
                /* try for the case where the user inputs an invalid input that would create an error */
                try{
                    /* 
                     * displays the alphabet for the user (me) to reference
                     * stops idiots (me) from having to recite the alphabet
                     */
                    System.out.println(arr);
                    /* prompts user for a letter to enter */
                    System.out.print("Guess a single letter: ");
                    /* casts the user input to upper case and then sets the character at index 0 to 'guess' */
                    guess = scan.next().toUpperCase().charAt(0);

                    /* 
                     * if the value of 'guess' is less than the first value found in 'arr'
                     * or the last value in 'arr', based on the ASCII tables, the value is
                     * invalid and the user is prompted to reenter a value. 
                     */
                    if(guess < (char) arr.get(0) || guess > (char) arr.get(arr.size() - 1)){
                        System.out.println("Please enter a valid character: A-Z");
                    } else if(guess == aws){
                        /* allows program to exit the while loop */
                        loop = false;
                        System.out.println("You Guessed The Value!");
                        /* asks user if they want to play again */
                        System.out.println("Would You Like To Play again?");
                        System.out.println("Yes/No");
                        String restart = scan.next();
                        /* if the user says they want to continue, the 'gameLoop' is left as 'true' */
                        if(restart.equals("Yes") || restart.equals("yes") || restart.equals("Y") || restart.equals("y")){
                            gameLoop = true;
                        /* if the user says 'no' or anything but 'yes' the 'gameLoop' will be set to 'false' and the game will be exited */
                        } else {
                            gameLoop = false;
                            System.out.println("Thanks For Playing!");
                        }
                    /*
                     * if the user 'guess' value is greater than or less than the value of 'aws,
                     * they are told if they are too high or low and the loop resets 
                     */
                    } else if(guess < aws){
                        System.out.println("Guess Is Too Low!");
                    } else {
                        System.out.println("Guess Is Too High!");
                    }
                    System.out.print("\n");
                    /* 
                     * if there are any errors with the value entered by the user, they are
                     * given an error message and reprompted to enter a guess 
                     */
                } catch(Exception e){
                    System.out.println("# -==-==- # -==-==- # -==-==- # -==-==- # -==-==- #");
                    System.out.println("ERROR: Invalid Input.");
                    System.out.println("# -==-==- # -==-==- # -==-==- # -==-==- # -==-==- #");
                }
            }
        }
    scan.close();
    }
}
