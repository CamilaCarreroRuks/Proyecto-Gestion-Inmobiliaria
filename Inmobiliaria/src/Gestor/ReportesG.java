package Gestor;

import static Librerias.Pdf.crearPDF;
import Modelo.ClienteConsulta;
import Modelo.ComprobanteConsulta;
import Modelo.TasacionConsulta;
import Modelo.UsuarioConsulta;
import Vista.FormReportes;
import com.itextpdf.text.DocumentException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author Camila Carrero
 */
public class ReportesG implements ActionListener, ItemListener {

    FormReportes formR = new FormReportes(null, true);

    public ReportesG() {
        iniciar(formR);
    }

    public void iniciar(FormReportes formR) { //Inicia las variables y agrega los listener.
        this.formR = formR;
        this.formR.bGenerar.addActionListener(this);
        this.formR.filtro.addActionListener(this);
        this.formR.tipo.addItemListener(this);
    }

    public void abrirFormReportes() { //Abre el formulario FormReportes.
        formR.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formR.bGenerar) {
            String nombre = formR.tNombre.getText();
            TableModel tablaModel = null;
            String titulo = null;
            String nombreTabla = null;
            Boolean cantidad = formR.cantidad.isSelected();;
            int orientacion = 0;
            if (formR.orientacion.getSelectedItem() == "Vertical") {
                orientacion = 0;
            } else if (formR.orientacion.getSelectedItem() == "Horizontal") {
                orientacion = 1;
            }
            if (formR.tipo.getSelectedItem() == "Usuarios") {
                UsuarioConsulta u = new UsuarioConsulta();
                titulo = "Listado de Usuarios:";
                nombreTabla = "usuario";
                tablaModel = u.imprimir();
            }
            if (formR.tipo.getSelectedItem() == "Tasaciones") {
                TasacionConsulta t = new TasacionConsulta();
                titulo = "Listado de Tasaciones:";
                nombreTabla = "tasaciones";
                tablaModel = t.imprimir();
            }
            if (formR.tipo.getSelectedItem() == "Clientes") {
                ClienteConsulta c = new ClienteConsulta();
                titulo = "Listado de Clientes:";
                nombreTabla = "clientes";
                tablaModel = c.imprimir();
            }
            if (formR.tipo.getSelectedItem() == "Comprobantes") {
                ComprobanteConsulta com = new ComprobanteConsulta();
                titulo = "Listado de Comprobantes:";
                nombreTabla = "comprobantes";
                tablaModel = com.imprimir();
            }
            try {
                crearPDF(orientacion, tablaModel, nombre, titulo, nombreTabla, cantidad);
            } catch (DocumentException ex) {
                Logger.getLogger(ReportesG.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReportesG.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == formR.tipo) {
            if (e.getItem().toString() == "Usuarios" || formR.tipo.getSelectedItem() == "Usuarios") {
                UsuarioG ug = new UsuarioG();
                formR.filtro.removeAllItems();
                formR.filtro.addItem("Todos");
                formR.filtro.addItem("Nombre de Usuario");
                formR.filtro.addItem("Tipo de Usuario");
            } else if (formR.tipo.getSelectedItem() == "Clientes") {
                formR.filtro.removeAllItems();
                formR.filtro.addItem("Todos");
                formR.filtro.addItem("Nombre");
                formR.filtro.addItem("Dni");
                formR.filtro.addItem("Tipo de Cliente");
                formR.filtro.addItem("Localidad");
                formR.filtro.addItem("Dirección");
                formR.ordenar.removeAllItems();
                formR.ordenar.addItem("");
                formR.ordenar.addItem("Localidad");
                formR.ordenar.addItem("Tipo de Cliente");
            } else if (formR.tipo.getSelectedItem() == "Propiedades") {
                formR.filtro.removeAllItems();
                formR.filtro.addItem("propiedades");
            } else if (formR.tipo.getSelectedItem() == "Tasaciones") {
                formR.filtro.removeAllItems();
                formR.filtro.addItem("Todos");
                formR.filtro.addItem("Fecha");
                formR.filtro.addItem("Cliente");
                formR.filtro.addItem("Localidad");
                formR.filtro.addItem("Tipo de Propiedad");
                formR.ordenar.removeAllItems();
                formR.ordenar.addItem("");
                formR.ordenar.addItem("Fecha");
                formR.ordenar.addItem("Cliente");
                formR.ordenar.addItem("Localidad");
                formR.ordenar.addItem("Tipo de Propiedad");
            } else if (formR.tipo.getSelectedItem() == "Comprobantes") {
                formR.filtro.removeAllItems();
                formR.filtro.addItem("Todos");
                formR.filtro.addItem("Fecha");
                formR.filtro.addItem("Tipo de Comprobante");
                formR.ordenar.removeAllItems();
                formR.ordenar.addItem("");
                formR.ordenar.addItem("Fecha");
                 formR.ordenar.addItem("Tipo de Comprobante");
            }
        }
    }
}
