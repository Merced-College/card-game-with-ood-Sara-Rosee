// cardsWithOOD
// Name: Sara Filipinas
// Date: 6/20/25 (June 20, 2025)
// What I added:
// I added a card class with constructors, accessors, mutators, and toString methods  
// I added ASCII symbols (♥, ♦, ♣, ♠) to the cards based on the suit to create a visually appealing display when printed


public class Card {
    private String cardSuit;
    private String cardName;
    private int cardValue;
    private String cardPicture;
    // I added ASCII art representation of the card, stores the suit symbol (♥, ♦, ♣, ♠) for visual display.
    private String cardArt;

    // Default constructor
    public Card() {
        this.cardSuit = "";
        this.cardName = "";
        this.cardValue = 0;
        this.cardPicture = "";
    }

    // Parameterized constructor
    // added cardArt to the constructor to assign the ASCII art based on the suit
    public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
        this.cardSuit = cardSuit;
        this.cardName = cardName;
        this.cardValue = cardValue;
        this.cardPicture = cardPicture;
        this.cardArt = assignArt(cardSuit); // auto-generate card art symbol
    }

    // Accessors (getters)
    public String getCardSuit() {
        return cardSuit;
    }

    public String getCardName() {
        return cardName;
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getCardPicture() {
        return cardPicture;
    }

    // Mutators (setters)
    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public void setCardPicture(String cardPicture) {
        this.cardPicture = cardPicture;
    }
    // Added a method to assign ASCII art based on the suit
    // example: assignArt("hearts") returns "♥"
    private String assignArt(String suit) {
        switch (suit.toLowerCase()) {
            case "hearts":
                return "♥";
            case "diamonds":
                return "♦";
            case "clubs":
                return "♣";
            case "spades":
                return "♠";
            default:
                return "?"; // Unknown suit
        }
    }
    // Added a getter for cardArt, returns the visual symbol
    public String getCardArt() {
        return cardArt;
    }

    // toString method
    @Override
    public String toString() {
        return cardArt + cardName + " of " + cardSuit + " (Value: " + cardValue + ")";
    }
}