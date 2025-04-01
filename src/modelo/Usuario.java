/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author dam
 */
public class Usuario {
    
    private String login;
    private String contra;
    private ArrayList <Mensaje> bEntrada;
    private String email;
    private int tipo;
    

    public Usuario(String login, String contra, String email,int tipo) {
        this.login = login;
        this.contra = contra;
        bEntrada = new ArrayList<>();
        this.email=email;
        this.tipo=tipo;
    }
    
    public void actualizarCorreo(int fila, boolean valor){
        
        bEntrada.get(fila).setLeido(valor);
        
    }
    

    public Usuario(String email) {
        this.email = email;
    }

    
    
    public String getLogin() {
        return login;
    }

    public String getContra() {
        return contra;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public ArrayList <Mensaje> getbEntrada() {
        return bEntrada;
    }
    
    public String getEmail() {
        return email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.email, other.email);
    }

    public int getTipo() {
        return tipo;
    }
    
    
    
    

    
    
    
    
}
