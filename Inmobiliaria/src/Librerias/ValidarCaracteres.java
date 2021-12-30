package Librerias;

import javax.swing.JOptionPane;

/**
 *
 * @author Camila Carrero
 */
public class ValidarCaracteres {

    public void validarSoloLetras(java.awt.event.KeyEvent evt) { //Valida que se ingresen solo letras.
        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 64
                || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 96
                || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 179
                || evt.getKeyChar() >= 181 && evt.getKeyChar() <= 208
                || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 8482) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se permite ese caracter");
        }
    }

    public void validarSoloNumeros(java.awt.event.KeyEvent e) { //Valida que se ingresen solo números.
        if (e.getKeyChar() >= 32 && e.getKeyChar() <= 47
                || e.getKeyChar() >= 58 && e.getKeyChar() <= 8482) {
            e.consume();
            JOptionPane.showMessageDialog(null, "No se permite ese caracter");
        }
    }

    public void validarAlfanumerico(java.awt.event.KeyEvent e) { //Valida que se ingresen solo letras y números.
        if (e.getKeyChar() >= 33 && e.getKeyChar() <= 47
                || e.getKeyChar() >= 58 && e.getKeyChar() <= 64
                || e.getKeyChar() >= 91 && e.getKeyChar() <= 96
                || e.getKeyChar() >= 123 && e.getKeyChar() <= 192
                || e.getKeyChar() >= 194 && e.getKeyChar() <= 200
                || e.getKeyChar() >= 202 && e.getKeyChar() <= 204
                || e.getKeyChar() >= 206 && e.getKeyChar() <= 210
                || e.getKeyChar() >= 212 && e.getKeyChar() <= 217
                || e.getKeyChar() >= 219 && e.getKeyChar() <= 224
                || e.getKeyChar() >= 226 && e.getKeyChar() <= 232
                || e.getKeyChar() >= 234 && e.getKeyChar() <= 236
                || e.getKeyChar() >= 238 && e.getKeyChar() <= 240
                || e.getKeyChar() == 242
                || e.getKeyChar() >= 244 && e.getKeyChar() <= 249              
                || e.getKeyChar() >= 251 && e.getKeyChar() <= 8482) {
            e.consume();
            JOptionPane.showMessageDialog(null, "No se permite ese caracter");
        }
    }

    public void validarDni(java.awt.event.KeyEvent evt) { //Valida que se ingresen solo caracteres pertenecientes al dni.
        if (evt.getKeyChar() >= 32 && evt.getKeyChar() <= 44
                || evt.getKeyChar() >= 46 && evt.getKeyChar() <= 47
                || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 8482) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se permite ese caracter");
        }
    }

    public void validarTel(java.awt.event.KeyEvent evt) { //Valida que se ingresen solo caracteres pertenecientes al teléfono.
        if (evt.getKeyChar() >= 32 && evt.getKeyChar() <= 47
                || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 8482) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se permite ese caracter");
        }
    }

    public void validarCorreo(java.awt.event.KeyEvent evt) { //Valida que se ingresen solo caracteres pertenecientes al correo.
        int arroba = 0;
        if (evt.getKeyChar() >= 32 && evt.getKeyChar() <= 44
                || evt.getKeyChar() == 47
                || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 63
                || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 94
                || evt.getKeyChar() == 96
                || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 208
                || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 8482) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se permite ese caracter");
        }
        if(evt.getKeyChar() == 40){
            arroba ++;
            if(arroba > 1){
                evt.consume();
            }
        }
    }

    public void validarNumeroPC(java.awt.event.KeyEvent e) { //Valida que se ingresen solo números, puntos y una coma.
        int coma = 0;
        if (e.getKeyChar() >= 32 && e.getKeyChar() <= 43
                || e.getKeyChar() == 45 || e.getKeyChar() == 47
                || e.getKeyChar() >= 58 && e.getKeyChar() <= 8482) {

            e.consume();
            JOptionPane.showMessageDialog(null, "No se permite ese caracter");
        }
        if (e.getKeyChar() == 44) {
            coma++;
            if (coma > 1) {
                e.consume();
            }
        }
    }

    public void validarNumeroC(java.awt.event.KeyEvent e) { //Valida que se ingrese solo números y una coma.
        if (e.getKeyChar() >= 32 && e.getKeyChar() <= 43
                || e.getKeyChar() >= 45 && e.getKeyChar() <= 47
                || e.getKeyChar() >= 58 && e.getKeyChar() <= 8482) {
            e.consume();
            JOptionPane.showMessageDialog(null, "No se permite ese caracter");
        }
    }
}
