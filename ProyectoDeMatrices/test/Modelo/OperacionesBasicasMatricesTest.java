/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class OperacionesBasicasMatricesTest {
    
    public OperacionesBasicasMatricesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suma method, of class OperacionesBasicasMatrices.
     */
    @org.junit.Test
    public void testSuma() {
        System.out.println("suma");
        double[][] matrizA = {
            {1,1},
            {1,1},
        };
        double[][] matrizB = {
            {1,1},
            {1,1},
        };
        OperacionesBasicasMatrices instance = new OperacionesBasicasMatrices();
        double[][] expResult = {
            {2,2},
            {2,2},
        };
        double[][] result = instance.suma(matrizA, matrizB);
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of multiplicacion method, of class OperacionesBasicasMatrices.
     */
    @org.junit.Test
    public void testMultiplicacion() {
        System.out.println("multiplicacion");
        double[][] matrizA = {
            {1,1},
            {2,2},
            {3,3}
        };
        double[][] matrizB = {
            {1,1,1},
            {2,2,2}
        };
        
        OperacionesBasicasMatrices instance = new OperacionesBasicasMatrices();
        double[][] expResult = {
            {3,3,3},
            {6,6,6},
            {9,9,9}
        };
        double[][] result = instance.multiplicacion(matrizA, matrizB);
        assertArrayEquals(expResult, result);
      
        
    }

    /**
     * Test of multiplicacionEscalar method, of class OperacionesBasicasMatrices.
     */
    @org.junit.Test
    public void testMultiplicacionEscalar() {
        System.out.println("multiplicacionEscalar");
        double[][] matriz = {
            {1,1},
            {1,1}
            
        };        
        double escalar = 3.0;
        OperacionesBasicasMatrices instance = new OperacionesBasicasMatrices();
        double[][] expResult = {
            {3,3},
            {3,3}
        };
        double[][] result = instance.multiplicacionEscalar(matriz, escalar);
        assertArrayEquals(expResult, result);
    
    }

    /**
     * Test of calcularDeterminante method, of class OperacionesBasicasMatrices.
     */
    @org.junit.Test
    public void testCalcularDeterminante() {
        System.out.println("calcularDeterminante");
        double[][] matriz = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        
        OperacionesBasicasMatrices instance = new OperacionesBasicasMatrices();
        double expResult = 0.0;
        double result = instance.calcularDeterminante(matriz);
        assertEquals(expResult, result, 0.0);
   
    }

    /**
     * Test of metodoDeCramer method, of class OperacionesBasicasMatrices.
     */
    @org.junit.Test
    public void testMetodoDeCramer() {
        System.out.println("metodoDeCramer");
        double[][] matrizA = {
            {2,4,2},
            {1,4,1}
        };
        OperacionesBasicasMatrices instance = new OperacionesBasicasMatrices();
        double[][] expResult = {
            {1,0}
        };
        double[][] result = instance.metodoDeCramer(matrizA);
        assertArrayEquals(expResult, result);
     
    }


    /**
     * Test of inversaGaussJordan method, of class OperacionesBasicasMatrices.
     */
    @org.junit.Test
    public void testInversaGaussJordan() {
        System.out.println("inversaGaussJordan");

        double [][] matriz = {
        {1,0,0},
        {0,1,0},
        {0,0,1}
        };
        OperacionesBasicasMatrices instance = new OperacionesBasicasMatrices();
        double[][] expResult = {
        {1,0,0},
        {0,1,0},
        {0,0,1}
        };
        double[][] result = instance.inversaGaussJordan(matriz);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of resolverSistemaEcuacion method, of class OperacionesBasicasMatrices.
     */
    @org.junit.Test
    public void testResolverSistemaEcuacion() {
        System.out.println("resolverSistemaEcuacion");
        double[][] matrizA = {
            {1.0,3.0,2.0},
            {1.0,2.0,1.0}
        };
        OperacionesBasicasMatrices instance = new OperacionesBasicasMatrices();
        double[][] expResult = {
            {1.0,0.0,-1.0},
            {-0.0,1.0,1.0}
        };
        double[][] result = instance.resolverSistemaEcuacion(matrizA);
        assertArrayEquals(expResult, result);
       
    }
    
}
