/*
 */
package com.uncuyo.pixelArena.view;

import com.uncuyo.pixelArena.control.JuegoControlador;
import com.uncuyo.pixelArena.control.TorneoControlador;
import com.uncuyo.pixelArena.model.Juego;
import com.uncuyo.pixelArena.model.Torneo;
import com.uncuyo.pixelArena.util.DateUtil;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 *
 * @author joaqu
 */
public class EditarTorneoFrame extends javax.swing.JFrame {

    private JuegoControlador juegoControlador;
    private TorneoControlador torneoControlador;
    private DateUtil dateUtil;

    public EditarTorneoFrame() {
        initComponents();
        juegoControlador = new JuegoControlador();
        torneoControlador = new TorneoControlador();
        dateUtil = new DateUtil();
        List<Juego> juegos = juegoControlador.listarJuegos();
        for (Juego juego : juegos) {
            if (juego.isActivo()) {
                juegosBox.addItem(juego.getNombre());
            }
        }
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
        textoDescripcion = new javax.swing.JTextPane();
        aceptarButton = new javax.swing.JToggleButton();
        cancelarButton = new javax.swing.JToggleButton();
        idTorneo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoIdTorneo = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        textoAviso = new javax.swing.JLabel();
        descripcionTorneo = new javax.swing.JLabel();
        juegosBox = new javax.swing.JComboBox<>();
        borrarTorneoButton = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        fechaInicio = new javax.swing.JFormattedTextField();
        fechaFinal = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoCosto = new javax.swing.JTextPane();
        textoAvisoTorneo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar torneo");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Editar torneo");

        jLabel2.setText("Nombre");

        jScrollPane1.setViewportView(textoNombre);

        jLabel3.setText("Juego");

        jScrollPane2.setViewportView(textoDescripcion);

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarClicked(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarClicked(evt);
            }
        });

        idTorneo.setText("Id torneo");

        textoIdTorneo.setText("Ingrese el id del torneo");
        textoIdTorneo.setToolTipText("");
        textoIdTorneo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                idTorneoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                idTorneoMouseExited(evt);
            }
        });
        textoIdTorneo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoIdTorneoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(textoIdTorneo);

        jLabel5.setText("Solamente rellene los campos que desee editar");

        descripcionTorneo.setText("Descripción");

        borrarTorneoButton.setText("Borrar torneo");
        borrarTorneoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarTorneoButtonClicked(evt);
            }
        });

        jLabel4.setText("Fecha inicio");

        fechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/mm/yyyy"))));

        jLabel6.setText("Fecha final");

        jLabel7.setText("Costo inscripción");

        jScrollPane4.setViewportView(textoCosto);

        textoAvisoTorneo.setText("             ");

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
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(idTorneo)
                            .addComponent(descripcionTorneo)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaFinal)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1)
                            .addComponent(juegosBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fechaInicio)
                            .addComponent(jScrollPane4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoAviso)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(aceptarButton))
                        .addGap(122, 122, 122)
                        .addComponent(cancelarButton)
                        .addGap(112, 112, 112)
                        .addComponent(borrarTorneoButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(textoAvisoTorneo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTorneo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descripcionTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(juegosBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aceptarButton)
                            .addComponent(cancelarButton)
                            .addComponent(borrarTorneoButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(textoAviso))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(textoAvisoTorneo)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarClicked
        this.dispose();
    }//GEN-LAST:event_cancelarClicked

    private void idTorneoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idTorneoMouseEntered
        if (textoIdTorneo.getText().equals("Ingrese el id del torneo")) {
            textoIdTorneo.setText("");
        }
    }//GEN-LAST:event_idTorneoMouseEntered

    private void idTorneoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idTorneoMouseExited
        if (textoIdTorneo.getText().equals("")) {
            textoIdTorneo.setText("Ingrese el id del torneo");
        }
    }//GEN-LAST:event_idTorneoMouseExited

    private void aceptarClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarClicked
        if (textoIdTorneo.getText().equals("") || textoIdTorneo.getText().equals("Ingrese el id del torneo")) {
            textoAvisoTorneo.setText("Debe ingresar un id de torneo");
        } else {
            if (!torneoControlador.existeTorneo(textoIdTorneo.getText())) {
                textoAvisoTorneo.setText("No existe el torneo");
            } else {
                textoAvisoTorneo.setText(torneoControlador.modificarTorneo(textoIdTorneo.getText(), textoNombre.getText(), textoDescripcion.getText(), (String) juegosBox.getSelectedItem(), fechaInicio.getText(), fechaFinal.getText(), textoCosto.getText()));
            }
        }
        this.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_aceptarClicked

    private void textoIdTorneoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoIdTorneoKeyReleased
        textoAvisoTorneo.setText("");
        String idTorneo = textoIdTorneo.getText();
        if (!idTorneo.equals("") && !idTorneo.equals("Ingrese el id del torneo")) {
            if (torneoControlador.existeTorneo(idTorneo)) {
                textoAviso.setText("");
                Torneo torneo = torneoControlador.buscarTorneo(idTorneo);
                textoNombre.setText(torneo.getNombreTorneo());
                textoDescripcion.setText(torneo.getDescripcionTorneo());
                juegosBox.setSelectedItem(torneo.getJuego().getNombre());
                fechaInicio.setText(dateUtil.formatearFecha(torneo.getFechaInicioTorneo().toString()));
                fechaFinal.setText(dateUtil.formatearFecha(torneo.getFechaFinalTorneo().toString()));
                textoCosto.setText(String.valueOf(torneo.getCostoInscripcionTorneo()));

            } else {
                textoAvisoTorneo.setText("No existe el torneo");
            }
        }
    }//GEN-LAST:event_textoIdTorneoKeyReleased

    private void borrarTorneoButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarTorneoButtonClicked
        ConfirmarFrame confirmarFrame = new ConfirmarFrame();
        confirmarFrame.setVisible(true);

        confirmarFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (confirmarFrame.getConfirmar()) {
                    textoAvisoTorneo.setText(torneoControlador.borrarTorneo(textoIdTorneo.getText()));
                }
            }
        });

    }//GEN-LAST:event_borrarTorneoButtonClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarTorneoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton aceptarButton;
    private javax.swing.JToggleButton borrarTorneoButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JToggleButton cancelarButton;
    private javax.swing.JLabel descripcionTorneo;
    private javax.swing.JFormattedTextField fechaFinal;
    private javax.swing.JFormattedTextField fechaInicio;
    private javax.swing.JLabel idTorneo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> juegosBox;
    private javax.swing.JLabel textoAviso;
    private javax.swing.JLabel textoAvisoTorneo;
    private javax.swing.JTextPane textoCosto;
    private javax.swing.JTextPane textoDescripcion;
    private javax.swing.JTextPane textoIdTorneo;
    private javax.swing.JTextPane textoNombre;
    // End of variables declaration//GEN-END:variables
}
