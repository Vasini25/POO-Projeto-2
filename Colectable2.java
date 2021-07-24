/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author flavi
 */
public class Colectable2 extends Elemento implements Colectable, Serializable {
    
    public Colectable2(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG);
        this.transponivel = true;
        mortal = true;
        coletavel = true;
        this.posicao.setPosicao(linha, coluna);
    }

    Colectable2(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }

    @Override
    public void Render() {
        this.autoDesenho();
    }
    
}
