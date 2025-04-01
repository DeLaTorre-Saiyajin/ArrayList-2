package vista;

import controlador.Empresa;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author dam
 */
public class PanelEnviar extends javax.swing.JPanel {

    Empresa miEmpresa;
    Usuario logueado;
    DefaultComboBoxModel modelo;

    public PanelEnviar(Empresa miEmpresa, Usuario logueado) {

        initComponents();
        this.miEmpresa = miEmpresa;
        this.logueado = logueado;
        cargarDirecciones();

    }

    private void cargarDirecciones() {

        ArrayList<Usuario> usuarios = miEmpresa.getUsuarios();
        modelo = new DefaultComboBoxModel();
        cmbUsuarios.setModel(modelo);
        //AÑADIR LAS DIRECCIONES DE CADA USUARIO AL COMBOBOX
        /*for(Usuario u:usuarios){
            modelo.addElement(u.getEmail());
        }*/
        modelo.addElement("SELECCIONA DESTINATARIO");
        //NO DEVUELVE LA DIRECCIÓN DE MEMORIA GRACIAS A TOSTRING
        modelo.addAll(usuarios);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        txtMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbUsuarios = new javax.swing.JComboBox<>();

        jLabel1.setText("EMAIL");

        jLabel2.setText("ASUNTO");

        jLabel3.setText("MENSAJE");

        btnEnviar.setText("ENVIAR");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cmbUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAsunto)
                            .addComponent(txtMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(cmbUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnCancelar))
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        int pos = cmbUsuarios.getSelectedIndex();

        //IF CREADO PARA QUE HASTA QUE NO SE SELECCIONE UN DESTINATARIO EN EL COMBOBOX, NO PUEDAS ENVIAR UN MENSAJE
        if (pos != 0) {

            //OBTENER LA DIRECCIÓN DE CORREO SELECCIONADO EN EL COMBOBOX QUE SERÁ EL DESTINATARIO DEL MENSAJE
            String email = ((Usuario) modelo.getElementAt(cmbUsuarios.getSelectedIndex())).getEmail();

            /*DESUSO
            String email=txtEmail.getText(); LO SUSTITUIMOS POR EL COMBOBOX (LÍNEA EN DESUSO)
            DESUSO*/
            
            String asunto = txtAsunto.getText();
            String texto = txtMensaje.getText();

            boolean resultado = miEmpresa.anadirMensaje(asunto, email, texto, logueado);
            if (resultado) {
                JOptionPane.showMessageDialog(this, "mensaje enviado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "No existe el destinatario");
            }

        } 
        else {
            JOptionPane.showMessageDialog(this, "Primero selecciona el destinatario");
        }


    }//GEN-LAST:event_btnEnviarActionPerformed

    //PARA QUE AL ENVIAR EL MENSAJE SE BORREN LOS CAMPOS DE TEXTO PARA ENVIAR OTRO MENSAJE
    private void limpiar() {

        txtAsunto.setText("");
        txtMensaje.setText("");
        cmbUsuarios.setSelectedIndex(0);

    }


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cmbUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}
