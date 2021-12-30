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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.Agenda;
import Modelo.AgendaConsulta;
import Modelo.Cliente;
import Modelo.ClienteConsulta;
import Vista.BuscarCliente;
import Vista.FormAgenda;
import Vista.PanelAgenda;
import static Vista.PantallaPrincipal.escritorio;
import com.toedter.calendar.JTextFieldDateEditor;

/**
 *
 * @author Camila Carrero
 */
public class AgendaG implements ActionListener, MouseListener, KeyListener, WindowListener {

    Agenda a = new Agenda();
    AgendaConsulta ac = new AgendaConsulta();
    PanelAgenda pa = new Vista.PanelAgenda();
    FormAgenda formA = new FormAgenda(null, true);
    JDialog ventana = new JDialog(formA);

    public AgendaG() {
        iniciar(a, ac, pa, formA);
    }

    public void iniciar(Agenda a, AgendaConsulta ac, PanelAgenda pa, FormAgenda formA) { //Inicia las variables y agrega los listener.
        this.a = a;
        this.ac = ac;
        this.pa = pa;
        this.formA = formA;
        this.pa.bBuscar.addActionListener(this);
        this.pa.bAgregar.addActionListener(this);
        this.pa.bModificar.addActionListener(this);
        this.pa.bEliminar.addActionListener(this);
        this.pa.table.addMouseListener(this);
        this.formA.addWindowListener(this);
        this.formA.bAgregar.addActionListener(this);
        this.formA.bModificar.addActionListener(this);
        this.formA.bAgregarCliente.addActionListener(this);
        this.formA.tCliente.addKeyListener(this);
        this.formA.tLugar.addKeyListener(this);
        this.formA.tObservaciones.addKeyListener(this);
    }

    public void abrirPanel() { //Abre el PanelAgenda.
        anularBoton("panel");
        pa.setVisible(true);
        pa.setSize(500, 500);
        pa.setLocation(0, 0);
        pa.bModificar.setEnabled(false);
        pa.bEliminar.setEnabled(false);
        escritorio.removeAll();
        escritorio.add(pa);
        escritorio.revalidate();
        escritorio.repaint();
    }

    public void abrirFormAgenda() { //Abre el formulario FormAgenda.
        JTextFieldDateEditor editor = (JTextFieldDateEditor) formA.fecha.getDateEditor();
        editor.setEditable(false);
        formA.setVisible(true);
    }

    public void anularBoton(String nom) { //Edita los botones para estar o no disponibles.
        if (nom == "modificar") {
            formA.bModificar.setEnabled(false);
            formA.bAgregar.setEnabled(true);
        } else if (nom == "agregar") {
            formA.bAgregar.setEnabled(false);
            formA.bModificar.setEnabled(true);
        } else if (nom == "0") {
            formA.bModificar.setEnabled(true);
            formA.bAgregar.setEnabled(true);
            pa.bModificar.setEnabled(true);
            pa.bEliminar.setEnabled(true);
        } else if (nom == "panel") {
            pa.bModificar.setEnabled(false);
            pa.bEliminar.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pa.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = ac.buscarAgenda();
            pa.table.setModel(modelo);
            pa.table.getColumn("Id").setPreferredWidth(3);
        }

        if (e.getSource() == pa.bAgregar) {
            anularBoton("modificar");
            abrirFormAgenda();
        }

        if (e.getSource() == pa.bModificar) {
            ClienteConsulta cc = new ClienteConsulta();
            int id = Integer.parseInt(pa.table.getValueAt(pa.table.getSelectedRow(), 0).toString());
            formA.tId.setText(Integer.toString(id));
            try {
                Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(pa.table.getValueAt(pa.table.getSelectedRow(), 1).toString());
                formA.fecha.setDate(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(AgendaG.class.getName()).log(Level.SEVERE, null, ex);
            }
            String nombre = pa.table.getValueAt(pa.table.getSelectedRow(), 4).toString();
            formA.tCliente.setText(cc.obtenerDni(nombre, ac.obtenerIdCliente(id), "Agenda"));
            formA.tLugar.setText(pa.table.getValueAt(pa.table.getSelectedRow(), 2).toString());
            String hora[] = pa.table.getValueAt(pa.table.getSelectedRow(), 3).toString().split(":");
            formA.hora.setSelectedItem(hora[0]);
            formA.minutos.setSelectedItem(hora[1]);
            formA.tObservaciones.setText(pa.table.getValueAt(pa.table.getSelectedRow(), 5).toString());
            anularBoton("agregar");
            abrirFormAgenda();
        }

        if (e.getSource() == pa.bEliminar) {
            cargarDatos();
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el evento seleccionado?", "Seleccione una opción", 0, 0);
            if (opcion == JOptionPane.YES_OPTION) {
                if (ac.eliminar(a)) {
                    JOptionPane.showMessageDialog(null, "Eliminación exitosa");
                    pa.bBuscar.doClick();
                }
            }
        }

        if (e.getSource() == formA.bAgregar) {
            ClienteConsulta cc = new ClienteConsulta();
            Cliente cli = new Cliente();
            Date fecha = formA.fecha.getDate();
            if (validarCampos()) {
                if (validarFecha(fecha)) {
                    String hora = formA.hora.getSelectedItem().toString();
                    String minutos = formA.minutos.getSelectedItem().toString();
                    if (validarHora(fecha, hora, minutos)) {
                        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
                        a.setFecha(forma.format(fecha));
                        a.setLugar(formA.tLugar.getText());
                        a.setHora(hora + ":" + minutos);
                        a.setIdCliente(cc.obtenerId(formA.tCliente.getText()));
                        a.setObservaciones(formA.tObservaciones.getText());
                        cli.setDni(Integer.parseInt(formA.tCliente.getText()));
                        if (cc.clienteExiste(cli)) {
                            if (ac.registrar(a)) {
                                JOptionPane.showMessageDialog(null, "Registro exitoso");
                                formA.dispose();
                                pa.bBuscar.doClick();
                                limpiar();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El cliente ingresado no existe");
                        }
                    }
                }
            }
        }

        if (e.getSource() == formA.bModificar) {
            ClienteConsulta cc = new ClienteConsulta();
            Cliente cli = new Cliente();
            if (validarCampos()) {
                Date fecha = formA.fecha.getDate();
                if (validarFecha(fecha)) {
                    String hora = formA.hora.getSelectedItem().toString();
                    String minutos = formA.minutos.getSelectedItem().toString();
                    if (validarHora(fecha, hora, minutos)) {
                        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
                        a.setIdAgenda(Integer.parseInt(formA.tId.getText()));
                        a.setIdCliente(cc.obtenerId(formA.tCliente.getText()));
                        a.setFecha(forma.format(fecha));
                        a.setHora(hora + ":" + minutos);
                        a.setLugar(formA.tLugar.getText());
                        a.setObservaciones(formA.tObservaciones.getText());
                        cli.setDni(Integer.parseInt(formA.tCliente.getText()));
                        if (cc.clienteExiste(cli)) {
                            if (ac.modificar(a)) {
                                JOptionPane.showMessageDialog(null, "Modificación exitosa");
                                formA.dispose();
                                pa.bBuscar.doClick();
                                limpiar();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El cliente ingresado no existe");
                        }
                    }
                }
            }
        }

        if (e.getSource() == formA.bAgregarCliente) {
            ClienteG cg = new ClienteG();
            BuscarCliente.tAbierto.setText("Agenda");
            cg.buscarCliente();
        }
    }

    public void cargarDatos() { //Carga datos en una instancia del objeto Agenda obtenidos de la tabla de PanelAgenda.
        String id = pa.table.getValueAt(pa.table.getSelectedRow(), 0).toString();
        a.setIdAgenda(Integer.parseInt(id));
    }

    public boolean validarFecha(Date fecha) { //Valida que la fecha sea igual o mayor a la actual.
        boolean validacion = false;
        Date fechaActual = new Date();
        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        if (fecha.compareTo(fechaActual) > 0 || forma.format(fecha).equals(forma.format(fechaActual))) {
            validacion = true;
        } else {
            JOptionPane.showMessageDialog(null, "La fecha ingresada es incorrecta");
        }
        return validacion;
    }

    public boolean validarHora(Date fecha, String hora, String minutos) { //Valida que la hora sea correcta.
        boolean validacion = false;
        Date fechaActual = new Date();
        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        if (forma.format(fecha).equals(forma.format(fechaActual))) {
            if (fechaActual.getHours() > Integer.parseInt(hora)) {
                JOptionPane.showMessageDialog(null, "La hora ingresada es incorrecta");
            } else if (fechaActual.getHours() == Integer.parseInt(hora) && fechaActual.getMinutes() > Integer.parseInt(minutos)) {
                JOptionPane.showMessageDialog(null, "La hora ingresada es incorrecta");
            } else {
                validacion = true;
            }
        } else {
            validacion = true;
        }
        return validacion;
    }

    public boolean validarCampos() { //Valida que los campos obligatorios no esten vacios.
        boolean validacion = true;
        Border border = formA.tId.getBorder();
        if (formA.tCliente.getText().isEmpty()) {
            formA.tCliente.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formA.tCliente.setBorder(border);
        }
        if (formA.fecha.getDate() == null) {
            formA.fecha.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formA.fecha.setBorder(border);
        }
        if (formA.tLugar.getText().isEmpty()) {
            formA.tLugar.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formA.tLugar.setBorder(border);
        }
        if (validacion == false) {
            JOptionPane.showMessageDialog(null, "Debe ingresar los datos marcados");
        }
        return validacion;
    }

    public void limpiar() { //Vacia todos los campos y coloca los bordes preestablecidos.
        formA.tId.setText(null);
        formA.fecha.setDate(null);
        formA.tLugar.setText(null);
        formA.hora.setSelectedItem(null);
        formA.minutos.setSelectedItem(null);
        formA.tObservaciones.setText(null);
        formA.tCliente.setText(null);
        Border border = formA.tId.getBorder();
        formA.tCliente.setBorder(border);
        formA.fecha.setBorder(border);
        formA.tLugar.setBorder(border);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == formA.tCliente) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarDni(e);
            if (formA.tCliente.getText().length() > 11) {
                e.consume();
            }
        }

        if (e.getSource() == formA.tLugar || e.getSource() == formA.tObservaciones) {
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
        if (e.getSource() == pa.table) {
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
        if (e.getSource() == formA) {
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
