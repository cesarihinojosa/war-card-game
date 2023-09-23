package hw2.coreobjects;

import java.util.ArrayList;
import java.util.List;

public class Player {
    
    String name;
    List<Card> pile;

    public Player(String name){
        this.name = name;
        pile = new ArrayList<Card>();
    }

    public String getName(){
        return name;
    }

    public List<Card> getPile(){
        return pile;
    }

    void setPile(List<Card> pile){
        this.pile = pile;
    }

    public void printPile(){
        for(int i = 0; i < pile.size(); i++){
            System.out.println(pile.get(i).getNameOfCard());
        }
    }

    public void addToPile(Card card){
    }

    public void turnCardOver(Card card){
    }

}
