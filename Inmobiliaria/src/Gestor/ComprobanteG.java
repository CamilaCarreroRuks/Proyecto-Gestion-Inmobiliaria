package Gestor;

import Librerias.Numeros;
import Librerias.PintarFilasComprobante;
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
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import Modelo.Comprobante;
import Modelo.ComprobanteConsulta;
import Modelo.Talonario;
import Modelo.TalonarioConsulta;
import Modelo.TipoComprobanteConsulta;
import Vista.FormComprobante;
import Vista.ImprimirComprobante;
import Vista.PanelComprobante;
import static Vista.PantallaPrincipal.escritorio;
import com.toedter.calendar.JTextFieldDateEditor;

/**
 *
 * @author Camila Carrero
 */
public class ComprobanteG implements ActionListener, MouseListener, KeyListener, WindowListener {

    Comprobante c = new Comprobante();
    ComprobanteConsulta cc = new ComprobanteConsulta();
    PanelComprobante pc = new PanelComprobante();
    ImprimirComprobante ic = new ImprimirComprobante(null, true);
    FormComprobante formC = new FormComprobante(null, true);

    public ComprobanteG() {
        iniciar(c, cc, pc, ic, formC);
    }

    public void iniciar(Comprobante c, ComprobanteConsulta cc, PanelComprobante pc, ImprimirComprobante ic, FormComprobante formC) { //Inicia las variables y agrega los listener.
        this.c = c;
        this.cc = cc;
        this.pc = pc;
        this.ic = ic;
        this.formC = formC;
        this.formC.addWindowListener(this);
        this.formC.bGenerar.addActionListener(this);
        this.formC.tMontoComprobante.addKeyListener(this);
        this.pc.table.addMouseListener(this);
        this.pc.bBuscar.addActionListener(this);
        this.pc.bAnular.addActionListener(this);
        this.pc.bImprimir.addActionListener(this);
        this.pc.table.addMouseListener(this);
        this.ic.bImprimir.addActionListener(this);
    }

    public void abrirFormComprobante() { //Abre el formulario FormComprobante.
        formC.tipoComprobante.removeAllItems();
        ArrayList tc = TipoComprobanteConsulta.listaTipoComprobante();
        for (int i = 0; i < tc.size(); i++) {
            formC.tipoComprobante.addItem(tc.get(i).toString());
        }
        JTextFieldDateEditor editor = (JTextFieldDateEditor) formC.fecha.getDateEditor();
        editor.setEditable(false);
        formC.setVisible(true);
        formC.revalidate();
        formC.repaint();
    }

    public void abrirPanel() { //Abre el PanelComprobante.
        anularBoton(true);
        pc.setVisible(true);
        pc.setSize(500, 500);
        pc.setLocation(0, 0);
        escritorio.removeAll();
        escritorio.add(pc);
        escritorio.revalidate();
        escritorio.repaint();
    }

    public void abrirImprimirComprobante(String tc, int id) { //Abre el formulario ImprimirComprobante.
        DefaultTableModel modelo = new DefaultTableModel();
        Formatter fmt = new Formatter();
        JTable tabla = new JTable(cc.obtenerDatos(id));
        modelo = (DefaultTableModel) tabla.getModel();
        String fecha = modelo.getValueAt(0, 4).toString();
        String f[] = fecha.split("/");
        String año = f[2];
        String dia = f[0];
        String mes = f[1];
        String MES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String mes1 = MES[Integer.parseInt(mes)-1];
        DecimalFormat df = new DecimalFormat("###,###.##");
        if (tc == "Recibo" || tc.equals("Recibo")) {
            ic.recibo.tFecha.setText("Paraná, " + dia + " de " + mes1 + " de " + año);
            ic.recibo.tNumero.setText(fmt.format("%06d", Integer.parseInt(modelo.getValueAt(0, 0).toString())).toString());
            ic.recibo.tNombre.setText(modelo.getValueAt(0, 1).toString());
            ic.recibo.tConcepto.setText(modelo.getValueAt(0, 3).toString());
            Double monto = Double.parseDouble(modelo.getValueAt(0, 2).toString());
            ic.recibo.tDineroN.setText(df.format(monto));
            boolean d = Numeros.tieneDecimales(df.format(monto));
            ic.recibo.tDinero.setText("pesos " + Numeros.numeroEnLetras(df.format(monto), d));
            ic.pLiquidacion.setVisible(false);
            ic.liquidacion.setVisible(false);
            ic.pRecibo.setVisible(true);
            ic.recibo.setVisible(true);
        } else if (tc == "Liquidación" || tc.equals("Liquidación")) {
            ic.liquidacion.tFecha.setText("Paraná, " + dia + " de " + mes1 + " de " + año);
            ic.liquidacion.tNumero.setText(fmt.format("%06d", Integer.parseInt(modelo.getValueAt(0, 0).toString())).toString());
            ic.liquidacion.tNombre.setText(modelo.getValueAt(0, 1).toString());
            ic.liquidacion.tConcepto.setText(modelo.getValueAt(0, 3).toString());
            Double monto = Double.parseDouble(modelo.getValueAt(0, 2).toString());
            ic.liquidacion.tDineroN.setText(df.format(monto));
            boolean d = Numeros.tieneDecimales(df.format(monto));
            ic.liquidacion.tDinero.setText("pesos " + Numeros.numeroEnLetras(df.format(monto), d));
            ic.pRecibo.setVisible(false);
            ic.recibo.setVisible(false);
            ic.pLiquidacion.setVisible(true);
            ic.liquidacion.setVisible(true);
        }
        ic.setVisible(true);
    }

    public void anularBoton(boolean a) { //Edita los botones para estar o no disponibles.
        if (a) {
            pc.bAnular.setEnabled(false);
            pc.bImprimir.setEnabled(false);
        } else {
            pc.bAnular.setEnabled(true);
            pc.bImprimir.setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formC.bGenerar) {
            if (validarCampos()) {
                ComprobanteG cg = new ComprobanteG();
                Comprobante c = new Comprobante();
                ComprobanteConsulta cc = new ComprobanteConsulta();
                TipoComprobanteConsulta tcc = new TipoComprobanteConsulta();
                Talonario t = new Talonario();
                TalonarioConsulta talc = new TalonarioConsulta();
                Date fecha = formC.fecha.getDate();
                if (validarFecha(fecha)) {
                    formC.tContabilidad.revalidate();
                    int id = Integer.parseInt(formC.tContabilidad.getText());
                    Double mc = cc.obtenerMontoContabilidad(id);
                    Double monto = Double.valueOf(formC.tMontoComprobante.getText().replace(",", "."));
                    if (validarMonto(id, mc, monto)) {
                        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
                        c.setIdContabilidad(id);
                        c.setFecha(forma.format(fecha));
                        c.setMonto(monto);
                        c.setIdTipoComprobante(tcc.obtenerId(formC.tipoComprobante.getSelectedItem().toString()));
                        t.setIdTipoComprobante(c.getIdTipoComprobante());
                        c.setIdTalonario(talc.obtenerId(t));
                        t.setIdTalonario(c.getIdTalonario());
                        int num = talc.obtenerNComprbanteActual(t) + 1;
                        c.setNumeroComprobante(num);
                        if (cc.registrarComprobanteTalonario(c)) {
                            cc.aumentarNComprobante(c.getIdTalonario());
                        }
                        c.setIdComprobanteTalonario(cc.obtenerIdComprobanteTalonario(c));
                        c.setVigente(1);
                        if (cc.registrar(c)) {
                            JOptionPane.showMessageDialog(null, "Registro exitoso");
                            formC.dispose();
                            pc.bBuscar.doClick();
                            cg.abrirImprimirComprobante(formC.tipoComprobante.getSelectedItem().toString(), cc.obtenerId(c));
                            limpiar();
                        }
                    }
                }
            }
        }

        if (e.getSource() == pc.bBuscar) {
            TableModel modelo = new DefaultTableModel();
            modelo = cc.buscarComprobante();
            pc.table.setModel(modelo);
            pc.table.getColumn("Id").setPreferredWidth(3);
            TableColumn tc = pc.table.getColumnModel().getColumn(4);
            tc.setCellEditor(pc.table.getDefaultEditor(Boolean.class));
            tc.setCellRenderer(pc.table.getDefaultRenderer(Boolean.class));
            pc.table.setDefaultRenderer(Object.class, new PintarFilasComprobante());
        }

        if (e.getSource() == pc.bAnular) {
            c.setIdComprobante(Integer.parseInt(pc.table.getValueAt(pc.table.getSelectedRow(), 0).toString()));
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea anular el comprobante seleccionado?", "Seleccione una opción", 0, 0);
            if (opcion == JOptionPane.YES_OPTION) {
                if (cc.anularComprobante(c)) {
                    JOptionPane.showMessageDialog(null, "Anulación exitosa");
                    pc.bBuscar.doClick();
                }
            }
        }

        if (e.getSource() == pc.bImprimir) {
            if (pc.table.getValueAt(pc.table.getSelectedRow(), 4).toString() == "true") {
                String tc = pc.table.getValueAt(pc.table.getSelectedRow(), 3).toString();
                int id = Integer.parseInt(pc.table.getValueAt(pc.table.getSelectedRow(), 0).toString());
                abrirImprimirComprobante(tc, id);
            } else {
                JOptionPane.showMessageDialog(null, "El comprobante seleccionado se encuentra Anulado.\nNo se puede imprimir.");
            }
        }

        if (e.getSource() == ic.bImprimir) {
            PrinterJob job = PrinterJob.getPrinterJob();
            if (ic.recibo.isVisible()) {
                job.setPrintable(ic.recibo);
            } else if (ic.liquidacion.isVisible()) {
                job.setPrintable(ic.liquidacion);
            }
            if (job.printDialog()) {
                try {
                    job.print();
                } catch (PrinterException ex) {

                }
            } else {
                JOptionPane.showMessageDialog(null, "La impresion se cancelo");
            }
            ic.dispose();
        }
    }

    public boolean validarCampos() { //Valida que los campos obligatorios no esten vacios.
        boolean validacion = true;
        Border border = formC.tId.getBorder();
        if (formC.fecha.getDate() == null) {
            formC.fecha.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.fecha.setBorder(border);
        }
        if (formC.tContabilidad.getText().isEmpty()) {
            formC.tContabilidad.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tContabilidad.setBorder(border);
        }
        if (formC.tMontoComprobante.getText().isEmpty()) {
            formC.tMontoComprobante.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            validacion = false;
        } else {
            formC.tMontoComprobante.setBorder(border);
        }
        if (validacion == false) {
            JOptionPane.showMessageDialog(null, "Debe ingresar los datos marcados");
        }
         if(formC.tMontoComprobante.getText() == "0" || formC.tMontoComprobante.getText().equals("0")){
                JOptionPane.showMessageDialog(null, "Debe ingresar un monto mayor a 0 (cero)");
                validacion = false;
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

    public boolean validarMonto(int id, Double mc, Double m) { //Valida que el monto del Comprobante sea correcto.
        boolean validacion = false;
        Double montoUsado = cc.montoUsado(id);
        if ((mc - montoUsado) > 0) {
            if ((mc - montoUsado) - m > 0 || (mc - montoUsado) - m == 0) {
                validacion = true;
            } else {
                JOptionPane.showMessageDialog(null, "El monto ingresado supera el saldo disponible");
            }
        } else{
            JOptionPane.showMessageDialog(null, "No se puede generar un comprobante sin saldo disponible");
        }
        return validacion;
    }

    public void limpiar() { //Vacia todos los campos y coloca los bordes preestablecidos.
        formC.tConcepto.setText(null);
        formC.tContabilidad.setText(null);
        formC.tId.setText(null);
        formC.tMonto.setText(null);
        formC.tMontoComprobante.setText(null);
        formC.tipoComprobante.setSelectedItem(null);
        Border border = formC.tId.getBorder();
        formC.fecha.setBorder(border);
        formC.tContabilidad.setBorder(border);
        formC.tMontoComprobante.setBorder(border);
    }

    public void pintarFilas() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == formC.tMontoComprobante) {
            ValidarCaracteres vc = new ValidarCaracteres();
            vc.validarNumeroC(e);
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
            anularBoton(false);
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
