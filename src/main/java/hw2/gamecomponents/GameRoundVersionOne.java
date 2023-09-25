package hw2.gamecomponents;

import hw2.coreobjects.Player;

public class GameRoundVersionOne implements GameRound{

    @Override
    public int playRound(Player[] players){
        playCards(players);
        int highestCard = determineHighestCard(players);
        int indexOfWinner = determineWinner(players, highestCard);
        int numberOfWinners = countNumberOfWinners(players, highestCard);
    
        if(numberOfWinners > 1){ //war
            clearCardsInPlay(players);
            return -1;
        }
        else{
            giveCardsToWinner(players, indexOfWinner);
            return indexOfWinner;
        }
    }

    private void playCards(Player[] players){
        for(int i = 0; i < players.length; i++){
            players[i].playCard();
        }
    }

    private int determineHighestCard(Player[] players){
        int highestCard = 0;
        for(int i = 0; i < players.length; i++){
            if(players[i].getCardInPlay().getFaceValue() > highestCard){
                highestCard = players[i].getCardInPlay().getFaceValue();
            }
        }
        return highestCard;
    }

    private int determineWinner(Player[] players, int highestCard){
        int indexOfWinner = -5;
        for(int i = 0; i < players.length; i++){
            if(highestCard == players[i].getCardInPlay().getFaceValue()){
                indexOfWinner = i;
            }
        }
        return indexOfWinner;
    }

    private int countNumberOfWinners(Player[] players, int highestCard){
        int numberOfWinners = 0;
        for(int i = 0; i < players.length; i++){
            if(highestCard == players[i].getCardInPlay().getFaceValue()){
                numberOfWinners++;
            }
        }
        return numberOfWinners;
    }

    private void clearCardsInPlay(Player[] players){
        for(int i = 0; i < players.length; i++){
            players[i].setCardInPlay(null);
        }
    }

    private void giveCardsToWinner(Player[] players, int indexOfWinner){
        for(int i = 0; i < players.length; i++){
            players[indexOfWinner].getPile().add(players[i].getCardInPlay());
            players[i].setCardInPlay(null);
        }
    }
    
}