
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
        System.out.println("Ingrese el a�o: "); 
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
                        // Resto de d�as
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
                    System.out.println("La fecha para ma�ana ser�:  " +newday+"/"+newmes+"/"+newyear+"\n"); 
                    newday = dia; 
                    newmes = mes;
                    newyear = ano;
                }

                else{
                System.out.println("D�a invalido o fuera del limite"); 
                }
            }
            else{
                System.out.println("Mes invalido o fuera del limite"); 
            }        
        }
        else{
           System.out.println("Vuelva a intentarlo con un a�o que no sea Bisiesto ");         
        }
    
        return 0;
    }
    
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
                    System.out.print("Ingrese el a�o para determinar si es bisiesto o no: "); 
                    int num4 = scanner.nextInt();
                    
                    if(anoBisiesto(num4) == 1){
                        System.out.println("\n\nEl a�o: " + num4 + " es Bisiesto");
                    }
                    else{
                        System.out.println("\n\nEl a�o: " + num4 + " NO es Bisiesto");
                    }
                    
                    break;  
                    
                case 9:
                    diaDeManana();
                    

                    break;
                     
                    
                case 23:


                    System.out.println("Ingrese el a�o para continuar"); 
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
                        System.out.println("D�A = "+day);
                        System.out.println("MES = ABRIL");
                    }
                    else if(N==31){
                        day=N;
                        System.out.println("D�A = "+ day);
                        System.out.println("MES = MARZO");
                    }
                    else{
                        day = N-31;
                        System.out.println("D�A = "+day);
                        System.out.println("MES = MARZO");
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
