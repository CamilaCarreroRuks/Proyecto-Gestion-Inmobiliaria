package Gestor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.Propiedad;
import Modelo.PropiedadConsulta;
import Vista.FormPropiedad;
import Vista.PanelPropiedad;
import static Vista.PantallaPrincipal.escritorio;

/**
 *
 * @author Camila Carrero
 */
public class PropiedadG implements ActionListener {

    Propiedad p = new Propiedad();
    PropiedadConsulta pc = new PropiedadConsulta();
    PanelPropiedad pp = new PanelPropiedad();
    FormPropiedad formP = new FormPropiedad(null, true);

    public PropiedadG() {
        iniciar(p, pc, pp, formP);
    }

    public void iniciar(Propiedad p, PropiedadConsulta pc, PanelPropiedad pp, FormPropiedad formP) { //Inicia las variables y agrega los listener.
        this.p = p;
        this.pc = pc;
        this.pp = pp;
        this.formP = formP;
        this.pp.bAgregar.addActionListener(this);
        this.pp.bEliminar.addActionListener(this);
        this.pp.bModificar.addActionListener(this);
        this.formP.bAgregar.addActionListener(this);
        this.formP.bModificar.addActionListener(this);
    }

    public void abrirPanel() { //Abre el PanelPropiedad.
        pp.setVisible(true);
        pp.setSize(500, 500);
        pp.setLocation(0, 0);
        escritorio.removeAll();
        escritorio.add(pp);
        escritorio.revalidate();
        escritorio.repaint();
    }

    public void abrirFormPropiedad() { //Abre el formulario FormPropiedad.
        formP.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pp.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = pc.buscarPropiedad();
            pp.table.setModel(modelo);
            pp.table.getColumn("Id").setPreferredWidth(3);
        }

        if (e.getSource() == pp.bAgregar) {
            formP.bAgregar.setEnabled(true);
            formP.bModificar.setEnabled(false);
            abrirFormPropiedad();
        }

        if (e.getSource() == pp.bModificar) {
            cargarDatosModificar();
        }

        if (e.getSource() == pp.bEliminar) {
            cargarDatos();
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Cliente seleccionado?", "Seleccione una opción", 0, 0);
            if (opcion == JOptionPane.YES_OPTION) {
                pc.eliminar(p);
                pp.bBuscar.doClick();
            }
        }

        if (e.getSource() == formP.bAgregar) {

        }

        if (e.getSource() == formP.bModificar) {

        }
    }

    public TableModel cargarDatosModificar() { //Carga los datos de la Propiedad en FormPropiedad para modificarlo.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) pp.table.getModel());
        try {
            String id = modelo.getValueAt(pp.table.convertRowIndexToView(pp.table.getSelectedRow()), 0).toString();
            formP.tId.setText(id);
            JTable tabla = new JTable(pc.propiedadXId(id));
            modelo = (DefaultTableModel) tabla.getModel();
            String tc = modelo.getValueAt(0, 1).toString();
            // formP.tipoCliente.setSelectedItem(tc);
            formP.tNombre.setText(modelo.getValueAt(0, 2).toString());
            formP.bAgregar.setEnabled(true);
            formP.bModificar.setEnabled(false);
            abrirFormPropiedad();
            return modelo;
        } catch (Exception e) {
            System.out.println("error al cargar datos modificar \n" + e);
        }
        return modelo;
    }

    public void cargarDatos() { //Carga datos en una instancia del objeto Propiedad obtenidos de la tabla de PanelPropiedad.
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = ((DefaultTableModel) pp.table.getModel());
        String id = modelo.getValueAt(pp.table.getSelectedRow(), 0).toString();
        p.setIdPropiedad(Integer.parseInt(id));
    }
}
