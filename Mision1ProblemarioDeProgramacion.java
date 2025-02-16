
package mision1.problemario.de.programacion;

import java.util.Scanner; // Importar la clase Scanner

public class Mision1ProblemarioDeProgramacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        float num1, num2, num3; // Declaramos las variables, pero las inicializamos dentro de cada caso

        do {
            System.out.println("\nMen� de Ejercicios");
            System.out.println( "1. Determinar si un n�mero es par o impar\n"
                    +           "2. Determinar si un n�mero entero es positivo o negativo\n"
                    +           "3. Realizar suma, resta y multiplicaci�n de dos n�meros\n"
                    +           "4. Calcular el mayor de los n�meros ingresados\n"
                    +           "5. Calcular el mayor de los n�meros ingresados\n"
                    
                    +           "0. Salir\n"
                    +           "Seleccione una opci�n: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un n�mero: ");
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
                        System.out.print("El n�mero " + num1 + " es MAYOR que " + num2 );
                    }
                    else{
                        System.out.print("El n�mero " + num1 + " es MENOR que " + num2 );
                    }
                    break;
                
                case 5: // Calcular el mayor de 3 n�meros
                    int mayor= Integer.MIN_VALUE;
                    for (int i=1; i<=3; i++){
                       System.out.print("Ingrese el n�mero: " + i + ": "); 
                       int num = scanner.nextInt();
                       if(num>mayor){
                           mayor=num;
                       }
                    }
                    System.out.print("El n�mero mayor de los tres ingresados es el: " + mayor); 
                    
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
3
3
