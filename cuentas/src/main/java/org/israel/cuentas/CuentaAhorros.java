package org.israel.cuentas;

/*
 *programador: Israel Pabón
 * fecha: 5/05/2025
 * descripcon: clase cuenta de ahorros del tipo hija
 */

public class CuentaAhorros extends CuentaBancaria{

    //Declaamos una variable de tipo Booleana para verificar si la cuenta esta activao no
    private boolean activa;

    /*Implementamos el constructor
    * @param saldo: Define el saldo de la cuenta de ahorros
    * @param tasa: Parametro que define la tasa anueal de interes*/

    public CuentaAhorros(float saldo, float interesAnual) {
        super(saldo, interesAnual);
        /*Verificamos si la cuenta esta activa o no*/
        if (saldo < 50){
            //desactivamos la cuenta
            activa = false;
        }else{
            activa = true;
        }
    }

    /*Implementamos un metodo de retiro
    * @param: saldo que va a manejar el saldo de la cuenta
    * @param: cantidad, estre define la cantidad que va a retirar el cliente*/
    public void retirar(float cantidad){
        //verifico si la cuenta esta activa
        if (activa){
            //retiro la cantidad de dinero
            super.retirar(cantidad);
        }
    }

    /*Implementamos el metodo para depositar
    * @param: Saldo definimos el saldo de la cuenta*/
    public void depositar(float cantidad){
        if (activa){
            super.depositar(cantidad);
        }
    }

    /*Implementamos el metodo de extracto mensual*/
    public void extractoMensual(){
        /*Verificamos el numero de retiros para cobrar la comision mensual*/
        if (numeroRetiro > 4){
            comisionMensual += (numeroRetiro-4)*1;
        }
        //Invocamos el metodo extractoMensual
        super.extractoMensual();
        //verificamos si la cuenta esta actica
        if (saldo <50){
            activa = false;
        }
    }

    /*implementamos un metodo donde se imprima toda la informaicon de la cuenta*/

    @Override
    public void imprimirDatos() {
        super.imprimirDatos();
    }
}
