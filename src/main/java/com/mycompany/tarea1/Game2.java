package com.mycompany.tarea1;

import java.util.Scanner;

public class Game2 {
    Scanner scanner = new Scanner(System.in);
    String player1, player2;
    int turns, pointsPJ1 = 0, pointsPJ2 = 0;

    public Game2(){

    }

    public void Game(){

    }

    public void enterPlayers(){
        System.out.println("Introduzca el nombre de los jugadores\n\nJugador 1:");
        player1 = scanner.nextLine();
        System.out.println("\nJugador 2:");
        player2 = scanner.nextLine();
    }

    public void enterTurns(){
        String numero;
        System.out.println("\nIngrese la cantidad de turnos que tendrá cada jugador:");
        do{
            numero = scanner.nextLine();
            if(isNumber(numero)){
                turns = Integer.parseInt(numero);
            }
            else{
                System.out.println("\nIngrese un número para los turnos:");
            }
        } while (!isNumber(numero));
    }

    public void turns(String player1, String player2){
        int attackType, defensType, attackOption=0, defenseOption=0;
        boolean turn1 = true;
        for (int i = 0; i < turns; i++) {
            for (int j = 0; j < 2; j++) {
                String number;
                if(turn1){
                    System.out.println("\n"+player1+": Te toca atacar");
                    do{
                        System.out.println("1. Salto largo\t2. Salto corto");
                        number = scanner.nextLine();
                        if(isNumber(number)){
                            attackOption = Integer.parseInt(number);
                        }
                    } while(isNumber(number) && validNumber(1,2,attackOption));

                    turn1 = false;
                }
                else{
                    turn1 = true;
                }
            }
        }
    }

    public void actions(int type){

    }
    public void attack(int type, String player, int defenseType){
        if(type == 1){ //Salto largo +3 puntos
            if(defenseType == 1){
                if(randomNumber()<51){
                    System.out.println("\n"+player+": Anotó en un salto largo\t+3 puntos");
                }
                else{
                    System.out.println("\n"+player+": Falló el tiro\t+0 puntos");
                }
            }
            else if(defenseType == 2){
                if(randomNumber()<36){
                    System.out.println("\n"+player+": Anotó en un salto largo\t+3 puntos");
                }
                else{
                    System.out.println("\n"+player+": Falló el tiro\t+0 puntos");
                }
            }
        }
        else if(type == 2){ //Salto corto +2 puntos
            if(defenseType==1){
                if(randomNumber()<66){
                    System.out.println("\n"+player+": Anotó en un salto corto\t+2 puntos");
                }
                else{
                    System.out.println("\n"+player+": Falló el tiro\t+0 puntos");
                }
            }
            else if(defenseType==2){
                if(randomNumber()<51){
                    System.out.println("\n"+player+": Anotó en un salto corto\t+2 puntos");
                }
                else{
                    System.out.println("\n"+player+": Falló el tiro\t+0 puntos");
                }
            }

        }
        else if(type == 3){ // Tiro Libre +2 puntos
            if(randomNumber()<91){
                System.out.println("\n"+player+": Anotó en un tiro libre\t+3 puntos");
            }
            else{
                System.out.println("\n"+player+": Falló el tiro libre\t+0 puntos");
            }
        }
    }

    public void defense(int type, String player, boolean foult){
        if(type == 1){
            if(randomNumber()<36){
                System.out.println("\n"+player+": Realizó defensa cuerpo a cuerpo\nProvocó una falta");
                foult = true;
            }
            else{
                System.out.println("\n"+player+": Realizó defensa cuerpo a cuerpo");
                foult = false;
            }
        }
        else{
            if(randomNumber()<66){
                System.out.println("\n"+player+": Realizó defensa fuerte\nProvocó una falta");
                foult = true;
            }
            else{
                System.out.println("\n"+player+": Realizó defensa fuerte");
                foult = false;
            }
        }
    }

    public boolean isNumber(String number){
        try{
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean validNumber(int start, int fin, int number){
        return number >= start && number <= fin;
    }

    public int randomNumber(){
        return (int)(Math.random()*100+1);
    }

    public static void main(String[] args) {
        Game2 game2 = new Game2();

    }
}
