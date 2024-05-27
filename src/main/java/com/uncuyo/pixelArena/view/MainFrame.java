/*
 */
package com.uncuyo.pixelArena.view;

import com.uncuyo.pixelArena.control.EmpresaControlador;
import com.uncuyo.pixelArena.control.JuegoControlador;
import com.uncuyo.pixelArena.control.TorneoControlador;
import com.uncuyo.pixelArena.data.DbBackUp;
import com.uncuyo.pixelArena.model.Empresa;
import com.uncuyo.pixelArena.model.Juego;
import com.uncuyo.pixelArena.model.Torneo;
import com.uncuyo.pixelArena.pdf.ReportGenerator;
import com.uncuyo.pixelArena.util.DateUtil;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;
import java.util.Date;
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
    private DbBackUp dbBackUp;
    private String backupPath = "C:\\Users\\joaqu\\Documents\\NetBeansProjects\\PixelArena\\backups";

    public MainFrame() {
        initComponents();
        empresaControlador = new EmpresaControlador();
        torneoControlador = new TorneoControlador();
        juegoControlador = new JuegoControlador();
        dateUtil = new DateUtil();
        dbBackUp = new DbBackUp();

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
        backupEmpresa = new javax.swing.JButton();
        backupJuego = new javax.swing.JButton();
        backupTorneo = new javax.swing.JButton();
        restaurarEmpresa = new javax.swing.JButton();
        restaurarTorneo = new javax.swing.JButton();
        restaurarJuego = new javax.swing.JButton();
        backupGeneral = new javax.swing.JButton();
        restaurarGeneral = new javax.swing.JButton();
        generarReporte = new javax.swing.JButton();

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

        backupEmpresa.setText("Hacer backup de empresas");
        backupEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupEmpresaActionPerformed(evt);
            }
        });

        backupJuego.setText("Hacer backup de juegos");
        backupJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupJuegoActionPerformed(evt);
            }
        });

        backupTorneo.setText("Hacer backup de torneos");
        backupTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupTorneoActionPerformed(evt);
            }
        });

        restaurarEmpresa.setText("Restaurar de último backup");
        restaurarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurarEmpresaActionPerformed(evt);
            }
        });

        restaurarTorneo.setText("Restaurar de último backup");
        restaurarTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurarTorneoActionPerformed(evt);
            }
        });

        restaurarJuego.setText("Restaurar de último backup");
        restaurarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurarJuegoActionPerformed(evt);
            }
        });

        backupGeneral.setText("Hacer backup de todos los datos");
        backupGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupGeneralActionPerformed(evt);
            }
        });

        restaurarGeneral.setText("Restaurar de último backup general");
        restaurarGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurarGeneralActionPerformed(evt);
            }
        });

        generarReporte.setText("Generar reporte");
        generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteActionPerformed(evt);
            }
        });

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
                .addGap(128, 128, 128)
                .addComponent(backupEmpresa)
                .addGap(118, 118, 118)
                .addComponent(restaurarEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modificarEmpresaButton)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(empresaLabel1)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(añadirJuegoButton)
                        .addGap(143, 143, 143)
                        .addComponent(backupJuego)
                        .addGap(146, 146, 146)
                        .addComponent(restaurarJuego)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificarJuegoButton)
                        .addGap(32, 32, 32)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(empresaLabel2)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backupGeneral)
                                .addGap(205, 205, 205)
                                .addComponent(generarReporte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(restaurarGeneral))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(añadirTorneoButton)
                                .addGap(139, 139, 139)
                                .addComponent(backupTorneo)
                                .addGap(141, 141, 141)
                                .addComponent(restaurarTorneo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modificarTorneoButton)))
                        .addGap(31, 31, 31))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(añadirEmpresaButton)
                    .addComponent(backupEmpresa)
                    .addComponent(restaurarEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empresaLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadirJuegoButton)
                    .addComponent(modificarJuegoButton)
                    .addComponent(backupJuego)
                    .addComponent(restaurarJuego))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empresaLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(añadirTorneoButton)
                        .addComponent(backupTorneo)
                        .addComponent(restaurarTorneo))
                    .addComponent(modificarTorneoButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backupGeneral)
                    .addComponent(restaurarGeneral)
                    .addComponent(generarReporte))
                .addContainerGap(15, Short.MAX_VALUE))
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

    private void backupJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupJuegoActionPerformed
        dbBackUp.exportTableToCSV("juego", backupPath + "\\juego.csv");
    }//GEN-LAST:event_backupJuegoActionPerformed

    private void backupTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupTorneoActionPerformed
       dbBackUp.exportTableToCSV("torneo", backupPath + "\\torneo.csv");
    }//GEN-LAST:event_backupTorneoActionPerformed

    private void restaurarTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurarTorneoActionPerformed
        dbBackUp.importTableFromCSV("torneo",  backupPath + "\\torneo.csv");
        llenarTablas();
    }//GEN-LAST:event_restaurarTorneoActionPerformed

    private void restaurarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurarJuegoActionPerformed
        dbBackUp.importTableFromCSV("juego",  backupPath + "\\juego.csv");
        llenarTablas();
    }//GEN-LAST:event_restaurarJuegoActionPerformed

    private void backupGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupGeneralActionPerformed
        dbBackUp.exportTableToCSV("empresa", backupPath + "\\empresa.csv");
        dbBackUp.exportTableToCSV("juego", backupPath + "\\juego.csv");
        dbBackUp.exportTableToCSV("torneo", backupPath + "\\torneo.csv");
    }//GEN-LAST:event_backupGeneralActionPerformed

    private void restaurarGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurarGeneralActionPerformed
        dbBackUp.importTableFromCSV("empresa",  backupPath + "\\empresa.csv");
        dbBackUp.importTableFromCSV("juego",  backupPath + "\\juego.csv");
         dbBackUp.importTableFromCSV("torneo",  backupPath + "\\torneo.csv");
         llenarTablas();
    }//GEN-LAST:event_restaurarGeneralActionPerformed

    private void backupEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupEmpresaActionPerformed
        dbBackUp.exportTableToCSV("empresa", backupPath + "\\empresa.csv");
    }//GEN-LAST:event_backupEmpresaActionPerformed

    private void restaurarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurarEmpresaActionPerformed
        dbBackUp.importTableFromCSV("empresa",  backupPath + "\\empresa.csv");
        llenarTablas();
    }//GEN-LAST:event_restaurarEmpresaActionPerformed

    private void generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteActionPerformed
        ReportGenerator reportGenerator = new ReportGenerator();

        try {
            reportGenerator.generarReportePDF(empresaControlador.listarEmpresas(), juegoControlador.listarJuegos(), torneoControlador.listarTorneos(), "C:\\Users\\joaqu\\Documents\\NetBeansProjects\\PixelArena\\reportes\\reporte.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_generarReporteActionPerformed

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
    private javax.swing.JButton backupEmpresa;
    private javax.swing.JButton backupGeneral;
    private javax.swing.JButton backupJuego;
    private javax.swing.JButton backupTorneo;
    private javax.swing.JLabel empresaLabel;
    private javax.swing.JLabel empresaLabel1;
    private javax.swing.JLabel empresaLabel2;
    private javax.swing.JButton generarReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton modificarEmpresaButton;
    private javax.swing.JButton modificarJuegoButton;
    private javax.swing.JButton modificarTorneoButton;
    private javax.swing.JButton restaurarEmpresa;
    private javax.swing.JButton restaurarGeneral;
    private javax.swing.JButton restaurarJuego;
    private javax.swing.JButton restaurarTorneo;
    private javax.swing.JTable tablaEmpresas;
    private javax.swing.JTable tablaJuegos;
    private javax.swing.JTable tablaTorneos;
    private javax.swing.JTable tblCliente1;
    // End of variables declaration//GEN-END:variables
}
