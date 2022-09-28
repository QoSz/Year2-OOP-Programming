import java.io.BufferedReader;
import java.io.InputStreamReader;

// Main game file to run the games
public class Main {

    // The buffer reader used get the users input and pass it to the ChosenGame method.
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        ChooseGame g = new ChooseGame();

        // Getting user input for the game they want to play.
        System.out.print("Card (c/C) or Die (d/D) game? ");
        String ans = br.readLine();

        // Making sure the input they have entered is correct otherwise they are prompted to check their input.
        try {
            g.ChosenGame(ans).playGame();
        } catch (Exception e) {
            System.out.println("Please check your input!");
        }
    }
}
