package hw2.coreobjects;

import java.util.ArrayList;
import java.util.List;

import hw2.coreobjects.Card.Rank;
import hw2.coreobjects.Card.Suit;

public class Deck {

    public List<Card> deckOfCards = new ArrayList<Card>();
    private Suit[] suits = Suit.values();
    private Rank[] ranks = Rank.values();
    private final int numOfSuits = suits.length;
    private final int numOfRanks = ranks.length;
    private final int numOfCardsInADeck = numOfSuits * numOfRanks;
    private final int faceCardValue = 10;
    private static Deck deck = null;

    private Deck() {
        buildDeckOfCards();
    }

    private void buildDeckOfCards() {
        createBlankCards();
        assignValuesToCards();
    }

    private void createBlankCards() {
        for (int i = 0; i < numOfCardsInADeck; i++) {
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
                if(j < 9){
                    deckOfCards.get(deckIndex).setFaceValue(j+2);
                }
                else if(j == 12){
                    deckOfCards.get(deckIndex).setFaceValue(11);
                }
                else{
                    deckOfCards.get(deckIndex).setFaceValue(faceCardValue);
                }
                deckIndex++;
            }
        }
    }

    Card removeCardFromDeck(){
        Card card = new Card();
        card = deckOfCards.get(deckOfCards.size() - 1);
        deckOfCards.remove(card);
        return card;
    }

    public int getSizeOfDeckOfCards(){
        return deckOfCards.size();
    }

    public static Deck getInstance() {
        if (deck == null) {
            deck = new Deck();
        }
        return deck;
    }

}
