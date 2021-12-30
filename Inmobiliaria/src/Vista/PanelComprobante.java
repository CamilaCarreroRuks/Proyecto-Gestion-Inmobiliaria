package Vista;

/**
 *
 * @author Camila Carrero
 */
public class PanelComprobante extends javax.swing.JPanel {

    public PanelComprobante() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        bAnular = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        bImprimir = new javax.swing.JButton();
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
        tfBuscar = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        bBuscar = new javax.swing.JButton();

        jSeparator1.setBackground(new java.awt.Color(188, 200, 251));
        jSeparator1.setForeground(new java.awt.Color(188, 200, 251));
        jSeparator1.setToolTipText("");

        jSeparator4.setBackground(new java.awt.Color(188, 200, 251));
        jSeparator4.setForeground(new java.awt.Color(188, 200, 251));

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 200, 251), 10));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(150, 28));
        jToolBar1.add(jSeparator5);

        bAnular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bAnular.setText("Anular");
        bAnular.setFocusCycleRoot(true);
        bAnular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAnular.setMaximumSize(new java.awt.Dimension(65, 25));
        bAnular.setMinimumSize(new java.awt.Dimension(65, 25));
        bAnular.setPreferredSize(new java.awt.Dimension(65, 25));
        jToolBar1.add(bAnular);
        jToolBar1.add(jSeparator7);

        bImprimir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bImprimir.setText("Imprimir");
        bImprimir.setFocusCycleRoot(true);
        bImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bImprimir.setMaximumSize(new java.awt.Dimension(65, 25));
        bImprimir.setMinimumSize(new java.awt.Dimension(65, 25));
        bImprimir.setPreferredSize(new java.awt.Dimension(65, 25));
        bImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bImprimir);
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
                "Id", "Fecha", "Monto", "Tipo de Comprobante", "Vigente"
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
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(30);
            table.getColumnModel().getColumn(3).setMinWidth(350);
        }

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
        jLabel1.setText("Comprobantes");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel3);

        jPanel2.setForeground(new java.awt.Color(153, 153, 255));
        jPanel2.setToolTipText("");
        jPanel2.setMinimumSize(new java.awt.Dimension(78, 35));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 70));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        filtro.setBackground(new java.awt.Color(240, 240, 240));
        filtro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Fecha", "Tipo de Comprobante" }));
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
        jPanel2.add(bBuscar, new java.awt.GridBagConstraints());

        jPanel4.add(jPanel2);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bAnular;
    public static javax.swing.JButton bBuscar;
    public javax.swing.JButton bImprimir;
    public static javax.swing.JComboBox<String> filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JTable table;
    public static javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}
