// cardsWithOOD
// Name: Sara Filipinas
// Date: 6/20/25 (June 20, 2025)

//package cardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

	// these are the data structures to hold our cards
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();


	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}

		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			// create a new card using 4 values from cards.txt
			// fields[0] = suit, fields[1] = name, fields[2] = value, fields[3] = picture
			Card newCard = new Card(fields[0].trim(), fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3].trim());
			deckOfCards.add(newCard);	
		}

		shuffle();

		//for(Card c: deckOfCards)
			//System.out.println(c);

		//deal the player 5 cards
		for(int i = 0; i < 4; i++) {
			playerCards.add(deckOfCards.remove(i));
		}
		
		System.out.println("players cards");
		for(Card c: playerCards)
			System.out.println(c);
		
		// added a print statement to compare and check face cards
		System.out.println("-- compareTo and isFaceCard test --");
		// add a test to compare first two cards
		if (playerCards.size() >= 2) {
			Card a = playerCards.get(0), b = playerCards.get(1);
			System.out.println(a + "vs" + b + " -> compare:" + a.compareTo(b));
		}
		// added a test to check if the first card is a face card
		for (Card c: playerCards) {
			System.out.println(c.getCardName() + (c.isFaceCard() ? " is a face card." : " is not a face card."));
		}


		System.out.println("pairs is " + checkFor2Kind());

	}//end main

	public static void shuffle() {

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.size(); i++) {
			int index = (int) (Math.random()*deckOfCards.size());
			Card c = deckOfCards.remove(index);
			//System.out.println("c is " + c + ", index is " + index);
			deckOfCards.add(c);
		}
	}

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {

		int count = 0;
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				if(current.equals(next))
					count++;
			}//end of inner for
			if(count == 1)
				return true;

		}//end outer for
		return false;
	}
}//end class
