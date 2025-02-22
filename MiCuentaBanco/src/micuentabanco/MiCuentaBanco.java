
//package main;       
package micuentabanco;

import java.util.Scanner;

public class MiCuentaBanco {

    /**
     * @param args the command line arguments
     */
    
  
    
    public static double consultaSaldo(double saldo){
        double valor=saldo;
        return valor;
    }
    
    public static double hacerRetiro(double saldo){
        System.out.println("Su saldo actual es de: " + consultaSaldo(saldo) + "\n");
        System.out.println("¿Ingrese el valor que desea retirar\n");   
        Scanner scanner = new Scanner(System.in);
        double valor = scanner.nextDouble();
        double disponible = consultaSaldo(saldo);
        
        
        if(valor>0){
            if(valor <= disponible){
                System.out.println("Valor Retirado: "+ valor+"\n"); 
                disponible = consultaSaldo(saldo)- valor;
                System.out.println("Nuevo Saldo: "+ disponible+"\n");
                
            }
            else{
               System.out.println("El valor que estas intentando retirar supera tu saldo actual,\n intentalo nuevamente con una cantida inferio\n"); 
            }
        }
        else{
            System.out.println("Error del monto solicitado, intentelo nuevamente\n"); 
        }
        return disponible;
    }
    
        public static double ingresarDinero(double saldo){
        System.out.println("¿Ingrese la cantidad a depositar\n");   
        Scanner scanner = new Scanner(System.in);
        double valor = scanner.nextDouble();
        double newSaldo = consultaSaldo(saldo);
        
        if(valor>0){
            if(valor > 0 ){
                System.out.println("Deposito ingresado: "+ valor+"\n"); 
                newSaldo = consultaSaldo(saldo)+ valor;
                System.out.println("Nuevo Saldo: "+ newSaldo+"\n");
                
            }
            else{
               System.out.println("Error del monto solicitado, intentelo nuevamente\n"); 
            }
        }
        return newSaldo;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String usuario = "Alejandro";
        double saldo= 500000;
                
        while(true){
          System.out.println("Hola " + usuario + "\n"); 
          System.out.println("Qué quieres hacer el día de hoy\n");  
          System.out.println("1. Consultar Saldo\n"); 
          System.out.println("2. Hacer Retiros\n"); 
          System.out.println("3. Hacer Consignacion\n"); 
          System.out.println("4. Salir\n"); 
          Scanner scanner = new Scanner(System.in);
          int opcion = scanner.nextInt();
          
          if(opcion == 4){
            break;
          }
          
          switch (opcion){
          
              case 1:
                  System.out.println(usuario+" Su saldo actual es de: $"+consultaSaldo(saldo)+"\n");
                  break;
                  
              case 2:
                  saldo=hacerRetiro(saldo); 
                  
                  break;
                  
              case 3:
                  saldo=ingresarDinero(saldo); 
                  break;
                  
              default:
                  break;
          
          }
        }
    }
    
}
