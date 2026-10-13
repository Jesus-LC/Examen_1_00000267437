

package com.mycompany.cu4_pagoservicioluz;

import controlador.controladorPago;
import javax.swing.SwingUtilities;
import vista.frmPagoLuz;

/**
 *
 * @author jesus
 */
public class CU4_PagoServicioLuz {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
             frmPagoLuz PagoLuz = new frmPagoLuz();
             
             new controladorPago(PagoLuz);
             PagoLuz.setVisible(true);
        });
    }
}
