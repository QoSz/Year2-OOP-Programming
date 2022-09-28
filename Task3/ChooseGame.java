// This is a factory which return a game object based on the users input.
// If the user enters "c" the cardGame object is returned
// If the user enters "d" the dieGame object is returned

public class ChooseGame {

    // Method used to check the user input and return a game object based on the input
    public Game ChosenGame(String ans) {
        if (ans.equals("c") || ans.equals("C")) {
            return new CardGame();
        }

        else if (ans.equals("d") || ans.equals("D")) {
            return new DieGame();
        }

        else {
            // Making sure the sure does not enter an invalid input.
            System.out.println("Invalid input!");
            return null;
        }
    }
}
