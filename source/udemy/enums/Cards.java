package udemy.enums;


import java.util.*;

public class Cards {

    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        Card ace = new Card(CardType.HEARTS, CardValue.ACE);
        cards.add(ace);
        cards.add(new Card(CardType.SPADES, CardValue.KING));
        cards.add(new Card(CardType.DIAMONDS, CardValue.QUIN));
        cards.add(new Card(CardType.CLUBS, CardValue.JACK));
        cards.add(new Card(CardType.SPADES, CardValue.NINE));
        cards.add(new Card(CardType.DIAMONDS, CardValue.SEVEN));
        cards.add(new Card(CardType.HEARTS, CardValue.SIX));

        System.out.println(ace.getKey().toString().compareTo(ace.getKey().toString()));
        System.out.println(cards);
        Collections.sort(cards, new CardKeyComparator());
        System.out.println(cards);
        Collections.sort(cards, new CardValueComparator());
        System.out.println(cards);
    }

}

class Card implements Map.Entry<CardType, CardValue> {

    private CardType cardType;
    private CardValue cardValue;
    private boolean isTrump; // козырь

    public Card(CardType cardType, CardValue cardValue, boolean isTrump) {
        this.cardType = cardType;
        this.cardValue = cardValue;
        this.isTrump = isTrump;
    }

    public Card(CardType cardType, CardValue cardValue) {
        this.cardType = cardType;
        this.cardValue = cardValue;
        this.isTrump = false;
    }

    @Override
    public CardType getKey() {
        return this.cardType;
    }

    @Override
    public CardValue getValue() {
        return this.cardValue;
    }

    @Override
    public CardValue setValue(CardValue value) {
        this.cardValue = value;
        return this.cardValue;
    }

    @Override
    public String toString() {
        return this.cardType + " : " + this.cardValue + " (" + this.cardValue.getValue() + ")";
    }
}

class CardKeyComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        return card1.getKey().compareTo(card2.getKey());
    }
}

class CardValueComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return card1.getValue().getValue() - card2.getValue().getValue();
    }
}

enum CardType {

    DIAMONDS, // бубны
    HEARTS, // черви
    CLUBS, // трефы
    SPADES; // пики
}

enum CardValue {

    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUIN(12),
    KING(13),
    ACE(14);


    private final int value;

    private CardValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
