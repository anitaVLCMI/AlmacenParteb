/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Anita
 */
public class FormatoFechaErroneo extends RuntimeException{
    
    public FormatoFechaErroneo(){
        super(" Formato erroneo.Debe ser \"dd-MMMM-yy\"");
    }
    
}
