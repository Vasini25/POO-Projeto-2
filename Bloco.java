/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import Controler.ControleDeJogo;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author flavi
 */
public class Bloco extends Elemento implements Serializable, Cloneable{
    
    public Color cor;
    public Losango los;
    
    public Bloco(String sNomeImagePNG, int linha, int coluna, Color cor, Losango los){
        super(sNomeImagePNG);
        this.posicao.setPosicao(linha, coluna);
        this.cor = cor;
        quebravel = this.cor.DefinidoPelaCor();
        this.los = los;
        arrastavel = this.los.ContemLosango();
    }
    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
    
    /*@Override
    public boolean moveUp() {
        boolean statusMovimento = this.posicao.moveUp();
        if (!ControleDeJogo.ehPosicaoValidaRelativa(this)) {
            voltaAUltimaPosicao();
            return false;
        }
        return statusMovimento;
    }

    @Override
    public boolean moveDown() {
        boolean statusMovimento = this.posicao.moveDown();
        if (!ControleDeJogo.ehPosicaoValidaRelativa(this)) {
            voltaAUltimaPosicao();
            return false;
        }
        return statusMovimento;
    }
    
    @Override
    public boolean moveRight() {
        boolean statusMovimento = this.posicao.moveRight();
        if (!ControleDeJogo.ehPosicaoValidaRelativa(this)) {
            voltaAUltimaPosicao();
            return false;
        }
        return statusMovimento;
    }

    @Override
    public boolean moveLeft() {
        boolean statusMovimento = this.posicao.moveLeft();
        if (!ControleDeJogo.ehPosicaoValidaRelativa(this)) {
            voltaAUltimaPosicao();
            return false;
        }
        return statusMovimento;
    }*/
}