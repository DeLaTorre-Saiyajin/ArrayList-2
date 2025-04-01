/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Empresa;
import java.awt.BorderLayout;
import modelo.Usuario;

/**
 *
 * @author dam
 */
public class VtnMenu extends javax.swing.JFrame {

    Empresa miEmpresa;
    int login;
    Usuario logueado;
    
    public VtnMenu(Empresa miEmpresa, int login) {
        
        initComponents();
        
        this.miEmpresa=miEmpresa;
        
        this.login=login;
        
        //CAMBIAR EL TAMAÑO
        this.setSize(1920, 1080);
        
        comprobar();
        
    }
    
    public VtnMenu(Usuario logueado){
        
        initComponents();
        
        this.logueado=logueado;
        
        if(logueado.getTipo()==0){
        
            mnuAlta.setVisible(false);
            mnuBaja.setVisible(false);
            mnuCambiarContra.setVisible(false);
            pack();
        }
        
    }
    
    
    
    PanelEnviar panelEnviar;
    PanelCambiarTuContra panelTuContra;
    PanelBandeja panelBandeja;


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuVolver = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAlta = new javax.swing.JMenuItem();
        mnuBaja = new javax.swing.JMenuItem();
        mnuCambiarContra = new javax.swing.JMenuItem();
        mnuCambiarTuContra = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuEnviar = new javax.swing.JMenuItem();
        mnuBandeja = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jMenu1.setText("Salir");

        mnuVolver.setText("Volver");
        mnuVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVolverActionPerformed(evt);
            }
        });
        jMenu1.add(mnuVolver);

        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Usuarios");

        mnuAlta.setText("Altas (ADMIN)");
        mnuAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAltaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuAlta);

        mnuBaja.setText("Bajas (ADMIN)");
        jMenu2.add(mnuBaja);

        mnuCambiarContra.setText("Cambiar contraseña (ADMIN)");
        mnuCambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCambiarContraActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCambiarContra);

        mnuCambiarTuContra.setText("Cambiar tu contraseña");
        mnuCambiarTuContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCambiarTuContraActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCambiarTuContra);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Mensajes");

        mnuEnviar.setText("Enviar Mensajes");
        mnuEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEnviarActionPerformed(evt);
            }
        });
        jMenu3.add(mnuEnviar);

        mnuBandeja.setText("Bandeja de Entrada");
        mnuBandeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBandejaActionPerformed(evt);
            }
        });
        jMenu3.add(mnuBandeja);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVolverActionPerformed
        dispose();
        new VtnLogin(miEmpresa).setVisible(true);
        pack();  
    }//GEN-LAST:event_mnuVolverActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        dispose();
        pack();
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEnviarActionPerformed
        eliminarPaneles();
        panelEnviar = new PanelEnviar(miEmpresa,miEmpresa.getUsuarios().get(login));
        getContentPane().add(panelEnviar,BorderLayout.CENTER);
        pack();
    }//GEN-LAST:event_mnuEnviarActionPerformed

    private void mnuAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAltaActionPerformed
        
    }//GEN-LAST:event_mnuAltaActionPerformed

    private void mnuCambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCambiarContraActionPerformed
        
    }//GEN-LAST:event_mnuCambiarContraActionPerformed

    private void mnuCambiarTuContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCambiarTuContraActionPerformed
        eliminarPaneles();
        panelTuContra = new PanelCambiarTuContra(miEmpresa.getUsuarios().get(login));
        getContentPane().add(panelTuContra,BorderLayout.CENTER);
        pack();
    }//GEN-LAST:event_mnuCambiarTuContraActionPerformed

    private void mnuBandejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBandejaActionPerformed
        eliminarPaneles();
        panelBandeja = new PanelBandeja(miEmpresa.getUsuarios().get(login));
        getContentPane().add(panelBandeja,BorderLayout.CENTER);
        pack();
        
    }//GEN-LAST:event_mnuBandejaActionPerformed

    public void comprobar(){
        
        if(miEmpresa.getUsuarios().get(login).getTipo()==0){
        
            mnuAlta.setVisible(false);
            mnuBaja.setVisible(false);
            mnuCambiarContra.setVisible(false);
            pack();
            
        }
    }
    
    public void eliminarPaneles(){
        
        try{
        this.remove(panelEnviar);
        }catch(NullPointerException ex){}
        try{
        this.remove(panelTuContra);
        }catch(NullPointerException ex){}
        try{
        this.remove(panelBandeja);
        }catch(NullPointerException ex){}
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnuAlta;
    private javax.swing.JMenuItem mnuBaja;
    private javax.swing.JMenuItem mnuBandeja;
    private javax.swing.JMenuItem mnuCambiarContra;
    private javax.swing.JMenuItem mnuCambiarTuContra;
    private javax.swing.JMenuItem mnuEnviar;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuVolver;
    // End of variables declaration//GEN-END:variables
}
