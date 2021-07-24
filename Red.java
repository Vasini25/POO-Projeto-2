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
public class Red implements Color{
    
    public boolean quebravel;
    
    public Red(){
        this.quebravel = true;
    };
    
    @Override
    public boolean DefinidoPelaCor(){
        return false;
    }
}
