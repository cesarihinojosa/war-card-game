package hw2;

import hw2.coreobjects.Deck;
import hw2.coreobjects.Player;

public class PrintGameExtra {

    Deck deck = Deck.getInstance();

    public void printTestStart() {
        System.out.println("\n");
        System.out.println("BEGIN TEST");
    }

    public void printTestEnd() {
        System.out.println("END TEST");
        System.out.println("\n");
    }

    public void printDeck() {
        System.out.println();
        System.out.println("Deck: ");
        if (deck.getSizeOfDeckOfCards() == 0) {
            System.out.println("<< deck is empty >>");
        } else {
            for (int i = 0; i < deck.getSizeOfDeckOfCards(); i++) {
                System.out.println(deck.deckOfCards.get(i).getNameOfCard());
            }
        }
        System.out.println();
    }

    public void printPlayers(Player[] players) {
        System.out.println();
        System.out.println("Number of players: " + players.length);
        System.out.println("Players: ");
        for (int i = 0; i < players.length; i++) {
            System.out.println("    " + players[i].getName());
        }
    }

    public void printPlayersDetail(Player[] players) {
        System.out.println();
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName() + "'s info:");
            System.out.println("Pile size: " + players[i].getPile().size());
        }
    }

    public void printPiles(Player[] players) {
        System.out.println();
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName() + "'s pile: ");
            if (players[i].pile.size() == 0) {
                System.out.println("<<pile is empty>>");
            }
            for (int j = 0; j < players[i].pile.size(); j++) {
                System.out.println(players[i].pile.get(j).getNameOfCard());
            }
        }
    }

}
