
package mision1.problemario.de.programacion;

import java.util.Scanner; // Importar la clase Scanner

public class Mision1ProblemarioDeProgramacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        float num1, num2, num3; // Declaramos las variables, pero las inicializamos dentro de cada caso

        do {
            System.out.println("\nMenú de Ejercicios");
            System.out.println( "1. Determinar si un número es par o impar\n"
                    +           "2. Determinar si un número entero es positivo o negativo\n"
                    +           "3. Realizar suma, resta y multiplicación de dos números\n"
                    +           "4. Calcular el mayor de los números ingresados\n"
                    +           "5. Calcular el mayor de los números ingresados\n"
                    
                    +           "0. Salir\n"
                    +           "Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un número: ");
                    num1 = scanner.nextInt();
                    if (num1 % 2 == 0) {
                        System.out.println("El número " + num1 + " es PAR.");
                    } else {
                        System.out.println("El número " + num1 + " es IMPAR.");
                    }
                    break;
                
                case 2: //Pide un número y determina si es positivo o negativo
                    System.out.print("Ingrese un número entero: ");
                    num1 = scanner.nextInt();
                    if (num1 > 0) {
                        System.out.println("El número ingresado es POSITIVO.");
                    } else {
                        System.out.println("El número ingresado es NEGATIVO.");
                    }
                    break; 

                case 3: //Si un numero ingrresado es +, entonces solicita otro y hace operaciones básicas
                    System.out.print("Ingrese un número entero número: ");
                    num1 = scanner.nextFloat();
                    
                    if (num1 > 0) {
                        System.out.print("Ingrese un segundo número: ");
                        num2 = scanner.nextFloat();
                        System.out.println("La suma, resta y producto de ambos números se muestra a continuación:");
                        System.out.println("SUMA: " + (num1 + num2));
                        System.out.println("RESTA: " + (num1 - num2));
                        System.out.println("PRODUCTO: " + (num1 * num2));
                    }
                    else{
                        System.out.println("El número ingresado es un valor diferente a un número entero POSITIVO, intente nuevamente ingresando un número entero POSITIVO");
                        
                    }
                    break; 
                    
                case 4: // Calcular el mayor de 2 números
                    System.out.print("Ingrese un número: ");
                    num1 = scanner.nextFloat();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = scanner.nextFloat();
                    if(num1>num2){
                        System.out.print("El número " + num1 + " es MAYOR que " + num2 );
                    }
                    else{
                        System.out.print("El número " + num1 + " es MENOR que " + num2 );
                    }
                    break;
                
                case 5: // Calcular el mayor de 3 números
                    int mayor= Integer.MIN_VALUE;
                    for (int i=1; i<=3; i++){
                       System.out.print("Ingrese el número: " + i + ": "); 
                       int num = scanner.nextInt();
                       if(num>mayor){
                           mayor=num;
                       }
                    }
                    System.out.print("El número mayor de los tres ingresados es el: " + mayor); 
                    
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
3
3
