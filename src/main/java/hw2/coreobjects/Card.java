package hw2.coreobjects;

public class Card {

    public enum Suit {
        spades,
        heart,
        diamond,
        club
    }
    public enum Rank {
        ace,
        two,
        three,
        four,
        five,
        six,
        seven,
        eight,
        nine,
        ten,
        jack,
        queen,
        king,
    }
    private Suit suit;
    private Rank rank;
    private int faceValue;
    private String nameOfCard;

    public Card() {
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit){
        this.suit = suit;
    }

    public Rank getRank(){
        return rank;
    }

    public void setRank(Rank rank){
        this.rank = rank;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue){
        this.faceValue = faceValue;
    }

    public String getNameOfCard() {
        setNameOfCard();
        return nameOfCard;
    }

    private void setNameOfCard(){
        this.nameOfCard = (new StringBuilder())
        .append(rank)
        .append(" of ")
        .append(suit)
        .append(": ")
        .append(faceValue)
        .toString();  
    }

}
