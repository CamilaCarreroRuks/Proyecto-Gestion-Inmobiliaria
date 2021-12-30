package Gestor;

import Modelo.Inconveniente;
import Modelo.InconvenienteConsulta;
import Vista.BuscarInconveniente;
import Vista.PanelInconveniente;
import static Vista.PantallaPrincipal.escritorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;
import java.util.logging.Level;
import Modelo.ClienteConsulta;
import Vista.FormInconveniente;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Camila Carrero
 */
public class InconvenientesG implements ActionListener {
    
    Inconveniente i = new Inconveniente();
    InconvenienteConsulta ic = new InconvenienteConsulta();
    BuscarInconveniente formBI = new BuscarInconveniente(null, true);
    PanelInconveniente pi = new PanelInconveniente();
    FormInconveniente formI = new FormInconveniente(null, true);
    
    public InconvenientesG() {
        iniciar(i, ic, formBI, pi, formI);
    }
    
    public void iniciar(Inconveniente i, InconvenienteConsulta ic, BuscarInconveniente formBI, PanelInconveniente pi, FormInconveniente formI) { //Inicia las variables y agrega los listener.
        this.i = i;
        this.ic = ic;
        this.formBI = formBI;
        this.pi = pi;
        this.formI = formI;
        this.pi.bBuscar.addActionListener(this);
        this.pi.bCargarComunicacion.addActionListener(this);
        this.pi.bAgregarComunicacion.addActionListener(this);
        this.pi.bModificarComunicaion.addActionListener(this);
        this.pi.bModificarEstado.addActionListener(this);
        this.formBI.bBuscar.addActionListener(this);
        this.formBI.bAgregar.addActionListener(this);
        this.formBI.bModificar.addActionListener(this);
        this.formBI.bEliminar.addActionListener(this);
    }
    
    public void abrirPanelInconveniente() { //Abre el PanelInconveniente.
        //  anularBoton("panel");
        pi.setVisible(true);
        pi.setSize(500, 500);
        pi.setLocation(0, 0);
        escritorio.removeAll();
        escritorio.add(pi);
        escritorio.revalidate();
        escritorio.repaint();
    }
    
    public void abrirBuscarInconveniente() { //Abre el formulario BuscarInconveniente.
        formBI.setVisible(true);
    }
    
    public void abrirFormInconveniente(){ //Abre el formulario FormInconveniente.
       formI.setVisible(true); 
    }
    
    public void anularBoton(String nom) { //Edita los botones para estar o no disponibles.
        if (nom == "modificar") {
            formI.bModificar.setEnabled(false);
            formI.bAgregar.setEnabled(true);
        } else if (nom == "agregar") {
            formI.bAgregar.setEnabled(false);
            formI.bModificar.setEnabled(true);
        } else if (nom == "0") {
            formI.bModificar.setEnabled(true);
            formI.bAgregar.setEnabled(true);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pi.bBuscar) {
            abrirBuscarInconveniente();
        }
        
        if (e.getSource() == pi.bCargarComunicacion) {
            i.setIdIncoveniente(Integer.parseInt(pi.tfId.getText()));
            TableModel modelo = new DefaultTableModel();
            modelo = ic.cargarComunicacion(i.getIdIncoveniente());
        }
        
        if (e.getSource() == pi.bAgregarComunicacion) {
            ComunicacionG cg = new ComunicacionG();
            cg.anularBoton("modificar");
            cg.abrirFormComunicacion();
        }
        
        if (e.getSource() == pi.bModificarComunicaion) {
            ComunicacionG cg = new ComunicacionG();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = ((DefaultTableModel) pi.table.getModel());
            ClienteConsulta clic = new ClienteConsulta();
           // try {
                int id = Integer.parseInt(modelo.getValueAt(pi.table.getSelectedRow(), 0).toString());
                cg.formC.tId.setText(Integer.toString(id));
                String nombre = pi.table.getValueAt(pi.table.getSelectedRow(), 1).toString();
                cg.formC.tCliente.setText(clic.obtenerDni(nombre, cg.cc.obtenerIdCliente(id), "Comunicación"));
                try {
                    Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(pi.table.getValueAt(pi.table.getSelectedRow(), 2).toString());
                    cg.formC.fecha.setDate(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(AgendaG.class.getName()).log(Level.SEVERE, null, ex);
                }
                cg.formC.tObservaciones.setText(modelo.getValueAt(pi.table.getSelectedRow(), 3).toString());
                cg.anularBoton("agregar");
                cg.abrirFormComunicacion();
           // } catch (Exception e) {
             //   System.out.println("error al cargar datos modificar \n" + e);
           // }
        }
        
        if (e.getSource() == formBI.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = ic.buscarInconveniente();
            pi.table.setModel(modelo);
            pi.table.getColumn("Id").setPreferredWidth(3);
        }
        
        if (e.getSource() == formBI.bAgregar) {
             anularBoton("modificar");
            abrirFormInconveniente();
        }
        
        if (e.getSource() == formBI.bModificar) {
            anularBoton("agregar");
            abrirFormInconveniente();
        }
        
        if (e.getSource() == formBI.bEliminar) {
            cargarDatos();
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la comunicación seleccionada?", "Seleccione una opción", 0, 0);
            if (opcion == JOptionPane.YES_OPTION) {
                if (ic.eliminar(i)) {
                    JOptionPane.showMessageDialog(null, "Eliminación exitosa");
                    pi.bBuscar.doClick();
                }
            }
        }
    }
    
    public void cargarDatos() { //Carga datos en una instancia del objeto Inconveniente obtenidos de la tabla de PanelInconveniente.
        String id = pi.table.getValueAt(pi.table.getSelectedRow(), 0).toString();
        i.setIdIncoveniente(Integer.parseInt(id));
    }
    
}
