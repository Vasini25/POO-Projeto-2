package Modelo;

import java.io.Serializable;

public class Hero extends Elemento implements Serializable {
    
    protected int vidas;
    
    // conta os coletaveis pegos em uma fase
    protected int coletaveisPegos;
    
    // conta os coletaveis pegos durante todo o jogo
    protected int pontosTotais;
    
    // Variavel que armazena qual foi nosso ultimo movimento
    // e consequentemente, para onde o skooter esta olhando.
    // Pode permitir adicionar animacao mudando de acordo com direcao
    // se der tempo.
    protected String olhandoPara;
    
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        mortal = true;
        transponivel = false;
        
        vidas = 3;
        coletaveisPegos = 0;
    }
    
    // getters
    public int getVidas() {
        return vidas;
    }

    public int getPontosTotais() {
        return pontosTotais;
    }
    
    public int getColetaveisPegos() {
        return coletaveisPegos;
    }
    
    // Funcoes de controle do heroi, usadas pelo controlador e pela tela para
    // fazer a logica geral do jogo (transicao de fases e interface de pontos)
    public void perdeVida() {
        coletaveisPegos = 0;
        vidas--;
    }

    public void setColetaveisPegos(int coletaveisPegos) {
        this.coletaveisPegos = coletaveisPegos;
    }

    public void aumentaPonto() {
        coletaveisPegos++;
        pontosTotais++;
    }
    
    // Comandos de movimentacao, que sobrescrevem os comandos da classe mae elemento,
    // porque na movimentacao do heroi eh necessario manter um "tracking" de para onde
    // ele esta olhando, para que a funcao "explodir" funcione e seja possivel adicionar
    // animacao dinamica
    public boolean move(String direcao) {
        olhandoPara = direcao;
        
        switch (direcao) {
            case "Up" -> { return this.moveUp(); }
            case "Down" -> { return this.moveDown(); }
            case "Left" -> { return this.moveLeft(); }
            case "Right" -> { return this.moveRight(); }
            default -> {
            }
        }
        return false;
    }

    @Override
    public boolean moveUp() {
        olhandoPara = "Up";
        return this.posicao.moveUp();
    }
    
    @Override
    public boolean moveDown() {
        olhandoPara = "Down";
        return this.posicao.moveDown();
    }

    @Override
    public boolean moveRight() {
        olhandoPara = "Right";
        return this.posicao.moveRight();
    }

    @Override
    public boolean moveLeft() {
        olhandoPara = "Left";
        return this.posicao.moveLeft();
    }

    public String getOlhandoPara() {
        return olhandoPara;
    }
}
