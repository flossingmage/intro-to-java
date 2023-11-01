package ApCS;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * this program is a game of sevens
 * 10/31/2023
 * @auther Kevin Dobruskin
 */
public class sevens {
    private static ArrayList<Card> deck = new ArrayList<Card>();
    private static ArrayList<Player> players = new ArrayList<>();
    private static int count = 1;
public static void main(String[] args) {
    createDeck();
    shuffle();
    createPlayers();
    boolean win = false;
    while(!win){
        playerTurn(players.get(count % players.size()));
    System.out.println();
    }  
    // add all the cards to the players hand

    // each person goes clockwise by putting 7 of diamonds on the desk, no matter which suit, which is a start of the game

    // each person puts one card related to the number 7 (like 6 or 8) and it should be the same suit

    //if the person doesnt have a card to put, he skips a turn

    // the winner is the person that ends up with no cards left. 


}

private static void playerTurn(Player player){

} 

/**
 * Creates the deck of cards
 */
private static void createDeck() {
    String[] suits = {"♥", "♦", "♠", "♣"};
    String[] values = {"a", "2", "3", "4", "5", "6", "7", "8", "9", "10","j", "q", "k"};
    for (String suit : suits) {
        for (String value : values) {
            deck.add(new Card(suit, value));
        }
    }
}

/**
 * shuffles the deck
 */
private static void shuffle() {
    for (int i = 0; i < deck.size(); i++) {
        int random = (int) (Math.random() * deck.size());
        Card temp = deck.get(i);
        deck.set(i, deck.get(random));
        deck.set(random, temp);
    }

}

private static void createPlayers(){
    Scanner scan = new Scanner(System.in);
    System.out.print("enter the number of players: ");
    // make the player objects
    int numOfPlayers = scan.nextInt();
    for(int i = 0; i < numOfPlayers; i++){
        System.out.print("enter player " + i + ": " );
        players.add(new Player(scan.next()));
    }
    dealOutCards(numOfPlayers);
    scan.close();
}

private static void dealOutCards(int numOfPlayers){
    int count = 0;
    while (!deck.isEmpty()) {
        players.get(count % numOfPlayers).takeCard(deck.get(0));
        count++;
    }
}

}

class Card {
    private String suit;
    private String value;
    
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
     switch (value) {
        case "a":
            return 14; 
        case "k":
            return 13;
        case "q":
            return 12;
        case "j":
            return 11;    
        default:
        return Integer.valueOf(value);
     }
    }

    public String toString() {
        return value + " of " + suit;
    }
    
}

class Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private String name;
    
    public Player(String name){
     this.name = name;
    }

    public void takeCard(Card pickedUpCard){
    hand.add(pickedUpCard);
    }

    public String getName(){
        return name;
    }  

    public ArrayList<Card> getHand(){
        return hand;
    }

}