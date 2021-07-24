package Controler;

import Modelo.*;
import Auxiliar.*;
import static Auxiliar.Consts.RES;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;


public class Tela extends javax.swing.JFrame implements KeyListener {

    private Hero hero;
    private ArrayList<Elemento> elementos;
    Fase fase;
    int faseAtual;
    private ControleDeJogo controle;
    private Graphics g2;
    
    // Flags de controle de telas especiais (inicio / morte / fim)
    boolean inicio;
    boolean acabou;
    boolean venceu;
    boolean morreu;
    
    // Creates new form
    
    public Tela() {
        this.controle = new ControleDeJogo();
        inicio = true;
        acabou = false;
        venceu = false;
        morreu = false;
        Desenhador.setCenario(this); // Desenhador funciona no modo estatico
        
        // Codigo controlado pelo netbeans
        initComponents();
 
        this.addKeyListener(this);   // teclado
        
        // Cria a janela do tamanho do cenario + insets (bordas) da janela
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                     Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        fase = new Fase();
        faseAtual = 0;
        fase.selecionaFase(faseAtual);
        // Este array vai guardar os elementos graficos
        elementos = fase.getArrayElementos(); 
        ControleDeJogo.setElementosFase(elementos);
        hero = fase.getHero();
    }

/*--------------------------------------------------*/
    public void addElemento(Elemento umElemento) {
        elementos.add(umElemento);
    }

    public void removeElemento(Elemento umElemento) {
        elementos.remove(umElemento);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/    
    @Override
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        if (inicio) {
            try {
                // Linha para alterar o background
                Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "telaInicial.png");
                g2.drawImage(newImage, 0x1, 0x1, Consts.CELL_SIDE * RES, Consts.CELL_SIDE * RES, null);

            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (acabou && venceu) {
            try {
                // Linha para alterar o background
                Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "win.png");
                g2.drawImage(newImage, 0x1, 0x1, Consts.CELL_SIDE * RES, Consts.CELL_SIDE * RES, null);

            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (acabou && morreu) {
            try {
                // Linha para alterar o background
                Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "gameover.png");
                g2.drawImage(newImage, 0x1, 0x1, Consts.CELL_SIDE * RES, Consts.CELL_SIDE * RES, null);

            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            for (int i = 0; i < Consts.RES; i++) {
                for (int j = 0; j < Consts.RES; j++) {
                    try {
                        // Linha para alterar o background
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "background.png");
                        g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                    } catch (IOException ex) {
                        Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        
        // Aqui podem ser inseridos novos processamentos de controle
        if (!this.elementos.isEmpty() && inicio == false && acabou == false) {
            
            // Logica de gameover quando o heroi perde todas as vidas.
            // Retorna para a primeira fase, perte todos os pontos e 
            // recupera as 3 vidas.
            if (hero.getVidas() <= 0) {
                System.out.println("U lose, my brudah!");
                acabou = true;
                morreu = true;                
            }
            this.controle.desenhaTudo();
            
            // Executando a funcao de processamento de todos os elementos e
            // logica de retornar ao comeco da fase se nosso heroi tiver morrido
            boolean heroiMorreu = this.controle.processaTudo();
            
            if (heroiMorreu) {
                fase.selecionaFase(faseAtual);
                elementos = fase.getArrayElementos();
                ControleDeJogo.setElementosFase(elementos);
                hero = fase.getHero();
            }
        }
        
        // Logica de termino de uma fase (todos os coletaveis foram pegos)
        // e de fim de jogo (todas as fases implementadas foram completadas)
        if ((fase.getNumColetaveis() == hero.getColetaveisPegos()) && acabou == false) {
            faseAtual++;
            if (fase.selecionaFase(faseAtual)) {
                elementos = fase.getArrayElementos();
                ControleDeJogo.setElementosFase(elementos);
                hero = fase.getHero();
                System.out.println("Boa! Bora pra proxima fase. Boa sorte.");
            }
            else {
                System.out.println("U win, my brudah! Aperte 'L' para jogar novamente.");
                acabou = true;
                venceu = true;
            }
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            @Override
            public void run() {
                repaint(); /*(executa o metodo paint)*/
            }
        };        
        
        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Movimento do heroi via teclado
        switch (e.getKeyCode()) {
            // iniciando o jogo e saindo da tela inicial
            case KeyEvent.VK_S -> { inicio = false; }
            
            case KeyEvent.VK_UP -> hero.moveUp();
            case KeyEvent.VK_DOWN -> hero.moveDown();
            case KeyEvent.VK_LEFT -> hero.moveLeft();
            case KeyEvent.VK_RIGHT -> hero.moveRight();
            case KeyEvent.VK_L -> {
                // L = reiniciar o jogo, ou seja, retorna a fase 1
                faseAtual = 0;
                fase = new Fase();
                
                inicio = false;
                acabou = false;
                morreu = false;
                venceu = false;
                
                fase.selecionaFase(faseAtual);
                elementos = fase.getArrayElementos();
                ControleDeJogo.setElementosFase(elementos);
                hero = fase.getHero();
            }
            case KeyEvent.VK_ENTER -> {
                // Enter = proxima fase
                faseAtual++;
                if (fase.selecionaFase(faseAtual)) {
                    elementos = fase.getArrayElementos();
                    ControleDeJogo.setElementosFase(elementos);
                    hero = fase.getHero();
                }
                else {
                    System.out.println("U win, my brudah! Aperte 'L' para jogar novamente.");
                    acabou = true;
                    venceu = true;
                }
            }
            case KeyEvent.VK_SPACE -> {
                try {
                    controle.quebra(hero);
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            default -> {
            }
        }
        
        // Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, 
        // ele volta para onde estava
        if (ControleDeJogo.ehPosicaoValida(hero) != null) {
            hero.voltaAUltimaPosicao();
        }

        this.setTitle("Skooter, from Flavio Vasini and Joao Vitor! Cell: " +
                     ( hero.getPosicao().getColuna()) + ", " + (hero.getPosicao().getLinha()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2021");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
