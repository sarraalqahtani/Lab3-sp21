import java.util.Random;
import java.util.Scanner;

public class Main {
    // main switchboard
    public void run(){
        System.out.println("Welcome to Blind Man's Bluff");
        boolean play, invalid, guessedHigher = false;
        String response;
        int compValue, userValue, nWin = 0, nLoss = 0, nTie = 0;
        Scanner sc= new Scanner(System.in);
        play = true;
        Random rand = new Random();
        while(play) {
            // assign values to computer and user
            compValue = rand.nextInt(52);
            userValue = rand.nextInt(52);

            // get user's bet
            System.out.println( "Computer's value is "+ compValue);
            invalid = true;
            while(invalid) {
                System.out.println( "Do you think your number is higher or lower? (H/L)");
                response=sc.next();
                if (response.toUpperCase().charAt(0) == 'H') {
                    // continue playing
                    guessedHigher = true;
                    invalid = false;
                } else if (response.toUpperCase().charAt(0) == 'L') {
                    // break out of while(play) loop
                    guessedHigher = false;
                    invalid = false;
                } else {
                    // invalid response, ask again
                    System.out.println("Invalid response...");
                    invalid = true;
                }
            }

            // determine outcome
            if((compValue < userValue && guessedHigher) || (compValue > userValue && !guessedHigher)) {
                System.out.println("Great! You're right:");
                nWin++;
            } else if((compValue > userValue && guessedHigher) || (compValue < userValue && !guessedHigher)) {
                System.out.println("Sorry, you're wrong:");
                nLoss++;
            } else {
                System.out.println("It's a tie:");
                nTie++;
            }
            System.out.println("your value is "+ userValue);

            // ask user to play again
            invalid = true;
            while(invalid) {
                System.out.println("Play again? (Y/N)");
                response=sc.next();
                if (response.toUpperCase().charAt(0) == 'Y') {
                    // continue playing
                    play = true;
                    invalid = false;
                } else if (response.toUpperCase().charAt(0)=='N') {
                    // break out of while(play) loop
                    play = false;
                    invalid = false;
                } else {
                    // invalid response, ask again
                    System.out.println("Invalid response..." );
                    invalid = true;
                }
            }
        }

        // output stats
        System.out.println("Thanks for playing!");
        System.out.println("Your record was " + nWin + "-" + nLoss + "-" + nTie +" (W-L-T)" );
    }

    public static void main(String[] args) {

        new Main().run();
    }

}
