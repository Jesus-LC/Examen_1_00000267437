/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author jesus
 */
public class ServicioLuz {
    private String numeroServicio;
    private String nombreCliente;
    private String direccion;
    private String periodo;
    private double consumoKw;
    private double montoPagar;

    // Constructor
    public ServicioLuz(String numeroServicio, String nombreCliente, String direccion, String periodo, double consumoKw, double montoPagar) {
        this.numeroServicio = numeroServicio;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.periodo = periodo;
        this.consumoKw = consumoKw;
        this.montoPagar = montoPagar;
    }

    public String getNumeroServicio() { return numeroServicio; }
    public String getNombreCliente() { return nombreCliente; }
    public String getDireccion() { return direccion; }
    public String getPeriodo() { return periodo; }
    public double getConsumoKw() { return consumoKw; }
    public double getMontoPagar() { return montoPagar; }

    // Simulación de una base de datos de servicios de luz
    public static List<ServicioLuz> obtenerBaseDatosMock() {
        List<ServicioLuz> lista = new ArrayList<>();
        lista.add(new ServicioLuz("1234567890", "Jesus Ramon Lopez Cantu", "Mi casa #123", "oct-dic 2026", 126.0, 1200.0));
        lista.add(new ServicioLuz("1234567891", "Maria Fernanda Perez", "Av. Central #45", "oct-dic 2026", 95.0, 850.0));
        lista.add(new ServicioLuz("1234567892", "Carlos Gomez Luna", "Calle Sur #89", "oct-dic 2026", 210.0, 2150.0));
        return lista;
    }

    // Método para buscar coincidencias al teclear
    public static List<ServicioLuz> buscarPorCriterio(String criterio) {
        List<ServicioLuz> resultados = new ArrayList<>();
        for (ServicioLuz s : obtenerBaseDatosMock()) {
            if (s.getNumeroServicio().startsWith(criterio)) {
                resultados.add(s);
            }
        }
        return resultados;
    }
}