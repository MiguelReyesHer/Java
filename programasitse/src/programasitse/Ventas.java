//Ventas de una tienda -
//Programacion Orientada a Objetos que usa un vector tipo double
package programasitse;
import java.util.Scanner;

public class Ventas {
    //estoy sobrecargando el metodo constructor
    public Ventas(int p) {         //llamado usado en main de Ventas
        proceso( );
    }
    public Ventas( ){  }           //llamado usado en quien quiera usarlo
    
    private void proceso( ){
        double montoln, totalCaja, vtaMayor;
        double []ventas = new double[200];    //ventas tambien es objeto
	int numVentas, numMayor;
	
        System.out.print("\n\t\t\tPROGRAMA PARA REGISTRAR VENTAS");
	System.out.print("\n\t\tRegistra monto inicial de la caja[0-1000]: ");
	montoln = leeNumeroD(0,1000);
	
	numVentas = vender(ventas);      //hasta 200 ventas  -(por experiencia)
	
      //al llamar los procesos que usan los datos del vector ya no mando 200 
      //si no numVentas que tiene el numero real de localidades usadas(espacios)
      //¿para que se necesitan los datos? - 
      //para hacer reportes que es la información

      //llamado a funcion en una expresion aritmetica
	totalCaja = sumar(ventas,numVentas) + montoln;  
	
        //ejemplo, contar en el vector cuantas ventas mayor igual a $100.00
	numMayor = contarMayor(ventas,numVentas,100);
	
	vtaMayor = buscaMayor(ventas,numVentas);
	
	System.out.print("\n\n\tReporte: \n");
	System.out.println("\t\tMonto total en caja: \t\t"  + totalCaja);
	System.out.println("\t\tNumero de ventas realizadas: \t" + numVentas);
	System.out.println("\t\tVentas de $100 o mas: \t\t" + numMayor);
	System.out.println("\t\tMonto de la venta mayor: \t" + vtaMayor);	
    }
    
    //lee un numero tipo float en un rango
    //leeNumeroD alcance default solo podran usar instancias de objetos
    //de las clases escritas en el mismo paquete
    double leeNumeroD(double vi, double vf){      
        Scanner sc = new Scanner(System.in);
	double numero = vi-1;
        String cad;        
                          
	do{
          try{  
            cad = sc.next();    //leer como String
            //Usando  Wrapper- envoltorio - Clases que apoyan con métodos a los
            //tipos elementales 
            numero =  Double.parseDouble(cad);  //parse es traducir
                                                //parse hace el error
          }catch(NumberFormatException  ex ){
              System.out.print(" Numero entre: " + vi + " - "+ vf + ": ");              
          }            
	} while (numero < vi  ||  numero > vf);
	return numero;
    }
    
//¿Que hace este proceso?
//registra en un vector cada venta realizada en el dia ->  carga de vector
//devuelve el numero de ventas realizadas - contadas por la variable i
    private int vender(double []ventas){  
	String otro;           //otro es un objeto  usa operador punto otro.
	int i=0;
        int max = ventas.length;
	Scanner sc = new Scanner(System.in); //sc dura solo el bloque veder
        
	do{
	    System.out.print("\n\tRegistra Venta [50c a 2000] " + (i+1) ); 
	    System.out.print("\t");
	    ventas[i] = leeNumeroD(0.5,2000);       
                        //tengo productos cuestan entre 50c y  $2000
	                //vector - permite registrar cada venta
	    i++;
	    System.out.print("\tOtra venta? [s/n]   ");
	    otro =  sc.next();
	}while( (otro.compareToIgnoreCase("s") == 0) &&  i < max) ;   

	return i;    //devuelve numVentas
    }
        
  //algoritmo de recorrido con suma de los elementos de un vector
  //los algoritmos de calculo no leen ni imprimen  
   public double sumar(double []vector, int n ){
	double suma=0;	
	        
        for(int i=0;  i < n;   i++){
	    suma = suma + vector[i];      //acumulador
	}         
	return suma;
   }

//cuenta cuantos valores del vector son mayor o igual a la cantidad recibida	
//si usara la constante el programa solo funciona con 100 -if(ventas[i] >= 100){
// constante la vuelves parametro- asi la funcion trabaja con el numero que
//le mandes if(ventas[i] >= cantidad){
    public int contarMayor(double []vector,int n, double cantidad){
        int cuenta=0;
	
        for(int i=0; i < n; i++){
            if(vector[i] >= cantidad){
                cuenta++;  //contador de uno en uno cuenta = cuenta + 1;
            }
        } 
        return cuenta;
    }

    //encuentra el numero mayor en un vector
    public double buscaMayor(double []vector, int n){
	double mayor;              
		
	//inicializo mayor con el primer elemento del vector
	mayor = vector[0];	
	for(int i=0; i < n; i++){
	    if(vector[i] > mayor){
		mayor = vector[i];
	    }
	} 
	return mayor;
    }
        
    public static void main(String[] args) {
        Ventas v = new Ventas(1);
    }    
}