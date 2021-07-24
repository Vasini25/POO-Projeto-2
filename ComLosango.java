/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controler.ControleDeJogo;
import java.io.Serializable;

/**
 *
 * @author flavi
 */
public class ComLosango extends Elemento implements Serializable, Losango{
    
    public ComLosango(String sNomeImagePNG){
        super(sNomeImagePNG);
    }

    @Override
    public boolean ContemLosango() {
        return true;
    }
    
    @Override
    public boolean moveUp() {
        boolean statusMovimento = this.posicao.moveUp();
        if (!ControleDeJogo.ehPosicaoValidaRelativa(this)) {
            voltaAUltimaPosicao();
            return false;
        }
        super.autoDesenho();
        return statusMovimento;
    }

    @Override
    public boolean moveDown() {
        boolean statusMovimento = this.posicao.moveDown();
        if (!ControleDeJogo.ehPosicaoValidaRelativa(this)) {
            voltaAUltimaPosicao();
            return false;
        }
        super.autoDesenho();
        return statusMovimento;
    }
    
    @Override
    public boolean moveRight() {
        boolean statusMovimento = this.posicao.moveRight();
        if (!ControleDeJogo.ehPosicaoValidaRelativa(this)) {
            voltaAUltimaPosicao();
            return false;
        }
        super.autoDesenho();
        return statusMovimento;
    }

    @Override
    public boolean moveLeft() {
        boolean statusMovimento = this.posicao.moveLeft();
        if (!ControleDeJogo.ehPosicaoValidaRelativa(this)) {
            voltaAUltimaPosicao();
            return false;
        }
        super.autoDesenho();
        return statusMovimento;
    }
}