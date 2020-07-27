/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rol.charactergenerator;

/**
 *
 * @author tipozico
 */
class Enser {
    
    String Nombre;
    int Cantidad;
    int Carga;
    
    void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    void setCarga(int Carga){
        this.Carga = Carga;
    }
    
    String getNombre(){
        Nombre = this.Nombre;
        return Nombre;
    }
    int getCarga(){
        Carga = this.Carga;
        return Carga;
    }
}
