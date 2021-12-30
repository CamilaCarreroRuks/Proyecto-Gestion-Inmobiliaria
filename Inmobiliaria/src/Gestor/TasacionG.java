package Gestor;

import Librerias.Numeros;
import Librerias.ValidarCaracteres;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import Modelo.Categoria;
import Modelo.CategoriaConsulta;
import Modelo.ClienteConsulta;
import Modelo.Direccion;
import Modelo.DireccionConsulta;
import Modelo.Localidad;
import Modelo.LocalidadConsulta;
import Modelo.Tasacion;
import Modelo.TasacionConsulta;
import Modelo.TipoPropiedadConsulta;
import Vista.BuscarCliente;
import Vista.GenerarTasacion;
import Vista.CategorizarPropiedad;
import Vista.PanelTasacion;
import static Vista.PantallaPrincipal.escritorio;
import Vista.Reportes.TasacionPresentacion;
import Modelo.Usuario;
import Modelo.UsuarioConsulta;

/**
 *
 * @author Camila Carrero
 */
public class TasacionG implements ActionListener, MouseListener, KeyListener, WindowListener {

    Tasacion t = new Tasacion();
    TasacionConsulta tc = new TasacionConsulta();
    GenerarTasacion formGT = new GenerarTasacion(null, true);
    CategorizarPropiedad formC = new CategorizarPropiedad(null, true);
    TasacionPresentacion tpre = new TasacionPresentacion();
    PanelTasacion pt = new PanelTasacion();
    JDialog jd = new JDialog(formGT);

    public TasacionG() {
        iniciar(t, tc, formGT, formC, tpre, pt);
    }

    public void iniciar(Tasacion t, TasacionConsulta tc, GenerarTasacion formGT, CategorizarPropiedad formC, TasacionPresentacion tpre, PanelTasacion pt) { //Inicia las variables y agrega los listener.
        this.t = t;
        this.tc = tc;
        this.formGT = formGT;
        this.formC = formC;
        this.tpre = tpre;
        this.pt = pt;
        this.formGT.addWindowListener(this);
        this.formGT.bCategorizar.addActionListener(this);
        this.formGT.bGenerar.addActionListener(this);
        this.formGT.bAgregarCliente.addActionListener(this);
        this.formGT.tCliente.addKeyListener(this);
        this.formGT.tAños.addKeyListener(this);
        this.formGT.tM2Construccion.addKeyListener(this);
        this.formGT.tM2Terreno.addKeyListener(this);
        this.formGT.tVB.addKeyListener(this);
        this.formGT.tVM2.addKeyListener(this);
        this.formGT.tCalle.addKeyListener(this);
        this.formGT.tNumero.addKeyListener(this);
        this.formGT.tDepartamento.addKeyListener(this);
        this.formC.bGenerar.addActionListener(this);
        this.tpre.bGuardar.addActionListener(this);
        this.pt.bAgregar.addActionListener(this);
        this.pt.bBuscar.addActionListener(this);
        this.pt.bEliminar.addActionListener(this);
        this.pt.bAgregarPropiedad.addActionListener(this);
        this.pt.bImprimir.addActionListener(this);
        this.pt.table.addMouseListener(this);
        this.formC.a1.addMouseListener(this);
        this.formC.b1.addMouseListener(this);
        this.formC.c1.addMouseListener(this);
        this.formC.d1.addMouseListener(this);
        this.formC.a2.addMouseListener(this);
        this.formC.b2.addMouseListener(this);
        this.formC.c2.addMouseListener(this);
        this.formC.d2.addMouseListener(this);
        this.formC.a3.addMouseListener(this);
        this.formC.b3.addMouseListener(this);
        this.formC.c3.addMouseListener(this);
        this.formC.d3.addMouseListener(this);
        this.formC.a4.addMouseListener(this);
        this.formC.b4.addMouseListener(this);
        this.formC.c4.addMouseListener(this);
        this.formC.d4.addMouseListener(this);
        this.formC.a5.addMouseListener(this);
        this.formC.b5.addMouseListener(this);
        this.formC.c5.addMouseListener(this);
        this.formC.d5.addMouseListener(this);
        this.formC.a6.addMouseListener(this);
        this.formC.b6.addMouseListener(this);
        this.formC.c6.addMouseListener(this);
        this.formC.d6.addMouseListener(this);
        this.formC.a7.addMouseListener(this);
        this.formC.b7.addMouseListener(this);
        this.formC.c7.addMouseListener(this);
        this.formC.d7.addMouseListener(this);
        this.formC.a8.addMouseListener(this);
        this.formC.b8.addMouseListener(this);
        this.formC.c8.addMouseListener(this);
        this.formC.d8.addMouseListener(this);
        this.formC.a9.addMouseListener(this);
        this.formC.b9.addMouseListener(this);
        this.formC.c9.addMouseListener(this);
        this.formC.d9.addMouseListener(this);
        this.formC.a10.addMouseListener(this);
        this.formC.b10.addMouseListener(this);
        this.formC.c10.addMouseListener(this);
        this.formC.d10.addMouseListener(this);
        this.formC.a11.addMouseListener(this);
        this.formC.b11.addMouseListener(this);
        this.formC.c11.addMouseListener(this);
        this.formC.d11.addMouseListener(this);
        this.formC.a12.addMouseListener(this);
        this.formC.b12.addMouseListener(this);
        this.formC.c12.addMouseListener(this);
        this.formC.d12.addMouseListener(this);
        this.formC.a13.addMouseListener(this);
        this.formC.b13.addMouseListener(this);
        this.formC.c13.addMouseListener(this);
        this.formC.d13.addMouseListener(this);
        this.formC.a14.addMouseListener(this);
        this.formC.b14.addMouseListener(this);
        this.formC.c14.addMouseListener(this);
        this.formC.d14.addMouseListener(this);
        this.formC.a15.addMouseListener(this);
        this.formC.b15.addMouseListener(this);
        this.formC.c15.addMouseListener(this);
        this.formC.d15.addMouseListener(this);
        this.formC.a16.addMouseListener(this);
        this.formC.b16.addMouseListener(this);
        this.formC.c16.addMouseListener(this);
        this.formC.d16.addMouseListener(this);
        this.formC.a17.addMouseListener(this);
        this.formC.b17.addMouseListener(this);
        this.formC.c17.addMouseListener(this);
        this.formC.d17.addMouseListener(this);
        this.formC.a18.addMouseListener(this);
        this.formC.b18.addMouseListener(this);
        this.formC.c18.addMouseListener(this);
        this.formC.d18.addMouseListener(this);
        this.formC.a19.addMouseListener(this);
        this.formC.b19.addMouseListener(this);
        this.formC.c19.addMouseListener(this);
        this.formC.d19.addMouseListener(this);
        this.formC.a20.addMouseListener(this);
        this.formC.b20.addMouseListener(this);
        this.formC.c20.addMouseListener(this);
        this.formC.d20.addMouseListener(this);
        this.formC.a21.addMouseListener(this);
        this.formC.b21.addMouseListener(this);
        this.formC.c21.addMouseListener(this);
        this.formC.d21.addMouseListener(this);
        this.formC.a22.addMouseListener(this);
        this.formC.b22.addMouseListener(this);
        this.formC.c22.addMouseListener(this);
        this.formC.d22.addMouseListener(this);
        this.formC.a23.addMouseListener(this);
        this.formC.b23.addMouseListener(this);
        this.formC.c23.addMouseListener(this);
        this.formC.d23.addMouseListener(this);
        this.formC.a24.addMouseListener(this);
        this.formC.b24.addMouseListener(this);
        this.formC.c24.addMouseListener(this);
        this.formC.d24.addMouseListener(this);
        this.formC.a25.addMouseListener(this);
        this.formC.b25.addMouseListener(this);
        this.formC.c25.addMouseListener(this);
        this.formC.d25.addMouseListener(this);
        this.formC.a26.addMouseListener(this);
        this.formC.b26.addMouseListener(this);
        this.formC.c26.addMouseListener(this);
        this.formC.d26.addMouseListener(this);
    }

    public void generarTasacion(boolean v) { //Abre el formulario GenerarTasacion.
        formGT.localidad.removeAllItems();
        formGT.tipoPropiedad.removeAllItems();
        ArrayList tp = TipoPropiedadConsulta.listaTipoPropiedad();
        for (int i = 0; i < tp.size(); i++) {
            formGT.tipoPropiedad.addItem(tp.get(i).toString());
        }
        ArrayList l = LocalidadConsulta.listaLocalidad();
        for (int e = 0; e < l.size(); e++) {
            formGT.localidad.addItem(l.get(e).toString());
        }
        formGT.tilde.setVisible(false);
        formGT.tIdCategoria.setText(null);
        formGT.tIdCategoria.setVisible(false);
        if (v) {
            formGT.setVisible(true);
        }
    }

    public void categorizar() { //Abre el formulario CategorizarPropiedad.
        formC.c9.setEnabled(false);
        formC.setVisible(true);
    }

    public void abrirPanel() { //Abre el PanelTasacion.
        UsuarioConsulta uc = new UsuarioConsulta();
        Usuario usu = new Usuario();
        usu.setNombreUsuario(Vista.PantallaPrincipal.nombreUsuario.getText().replace("   USUARIO:  ", ""));
        UsuarioG.darPermisos(uc.obtenerTipoUsuario(usu), "Tasación");
        anularBoton("panel");
        pt.setVisible(true);
        pt.setSize(500, 500);
        pt.setLocation(0, 0);
        escritorio.removeAll();
        escritorio.add(pt);
        escritorio.revalidate();
        escritorio.repaint();
    }

    public void anularBoton(String nom) { //Edita los botones para estar o no disponibles.
        if (nom == "0") {
            formGT.bGenerar.setEnabled(true);
            pt.bEliminar.setEnabled(true);
        } else if (nom == "panel") {
            pt.bEliminar.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formGT.bCategorizar) {
            if (!formGT.tilde.isVisible()) {
                categorizar();
            } else {
                int opcion = JOptionPane.showConfirmDialog(null, "Ya existe una categoria\n¿Desea modificarla?", "Seleccione una opción", 0, 0);
                if (opcion == JOptionPane.YES_OPTION) {
                    categorizar();
                }
            }
        }

        if (e.getSource() == formGT.bGenerar) {
            if (validarCampos()) {
                String dia = Integer.toString(formGT.fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
                String mes = Integer.toString(formGT.fecha.getCalendar().get(Calendar.MARCH));
                String año = Integer.toString(formGT.fecha.getCalendar().get(Calendar.YEAR));
                String formato = "dd/MM/yyyy";
                Date fecha = formGT.fecha.getDate();
                SimpleDateFormat forma = new SimpleDateFormat(formato);
                t.setFecha(forma.format(fecha));
                ClienteConsulta cc = new ClienteConsulta();
                t.setIdCliente(cc.obtenerId(formGT.tCliente.getText()));
                t.setIdCategoria(Integer.parseInt(formGT.tIdCategoria.getText()));
                DireccionConsulta dc = new DireccionConsulta();
                LocalidadConsulta lc = new LocalidadConsulta();
                Direccion d = new Direccion();
                Localidad l = new Localidad();
                d.setCalle(formGT.tCalle.getText());
                d.setNumero(Integer.parseInt(formGT.tNumero.getText()));
                d.setDepartamento(formGT.tDepartamento.getText());
                l.setNombreLocalidad(formGT.localidad.getSelectedItem().toString());
                d.setIdLocalidad(lc.obtenerId(l));
                if (dc.direccionExiste(d) == false) {
                    dc.registrar(d);
                }
                t.setIdDireccion(dc.obtenerId(d));
                TipoPropiedadConsulta tpc = new TipoPropiedadConsulta();
                t.setIdTipoPropiedad(tpc.obtenerId(formGT.tipoPropiedad.getSelectedItem().toString()));
                t.setAños(Integer.parseInt(formGT.tAños.getText()));
                t.setEstado(obtenerNumEstado());
                t.setM2Construccion(Double.parseDouble(formGT.tM2Construccion.getText()));
                t.setM2Terreno(Double.parseDouble(formGT.tM2Terreno.getText()));
                t.setValorBolsa(Double.parseDouble(formGT.tVB.getText()));
                t.setValorM2Terreno(Double.parseDouble(formGT.tVM2.getText()));
                t.setValorResidual(Double.parseDouble(formGT.valorResidual.getSelectedItem().toString()));
                if (tc.existeConstantes(t)) {
                    t.setIdConstantes(tc.obtenerIdConstantes(t));
                } else {
                    tc.registrarConstantes(t);
                    t.setIdConstantes(tc.obtenerIdConstantes(t));
                }
                if (tc.registrarDatos(t)) {
                    t.setIdDatos(tc.obtenerIdDatos(t));
                    if (t.getIdDatos() != 0) {
                        if (tc.registrar(t)) {
                            JOptionPane.showMessageDialog(null, "Registro exitoso");
                        }
                    }
                }
                t.setIdTasacion(tc.obtenerIdTasacion(t));
                DecimalFormat df = new DecimalFormat("###,###.##");
                try {
                    tpre.tCA.setText(formGT.tVB.getText());
                    tpre.tCB.setText(formGT.tVB.getText());
                    tpre.tCC.setText(formGT.tVB.getText());
                    tpre.tCD.setText(formGT.tVB.getText());
                    tpre.tCFA.setText(df.format(Integer.parseInt(tpre.tCA.getText()) * Integer.parseInt(tpre.tCBA.getText())));
                    tpre.tCFB.setText(df.format(Integer.parseInt(tpre.tCB.getText()) * Integer.parseInt(tpre.tCBB.getText())));
                    tpre.tCFC.setText(df.format(Integer.parseInt(tpre.tCC.getText()) * Integer.parseInt(tpre.tCBC.getText())));
                    tpre.tCFD.setText(df.format(Integer.parseInt(tpre.tCD.getText()) * Integer.parseInt(tpre.tCBD.getText())));
                    ArrayList cat = CategoriaConsulta.listaCategoria(Integer.parseInt(formGT.tIdCategoria.getText()));
                    tpre.tTipoA.setText(cat.get(0).toString());
                    tpre.tTipoB.setText(cat.get(1).toString());
                    tpre.tTipoC.setText(cat.get(2).toString());
                    tpre.tTipoD.setText(cat.get(3).toString());
                    tpre.tM2A.setText(tpre.tCFA.getText());
                    tpre.tM2B.setText(tpre.tCFB.getText());
                    tpre.tM2C.setText(tpre.tCFC.getText());
                    tpre.tM2D.setText(tpre.tCFD.getText());
                    tpre.tVM2TA.setText(df.format(df.parse(tpre.tTipoA.getText()).doubleValue() * df.parse(tpre.tM2A.getText()).doubleValue()));
                    tpre.tVM2TB.setText(df.format(df.parse(tpre.tTipoB.getText()).doubleValue() * df.parse(tpre.tM2B.getText()).doubleValue()));
                    tpre.tVM2TC.setText(df.format(df.parse(tpre.tTipoC.getText()).doubleValue() * df.parse(tpre.tM2C.getText()).doubleValue()));
                    tpre.tVM2TD.setText(df.format(df.parse(tpre.tTipoD.getText()).doubleValue() * df.parse(tpre.tM2D.getText()).doubleValue()));
                    tpre.tTotalTipo.setText(Integer.toString((Integer.parseInt(tpre.tTipoA.getText())) + Integer.parseInt(tpre.tTipoB.getText())
                            + Integer.parseInt(tpre.tTipoC.getText()) + Integer.parseInt(tpre.tTipoD.getText())));
                    tpre.tTotalM2T.setText(df.format((df.parse(tpre.tVM2TA.getText()).doubleValue()) + (df.parse(tpre.tVM2TB.getText()).doubleValue())
                            + (df.parse(tpre.tVM2TC.getText()).doubleValue()) + (df.parse(tpre.tVM2TD.getText()).doubleValue())));
                    Double tVM2Promedio = ((df.parse(tpre.tTotalM2T.getText()).doubleValue()) / (df.parse(tpre.tTotalTipo.getText()).doubleValue()));
                    tpre.tVM2Promedio.setText(df.format(tVM2Promedio));
                    tpre.tVM2.setText(tpre.tVM2Promedio.getText());
                    tpre.tM2.setText(formGT.tM2Construccion.getText());
                    Double tVNuevo = ((df.parse(tpre.tVM2.getText()).doubleValue()) * (df.parse(tpre.tM2.getText()).doubleValue()));
                    tpre.tVNuevo.setText(df.format(tVNuevo));
                    tpre.tVM2Terreno.setText(formGT.tVM2.getText());
                    tpre.tM2Terreno.setText(formGT.tM2Terreno.getText());
                    tpre.tVTerreno.setText(df.format((Double.parseDouble(tpre.tVM2Terreno.getText())) * (Double.parseDouble(tpre.tM2Terreno.getText()))));
                    tpre.tVN.setText(tpre.tVNuevo.getText());
                    tpre.tVR.setText(formGT.valorResidual.getSelectedItem().toString());
                    String estado = obtenerNumEstado();
                    Double coef = tc.obtenerCoef(estado, formGT.tAños.getText());
                    tpre.tCoef.setText(Double.toString(tc.obtenerCoef(estado, formGT.tAños.getText())).replace(".", ","));
                    Double vn = df.parse(tpre.tVN.getText()).doubleValue();
                    String tVActual = df.format((vn) - (((vn) - ((vn) * (df.parse(tpre.tVR.getText()).doubleValue()))) * (tc.obtenerCoef(estado, formGT.tAños.getText()))));
                    tpre.tVActual.setText(tVActual);
                    DecimalFormat dft = new DecimalFormat("###,###");
                    String tvv = dft.format(Double.parseDouble(tpre.tVActual.getText().replace(".", "").replace(",", ".")));
                    //tpre.tVV.setText(tpre.tVActual.getText());
                    tpre.tVV.setText(tvv);
                    String tvt = dft.format(Double.parseDouble(tpre.tVTerreno.getText().replace(".", "")));
                    //tpre.tVT.setText(tpre.tVTerreno.getText());
                    tpre.tVT.setText(tvt);
                    String tVTotal = df.format((df.parse(tpre.tVV.getText()).doubleValue()) + (df.parse(tpre.tVT.getText()).doubleValue()));
                    tpre.tVTotal.setText(tVTotal);
                } catch (ParseException ex) {
                    Logger.getLogger(TasacionG.class.getName()).log(Level.SEVERE, null, ex);
                }
                limpiar();
                jd.setSize(1100, 700);
                jd.add(tpre);
                jd.setLocationRelativeTo(null);
                jd.setVisible(true);
                tpre.tIdTasacion.setText(Integer.toString(t.getIdTasacion()));
                tpre.tIdTasacion.setVisible(false);
                //formGT.dispose();
                tpre.setVisible(true);
            }
        }

        if (e.getSource() == tpre.bGuardar) {
            t.setIdTasacion(Integer.parseInt(tpre.tIdTasacion.getText()));
            t.setValorConstruccion(Integer.parseInt(tpre.tVV.getText().replace(".", "")));
            t.setValorTerreno(Integer.parseInt(tpre.tVT.getText().replace(".", "")));
            t.setValorTotal(Integer.parseInt(tpre.tVTotal.getText().replace(".", "")));
            tc.registrarValor(t);
            t.setIdValores(tc.obtenerIdValores(t));
            tc.modificarIdValores(t);
            jd.setVisible(false);
            generarReporteTasacion(t);
        }

        if (e.getSource() == pt.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = tc.buscarTasacion();
            pt.table.setModel(modelo);
            pt.table.getColumn("Id").setPreferredWidth(3);
        }

        if (e.getSource() == pt.bAgregar) {
            generarTasacion(true);
        }

        if (e.getSource() == pt.bEliminar) {
            cargarDatos();
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Cliente seleccionado?", "Seleccione una opción", 0, 0);
            if (opcion == JOptionPane.YES_OPTION) {
                tc.eliminar(t);
                pt.bBuscar.doClick();
            }
        }

        if (e.getSource() == pt.bAgregarPropiedad) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = ((DefaultTableModel) pt.table.getModel());
            String id = modelo.getValueAt(pt.table.getSelectedRow(), 0).toString();
            // tc.tasacionXId(id);
            //JTable tabla = new JTable(tc.tasacionXId(id));
            //modelo = (DefaultTableModel) tabla.getModel();
            PropiedadG pg = new PropiedadG();
            TipoPropiedadConsulta tpc = new TipoPropiedadConsulta();
            t.setIdCliente(Integer.parseInt(modelo.getValueAt(0, 1).toString()));
            t.setIdTipoPropiedad(tpc.obtenerId(modelo.getValueAt(0, 2).toString()));
            t.setIdDireccion(tc.obtenerIdDirec(id));
            pg.abrirFormPropiedad();
        }

        if (e.getSource() == pt.bImprimir) {
            t.setIdTasacion(Integer.parseInt(pt.table.getValueAt(pt.table.getSelectedRow(), 0).toString()));
            t.setValorConstruccion(Integer.parseInt(pt.table.getValueAt(pt.table.getSelectedRow(), 6).toString().replace(".", "")));
            t.setValorTerreno(Integer.parseInt(pt.table.getValueAt(pt.table.getSelectedRow(), 7).toString().replace(".", "")));
            t.setValorTotal(Integer.parseInt(pt.table.getValueAt(pt.table.getSelectedRow(), 8).toString().replace(".", "")));
            generarReporteTasacion(t);
        }

        if (e.getSource() == formGT.bAgregarCliente) {
            ClienteG cg = new ClienteG();
            BuscarCliente.tAbierto.setText("Tasación");
            cg.buscarCliente();
        }

        if (e.getSource() == formC.bGenerar) {
            if (validarCategorizacion()) {
                Categoria c = new Categoria();
                CategoriaConsulta cac = new CategoriaConsulta();
                c.setTipoA(sumaCategoriaA());
                c.setTipoB(sumaCategoriaB());
                c.setTipoC(sumaCategoriaC());
                c.setTipoD(sumaCategoriaD());
                int suma = c.getTipoA() + c.getTipoB() + c.getTipoC() + c.getTipoD();
                if (suma >= 15) {
                    if (cac.registrar(c)) {
                        formGT.tIdCategoria.setText(Integer.toString(cac.obtenerId(c)));
                        formGT.tilde.setVisible(true);
                        formC.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar mas caracteristicas de la vivienda");
                }
            }
        }
    }

    public void cargarDatos() { //Carga datos en una instancia del objeto Tasación obtenidos de la tabla de PanelTasacion.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) pt.table.getModel());
        String id = modelo.getValueAt(pt.table.getSelectedRow(), 0).toString();
        t.setIdTasacion(Integer.parseInt(id));
    }

    public TableModel cargaDatosModificar() { //Carga los datos de la Tasación en FormTasacion para modificarlo.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) pt.table.getModel());
        try {
            String id = modelo.getValueAt(pt.table.convertRowIndexToView(pt.table.getSelectedRow()), 0).toString();
            JTable tabla = new JTable(tc.tasacionXId(Integer.parseInt(id)));
            modelo = (DefaultTableModel) tabla.getModel();
            generarTasacion(false);
            formGT.tCliente.setText(modelo.getValueAt(0, 1).toString());
            String formato = "dd/MM/yyyy";
            SimpleDateFormat forma = new SimpleDateFormat(formato);
            Date fecha = forma.parse(modelo.getValueAt(0, 0).toString());
            formGT.fecha.setDate(fecha);
            String tc = modelo.getValueAt(0, 2).toString();
            formGT.tipoPropiedad.setSelectedItem(tc);
            formGT.tCalle.setText(modelo.getValueAt(0, 3).toString());
            formGT.tNumero.setText(modelo.getValueAt(0, 4).toString());
            formGT.tDepartamento.setText(modelo.getValueAt(0, 5).toString());
            String loc = modelo.getValueAt(0, 6).toString();
            formGT.localidad.setSelectedItem(loc);
            formGT.tVB.setText(modelo.getValueAt(0, 7).toString());
            formGT.tVM2.setText(modelo.getValueAt(0, 8).toString());
            formGT.valorResidual.setSelectedItem(modelo.getValueAt(0, 9).toString());
            formGT.tAños.setText(modelo.getValueAt(0, 10).toString());
            formGT.estado.setSelectedItem(obtenerEstado(modelo.getValueAt(0, 11).toString()));
            formGT.tM2Construccion.setText(modelo.getValueAt(0, 12).toString());
            formGT.tM2Terreno.setText(modelo.getValueAt(0, 13).toString());
            formGT.setVisible(true);
            return modelo;
        } catch (Exception e) {
            System.out.println("error al cargar datos modificar \n" + e);
        }
        return modelo;
    }

    public void generarReporteTasacion(Tasacion t) { //Genera el informe de la Tasación.
        TableModel modelo = new DefaultTableModel();
        TableModel modelo1 = new DefaultTableModel();
        ClienteConsulta cc = new ClienteConsulta();
        modelo = cc.clienteTasacion(t.getIdTasacion());
        modelo1 = tc.tasacionXId(t.getIdTasacion());
        String fecha = modelo1.getValueAt(0, 0).toString();
        String f[] = fecha.split("/");
        String año = f[2];
        String dia = f[0];
        String mes = f[1];
        String MES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String mes1 = MES[Integer.parseInt(mes) - 1];
        DecimalFormat df = new DecimalFormat("###,###.##");
        String construccion = df.format(t.getValorConstruccion());
        String lote = df.format(t.getValorTerreno());
        String total = df.format(t.getValorTotal());
        boolean bCons = Numeros.tieneDecimales(construccion);
        boolean bLote = Numeros.tieneDecimales(lote);
        boolean bTotal = Numeros.tieneDecimales(total);
        String report = "En la ciudad de Paraná, a los " + dia + " días del mes de " + mes1 + " de " + año
                + ", a petición del Sr./Sra. " + modelo.getValueAt(0, 1) + ", D.N.I N° " + modelo.getValueAt(0, 2)
                + ", con domicilio en la calle " + modelo.getValueAt(0, 3) + " de la ciudad de " + modelo.getValueAt(0, 4)
                + ", y en carácter de Corredor Público Inmobiliario (mat. N° XXX del Colegio de "
                + "Corredores  Públicos Inmobiliarios de Entre Ríos) manifiesto que conforme a la finalidad y métodos de valoración justificados y empleados, "
                + "y a lo expuesto en el presente informe, se puede concluir el valor de tasación del inmueble ubicado en la calle "
                + modelo1.getValueAt(0, 3) + " " + modelo1.getValueAt(0, 4) + " " + modelo1.getValueAt(0, 5)
                + " de la ciudad de " + modelo1.getValueAt(0, 6) + "."
                + "\nPor la presente, certifico, previa inspección al inmueble mencionado, que se encuentra en "
                + "buen estado de conservación  y mantenimiento, siendo el detalle el siguiente:"
                + "\n\n-  Valor del lote: $" + lote + " (Pesos " + Numeros.numeroEnLetras(lote, bLote) + ")."
                + "\n-  Valor de la construcción: $" + construccion + " (Pesos " + Numeros.numeroEnLetras(construccion, bCons)
                + ")." + "\n-  Valor de la propiedad: $"
                + total + " (Pesos " + Numeros.numeroEnLetras(total, bTotal) + ").";
        ImprimirReporteG irg = new ImprimirReporteG();
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        SimpleAttributeSet attribs1 = new SimpleAttributeSet();
        SimpleAttributeSet attribs2 = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_JUSTIFIED);
        StyleConstants.setFontFamily(attribs, "Arial");
        StyleConstants.setFontSize(attribs, 12);
        StyleConstants.setLineSpacing(attribs, 0.8f);
        irg.ir.reporte.jTextPane1.setParagraphAttributes(attribs, true);
        irg.ir.reporte.jTextPane1.setText(report);
        StyleConstants.setFontSize(attribs1, 24);
        StyleConstants.setAlignment(attribs1, StyleConstants.ALIGN_CENTER);
        try {
            irg.ir.reporte.jTextPane1.getStyledDocument().insertString(0, "Informe de Tasación\n", attribs1);
            irg.ir.reporte.jTextPane1.getStyledDocument().insertString(irg.ir.reporte.jTextPane1.getStyledDocument().getLength(), "\n\n\n\n\n\n\n\n", attribs);
            StyleConstants.setAlignment(attribs2, StyleConstants.ALIGN_RIGHT);
            irg.ir.reporte.jTextPane1.setParagraphAttributes(attribs2, true);
            ImageIcon icono = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
            irg.ir.reporte.jTextPane1.setCaretPosition(irg.ir.reporte.jTextPane1.getStyledDocument().getLength());
            irg.ir.reporte.jTextPane1.insertIcon(icono);
            irg.ir.reporte.jTextPane1.getStyledDocument().insertString(irg.ir.reporte.jTextPane1.getStyledDocument().getLength(), " \nINMOBILIARIA", attribs2);
        } catch (BadLocationException ex) {
            Logger.getLogger(TasacionG.class.getName()).log(Level.SEVERE, null, ex);
        }
        irg.abrirImprimirReporte();
    }

    public boolean validarCampos() { //Valida que los campos obligatorios no esten vacios.
        boolean validacion = true;
        Border border = formGT.tIdCategoria.getBorder();
        if (formGT.tCliente.getText().isEmpty()) {
            formGT.tCliente.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formGT.tCliente.setBorder(border);
        }
        if (formGT.fecha.getDate() == null) {
            formGT.fecha.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formGT.fecha.setBorder(border);
        }
        if (formGT.tCalle.getText().isEmpty()) {
            formGT.tCalle.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formGT.tCalle.setBorder(border);
        }
        if (formGT.tNumero.getText().isEmpty()) {
            formGT.tNumero.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formGT.tNumero.setBorder(border);
        }
        if (formGT.tVB.getText().isEmpty()) {
            formGT.tVB.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formGT.tVB.setBorder(border);
        }
        if (formGT.tVM2.getText().isEmpty()) {
            formGT.tVM2.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formGT.tVM2.setBorder(border);
        }
        if (formGT.tAños.getText().isEmpty()) {
            formGT.tAños.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formGT.tAños.setBorder(border);
        }
        if (formGT.tM2Construccion.getText().isEmpty()) {
            formGT.tM2Construccion.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formGT.tM2Construccion.setBorder(border);
        }
        if (formGT.tM2Terreno.getText().isEmpty()) {
            formGT.tM2Terreno.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formGT.tM2Terreno.setBorder(border);
        }
        if (validacion == false) {
            JOptionPane.showMessageDialog(null, "Debe ingresar los datos marcados");
        }
        return validacion;
    }

    public void limpiar() { //Vacia todos los campos y coloca los bordes preestablecidos.
        formGT.tCliente.setText(null);
        formGT.estado.setSelectedItem(null);
        formGT.fecha.setDate(null);
        formGT.tAños.setText(null);
        formGT.tIdCategoria.setText(null);
        formGT.tM2Construccion.setText(null);
        formGT.tM2Terreno.setText(null);
        formGT.tVB.setText(null);
        formGT.tVM2.setText(null);
        formGT.tipoPropiedad.setSelectedItem(null);
        formGT.valorResidual.setSelectedItem(null);
        Border border = formGT.tIdCategoria.getBorder();
        formGT.tCliente.setBorder(border);
        formGT.fecha.setBorder(border);
        formGT.tCalle.setBorder(border);
        formGT.tNumero.setBorder(border);
        formGT.tVB.setBorder(border);
        formGT.tVM2.setBorder(border);
        formGT.tAños.setBorder(border);
        formGT.tM2Construccion.setBorder(border);
        formGT.tM2Terreno.setBorder(border);
    }

    public String obtenerNumEstado() { //Obtener el número del estado de la propiedad segun su descripción.
        switch (formGT.estado.getSelectedItem().toString()) {
            case "Excelente":
                return "1";
            case "Muy Buena":
                return "1.5";
            case "Buena":
                return "2";
            case "Normal":
                return "2.5";
            case "Regular":
                return "3";
            case "Malo":
                return "3.5";
            case "Muy Malo":
                return "4";
            case "Demolición":
                return "4.5";
            case "Irrecuperable":
                return "5";
            default:
                return "";
        }
    }

    public String obtenerEstado(String n) { //Obtener la descripción del estado de la propiedad segun el número.
        switch (n) {
            case "1":
                return "Excelente";
            case "1.5":
                return "Muy Buena";
            case "2":
                return "Buena";
            case "2.5":
                return "Normal";
            case "3":
                return "Regular";
            case "3.5":
                return "Malo";
            case "4":
                return "Muy Malo";
            case "4.5":
                return "Demolición";
            case "5":
                return "Irrecuperable";
            default:
                return "";
        }
    }

    public boolean validarCategorizacion() { //Valida que se ha selecciona un tipo de unidad funcional en la Categorización de la propiedad.
        boolean validacion = false;
        int i = 0;
        if (formC.a23.getBackground() == Color.red) {
            i++;
        }
        if (formC.a24.getBackground() == Color.red) {
            i++;
        }
        if (formC.a25.getBackground() == Color.red) {
            i++;
        }
        if (formC.a26.getBackground() == Color.red) {
            i++;
        }
        if (formC.b23.getBackground() == Color.red) {
            i++;
        }
        if (formC.b24.getBackground() == Color.red) {
            i++;
        }
        if (formC.b25.getBackground() == Color.red) {
            i++;
        }
        if (formC.b26.getBackground() == Color.red) {
            i++;
        }
        if (formC.c23.getBackground() == Color.red) {
            i++;
        }
        if (formC.c24.getBackground() == Color.red) {
            i++;
        }
        if (formC.c25.getBackground() == Color.red) {
            i++;
        }
        if (formC.c26.getBackground() == Color.red) {
            i++;
        }
        if (formC.d23.getBackground() == Color.red) {
            i++;
        }
        if (formC.d24.getBackground() == Color.red) {
            i++;
        }
        if (formC.d25.getBackground() == Color.red) {
            i++;
        }
        if (formC.d26.getBackground() == Color.red) {
            i++;
        }
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de unidad funcional");
            validacion = false;
        } else {
            validacion = true;
        }
        return validacion;
    }

    public int sumaCategoriaA() { //Suma las caracteristicas de la propiedad que corresponden a la Categoria A.
        int cA = 0, cAf = 0;
        if (formC.a1.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a2.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a3.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a4.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a5.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a6.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a7.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a8.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a9.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a10.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a11.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a12.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a13.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a14.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a15.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a16.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a17.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a18.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a19.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a20.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a21.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a22.getBackground() == Color.red) {
            cA++;
        }
        if (formC.a23.getBackground() == Color.red) {
            cAf++;
        }
        if (formC.a24.getBackground() == Color.red) {
            cAf++;
        }
        if (formC.a25.getBackground() == Color.red) {
            cAf++;
        }
        if (formC.a26.getBackground() == Color.red) {
            cAf++;
        }

        cA = cA + (cAf * 5);
        return cA;
    }

    public int sumaCategoriaB() { //Suma las caracteristicas de la propiedad que corresponden a la Categoria B.
        int c = 0, cf = 0;
        if (formC.b1.getBackground() == Color.red) {
            c++;
        }
        if (formC.b2.getBackground() == Color.red) {
            c++;
        }
        if (formC.b3.getBackground() == Color.red) {
            c++;
        }
        if (formC.b4.getBackground() == Color.red) {
            c++;
        }
        if (formC.b5.getBackground() == Color.red) {
            c++;
        }
        if (formC.b6.getBackground() == Color.red) {
            c++;
        }
        if (formC.b7.getBackground() == Color.red) {
            c++;
        }
        if (formC.b8.getBackground() == Color.red) {
            c++;
        }
        if (formC.b9.getBackground() == Color.red) {
            c++;
        }
        if (formC.b10.getBackground() == Color.red) {
            c++;
        }
        if (formC.b11.getBackground() == Color.red) {
            c++;
        }
        if (formC.b12.getBackground() == Color.red) {
            c++;
        }
        if (formC.b13.getBackground() == Color.red) {
            c++;
        }
        if (formC.b14.getBackground() == Color.red) {
            c++;
        }
        if (formC.b15.getBackground() == Color.red) {
            c++;
        }
        if (formC.b16.getBackground() == Color.red) {
            c++;
        }
        if (formC.b17.getBackground() == Color.red) {
            c++;
        }
        if (formC.b18.getBackground() == Color.red) {
            c++;
        }
        if (formC.b19.getBackground() == Color.red) {
            c++;
        }
        if (formC.b20.getBackground() == Color.red) {
            c++;
        }
        if (formC.b21.getBackground() == Color.red) {
            c++;
        }
        if (formC.b22.getBackground() == Color.red) {
            c++;
        }
        if (formC.b23.getBackground() == Color.red) {
            cf++;
        }
        if (formC.b24.getBackground() == Color.red) {
            cf++;
        }
        if (formC.b25.getBackground() == Color.red) {
            cf++;
        }
        if (formC.b26.getBackground() == Color.red) {
            cf++;
        }

        c = c + (cf * 5);
        return c;
    }

    public int sumaCategoriaC() { //Suma las caracteristicas de la propiedad que corresponden a la Categoria C.
        int c = 0, cf = 0;
        if (formC.c1.getBackground() == Color.red) {
            c++;
        }
        if (formC.c2.getBackground() == Color.red) {
            c++;
        }
        if (formC.c3.getBackground() == Color.red) {
            c++;
        }
        if (formC.c4.getBackground() == Color.red) {
            c++;
        }
        if (formC.c5.getBackground() == Color.red) {
            c++;
        }
        if (formC.c6.getBackground() == Color.red) {
            c++;
        }
        if (formC.c7.getBackground() == Color.red) {
            c++;
        }
        if (formC.c8.getBackground() == Color.red) {
            c++;
        }
        if (formC.c9.getBackground() == Color.red) {
            c++;
        }
        if (formC.c10.getBackground() == Color.red) {
            c++;
        }
        if (formC.c11.getBackground() == Color.red) {
            c++;
        }
        if (formC.c12.getBackground() == Color.red) {
            c++;
        }
        if (formC.c13.getBackground() == Color.red) {
            c++;
        }
        if (formC.c14.getBackground() == Color.red) {
            c++;
        }
        if (formC.c15.getBackground() == Color.red) {
            c++;
        }
        if (formC.c16.getBackground() == Color.red) {
            c++;
        }
        if (formC.c17.getBackground() == Color.red) {
            c++;
        }
        if (formC.c18.getBackground() == Color.red) {
            c++;
        }
        if (formC.c19.getBackground() == Color.red) {
            c++;
        }
        if (formC.c20.getBackground() == Color.red) {
            c++;
        }
        if (formC.c21.getBackground() == Color.red) {
            c++;
        }
        if (formC.c22.getBackground() == Color.red) {
            c++;
        }
        if (formC.c23.getBackground() == Color.red) {
            cf++;
        }
        if (formC.c24.getBackground() == Color.red) {
            cf++;
        }
        if (formC.c25.getBackground() == Color.red) {
            cf++;
        }
        if (formC.c26.getBackground() == Color.red) {
            cf++;
        }
        c = c + (cf * 5);
        return c;
    }

    public int sumaCategoriaD() { //Suma las caracteristicas de la propiedad que corresponden a la Categoria D.
        int c = 0, cf = 0;
        if (formC.d1.getBackground() == Color.red) {
            c++;
        }
        if (formC.d2.getBackground() == Color.red) {
            c++;
        }
        if (formC.d3.getBackground() == Color.red) {
            c++;
        }
        if (formC.d4.getBackground() == Color.red) {
            c++;
        }
        if (formC.d5.getBackground() == Color.red) {
            c++;
        }
        if (formC.d6.getBackground() == Color.red) {
            c++;
        }
        if (formC.d7.getBackground() == Color.red) {
            c++;
        }
        if (formC.d8.getBackground() == Color.red) {
            c++;
        }
        if (formC.d9.getBackground() == Color.red) {
            c++;
        }
        if (formC.d10.getBackground() == Color.red) {
            c++;
        }
        if (formC.d11.getBackground() == Color.red) {
            c++;
        }
        if (formC.d12.getBackground() == Color.red) {
            c++;
        }
        if (formC.d13.getBackground() == Color.red) {
            c++;
        }
        if (formC.d14.getBackground() == Color.red) {
            c++;
        }
        if (formC.d15.getBackground() == Color.red) {
            c++;
        }
        if (formC.d16.getBackground() == Color.red) {
            c++;
        }
        if (formC.d17.getBackground() == Color.red) {
            c++;
        }
        if (formC.d18.getBackground() == Color.red) {
            c++;
        }
        if (formC.d19.getBackground() == Color.red) {
            c++;
        }
        if (formC.d20.getBackground() == Color.red) {
            c++;
        }
        if (formC.d21.getBackground() == Color.red) {
            c++;
        }
        if (formC.d22.getBackground() == Color.red) {
            c++;
        }
        if (formC.d23.getBackground() == Color.red) {
            cf++;
        }
        if (formC.d24.getBackground() == Color.red) {
            cf++;
        }
        if (formC.d25.getBackground() == Color.red) {
            cf++;
        }
        if (formC.d26.getBackground() == Color.red) {
            cf++;
        }
        c = c + (cf * 5);
        return c;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == formGT.tCalle || e.getSource() == formGT.tDepartamento) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarAlfanumerico(e);
        }

        if (e.getSource() == formGT.tAños || e.getSource() == formGT.tNumero) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarSoloNumeros(e);
        }

        if (e.getSource() == formGT.tM2Construccion || e.getSource() == formGT.tM2Terreno || e.getSource() == formGT.tVB || e.getSource() == formGT.tVM2) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarNumeroC(e);
            String caracter = ",";
            int count = 0;
            if (formGT.tM2Construccion.getText().contains(",") && e.getKeyChar() == 44) {
                for (int i = 0; i < formGT.tM2Construccion.getText().length(); i++) {
                    if (formGT.tM2Construccion.getText().charAt(i) == caracter.charAt(0)) {
                        count++;
                        if (count > 0) {
                            e.consume();
                        }
                    }
                }
            }
            if (formGT.tM2Terreno.getText().contains(",") && e.getKeyChar() == 44) {
                for (int i = 0; i < formGT.tM2Terreno.getText().length(); i++) {
                    if (formGT.tM2Terreno.getText().charAt(i) == caracter.charAt(0)) {
                        count++;
                        if (count > 0) {
                            e.consume();
                        }
                    }
                }
            }
            if (formGT.tVB.getText().contains(",") && e.getKeyChar() == 44) {
                for (int i = 0; i < formGT.tVB.getText().length(); i++) {
                    if (formGT.tVB.getText().charAt(i) == caracter.charAt(0)) {
                        count++;
                        if (count > 0) {
                            e.consume();
                        }
                    }
                }
            }
            if (formGT.tVM2.getText().contains(",") && e.getKeyChar() == 44) {
                for (int i = 0; i < formGT.tVM2.getText().length(); i++) {
                    if (formGT.tVM2.getText().charAt(i) == caracter.charAt(0)) {
                        count++;
                        if (count > 0) {
                            e.consume();
                        }
                    }
                }
            }
        }

        if (e.getSource() == formGT.tCliente) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarDni(e);
            if (formGT.tCliente.getText().length() > 10) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == pt.table) {
            anularBoton("0");
        }

        if (e.getSource().equals(formC.a1)) {
            if (formC.a1.getBackground() == Color.red) {
                formC.a1.setBackground(Color.white);
            } else {
                formC.a1.setBackground(Color.red);
                formC.b1.setBackground(Color.white);
                formC.c1.setBackground(Color.white);
                formC.d1.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b1)) {
            if (formC.b1.getBackground() == Color.red) {
                formC.b1.setBackground(Color.white);
            } else {
                formC.b1.setBackground(Color.red);
                formC.a1.setBackground(Color.white);
                formC.c1.setBackground(Color.white);
                formC.d1.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c1)) {
            if (formC.c1.getBackground() == Color.red) {
                formC.c1.setBackground(Color.white);
            } else {
                formC.c1.setBackground(Color.red);
                formC.a1.setBackground(Color.white);
                formC.b1.setBackground(Color.white);
                formC.d1.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d1)) {
            if (formC.d1.getBackground() == Color.red) {
                formC.d1.setBackground(Color.white);
            } else {
                formC.d1.setBackground(Color.red);
                formC.a1.setBackground(Color.white);
                formC.b1.setBackground(Color.white);
                formC.c1.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a2)) {
            if (formC.a2.getBackground() == Color.red) {
                formC.a2.setBackground(Color.white);
            } else {
                formC.a2.setBackground(Color.red);
                formC.b2.setBackground(Color.white);
                formC.c2.setBackground(Color.white);
                formC.d2.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b2)) {
            if (formC.b2.getBackground() == Color.red) {
                formC.b2.setBackground(Color.white);
            } else {
                formC.b2.setBackground(Color.red);
                formC.a2.setBackground(Color.white);
                formC.c2.setBackground(Color.white);
                formC.d2.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c2)) {
            if (formC.c2.getBackground() == Color.red) {
                formC.c2.setBackground(Color.white);
            } else {
                formC.c2.setBackground(Color.red);
                formC.a2.setBackground(Color.white);
                formC.b2.setBackground(Color.white);
                formC.d2.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d2)) {
            if (formC.d2.getBackground() == Color.red) {
                formC.d2.setBackground(Color.white);
            } else {
                formC.d2.setBackground(Color.red);
                formC.a2.setBackground(Color.white);
                formC.b2.setBackground(Color.white);
                formC.c2.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a3)) {
            if (formC.a3.getBackground() == Color.red) {
                formC.a3.setBackground(Color.white);
            } else {
                formC.a3.setBackground(Color.red);
                formC.b3.setBackground(Color.white);
                formC.c3.setBackground(Color.white);
                formC.d3.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b3)) {
            if (formC.b3.getBackground() == Color.red) {
                formC.b3.setBackground(Color.white);
            } else {
                formC.b3.setBackground(Color.red);
                formC.a3.setBackground(Color.white);
                formC.c3.setBackground(Color.white);
                formC.d3.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c3)) {
            if (formC.c3.getBackground() == Color.red) {
                formC.c3.setBackground(Color.white);
            } else {
                formC.c3.setBackground(Color.red);
                formC.a3.setBackground(Color.white);
                formC.b3.setBackground(Color.white);
                formC.d3.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d3)) {
            if (formC.d3.getBackground() == Color.red) {
                formC.d3.setBackground(Color.white);
            } else {
                formC.d3.setBackground(Color.red);
                formC.a3.setBackground(Color.white);
                formC.b3.setBackground(Color.white);
                formC.c3.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a4)) {
            if (formC.a4.getBackground() == Color.red) {
                formC.a4.setBackground(Color.white);
            } else {
                formC.a4.setBackground(Color.red);
                formC.b4.setBackground(Color.white);
                formC.c4.setBackground(Color.white);
                formC.d4.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b4)) {
            if (formC.b4.getBackground() == Color.red) {
                formC.b4.setBackground(Color.white);
            } else {
                formC.b4.setBackground(Color.red);
                formC.a4.setBackground(Color.white);
                formC.c4.setBackground(Color.white);
                formC.d4.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c4)) {
            if (formC.c4.getBackground() == Color.red) {
                formC.c4.setBackground(Color.white);
            } else {
                formC.c4.setBackground(Color.red);
                formC.a4.setBackground(Color.white);
                formC.b4.setBackground(Color.white);
                formC.d4.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d4)) {
            if (formC.d4.getBackground() == Color.red) {
                formC.d4.setBackground(Color.white);
            } else {
                formC.d4.setBackground(Color.red);
                formC.a4.setBackground(Color.white);
                formC.b4.setBackground(Color.white);
                formC.c4.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a5)) {
            if (formC.a5.getBackground() == Color.red) {
                formC.a5.setBackground(Color.white);
            } else {
                formC.a5.setBackground(Color.red);
                formC.b5.setBackground(Color.white);
                formC.c5.setBackground(Color.white);
                formC.d5.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b5)) {
            if (formC.b5.getBackground() == Color.red) {
                formC.b5.setBackground(Color.white);
            } else {
                formC.b5.setBackground(Color.red);
                formC.a5.setBackground(Color.white);
                formC.c5.setBackground(Color.white);
                formC.d5.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c5)) {
            if (formC.c5.getBackground() == Color.red) {
                formC.c5.setBackground(Color.white);
            } else {
                formC.c5.setBackground(Color.red);
                formC.a5.setBackground(Color.white);
                formC.b5.setBackground(Color.white);
                formC.d5.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d5)) {
            if (formC.d5.getBackground() == Color.red) {
                formC.d5.setBackground(Color.white);
            } else {
                formC.d5.setBackground(Color.red);
                formC.a5.setBackground(Color.white);
                formC.b5.setBackground(Color.white);
                formC.c5.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a6)) {
            if (formC.a6.getBackground() == Color.red) {
                formC.a6.setBackground(Color.white);
            } else {
                formC.a6.setBackground(Color.red);
                formC.b6.setBackground(Color.white);
                formC.c6.setBackground(Color.white);
                formC.d6.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b6)) {
            if (formC.b6.getBackground() == Color.red) {
                formC.b6.setBackground(Color.white);
            } else {
                formC.b6.setBackground(Color.red);
                formC.a6.setBackground(Color.white);
                formC.c6.setBackground(Color.white);
                formC.d6.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c6)) {
            if (formC.c6.getBackground() == Color.red) {
                formC.c6.setBackground(Color.white);
            } else {
                formC.c6.setBackground(Color.red);
                formC.a6.setBackground(Color.white);
                formC.b6.setBackground(Color.white);
                formC.d6.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d6)) {
            if (formC.d6.getBackground() == Color.red) {
                formC.d6.setBackground(Color.white);
            } else {
                formC.d6.setBackground(Color.red);
                formC.a6.setBackground(Color.white);
                formC.b6.setBackground(Color.white);
                formC.c6.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a7)) {
            if (formC.a7.getBackground() == Color.red) {
                formC.a7.setBackground(Color.white);
            } else {
                formC.a7.setBackground(Color.red);
                formC.b7.setBackground(Color.white);
                formC.c7.setBackground(Color.white);
                formC.d7.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b7)) {
            if (formC.b7.getBackground() == Color.red) {
                formC.b7.setBackground(Color.white);
            } else {
                formC.b7.setBackground(Color.red);
                formC.a7.setBackground(Color.white);
                formC.c7.setBackground(Color.white);
                formC.d7.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c7)) {
            if (formC.c7.getBackground() == Color.red) {
                formC.c7.setBackground(Color.white);
            } else {
                formC.c7.setBackground(Color.red);
                formC.a7.setBackground(Color.white);
                formC.b7.setBackground(Color.white);
                formC.d7.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d7)) {
            if (formC.d7.getBackground() == Color.red) {
                formC.d7.setBackground(Color.white);
            } else {
                formC.d7.setBackground(Color.red);
                formC.a7.setBackground(Color.white);
                formC.b7.setBackground(Color.white);
                formC.c7.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a8)) {
            if (formC.a8.getBackground() == Color.red) {
                formC.a8.setBackground(Color.white);
            } else {
                formC.a8.setBackground(Color.red);
                formC.b8.setBackground(Color.white);
                formC.c8.setBackground(Color.white);
                formC.d8.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b8)) {
            if (formC.b8.getBackground() == Color.red) {
                formC.b8.setBackground(Color.white);
            } else {
                formC.b8.setBackground(Color.red);
                formC.a8.setBackground(Color.white);
                formC.c8.setBackground(Color.white);
                formC.d8.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c8)) {
            if (formC.c8.getBackground() == Color.red) {
                formC.c8.setBackground(Color.white);
            } else {
                formC.c8.setBackground(Color.red);
                formC.a8.setBackground(Color.white);
                formC.b8.setBackground(Color.white);
                formC.d8.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d8)) {
            if (formC.d8.getBackground() == Color.red) {
                formC.d8.setBackground(Color.white);
            } else {
                formC.d8.setBackground(Color.red);
                formC.a8.setBackground(Color.white);
                formC.b8.setBackground(Color.white);
                formC.c8.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a9)) {
            if (formC.a9.getBackground() == Color.red) {
                formC.a9.setBackground(Color.white);
            } else {
                formC.a9.setBackground(Color.red);
                formC.b9.setBackground(Color.white);
                formC.c9.setBackground(Color.white);
                formC.d9.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b9)) {
            if (formC.b9.getBackground() == Color.red) {
                formC.b9.setBackground(Color.white);
            } else {
                formC.b9.setBackground(Color.red);
                formC.a9.setBackground(Color.white);
                formC.c9.setBackground(Color.white);
                formC.d9.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c9)) {
            /* if (formC.c9.getBackground() == Color.red) {
                formC.c9.setBackground(Color.white);
            } else {
                formC.c9.setBackground(Color.red);
                formC.a9.setBackground(Color.white);
                formC.b9.setBackground(Color.white);
                formC.d9.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d9)) {
            if (formC.d9.getBackground() == Color.red) {
                formC.d9.setBackground(Color.white);
            } else {
                formC.d9.setBackground(Color.red);
                formC.a9.setBackground(Color.white);
                formC.b9.setBackground(Color.white);
                formC.c9.setBackground(Color.white);
            }*/
        }

        if (e.getSource().equals(formC.a10)) {
            if (formC.a10.getBackground() == Color.red) {
                formC.a10.setBackground(Color.white);
            } else {
                formC.a10.setBackground(Color.red);
                formC.b10.setBackground(Color.white);
                formC.c10.setBackground(Color.white);
                formC.d10.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b10)) {
            if (formC.b10.getBackground() == Color.red) {
                formC.b10.setBackground(Color.white);
            } else {
                formC.b10.setBackground(Color.red);
                formC.a10.setBackground(Color.white);
                formC.c10.setBackground(Color.white);
                formC.d10.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c10)) {
            if (formC.c10.getBackground() == Color.red) {
                formC.c10.setBackground(Color.white);
            } else {
                formC.c10.setBackground(Color.red);
                formC.a10.setBackground(Color.white);
                formC.b10.setBackground(Color.white);
                formC.d10.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d10)) {
            /* if (formC.d10.getBackground() == Color.red) {
                formC.d10.setBackground(Color.white);
            } else {
                formC.d10.setBackground(Color.red);
                formC.a10.setBackground(Color.white);
                formC.b10.setBackground(Color.white);
                formC.c10.setBackground(Color.white);
            }*/
        }

        if (e.getSource().equals(formC.a11)) {
            if (formC.a11.getBackground() == Color.red) {
                formC.a11.setBackground(Color.white);
            } else {
                formC.a11.setBackground(Color.red);
                formC.b11.setBackground(Color.white);
                formC.c11.setBackground(Color.white);
                formC.d11.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b11)) {
            if (formC.b11.getBackground() == Color.red) {
                formC.b11.setBackground(Color.white);
            } else {
                formC.b11.setBackground(Color.red);
                formC.a11.setBackground(Color.white);
                formC.c11.setBackground(Color.white);
                formC.d11.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c11)) {
            if (formC.c11.getBackground() == Color.red) {
                formC.c11.setBackground(Color.white);
            } else {
                formC.c11.setBackground(Color.red);
                formC.a11.setBackground(Color.white);
                formC.b11.setBackground(Color.white);
                formC.d11.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d11)) {
            if (formC.d11.getBackground() == Color.red) {
                formC.d11.setBackground(Color.white);
            } else {
                formC.d11.setBackground(Color.red);
                formC.a11.setBackground(Color.white);
                formC.b11.setBackground(Color.white);
                formC.c11.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a12)) {
            if (formC.a12.getBackground() == Color.red) {
                formC.a12.setBackground(Color.white);
            } else {
                formC.a12.setBackground(Color.red);
                formC.b12.setBackground(Color.white);
                formC.c12.setBackground(Color.white);
                formC.d12.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b12)) {
            if (formC.b12.getBackground() == Color.red) {
                formC.b12.setBackground(Color.white);
            } else {
                formC.b12.setBackground(Color.red);
                formC.a12.setBackground(Color.white);
                formC.c12.setBackground(Color.white);
                formC.d12.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c12)) {
            if (formC.c12.getBackground() == Color.red) {
                formC.c12.setBackground(Color.white);
            } else {
                formC.c12.setBackground(Color.red);
                formC.a12.setBackground(Color.white);
                formC.b12.setBackground(Color.white);
                formC.d12.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d12)) {
            if (formC.d12.getBackground() == Color.red) {
                formC.d12.setBackground(Color.white);
            } else {
                formC.d12.setBackground(Color.red);
                formC.a12.setBackground(Color.white);
                formC.b12.setBackground(Color.white);
                formC.c12.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a13)) {
            if (formC.a13.getBackground() == Color.red) {
                formC.a13.setBackground(Color.white);
            } else {
                formC.a13.setBackground(Color.red);
                formC.b13.setBackground(Color.white);
                formC.c13.setBackground(Color.white);
                formC.d13.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b13)) {
            if (formC.b13.getBackground() == Color.red) {
                formC.b13.setBackground(Color.white);
            } else {
                formC.b13.setBackground(Color.red);
                formC.a13.setBackground(Color.white);
                formC.c13.setBackground(Color.white);
                formC.d13.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c13)) {
            if (formC.c13.getBackground() == Color.red) {
                formC.c13.setBackground(Color.white);
            } else {
                formC.c13.setBackground(Color.red);
                formC.a13.setBackground(Color.white);
                formC.b13.setBackground(Color.white);
                formC.d13.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d13)) {
            if (formC.d13.getBackground() == Color.red) {
                formC.d13.setBackground(Color.white);
            } else {
                formC.d13.setBackground(Color.red);
                formC.a13.setBackground(Color.white);
                formC.b13.setBackground(Color.white);
                formC.c13.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a14)) {
            if (formC.a14.getBackground() == Color.red) {
                formC.a14.setBackground(Color.white);
            } else {
                formC.a14.setBackground(Color.red);
                formC.b14.setBackground(Color.white);
                formC.c14.setBackground(Color.white);
                formC.d14.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b14)) {
            if (formC.b14.getBackground() == Color.red) {
                formC.b14.setBackground(Color.white);
            } else {
                formC.b14.setBackground(Color.red);
                formC.a14.setBackground(Color.white);
                formC.c14.setBackground(Color.white);
                formC.d14.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c14)) {
            /* if (formC.c14.getBackground() == Color.red) {
                formC.c14.setBackground(Color.white);
            } else {
                formC.c14.setBackground(Color.red);
                formC.a14.setBackground(Color.white);
                formC.b14.setBackground(Color.white);
                formC.d14.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d14)) {
            if (formC.d14.getBackground() == Color.red) {
                formC.d14.setBackground(Color.white);
            } else {
                formC.d14.setBackground(Color.red);
                formC.a14.setBackground(Color.white);
                formC.b14.setBackground(Color.white);
                formC.c14.setBackground(Color.white);
            }*/
        }

        if (e.getSource().equals(formC.a15)) {
            if (formC.a15.getBackground() == Color.red) {
                formC.a15.setBackground(Color.white);
            } else {
                formC.a15.setBackground(Color.red);
                formC.b15.setBackground(Color.white);
                formC.c15.setBackground(Color.white);
                formC.d15.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b15)) {
            if (formC.b15.getBackground() == Color.red) {
                formC.b15.setBackground(Color.white);
            } else {
                formC.b15.setBackground(Color.red);
                formC.a15.setBackground(Color.white);
                formC.c15.setBackground(Color.white);
                formC.d15.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c15)) {
            if (formC.c15.getBackground() == Color.red) {
                formC.c15.setBackground(Color.white);
            } else {
                formC.c15.setBackground(Color.red);
                formC.a15.setBackground(Color.white);
                formC.b15.setBackground(Color.white);
                formC.d15.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d15)) {
            if (formC.d15.getBackground() == Color.red) {
                formC.d15.setBackground(Color.white);
            } else {
                formC.d15.setBackground(Color.red);
                formC.a15.setBackground(Color.white);
                formC.b15.setBackground(Color.white);
                formC.c15.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a16)) {
            if (formC.a16.getBackground() == Color.red) {
                formC.a16.setBackground(Color.white);
            } else {
                formC.a16.setBackground(Color.red);
                formC.b16.setBackground(Color.white);
                formC.c16.setBackground(Color.white);
                formC.d16.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b16)) {
            if (formC.b16.getBackground() == Color.red) {
                formC.b16.setBackground(Color.white);
            } else {
                formC.b16.setBackground(Color.red);
                formC.a16.setBackground(Color.white);
                formC.c16.setBackground(Color.white);
                formC.d16.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c16)) {
            if (formC.c16.getBackground() == Color.red) {
                formC.c16.setBackground(Color.white);
            } else {
                formC.c16.setBackground(Color.red);
                formC.a16.setBackground(Color.white);
                formC.b16.setBackground(Color.white);
                formC.d16.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d16)) {
            if (formC.d16.getBackground() == Color.red) {
                formC.d16.setBackground(Color.white);
            } else {
                formC.d16.setBackground(Color.red);
                formC.a16.setBackground(Color.white);
                formC.b16.setBackground(Color.white);
                formC.c16.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a17)) {
            if (formC.a17.getBackground() == Color.red) {
                formC.a17.setBackground(Color.white);
            } else {
                formC.a17.setBackground(Color.red);
                formC.b17.setBackground(Color.white);
                formC.c17.setBackground(Color.white);
                formC.d17.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b17)) {
            if (formC.b17.getBackground() == Color.red) {
                formC.b17.setBackground(Color.white);
            } else {
                formC.b17.setBackground(Color.red);
                formC.a17.setBackground(Color.white);
                formC.c17.setBackground(Color.white);
                formC.d17.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c17)) {
            if (formC.c17.getBackground() == Color.red) {
                formC.c17.setBackground(Color.white);
            } else {
                formC.c17.setBackground(Color.red);
                formC.a17.setBackground(Color.white);
                formC.b17.setBackground(Color.white);
                formC.d17.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d17)) {
            if (formC.d17.getBackground() == Color.red) {
                formC.d17.setBackground(Color.white);
            } else {
                formC.d17.setBackground(Color.red);
                formC.a17.setBackground(Color.white);
                formC.b17.setBackground(Color.white);
                formC.c17.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a18)) {
            if (formC.a18.getBackground() == Color.red) {
                formC.a18.setBackground(Color.white);
            } else {
                formC.a18.setBackground(Color.red);
                formC.b18.setBackground(Color.white);
                formC.c18.setBackground(Color.white);
                formC.d18.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b18)) {
            if (formC.b18.getBackground() == Color.red) {
                formC.b18.setBackground(Color.white);
            } else {
                formC.b18.setBackground(Color.red);
                formC.a18.setBackground(Color.white);
                formC.c18.setBackground(Color.white);
                formC.d18.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c18)) {
            if (formC.c18.getBackground() == Color.red) {
                formC.c18.setBackground(Color.white);
            } else {
                formC.c18.setBackground(Color.red);
                formC.a18.setBackground(Color.white);
                formC.b18.setBackground(Color.white);
                formC.d18.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d18)) {
            if (formC.d18.getBackground() == Color.red) {
                formC.d18.setBackground(Color.white);
            } else {
                formC.d18.setBackground(Color.red);
                formC.a18.setBackground(Color.white);
                formC.b18.setBackground(Color.white);
                formC.c18.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a19)) {
            if (formC.a19.getBackground() == Color.red) {
                formC.a19.setBackground(Color.white);
            } else {
                formC.a19.setBackground(Color.red);
                formC.b19.setBackground(Color.white);
                formC.c19.setBackground(Color.white);
                formC.d19.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b19)) {
            if (formC.b19.getBackground() == Color.red) {
                formC.b19.setBackground(Color.white);
            } else {
                formC.b19.setBackground(Color.red);
                formC.a19.setBackground(Color.white);
                formC.c19.setBackground(Color.white);
                formC.d19.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c19)) {
            if (formC.c19.getBackground() == Color.red) {
                formC.c19.setBackground(Color.white);
            } else {
                formC.c19.setBackground(Color.red);
                formC.a19.setBackground(Color.white);
                formC.b19.setBackground(Color.white);
                formC.d19.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d19)) {
            if (formC.d19.getBackground() == Color.red) {
                formC.d19.setBackground(Color.white);
            } else {
                formC.d19.setBackground(Color.red);
                formC.a19.setBackground(Color.white);
                formC.b19.setBackground(Color.white);
                formC.c19.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a20)) {
            if (formC.a20.getBackground() == Color.red) {
                formC.a20.setBackground(Color.white);
            } else {
                formC.a20.setBackground(Color.red);
                formC.b20.setBackground(Color.white);
                formC.c20.setBackground(Color.white);
                formC.d20.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b20)) {
            if (formC.b20.getBackground() == Color.red) {
                formC.b20.setBackground(Color.white);
            } else {
                formC.b20.setBackground(Color.red);
                formC.a20.setBackground(Color.white);
                formC.c20.setBackground(Color.white);
                formC.d20.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c20)) {
            if (formC.c20.getBackground() == Color.red) {
                formC.c20.setBackground(Color.white);
            } else {
                formC.c20.setBackground(Color.red);
                formC.a20.setBackground(Color.white);
                formC.b20.setBackground(Color.white);
                formC.d20.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d20)) {
            if (formC.d20.getBackground() == Color.red) {
                formC.d20.setBackground(Color.white);
            } else {
                formC.d20.setBackground(Color.red);
                formC.a20.setBackground(Color.white);
                formC.b20.setBackground(Color.white);
                formC.c20.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a21)) {
            if (formC.a21.getBackground() == Color.red) {
                formC.a21.setBackground(Color.white);
            } else {
                formC.a21.setBackground(Color.red);
                formC.b21.setBackground(Color.white);
                formC.c21.setBackground(Color.white);
                formC.d21.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b21)) {
            if (formC.b21.getBackground() == Color.red) {
                formC.b21.setBackground(Color.white);
            } else {
                formC.b21.setBackground(Color.red);
                formC.a21.setBackground(Color.white);
                formC.c21.setBackground(Color.white);
                formC.d21.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c21)) {
            if (formC.c21.getBackground() == Color.red) {
                formC.c21.setBackground(Color.white);
            } else {
                formC.c21.setBackground(Color.red);
                formC.a21.setBackground(Color.white);
                formC.b21.setBackground(Color.white);
                formC.d21.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d21)) {
            if (formC.d21.getBackground() == Color.red) {
                formC.d21.setBackground(Color.white);
            } else {
                formC.d21.setBackground(Color.red);
                formC.a21.setBackground(Color.white);
                formC.b21.setBackground(Color.white);
                formC.c21.setBackground(Color.white);
            }
        }

        if (e.getSource().equals(formC.a22)) {
            if (formC.a22.getBackground() == Color.red) {
                formC.a22.setBackground(Color.white);
            } else {
                formC.a22.setBackground(Color.red);
                formC.b22.setBackground(Color.white);
                formC.c22.setBackground(Color.white);
                formC.d22.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b22)) {
            if (formC.b22.getBackground() == Color.red) {
                formC.b22.setBackground(Color.white);
            } else {
                formC.b22.setBackground(Color.red);
                formC.a22.setBackground(Color.white);
                formC.c22.setBackground(Color.white);
                formC.d22.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c22)) {
            if (formC.c22.getBackground() == Color.red) {
                formC.c22.setBackground(Color.white);
            } else {
                formC.c22.setBackground(Color.red);
                formC.a22.setBackground(Color.white);
                formC.b22.setBackground(Color.white);
                formC.d22.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d22)) {
            /*if (formC.d22.getBackground() == Color.red) {
                formC.d22.setBackground(Color.white);
            } else {
                formC.d22.setBackground(Color.red);
                formC.a22.setBackground(Color.white);
                formC.b22.setBackground(Color.white);
                formC.c22.setBackground(Color.white);
            }*/
        }

        if (e.getSource().equals(formC.a23)) {
            if (formC.a23.getBackground() == Color.red) {
                formC.a23.setBackground(Color.white);
            } else {
                formC.a23.setBackground(Color.red);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b23)) {
            if (formC.b23.getBackground() == Color.red) {
                formC.b23.setBackground(Color.white);
            } else {
                formC.b23.setBackground(Color.red);
                formC.a23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c23)) {
            if (formC.c23.getBackground() == Color.red) {
                formC.c23.setBackground(Color.white);
            } else {
                formC.c23.setBackground(Color.red);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d23)) {
            if (formC.d23.getBackground() == Color.red) {
                formC.d23.setBackground(Color.white);
            } else {
                formC.d23.setBackground(Color.red);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.a24)) {
            if (formC.a24.getBackground() == Color.red) {
                formC.a24.setBackground(Color.white);
            } else {
                formC.a24.setBackground(Color.red);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b24)) {
            if (formC.b24.getBackground() == Color.red) {
                formC.b24.setBackground(Color.white);
            } else {
                formC.b24.setBackground(Color.red);
                formC.a24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c24)) {
            if (formC.c24.getBackground() == Color.red) {
                formC.c24.setBackground(Color.white);
            } else {
                formC.c24.setBackground(Color.red);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d24)) {
            if (formC.d24.getBackground() == Color.red) {
                formC.d24.setBackground(Color.white);
            } else {
                formC.d24.setBackground(Color.red);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.a25)) {
            if (formC.a25.getBackground() == Color.red) {
                formC.a25.setBackground(Color.white);
            } else {
                formC.a25.setBackground(Color.red);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b25)) {
            if (formC.b25.getBackground() == Color.red) {
                formC.b25.setBackground(Color.white);
            } else {
                formC.b25.setBackground(Color.red);
                formC.a25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c25)) {
            if (formC.c25.getBackground() == Color.red) {
                formC.c25.setBackground(Color.white);
            } else {
                formC.c25.setBackground(Color.red);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.d25)) {
            if (formC.d25.getBackground() == Color.red) {
                formC.d25.setBackground(Color.white);
            } else {
                formC.d25.setBackground(Color.red);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.a26)) {
            if (formC.a26.getBackground() == Color.red) {
                formC.a26.setBackground(Color.white);
            } else {
                formC.a26.setBackground(Color.red);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.b26)) {
            if (formC.b26.getBackground() == Color.red) {
                formC.b26.setBackground(Color.white);
            } else {
                formC.b26.setBackground(Color.red);
                formC.a26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
            }
        } else if (e.getSource().equals(formC.c26)) {
            /* if (formC.c26.getBackground() == Color.red) {
                formC.c26.setBackground(Color.white);
            } else {
                formC.c26.setBackground(Color.red);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.d26.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
            }*/
        } else if (e.getSource().equals(formC.d26)) {
            /*if (formC.d26.getBackground() == Color.red) {
                formC.d26.setBackground(Color.white);
            } else {
                formC.d26.setBackground(Color.red);
                formC.a26.setBackground(Color.white);
                formC.b26.setBackground(Color.white);
                formC.c26.setBackground(Color.white);
                formC.a23.setBackground(Color.white);
                formC.b23.setBackground(Color.white);
                formC.c23.setBackground(Color.white);
                formC.d23.setBackground(Color.white);
                formC.a24.setBackground(Color.white);
                formC.b24.setBackground(Color.white);
                formC.c24.setBackground(Color.white);
                formC.d24.setBackground(Color.white);
                formC.a25.setBackground(Color.white);
                formC.b25.setBackground(Color.white);
                formC.c25.setBackground(Color.white);
                formC.d25.setBackground(Color.white);
            }*/
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getSource() == formGT) {
            limpiar();
        }

        if (e.getSource() == tpre) {
            formGT.dispose();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
