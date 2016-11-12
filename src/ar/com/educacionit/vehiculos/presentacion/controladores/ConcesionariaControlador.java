/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import ar.com.educacionit.vehiculos.aplicacion.APPConcesionaria;

/**
 *
 * @author Rodolfo Durante
 */
public abstract class ConcesionariaControlador {

    protected APPConcesionaria mainApp;

    public void setMainApp(APPConcesionaria runner) {
        this.mainApp = runner;
    }
}
