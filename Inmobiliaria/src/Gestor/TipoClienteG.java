package Gestor;

import Librerias.ValidarCaracteres;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.TipoCliente;
import Modelo.TipoClienteConsulta;
import Modelo.Usuario;
import Modelo.UsuarioConsulta;
import Vista.FormTipoCliente;
import Vista.PanelTipoCliente;
import static Vista.PantallaPrincipal.escritorio;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Camila Carrero
 */
public class TipoClienteG implements ActionListener, MouseListener, KeyListener {

    private TipoCliente tc = new TipoCliente();
    private TipoClienteConsulta tcc = new TipoClienteConsulta();
    private FormTipoCliente formTC = new FormTipoCliente(null, true);
    private PanelTipoCliente ptc = new PanelTipoCliente();

    public TipoClienteG() {
        iniciar(tc, tcc, formTC, ptc);
    }

    public void iniciar(TipoCliente tc, TipoClienteConsulta tcc, FormTipoCliente formTC, PanelTipoCliente ptc) { //Inicia las variables y agrega los listener.
        this.tc = tc;
        this.tcc = tcc;
        this.formTC = formTC;
        this.ptc = ptc;
        this.ptc.bBuscar.addActionListener(this);
        this.ptc.bAgregar.addActionListener(this);
        this.ptc.bModificar.addActionListener(this);
        this.ptc.bEliminar.addActionListener(this);
        this.formTC.bAgregar.addActionListener(this);
        this.formTC.bModificar.addActionListener(this);
        this.formTC.tNombre.addKeyListener(this);
        this.ptc.table.addMouseListener(this);
    }

    public void abrirPanel() { //Abre el PanelTipoCliente.
        UsuarioConsulta uc = new UsuarioConsulta();
        Usuario usu = new Usuario();
        usu.setNombreUsuario(Vista.PantallaPrincipal.nombreUsuario.getText().replace("   USUARIO:  ", ""));
        UsuarioG.darPermisos(uc.obtenerTipoUsuario(usu), "Tipo Cliente");
        anularBoton("panel");
        ptc.setVisible(true);
        ptc.setSize(500, 500);
        ptc.setLocation(0, 0);
        escritorio.removeAll();
        escritorio.add(ptc);
        escritorio.revalidate();
        escritorio.repaint();
        ptc.bBuscar.doClick();
    }

    public void abrirFormTipoCliente() { //Abre el formulario FormTipoCliente.
        formTC.setVisible(true);
    }

    public void anularBoton(String nom) { //Edita los botones para estar o no disponibles.
        if (nom == "modificar") {
            formTC.bModificar.setEnabled(false);
            formTC.bAgregar.setEnabled(true);
        } else if (nom == "agregar") {
            formTC.bAgregar.setEnabled(false);
            formTC.bModificar.setEnabled(true);
        } else if (nom == "0") {
            formTC.bModificar.setEnabled(true);
            formTC.bAgregar.setEnabled(true);
            ptc.bModificar.setEnabled(true);
            ptc.bEliminar.setEnabled(true);
        } else if (nom == "panel") {
            ptc.bModificar.setEnabled(false);
            ptc.bEliminar.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formTC.bAgregar) {
            tc.setNombreTipoCliente(formTC.tNombre.getText());
            if (validarCampos()) {
                if (tcc.tipoClienteExiste(tc) == true) {
                    JOptionPane.showMessageDialog(null, "El tipo de cliente ingresado ya existe");
                    limpiar();
                } else if (tcc.registrar(tc)) {
                    limpiar();
                    formTC.dispose();
                    ptc.bBuscar.doClick();
                }
            }
        }

        if (e.getSource() == formTC.bModificar) {
            tc.setNombreTipoCliente(formTC.tNombre.getText());
            tc.setIdTipoCliente(Integer.parseInt(ptc.table.getValueAt(ptc.table.getSelectedRow(), 0).toString()));
            if (validarCampos()) {
                if (tcc.modificar(tc)) {
                    limpiar();
                    formTC.dispose();
                    ptc.bBuscar.doClick();
                }
            }
        }

        if (e.getSource() == ptc.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = tcc.buscarTipoCliente();
            ptc.table.setModel(modelo);
            ptc.table.getColumn("Id").setPreferredWidth(3);
        }

        if (e.getSource() == ptc.bAgregar) {
            anularBoton("modificar");
            abrirFormTipoCliente();
        }

        if (e.getSource() == ptc.bModificar) {
            cargaDatosModificar();
        }

        if (e.getSource() == ptc.bEliminar) {
           cargarDatos();
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Tipo de Cliente seleccionado?", "Seleccione una opción", 0, 0);
            if (opcion == JOptionPane.YES_OPTION) {
                if (tcc.eliminar(tc)) {
                    JOptionPane.showMessageDialog(null, "Tipo de Cliente Eliminado");
                    ptc.bBuscar.doClick();
                }
            }
        }
    }

    public void limpiar() { //Vacia todos los campos.
        formTC.tNombre.setText(null);
    }

    public boolean validarCampos() { //Valida que los campos obligatorios no esten vacios.
        boolean validacion = true;
        if (tc.getNombreTipoCliente() == null || tc.getNombreTipoCliente().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el tipo de cliente");
            validacion = false;
        }
        return validacion;
    }
    
    public void cargarDatos() { //Carga datos en una instancia del objeto TipoCliente obtenidos de la tabla de PanelTipoCliente.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) ptc.table.getModel());
        String id = modelo.getValueAt(ptc.table.getSelectedRow(), 0).toString();
        String nombre = modelo.getValueAt(ptc.table.getSelectedRow(), 1).toString();
        tc.setIdTipoCliente(Integer.parseInt(id));
        tc.setNombreTipoCliente(nombre);
    }

    public TableModel cargaDatosModificar() { //Carga los datos del TipoCliente en FormTipoCliente para modificarlo.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) ptc.table.getModel());
        try {
            String nombre = modelo.getValueAt(ptc.table.getSelectedRow(), 1).toString();
            formTC.tNombre.setText(nombre);
            anularBoton("agregar");
            abrirFormTipoCliente();
            return modelo;
        } catch (Exception e) {
            System.out.println("error al cargar datos modificar \n" + e);
        }
        return modelo;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == formTC.tNombre) {
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
        if (e.getSource() == ptc.table) {
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
}
