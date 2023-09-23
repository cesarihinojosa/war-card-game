package hw2;

import org.junit.Test;

import hw2.coreobjects.Dealer;
import hw2.coreobjects.Deck;
import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;

public class GameRoundVersionOneTest {

    GameOfWar gameOfWar = new GameOfWarVersionOne();
    Deck deck = Deck.getInstance();

    @Test
    public void TestPlayingRounds(){

        printStartingStuff();

        Dealer.getInstance().shuffleDeck();
        printDeck();

        gameOfWar.setupGame.setup(gameOfWar.players);

        printPiles();

        for(int i = 0; i < 10; i++){
            int winnerIndex;
            winnerIndex = gameOfWar.gameRound.playRound(gameOfWar.players);
            printCurrentStatusRound(i+1, winnerIndex);
        }
    }

    private void printStartingStuff(){
        System.out.println("TEST BEGINS");
        System.out.println("\n");
        System.out.println("--------------GAME OF WAR--------------");
        System.out.println("");
        System.out.println("Number of players: " + 
        gameOfWar.players.length);
        System.out.println("Deck: ");
        deck.printDeckOfCards();
        System.out.println("");
        for(int i = 0; i < gameOfWar.players.length; i++){
            System.out.println(gameOfWar.players[i].getName() +
            " pile (before dealing): ");
            gameOfWar.players[i].printPile(gameOfWar.players[i].getPile());
        }
        System.out.println("");
    }

    private void printDeck(){
        System.out.println("Deck (after shuffling): ");
        deck.printDeckOfCards();
        System.out.println("");
    }

    private void printPiles(){
        for(int i = 0; i < gameOfWar.players.length; i++){
            System.out.println(gameOfWar.players[i].getName() +
            " pile: ");
            gameOfWar.players[i].printPile(gameOfWar.players[i].getPile());
            System.out.println("");
        }
    }

    private void printCurrentStatusRound(int roundNumber, int winnerIndex){
        System.out.println("ROUND " + roundNumber);
        System.out.println("");
        for(int i = 0; i < gameOfWar.players.length; i++){
            System.out.println(gameOfWar.players[i].getName() +
            "'s card: " +
            gameOfWar.players[i].getCardInPlay().getNameOfCard());

            System.out.println("Number of cards in " +
            gameOfWar.players[i].getName() +
            "'s pile: " + 
            gameOfWar.players[i].getPile().size());
        }
        if(winnerIndex < 0){
            System.out.println("WAR!!!!!!!!");
        }
        else{
            System.out.println("Winner: " + 
            gameOfWar.players[winnerIndex].getName());
        }

        System.out.println("");
        System.out.println("END OF ROUND");
    }

}
