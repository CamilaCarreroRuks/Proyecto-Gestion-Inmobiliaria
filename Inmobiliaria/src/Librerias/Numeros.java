package Librerias;

/**
 *
 * @author Camila Carrero
 */
public class Numeros {

    public static String unidadEnTexto(int iNumero) {
        switch (iNumero) {
            case 1:
                return "uno";
            case 2:
                return "dos";
            case 3:
                return "tres";
            case 4:
                return "cuatro";
            case 5:
                return "cinco";
            case 6:
                return "seis";
            case 7:
                return "siete";
            case 8:
                return "ocho";
            case 9:
                return "nueve";
            case 0:
                return "cero";
            default:
                return "";
        }
    }

    public static String decenaEnTexto(int iDecena) {
        switch (iDecena) {
            case 1:
                return "diez";
            case 2:
                return "veinte";
            case 3:
                return "treinta";
            case 4:
                return "cuarenta";
            case 5:
                return "cincuenta";
            case 6:
                return "sesenta";
            case 7:
                return "setenta";
            case 8:
                return "ochenta";
            case 9:
                return "noventa";
            default:
                return "";
        }
    }

    public static String decenas(int iDecena) {
        switch (iDecena) {
            case 11:
                return "once";
            case 12:
                return "doce";
            case 13:
                return "trece";
            case 14:
                return "catorce";
            case 15:
                return "quince";
            case 16:
                return "dieciseis";
            case 17:
                return "diecisiete";
            case 18:
                return "dieciocho";
            case 19:
                return "diecinueve";
            default:
                return "";
        }
    }

    public static String centenaEnTexto(int iCentena) {
        switch (iCentena) {
            case 1:
                return "ciento";
            case 5:
                return "quinientos";
            case 7:
                return "setecientos";
            case 9:
                return "novecientos";
            default:
                return "";
        }
    }

    public static String milesEnTexto(int mil, String nom) {
        switch (mil) {
            case 1:
                return "mil";
            case 2:
                if (nom == "uno") {
                    return "millón";
                } else {
                    return "millones";
                }
            case 3:
                if (nom == "uno") {
                    return "billón";
                } else {
                    return "billones";
                }
            default:
                return "";
        }
    }

    public static String numeroEnLetras(String numero, boolean decimal) {
        String nombre = null;
        if (decimal == true) {
            String num[] = numero.split(",");
            String decimales = num[1];
            String enteros = num[0];
            String punto[] = enteros.split("\\.");
            String nombreEnteros = null;
            int i = 0;
            while (i < punto.length) {
                int nu = Integer.parseInt(punto[i]);
                int uni = nu % 10;
                int dec = (nu / 10) % 10;
                int cen = nu / 100;
                String unidadT = unidadEnTexto(uni);
                String decenaT = null;
                if ((uni == 0) && (dec >= 1)) {
                    decenaT = decenaEnTexto(dec);
                } else if (dec == 1 && uni != 0) {
                    decenaT = decenas(10 + uni);
                } else if (dec > 1) {
                    if (dec == 2) {
                        decenaT = "veinti" + unidadT;
                    } else {
                        decenaT = decenaEnTexto(dec) + " y " + unidadT;
                    }
                }
                String centenaT = null;
                if ((cen != 1) && (cen != 5) && (cen != 7) && (cen != 9) && (cen != 0)) {
                    if (dec != 0) {
                        centenaT = unidadEnTexto(cen) + "cientos" + " " + decenaT;
                    } else {
                        if (uni != 0) {
                            centenaT = unidadEnTexto(cen) + "cientos" + " " + unidadT;
                        }
                    }
                } else if ((cen == 1) || (cen == 5) || (cen == 7) || (cen == 9)) {
                    if (dec != 0) {
                        centenaT = centenaEnTexto(cen) + " " + decenaT;
                    } else {
                        if (uni != 0) {
                            centenaT = centenaEnTexto(cen) + " " + unidadT;
                        } else {
                            centenaT = centenaEnTexto(cen);
                        }
                    }
                }
                String ent;
                if (cen == 0 && dec != 0) {
                    ent = decenaT;
                } else {
                    if (cen == 0 && dec == 0) {
                        ent = unidadT;
                    } else {
                        ent = centenaT;
                    }
                }
                if (nombreEnteros == null) {
                    nombreEnteros = ent;
                } else if (nombreEnteros == "uno") {
                    nombreEnteros = "un " + milesEnTexto(punto.length - i, nombreEnteros) + " " + ent;
                } else if (ent == "cero") {
                    nombreEnteros = nombreEnteros + " " + milesEnTexto(punto.length - i, nombreEnteros);
                } else {
                    nombreEnteros = nombreEnteros + " " + milesEnTexto(punto.length - i, nombreEnteros) + " " + ent;
                }
                i++;
            }
            int deci = Integer.parseInt(decimales);
            int uni = deci % 10;
            int dec = (deci / 10) % 10;
            int cen = deci / 100;
            String unidadT = unidadEnTexto(uni);
            String decenaT = null;
            if ((uni == 0) && (dec >= 1)) {
                decenaT = decenaEnTexto(dec);
            } else if (dec == 1 && uni != 0) {
                decenaT = decenas(10 + uni);
            } else if (dec > 1) {
                if (dec == 2) {
                    decenaT = "veinti" + unidadT;
                } else {
                    decenaT = decenaEnTexto(dec) + " y " + unidadT;
                }
            }
            String centenaT = null;
            if ((cen != 1) && (cen != 5) && (cen != 7) && (cen != 9) && (cen != 0)) {
                centenaT = unidadEnTexto(cen) + "cientos" + " " + decenaT;
            } else if ((cen == 1) || (cen == 5) || (cen == 7) || (cen == 9)) {
                centenaT = centenaEnTexto(cen) + " " + decenaT;
            } else if ((cen != 1) && (cen != 5) && (cen != 7) && (cen != 9) && (cen != 0) && dec == 0) {
                centenaT = unidadEnTexto(cen) + "cientos" + " " + unidadT;
            } else if (((cen == 1) || (cen == 5) || (cen == 7) || (cen == 9)) && dec == 0) {
                centenaT = centenaEnTexto(cen) + " " + unidadT;
            }
            String nombreDecimales;
            if (cen == 0 && dec != 0) {
                nombreDecimales = decenaT;
            } else {
                if (cen == 0 && dec == 0) {
                    nombreDecimales = unidadT;
                } else {
                    nombreDecimales = centenaT;
                }
            }
            if (nombreDecimales != null) {
                nombre = nombreEnteros + " con " + nombreDecimales;
            } else {
                nombre = nombreEnteros;
            }
            return nombre;
        } else {
            String enteros = numero;
            String punto[] = enteros.split("\\.");
            String nombreEnteros = null;
            int i = 0;
            while (i < punto.length) {
                int nu = Integer.parseInt(punto[i]);
                int uni = nu % 10;
                int dec = (nu / 10) % 10;
                int cen = nu / 100;
                String unidadT = unidadEnTexto(uni);
                String decenaT = null;
                if ((uni == 0) && (dec >= 1)) {
                    decenaT = decenaEnTexto(dec);
                } else if (dec == 1 && uni != 0) {
                    decenaT = decenas(10 + uni);
                } else if (dec > 1) {
                    if (dec == 2) {
                        decenaT = "veinti" + unidadT;
                    } else {
                        decenaT = decenaEnTexto(dec) + " y " + unidadT;
                    }
                }
                String centenaT = null;
                if ((cen != 1) && (cen != 5) && (cen != 7) && (cen != 9) && (cen != 0)) {
                    if (dec != 0) {
                        centenaT = unidadEnTexto(cen) + "cientos" + " " + decenaT;
                    } else {
                        if (uni != 0) {
                            centenaT = unidadEnTexto(cen) + "cientos" + " " + unidadT;
                        }
                    }
                } else if ((cen == 1) || (cen == 5) || (cen == 7) || (cen == 9)) {
                    if (dec != 0) {
                        centenaT = centenaEnTexto(cen) + " " + decenaT;
                    } else {
                        if (uni != 0) {
                            centenaT = centenaEnTexto(cen) + " " + unidadT;
                        } else {
                            centenaT = centenaEnTexto(cen);
                        }
                    }
                }
                String ent;
                if (cen == 0 && dec != 0) {
                    ent = decenaT;
                } else {
                    if (cen == 0 && dec == 0) {
                        ent = unidadT;
                    } else {
                        ent = centenaT;
                    }
                }
                if (nombreEnteros == null) {
                    nombreEnteros = ent;
                } else if (nombreEnteros == "uno") {
                    nombreEnteros = "un " + milesEnTexto(punto.length - i, nombreEnteros) + " " + ent;
                } else if (ent == "cero") {
                    nombreEnteros = nombreEnteros + " " + milesEnTexto(punto.length - i, nombreEnteros);
                } else {
                    nombreEnteros = nombreEnteros + " " + milesEnTexto(punto.length - i, nombreEnteros) + " " + ent;
                }
                i++;
                nombre = nombreEnteros;
            }
        }
        return nombre;
    }

    public static boolean tieneDecimales(String numero) {
        if (numero.contains(",")) {
            return true;
        } else {
            return false;
        }
    }

    public static String conMayuscula(String num) {
        num = num.substring(0, 1).toUpperCase() + num.substring(1);
        return num;
    }
}