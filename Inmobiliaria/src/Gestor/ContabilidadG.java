package Gestor;

import Librerias.PintarFilasContabilidad;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.Cliente;
import Modelo.ClienteConsulta;
import Modelo.ContabilidadConsulta;
import Modelo.Contabilidad;
import Modelo.TipoContabilidadConsulta;
import Vista.BuscarContabilidad;
import Vista.FormContabilidad;
import Vista.PanelContabilidad;
import static Vista.PantallaPrincipal.escritorio;
import com.toedter.calendar.JTextFieldDateEditor;
import java.text.DecimalFormat;

/**
 *
 * @author Camila Carrero
 */
public class ContabilidadG implements ActionListener, KeyListener, MouseListener, WindowListener {

    Contabilidad c = new Contabilidad();
    ContabilidadConsulta cc = new ContabilidadConsulta();
    PanelContabilidad pc = new PanelContabilidad();
    FormContabilidad formC = new FormContabilidad(null, true);
    BuscarContabilidad formBC = new BuscarContabilidad(null, true);

    public ContabilidadG() {
        iniciar(c, cc, pc, formC, formBC);
    }

    public void iniciar(Contabilidad c, ContabilidadConsulta cc, PanelContabilidad pc, FormContabilidad formC, BuscarContabilidad formBC) { //Inicia las variables y agrega los listener.
        this.c = c;
        this.cc = cc;
        this.pc = pc;
        this.formC = formC;
        this.formBC = formBC;
        this.pc.bBuscar.addActionListener(this);
        this.pc.bAgregar.addActionListener(this);
        this.pc.bModificar.addActionListener(this);
        this.pc.bEliminar.addActionListener(this);
        this.pc.bGenerarComprobante.addActionListener(this);
        this.pc.table.addMouseListener(this);
        this.formC.addWindowListener(this);
        this.formC.bAgregar.addActionListener(this);
        this.formC.bModificar.addActionListener(this);
        this.formC.bAgregarCliente.addActionListener(this);
        this.formC.tMonto.addKeyListener(this);
        this.formC.tCliente.addKeyListener(this);
        this.formBC.bBuscar.addActionListener(this);
        this.formBC.table.addMouseListener(this);
    }

    public void abrirPanel() { //Abre el PanelContabilidad.
        anularBoton("panel");
        pc.setVisible(true);
        pc.setSize(500, 500);
        pc.setLocation(0, 0);
        escritorio.removeAll();
        escritorio.add(pc);
        escritorio.revalidate();
        escritorio.repaint();
    }

    public void abrirFormContabilidad() { //Abre el formulario FormContabilidad.
        formC.tipoContabilidad.removeAllItems();
        ArrayList tc = TipoContabilidadConsulta.listaTipoContabilidad();
        for (int i = 0; i < tc.size(); i++) {
            formC.tipoContabilidad.addItem(tc.get(i).toString());
        }
        JTextFieldDateEditor editor = (JTextFieldDateEditor) formC.fecha.getDateEditor();
        editor.setEditable(false);
        formC.setVisible(true);
    }

    public void anularBoton(String nom) { //Edita los botones para estar o no disponibles.
        if (nom == "modificar") {
            formC.bModificar.setEnabled(false);
            formC.bAgregar.setEnabled(true);
        } else if (nom == "agregar") {
            formC.bAgregar.setEnabled(false);
            formC.bModificar.setEnabled(true);
        } else if (nom == "0") {
            formC.bModificar.setEnabled(true);
            formC.bAgregar.setEnabled(true);
            pc.bModificar.setEnabled(true);
            pc.bEliminar.setEnabled(true);
            pc.bGenerarComprobante.setEnabled(true);
        } else if (nom == "panel") {
            pc.bModificar.setEnabled(false);
            pc.bEliminar.setEnabled(false);
            pc.bGenerarComprobante.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pc.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = cc.buscarContabilidad();
            pc.table.setModel(modelo);
            pc.table.getColumn("Id").setPreferredWidth(3);
            pc.table.setDefaultRenderer(Object.class, new PintarFilasContabilidad());
        }

        if (e.getSource() == pc.bAgregar) {
            anularBoton("modificar");
            abrirFormContabilidad();
        }

        if (e.getSource() == pc.bModificar) {
            cargaDatosModificar();
        }

        if (e.getSource() == pc.bEliminar) {
            cargarDatos();
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la contabilidad seleccionada?", "Seleccione una opción", 0, 0);
            if (opcion == JOptionPane.YES_OPTION) {
                if (cc.eliminar(c)) {
                    JOptionPane.showMessageDialog(null, "Eliminación exitosa");
                    pc.bBuscar.doClick();
                }
            }
        }

        if (e.getSource() == pc.bGenerarComprobante) {
            ComprobanteG comg = new ComprobanteG();
            DecimalFormat df = new DecimalFormat("###,###.##");
            String id = pc.table.getValueAt(pc.table.getSelectedRow(), 0).toString();
            comg.formC.tContabilidad.setText(id);
            comg.formC.tConcepto.setText(pc.table.getValueAt(pc.table.getSelectedRow(), 4).toString());
            Double mc = Double.parseDouble(pc.table.getValueAt(pc.table.getSelectedRow(), 3).toString().replace(".", "").replace(",", "."));
            comg.formC.tMonto.setText(df.format(mc));
            comg.formC.tSaldo.setText(df.format(obtenerMonto(id, mc)));
            if(pc.table.getValueAt(pc.table.getSelectedRow(), 5).toString().equals("Ingreso")){
                comg.formC.tipoComprobante.setSelectedItem("Recibo");
            } else if(pc.table.getValueAt(pc.table.getSelectedRow(), 5).toString().equals("Egreso")){
                comg.formC.tipoComprobante.setSelectedItem("Liquidación");
            }             
            comg.abrirFormComprobante();
        }

        if (e.getSource() == formC.bAgregar) {
            ClienteConsulta clic = new ClienteConsulta();
            Cliente cli = new Cliente();
            Date fecha = formC.fecha.getDate();
            if (validarCampos()) {
                if (validarFecha(fecha)) {
                    TipoContabilidadConsulta tcc = new TipoContabilidadConsulta();
                    SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
                    c.setIdCliente(clic.obtenerId(formC.tCliente.getText()));
                    c.setFecha(forma.format(fecha));
                    c.setMonto(Double.parseDouble(formC.tMonto.getText().replace(",", ".")));
                    c.setConcepto(formC.tConcepto.getText());
                    c.setIdTipoContabilidad(tcc.obtenerId(formC.tipoContabilidad.getSelectedItem().toString()));
                    cli.setDni(Integer.parseInt(formC.tCliente.getText()));
                    if (clic.clienteExiste(cli)) {
                        if (cc.registrar(c)) {
                            JOptionPane.showMessageDialog(null, "Registro exitoso");
                            limpiar();
                            formC.dispose();
                            pc.bBuscar.doClick();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente ingresado no existe");
                    }
                }
            }
        }

        if (e.getSource() == formC.bModificar) {
            ClienteConsulta clic = new ClienteConsulta();
            Cliente cli = new Cliente();
            Date fecha = formC.fecha.getDate();
            if (validarCampos()) {
                if (validarFecha(fecha)) {
                    TipoContabilidadConsulta tcc = new TipoContabilidadConsulta();
                    SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
                    c.setIdContabilidad(Integer.parseInt(formC.tId.getText()));
                    c.setIdCliente(clic.obtenerId(formC.tCliente.getText()));
                    c.setFecha(forma.format(fecha));
                    String monto = formC.tMonto.getText();
                    if (monto.contains(".") && monto.contains(",")){
                        c.setMonto(Double.parseDouble(monto.replace(".", "").replace(",", ".")));
                    } else if (monto.contains(".")){
                        c.setMonto(Double.parseDouble(monto.replace(".", "")));
                    } else if(monto.contains(",")){
                        c.setMonto(Double.parseDouble(monto.replace(",", ".")));
                    } else{
                        c.setMonto(Double.parseDouble(monto));
                    }
                    c.setConcepto(formC.tConcepto.getText());
                    c.setIdTipoContabilidad(tcc.obtenerId(formC.tipoContabilidad.getSelectedItem().toString()));
                    cli.setDni(Integer.parseInt(formC.tCliente.getText()));
                    if (clic.clienteExiste(cli)) {
                        if (cc.modificar(c)) {
                            JOptionPane.showMessageDialog(null, "Modificación exitosa");
                            limpiar();
                            formC.dispose();
                            pc.bBuscar.doClick();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente ingresado no existe");
                    }
                }
            }
        }

        if (e.getSource() == formC.bAgregarCliente) {
            ClienteG cg = new ClienteG();
            Vista.BuscarCliente.tAbierto.setText("Contabilidad");
            cg.buscarCliente();
        }

        if (e.getSource() == formBC.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = cc.buscarContabilidad();
            formBC.table.setModel(modelo);
            formBC.table.getColumn("Id").setPreferredWidth(3);
        }
    }

    public TableModel cargaDatosModificar() { //Carga los datos de la Contabilidad en FormContabilidad para modificarlo.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) pc.table.getModel());
        ClienteConsulta clic = new ClienteConsulta();
        try {
            int id = Integer.parseInt(modelo.getValueAt(pc.table.getSelectedRow(), 0).toString());
            formC.tId.setText(Integer.toString(id));
            String nombre = pc.table.getValueAt(pc.table.getSelectedRow(), 1).toString();
            formC.tCliente.setText(clic.obtenerDni(nombre, cc.obtenerIdCliente(id), "Contabilidad"));
            try {
                Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(pc.table.getValueAt(pc.table.getSelectedRow(), 2).toString());
                formC.fecha.setDate(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(AgendaG.class.getName()).log(Level.SEVERE, null, ex);
            }
            formC.tMonto.setText(modelo.getValueAt(pc.table.getSelectedRow(), 3).toString());
            formC.tConcepto.setText(modelo.getValueAt(pc.table.getSelectedRow(), 4).toString());
            formC.tipoContabilidad.setSelectedItem(modelo.getValueAt(pc.table.getSelectedRow(), 5).toString());
            anularBoton("agregar");
            abrirFormContabilidad();
            return modelo;
        } catch (Exception e) {
            System.out.println("error al cargar datos modificar \n" + e);
        }
        return modelo;
    }

    public void cargarDatos() { //Carga datos en una instancia del objeto Contabilidad obtenidos de la tabla de PanelContabilidad.
        String id = pc.table.getValueAt(pc.table.getSelectedRow(), 0).toString();
        c.setIdContabilidad(Integer.parseInt(id));
    }

    public boolean validarCampos() { //Valida que los campos obligatorios no esten vacios.
        boolean validacion = true;
        Border border = formC.tId.getBorder();
        if (formC.tCliente.getText().isEmpty()) {
            formC.tCliente.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tCliente.setBorder(border);
        }
        if (formC.fecha.getDate() == null) {
            formC.fecha.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.fecha.setBorder(border);
        }
        if (formC.tMonto.getText().isEmpty()) {
            formC.tMonto.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tMonto.setBorder(border);
        }
        if (formC.tConcepto.getText().isEmpty()) {
            formC.tConcepto.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tConcepto.setBorder(border);
        }
        if (validacion == false) {
            JOptionPane.showMessageDialog(null, "Debe ingresar los datos marcados");
        }
        return validacion;
    }

    public void limpiar() { //Vacia todos los campos y coloca los bordes preestablecidos.
        formC.tId.setText(null);
        formC.tCliente.setText(null);
        formC.fecha.setDate(null);
        formC.tMonto.setText(null);
        formC.tConcepto.setText(null);
        formC.tipoContabilidad.setSelectedItem(null);
        Border border = formC.tId.getBorder();
        formC.tCliente.setBorder(border);
        formC.fecha.setBorder(border);
        formC.tMonto.setBorder(border);
        formC.tConcepto.setBorder(border);
    }

    public boolean validarFecha(Date fecha) { //Valida que la fecha igual o menor que la actual.
        boolean validacion = false;
        Date fechaActual = new Date();
        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        if (fecha.compareTo(fechaActual) < 0 || forma.format(fecha).equals(forma.format(fechaActual))) {
            validacion = true;
        } else {
            JOptionPane.showMessageDialog(null, "La fecha ingresada es incorrecta");
        }
        return validacion;
    }

    public Double obtenerMonto(String id, Double mc) { //Calcula el saldo disponible para emitir comprobante.
        ComprobanteG comg = new ComprobanteG();
        Double monto = 0.0;
        Double montoUsado = comg.cc.montoUsado(Integer.parseInt(id));
        monto = mc - montoUsado;
        return monto;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == formC.tMonto) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarNumeroC(e);
        }

        if (e.getSource() == formC.tCliente) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarDni(e);
            if (formC.tCliente.getText().length() > 11) {
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
        if (e.getSource() == pc.table) {
            anularBoton("0");
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
        if (e.getSource() == formC) {
            limpiar();
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
