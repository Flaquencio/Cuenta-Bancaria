package org.israel.cuentas;

/*
 *programador: Israel Pabón
 * fecha: 5/05/2025
 * descripcon: clase cuenta de ahorros del tipo hija
 */

public class CuentaCorriente extends CuentaBancaria{

    /*parametro de sobregiro debe empezar en 0*/
    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float interesAnual) {
        super(saldo, interesAnual);
    }

    /*retirar dinero y actualizar saldo*/
    @Override
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else{
           float diferencia = cantidad - saldo;
           saldo = 0;
           sobregiro += diferencia;

        }
        numeroRetiro++;
    }

    /*depositar */
    @Override
    public void depositar(float cantidad) {
        if (sobregiro>0){
            //definimos en el caso que se tenga y no tenga sobregiro
            if (cantidad >= sobregiro){
                cantidad -= sobregiro;
                sobregiro = 0;
                saldo += cantidad;
            }else{
                sobregiro -= cantidad;
            }
        }else{
            saldo += cantidad;
        }
        numeroDepositos++;
    }

    /*Mostrar el extracto mensual*/
    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    /*Imprimir los los datos*/
    public void imprimirDatos() {
        super.imprimirDatos();
    }

}
