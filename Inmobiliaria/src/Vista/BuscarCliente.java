package Vista;

import javax.swing.ImageIcon;

/**
 *
 * @author Camila Carrero
 */
public class BuscarCliente extends javax.swing.JDialog {

    public BuscarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
         setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        // tAbierto.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        filtro = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        tfBuscar = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        bBuscar = new javax.swing.JButton();
        tAbierto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Cliente");
        setMinimumSize(new java.awt.Dimension(100, 100));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 200, 251), 10));
        jPanel1.setMinimumSize(new java.awt.Dimension(265, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(495, 495));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setMinimumSize(new java.awt.Dimension(23, 100));
        jPanel6.setPreferredSize(new java.awt.Dimension(548, 380));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(null);
        jScrollPane2.setWheelScrollingEnabled(false);

        table.setAutoCreateRowSorter(true);
        table.setBackground(new java.awt.Color(240, 240, 240));
        table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo de Cliente", "Nombre", "DNI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setToolTipText("");
        table.setFocusable(false);
        table.setGridColor(new java.awt.Color(240, 240, 240));
        table.setMaximumSize(new java.awt.Dimension(300, 300));
        table.setMinimumSize(new java.awt.Dimension(100, 100));
        table.setName(""); // NOI18N
        table.setOpaque(false);
        table.setPreferredSize(new java.awt.Dimension(300, 300));
        table.setShowGrid(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        jPanel6.add(jScrollPane2, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel4.setForeground(new java.awt.Color(188, 200, 251));
        jPanel4.setAutoscrolls(true);
        jPanel4.setMinimumSize(new java.awt.Dimension(245, 180));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 130));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setForeground(new java.awt.Color(153, 153, 255));
        jPanel3.setToolTipText("");
        jPanel3.setMinimumSize(new java.awt.Dimension(110, 30));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clientes");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel3);

        jPanel2.setForeground(new java.awt.Color(153, 153, 255));
        jPanel2.setToolTipText("");
        jPanel2.setMinimumSize(new java.awt.Dimension(78, 35));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 70));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        filtro.setBackground(new java.awt.Color(240, 240, 240));
        filtro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nombre", "Dni", "Tipo de Cliente" }));
        jPanel2.add(filtro, new java.awt.GridBagConstraints());

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(25, 0));
        jPanel2.add(jSeparator2, new java.awt.GridBagConstraints());

        tfBuscar.setBackground(new java.awt.Color(240, 240, 240));
        tfBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfBuscar.setForeground(new java.awt.Color(153, 153, 153));
        tfBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tfBuscar.setMinimumSize(new java.awt.Dimension(150, 21));
        tfBuscar.setName(""); // NOI18N
        tfBuscar.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel2.add(tfBuscar, new java.awt.GridBagConstraints());

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setPreferredSize(new java.awt.Dimension(25, 0));
        jPanel2.add(jSeparator3, new java.awt.GridBagConstraints());

        bBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bBuscar.setText("Buscar");
        bBuscar.setFocusCycleRoot(true);
        bBuscar.setHideActionText(true);
        bBuscar.setMaximumSize(new java.awt.Dimension(75, 25));
        bBuscar.setMinimumSize(new java.awt.Dimension(75, 25));
        bBuscar.setPreferredSize(new java.awt.Dimension(75, 25));
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(bBuscar, new java.awt.GridBagConstraints());

        tAbierto.setText("jTextField1");
        jPanel2.add(tAbierto, new java.awt.GridBagConstraints());

        jPanel4.add(jPanel2);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
     /* if(evt.getClickCount() == 2){
        int fila = table.getSelectedRow();
       //agendaG ag = new agendaG();
       //agregarAgenda aa = new agregarAgenda(null, true);
       //aa.tCliente.setText(table.getValueAt(fila, 3).toString());
       //aa.setVisible(true);
       //agregarAgenda.dni = table.getValueAt(fila, 3).toString();
      //cliente c = new cliente();
      //c.setDni(Integer.parseInt(table.getValueAt(fila, 3).toString()));
      agregarAgenda.tCliente.setText(table.getValueAt(fila, 3).toString());
       dispose();
       //setVisible(false);
      }*/
    }//GEN-LAST:event_tableMouseClicked

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
      /*TableModel modelo = new DefaultTableModel();
           clienteConsulta cc = new clienteConsulta(); 
      modelo = cc.buscarClienteX();
           table.setModel(modelo);
            table.getColumn("Id").setPreferredWidth(3);*/
    }//GEN-LAST:event_bBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarCliente dialog = new BuscarCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bBuscar;
    public static javax.swing.JComboBox<String> filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JTextField tAbierto;
    public static javax.swing.JTable table;
    public static javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}
