//Banco del ahorro
package programasitse;
import java.util.Scanner;

public class CuentaAhorro {

    public static void main(String[] args) {
	int     opc;
	double  deposito, saldo = 0, retiro; 
	Scanner sc = new Scanner(System.in);
   
	do{            
	    System.out.print("\n\n\t Banco del Ahorro \n");
	    System.out.print("1. Ingresar dinero en cuenta \n");
	    System.out.print("2. Retirar dinero de la cuenta \n");
	    System.out.print("3. Consultar el saldo \n");
	    System.out.print("4. Salir \n");
	    System.out.print("Opcion: "); 
	    opc = sc.nextInt();
	    switch(opc){
		case 1: 
                    System.out.print("\nCuanto dinero desea ingresar en cuenta: "); 
		    deposito = sc.nextDouble();				
		    saldo = saldo + deposito;
		    System.out.print("Depositado.....\n");  
		    break;
		case 2: 
                    System.out.print("\nCuanto dinero desea retirar: "); 
		    retiro = sc.nextDouble();				
		    if(retiro > saldo){
			System.out.print("No cuenta con esa cantidad..\n");
		    }else{
			saldo = saldo - retiro;
			System.out.print("Retirado.....\n");
			if(saldo == 0){
			    System.out.print("La cuenta esta en ceros...\n");
			} 
		    }
		    break;
		case 3: 
                    System.out.print("Su saldo a la fecha es:" + saldo + " pesos ");	
		        break;	
		default: 
                    System.out.print("Error en la Opcion digite [1 2 3 4 5]: ");
  	    }
        }while(saldo != 4);
     }
 }