/*
 */
package com.uncuyo.pixelArena.view;

import com.uncuyo.pixelArena.control.JuegoControlador;
import com.uncuyo.pixelArena.model.Juego;

/**
 *
 * @author joaqu
 */
public class EditarJuegoFrame extends javax.swing.JFrame {

    private JuegoControlador juegoControlador;

    public EditarJuegoFrame() {
        initComponents();
        juegoControlador = new JuegoControlador();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoNombre = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoIdEmpresa = new javax.swing.JTextPane();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoIdJuego = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        textoAviso = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        estadoJuego = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar juego");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Editar Juego");

        jLabel2.setText("Nombre");

        jScrollPane1.setViewportView(textoNombre);

        jLabel3.setText("Estado juego");

        jScrollPane2.setViewportView(textoIdEmpresa);

        jToggleButton1.setText("Aceptar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarClicked(evt);
            }
        });

        jToggleButton2.setText("Cancelar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarClicked(evt);
            }
        });

        jLabel4.setText("Id juego");

        textoIdJuego.setText("Ingrese el id del juego");
        textoIdJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                idJuegoEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                idJuegoExited(evt);
            }
        });
        textoIdJuego.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoIdJuegoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(textoIdJuego);

        jLabel5.setText("Solamente rellene los campos que desee editar");

        jLabel6.setText("Id de empresa");

        estadoJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoAviso)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButton2)
                                .addGap(50, 50, 50))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2))
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1)
                            .addComponent(estadoJuego, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(estadoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton1)
                            .addComponent(jToggleButton2))
                        .addGap(38, 38, 38)
                        .addComponent(textoAviso))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarClicked
        this.dispose();
    }//GEN-LAST:event_cancelarClicked

    private void idJuegoEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idJuegoEntered
        if (textoIdJuego.getText().equals("Ingrese el id del juego")) {
            textoIdJuego.setText("");
        }
    }//GEN-LAST:event_idJuegoEntered

    private void idJuegoExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idJuegoExited
        if (textoIdJuego.getText().equals("")) {
            textoIdJuego.setText("Ingrese el id del juego");
        }
    }//GEN-LAST:event_idJuegoExited

    private void aceptarClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarClicked
        if (textoIdJuego.getText().equals("") || textoIdJuego.getText().equals("Ingrese el id del juego")) {
            textoAviso.setText("Debe ingresar un id de juego");
        } else {
            if (!juegoControlador.existeJuego(textoIdJuego.getText())) {
                textoAviso.setText("No existe el juego");
            } else {
                textoAviso.setText(juegoControlador.modificarJuego(textoIdJuego.getText(), textoNombre.getText(), textoIdEmpresa.getText(), (String) estadoJuego.getSelectedItem()));
            }
        }
        this.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_aceptarClicked

    private void textoIdJuegoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoIdJuegoKeyReleased
        String idJuego = textoIdJuego.getText();
        if (!idJuego.equals("") && !idJuego.equals("Ingrese el id del juego")) {
            if (juegoControlador.existeJuego(idJuego)) {
                Juego juego = juegoControlador.buscarJuegoPorId(idJuego);
                textoNombre.setText(juego.getNombre());
                textoIdEmpresa.setText(String.valueOf(juego.getEmpresa().getId()));
                if(!juego.isActivo()){
                    estadoJuego.setSelectedItem("Inactivo");
                }else{
                    estadoJuego.setSelectedItem("Activo");
                }
            } else {
                textoNombre.setText("Ingrese el nombre");
                textoIdEmpresa.setText("Ingrese el id de la empresa");
                textoAviso.setText("No existe el juego");
            }
        }
    }//GEN-LAST:event_textoIdJuegoKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarJuegoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> estadoJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel textoAviso;
    private javax.swing.JTextPane textoIdEmpresa;
    private javax.swing.JTextPane textoIdJuego;
    private javax.swing.JTextPane textoNombre;
    // End of variables declaration//GEN-END:variables
}
