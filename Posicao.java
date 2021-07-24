package Auxiliar;

import java.io.Serializable;

public class Posicao implements Serializable, Cloneable {
    private int	linha;
    private int coluna;
    
    private int linhaAnterior;
    private int colunaAnterior;
       
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Posicao(int linha, int coluna) {
        this.setPosicao(linha, coluna);
    }

    public boolean setPosicao(int linha, int coluna) {       
        if (linha < 0 || linha >= Auxiliar.Consts.RES)
            return false;
        linhaAnterior = this.linha;
        this.linha = linha;
        
        if (coluna < 0 || coluna >= Auxiliar.Consts.RES) {
            return false;
        }
            
        colunaAnterior = this.coluna;
        this.coluna = coluna;
        return true;
    }
    
    public int getLinha() {
        return linha;
    }
   
    public boolean volta() {
        return this.setPosicao(linhaAnterior,colunaAnterior);
    }

    public int getColuna() {
        return coluna;
    }

    public boolean estaNaMesmaPosicao(Posicao posicao) {
        return (linha == posicao.getLinha() && coluna == posicao.getColuna());
    }

    public boolean copia(Posicao posicao) {
        return this.setPosicao(posicao.getLinha(),posicao.getColuna());
    }
    
    
    public boolean moveUp() {
        return this.setPosicao(this.getLinha()-1, this.getColuna());
    }
    public boolean moveDown() {
        return this.setPosicao(this.getLinha()+1, this.getColuna());
    }
    public boolean moveRight() {
        return this.setPosicao(this.getLinha(), this.getColuna()+1);
    }
    public boolean moveLeft() {
        return this.setPosicao(this.getLinha(), this.getColuna()-1);        
    }

    // Funcoes uteis na funcao de quebrar bloco
    public boolean estaACima(Posicao posicao) {
        return (linha == ( posicao.getLinha() + 1 ) && coluna == posicao.getColuna());
    }
    
    public boolean estaADireita(Posicao posicao) {
        return (linha == posicao.getLinha() && coluna == ( posicao.getColuna() + 1) );
    }
    
    public boolean estaAEsquerda(Posicao posicao) {
        return (linha == posicao.getLinha() && coluna == ( posicao.getColuna() - 1) );
    }
    
    public boolean estaABaixo(Posicao posicao) {
        return (linha == ( posicao.getLinha() - 1 ) && coluna == posicao.getColuna());
    }
    
    public String posicaoRelativaA(Posicao posicao) {
        if (this.estaACima(posicao)) return "Up";
        if (this.estaABaixo(posicao)) return "Down";
        if (this.estaADireita(posicao)) return "Left";
        if (this.estaAEsquerda(posicao)) return "Right";
        return null;
    }
}
