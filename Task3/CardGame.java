import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// Card game class implement the game interface
public class CardGame implements Game {
    // Variable(s) used in the card game methods
    public static ArrayList<String> cardList;
    public static HashSet<String> cardsChosen=new HashSet<String>();

    // Overrides game interface method with its own implementation
    @Override
    public void playGame() throws Exception {
        // Play card game:

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
        String[] cards ={"AHrts", "2Hrts", "3Hrts", "4Hrts", "5Hrts", "6Hrts",
                "7Hrts", "8Hrts", "9Hrts", "10Hrts", "JHrts",
                "QHrts", "KHrts",
                "ADmnds", "2Dmnds", "3Dmnds", "4Dmnds", "5Dmnds",
                "6Dmnds", "7Dmnds", "8Dmnds", "9Dmnds", "10Dmnds",
                "JDmnds", "QDmnds", "KDmnds",
                "ASpds", "2Spds", "3Spds", "4Spds", "5Spds", "6Spds",
                "7Spds", "8Spds", "9Spds", "10Spds", "JSpds",
                "QSpds", "KSpds",
                "AClbs", "2Clbs", "3Clbs", "4Clbs", "5Clbs", "6Clbs",
                "7Clbs", "8Clbs", "9Clbs", "10Clbs", "JClbs",
                "QClbs", "KClbs"};

        // Taking advantage of "generics" to tell the compiler all the elements will be Strings
        cardList = new ArrayList<String>(Arrays.asList(cards));

        // Shuffle the cards by generating two random numbers and swapping the cards at those indexes.
        // This is done a 100 times.
        for (int i = 0; i < 100; i++) {
            int firstIndex = ((int) (r.next() * 52));
            int secondIndex = ((int) (r.next() * 52));
            String temp = cardList.get(firstIndex);
            cardList.set(firstIndex, cardList.get(secondIndex));
            cardList.set(secondIndex, temp);
        }

        // print out the shuffled cards
        System.out.println(cardList);

    }

    // Overrides game interface method with its own implementation
    @Override
    public void mainGame() throws Exception {
        // The main game:

        // Let user select two cards from the pack
        for (int i=0; i<2; i++) {
            System.out.println("Hit <RETURN> to choose a card");
            br.readLine();

            // Selecting a card from the deck based on the random number generated
            int cardChoice=(int) (r.next() * cardList.size());
            // Printing out the card chosen to the user
            System.out.println("You chose " + cardList.get(cardChoice));
            cardsChosen.add(cardList.remove(cardChoice));
        }

        // Display the cards chosen and remaining cards
        System.out.println("Cards chosen: " + cardsChosen);
        System.out.println("Remaining cards: " + cardList);
    }

    // Overrides game interface method with its own implementation
    @Override
    public void declareGameWinner() throws Exception {
        // Declare the winner:

        // User wins the game if one of their cards is an Ace card otherwise they loose.
        System.out.println("Cards chosen: " + cardsChosen);
        if (cardsChosen.contains("AHrts") || cardsChosen.contains("ADmnds") ||
                cardsChosen.contains("ASpds") || cardsChosen.contains("AClbs")) {
            System.out.println("You won!");
        }
        else System.out.println("You lost!");
    }
}
