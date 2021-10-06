package com.company;

import java.util.Arrays;

public class Card {
    private final int rank;
    private final int suit;

    public Card (int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static final String[] RANKS = {
            null, "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static final String[] SUITS = {
            "Clubs", "Diamonds", "hearts", "Spades"};

    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

    public static Card[] makeDeck () {
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank=1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }

    public static boolean hasFlush(Card[] cards) {
        int clubs = 0;
        int diamonds = 0;
        int hearts = 0;
        int spades = 0;
        Card isClubs = new Card(0, 0);
        Card isDiamonds = new Card(0, 1);
        Card isHearts = new Card(0, 2);
        Card isSpades = new Card(0, 3);
        for (int i = 0; i < cards.length; i++) {
            if (isClubs.compareSuit(cards[i])) clubs++;
            else if (isDiamonds.compareSuit(cards[i])) diamonds++;
            else if (isHearts.compareSuit(cards[i])) hearts++;
            else if (isSpades.compareSuit(cards[i])) spades++;
        }
        if (clubs >= 5 || diamonds >= 5 || hearts >= 5 || spades >= 5) return true;
        else return false;
    }

    public static boolean hasRoyal(Card[] cards) {
        int isRoyal = 0;
        Card isTen = new Card(9, 0);
        Card isJack = new Card(10, 0);
        Card isQueen = new Card(11, 0);
        Card isKing = new Card(12, 0);
        Card isAce = new Card(13, 0);
        for (int i = 0; i < cards.length; i++) {
            if (isTen.compareRank(cards[i]) || isJack.compareRank(cards[i]) || isQueen.compareRank(cards[i]) ||
                    isKing.compareRank(cards[i]) || isAce.compareRank(cards[i])) {
                isRoyal++;
            }
        }
        if (isRoyal == 5 && hasFlush(cards)) {
            return true;
        }
        return false;
    }

    public static int binarySearch(Card[] cards, Card target) {
        int low = 0;
        int high = cards.length - 1;
        while (low <= high) {
            System.out.println(low + ", " + high);
            int mid = (low + high) / 2;
            int comp = cards[mid].compareTo(target);

            if (comp == 0) return mid;
            else if (comp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public int compareTo(Card that) {
        if (this.suit < that.suit) return -1;
        if (this.suit > that.suit) return 1;
        if (this.rank < that.rank) return -1;
        if (this.rank > that.rank) return 1;
        return 0;
    }

    public boolean compareSuit(Card that) {
        if (this.suit == that.suit) return true;
        else return false;
    }

    public boolean compareRank(Card that) {
        if (this.rank == that.rank) return true;
        else return false;
    }
}
