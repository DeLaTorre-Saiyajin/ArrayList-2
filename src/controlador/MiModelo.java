/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dam
 */
public class MiModelo extends DefaultTableModel {
    
    //PARA QUE NO SE PUEDA MODIFICAR EL CONTENIDO DE JTABLE

    @Override
    public boolean isCellEditable(int row, int column) {
        
        return false;
    }
    
    
    
    
}
