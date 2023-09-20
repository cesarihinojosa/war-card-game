package hw2.coreobjects;

public class Card {

    private int faceValue;
    private String nameOfCard;

    public Card(int faceValue, String nameOfCard){
        this.faceValue = faceValue;
        this.nameOfCard = nameOfCard;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public String getNameOfCard() {
        return nameOfCard;
    }
    
}
