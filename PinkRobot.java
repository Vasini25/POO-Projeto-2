/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controler.ControleDeJogo;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author flavi
 */
public class PinkRobot extends Elemento implements Robot, Serializable {
    
    private Random rand;
    private int randomNumber;
    
    public PinkRobot(int linha, int coluna) {
        super("PinkRobot.png");
        this.mortal = false;
        this.transponivel = false;
        this.assassino = true;
        rand = new Random();    
        randomNumber = rand.nextInt(4); 
        this.posicao.setPosicao(linha, coluna);
    }

    PinkRobot() {
        super("PinkRobot.png");
    }
    
    @Override
    public void autoDesenho(){
        switch (randomNumber) {
            case 0 -> posicao.moveRight();
            case 1 -> posicao.moveDown();
            case 2 -> posicao.moveLeft();
            case 3 -> posicao.moveUp();
            default -> {
            }
        }
        
        if (!ControleDeJogo.ehPosicaoValidaRelativa(this)) {
            voltaAUltimaPosicao();
        }

        super.autoDesenho();
        
        rand = new Random();
        randomNumber = rand.nextInt(4);   
    }

    @Override
    public void Render() {
        
        this.autoDesenho();
        
    }
    
}
