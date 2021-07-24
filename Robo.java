package Modelo;

import Controler.ControleDeJogo;
import java.io.Serializable;
import java.util.Random;

public class Robo extends Elemento implements Serializable {
    
    // usamos funcoes geradores de numeros aleatorios para decidir
    // para onde o robo se movera
    private Random rand;
    private int randomNumber;

    public Robo(String sNomeImagePNG) {
        super(sNomeImagePNG);
        
        this.mortal = false;
        this.transponivel = false;
        
        this.assassino = true;
        
        rand = new Random();    
        randomNumber = rand.nextInt(4);        
    }
    
    public Robo(String sNomeImagePNG, int linha, int coluna) {
        this(sNomeImagePNG);
        this.posicao.setPosicao(linha, coluna);
    }
    
    // Valores de randomNumber e suas correspondencias:
    // 0 == direita
    // 1 == baixo
    // 2 == esquerda
    // 3 == cima
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
        
        // Para que os nossos robos (que sao elementos dinamicos) nao
        // entrem em posicoes invalidas para eles, como blocos vermelhos, 
        // verdes, ou setas e itens coletaveis, eh necessario avaliar 
        // a validade da posicao para qual irao se mover. 
        
        // Para isso, perguntamos ao controlador do jogo se podemos nos mover. 
        
        // O controlador conhece todos os outros elementos e resolve isso para 
        // nos, visto que a classe robo nao deve conhecer todos os elementos do 
        // jogo ou ter controle sobre isso.
        
        // Eh possivel aumentar a dificuldade do jogo fazendo com que ele recalcule 
        // a posicao ate que encontre uma posicao valida, ao inves de ficar parado
        // quando tenta se mover para uma posicao invalida. Porem, o jogo fica
        // MUITO mais dificil.
        
        if (!ControleDeJogo.ehPosicaoValidaRelativa(this)) {
            voltaAUltimaPosicao();
        }

        super.autoDesenho();
        
        rand = new Random();
        randomNumber = rand.nextInt(4);   
    }
}
