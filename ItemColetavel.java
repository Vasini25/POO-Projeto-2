package Modelo;     

import java.io.Serializable;
        
public class ItemColetavel extends Elemento implements Serializable {
    
    public ItemColetavel(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.transponivel = true;
        mortal = true;
        coletavel = true;
    }
    
    public ItemColetavel(String sNomeImagePNG, int linha, int coluna) {
        this(sNomeImagePNG);
        this.posicao.setPosicao(linha, coluna);
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }    
}
