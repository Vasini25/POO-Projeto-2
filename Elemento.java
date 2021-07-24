package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;

public abstract class Elemento implements Serializable {

    protected ImageIcon image;
    protected Posicao posicao;
    
    // Atributos de todos os elementos possiveis, necessario para o polimorfismo
    protected boolean transponivel;     // Pode passar por cima?
    protected boolean mortal;           // Se encostar, morre?
    protected boolean assassino;        // Se encostar, o heroi morre?
    protected boolean coletavel;        // Eh um item coletavel, que fornece pontos?
    protected boolean cura;             // Eh um item que aumenta a vida?
    protected boolean arrastavel;       // Pode ser arrastado pelo heroi?
    protected boolean quebravel;        // Possui interacao de ser "explodido"?
    protected boolean empurrador;       // Elemento empurra o heroi?
    protected boolean movel;            // Pode ser empurrado?
    protected String direcao;           // Metadado usado por alguns elementos
   
       
    protected Elemento(String sNomeImagePNG) {
        
        // Inicializando todos os atributos, prevenindo erros
        this.posicao = new Posicao(1, 1);
        this.transponivel = false;
        this.mortal = false;
        this.coletavel = false;
        this.cura = false;  
        this.arrastavel = false;
        this.quebravel = false;
        this.empurrador = false;
        this.direcao = null;        
        
        try {
            image = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = image.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            image = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // getters para acessar o valor dos atributos privados
    public Posicao getPosicao() {
        return posicao;
    }

    public boolean isMortal() {
        return mortal;
    }

    public boolean isTransponivel() {
        return transponivel;
    }

    public boolean isArrastavel() {
        return arrastavel;
    }

    public boolean isQuebravel() {
        return quebravel;
    }

    public boolean isEmpurrador() {
        return empurrador;
    }

    public boolean isCura() {
        return cura;
    }
    
    public boolean isAssassino() {
        return assassino;
    }

    public boolean isColetavel() {
        return coletavel;
    }

    public boolean isMovel() {
        return movel;
    }

    public String getDirecao() {
        return direcao;
    }
    

    // Setters a serem usados pelos metodos de controle do jogo
    public void setTransponivel(boolean bTransponivel) {
        this.transponivel = bTransponivel;
    }

    public boolean setPosicao(int linha, int coluna) {
        return posicao.setPosicao(linha, coluna);
    }

    public boolean moveUp() {
        return this.posicao.moveUp();
    }

    public boolean moveDown() {
        return this.posicao.moveDown();
    }

    public boolean moveRight() {
        return this.posicao.moveRight();
    }

    public boolean moveLeft() {
        return this.posicao.moveLeft();
    }
    
    public void voltaAUltimaPosicao() {
        this.posicao.volta();
    }
    
    // Funcao polimorfica usada pela tela para desenhar todos os elementos
    public void autoDesenho(){
        Desenhador.desenhar(this.image, posicao.getColuna(), posicao.getLinha());        
    }
}
