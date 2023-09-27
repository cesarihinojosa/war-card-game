package hw2.coreobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Dealer {

    private Deck deck;
    private static Dealer dealer = null;

    public static Dealer getInstance(){
        if (dealer == null) {
            dealer = new Dealer();
        }
        return dealer;
    }

    private Dealer(){
        deck = Deck.getInstance();
    }

    public void shuffleDeck(){
        Random random = new Random();
        for(int i = 0; i < deck.deckOfCards.size(); i++){
            int randomInt = random.nextInt(deck.deckOfCards.size());
            Collections.swap(deck.deckOfCards, i, randomInt);
        }
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
