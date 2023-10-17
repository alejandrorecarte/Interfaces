package Calculadora;

public class Calc {

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

    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int mcm(int a, int b) {
        return a * (b / mcd(a, b));
    }
}
