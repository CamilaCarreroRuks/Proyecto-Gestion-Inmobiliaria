package Gestor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;
import Vista.ImprimirReporte;

/**
 *
 * @author Camila Carrero
 */
public class ImprimirReporteG implements ActionListener {

    ImprimirReporte ir = new ImprimirReporte(null, true);

    public ImprimirReporteG() {
        iniciar(ir);
    }

    public void iniciar(ImprimirReporte ir) { //Inicia las variables y agrega los listener.
        this.ir = ir;
        this.ir.bImprimir.addActionListener(this);
    }

    public void abrirImprimirReporte() { //Abre el formulario ImprimirReporte.
        ir.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ir.bImprimir) {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(ir.reporte);
            if (job.printDialog()) {
                try {
                    job.print();
                } catch (PrinterException ex) {
                }
            } else {
                JOptionPane.showMessageDialog(null, "La impresion se cancelo");
            }
        }
    }
}
