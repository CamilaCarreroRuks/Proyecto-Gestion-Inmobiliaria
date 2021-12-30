package Gestor;

import Librerias.ValidarCaracteres;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.TipoUsuarioConsulta;
import Modelo.Usuario;
import Modelo.UsuarioConsulta;
import Vista.FormUsuario;
import Vista.Login;
import Vista.PanelCliente;
import Vista.PanelUsuario;
import Vista.PantallaPrincipal;
import static Vista.PantallaPrincipal.escritorio;
import Vista.PanelTipoCliente;
import Vista.PanelTasacion;
import Vista.PanelContabilidad;
import Vista.PanelComprobante;
import Vista.PanelAgenda;
import Vista.PanelComunicacion;

/**
 *
 * @author Camila Carrero
 */
public class UsuarioG implements ActionListener, MouseListener, KeyListener, WindowListener {

    private Usuario usu = new Usuario();
    private UsuarioConsulta uc = new UsuarioConsulta();
    private FormUsuario formU = new FormUsuario(null, true);
    private Login login = new Login();
    private PanelUsuario pu = new PanelUsuario();

    public UsuarioG() {
        iniciar(usu, uc, formU, login, pu);
    }

    public void iniciar(Usuario usu, UsuarioConsulta uc, FormUsuario formU, Login login, PanelUsuario pu) { //Inicia las variables y agrega los listener.
        this.usu = usu;
        this.uc = uc;
        this.formU = formU;
        this.login = login;
        this.pu = pu;
        this.formU.addWindowListener(this);
        this.formU.bAgregar.addActionListener(this);
        this.formU.bModificar.addActionListener(this);
        this.login.addKeyListener(this);
        this.login.tcontraseña.addKeyListener(this);
        this.login.bingresar.addKeyListener(this);
        this.login.bingresar.addActionListener(this);
        this.pu.bBuscar.addActionListener(this);
        this.pu.bAgregar.addActionListener(this);
        this.pu.bModificar.addActionListener(this);
        this.pu.bEliminar.addActionListener(this);
        this.pu.table.addMouseListener(this);
    }

    public void abrirFormUsuario(boolean v) { //Abre el formulario FormUsuario.
        formU.tipoUsuario.removeAllItems();
        ArrayList tc = TipoUsuarioConsulta.listaTipoUsuario();
        for (int i = 0; i < tc.size(); i++) {
            formU.tipoUsuario.addItem(tc.get(i).toString());
        }
        if (v == true) {
            formU.setVisible(true);
        }
    }

    public void login() { //Abre el formulario Login.
        login.setVisible(true);
    }

    public void abrirPanel() { //Abre el PanelUsuario.
        anularBoton("panel");
        pu.setVisible(true);
        pu.setSize(500, 500);
        pu.setLocation(0, 0);
        escritorio.removeAll();
        escritorio.add(pu);
        escritorio.revalidate();
        escritorio.repaint();
        pu.bBuscar.doClick();
    }

    public void anularBoton(String nom) { //Edita los botones para estar o no disponibles.
        if (nom == "modificar") {
            formU.bModificar.setEnabled(false);
            formU.bAgregar.setEnabled(true);
        } else if (nom == "agregar") {
            formU.bAgregar.setEnabled(false);
            formU.bModificar.setEnabled(true);
        } else if (nom == "0") {
            formU.bModificar.setEnabled(true);
            formU.bAgregar.setEnabled(true);
            pu.bModificar.setEnabled(true);
            pu.bEliminar.setEnabled(true);
        } else if (nom == "panel") {
            pu.bModificar.setEnabled(false);
            pu.bEliminar.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formU.bAgregar) {
            TipoUsuarioConsulta tuc = new TipoUsuarioConsulta();
            usu.setNombreUsuario(formU.tusuario.getText());
            usu.setContraseña(formU.tcontraseña.getText());
            String a = (String) formU.tipoUsuario.getSelectedItem();
            usu.setIdTipoUsuario(tuc.obtenerId(a));
            if (validarCampos()) {
                if (uc.usuarioExiste(usu) == true) {
                    JOptionPane.showMessageDialog(null, "El usuario ingresado ya existe");
                    limpiar();
                    formU.dispose();
                } else {
                    uc.registrar(usu);
                    formU.dispose();
                    limpiar();
                    pu.bBuscar.doClick();
                }
            }
        }

        if (e.getSource() == formU.bModificar) {
            TipoUsuarioConsulta tuc = new TipoUsuarioConsulta();
            usu.setIdUsuario(Integer.parseInt(formU.tid.getText()));
            usu.setNombreUsuario(formU.tusuario.getText());
            usu.setContraseña(formU.tcontraseña.getText());
            String a = (String) formU.tipoUsuario.getSelectedItem();
            usu.setIdTipoUsuario(tuc.obtenerId(a));
            if (validarCampos()) {
                if (uc.modificar(usu)) {
                    JOptionPane.showMessageDialog(null, "Modificación exitosa");
                    formU.dispose();
                    pu.bBuscar.doClick();
                    limpiar();
                }

            }
        }

        if (e.getSource() == login.bingresar) {
            usu.setNombreUsuario(login.tusuario.getText());
            usu.setContraseña(String.valueOf(login.tcontraseña.getPassword()));
            if (validarCamposLogin()) {
                if (uc.login(usu)) {
                    PantallaPrincipalG ppg = new PantallaPrincipalG();
                    ppg.pp.nombreUsuario.setText("   USUARIO:  " + usu.getNombreUsuario());
                    darPermisos(uc.obtenerTipoUsuario(usu), "Pantalla Principal");
                    ppg.abrirPantalla();
                    login.dispose();
                }else{
                    limpiar();                 
                }
            }
        }

        if (e.getSource() == pu.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = uc.buscarUsuario();
            pu.table.setModel(modelo);
            pu.table.getColumn("Id").setPreferredWidth(3);
        }

        if (e.getSource() == pu.bAgregar) {
            anularBoton("modificar");
            abrirFormUsuario(true);
        }

        if (e.getSource() == pu.bModificar) {
            cargaDatosModificar();
        }

        if (e.getSource() == pu.bEliminar) {
            cargarDatos();
            if (usu.getNombreUsuario() == PantallaPrincipal.nombreUsuario.getText() || usu.getIdUsuario() == 1) {
                JOptionPane.showMessageDialog(null, "Este usuario no puede ser eliminado");
            } else {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Usuario seleccionado?", "Seleccione una opción", 0, 0);
                if (opcion == JOptionPane.YES_OPTION) {
                    if (uc.eliminar(usu)) {
                        JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                        pu.bBuscar.doClick();
                    }
                }
            }
        }
    }

    public void limpiar() { //Vacia todos los campos.
        formU.tid.setText(null);
        formU.tusuario.setText(null);
        formU.tcontraseña.setText(null);
        formU.tipoUsuario.setSelectedItem(null);
        login.tusuario.setText(null);
        login.tcontraseña.setText(null);
    }

    public boolean validarCampos() { //Valida que los campos obligatorios no esten vacios.
        boolean validacion = true;
        if (usu.getNombreUsuario() == null || usu.getNombreUsuario().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el usuario");
            validacion = false;
        }
        if (usu.getContraseña() == null || usu.getContraseña().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la contraseña");
            validacion = false;
        }
        Integer a = usu.getIdTipoUsuario();
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el tipo de usuario");
            validacion = false;
        }
        return validacion;
    }

    public boolean validarCamposLogin() { //Valida que los campos obligatorios del Login no esten vacios.
        boolean validacion = true;
        if (usu.getNombreUsuario() == null || usu.getNombreUsuario().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el usuario");
            validacion = false;
        }
        if (usu.getContraseña() == null || usu.getContraseña().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la contraseña");
            validacion = false;
        }
        return validacion;
    }

    public static void darPermisos(int id, String form) { //Establece los permisos del sistema segun el Tipo de Usuario.
        if (id == 2) { //Administración
            if (form == "Pantalla Principal") {
                PantallaPrincipal.smOperaciones.setVisible(false);
                PantallaPrincipal.smZonas.setVisible(false);
                PantallaPrincipal.smGenerarTasacion.setVisible(false);
                PantallaPrincipal.smUsuarios.setVisible(false);
                PantallaPrincipal.smAgregarUsuario.setVisible(false);
                PantallaPrincipal.smTipoUsuario.setVisible(false);
                PantallaPrincipal.smAgregarTipoUsuario.setVisible(false);
            } else if (form == "Cliente") {
                PanelCliente.bEliminar.setVisible(false);
            } else if (form == "Tipo Cliente") {
                PanelTipoCliente.bEliminar.setVisible(false);
            } else if (form == "Tasación") {
                PanelTasacion.bAgregar.setVisible(false);
                PanelTasacion.bEliminar.setVisible(false);
            } else if (form == "Contabilidad") {
                PanelContabilidad.bEliminar.setVisible(false);
            } else if (form == "Agenda") {
                PanelAgenda.bEliminar.setVisible(false);
            } else if (form == "Comunicación") {
                PanelComunicacion.bEliminar.setVisible(false);
            }
        } else if (id == 3) { //Atención al Cliente
            if (form == "Pantalla Principal") {
                PantallaPrincipal.smOperaciones.setVisible(false);
                PantallaPrincipal.smZonas.setVisible(false);
                PantallaPrincipal.smGenerarTasacion.setVisible(false);
                PantallaPrincipal.smUsuarios.setVisible(false);
                PantallaPrincipal.smAgregarUsuario.setVisible(false);
                PantallaPrincipal.smTipoUsuario.setVisible(false);
                PantallaPrincipal.smAgregarTipoUsuario.setVisible(false);
            } else if (form == "Cliente") {
                PanelCliente.bEliminar.setVisible(false);
            } else if (form == "Tipo Cliente") {
                PanelTipoCliente.bEliminar.setVisible(false);
            } else if (form == "Tasación") {
                 PanelTasacion.bAgregar.setVisible(false);
                PanelTasacion.bEliminar.setVisible(false);
            } else if (form == "Contabilidad") {
                PanelContabilidad.bEliminar.setVisible(false);
            } else if (form == "Comprobante") {
                PanelComprobante.bAnular.setVisible(false);
            } else if (form == "Agenda") {
                PanelAgenda.bEliminar.setVisible(false);
            } else if (form == "Comunicación") {
                PanelComunicacion.bEliminar.setVisible(false);
            }
        }
    }

    public void cargarDatos() { //Carga datos en una instancia del objeto Usuario obtenidos de la tabla de PanelUsuario.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) pu.table.getModel());
        String id = modelo.getValueAt(pu.table.getSelectedRow(), 0).toString();
        String nombre = modelo.getValueAt(pu.table.getSelectedRow(), 1).toString();
        usu.setIdUsuario(Integer.parseInt(id));
        usu.setNombreUsuario(nombre);
    }

    public TableModel cargaDatosModificar() { //Carga los datos del Usuario en FormUsuario para modificarlo.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) PanelUsuario.table.getModel());
        try {
            String id = modelo.getValueAt(pu.table.convertRowIndexToView(pu.table.getSelectedRow()), 0).toString();
            String nombre = modelo.getValueAt(pu.table.getSelectedRow(), 1).toString();
            String contraseña = modelo.getValueAt(pu.table.getSelectedRow(), 2).toString();
            String tipo = modelo.getValueAt(pu.table.getSelectedRow(), 3).toString();
            abrirFormUsuario(false);
            formU.tid.setText(id);
            formU.tusuario.setText(nombre);
            formU.tcontraseña.setText(contraseña);
            formU.tipoUsuario.setSelectedItem(tipo);
            anularBoton("agregar");
            formU.setVisible(true);
            return modelo;
        } catch (Exception e) {
            System.out.println("error al cargar datos modificar \n" + e);
        }
        return modelo;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == formU.tusuario) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarAlfanumerico(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            login.bingresar.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == pu.table) {
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
        if (e.getSource() == formU) {
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
