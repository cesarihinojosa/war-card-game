package hw2.coreobjects;

import java.util.ArrayList;
import java.util.List;

import hw2.coreobjects.Card.Rank;
import hw2.coreobjects.Card.Suit;

public class Deck {

    public List<Card> deckOfCards = new ArrayList<Card>();
    private Suit[] suits = Suit.values();
    private Rank[] ranks = Rank.values();
    private int numOfRanks = Rank.values().length;
    private int numOfSuits = Suit.values().length;
    private int numofCards = Suit.values().length * Rank.values().length;
    private static Deck deck = null;

    private Deck() {
        buildDeckOfCards();
    }

    private void buildDeckOfCards() {// change to priv
        crateBlankCards();
        assignValuesToCards();
    }

    private void crateBlankCards() {
        for (int i = 0; i < numofCards; i++) {
            Card card = new Card();
            deckOfCards.add(card);
        }
    }

    private void assignValuesToCards() {
        int deckIndex = 0;
        for(int i = 0; i < numOfSuits; i++){
            for(int j = 0; j < numOfRanks; j++){
                deckOfCards.get(deckIndex).setSuit(suits[i]);
                deckOfCards.get(deckIndex).setRank(ranks[j]);
                if(j < 10){
                    deckOfCards.get(deckIndex).setFaceValue(j+1);
                }
                else{
                    deckOfCards.get(deckIndex).setFaceValue(10);
                }
                deckIndex++;
            }
        }
    }

    public static Deck getInstance() {
        if (deck == null) {
            deck = new Deck();
        }
        return deck;
    }

}
