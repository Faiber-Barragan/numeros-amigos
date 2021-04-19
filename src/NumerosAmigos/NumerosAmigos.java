package NumerosAmigos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumerosAmigos {
    
    //Función recursiva
    static int numeroAmigo(int num, int div){
        if(div == 1){
            return 1;
        }
        
        if(num % div == 0){
            return div + numeroAmigo(num, div-1);
        }
        
        return numeroAmigo(num, div-1);
    }
    
    static boolean esNumeroAmigo(int num1, int num2) throws StackOverflowError{
        /*Al divir el numero entre 2 se optimiza el algoritmo, siendo este el doble de rápido,
        ya que, ningún numero es divisible por su mitad superior*/
        int div1 = num1/2;
        int div2 = num2/2;

        //True si son amigos
        return numeroAmigo(num1, div1) == num2 && numeroAmigo(num2, div2) == num1;
    }
    
    static int pedirNumeroEnteroPositivo(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        
        //Ciclo infinito hasta que el usuario ingrese 2 numeros enteros mayores a cero
        //Los numeros deben ser menores a 2^31
        while(true){
            try {
                while(true){
                    System.out.print("Ingrese un numero entero positivo: ");
                    num = Integer.parseInt(br.readLine());
                    if(num > 0){
                        return num;
                    }else{
                        System.out.println("El numero ingresado no es mayor a 0, intente de nuevo");
                        System.out.println("");
                    }
                }
                
            } catch (IOException ex) {
                System.out.println("Problema de lectura");
                System.out.println("");
            } catch (NumberFormatException ex){
                System.out.println("Los datos ingresados no son numeros enteros o es un numero muy grande, intente de nuevo");
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        
        //Solicitar 2 numeros mayores a cero
        int num1 = pedirNumeroEnteroPositivo();
        int num2 = pedirNumeroEnteroPositivo();        
        
        //Validar si son numeros amigos y se contrala el máximo numero de llamadas recursivas
        try {
            if(esNumeroAmigo(num1, num2))
                System.out.println("El numero "+ num1 +" y el numero "+ num2 + ", son numeros amigos. :D");
            else
                System.out.println("El numero "+ num1 +" y el numero "+ num2 + ", no son numeros amigos. :(");
            
        } catch (StackOverflowError e) {
            System.out.println("Lo siento :( la profundiad del algorimo ha sido superada, intenta con numeros más pequeños.");
        }
    }
    
}
