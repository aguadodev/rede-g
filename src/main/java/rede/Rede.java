package rede;

import java.util.Arrays;

/**
 *
 * @author �scar N��ez Aguado <aguado@edu.xunta.es>
 */
public class Rede {

    public static boolean validarIP(String ip) {
        boolean ipOK = true;
        
        if (ip.isEmpty() || ip.startsWith(".") || ip.endsWith(".")){
            ipOK = false;
        } else {
            // Divide la cadena en tramos separados por puntos.
            // Cada tramo representar�a un byte.
            String[] bytes = ip.split("\\.");

            if (bytes.length != 4) {
                // Si no hay 4 bytes
                ipOK = false;
            } else {
                int i = 0;
                while (ipOK && i < 4) {
                    // Valida cada tramo/byte de la direcci�n IP
                    ipOK = validarByte(bytes[i]);
                    i++;
                }
            }           
        }

        return ipOK;
    }

    public static boolean validarByte(String octetoStr) {
        boolean byteOK = true;
        
        if (octetoStr.isEmpty()) {
            byteOK = false;
        } else {
            // Comprueba si los caracteres del octeto son d�gitos sin ceros a la izquierda
            boolean ceroIzq = true;
            for (int i = 0; i < octetoStr.length(); i++) {
                if (!Character.isDigit(octetoStr.charAt(i))) {
                    byteOK = false;
                } else {
                    if (octetoStr.charAt(i) != '0') {
                        ceroIzq = false;
                    } else if (ceroIzq && i < octetoStr.length() - 1) {
                        byteOK = false;
                    }
                }
            }

            if (byteOK) {
                // Comprueba si el n�mero est� entre 0 y 255
                int octetoInt = Integer.valueOf(octetoStr);
                if (octetoInt < 0 || octetoInt > 255) {
                    byteOK = false;
                }
            }

        }

        return byteOK;
    }

    
    public static int buscarIP(String ip, String[] ips) {
        int pos = -1;

        int i = 0;
        while (pos == -1 && i < ips.length) {
            if (ip.equals(ips[i])) {
                pos = i;
            }
            i++;
        }
        return pos;
    }

}
