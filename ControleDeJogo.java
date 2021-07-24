package Controler;

import Auxiliar.Posicao;
import Modelo.Elemento;
import Modelo.Hero;
import java.util.ArrayList;

public class ControleDeJogo {
    // Adaptamos o array contendo os elementos da fase para estatico, porque 
    // existe apenas um controlador em cada jogo e suas funcoes podem ser uteis
    // em outros elementos que nao conhecem tudo.
    static ArrayList<Elemento> e;
    
    // Visto que fizemos essa adaptacao, tambem precisamos de alguma forma 
    // de controlar a fase em que estamos e quais elementos o controlador
    // esta controlando. Logo, usamos um setter:
    public static void setElementosFase(ArrayList<Elemento> e) {
        ControleDeJogo.e = e;
    }
    
    public void desenhaTudo() {
        // invertendo o desenhaTudo para que o herói e os robos sejam 
        // sempre desenhados por ultimo e fiquem na frente da tela
        for (int i = e.size() - 1; i >= 0; i--) {
            e.get(i).autoDesenho();
        }
    }
    
    // O booleano de retorno indica se o heroi morreu durante o processamento
    // ou nao: true == morreu; false == nao morreu.
    
    public boolean processaTudo() {
        Hero hero = (Hero)e.get(0); // O heroi (protagonista) eh sempre o primeiro do array
        
        Elemento tempElemento;
        // Processa todos os demais em relacao ao heroi
        for (int i = 1; i < e.size(); i++) {
            tempElemento = e.get(i); 
            // Pega o i-esimo elemento do jogo e verifica
            // se o heroi se sobrepoe ao i-ésimo elemento
            
            if (hero.getPosicao().estaNaMesmaPosicao(tempElemento.getPosicao())) {
                // Nem todos os elementos podem ser transpostos pelo heroi
                // e alguns vao mata-lo. Nao precisamos fazer o heroi retornar
                // a sua posicao ao encontrar um elemento transponivel porque a tela
                // ja faz essa verificacao atraves da funcao "ehPosicaoValida"
                // a cada movimento do jogador.
                if (tempElemento.isTransponivel() && tempElemento.isMortal()) {
                    if (tempElemento.isColetavel()) {
                        hero.aumentaPonto();
                        System.out.println("Pegou um coletavel! Pontos: " + hero.getPontosTotais());
                    }
                    e.remove(tempElemento);
                    return false;
                }
                
                if (tempElemento.isAssassino()) {
                    hero.perdeVida();
                    System.out.println("Heroi perdeu uma vida! Vidas: " + hero.getVidas());
                    // indicando para a tela que o heroi perdeu uma vida e devemos voltar
                    // ao inicio da fase.
                    return true;
                }
                
                if (tempElemento.isEmpurrador()) {
                    String direcao = tempElemento.getDirecao();
                    switch (direcao) {
                        case "Right" -> hero.moveRight();
                        case "Up" -> hero.moveUp();
                        case "Left" -> hero.moveLeft();
                        case "Down" -> hero.moveDown();
                    }
                    return false;
                }
                
                // Esse trecho possivelmente pode ser melhorado.
                // Atualmente, o heroi e o bloco movido sao desenhados
                // nas posicoes erradas, antes de retornar... 
                if (tempElemento.isMovel()) {
                    switch (hero.getOlhandoPara()) {
                        case "Right" -> {
                            if (!tempElemento.moveRight()) {
                                hero.voltaAUltimaPosicao();
                            }
                        }
                        case "Left" -> {
                            if (!tempElemento.moveLeft()) {
                                hero.voltaAUltimaPosicao();
                            }
                        }
                        case "Up" -> {
                            if (!tempElemento.moveUp()) {
                                hero.voltaAUltimaPosicao();
                            }
                        }
                        case "Down" -> {
                            if (!tempElemento.moveDown()) {
                                hero.voltaAUltimaPosicao();
                            }
                        }
                    }
                }
            }  
        }
        
        return false;
    }
    
    // Nao podemos usar essa funcao para qualquer elemento.
    // O laco comeca no 1, ignorando o heroi. Como os outros elementos
    // nao estao na posicao 1, eles serao comparados com eles mesmos e 
    // com certeza estarao na mesma posicao, resultando em posicao invalida.
    
    // Ela retorna o elemento nao transponivel que estamos tentando forcar, se 
    // houver algum. Caso nao (caso seja uma posicao valida / livre), retorna null
    public static Elemento ehPosicaoValida(Elemento elemento) {
        Elemento tempElemento;
        // Validacao da posicao de todos os elementos com relacao ao elemento p
        for (int i = 1; i < e.size(); i++) { 
            // Olha todos os elementos, pegando o i-esimo elemento do jogo
            tempElemento = e.get(i); 
            
            // Se nao for transponivel e nem movel, eh uma posicao invalida.
            if (!tempElemento.isTransponivel() && !tempElemento.isMovel()) {
                if (tempElemento.getPosicao().estaNaMesmaPosicao(elemento.getPosicao())) {
                    return tempElemento;    // A posicao é invalida, pois ha um elemento 
                                            // (i-esimo tempElemento) intransponivel lá
                } 
            }
        }
        return null;
    }
    
    
    
    // Ja essa funcao, faz o mesmo que a funcao acima, porem, eh valida para qualquer 
    // elemento recebido como argumento. Se qualquer elemento tentar se mover
    // para uma posicao em que ha algum outro elemento, retornaremos "false".
    public static boolean ehPosicaoValidaRelativa(Elemento elemento) {
        Elemento tempElemento;
        
        for (int i = 1; i < e.size(); i++) {
            tempElemento = e.get(i);
            
            if (tempElemento == elemento) {
                continue;
            }
            
            if (!tempElemento.isTransponivel() || tempElemento.isEmpurrador() || tempElemento.isColetavel()) {
                if (tempElemento.getPosicao().estaNaMesmaPosicao(elemento.getPosicao())) {
                    return false;
                }
            }
        }
        return true;
    }

    // Essa funcao e a funcao privada que ela usa foram feitas para otimizar a 
    // quebra de um bloco. A quebra poderia ser feita junto com as condicionais 
    // no processaTudo, porem, se feita dessa forma, sujeitamos o jogo a alguns 
    // problemas como poder apertar espaco uma vez e o proximo bloco quebravel 
    // se romper, mesmo se nao quisermos mais quebra-lo (ja que teriamos que usar
    // "flags" em algum elemento (o heroi seria o elemento mais adequado) carregando
    // a informacao da tecla pressionada. Preferimos colocar 
    // um pouco de complexidade no codigo e adicionar melhor experiencia.
    void quebra(Hero hero) throws CloneNotSupportedException {
        String direcao = hero.getOlhandoPara();
        
        try {
            Posicao posicao = (Posicao) hero.getPosicao().clone();
            Elemento tempElemento = null;

            switch (direcao) {        
                case "Right" -> {
                    posicao.moveRight();
                    tempElemento = buscaElementoPorPosicao(posicao);
                }
                case "Left" -> {
                    posicao.moveLeft();
                    tempElemento = buscaElementoPorPosicao(posicao);
                }
                case "Up" -> {
                    posicao.moveUp();
                    tempElemento = buscaElementoPorPosicao(posicao);
                }
                case "Down" -> {
                    posicao.moveDown();
                    tempElemento = buscaElementoPorPosicao(posicao);
                }
                default -> {
                }
            }

            if (tempElemento != null && tempElemento.isQuebravel()) {
                e.remove(tempElemento);
            }
        }
        catch (CloneNotSupportedException exception) {
            throw exception;
        }
    }
    
    private Elemento buscaElementoPorPosicao(Posicao posicao) {
        Elemento tempElemento;
        int size = e.size();
        for (int i = 0; i < size; i++) {
            tempElemento = e.get(i);
            if (tempElemento.getPosicao().estaNaMesmaPosicao(posicao)) {
                return tempElemento;
            }
        }
        return null;
    }
}
