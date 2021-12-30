package Gestor;

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
import Modelo.Comunicacion;
import Modelo.ComunicacionConsulta;
import Vista.FormComunicacion;
import Vista.PanelComunicacion;
import static Vista.PantallaPrincipal.escritorio;
import com.toedter.calendar.JTextFieldDateEditor;

/**
 *
 * @author Camila Carrero
 */
public class ComunicacionG implements ActionListener, MouseListener, KeyListener, WindowListener {

    Comunicacion c = new Comunicacion();
    ComunicacionConsulta cc = new ComunicacionConsulta();
    FormComunicacion formC = new FormComunicacion(null, true);
    PanelComunicacion pc = new PanelComunicacion();

    public ComunicacionG() {
        iniciar(c, cc, formC, pc);
    }

    public void iniciar(Comunicacion c, ComunicacionConsulta cc, FormComunicacion formC, PanelComunicacion pc) { //Inicia las variables y agrega los listener.
        this.c = c;
        this.cc = cc;
        this.formC = formC;
        this.pc = pc;
        this.pc.bBuscar.addActionListener(this);
        this.pc.bAgregar.addActionListener(this);
        this.pc.bModificar.addActionListener(this);
        this.pc.bEliminar.addActionListener(this);
        this.pc.table.addMouseListener(this);
        this.formC.bAgregar.addActionListener(this);
        this.formC.bModificar.addActionListener(this);
        this.formC.bAgregarCliente.addActionListener(this);
        this.formC.tCliente.addKeyListener(this);
        this.formC.tObservaciones.addKeyListener(this);
        this.formC.addWindowListener(this);
    }

    public void abrirPanel() { //Abre el PanelComunicacion.
        anularBoton("panel");
        pc.setVisible(true);
        pc.setSize(500, 500);
        pc.setLocation(0, 0);
        escritorio.removeAll();
        escritorio.add(pc);
        escritorio.revalidate();
        escritorio.repaint();
    }

    public void abrirFormComunicacion() { //Abre el formulario FormComunicacion.
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
        } else if (nom == "panel") {
            pc.bModificar.setEnabled(false);
            pc.bEliminar.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pc.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = cc.buscarComunicacion();
            pc.table.setModel(modelo);
            pc.table.getColumn("Id").setPreferredWidth(3);
        }

        if (e.getSource() == pc.bAgregar) {
            anularBoton("modificar");
            abrirFormComunicacion();
        }

        if (e.getSource() == pc.bModificar) {
            cargaDatosModificar();
        }

        if (e.getSource() == pc.bEliminar) {
            cargarDatos();
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la comunicación seleccionada?", "Seleccione una opción", 0, 0);
            if (opcion == JOptionPane.YES_OPTION) {
                if (cc.eliminar(c)) {
                    JOptionPane.showMessageDialog(null, "Eliminación exitosa");
                    pc.bBuscar.doClick();
                }
            }
        }

        if (e.getSource() == formC.bAgregar) {
            ClienteConsulta clic = new ClienteConsulta();
            Cliente cli = new Cliente();
            Date fecha = formC.fecha.getDate();
            if (validarCampos()) {
                if (validarFecha(fecha)) {
                    SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
                    c.setIdCliente(clic.obtenerId(formC.tCliente.getText()));
                    c.setFecha(forma.format(fecha));
                    c.setObservaciones(formC.tObservaciones.getText());
                    c.setIdInconveniente(0);
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
                    SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
                    c.setIdComunicacion(Integer.parseInt(formC.tId.getText()));
                    c.setIdCliente(clic.obtenerId(formC.tCliente.getText()));
                    c.setFecha(forma.format(fecha));
                    c.setObservaciones(formC.tObservaciones.getText());
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
            Vista.BuscarCliente.tAbierto.setText("Comunicación");
            cg.buscarCliente();
        }
    }

    public TableModel cargaDatosModificar() { //Carga los datos de la Comunicación en FormComunicacion para modificarla.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) pc.table.getModel());
        ClienteConsulta clic = new ClienteConsulta();
        try {
            int id = Integer.parseInt(modelo.getValueAt(pc.table.getSelectedRow(), 0).toString());
            formC.tId.setText(Integer.toString(id));
            String nombre = pc.table.getValueAt(pc.table.getSelectedRow(), 1).toString();
            formC.tCliente.setText(clic.obtenerDni(nombre, cc.obtenerIdCliente(id), "Comunicación"));
            try {
                Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(pc.table.getValueAt(pc.table.getSelectedRow(), 2).toString());
                formC.fecha.setDate(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(AgendaG.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            formC.tObservaciones.setText(modelo.getValueAt(pc.table.getSelectedRow(), 3).toString());
            anularBoton("agregar");
            abrirFormComunicacion();
            return modelo;
        } catch (Exception e) {
            System.out.println("error al cargar datos modificar \n" + e);
        }
        return modelo;
    }

    public void cargarDatos() { //Carga datos en una instancia del objeto Comunicacion obtenidos de la tabla de PanelComunicacion.
        String id = pc.table.getValueAt(pc.table.getSelectedRow(), 0).toString();
        c.setIdComunicacion(Integer.parseInt(id));
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
        if (formC.tObservaciones.getText().isEmpty()) {
            formC.tObservaciones.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tObservaciones.setBorder(border);
        }
        if (validacion == false) {
            JOptionPane.showMessageDialog(null, "Debe ingresar los datos marcados");
        }
        return validacion;
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

    public void limpiar() { //Vacia todos los campos y coloca los bordes preestablecidos.
        formC.tId.setText(null);
        formC.tCliente.setText(null);
        formC.fecha.setDate(null);
        formC.tObservaciones.setText(null);
        Border border = formC.tId.getBorder();
        formC.tCliente.setBorder(border);
        formC.fecha.setBorder(border);
        formC.tObservaciones.setBorder(border);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == formC.tCliente) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarDni(e);
        }

        if (e.getSource() == formC.tObservaciones) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarAlfanumerico(e);
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
