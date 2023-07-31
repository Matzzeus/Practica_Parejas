package com.mycompany.tarea1;

public class Card {
    private String suit = "";
    private String symbol = "";
    private final int value;
    public Card(String symbol, String suit, int value){
        this.symbol = symbol;
        this. suit = suit;
        this.value = value;
    }
    public String getSuit() {
        return suit;
    }
    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

}
