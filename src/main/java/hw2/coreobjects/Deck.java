package hw2.coreobjects;

import java.util.List;

public class Deck {

    public static List<Card> deckOfCards;
    private static Deck deck = null;

    private Deck() {
        deckOfCards = generateDeck();
    }

    public static Deck getInstance() {
        if (deck == null) {
            deck = new Deck();
        }
        return deck;
    }

    private List<Card> generateDeck(){
        //write code to build the deck
        return null;
    }

}
