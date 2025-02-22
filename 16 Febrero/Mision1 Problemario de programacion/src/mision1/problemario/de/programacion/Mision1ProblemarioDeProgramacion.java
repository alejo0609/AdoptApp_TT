
package mision1.problemario.de.programacion;

import java.util.Scanner; // Importar la clase Scanner

public class Mision1ProblemarioDeProgramacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        float num1, num2, num3; // Declaramos las variables, pero las inicializamos dentro de cada caso

        do {
            System.out.println("\nMenú de Ejercicios\n");
            System.out.println( "1. Determinar si un número es par o impar\n"
                    +           "2. Determinar si un número entero es positivo o negativo\n"
                    +           "3. Realizar suma, resta y multiplicación de dos números\n"
                    +           "4. Calcular el mayor de los números ingresados\n"
                    +           "5. Calcular el mayor de 3 números enteros ingresados\n"
                    +           "6. Calcular el mayor de 4 números enteros ingresados\n"
                    +           "7. Calcular el estado del agua según su temperatura\n" 
                    +           "8. Calcular si un año es bisiesto o no\n\n"
                    
                    +           "0. Salir\n\n\n"
                    +           "Seleccione una opción: \n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un número: ");
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
                        System.out.println("El número " + num1 + " es MAYOR que " + num2 );
                    }
                    else{
                        System.out.println("El número " + num1 + " es MENOR que " + num2 );
                    }
                    break;
                
                case 5: // Calcular el mayor de 3 números
                    int mayor= Integer.MIN_VALUE;
                    for (int i=1; i<=3; i++){
                       System.out.println("Ingrese el número: " + i + ": "); 
                       int num = scanner.nextInt();
                       if(num>mayor){
                           mayor=num;
                       }
                    }
                    System.out.println("\n\nEl número mayor de los tres ingresados es el: " + mayor); 
                    
                    break;
                    
                case 6: // Calcular el mayor de 4 números
                    int mayor2= Integer.MIN_VALUE;
                    for (int i=1; i<=4; i++){
                       System.out.print("Ingrese el número: " + i + ": "); 
                       int num = scanner.nextInt();
                       if(num>mayor2){
                           mayor2=num;
                       }
                    }
                    System.out.println("\n\nEl número mayor de los cuatro ingresados es el: " + mayor2); 
                    
                    break;
                    
                case 7: // Calcula el estado del agua de acuerdo a la temperatura
                    //int mayor3= Integer.MIN_VALUE;
                    String estado="";
                    System.out.print("Ingrese el el valor de la temperatura: "); 
                    double num = scanner.nextInt();
                    if(num<0){
                        estado="Sólido";
                    }
                    else if(num>0 && num<=100){
                        estado="Líquido";
                    }
                    else{
                        estado="Gas";
                    } 
                    System.out.println("\n\nEl estado actual del agua es: " + estado); 
                    
                    break;

                 case 8: // Calcula un año Bisiestos
                    int residuo;
                    System.out.print("Ingrese el año para determinar si es bisiesto o no: "); 
                    int num4 = scanner.nextInt();
                    residuo = num4%4;
                    if(residuo == 0){
                        if(num4%100 == 0){
                            if(num4%400 == 0){
                                System.out.println("\n\nEl año: " + num4 + " es Bisiesto");
                                break;
                            }
                            else{
                                System.out.println("\n\nEl año: " + num4 + " NO es Bisiesto");
                                break;
                            }
                        }
                        System.out.println("\n\nEl año: " + num4 + " es Bisiesto");
                        
                    }
                    else{
                        System.out.println("\n\nEl año: " + num4 + " NO es Bisiesto");
                    }
                    
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
