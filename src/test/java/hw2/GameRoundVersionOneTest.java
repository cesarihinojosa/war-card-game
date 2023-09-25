package hw2;

import org.junit.Test;

import hw2.coreobjects.Dealer;
import hw2.coreobjects.Deck;
import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;

public class GameRoundVersionOneTest {

    GameOfWar gameOfWar = new GameOfWarVersionOne();
    Dealer dealer = Dealer.getInstance();
    Deck deck = Deck.getInstance();
    PrintGameExtra printGameExtra = new PrintGameExtra();

    @Test
    public void TestPlayingRounds() {
        printStartingStuff();
        dealer.shuffleDeck();
        printDeck();
        gameOfWar.setupGame.setup(gameOfWar.players);
        printPiles();
        PlayAndPrintRounds();
        printEndOfTest();
    }

    private void printStartingStuff() {
        System.out.println("TEST BEGINS");
        System.out.println("\n");
        System.out.println("--------------GAME OF WAR--------------");
        System.out.println("");
        System.out.println("Number of players: " +
                gameOfWar.players.length);
        System.out.println("Deck: ");
        printGameExtra.printDeck();
        System.out.println("");
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    " pile (before dealing): ");
            printGameExtra.printPile(gameOfWar.players[i]);
        }
        System.out.println("");
    }

    private void printDeck() {
        System.out.println("Deck (after shuffling): ");
        printGameExtra.printDeck();
        System.out.println("");
    }

    private void printPiles() {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    " pile: ");
            printGameExtra.printPile(gameOfWar.players[i]);
            System.out.println("");
        }
    }

    private void PlayAndPrintRounds() {
        for (int i = 0; i < 20; i++) {
            if (checkIfPileNull()) {
                break;
            }
            int winnerIndex = gameOfWar.gameRound.playRound(gameOfWar.players);
            printStartOfRound(i + 1);
            printCardsInPlay(i + 1, winnerIndex);
            printWinner(winnerIndex);
            printPileAmount();
            printEndOfRound();
        }
    }

    private boolean checkIfPileNull() {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            if (gameOfWar.players[i].getPile().size() == 0) {
                System.out.println(gameOfWar.players[i].getName() +
                        " pile is EMPTY!!");
                return true;
            }
        }
        return false;
    }

    private void printStartOfRound(int roundNumber) {
        System.out.println("ROUND " + roundNumber);
        System.out.println("");
    }

    private void printCardsInPlay(int roundNumber, int winnerIndex) {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    "'s card: " +
                    gameOfWar.players[i].getPreviousCardInPlay().getNameOfCard());
        }
    }

    private void printPileAmount() {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println("Number of cards in " +
                    gameOfWar.players[i].getName() +
                    "'s pile: " +
                    gameOfWar.players[i].getPile().size());
        }
    }

    private void printWinner(int winnerIndex) {
        if (winnerIndex < 0) {
            System.out.println("WAR!!!!!!!!");
        } else {
            System.out.println("Winner: " +
                    gameOfWar.players[winnerIndex].getName());
        }
    }

    private void printEndOfRound() {
        System.out.println("");
        System.out.println("END OF ROUND");
    }

    private void printEndOfTest() {
        System.out.println("");
        System.out.println("END OF TEST");
    }

}
