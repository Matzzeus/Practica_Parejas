package com.mycompany.tarea1;

import java.util.Scanner;

public class Game3 {
    Scanner scanner = new Scanner(System.in);
    Deck deck;
    double moneyPlayer = 0;

    public Game3(){
        deck = new Deck();
    }
    public void enterGame() {
        String line = "";
        do {
            System.out.println("\nIngresa la cantidad de Dinero con la que quiere entrar a la mesa:");
            line = scanner.nextLine();
            if (isNumber(line)) {
                moneyPlayer = Integer.parseInt(line);
            } else {
                System.out.println("\nIngresa un número porfavor");
            }
        } while (!isNumber(line));

    }

    public void game(){
        enterGame();
        do{
            showCards();
        }while (moneyPlayer>0);
        System.out.println("\nTerminó el juego, te quedaste sin dinero");
    }

    public void showCards(){
        String line;
        int firstCard, secondCard, thirdCard, response=0;
        double bet = 0;
        int value1, value2, value3;
        firstCard = randomNumber();
        do{
            secondCard = randomNumber();
        }while(firstCard == secondCard);
        System.out.println("\nMostrando las cartas\n\t"+deck.datos(firstCard)+"\n\t"+deck.datos(secondCard));
        System.out.println("\n¿El valor de la carta que vendrá estará entre estas dos?\n\t1. Si\t2. No");
        do{
            line = scanner.nextLine();
            if(isNumber(line)){
                response = Integer.parseInt(line);
            }
            else {
                System.out.println("\nELija 1 o 2 ¡porfavor!\n\t1. SI\t2. NO");
            }
        } while(!isNumber(line) || !validNumber(response));
        do{
            thirdCard = randomNumber();
        }while (thirdCard==firstCard || thirdCard==secondCard);
        bet = bet();
        System.out.println("\nLa tercera carta es: "+deck.datos(thirdCard));
        value1 = deck.cards[firstCard].getValue();
        value2 = deck.cards[secondCard].getValue();
        value3 = deck.cards[thirdCard].getValue();
        if(value1<value2){
            if(value3>=value1 && value3<=value2){
                if(response == 1){
                    win(bet);
                }
                else if(response == 2){
                    lose(bet);
                }
            }
            else{
                if(response == 1){
                    lose(bet);
                }
                else if(response == 2){
                    win(bet);
                }
            }
        }
        else if(value1>value2){
            if(value3>=value2 && value3<=value1){
                if(response == 1){
                    win(bet);
                }
                else if(response == 2){
                    lose(bet);
                }
            }
            else{
                if(response == 1){
                    lose(bet);
                }
                else if(response == 2){
                    win(bet);
                }
            }
        }
        else {
            if(value3 == value1){
                if(response == 1){
                    win(bet);
                }
                else if(response == 2){
                    lose(bet);
                }
            }
            else{
                if(response == 1){
                    lose(bet);
                }
                else if(response == 2){
                    win(bet);
                }
            }
        }
    }
    public double bet(){
        String line;
        double bet = 0;
        do{
            System.out.println("¿Cuánto desea apostar?\tSaldo actual: Q"+moneyPlayer);
            line = scanner.nextLine();
            if(isNumber(line)){
                bet = Double.parseDouble(line);
                if(bet<=moneyPlayer){
                    return bet;
                }
                else{
                    System.out.println("\nNo puedes apostar dinero que no tienes");
                }
            }
        }while(!isNumber(line) || bet>moneyPlayer);
        return bet;
    }
    public void win(double bet){
        moneyPlayer = moneyPlayer+bet;
        System.out.println("\nGANASTE ---> +Q"+bet+"\nSaldo actual: Q"+moneyPlayer);
    }
    public void lose(double bet){
        moneyPlayer = moneyPlayer-bet;
        System.out.println("\nPERDISTE ---> -Q"+bet+"\nSaldo actual: Q  "+moneyPlayer);
    }
    public int randomNumber(){
        return (int)(Math.random()*52+1);
    }
    public boolean isNumber(String number){
        try{
            Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean validNumber(int number){
        return number == 1 || number == 2;
    }

}
