package com.mycompany.tarea1;

public class Card {
    private String suit = "";
    private String symbol = "";
    public Card(String symbol, String suit){
        this.symbol = symbol;
        this. suit = suit;
    }
    public String getSuit() {
        return suit;
    }
    public String getSymbol() {
        return symbol;
    }
}
