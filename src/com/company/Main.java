package com.company;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        //Card[] cards = Card.makeDeck();
        //System.out.println(Arrays.toString(cards));
        //Card card = new Card(13, 3);
        //System.out.println(Card.binarySearch(cards, card));
        //System.out.println(card);

        Card[] hand = new Card[5];
        hand[0] = new Card(9, 0);
        hand[1] = new Card(10, 0);
        hand[2] = new Card(11, 0);
        hand[3] = new Card(12, 0);
        hand[4] = new Card(13, 0);
        /*
        for (int i = 0; i < 5; i++) {
            int randSuit = random.nextInt(3);
            // int randSuit = 0;
            int randRank = random.nextInt(13) + 1;
            hand[i] = new Card(randRank, randSuit);
        }
        */
        System.out.println(Arrays.toString(hand));
        System.out.println(Card.hasFlush(hand));
        System.out.println(Card.hasRoyal(hand));
    }
}

