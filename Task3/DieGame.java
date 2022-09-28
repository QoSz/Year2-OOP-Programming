import java.util.HashSet;

public class DieGame implements Game{
    //Variable(s) used in the die game methods
    // Used to store the numbers rolled by the user
    public static HashSet<Integer> numbersRolled=new HashSet<Integer>();

    // Overrides game interface method with its own implementation
    @Override
    public void playGame() throws Exception {
        // Play die game:

        // Initialise the game
        initialiseGame();

        // Play the main game phase
        mainGame();

        // Now see if (s)he has won!
        declareGameWinner();

    }

    // Overrides game interface method with its own implementation
    @Override
    public void initialiseGame() throws Exception {
        // The initialisation phase:

        // Actually there isn't anything to do here
    }

    // Overrides game interface method with its own implementation
    @Override
    public void mainGame() throws Exception {
        // The main game:

        // Let the user roll the die twice
        for (int i=0; i<2; i++) {
            System.out.println("Hit <RETURN> to roll the die");
            br.readLine();
            // Random number is generated from 1 to 6 and that is the users roll.
            int dieRoll=(int)(r.next() * 6) + 1;

            System.out.println("You rolled " + dieRoll);
            numbersRolled.add(dieRoll);
        }

        // Display the numbers rolled
        System.out.println("Numbers rolled: " + numbersRolled);
    }

    // Overrides game interface method with its own implementation
    @Override
    public void declareGameWinner() throws Exception {
        // Declare the winner:

        // User wins the game if at least one of the die rolls is a 1
        if (numbersRolled.contains(1)) {
            System.out.println("You won!");
        }
        else System.out.println("You lost!");
    }
}
