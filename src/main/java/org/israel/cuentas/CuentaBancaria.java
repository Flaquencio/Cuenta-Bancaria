package org.israel.cuentas;
/*
*programador: Israel Pabón
* fecha: 1/05/2025
* descripcon: Esta es la clase padre donde vamos a modelar un conjunto de tipo cuenta bancaria
 */


public class CuentaBancaria {
    /*Declarar una variable de tipo double de nombre saldo*/
    protected float saldo;

    /*Declaramos e inicializamos una varible de tipo entero con el nombre de numero de depositos*/
    protected int numeroDepositos=0;

    /*Declaramos e inicializamos una variablde de tipo entero con el nombre de numero de retiros*/
    protected int numeroRetiro=0;

    /*Declaramos una variable de tipo flotante de interes anual*/
    protected float interesAnual;

    /*Declaramos e inializamos una variable flotante de comision mensual*/
    protected float interesMensual=0;

    /*Declaramos la comision mensualq ue usara*/
    protected float comisionMensual = 0;

    /*
    Constructor de la clase Cuenta Bancarioa
    @Param saldo, parametro que defiune el saldo de la cuenta
    @Param interesAnual, parametroq ue define el interes anual que nos da el banco
     */
    public CuentaBancaria(float saldo, float interesAnual) {
        this.saldo = saldo;
        this.interesAnual = interesAnual;
    }

    /*Metodo depositar*/
    public void depositar(float cantidad) {
        //aumentar o sumar el saldo
        saldo = saldo + cantidad;
        //incrementar el numero de deposito
        numeroDepositos = numeroDepositos + 1;
    }

    /*Metodo retirar*/
    public void retirar(float cantidad) {
        float nuevoSaldo = saldo-cantidad;
        if (nuevoSaldo>=0) {
            //retiro el dinero en el caso de que tenga plata en la cuenta
            saldo = saldo-cantidad;
            //cuanta las opperaciones de retiros
            numeroRetiro = numeroRetiro+1;
        }else{
           System.out.println("No se puede retirar. El saldo es insuficiente.");
        }
    }

    /*Metodo Calcular Interes Mensual */
    public void calcularInteresMensual() {
        float tasaMensual = interesAnual / 12;
        float interesGenerado = saldo * tasaMensual;
        saldo += interesGenerado;
    }

    /*Metodo Extracto mensual*/
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    /*Metodo imprimir datos*/
    public void imprimirDatos() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Número de depósitos: " + numeroDepositos);
        System.out.println("Número de retiros: " + numeroRetiro);
        System.out.println("Interés anual: " + interesAnual);
        System.out.println("Comisión mensual: " + comisionMensual);
    }
}
