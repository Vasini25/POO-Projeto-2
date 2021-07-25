/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author flavi
 */
public class Facede {
    
    private Random rand;
    private int randomNumber;
    
    public Facede (){
    }
    
    public Object RandomColectable(int x, int y){
        
        rand = new Random();    
        randomNumber = rand.nextInt(8);
        
        if(randomNumber==0) {
            return new Colectable1("Cherry.png", x, y);
        }
        else if(randomNumber==1){
            return new Colectable2("Grape.png", x, y);
        }
        else if(randomNumber==2){
            return new Colectable3("Lemon.png", x, y);
        }
        else if(randomNumber==3){
            return new Colectable4("Strawberry.png", x, y);
        }
        else if(randomNumber==4) {
            return new Colectable1("Sun.png", x, y);
        }
        else if(randomNumber==5){
            return new Colectable2("Candle.png", x, y);
        }
        else if(randomNumber==6){
            return new Colectable3("lightbulb.png", x, y);
        }
        else if(randomNumber==7){
            return new Colectable4("Flashlight.png", x, y);
        }
        return null;  //nunca vai ocorrer!!
    }
}