package Modelo;

import java.io.Serializable;

public class StaticBlock extends Elemento implements Serializable{
    
    public Color cor;
    public Losango los;
            
    public StaticBlock(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.mortal = false;
        this.transponivel = false;
    }
    
    public StaticBlock(String sNomeImagePNG, int linha, int coluna, Color cor, Losango los) {
        this(sNomeImagePNG);
        this.posicao.setPosicao(linha, coluna);
        this.cor = cor;
        this.quebravel = this.cor.DefinidoPelaCor();
        this.los = los;
        this.arrastavel = this.los.ContemLosango();
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
}
