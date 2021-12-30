package Vista;

/**
 *
 * @author Camila Carrero
 */
public class PanelInconveniente extends javax.swing.JPanel {

    public PanelInconveniente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        bAgregarComunicacion = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        bModificarComunicaion = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        bModificarEstado = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        bBuscar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        tfId = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        bCargarComunicacion = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 200, 251), 10));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setMinimumSize(new java.awt.Dimension(23, 100));
        jPanel6.setPreferredSize(new java.awt.Dimension(548, 350));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(null);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(450, 470));
        jScrollPane2.setWheelScrollingEnabled(false);

        table.setAutoCreateRowSorter(true);
        table.setBackground(new java.awt.Color(240, 240, 240));
        table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Fecha", "Observaciones"
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
        table.setShowGrid(true);
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(30);
            table.getColumnModel().getColumn(3).setMinWidth(350);
        }

        jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 28));

        jSeparator6.setMinimumSize(new java.awt.Dimension(6, 0));
        jToolBar1.add(jSeparator6);

        bAgregarComunicacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bAgregarComunicacion.setText("Agregar Comunicación");
        bAgregarComunicacion.setPreferredSize(new java.awt.Dimension(113, 28));
        jToolBar1.add(bAgregarComunicacion);
        jToolBar1.add(jSeparator5);

        bModificarComunicaion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bModificarComunicaion.setText("Modificar Comunicación");
        jToolBar1.add(bModificarComunicaion);
        jToolBar1.add(jSeparator8);

        bModificarEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bModificarEstado.setText("Modificar Estado");
        jToolBar1.add(bModificarEstado);
        jToolBar1.add(jSeparator7);

        jPanel6.add(jToolBar1, java.awt.BorderLayout.PAGE_END);

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
        jLabel1.setText("Inconveniente");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel3);

        jPanel2.setForeground(new java.awt.Color(153, 153, 255));
        jPanel2.setToolTipText("");
        jPanel2.setMinimumSize(new java.awt.Dimension(78, 35));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 70));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setPreferredSize(new java.awt.Dimension(110, 0));
        jPanel2.add(jSeparator4, new java.awt.GridBagConstraints());

        bBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bBuscar.setText("Buscar");
        bBuscar.setFocusCycleRoot(true);
        bBuscar.setHideActionText(true);
        bBuscar.setMaximumSize(new java.awt.Dimension(75, 25));
        bBuscar.setMinimumSize(new java.awt.Dimension(75, 25));
        bBuscar.setPreferredSize(new java.awt.Dimension(75, 28));
        jPanel2.add(bBuscar, new java.awt.GridBagConstraints());

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(25, 0));
        jPanel2.add(jSeparator2, new java.awt.GridBagConstraints());

        tfId.setBackground(new java.awt.Color(240, 240, 240));
        tfId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfId.setForeground(new java.awt.Color(153, 153, 153));
        tfId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tfId.setMinimumSize(new java.awt.Dimension(180, 21));
        tfId.setName(""); // NOI18N
        tfId.setPreferredSize(new java.awt.Dimension(180, 30));
        jPanel2.add(tfId, new java.awt.GridBagConstraints());

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setPreferredSize(new java.awt.Dimension(25, 0));
        jPanel2.add(jSeparator3, new java.awt.GridBagConstraints());

        bCargarComunicacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bCargarComunicacion.setText("Cargar Comunicaciones");
        bCargarComunicacion.setFocusCycleRoot(true);
        bCargarComunicacion.setHideActionText(true);
        bCargarComunicacion.setMaximumSize(new java.awt.Dimension(75, 25));
        bCargarComunicacion.setMinimumSize(new java.awt.Dimension(75, 25));
        bCargarComunicacion.setPreferredSize(new java.awt.Dimension(185, 28));
        jPanel2.add(bCargarComunicacion, new java.awt.GridBagConstraints());

        jPanel4.add(jPanel2);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bAgregarComunicacion;
    public static javax.swing.JButton bBuscar;
    public static javax.swing.JButton bCargarComunicacion;
    public javax.swing.JButton bModificarComunicaion;
    public javax.swing.JButton bModificarEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JTable table;
    public static javax.swing.JTextField tfId;
    // End of variables declaration//GEN-END:variables
}
