package Controler;

import Modelo.ArrowBlock;
import Modelo.Elemento;
import Modelo.BlocoMovel;
import Modelo.Bloco;
import Modelo.ComLosango;
import Modelo.Green;
import Modelo.GreenBreakableMovelBlock;
import Modelo.GreenStaticBlock;
import Modelo.Hero;
import Modelo.ItemColetavel;
import Modelo.Red;
import Modelo.StaticBlock;
import Modelo.Robo;
import Modelo.SemLosango;
import java.util.ArrayList;

public class Fase {
    public ArrayList<Elemento> arrayElementos;
    
    private Hero hero;
    
    // Visto que nossa clase fase eh uma especie de controlador do sistema de fases
    // em conjunto com a classe tela e a classe ControleDeJogo, guardamos alguns
    // "metadados" na classe fase, para que possamos terceirizar algumas funcoes
    private int numColetaveis;

    public Fase() {
        arrayElementos = new ArrayList<> ();
        
        // Inicializamos o heroi junto com a instancia da classe fase, 
        // visto que sera o mesmo durante todo o jogo.
        hero = new Hero("skooter_hero.png"); // https://www.online-image-editor.com/
    }
       
    public boolean selecionaFase(int qualFase) {
        switch (qualFase) {
            case 0 -> {
                
                numColetaveis = 4;
                arrayElementos.clear();
                
                // Setando o heroi
                hero.setPosicao(4, 4);
                arrayElementos.add(hero);
                hero.setColetaveisPegos(0);
                
                // Robôs   
                arrayElementos.add( new Robo("robo_laranja.png", 2, 0) );
                arrayElementos.add( new Robo("robo_rosa.png", 0, 9) );
                arrayElementos.add( new Robo("robo_verde.png", 10, 9) );
                arrayElementos.add( new Robo("robo_azul.png", 10, 1) );
                
                
                // Coletaveis
                
                arrayElementos.add( new ItemColetavel("Cherry.png", 10, 10) );
                arrayElementos.add( new ItemColetavel("Grape.png", 0, 0) );
                arrayElementos.add( new ItemColetavel("Lemon.png", 0, 10) );
                arrayElementos.add( new ItemColetavel("Strawberry.png", 10, 0) );
                
                // Blocos da fase
                
                arrayElementos.add(new Bloco("RedSquare.png", 1, 1, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 1, 3, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 1, 5, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 1, 7, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 1, 9, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 3, 1, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 3, 3, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 3, 5, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 3, 7, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 3, 9, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 5, 1, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 5, 3, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 5, 5, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 5, 7, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 5, 9, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 7, 1, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 7, 3, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 7, 5, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 7, 7, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 7, 9, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 9, 1, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 9, 3, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 9, 5, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 9, 7, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 9, 9, new Red(), new SemLosango()) );

                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 0, 1, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 0, 5, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new Bloco("GreenBreakableSquare.png", 1, 2, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 1, 8, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 1, 10, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 2, 1, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 2, 5, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 3, 0, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 3, 8, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 4, 1, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 4, 9, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 5, 2, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 5, 6, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 6, 5, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 6, 7, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 7, 8, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 8, 3, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 8, 9, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 9, 0, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 9, 2, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 9, 6, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 9, 8, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 10, 7, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                arrayElementos.add(new GreenBreakableMovelBlock("GreenBreakableSquare.png", 7, 10, new Green(), new ComLosango("GreenBreakableSquare.png")) );
                
                System.out.println("Estamos na fase 1.");
                return true;
            }
            case 1 -> {
                numColetaveis = 4;
                arrayElementos.clear();
                
                // Heroi
                hero.setPosicao(5, 5);
                arrayElementos.add(hero);    
                hero.setColetaveisPegos(0);
                
                // Robos
                arrayElementos.add( new Robo("PinkRobot.png", 9, 1) );
                arrayElementos.add( new Robo("YellowRobot.png", 1, 1) );
                arrayElementos.add( new Robo("BlueRobot.png", 9, 9) );
                arrayElementos.add( new Robo("GreenRobot.png", 1, 9 ) );
                
                // Coletaveis
                arrayElementos.add( new ItemColetavel("Cherry.png", 9, 5) );
                arrayElementos.add( new ItemColetavel("Grape.png", 1, 5) );
                arrayElementos.add( new ItemColetavel("Lemon.png", 5, 1) );
                arrayElementos.add( new ItemColetavel("Strawberry.png", 5, 9) );
                
                // Blocos
                arrayElementos.add(new StaticBlock("RedSquare.png", 1, 3, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 1, 7, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 3, 1, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 3, 3, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 3, 5, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 3, 7, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 3, 9, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 5, 3, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 5, 7, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 7, 1, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 7, 3, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 7, 5, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 7, 7, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 7, 9, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 9, 3, new Red(), new SemLosango()) );
                arrayElementos.add(new StaticBlock("RedSquare.png", 9, 7, new Red(), new SemLosango()) );
                arrayElementos.add( new ArrowBlock("SetaRight.png", 0, 3) );
                arrayElementos.add( new ArrowBlock("SetaRight.png", 0, 7) );
                arrayElementos.add( new ArrowBlock("SetaRight.png", 2, 3) );
                arrayElementos.add( new ArrowBlock("SetaDown.png", 2, 4) );
                arrayElementos.add( new ArrowBlock("SetaLeft.png", 2, 5) );
                arrayElementos.add( new ArrowBlock("SetaLeft.png", 2, 6) );
                arrayElementos.add( new ArrowBlock("SetaLeft.png", 2, 7) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 3, 0) );
                arrayElementos.add( new ArrowBlock("SetaDown.png", 3, 2) );
                arrayElementos.add( new ArrowBlock("SetaDown.png", 3, 4) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 3, 6) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 3, 8) );
                arrayElementos.add( new ArrowBlock("SetaDown.png", 3, 10) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 4, 0) );
                arrayElementos.add( new ArrowBlock("SetaRight.png", 4, 3) );
                arrayElementos.add( new ArrowBlock("SetaRight.png", 4, 7) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 4, 8) );
                arrayElementos.add( new ArrowBlock("SetaLeft.png", 4, 9) );
                arrayElementos.add( new ArrowBlock("SetaDown.png", 4, 10) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 5, 0) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 6, 0) );
                arrayElementos.add( new ArrowBlock("SetaRight.png", 6, 3) );
                arrayElementos.add( new ArrowBlock("SetaLeft.png", 6, 7) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 7, 0) );
                arrayElementos.add( new ArrowBlock("SetaDown.png", 7, 2) );
                arrayElementos.add( new ArrowBlock("SetaDown.png", 7, 4) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 7, 6) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 7, 8) );
                arrayElementos.add( new ArrowBlock("SetaUp.png", 7, 10) );
                arrayElementos.add( new ArrowBlock("SetaRight.png", 8, 3) );
                arrayElementos.add( new ArrowBlock("SetaRight.png", 8, 7) );
                arrayElementos.add( new ArrowBlock("SetaLeft.png", 10, 3) );
                arrayElementos.add( new ArrowBlock("SetaRight.png", 10, 7) );
                
                System.out.println("Estamos na fase 2.");
                return true;
            }
            case 2 -> {
                
                arrayElementos.clear();
                
                // Heroi               
                hero.setPosicao(5, 5);
                arrayElementos.add(hero);
                hero.setColetaveisPegos(0);
                
                // Robos
                arrayElementos.add( new Robo("PinkRobot.png", 2, 5) );
                arrayElementos.add( new Robo("YellowRobot.png", 0, 5) );
                arrayElementos.add( new Robo("BlueRobot.png", 8, 5) );
                arrayElementos.add( new Robo("GreenRobot.png", 10, 5) );
                
                // Coletaveis
                arrayElementos.add( new ItemColetavel("Sun.png", 5, 0) );
                arrayElementos.add( new ItemColetavel("Candle.png", 5, 2) );
                arrayElementos.add( new ItemColetavel("lightbulb.png", 5, 8) );
                arrayElementos.add( new ItemColetavel("Flashlight.png", 5, 10) );
                
                // Blocos
                arrayElementos.add( new Bloco("RedMoveableSquare.png", 1, 1, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 1, 2, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 9, 7, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 1, 3, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 1, 4, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 1, 5, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 1, 6, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 1, 7, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 1, 8, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 1, 9, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 2, 1, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 2, 9, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 3, 1, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 3, 3, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 3, 4, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 3, 5, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 3, 6, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 3, 7, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 3, 9, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 4, 1, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 4, 3, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 4, 7, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 4, 9, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 5, 1, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 5, 3, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 5, 7, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 5, 9, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 6, 1, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 6, 3, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 6, 7, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 6, 9, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 7, 1, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 7, 3, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 7, 4, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 7, 5, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 7, 6, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 7, 7, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 7, 9, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 8, 1, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 8, 9, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 9, 1, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 9, 2, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 9, 3, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 9, 4, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 9, 5, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 9, 6, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 9, 8, new Red(), new ComLosango("RedMoveableSquare.png")) );
                arrayElementos.add( new BlocoMovel("RedMoveableSquare.png", 9, 9, new Red(), new ComLosango("RedMoveableSquare.png")) );

                
                System.out.println("Estamos na fase 3.");
                return true;
            }
            case 3 -> {
                arrayElementos.clear();
                
                // Heroi
                hero.setPosicao(4, 5);
                arrayElementos.add(hero);
                hero.setColetaveisPegos(0);
                
                // Robos
                arrayElementos.add( new Robo("PinkRobot.png", 10, 5) );
                arrayElementos.add( new Robo("YellowRobot.png", 0, 5) );
                arrayElementos.add( new Robo("BlueRobot.png", 5, 10) );
                arrayElementos.add( new Robo("GreenRobot.png", 5, 0) );
                
                // Coletaveis
                arrayElementos.add( new ItemColetavel("Sun.png", 0, 0) );
                arrayElementos.add( new ItemColetavel("Candle.png", 10, 0) );
                arrayElementos.add( new ItemColetavel("lightbulb.png", 0, 10) );
                arrayElementos.add( new ItemColetavel("Flashlight.png", 10, 10) );
                
                // Blocos
                arrayElementos.add( new StaticBlock("RedSquare.png", 0, 3, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 0, 7, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 1, 0, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 1, 8, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 2, 5, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 3, 2, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 3, 10, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 5, 2, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 5, 8, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 6, 3, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 7, 0, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 10, 1, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 8, 1, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 8, 7, new Red(), new SemLosango()) );
                arrayElementos.add( new StaticBlock("RedSquare.png", 8, 10, new Red(), new SemLosango()) );


                Elemento G[] = new GreenStaticBlock[41];
                int cont = 0;

                for (int i = 1; i < 10; i++) {
                    int j, max;
                    
                    if (i % 2 == 0) {
                        j = 2;
                        max = 9;
                    } 
                    else {
                        j = 1;
                        max = 10;
                    }
                    
                    for (; j < max; j++) {

                        G[cont] = new GreenStaticBlock("GreenSquare.png", new Green(), new SemLosango());
                        G[cont].setPosicao(i, j);
                        arrayElementos.add(G[cont]);
                        j++;

                    }
                    cont++;
                }
                
                System.out.println("Estamos na fase 3.");
                return true;
            }
            default -> {
                arrayElementos.clear();
                return false;
            }
        }
    }

    public void add(Elemento umElemento) {
        arrayElementos.add(umElemento);
    }

    public void remove(Elemento umElemento) {
        arrayElementos.remove(umElemento);
    }

    public Hero getHero() {
        return hero;
    }

    public int getNumColetaveis() {
        return numColetaveis;
    }

    public ArrayList<Elemento> getArrayElementos() {
        return arrayElementos;
    }

    protected Fase reiniciaJogo(ArrayList<Elemento> elementos) { 
        hero = new Hero("skooter_hero.png");
        selecionaFase(0);
        elementos = getArrayElementos();
        ControleDeJogo.setElementosFase(elementos);
        return this;
    }
}
