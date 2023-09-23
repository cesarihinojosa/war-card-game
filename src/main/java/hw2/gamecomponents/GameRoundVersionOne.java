package hw2.gamecomponents;

import hw2.coreobjects.Player;

public class GameRoundVersionOne implements GameRound{

    @Override
    public int playRound(Player[] players){
        int highestFaceValue = 0;
        for(int i = 0; i < players.length; i++){
            players[i].playCard();
            if(players[i].getCardInPlay().getFaceValue() > highestFaceValue){
                highestFaceValue = players[i].getCardInPlay().getFaceValue();
            }
        }
        int numberOfWinners = 0;
        int indexOfWinner = -5;
        for(int i = 0; i < players.length; i++){
            if(highestFaceValue == players[i].getCardInPlay().getFaceValue()){
                indexOfWinner = i;
                numberOfWinners++;
            }
        }

        if(numberOfWinners > 1){
            return -1;
        }
        else{
            return indexOfWinner;
        }
    }
    
}