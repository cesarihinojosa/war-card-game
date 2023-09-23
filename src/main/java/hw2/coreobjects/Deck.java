package hw2.coreobjects;

import java.util.ArrayList;
import java.util.List;

import hw2.coreobjects.Card.Rank;
import hw2.coreobjects.Card.Suit;

public class Deck {

    public List<Card> deckOfCards = new ArrayList<Card>();
    private Suit[] suits = Suit.values();
    private Rank[] ranks = Rank.values();
    private int numOfSuits = suits.length;
    private int numOfRanks = ranks.length;
    private int numOfCardsInADeck = numOfSuits * numOfRanks;
    private int maxFaceValue = 10;

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
                if(j < 10){
                    deckOfCards.get(deckIndex).setFaceValue(j+1);
                }
                else{
                    deckOfCards.get(deckIndex).setFaceValue(maxFaceValue);
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

    public void printDeckOfCards(){
        if(getSizeOfDeckOfCards() == 0){
            System.out.println("<< deck is empty >>");
        }
        else{
            for(int i = 0; i < getSizeOfDeckOfCards(); i++){
                System.out.println(deckOfCards.get(i).getNameOfCard());
            }
        }
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
