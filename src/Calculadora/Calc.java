package Calculadora;

public class Calc {

    /**
     * Funcion que permite hacer los calculos de las operaciones de suma, resta, multiplicacion, division, potencia y raiz.
     *
     * @author Alejandro Recarte Rebollo
     * @param operacion Numero de la operacion que se va a realizar suma(1), resta(2), multiplicacion(3), division(4), potencia(5), raiz(6)
     * @param op1       Primer operando
     * @param op2       Segundo operando
     * @return          Resultado decimal
     */

    public static double calcular(int operacion, double op1, double op2){

        double resultado = 0;

        switch(operacion){
            case 1: resultado = op1 + op2; break;
            case 2: resultado = op1 - op2; break;
            case 3: resultado = op1 * op2; break;
            case 4: resultado = op1 / op2; break;
            case 5: resultado = Math.pow(op1, op2); break;
            case 6: resultado = Math.pow(op1, 1.0 / op2); break;
            default: resultado = 0;
        }

        return resultado;
    }

    /**
     * Funcion que permite obtener el diagrama de factorizacion de un digito.
     * Codigo original: "https://github.com/AlexRecarte/Programacion/blob/3f6840d0734be78e5b67f17887ee8107fd3ea507/Calculadora%20mejorada/calculadora.java"
     *
     * @author Alejandro Recarte Rebollo
     * @param n Operando para factorizar
     * @return  String con el diagrama
     */

    public static String factorizar(int n){
        String resultado = new String("Factorización de " +n);
        String espacio = " ";
        int iaux = 0;
        int l = n;
        String espacioauxiliar = "   ";
        String espaciofinal= "   ";
        int naux = n;
        for (int i= 2 ; i<=n;)
        {
            int numdig = 0;
            int numdig2 = 0;
            if (n % i == 0) {
                for (int j = n; j > 0; j = j / 10) {
                    numdig++;
                }
                resultado += ("\n" + espaciofinal + n+" | "+i);
                n = n / i;
                for (int k = n; k > 0; k = k / 10) {
                    numdig2++;
                }
                while (numdig > numdig2) {
                    espaciofinal = espaciofinal + espacio;
                    numdig--;
                }
            }
            if (n % i != 0) {
                i++;
            }
            iaux = i;
        }
        if (n == iaux) {
            resultado += ("\n" + espaciofinal + iaux+" | " +iaux);}
        int numdig = 0;
        for (int j = naux; j > 0 ; j = j / 10) {
            numdig++;
        }
        while (numdig > 1) {
            espacioauxiliar = espacioauxiliar + espacio;
            numdig--;
        }
        resultado += ("\n" + espacioauxiliar + 1+" | " +1 + "\n");
        return resultado;
    }

    /**
     * Funcion que devuelve el Maximo Comun Divisor de dos numeros.
     *
     * @author Alejandro Recarte Rebollo
     * @param a Primer operando
     * @param b Segundo operando
     * @return  MCD resultado
     */

    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Funcion que devuelve el Minimo Comun Multiplo de dos numeros.
     *
     * @author Alejandro Recarte Rebollo
     * @param a Primer operando
     * @param b Segundo operando
     * @return  MCM resultado
     */

    public static int mcm(int a, int b) {
        return a * (b / mcd(a, b));
    }
}
