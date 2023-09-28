package Calculadora;

public class Calc {

    public static double calcular(int operacion, double op1, double op2){

        double resultado = 0;

        switch(operacion){
            case 1: resultado = op1 + op2; break;
            case 2: resultado = op1 - op2; break;
            case 3: resultado = op1 * op2; break;
            case 4: resultado = op1 / op2; break;
            default: resultado = 0;
        }

        return resultado;
    }
}
