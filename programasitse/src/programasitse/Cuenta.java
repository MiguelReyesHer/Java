//define las caracteristicas de una cuenta bancaria
//atributos y metodos que manejan la cuenta
package programasitse;

public class Cuenta {
    private String   numeroCuenta,  nombreCliente; 
    double   saldo;                        //alcance default
    
    //regla de negocio: No puedes dar de alta una cuenta sin contar
    //con un nombre y su numero de cuenta asignado
    public Cuenta(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;         
    }   

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    //en los setters se programan los filtros que son procesos 
    //de validacion de datos
    //nombre del cliente NO vacio
    public void setNombreCliente(String nombreCliente) {   
        if(  !nombreCliente.isEmpty() ){           //el uso del ! (not) negar
           this.nombreCliente = nombreCliente;
        }
    }
  
    @Override
    public String toString() {
        return "Cuenta: " + numeroCuenta + "  nombreCliente: " + nombreCliente +
                "\t saldo: " + saldo ;
    }   
}