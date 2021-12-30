package Vista;

import javax.swing.ImageIcon;

/**
 *
 * @author Camila Carrero
 */
public class BuscarInconveniente extends javax.swing.JDialog {

    public BuscarInconveniente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
         setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        // tAbierto.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bAgregar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        bModificar = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        bEliminar = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        filtro = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        tBuscar = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        bBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Inconveniente");
        setMinimumSize(new java.awt.Dimension(100, 100));
        setResizable(false);

        jPanel5.setPreferredSize(new java.awt.Dimension(495, 495));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 200, 251), 10));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jToolBar1.setRollover(true);

        jSeparator6.setMinimumSize(new java.awt.Dimension(6, 0));
        jToolBar1.add(jSeparator6);

        bAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bAgregar.setText("Agregar");
        bAgregar.setFocusCycleRoot(true);
        bAgregar.setHideActionText(true);
        bAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAgregar.setMaximumSize(new java.awt.Dimension(65, 25));
        bAgregar.setMinimumSize(new java.awt.Dimension(65, 25));
        bAgregar.setName(""); // NOI18N
        bAgregar.setPreferredSize(new java.awt.Dimension(65, 25));
        bAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bAgregar);
        jToolBar1.add(jSeparator5);

        bModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bModificar.setText("Modificar");
        bModificar.setFocusCycleRoot(true);
        bModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bModificar.setMaximumSize(new java.awt.Dimension(65, 25));
        bModificar.setMinimumSize(new java.awt.Dimension(65, 25));
        bModificar.setPreferredSize(new java.awt.Dimension(65, 25));
        jToolBar1.add(bModificar);
        jToolBar1.add(jSeparator7);

        bEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bEliminar.setText("Eliminar");
        bEliminar.setFocusCycleRoot(true);
        bEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEliminar.setMaximumSize(new java.awt.Dimension(65, 25));
        bEliminar.setMinimumSize(new java.awt.Dimension(65, 25));
        bEliminar.setPreferredSize(new java.awt.Dimension(65, 25));
        bEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bEliminar);
        jToolBar1.add(jSeparator8);

        jPanel1.add(jToolBar1, java.awt.BorderLayout.PAGE_END);

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
                "Id", "Nombre", "Dirección", "Localidad", "Tipo de Propiedad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setToolTipText("");
        table.setFocusable(false);
        table.setGridColor(new java.awt.Color(240, 240, 240));
        table.setShowGrid(true);
        jScrollPane2.setViewportView(table);

        jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);

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
        jLabel1.setText("Inconvenientes");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel3);

        jPanel2.setForeground(new java.awt.Color(153, 153, 255));
        jPanel2.setToolTipText("");
        jPanel2.setMinimumSize(new java.awt.Dimension(78, 35));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 70));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        filtro.setBackground(new java.awt.Color(240, 240, 240));
        filtro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nombre", "Dni", "Tipo de Cliente", "Dirección", "Localidad" }));
        jPanel2.add(filtro, new java.awt.GridBagConstraints());

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(25, 0));
        jPanel2.add(jSeparator2, new java.awt.GridBagConstraints());

        tBuscar.setBackground(new java.awt.Color(240, 240, 240));
        tBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tBuscar.setForeground(new java.awt.Color(153, 153, 153));
        tBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tBuscar.setMinimumSize(new java.awt.Dimension(150, 21));
        tBuscar.setName(""); // NOI18N
        tBuscar.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel2.add(tBuscar, new java.awt.GridBagConstraints());

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
        jPanel2.add(bBuscar, new java.awt.GridBagConstraints());

        jPanel4.add(jPanel2);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(BuscarInconveniente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarInconveniente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarInconveniente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarInconveniente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarInconveniente dialog = new BuscarInconveniente(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton bAgregar;
    public static javax.swing.JButton bBuscar;
    public static javax.swing.JButton bEliminar;
    public javax.swing.JButton bModificar;
    public static javax.swing.JComboBox<String> filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JTextField tBuscar;
    public static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}