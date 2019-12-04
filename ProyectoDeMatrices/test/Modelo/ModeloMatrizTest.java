/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.junit.Test;

/**
 *
 * @author NicoGJ
 */
public class ModeloMatrizTest {

    /**
     * Test del metodo validarOperacionDosMatrices de la clase ModeloMatriz
     */
    @Test
    public void testValidarOperacionDosMatrices() {
        System.out.println("validarOperacionDosMatrices");
        int filaMatrizA = 3;
        int columnaMatrizA = 3;
        int filaMatrizB = 4;
        int columnaMatrizB = 3;
        String operacion = "suma";
        ModeloMatriz instance = new ModeloMatriz();
        instance.validarOperacionDosMatrices(filaMatrizA, columnaMatrizA, filaMatrizB, columnaMatrizB, operacion);
    }

    /**
     * Test del metodo validarOperacion de la clase ModeloMatriz
     */
    @Test
    public void testValidarOperacion() {
        System.out.println("validarOperacion");
        int filas = 8;
        int columnas = 8;
        String operacion = "Determinante";
        ModeloMatriz instance = new ModeloMatriz();
        instance.validarOperacion(filas, columnas, operacion);
    }

    /**
     * Test del metodo generarMatrizA de la clase ModeloMatriz
     */
    @Test
    public void testGenerarMatrizA() {
        System.out.println("generarMatrizA");
        int fila = 5;
        int columna = 0;
        ModeloMatriz instance = new ModeloMatriz();
        instance.generarMatrizA(fila, columna);
    }

    /**
     * Test del metodo generarMatrizB de la clase ModeloMatriz
     */
    @Test
    public void testGenerarMatrizB() {
        System.out.println("generarMatrizB");
        int fila = 2;
        int columna = 3;
        ModeloMatriz instance = new ModeloMatriz();
        instance.generarMatrizB(fila, columna);
    }

}
