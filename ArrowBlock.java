package Modelo;

import java.io.Serializable;

public class ArrowBlock extends Elemento implements Serializable {
    
    public ArrowBlock(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.mortal = false;
        this.transponivel = true;
        this.empurrador = true;
        
        // Definindo para qual direcao a seta empurra, a partir do seu icone
        if (null != sNomeImagePNG) switch (sNomeImagePNG) {
            case "SetaUp.png" -> direcao = "Up";
            case "SetaRight.png" -> direcao = "Right";
            case "SetaDown.png" -> direcao = "Down";
            case "SetaLeft.png" -> direcao = "Left";
            default -> {
            }
        }
    }
    
    public ArrowBlock(String sNomeImagePNG, int linha, int coluna) {
        this(sNomeImagePNG);
        this.posicao.setPosicao(linha, coluna);
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
}
