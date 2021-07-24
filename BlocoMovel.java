package Modelo;

import java.io.Serializable;

public class BlocoMovel extends Elemento implements Serializable{
    
    public Color cor;
    public Losango los;
            
    public BlocoMovel(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.mortal = false;
        this.transponivel = false;
        
        this.arrastavel = true;
        this.quebravel = false;
        movel = true;
    }
    
    public BlocoMovel(String sNomeImagePNG, int linha, int coluna, Color cor, Losango los) {
        this(sNomeImagePNG);
        this.posicao.setPosicao(linha, coluna);
        this.transponivel = false;
        this.mortal = false;
        this.movel = true;
        this.cor = cor;
        this.quebravel = this.cor.DefinidoPelaCor();
        this.los = los;
        this.arrastavel = this.los.ContemLosango();
        movel = this.los.ContemLosango();
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
    
    // Sobrescrevendo os metodos de movimentacao, ja que a interacao de ser
    // empurravel eh especifica desse metodo e dos vermelhos empurraveis, 
    // que serao descendentes dessa classe.
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