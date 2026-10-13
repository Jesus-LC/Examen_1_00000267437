/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Cliente;
import modelo.Recibo;
import modelo.ServicioLuz;
import vista.frmPagoLuz;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

public class controladorPago {
    private frmPagoLuz view;
    private List<ServicioLuz> listaActual;
    private ServicioLuz servicioSeleccionado;

    public controladorPago(frmPagoLuz view) {
        this.view = view;
        initController();
    }

    private void initController() {
        
        view.panelEntrada.getTxtNumeroS().getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { realizarBusqueda(); }
            @Override public void removeUpdate(DocumentEvent e) { realizarBusqueda(); }
            @Override public void changedUpdate(DocumentEvent e) { realizarBusqueda(); }
        });

        
        view.panelEntrada.getListaClientes().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = view.panelEntrada.getListaClientes().getSelectedIndex();
                if (index >= 0 && listaActual != null && index < listaActual.size()) {
                    servicioSeleccionado = listaActual.get(index);
                    view.panelEntrada.mostrarDatosServicio(servicioSeleccionado);
                }
            }
        });

        
        view.panelEntrada.getBtnCPagar().addActionListener(e -> {
            if (view.panelEntrada.getBtnCPagar().getText().contains("Imprimir")) {
                System.exit(0);
            } else {
                view.cardLayout.show(view.getContentPane(), "PANEL_PAGO");
            }
        });

        
        view.panelPago.getBtnPagar().addActionListener(e -> procesarPago());
    }

    private void realizarBusqueda() {
        
        String texto = view.panelEntrada.getTxtNumeroS().getText().trim();
        
        
        view.panelEntrada.modeloLista.clear();
        
        if (texto.isEmpty()) {
            return;
        }

        
        listaActual = ServicioLuz.buscarPorCriterio(texto);
        
        
        for (ServicioLuz s : listaActual) {
            view.panelEntrada.modeloLista.addElement(s.getNumeroServicio() + " - " + s.getNombreCliente());
        }
    }

    private void procesarPago() {
        String tarjeta = view.panelPago.getTxtNTarjeta().getText().trim();
        if (tarjeta.length() < 15) {
            view.panelPago.getLblMensajeError().setText("¡Ingrese un número de tarjeta válido!");
            return;
        }

        view.panelPago.getLblMensajeError().setText("");

        Cliente clienteTemp = new Cliente("CLI-01", servicioSeleccionado.getNombreCliente(), servicioSeleccionado.getDireccion());

        Recibo recibo = new Recibo(
            "CFE-" + System.currentTimeMillis(), 
            new Date(), 
            servicioSeleccionado.getMontoPagar(), 
            clienteTemp
        );

        view.panelEntrada.activarModoRecibo(recibo);
        view.cardLayout.show(view.getContentPane(), "PANEL_PRINCIPAL");
    }
}
