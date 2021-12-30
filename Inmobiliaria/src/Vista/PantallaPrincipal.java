package Vista;

import javax.swing.ImageIcon;

/**
 *
 * @author Camila Carrero
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    public PantallaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        barraMenu = new javax.swing.JMenuBar();
        mClientes = new javax.swing.JMenu();
        smClientes = new javax.swing.JMenuItem();
        smAgregarCliente = new javax.swing.JMenuItem();
        smTipoCliente = new javax.swing.JMenuItem();
        smAgregarTipoCliente = new javax.swing.JMenuItem();
        mPropiedades = new javax.swing.JMenu();
        smPropiedades = new javax.swing.JMenuItem();
        smAgregarPropiedad = new javax.swing.JMenuItem();
        smTipoPropiedad = new javax.swing.JMenuItem();
        smAgregarTipoPropiedad = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        smOperaciones = new javax.swing.JMenuItem();
        smZonas = new javax.swing.JMenuItem();
        mConsorcio = new javax.swing.JMenu();
        mAlquileres = new javax.swing.JMenu();
        mTasacion = new javax.swing.JMenu();
        smGenerarTasacion = new javax.swing.JMenuItem();
        smTasaciones = new javax.swing.JMenuItem();
        mDocumentos = new javax.swing.JMenu();
        smContrato = new javax.swing.JMenuItem();
        smAgregarContrato = new javax.swing.JMenuItem();
        smContabilidad = new javax.swing.JMenuItem();
        smComprobantes = new javax.swing.JMenuItem();
        mHerramientas = new javax.swing.JMenu();
        smAgenda = new javax.swing.JMenuItem();
        smComunicacion = new javax.swing.JMenuItem();
        smInconveniente = new javax.swing.JMenuItem();
        smSeguimiento = new javax.swing.JMenuItem();
        smReportes = new javax.swing.JMenuItem();
        mUsuarios = new javax.swing.JMenu();
        smCerrarSesion = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        smUsuarios = new javax.swing.JMenuItem();
        smAgregarUsuario = new javax.swing.JMenuItem();
        smTipoUsuario = new javax.swing.JMenuItem();
        smAgregarTipoUsuario = new javax.swing.JMenuItem();
        nombreUsuario = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inmobiliaria");
        setFocusCycleRoot(false);
        setIconImage(new ImageIcon("/imagenes/icon.png").getImage());
        setMinimumSize(new java.awt.Dimension(750, 650));

        escritorio.setMinimumSize(new java.awt.Dimension(700, 650));
        escritorio.setPreferredSize(new java.awt.Dimension(700, 650));
        escritorio.setLayout(new java.awt.BorderLayout());
        getContentPane().add(escritorio, java.awt.BorderLayout.CENTER);

        mClientes.setText("Clientes");

        smClientes.setText("Clientes");
        mClientes.add(smClientes);

        smAgregarCliente.setText("Agregar Cliente");
        mClientes.add(smAgregarCliente);

        smTipoCliente.setText("Tipos de Clientes");
        mClientes.add(smTipoCliente);

        smAgregarTipoCliente.setText("Agregar Tipo de Cliente");
        mClientes.add(smAgregarTipoCliente);

        barraMenu.add(mClientes);

        mPropiedades.setText("Propiedades");

        smPropiedades.setText("Propiedades");
        mPropiedades.add(smPropiedades);

        smAgregarPropiedad.setText("Agregar Propiedad");
        mPropiedades.add(smAgregarPropiedad);

        smTipoPropiedad.setText("Tipos de Propiedades");
        mPropiedades.add(smTipoPropiedad);

        smAgregarTipoPropiedad.setText("Agregar Tipo de Propiedad");
        mPropiedades.add(smAgregarTipoPropiedad);
        mPropiedades.add(jSeparator2);

        smOperaciones.setText("Operaciones");
        mPropiedades.add(smOperaciones);

        smZonas.setText("Zonas");
        mPropiedades.add(smZonas);

        barraMenu.add(mPropiedades);

        mConsorcio.setText("Consorcios");
        barraMenu.add(mConsorcio);

        mAlquileres.setText("Alquileres");
        barraMenu.add(mAlquileres);

        mTasacion.setText("Tasación");

        smGenerarTasacion.setText("Generar Tasación");
        mTasacion.add(smGenerarTasacion);

        smTasaciones.setText("Tasaciones");
        mTasacion.add(smTasaciones);

        barraMenu.add(mTasacion);

        mDocumentos.setText("Documentos");

        smContrato.setText("Contrato");
        mDocumentos.add(smContrato);

        smAgregarContrato.setText("Agregar Contrato");
        mDocumentos.add(smAgregarContrato);

        smContabilidad.setText("Contabilidad");
        mDocumentos.add(smContabilidad);

        smComprobantes.setText("Comprobantes");
        mDocumentos.add(smComprobantes);

        barraMenu.add(mDocumentos);

        mHerramientas.setText("Herramientas");

        smAgenda.setText("Agenda");
        smAgenda.setToolTipText("");
        mHerramientas.add(smAgenda);

        smComunicacion.setText("Comunicación");
        mHerramientas.add(smComunicacion);

        smInconveniente.setText("Inconveniente");
        mHerramientas.add(smInconveniente);

        smSeguimiento.setText("Seguimiento");
        mHerramientas.add(smSeguimiento);

        smReportes.setText("Reportes");
        mHerramientas.add(smReportes);

        barraMenu.add(mHerramientas);

        mUsuarios.setText("Usuarios");

        smCerrarSesion.setText("Cerrar Sesion");
        mUsuarios.add(smCerrarSesion);
        mUsuarios.add(jSeparator3);

        smUsuarios.setText("Usuarios");
        mUsuarios.add(smUsuarios);

        smAgregarUsuario.setText("Agregar Usuario");
        mUsuarios.add(smAgregarUsuario);

        smTipoUsuario.setText("Tipos de Usuarios");
        mUsuarios.add(smTipoUsuario);

        smAgregarTipoUsuario.setText("Agregar Tipo de Usuario");
        mUsuarios.add(smAgregarTipoUsuario);

        barraMenu.add(mUsuarios);

        nombreUsuario.setToolTipText("");
        nombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nombreUsuario.setEnabled(false);
        nombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        barraMenu.add(nombreUsuario);

        setJMenuBar(barraMenu);

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuBar barraMenu;
    public static javax.swing.JPanel escritorio;
    public static javax.swing.JPopupMenu.Separator jSeparator2;
    public static javax.swing.JPopupMenu.Separator jSeparator3;
    public static javax.swing.JMenu mAlquileres;
    public static javax.swing.JMenu mClientes;
    public static javax.swing.JMenu mConsorcio;
    public static javax.swing.JMenu mDocumentos;
    public static javax.swing.JMenu mHerramientas;
    public static javax.swing.JMenu mPropiedades;
    public static javax.swing.JMenu mTasacion;
    public static javax.swing.JMenu mUsuarios;
    public static javax.swing.JMenu nombreUsuario;
    public static javax.swing.JMenuItem smAgenda;
    public static javax.swing.JMenuItem smAgregarCliente;
    public static javax.swing.JMenuItem smAgregarContrato;
    public static javax.swing.JMenuItem smAgregarPropiedad;
    public static javax.swing.JMenuItem smAgregarTipoCliente;
    public static javax.swing.JMenuItem smAgregarTipoPropiedad;
    public static javax.swing.JMenuItem smAgregarTipoUsuario;
    public static javax.swing.JMenuItem smAgregarUsuario;
    public static javax.swing.JMenuItem smCerrarSesion;
    public static javax.swing.JMenuItem smClientes;
    public static javax.swing.JMenuItem smComprobantes;
    public static javax.swing.JMenuItem smComunicacion;
    public static javax.swing.JMenuItem smContabilidad;
    public static javax.swing.JMenuItem smContrato;
    public static javax.swing.JMenuItem smGenerarTasacion;
    public static javax.swing.JMenuItem smInconveniente;
    public static javax.swing.JMenuItem smOperaciones;
    public static javax.swing.JMenuItem smPropiedades;
    public static javax.swing.JMenuItem smReportes;
    public static javax.swing.JMenuItem smSeguimiento;
    public static javax.swing.JMenuItem smTasaciones;
    public static javax.swing.JMenuItem smTipoCliente;
    public static javax.swing.JMenuItem smTipoPropiedad;
    public static javax.swing.JMenuItem smTipoUsuario;
    public static javax.swing.JMenuItem smUsuarios;
    public static javax.swing.JMenuItem smZonas;
    // End of variables declaration//GEN-END:variables
}
