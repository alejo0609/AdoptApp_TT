
package mision1.problemario.de.programacion;

import java.util.Scanner; // Importar la clase Scanner

public class Mision1ProblemarioDeProgramacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        float num1, num2, num3; // Declaramos las variables, pero las inicializamos dentro de cada caso

        do {
            System.out.println("\nMen� de Ejercicios\n");
            System.out.println( "1. Determinar si un n�mero es par o impar\n"
                    +           "2. Determinar si un n�mero entero es positivo o negativo\n"
                    +           "3. Realizar suma, resta y multiplicaci�n de dos n�meros\n"
                    +           "4. Calcular el mayor de los n�meros ingresados\n"
                    +           "5. Calcular el mayor de 3 n�meros enteros ingresados\n"
                    +           "6. Calcular el mayor de 4 n�meros enteros ingresados\n"
                    +           "7. Calcular el estado del agua seg�n su temperatura\n" 
                    +           "8. Calcular si un a�o es bisiesto o no\n\n"
                    
                    +           "0. Salir\n\n\n"
                    +           "Seleccione una opci�n: \n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un n�mero: ");
                    num1 = scanner.nextInt();
                    if (num1 % 2 == 0) {
                        System.out.println("El n�mero " + num1 + " es PAR.");
                    } else {
                        System.out.println("El n�mero " + num1 + " es IMPAR.");
                    }
                    break;
                
                case 2: //Pide un n�mero y determina si es positivo o negativo
                    System.out.print("Ingrese un n�mero entero: ");
                    num1 = scanner.nextInt();
                    if (num1 > 0) {
                        System.out.println("El n�mero ingresado es POSITIVO.");
                    } else {
                        System.out.println("El n�mero ingresado es NEGATIVO.");
                    }
                    break; 

                case 3: //Si un numero ingrresado es +, entonces solicita otro y hace operaciones b�sicas
                    System.out.print("Ingrese un n�mero entero n�mero: ");
                    num1 = scanner.nextFloat();
                    
                    if (num1 > 0) {
                        System.out.print("Ingrese un segundo n�mero: ");
                        num2 = scanner.nextFloat();
                        System.out.println("La suma, resta y producto de ambos n�meros se muestra a continuaci�n:");
                        System.out.println("SUMA: " + (num1 + num2));
                        System.out.println("RESTA: " + (num1 - num2));
                        System.out.println("PRODUCTO: " + (num1 * num2));
                    }
                    else{
                        System.out.println("El n�mero ingresado es un valor diferente a un n�mero entero POSITIVO, intente nuevamente ingresando un n�mero entero POSITIVO");
                        
                    }
                    break; 
                    
                case 4: // Calcular el mayor de 2 n�meros
                    System.out.print("Ingrese un n�mero: ");
                    num1 = scanner.nextFloat();
                    System.out.print("Ingrese el segundo n�mero: ");
                    num2 = scanner.nextFloat();
                    if(num1>num2){
                        System.out.println("El n�mero " + num1 + " es MAYOR que " + num2 );
                    }
                    else{
                        System.out.println("El n�mero " + num1 + " es MENOR que " + num2 );
                    }
                    break;
                
                case 5: // Calcular el mayor de 3 n�meros
                    int mayor= Integer.MIN_VALUE;
                    for (int i=1; i<=3; i++){
                       System.out.println("Ingrese el n�mero: " + i + ": "); 
                       int num = scanner.nextInt();
                       if(num>mayor){
                           mayor=num;
                       }
                    }
                    System.out.println("\n\nEl n�mero mayor de los tres ingresados es el: " + mayor); 
                    
                    break;
                    
                case 6: // Calcular el mayor de 4 n�meros
                    int mayor2= Integer.MIN_VALUE;
                    for (int i=1; i<=4; i++){
                       System.out.print("Ingrese el n�mero: " + i + ": "); 
                       int num = scanner.nextInt();
                       if(num>mayor2){
                           mayor2=num;
                       }
                    }
                    System.out.println("\n\nEl n�mero mayor de los cuatro ingresados es el: " + mayor2); 
                    
                    break;
                    
                case 7: // Calcula el estado del agua de acuerdo a la temperatura
                    //int mayor3= Integer.MIN_VALUE;
                    String estado="";
                    System.out.print("Ingrese el el valor de la temperatura: "); 
                    double num = scanner.nextInt();
                    if(num<0){
                        estado="S�lido";
                    }
                    else if(num>0 && num<=100){
                        estado="L�quido";
                    }
                    else{
                        estado="Gas";
                    } 
                    System.out.println("\n\nEl estado actual del agua es: " + estado); 
                    
                    break;

                 case 8: // Calcula un a�o Bisiestos
                    int residuo;
                    System.out.print("Ingrese el a�o para determinar si es bisiesto o no: "); 
                    int num4 = scanner.nextInt();
                    residuo = num4%4;
                    if(residuo == 0){
                        if(num4%100 == 0){
                            if(num4%400 == 0){
                                System.out.println("\n\nEl a�o: " + num4 + " es Bisiesto");
                                break;
                            }
                            else{
                                System.out.println("\n\nEl a�o: " + num4 + " NO es Bisiesto");
                                break;
                            }
                        }
                        System.out.println("\n\nEl a�o: " + num4 + " es Bisiesto");
                        
                    }
                    else{
                        System.out.println("\n\nEl a�o: " + num4 + " NO es Bisiesto");
                    }
                    
                    break;                   
                    
                    
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opci�n no v�lida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
