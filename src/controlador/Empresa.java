/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Mensaje;
import modelo.Usuario;
import utilidades.Encriptar;

/**
 *
 * @author dam
 */
public class Empresa {

    ArrayList<Usuario> usuarios;

    ArrayList<Mensaje> mensajes;

    public Empresa() {

        mensajes = new ArrayList<>();
        usuarios = new ArrayList<>();

    }

    public void anadir() {

        String contra = "pepe";
        String encriptado = Encriptar.getMD5(contra);

        usuarios.add(new Usuario("Admin", "e3afed0047b08059d0fada10f400c1e5", "admin@example.com", 1));
        usuarios.add(new Usuario("pepe", "926e27eecdbc7a18858b3798ba99bddd", "pepe@example.com", 0));

    }

    public int buscar(String nombre, String contra) {

        int pos = 0;
        boolean encontrado = false;

        while (!encontrado && pos < usuarios.size()) {
            if (pos != -1) {

                if ((usuarios.get(pos).getLogin().equals(nombre))) {
                    encontrado = true;
                } else {
                    pos++;
                }

            }
        }
        if (encontrado) {

            if (!(usuarios.get(pos).getContra().equals(contra))) {
                pos = -1;
            }

        } else {

            pos = -1;

        }
        return pos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean anadirMensaje(String asunto, String email, String texto, Usuario emisor) {

        boolean resultado = true;

        int pos = usuarios.indexOf(new Usuario(email));

        if (pos == -1) {
            resultado = false;
        } else {
            usuarios.get(pos).getbEntrada().add(new Mensaje(asunto, texto, email, emisor));
        }

        return resultado;
    }

}
