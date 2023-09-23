package hw2;

import org.junit.Test;

import hw2.coreobjects.Dealer;
import hw2.coreobjects.Deck;
import hw2.coreobjects.Player;

public class DealerTest {

    Deck deck = Deck.getInstance();
    Dealer dealer = Dealer.getInstance();

    private int chooseNumberOfPlayers(){
        return 2;
    }

    @Test
    public void TestDealCards(){
        int numOfPlayers = chooseNumberOfPlayers();

        Player[] players = assignPlayersArray(numOfPlayers);

        System.out.println("BEGIN TEST");
        System.out.println("\n");

        printOriginalDeck();
        dealer.dealCards(players, numOfPlayers);
        printPlayerPiles(players, numOfPlayers);
        printDeckAfter();

        System.out.println("\n");
        System.out.println("TEST END");
    }

    private Player[] assignPlayersArray(int numOfPlayers){
        Player[] players = new Player[numOfPlayers];
        for(int i = 0; i < numOfPlayers; i++){
            Player player = new Player(
                (new StringBuilder())
                .append("Player ")
                .append(i+1)
                .toString());
            players[i] = player;
        }
        return players;
    }

    private void printOriginalDeck(){
        System.out.println("--------ORIGINAL DECK--------");
        deck.printDeckOfCards();
        System.out.println("");
    }

    private void printPlayerPiles(Player[] players, int numOfPlayers){
        for(int i = 0; i < numOfPlayers; i++){
            System.out.println("--------" + players[i].getName() 
            + " CARDS--------");
            players[i].printPile();
            System.out.println("");
            System.out.println("Number of cards in pile: " + 
            players[i].getPile().size());
            System.out.println("");
        }
    }

    private void printDeckAfter(){
        System.out.println("--------DECK AFTER DEALING--------");
        deck.printDeckOfCards();
    }
    
}
