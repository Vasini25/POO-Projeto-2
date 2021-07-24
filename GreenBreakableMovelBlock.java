
package Modelo;

import java.io.Serializable;

public class GreenBreakableMovelBlock extends BlocoMovel implements Serializable {
    
    public Color cor;
    public Losango los;
    
    public GreenBreakableMovelBlock (String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.mortal = false;
        this.transponivel = false;
        
        // Esse arrastavel eh redundante, mas achamos justo para uma classe 
        // mais clara e auto-explicativa.
        this.arrastavel = true;
        this.quebravel = true;
        
    }
    
    /*public GreenBreakableMovelBlock (String sNomeImagePNG, Color cor) {
        super(sNomeImagePNG);
        this.mortal = false;
        this.transponivel = false;
        this.arrastavel = true;
        //this.quebravel;
        this.cor = cor;
        this.quebravel = this.cor.DefinidoPelaCor();
    }*/
    
    public GreenBreakableMovelBlock (String sNomeImagePNG, int linha, int coluna, Color cor, Losango los) {
        super(sNomeImagePNG);
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
