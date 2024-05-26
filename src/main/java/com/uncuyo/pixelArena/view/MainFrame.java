/*
 */
package com.uncuyo.pixelArena.view;

import com.uncuyo.pixelArena.control.EmpresaControlador;
import com.uncuyo.pixelArena.control.JuegoControlador;
import com.uncuyo.pixelArena.control.TorneoControlador;
import com.uncuyo.pixelArena.model.Empresa;
import com.uncuyo.pixelArena.model.Juego;
import com.uncuyo.pixelArena.model.Torneo;
import com.uncuyo.pixelArena.util.DateUtil;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;
import java.util.List;
import javassist.tools.framedump;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaqu
 */
public class MainFrame extends javax.swing.JFrame {

    private EmpresaControlador empresaControlador;
    private TorneoControlador torneoControlador;
    private JuegoControlador juegoControlador;
    private DateUtil dateUtil;

    public MainFrame() {
        initComponents();
        empresaControlador = new EmpresaControlador();
        torneoControlador = new TorneoControlador();
        juegoControlador = new JuegoControlador();
        dateUtil = new DateUtil();

        llenarTablas();

    }

    public void llenarTablas() {
        //Tabla empresas
        List<Empresa> empresas = empresaControlador.listarEmpresas();
        DefaultTableModel empresaModel = (DefaultTableModel) tablaEmpresas.getModel();
        empresaModel.setRowCount(0);
        String[] empresaTableColumnNames = {"id", "nombre", "email", "numero de teléfono", "activa"};
        empresaModel.setColumnIdentifiers(empresaTableColumnNames);
        for (Empresa empresa : empresas) {
            Object[] rowData = {empresa.getId(), empresa.getNombre(), empresa.getEmail(), empresa.getNumtelefono(), empresa.isActivo()};
            empresaModel.addRow(rowData);
        }

        //Tabla juegos
        List<Juego> juegos = juegoControlador.listarJuegos();
        DefaultTableModel juegoModel = (DefaultTableModel) tablaJuegos.getModel();
        juegoModel.setRowCount(0);
        String[] juegoTableColumnNames = {"id", "nombre", "empresa", "activo"};
        juegoModel.setColumnIdentifiers(juegoTableColumnNames);
        for (Juego juego : juegos) {
            Object[] rowData = {juego.getId(), juego.getNombre(), juego.getEmpresa().getNombre(), juego.isActivo()};
            juegoModel.addRow(rowData);
        }

        //Tabla torneos
        List<Torneo> torneos = torneoControlador.listarTorneos();
        DefaultTableModel torneoModel = (DefaultTableModel) tablaTorneos.getModel();
        torneoModel.setRowCount(0);
        String[] torneoTableColumnNames = {"Número torneo", "Nombre", "Descripción", "Juego", "Fecha inicio", "Fecha final", "Costo inscripción"};
        torneoModel.setColumnIdentifiers(torneoTableColumnNames);
        for (Torneo torneo : torneos) {
            Object[] rowData = {torneo.getNumTorneo(), torneo.getNombreTorneo(), torneo.getDescripcionTorneo(), torneo.getJuego().getNombre(),
                dateUtil.formatearFecha(torneo.getFechaInicioTorneo().toString()), dateUtil.formatearFecha(torneo.getFechaFinalTorneo().toString()), torneo.getCostoInscripcionTorneo()};
            torneoModel.addRow(rowData);
        }
    }

    public void actualizarVentana(JFrame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                llenarTablas();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblCliente1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpresas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        empresaLabel = new javax.swing.JLabel();
        empresaLabel1 = new javax.swing.JLabel();
        añadirEmpresaButton = new javax.swing.JButton();
        modificarEmpresaButton = new javax.swing.JButton();
        modificarJuegoButton = new javax.swing.JButton();
        añadirJuegoButton = new javax.swing.JButton();
        empresaLabel2 = new javax.swing.JLabel();
        modificarTorneoButton = new javax.swing.JButton();
        añadirTorneoButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaJuegos = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaTorneos = new javax.swing.JTable();

        tblCliente1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblCliente1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpresas);

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabel1.setText("PIXEL ARENA");

        empresaLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        empresaLabel.setText("EMPRESAS");

        empresaLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        empresaLabel1.setText("JUEGOS");

        añadirEmpresaButton.setText("Añadir empresa");
        añadirEmpresaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirEmpresaButtonActionPerformed(evt);
            }
        });

        modificarEmpresaButton.setText("Modificar empresa");
        modificarEmpresaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEmpresaButtonActionPerformed(evt);
            }
        });

        modificarJuegoButton.setText("Modificar juego");
        modificarJuegoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarJuegoButtonActionPerformed(evt);
            }
        });

        añadirJuegoButton.setText("Añadir juego");
        añadirJuegoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirJuegoButtonActionPerformed(evt);
            }
        });

        empresaLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        empresaLabel2.setText("TORNEOS");

        modificarTorneoButton.setText("Modificar torneo");
        modificarTorneoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarTorneoButtonActionPerformed(evt);
            }
        });

        añadirTorneoButton.setText("Añadir torneo");
        añadirTorneoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirTorneoButtonActionPerformed(evt);
            }
        });

        tablaJuegos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tablaJuegos);

        tablaTorneos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tablaTorneos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(415, 415, 415))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(empresaLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(añadirEmpresaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modificarEmpresaButton)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(empresaLabel1)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(añadirJuegoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificarJuegoButton)
                        .addGap(32, 32, 32)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(añadirTorneoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificarTorneoButton)
                        .addGap(31, 31, 31))
                    .addComponent(empresaLabel2)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empresaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarEmpresaButton)
                    .addComponent(añadirEmpresaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empresaLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadirJuegoButton)
                    .addComponent(modificarJuegoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empresaLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(añadirTorneoButton)
                    .addComponent(modificarTorneoButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarEmpresaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEmpresaButtonActionPerformed
        EditarEmpresaFrame editarEmpresaFrame = new EditarEmpresaFrame();
        editarEmpresaFrame.setVisible(true);
        actualizarVentana(editarEmpresaFrame);
    }//GEN-LAST:event_modificarEmpresaButtonActionPerformed

    private void modificarJuegoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarJuegoButtonActionPerformed
        EditarJuegoFrame editarJuegoFrame = new EditarJuegoFrame();
        editarJuegoFrame.setVisible(true);
        actualizarVentana(editarJuegoFrame);
    }//GEN-LAST:event_modificarJuegoButtonActionPerformed

    private void modificarTorneoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarTorneoButtonActionPerformed
        EditarTorneoFrame editarTorneoFrame = new EditarTorneoFrame();
        editarTorneoFrame.setVisible(true);
        actualizarVentana(editarTorneoFrame);
    }//GEN-LAST:event_modificarTorneoButtonActionPerformed

    private void añadirEmpresaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirEmpresaButtonActionPerformed
        IngresarEmpresaFrame ingresarEmpresaFrame = new IngresarEmpresaFrame();
        ingresarEmpresaFrame.setVisible(true);
        actualizarVentana(ingresarEmpresaFrame);
    }//GEN-LAST:event_añadirEmpresaButtonActionPerformed

    private void añadirJuegoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirJuegoButtonActionPerformed
        IngresarJuegoFrame ingresarJuegoFrame = new IngresarJuegoFrame();
        ingresarJuegoFrame.setVisible(true);
        actualizarVentana(ingresarJuegoFrame);
    }//GEN-LAST:event_añadirJuegoButtonActionPerformed

    private void añadirTorneoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirTorneoButtonActionPerformed
        IngresarTorneoFrame ingresarTorneoFrame = new IngresarTorneoFrame();
        ingresarTorneoFrame.setVisible(true);
        actualizarVentana(ingresarTorneoFrame);
    }//GEN-LAST:event_añadirTorneoButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirEmpresaButton;
    private javax.swing.JButton añadirJuegoButton;
    private javax.swing.JButton añadirTorneoButton;
    private javax.swing.JLabel empresaLabel;
    private javax.swing.JLabel empresaLabel1;
    private javax.swing.JLabel empresaLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton modificarEmpresaButton;
    private javax.swing.JButton modificarJuegoButton;
    private javax.swing.JButton modificarTorneoButton;
    private javax.swing.JTable tablaEmpresas;
    private javax.swing.JTable tablaJuegos;
    private javax.swing.JTable tablaTorneos;
    private javax.swing.JTable tblCliente1;
    // End of variables declaration//GEN-END:variables
}
