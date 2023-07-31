package com.mycompany.tarea1;

public  class Deck {
    Card[] cards = new Card[52];
    String[] symbols = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    String[] suits = {"Picas","Corazones","Diamantes","Tréboles"};

    public Deck(){
        fillDeck();
    }
    public void fillDeck(){
        int aux = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards[aux] = new Card(symbols[j],suits[i],j+1);
                aux++;
            }
        }
    }
    public String datos(int x){
        return cards[x].getSymbol()+" de "+cards[x].getSuit();
    }
}
