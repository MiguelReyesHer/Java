package gui2022;

public class Cuenta {
    
    //Declaración variables
    private String nombreCliente;   
    private String numeroCuenta;
    public double saldo;

    //Constructor
    public Cuenta(String nombreCliente, String numeroCuenta) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
    }

    //to string
    @Override
    public String toString() {
        return "Cuenta " + numeroCuenta + " " + nombreCliente + " saldo= " + saldo + '\n';
    } 

    
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }


}
