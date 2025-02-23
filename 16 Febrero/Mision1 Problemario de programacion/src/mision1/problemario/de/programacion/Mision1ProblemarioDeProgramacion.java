
package mision1.problemario.de.programacion;

import java.util.Scanner; // Importar la clase Scanner


public class Mision1ProblemarioDeProgramacion {
    public static int anoBisiesto(int ano){
        
        int residuo;
        int bisiesto;
        int num4 = ano;
        residuo = num4%4;
        if(residuo == 0){
            if(num4%100 == 0){
                if(num4%400 == 0){
                    bisiesto = 1;
                }
                else{
                    bisiesto = 0;
                }
            }
            bisiesto = 1;

        }
        else{
            bisiesto = 1;
        }   
    return(bisiesto);
}
    
    public static int diaDeManana(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el año: "); 
        int ano = scanner.nextInt();
        anoBisiesto(ano);
        int dia=0;
        int mes=0;

        if(anoBisiesto(ano) == 1){
            System.out.println("Ingrese el mes: "); 
            mes = scanner.nextInt();
            if(mes>0 && mes<=12){
                System.out.println("Ingrese el dia: "); 
                dia = scanner.nextInt();
                int newday=dia;
                int newmes=mes;
                int newyear= ano;
                if(dia>0 && dia<=31){

                    // MESES DE 30 DIAS
                    if(mes==4 || mes== 6 || mes==9 || mes== 11){
                        if(dia == 30){
                            newday = dia-29; 
                            newmes = mes+1;
                        }
                        // Resto de días
                        else{
                            newday = dia+1; 
                        }
                    }

                    // MESES DE 31 DIAS
                    else if (mes == 2){
                        if(dia == 28){
                            newday = dia-27; 
                            newmes = mes+1;
                        }
                        else{
                            newday = dia+1; 
                        }
                    }    
                    else{ 
                        // Diciembre
                        if(mes == 12){
                            if(dia == 31){
                                newday = dia-30; 
                                newmes = mes-11;
                                newyear = ano+1;
                            }
                            else{
                                newday = dia+1; 
                            }
                        }
                        // Meses de 31 dias ferentes a Diciembre
                        else{
                            if(dia == 31){
                                newday = dia-30; 
                                newmes = mes+1;
                            }
                            else{
                                newday = dia+1; 
                            }
                        }  
                    }
                    // ACA VAN LAS IMPRESIONES
                    System.out.println("La fecha para mañana será:  " +newday+"/"+newmes+"/"+newyear+"\n"); 
                    newday = dia; 
                    newmes = mes;
                    newyear = ano;
                }

                else{
                System.out.println("Día invalido o fuera del limite"); 
                }
            }
            else{
                System.out.println("Mes invalido o fuera del limite"); 
            }        
        }
        else{
           System.out.println("Vuelva a intentarlo con un año que no sea Bisiesto ");         
        }
    
        return 0;
    }
    
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
                    System.out.print("Ingrese el año para determinar si es bisiesto o no: "); 
                    int num4 = scanner.nextInt();
                    
                    if(anoBisiesto(num4) == 1){
                        System.out.println("\n\nEl año: " + num4 + " es Bisiesto");
                    }
                    else{
                        System.out.println("\n\nEl año: " + num4 + " NO es Bisiesto");
                    }
                    
                    break;  
                    
                case 9:
                    diaDeManana();
                    

                    break;
                     
                    
                case 23:


                    System.out.println("Ingrese el año para continuar"); 
                    int anoPascua = scanner.nextInt();
                    double day;
                    double A = anoPascua % 19 ;
                    double B = anoPascua % 4;
                    double C = anoPascua % 7;
                    double D = (19*A+24)%30;
                    double E = (2*B+4*C+6*D+5) % 7;
                    double N = (22+D+E);


                    if( N>31 ){
                        day = N-31;
                        System.out.println("DÍA = "+day);
                        System.out.println("MES = ABRIL");
                    }
                    else if(N==31){
                        day=N;
                        System.out.println("DÍA = "+ day);
                        System.out.println("MES = MARZO");
                    }
                    else{
                        day = N-31;
                        System.out.println("DÍA = "+day);
                        System.out.println("MES = MARZO");
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
