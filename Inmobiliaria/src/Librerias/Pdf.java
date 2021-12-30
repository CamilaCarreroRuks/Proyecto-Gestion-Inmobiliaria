package Librerias;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Camila Carrero
 */
public class Pdf {

    public static void crearPDF(int orientacion, TableModel tablaModel, String nombre, String titulo, String nombreTabla, Boolean cantidad) 
            throws DocumentException, BadElementException, IOException {
        String ruta = "C:\\Users\\Cami\\Documents\\NetBeansProjects\\inmobiliaria\\src\\imagenes\\icon.png";
        Image imagen = Image.getInstance(ruta);
        Document documento = null;
        if (orientacion == 0) {
            documento = new Document(PageSize.A4);
        } else if (orientacion == 1) {
            documento = new Document(PageSize.A4.rotate());
        }
        FileOutputStream ficheroPdf = null;
        File archivo = null;
        PdfWriter writer;
        try {
          //  archivo = new File("C:\\Users\\Cami\\Documents\\Reportes_Pdf\\" + nombre + ".pdf");
                      archivo = new File("C:\\Users\\Cami\\Desktop\\Reportes_Pdf\\" + nombre + ".pdf");
            ficheroPdf = new FileOutputStream(archivo);
            writer = PdfWriter.getInstance(documento, ficheroPdf);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "El nombre del archivo ya ha sido utilizado");
            return;
        }
        writer.open();
        documento.open();
        PdfPTable encabezado = new PdfPTable(2);
        encabezado.setTotalWidth(350);
        int[] valores = new int[]{45, 100};
        encabezado.setWidths(valores);
        encabezado.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cell = new PdfPCell(imagen);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        BaseColor bc = new BaseColor(15, 0, 91);
        Paragraph inmo = new Paragraph("INMOBILIARIA", FontFactory.getFont("arial", 35, Font.ITALIC, bc));
        PdfPCell cell1 = new PdfPCell(inmo);
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        encabezado.addCell(cell);
        encabezado.addCell(cell1);
        documento.add(encabezado);
        Paragraph titulo1 = new Paragraph(titulo, FontFactory.getFont("arial", 22, Font.UNDERLINE));
        titulo1.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo1);
        documento.add(new Paragraph("\n\n"));
        int columnas = tablaModel.getColumnCount();
        PdfPTable tabla = new PdfPTable(columnas);
        tabla.setHeaderRows(1);       
        tabla.setWidthPercentage(100);
        for (int i = 0; i < columnas; i++) {
            String dato = tablaModel.getColumnName(i);
            PdfPCell celda = new PdfPCell(new Paragraph(dato, FontFactory.getFont("arial", 14, Font.BOLD)));
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setBorderWidth(1);
            celda.setBackgroundColor(new BaseColor(225,225, 225));
            tabla.addCell(celda);
        }
        for (int i = 0; i < tablaModel.getRowCount(); i++) {
            for (int p = 0; p < columnas; p++) {
                PdfPCell dato = new PdfPCell(new Paragraph(String.valueOf(tablaModel.getValueAt(i, p)), FontFactory.getFont("arial", 12)));  
                tabla.addCell(dato);
            }
        }
        if (cantidad) {
            for (int i = 0; i < columnas; i++) {
                if (i == (columnas - 1)) {
                    PdfPCell cant = new PdfPCell(new Paragraph("Cant.: " + Integer.toString(tablaModel.getRowCount()), FontFactory.getFont("arial", 14, Font.BOLD)));
                    cant.setColspan(3);
                    cant.setPaddingTop(5);
                    cant.setBackgroundColor(new BaseColor(225,225, 225));
                    tabla.addCell(cant);
                } else {
                    PdfPCell celd = new PdfPCell(new Paragraph(""));
                    celd.setBorderWidth(0);
                    celd.setBorder(Rectangle.NO_BORDER);
                    tabla.addCell(celd);
                }
            }
        }
        documento.add(tabla);
        documento.close();
        abrirArchivo(archivo.getAbsolutePath());
    }

    public static void abrirArchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
