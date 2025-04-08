/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import utilidadesString.Fecha;

/**
 *
 * @author dam
 */
public class Mensaje {
    
    private String asunto;
    
    private Fecha fecha;
    
    private String contenido;
    
    private String email;
    
    private boolean leido;
    
    private Usuario emisor;

    public Mensaje(String asunto, String contenido, String email, Usuario emisor, Fecha fecha) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.email=email;
        this.emisor=emisor;
        this.fecha=fecha;
        leido=false;
    }

    
    

    public String getAsunto() {
        return asunto;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public boolean isLeido() {
        return leido;
    }

    public String getEmail() {
        return email;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
    
    
    
    
    
    

    
    
    
    
}
