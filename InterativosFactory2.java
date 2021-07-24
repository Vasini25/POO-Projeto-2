/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author flavi
 */
public class InterativosFactory2 implements AbstractFactory{
    
    @Override
    public Object createRobot() {
        return new PinkRobot();
    }

    @Override
    public Object createColectable(String sNomeImagePNG) {
        return new Colectable2(sNomeImagePNG);
    }
    
}
