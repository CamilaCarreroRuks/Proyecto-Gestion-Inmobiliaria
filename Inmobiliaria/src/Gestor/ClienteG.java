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
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.Cliente;
import Modelo.ClienteConsulta;
import Modelo.DireccionConsulta;
import Modelo.LocalidadConsulta;
import Modelo.TipoClienteConsulta;
import Modelo.Direccion;
import Modelo.Localidad;
import Vista.PanelCliente;
import static Vista.PantallaPrincipal.escritorio;
import Vista.BuscarCliente;
import Vista.GenerarTasacion;
import Vista.FormCliente;
import Vista.FormComunicacion;
import Vista.FormContabilidad;
import Vista.FormAgenda;
import Modelo.Usuario;
import Modelo.UsuarioConsulta;
import Vista.PantallaPrincipal;

/**
 *
 * @author Camila Carrero
 */
public class ClienteG implements ActionListener, KeyListener, MouseListener, WindowListener {

    private Cliente cli = new Cliente();
    private ClienteConsulta cc = new ClienteConsulta();
    private PanelCliente pc = new PanelCliente();
    private FormCliente formC = new FormCliente(null, true);
    private BuscarCliente formBC = new BuscarCliente(null, true);

    public ClienteG() {
        iniciar(cli, cc, pc, formC, formBC);
    }

    public void iniciar(Cliente cli, ClienteConsulta cc, PanelCliente pc, FormCliente formC, BuscarCliente formBC) { //Inicia las variables y agrega los listener.
        this.cli = cli;
        this.cc = cc;
        this.pc = pc;
        this.formC = formC;
        this.formBC = formBC;
        this.formC.addWindowListener(this);
        this.formC.bAgregar.addActionListener(this);
        this.formC.tDni.addKeyListener(this);
        this.formC.tTelefono.addKeyListener(this);
        this.formC.tTelefono1.addKeyListener(this);
        this.formC.tNombre.addKeyListener(this);
        this.formC.tNombre1.addKeyListener(this);
        this.formC.tApellido.addKeyListener(this);
        this.formC.tApellido1.addKeyListener(this);
        this.formC.tCorreo.addKeyListener(this);
        this.formC.tCalle.addKeyListener(this);
        this.formC.tNumero.addKeyListener(this);
        this.formC.tDepartamento.addKeyListener(this);
        this.formC.bModificar.addActionListener(this);
        this.pc.table.addMouseListener(this);
        this.pc.bBuscar.addActionListener(this);
        this.pc.bAgregar.addActionListener(this);
        this.pc.bModificar.addActionListener(this);
        this.pc.bEliminar.addActionListener(this);
        this.formBC.bBuscar.addActionListener(this);
        this.formBC.table.addMouseListener(this);
    }

    public void abrirPanel() { //Abre el PanelCliente.
        UsuarioConsulta uc = new UsuarioConsulta();
        Usuario usu = new Usuario();
        usu.setNombreUsuario(PantallaPrincipal.nombreUsuario.getText().replace("   USUARIO:  ", ""));
        UsuarioG.darPermisos(uc.obtenerTipoUsuario(usu), "Cliente");
        anularBoton("panel");
        pc.setVisible(true);
        pc.setSize(500, 500);
        pc.setLocation(0, 0);
        escritorio.removeAll();
        escritorio.add(pc);
        escritorio.revalidate();
        escritorio.repaint();
    }

    public void abrirFormCliente(boolean v) { //Abre el formulario FormCliente.
        formC.tipoCliente.removeAllItems();
        ArrayList tc = TipoClienteConsulta.listaTipoCliente();
        for (int i = 0; i < tc.size(); i++) {
            formC.tipoCliente.addItem(tc.get(i).toString());
        }
        formC.localidad.removeAllItems();
        ArrayList l = LocalidadConsulta.listaLocalidad();
        for (int e = 0; e < l.size(); e++) {
            formC.localidad.addItem(l.get(e).toString());
        }
        if (v == true) {
            formC.setVisible(true);
        }
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

    public void buscarCliente() { //Abre el formulario BuscarCliente.
        formBC.tAbierto.setVisible(false);
        formBC.setVisible(true);
        formBC.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pc.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = cc.buscarClientePanel();
            pc.table.setModel(modelo);
            pc.table.getColumn("Id").setPreferredWidth(3);
        }

        if (e.getSource() == pc.bAgregar) {
            anularBoton("modificar");
            abrirFormCliente(true);
        }

        if (e.getSource() == pc.bModificar) {
            cargaDatosModificar();
        }

        if (e.getSource() == pc.bEliminar) {
            cargarDatos();
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Cliente seleccionado?", "Seleccione una opción", 0, 0);
            if (opcion == JOptionPane.YES_OPTION) {
                cc.eliminar(cli);
                pc.bBuscar.doClick();
            }
        }

        if (e.getSource() == formC.bAgregar) {
            agregarCliente();
        }

        if (e.getSource() == formC.bModificar) {
            modificarCliente();
        }

        if (e.getSource() == formBC.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = cc.buscarClienteX();
            formBC.table.setModel(modelo);
            formBC.table.getColumn("Id").setPreferredWidth(3);
        }
    }

    public void agregarCliente() { //Realiza el registro del Cliente y la inserción en la base de datos.
        TipoClienteConsulta tcc = new TipoClienteConsulta();
        DireccionConsulta dc = new DireccionConsulta();
        LocalidadConsulta lc = new LocalidadConsulta();
        Direccion d = new Direccion();
        Localidad l = new Localidad();
        try {
            if (validarCampos()) {
                cli.setDni(Integer.parseInt(formC.tDni.getText()));
                if (cc.clienteExiste(cli) == true) {
                    JOptionPane.showMessageDialog(null, "El cliente ingresado ya existe");
                    limpiar();
                    formC.dispose();
                } else {
                    String idTC = (String) formC.tipoCliente.getSelectedItem();
                    cli.setIdTipoCliente(tcc.obtenerId(idTC));
                    cli.setPrimerNombre(formC.tNombre.getText());
                    cli.setSegundoNombre(formC.tNombre1.getText());
                    cli.setPrimerApellido(formC.tApellido.getText());
                    cli.setSegundoApellido(formC.tApellido1.getText());
                    cli.setTelefonoPrincipal(Integer.parseInt(formC.tTelefono.getText()));
                    if (formC.tTelefono1.getText().isEmpty()) {
                        formC.tTelefono1.setText(Integer.toString(0));
                        cli.setTelefonoSecundario(Integer.parseInt(formC.tTelefono1.getText()));
                    } else {
                        cli.setTelefonoSecundario(Integer.parseInt(formC.tTelefono1.getText()));
                    }
                    cli.setCorreo(formC.tCorreo.getText());
                    d.setCalle(formC.tCalle.getText());
                    d.setNumero(Integer.parseInt(formC.tNumero.getText()));
                    d.setDepartamento(formC.tDepartamento.getText());
                    l.setNombreLocalidad(formC.localidad.getSelectedItem().toString());
                    d.setIdLocalidad(lc.obtenerId(l));
                    dc.registrar(d);
                    cli.setIdDireccion(dc.obtenerId(d));
                    if (cc.registrar(cli)) {
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                        formC.dispose();
                        pc.bBuscar.doClick();
                        limpiar();
                    }
                }
            }
        } catch (NumberFormatException ex) {

        }
    }

    public void modificarCliente() { //Realiza la modificación del Cliente y actualización de base de datos.
        cargarDatosModelo();
        if (validarCampos()) {
            Direccion d = new Direccion();
            Localidad l = new Localidad();
            DireccionConsulta dc = new DireccionConsulta();
            LocalidadConsulta lc = new LocalidadConsulta();
            TipoClienteConsulta tcc = new TipoClienteConsulta();
            cli.setIdCliente(Integer.parseInt(formC.tId.getText()));
            cli.setIdTipoCliente(tcc.obtenerId(formC.tipoCliente.getSelectedItem().toString()));
            cli.setPrimerNombre(formC.tNombre.getText());
            cli.setSegundoNombre(formC.tNombre1.getText());
            cli.setPrimerApellido(formC.tApellido.getText());
            cli.setSegundoApellido(formC.tApellido1.getText());
            cli.setDni(Integer.parseInt(formC.tDni.getText()));
            d.setCalle(formC.tCalle.getText());
            d.setNumero(Integer.parseInt(formC.tNumero.getText()));
            d.setDepartamento(formC.tDepartamento.getText());
            l.setNombreLocalidad(formC.localidad.getSelectedItem().toString());
            d.setIdLocalidad(lc.obtenerId(l));
            cli.setIdDireccion(cc.obtenerDireccion(cli));
            d.setIdDireccion(cli.getIdDireccion());
            cli.setTelefonoPrincipal(Integer.parseInt(formC.tTelefono.getText()));
            if (formC.tTelefono1.getText().isEmpty()) {
                formC.tTelefono1.setText(Integer.toString(0));
                cli.setTelefonoSecundario(Integer.parseInt(formC.tTelefono1.getText()));
            } else {
                cli.setTelefonoSecundario(Integer.parseInt(formC.tTelefono1.getText()));
            }
            cli.setCorreo(formC.tCorreo.getText());
            if (dc.modificar(d)) {
                if (cc.modificar(cli)) {
                    JOptionPane.showMessageDialog(null, "Modificación exitosa");
                    formC.dispose();
                    pc.bBuscar.doClick();
                    limpiar();
                }
            }
        }
    }

    public boolean validarCampos() { //Valida que los campos obligatorios no esten vacios y que el correo contenga los caracteres obligatorios.
        boolean validacion = true;
        Border border = formC.tApellido1.getBorder();
        if (formC.tNombre.getText().isEmpty()) {
            formC.tNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tNombre.setBorder(border);
        }
        if (formC.tApellido.getText().isEmpty()) {
            formC.tApellido.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tApellido.setBorder(border);
        }
        if (formC.tCalle.getText().isEmpty()) {
            formC.tCalle.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tCalle.setBorder(border);
        }
        if (formC.tNumero.getText().isEmpty()) {
            formC.tNumero.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tNumero.setBorder(border);
        }
        if (formC.tCorreo.getText().isEmpty()) {
            formC.tCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            if (formC.tCorreo.getText().contains("@") && formC.tCorreo.getText().contains(".com")) {
                formC.tCorreo.setBorder(border);
            } else {
                JOptionPane.showMessageDialog(null, "El correo ingresado no es correcto");
                formC.tCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                validacion = false;
            }
        }
        if (formC.tDni.getText().isEmpty()) {
            formC.tDni.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tDni.setBorder(border);
        }
        if (formC.tTelefono.getText().isEmpty()) {
            formC.tTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tTelefono.setBorder(border);
        }
        if (validacion == false) {
            JOptionPane.showMessageDialog(null, "Debe ingresar los datos marcados");
        }
        return validacion;
    }

    public void limpiar() { //Vacia todos los campos y coloca los bordes preestablecidos.
        formC.tId.setText(null);
        formC.tNombre.setText(null);
        formC.tNombre1.setText(null);
        formC.tApellido.setText(null);
        formC.tApellido1.setText(null);
        formC.tDni.setText(null);
        formC.tCalle.setText(null);
        formC.tNumero.setText(null);
        formC.tDepartamento.setText(null);
        formC.tTelefono.setText(null);
        formC.tTelefono1.setText(null);
        formC.tCorreo.setText(null);
        formC.localidad.setSelectedItem(null);
        formC.tipoCliente.setSelectedItem(null);
        Border border = formC.tApellido1.getBorder();
        formC.tNombre.setBorder(border);
        formC.tApellido.setBorder(border);
        formC.tCalle.setBorder(border);
        formC.tNumero.setBorder(border);
        formC.tCorreo.setBorder(border);
        formC.tDni.setBorder(border);
        formC.tTelefono.setBorder(border);
    }

    public void cargarDatos() { //Carga datos en una instancia del objeto Cliente obtenidos de la tabla de PanelCliente.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) pc.table.getModel());
        String id = modelo.getValueAt(pc.table.getSelectedRow(), 0).toString();
        String dni = modelo.getValueAt(pc.table.getSelectedRow(), 3).toString();
        cli.setIdCliente(Integer.parseInt(id));
        cli.setDni(Integer.parseInt(dni));
    }

    public TableModel cargaDatosModificar() { //Carga los datos del Cliente en FormCliente para modificarlo.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) pc.table.getModel());
        try {
            String id = modelo.getValueAt(pc.table.convertRowIndexToView(pc.table.getSelectedRow()), 0).toString();
            formC.tId.setText(id);
            JTable tabla = new JTable(cc.clienteXId(id));
            modelo = (DefaultTableModel) tabla.getModel();
            String tc = modelo.getValueAt(0, 1).toString();
            abrirFormCliente(false);
            formC.tipoCliente.setSelectedItem(tc);
            formC.tNombre.setText(modelo.getValueAt(0, 2).toString());
            formC.tNombre1.setText(modelo.getValueAt(0, 3).toString());
            formC.tApellido.setText(modelo.getValueAt(0, 4).toString());
            formC.tApellido1.setText(modelo.getValueAt(0, 5).toString());
            formC.tDni.setText(modelo.getValueAt(0, 6).toString());
            formC.tCalle.setText(modelo.getValueAt(0, 7).toString());
            formC.tNumero.setText(modelo.getValueAt(0, 8).toString());
            formC.tDepartamento.setText(modelo.getValueAt(0, 9).toString());
            String loc = modelo.getValueAt(0, 10).toString();
            formC.localidad.setSelectedItem(loc);
            formC.tTelefono.setText(modelo.getValueAt(0, 11).toString());
            if (cc.existeTel(id) == true) {
                formC.tTelefono1.setText(modelo.getValueAt(0, 12).toString());
            }
            formC.tCorreo.setText(modelo.getValueAt(0, 13).toString());
            anularBoton("agregar");
            formC.setVisible(true);
            return modelo;
        } catch (Exception e) {
            System.out.println("error al cargar datos modificar \n" + e);
        }
        return modelo;
    }

    public void cargarDatosModelo() { //Carga datos en las instancias de los objetos Cliente, Domicilio y Localidad obtenidos de FormCliente.
        Direccion d = new Direccion();
        Localidad l = new Localidad();
        DireccionConsulta dc = new DireccionConsulta();
        LocalidadConsulta lc = new LocalidadConsulta();
        cli.setPrimerNombre(formC.tNombre.getText());
        cli.setSegundoNombre(formC.tNombre1.getText());
        cli.setPrimerApellido(formC.tApellido.getText());
        cli.setSegundoApellido(formC.tApellido1.getText());
        cli.setDni(Integer.parseInt(formC.tDni.getText()));
        d.setCalle(formC.tCalle.getText());
        d.setNumero(Integer.parseInt(formC.tNumero.getText()));
        d.setDepartamento(formC.tDepartamento.getText());
        l.setNombreLocalidad(formC.localidad.getSelectedItem().toString());
        d.setIdLocalidad(lc.obtenerId(l));
        cli.setIdDireccion(dc.obtenerId(d));
        cli.setTelefonoPrincipal(Integer.parseInt(formC.tTelefono.getText()));
        if (!formC.tTelefono1.getText().isEmpty()) {
            cli.setTelefonoSecundario(Integer.parseInt(formC.tTelefono1.getText()));
        }
        cli.setCorreo(formC.tCorreo.getText());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == formC.tDni) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarDni(e);
            if (formC.tDni.getText().length() > 10) {
                e.consume();
            }
        }

        if (e.getSource() == formC.tTelefono || e.getSource() == formC.tTelefono1 || e.getSource() == formC.tNumero) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarTel(e);
        }

        if (e.getSource() == formC.tCorreo) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarCorreo(e);
        }

        if (e.getSource() == formC.tCalle || e.getSource() == formC.tDepartamento) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarAlfanumerico(e);
        }

        if (e.getSource() == formC.tNombre || e.getSource() == formC.tNombre1 || e.getSource() == formC.tApellido || e.getSource() == formC.tApellido1) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarSoloLetras(e);
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

        if (e.getSource() == formBC.table) {
            if (e.getClickCount() == 2) {
                int fila = formBC.table.getSelectedRow();
                String dni = formBC.table.getValueAt(fila, 3).toString();
                if (formBC.tAbierto.getText().equals("Tasación")) {
                    GenerarTasacion.tCliente.setText(dni);
                    formBC.dispose();
                } else if (formBC.tAbierto.getText().equals("Contabilidad")) {
                    FormContabilidad.tCliente.setText(dni);
                    formBC.dispose();
                } else if (formBC.tAbierto.getText().equals("Comunicación")) {
                    FormComunicacion.tCliente.setText(dni);
                    formBC.dispose();
                } else if (formBC.tAbierto.getText().equals("Agenda")) {
                    FormAgenda.tCliente.setText(dni);
                    formBC.dispose();
                }
            }
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
