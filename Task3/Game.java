import java.io.*;

// This interface is used as a template for the games. As both games have a similar structure.

public interface Game {
    // The BufferedReader used throughout which checks the user input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // The random number generator used throughout for generating pseudo random numbers
    RandomInterface r = new LinearCongruentialGenerator();

    // Used to start and play the game
    void playGame() throws Exception;
    // Setting up the game
    void initialiseGame() throws Exception;
    // Running the main gamin
    void mainGame() throws Exception;
    // Checking the users outputs to see if they have won the game.
    void declareGameWinner() throws Exception;

}
