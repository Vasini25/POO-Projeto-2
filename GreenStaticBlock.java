
package Modelo;

import java.io.Serializable;

public class GreenStaticBlock extends StaticBlock implements Serializable {
    
    public Color cor;
    public Losango los;
    
    public GreenStaticBlock (String sNomeImagePNG, Color cor, Losango los) {
        super(sNomeImagePNG);
        this.mortal = false;
        this.transponivel = false;
        
        // Esse arrastavel eh redundante, mas achamos justo para uma classe 
        // mais clara e auto-explicativa.
        //this.arrastavel = false;
        //this.quebravel = true;
        this.cor = cor;
        this.quebravel = this.cor.DefinidoPelaCor();
        this.los = los;
        this.arrastavel = this.los.ContemLosango();
    }
    
    public GreenStaticBlock (String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG);
        this.posicao.setPosicao(linha, coluna);
        //this.cor = cor;
        //this.quebravel = this.cor.DefinidoPelaCor();
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
}
