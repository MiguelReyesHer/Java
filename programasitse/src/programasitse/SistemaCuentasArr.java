//Sistema Cuenta de ahorros completo
package programasitse;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCuentasArr {
    //solo declaro variable, informo que los apuntadores apuntaran a objetos
    //tipo Cuenta  con  <Cuenta>
    ArrayList <Cuenta> cuentas;            //declaro
   
    public SistemaCuentasArr(){
       //instancio - crear el objeto tipo ArrayList 
       //que es una estructura de datos dinámica a la cual se le van
       //agregando tatos conforme se necesita
       cuentas = new <Cuenta> ArrayList();     //instancio
       proceso(); 
    }
         
    private void proceso( ){
        char opc;      
        Cuenta cliente = null;   //null es el cero de lo apuntadores
        String cta;
        
        do{
          opc = menu();            
          switch(opc){
            case '1':   cta = leeCta();
                        if(cta.compareTo("00000") != 0 ){ 
                           cliente = buscar(cta);
                           if(cliente == null){
                              registro(cta);      //proceso de carga de datos
                           }else{
                              System.out.println(" El cliente ya esta"
                                                      + " registrado "); 
                           }                              
                        } 
                        break;
            case '2':   cta = leeCta();
                        cliente = buscar(cta);   //proceso de busqueda en datos
                        if(cliente != null){
                           deposito(cliente);   //proceso de actualizar
                        }else{
                            System.out.println("  Cliente no Encontrado "); 
                        }   
                        break;
            case '3':   cta = leeCta();
                        cliente = buscar(cta);
                        if(cliente != null){
                           retiro(cliente);      //proceso de actualizar
                        }else{
                            System.out.println("  Cliente no Encontrado "); 
                        }    
		        break;
            case '4':   cta = leeCta();
                        cliente = buscar(cta);
                        if(cliente != null){    //salida
                           System.out.print("Su saldo a la fecha es: " + 
                                     cliente.saldo + " pesos ");	
                        }else{
                            System.out.println(" Cliente no Encontrado "); 
                        } 
                        break;	
            case '5':   if(cuentas.isEmpty()){
                           System.out.println(" No hay cuentas registradas");
                        }else{
                           listaClientes();
                        }   
                        break;  
            case '6':   cta = leeCta();
                        cliente = buscar(cta);
                        if(cliente != null){    
                            cambiaNombre(cliente);	
                        }else{
                            System.out.println(" Cliente no Encontrado "); 
                        } 
                        break; 
            case '7':   cta = leeCta();
                        cliente = buscar(cta);
                        if(cliente != null){    
                            eliminaCliente(cliente);	
                        }else{
                            System.out.println(" Cliente no Encontrado "); 
                        } 
                        break;             
  	    case '8':   System.out.println(" Fin de las transacciones \n");
          }
        }while(opc != '8');         
    }
    
    //Eliminar un elemento en ArrayList
    //Siempre y cuando la cuenta no tenga saldo
    private void eliminaCliente(Cuenta cliente){
        Scanner sc = new Scanner(System.in);
        String aprueba;
        
        if(cliente.saldo == 0 ){
          System.out.println(" Elimina la cuenta: \n " + cliente);
          System.out.print("¿Desea eliminar la cuenta? [s/n]: ");
	  aprueba =  sc.next();
	  if(aprueba.compareToIgnoreCase("s") == 0){
            //quito del array list la referencia hacia el objeto de las cuentas
            //el garbage collector se dara cuenta de que la nubecita (el objeto)
            //ya no esta siendo apuntado y automaticamente libera la memoria
            //es decir - el SO podra asignar esa memoria a otro proceso
            cuentas.remove(cliente);    
            System.out.println(" Cliente eliminado.....");
          }else{
            System.out.println("  La cuenta continua habilitada ");
          }
        }else{
            System.out.println("La cuenta debe estar en ceros....");
        }        
    }
    
    //actualizacion de una variable de clase encapsulada    
    private void cambiaNombre( Cuenta  cl){
        Scanner sc = new Scanner(System.in);
        String  nombre; 
        
        System.out.println("Actualiza el Nombre: " + cl.getNombreCliente());
        System.out.print("Nuevo Nombre: ");
        nombre = sc.nextLine();
        cl.setNombreCliente(nombre);
        //System.out.println("  Nombre Actualizado " + cl);  usaria toString()
        System.out.println("  Nombre Actualizado "+ cl.getNombreCliente()+
                             "  Cta: " + cl.getNumeroCuenta());
         //si quisiera ver el saldo  es + "  "+ cl.saldo); sin getter
    }
     
    //argoritmo de recorrido ArrayList para mostrar
    private void  listaClientes( ){
        for(Cuenta cliente : cuentas){      
            System.out.println(cliente);
        }
    } 
    
    // Metodo con proceso para leer una cadena -sin mensaje devuelve cadena
    // faltaria la validacion: las cuentas solo tiene 5 digitos
    //  La cuenta es  "00000" si el valor es invalido
    private String leeCta( ){
        Scanner sc = new Scanner(System.in);
        String  cta;
        boolean ok;        // valor es true   o   false
        
        System.out.print("  Busca Cuenta Numero: ");
        cta = sc.nextLine(); 
        
        //proceso de validacion
        ok = cta.matches("[0-9]+");    //uso de una expresion regular [0-9]+
        
        //validador - para que los datos siempre esten correctos
        if(cta.compareTo("00000") == 0){
            System.out.println(" Numero de Cuenta invalido ");
        }else  if(cta.length() != 5){
            System.out.println("La cuenta contiene 5 digitos");
            cta = "00000";     // - banderas valores no posibles 
        }else if(!ok){         //ok == true        !ok (not ok) == false
            System.out.println(" La cuenta solo son digitos");
            cta = "00000";
        }
        return cta;
    }
    
    // el encabezado del metodo   cliente = buscar();
    private Cuenta buscar(String  cta ){
        //Busueda por numero de cuenta
        //for each 
        //Cuenta cliente - estas declarando una variable para un objeto
        //getNumeroCuenta( )   por que el numero de cuenta esta encapsulado
        for(Cuenta cliente : cuentas){
            if(cliente.getNumeroCuenta( ).compareTo(cta) ==  0){ //son iguales?
               return cliente;
            }
        }        
        return null;
    }
    
    //forma de crear una estructura de datos
    private void registro(String  cta  ){
        Scanner sc = new Scanner(System.in);
        Cuenta cl;
        String  nombre;
     
        //pide datos para el objeto        
        System.out.println("  Registrando Cuenta " + cta);
        System.out.print("  Nombre: ");
        nombre = sc.nextLine();
        //crea el objeto con regla de negocio - INSTANCIAR
        cl = new Cuenta(cta,nombre); 
             
        //pego el objeto a la lista
        cuentas.add(cl);
        System.out.println("Registrado... " + cl);
    }
    //un algoritmo de actualizacion de un dato de un objeto  
    // recordando que la variable saldo de la clase Cuenta es publica
    private void retiro(Cuenta cl){
      double retiro;
      Ventas v = new Ventas();  
               
      System.out.print("\nCuanto dinero desea retirar [100-9000]: "); 
      retiro = v.leeNumeroD(100, 9000);			
      if(retiro > cl.saldo){
  	   System.out.print("No cuenta con esa cantidad..\n");
      }else{
	   cl.saldo = cl.saldo - retiro;           //uso la variable publica
	   System.out.print("Retirado.....\n");
	   if(cl.saldo == 0){
		 System.out.print("La cuenta esta en ceros...\n");
  	   } 
       }
    }
    //un algoritmo de actualizacion  de una variable publica 
    private void deposito(Cuenta cl){
        double deposito;
        Ventas v = new Ventas();
        
        System.out.print("\nCuanto dinero desea ingresar en cuenta" +
                         "[100-10000]: "); 
         
	deposito = v.leeNumeroD(100, 10000);  
	cl.saldo = cl.saldo + deposito;
	System.out.print("Depositado.....\n"); 
    }
    
    private char menu(  ){
        char opc = 0;        
        String cad;         
        Scanner sc = new Scanner(System.in);
                                  
        do{
            System.out.print("\n\n\t Banco del Ahorro \n");
            System.out.print("1. Registro de Cuenta \n");
            System.out.print("2. Ingresar dinero en cuenta \n");            
            System.out.print("3. Retirar dinero de la cuenta \n");
            System.out.print("4. Consultar el saldo \n");
            System.out.print("5. Lista de clientes \n");
            System.out.print("6. Corregir Nombre de cliente \n");
            System.out.print("7. Baja de Cuenta \n");
            System.out.print("8. Salir \n");
            System.out.print("Opcion: "); 
            cad = sc.next().trim();      
      
            opc = cad.charAt(0);         
            if(opc < '1'  ||  opc > '8'){
                System.out.println(" ERROR: la opcion es [1  a  8] ");
            }            
        }while(opc < '1'  ||  opc > '8');    
        return opc;
    }

    public static void main(String[] args) {
        SistemaCuentasArr  sistema  = new SistemaCuentasArr( );      
    } 
}