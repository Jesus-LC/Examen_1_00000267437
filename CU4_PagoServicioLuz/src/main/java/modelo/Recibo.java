/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author jesus
 */
public class Recibo {
    private String folio;
    private Date fecha;
    private double importeTotal;
    private Cliente cliente;

    public Recibo(String folio, Date fecha, double importeTotal, Cliente cliente) {
        this.folio = folio;
        this.fecha = fecha;
        this.importeTotal = importeTotal;
        this.cliente = cliente;
    }

    public String getFolio() { return folio; }
    public Date getFecha() { return fecha; }
    public double getImporteTotal() { return importeTotal; }
    public Cliente getCliente() { return cliente; }
}
