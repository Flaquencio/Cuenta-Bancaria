package org.israel.cuentas;

/*
 *programador: Israel Pabón
 * fecha: 5/05/2025
 * descripcon: main para llamar los datos de las clases hijas y padre
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese el saldo inicial: ");
        float saldoInicial = Float.parseFloat(br.readLine());

        System.out.print("Ingrese la tasa de interés anual: ");
        float interesAnual = Float.parseFloat(br.readLine());

        CuentaAhorros cuentaAhorros = new CuentaAhorros(saldoInicial, interesAnual);
        CuentaCorriente cuentaCorriente = new CuentaCorriente(saldoInicial, interesAnual);

        boolean continuar = true;

        //creacion de ingreso interactivo
        while (continuar) {
            System.out.println("A donde quiere ir?");
            System.out.println("1. Cuenta de Ahorros");
            System.out.println("2. Cuenta Corriente");
            System.out.println("3. Salir");
            System.out.print("Indique su seleccion");
            int tipoCuenta = Integer.parseInt(br.readLine());

            if (tipoCuenta == 3) {
                System.out.println("Gracias por preferirnos");
                break;
            }

            CuentaBancaria cuentaSeleccionada;
            String nombreCuenta;

            if (tipoCuenta == 1) {
                cuentaSeleccionada = cuentaAhorros;
                nombreCuenta = "Cuenta de Ahorros";
            } else if (tipoCuenta == 2) {
                cuentaSeleccionada = cuentaCorriente;
                nombreCuenta = "Cuenta Corriente";
            } else {
                System.out.println("Opcion no disponible");
                continue;
            }

            System.out.println("En que te puede ayudar");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Ver datos de la cuenta");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int accion = Integer.parseInt(br.readLine());

            switch (accion) {
                case 1:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    float deposito = Float.parseFloat(br.readLine());
                    cuentaSeleccionada.depositar(deposito);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    float retiro = Float.parseFloat(br.readLine());
                    cuentaSeleccionada.retirar(retiro);
                    break;
                case 3:
                    System.out.println("Datos de " + nombreCuenta + ":");
                    cuentaSeleccionada.imprimirDatos();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Gracias por preferirnos");
                    break;
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }

            if (accion != 4) {
                System.out.print("¿Desea realizar otra acción? (s/n): ");
                String respuesta = br.readLine();
                if (!respuesta.equalsIgnoreCase("s")) {
                    continuar = false;
                    System.out.println("Gracias por preferirnos");
                }
            }
        }
    }
}

//whilw y swich