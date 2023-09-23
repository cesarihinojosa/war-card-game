package hw2.coreobjects;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private static Dealer dealer = null;
    private Deck deck;

    private Dealer(){
        deck = Deck.getInstance();
    }

    public static Dealer getInstance(){
        if (dealer == null) {
            dealer = new Dealer();
        }
        return dealer;
    }

    public void shuffleDeck(){
    }

    public void dealCards(Player[] players, int numberOfPlayers){
        fixDeckToNumOfPlayers(players, numberOfPlayers);
        int numOfCardsPerPlayer;
        numOfCardsPerPlayer = deck.getSizeOfDeckOfCards() / numberOfPlayers;

        for(int i = 0; i < numberOfPlayers; i++){
            List<Card> tempPile = new ArrayList<Card>();
            for(int j = 0; j < numOfCardsPerPlayer; j++){
                Card card = new Card();
                card = deck.removeCardFromDeck();
                tempPile.add(card);
            }
            players[i].setPile(tempPile);
        }
    }

    private void fixDeckToNumOfPlayers(Player[] players, int numberOfPlayers){
        int numOfCardsPerPlayer;
        numOfCardsPerPlayer = deck.getSizeOfDeckOfCards() / numberOfPlayers;

        int numCardsInPlay;
        numCardsInPlay = numOfCardsPerPlayer  * numberOfPlayers;

        int numOfCardsToThrowOut; 
        numOfCardsToThrowOut = deck.getSizeOfDeckOfCards() - numCardsInPlay;
        if(numOfCardsToThrowOut != 0){
            for(int i = 0; i < numOfCardsToThrowOut; i++){
                deck.removeCardFromDeck();
            }
        }
    }

}
