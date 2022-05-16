//APLICACION - para manejo de cuentas bancarias - TIENE MAIN
package programasitse;
import java.util.Scanner;

public class SistemaCuentas {

    //metodo constructor - llamado a proceso
    public SistemaCuentas() {
       proceso(); 
    }
    
    //aqui se desarrolla todo el control del programa
    private void proceso( ){
        char opc;         
        //estoy creando el objeto de la cuenta 123356 - juan perez
        Cuenta cliente = new Cuenta("123356","Juan Perez ");
        
        do{
          opc = menu();            
          switch(opc){
            case '1':   deposito(cliente);
                        break;
            case '2':   this.retiro(cliente);
		        break;
            case '3':   System.out.print("Su saldo a la fecha es: " + 
                                     cliente.saldo + " pesos ");	
		        break;	
  	    case '4':   System.out.println(" Fin de las transacciones \n");
          }
        }while(opc != '4');         
    }
    
    private void retiro(Cuenta cl){
      double retiro;
      Ventas v = new Ventas();  
      
      System.out.print("\nCuanto dinero desea retirar [100-9000]: "); 
      retiro = v.leeNumeroD(100, 9000);			
      if(retiro > cl.saldo){
  	   System.out.print("No cuenta con esa cantidad..\n");
      }else{
	   cl.saldo = cl.saldo - retiro;
	   System.out.print("Retirado.....\n");
	   if(cl.saldo == 0){
		 System.out.print("La cuenta esta en ceros...\n");
  	   } 
       }
    }
    
    private void deposito(Cuenta cl){
        double deposito;
        Ventas v = new Ventas();
        
        System.out.print("\nCuanto dinero desea ingresar en cuenta" +
                         "[100-10000]: "); 
        //regla de negocio los depositos seran entre 100 y 10000
	deposito = v.leeNumeroD(100, 10000);
	cl.saldo = cl.saldo + deposito;
	System.out.print("Depositado.....\n"); 
    }
    
    private char menu(    ){
        char opc = 0;       //variable local de trabajo
        String cad;         //OJO  el String ya no es vector, es objeto
        Scanner sc = new Scanner(System.in);
                                 //paso de MENSAJE al constructor
        do{
            System.out.print("\n\n\t Banco del Ahorro \n");
            System.out.print("1. Ingresar dinero en cuenta \n");
            System.out.print("2. Retirar dinero de la cuenta \n");
            System.out.print("3. Consultar el saldo \n");
            System.out.print("4. Salir \n");
            System.out.print("Opcion: "); 
            cad = sc.next().trim();     //leer como cadena y quitar espacios
     //sc.next() -> es String  por tanto uso .trim() es un metodo de String
            opc = cad.charAt(0);        //sacar el caracter en posicion
            if(opc < '1'  ||  opc > '4'){
                System.out.println(" ERROR: la opcion es [1  2  3  4] ");
            }            
        }while(opc < '1'  ||  opc > '4');    
        return opc;
    }

    public static void main(String[] args) {
        SistemaCuentas  sistema      = new        SistemaCuentas( );  
     //   clase    variable-objeto  instancia    llamado constructor 
    } 
}