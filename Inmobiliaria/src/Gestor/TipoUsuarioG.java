package Gestor;

import Librerias.ValidarCaracteres;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.TipoUsuario;
import Modelo.TipoUsuarioConsulta;
import Vista.FormTipoUsuario;
import Vista.PanelTipoUsuario;
import static Vista.PantallaPrincipal.escritorio;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Camila Carrero
 */
public class TipoUsuarioG implements ActionListener, WindowListener, MouseListener, KeyListener {

    private TipoUsuario tu = new TipoUsuario();
    private TipoUsuarioConsulta tuc = new TipoUsuarioConsulta();
    private FormTipoUsuario formTU = new FormTipoUsuario(null, true);
    private PanelTipoUsuario ptu = new PanelTipoUsuario();

    public TipoUsuarioG() {
        iniciar(tu, tuc, formTU, ptu);
    }

    public void iniciar(TipoUsuario tu, TipoUsuarioConsulta tuc, FormTipoUsuario formTU, PanelTipoUsuario ptu) { //Inicia las variables y agrega los listener.
        this.tu = tu;
        this.tuc = tuc;
        this.formTU = formTU;
        this.ptu = ptu;
        this.formTU.addWindowListener(this);
        this.formTU.bAgregar.addActionListener(this);
        this.formTU.bModificar.addActionListener(this);
        this.formTU.tNombre.addKeyListener(this);
        this.ptu.bBuscar.addActionListener(this);
        this.ptu.bAgregar.addActionListener(this);
        this.ptu.bModificar.addActionListener(this);
        this.ptu.bEliminar.addActionListener(this);
        this.ptu.table.addMouseListener(this);
    }

    public void abrirPanel() { //Abre el PanelTipoUsuario.
        anularBoton("panel");
        ptu.setVisible(true);
        ptu.setSize(500, 500);
        ptu.setLocation(0, 0);
        escritorio.removeAll();
        escritorio.add(ptu);
        escritorio.revalidate();
        escritorio.repaint();
        ptu.bBuscar.doClick();
    }

    public void abrirFormUsuario() { //Abre el formulario FormTipoUsuario.
        formTU.setVisible(true);
    }

    public void anularBoton(String nom) { //Edita los botones para estar o no disponibles.
        if (nom == "modificar") {
            formTU.bModificar.setEnabled(false);
            formTU.bAgregar.setEnabled(true);
        } else if (nom == "agregar") {
            formTU.bAgregar.setEnabled(false);
            formTU.bModificar.setEnabled(true);
        } else if (nom == "0") {
            formTU.bModificar.setEnabled(true);
            formTU.bAgregar.setEnabled(true);
            ptu.bModificar.setEnabled(true);
            ptu.bEliminar.setEnabled(true);
        } else if (nom == "panel") {
            ptu.bModificar.setEnabled(false);
            ptu.bEliminar.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formTU.bAgregar) {
            tu.setNombreTipoUsuario(formTU.tNombre.getText());
            if (validarCampos()) {
                if (tuc.tipoUsuarioExiste(tu) == true) {
                    JOptionPane.showMessageDialog(null, "El tipo de usuario ingresado ya existe");
                    limpiar();
                } else {
                    tuc.registrar(tu);
                    formTU.dispose();
                    ptu.bBuscar.doClick();
                    limpiar();
                }
            }
        }

        if (e.getSource() == formTU.bModificar) {
            cargarDatos();
            if (validarCampos()) {
                tu.setNombreTipoUsuario(formTU.tNombre.getText());
                if (tuc.modificar(tu)) {
                    formTU.dispose();
                    ptu.bBuscar.doClick();
                    limpiar();
                }
            }
        }

        if (e.getSource() == ptu.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = tuc.buscarTipoUsuario();
            ptu.table.setModel(modelo);
            ptu.table.getColumn("Id").setPreferredWidth(3);
        }

        if (e.getSource() == ptu.bAgregar) {
            anularBoton("modificar");
            abrirFormUsuario();
        }

        if (e.getSource() == ptu.bModificar) {
            anularBoton("agregar");
            cargaDatosModificar();
        }

        if (e.getSource() == ptu.bEliminar) {
            cargarDatos();
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Tipo de Usuario seleccionado?", "Seleccione una opción", 0, 0);
            if (opcion == JOptionPane.YES_OPTION) {
                if (tuc.eliminar(tu)) {
                    JOptionPane.showMessageDialog(null, "Eliminación exitosa");
                    ptu.bBuscar.doClick();
                }
            }
        }
    }

    public void limpiar() { //Vacia todos los campos.
        formTU.tNombre.setText(null);
    }

    public boolean validarCampos() { //Valida que los campos obligatorios no esten vacios.
        boolean validacion = true;
        if (tu.getNombreTipoUsuario() == null || tu.getNombreTipoUsuario().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el tipo de usuario");
            validacion = false;
        }
        return validacion;
    }

    public void cargarDatos() { //Carga datos en una instancia del objeto TipoUsuario obtenidos de la tabla de PanelTipoUsuario.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) ptu.table.getModel());
        String id = modelo.getValueAt(ptu.table.getSelectedRow(), 0).toString();
        String nombre = modelo.getValueAt(ptu.table.getSelectedRow(), 1).toString();
        tu.setIdTipoUsuario(Integer.parseInt(id));
        tu.setNombreTipoUsuario(nombre);
    }

    public TableModel cargaDatosModificar() { //Carga los datos del TipoUsuario en FormTipoUsuario para modificarlo.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) ptu.table.getModel());
        try {
            String nombre = modelo.getValueAt(ptu.table.getSelectedRow(), 1).toString();
            formTU.tNombre.setText(nombre);
            formTU.setVisible(true);
            return modelo;
        } catch (Exception e) {
            System.out.println("error al cargar datos modificar \n" + e);
        }
        return modelo;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == formTU.tNombre) {
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
        if (e.getSource() == ptu.table) {
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
        if (e.getSource() == formTU) {
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
