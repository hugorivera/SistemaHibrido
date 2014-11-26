package RedNeuronalHopfield;

import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public class Matriz {

    int pivoteInicial = 0;
    int pivote = 0;
    int nuevoVector[];
    int calculoError[];
    boolean comparacion = false;
    ArrayList resultados = new ArrayList<>();
    OperacionesFormula O = new OperacionesFormula();

    public int[][] matriz00(int[][] matriz) {
        int pesos[][] = new int[matriz[0].length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i == j) {
                    pesos[i][j] = 0;
                }
            }
        }
        return pesos;
    }

    public ArrayList formulaFacil(int[][] matriz) {
        int tamaño = matriz.length;
        int elementos = matriz[0].length;

        ArrayList l1 = new ArrayList();
        ArrayList l2 = new ArrayList();

        while (pivoteInicial < elementos) {
            while (pivote < elementos) {
                for (int i = 0; i < tamaño; i++) {
                    l1.add(matriz[i][pivoteInicial]);
                    l2.add(matriz[i][pivote]);
                }
                if (pivoteInicial != pivote) {
                    resultados.add(O.multiplicacion(l1, l2));
                }
                l1.clear();
                l2.clear();
                pivote++;
            }
            pivote = 0;
            pivoteInicial++;
        }
        return resultados;
    }

    public int[][] Generacion(int[][] pesos, ArrayList resultados) {
        int indicePila = 0;
        for (int i = 0; i < pesos.length; i++) {
            for (int j = 0; j < pesos[0].length; j++) {
                if (i == j) {
                } else {
                    pesos[i][j] = (int) resultados.get(indicePila);
                    indicePila++;
                }
            }
        }
        return pesos;
    }

    public void generaNuevoVector(int entrada[], int pesos[][]) {
        System.out.println("Vector Entrante");
        imprimeVector(entrada);
        int generaciones = 1;
        int tamaño = pesos.length;
        int elementos = pesos[0].length;
        nuevoVector = new int[tamaño];
        calculoError = new int[tamaño];

        int resultado = 0;
        while (comparacion != true) {
            for (int i = 0; i < tamaño; i++) {
                for (int j = 0; j < elementos; j++) {
                    resultado += pesos[i][j] * entrada[j];
                }
                nuevoVector[i] = O.funcionActivacion(resultado);
                resultado = 0;
            }
            comparacion = O.comparaVectores(entrada, nuevoVector);
            System.out.println("Generación: " + generaciones);
            imprimeVector(entrada);
            imprimeVector(nuevoVector);
            generaciones++;
            entrada = nuevoVector;
            calculoError = entrada;
            nuevoVector = new int[tamaño];
            if (generaciones >= 10001) {
                break;
            }
        }   //FIN DE WHILE
    }

    public void calculaError(int entrenamiento[][]) {
        int score = 0;
        int error;
        int tamaño = entrenamiento.length;
        int elementos = entrenamiento[0].length;
        int mayor = 0;
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < elementos; j++) {
                if (calculoError[j] == entrenamiento[i][j]) {
                    score++;
                }
                if (score >= mayor) {
                    mayor = score;
                }
            }

            score = 0;
        }
        System.out.println(mayor);
        error = (mayor * 100) / elementos;
        System.out.println("Porcentaje de aciertos: " + error + " %");

    }

    public void imprimeMatriz(int matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "|\t");
            }
            System.out.println("");
        }
    }

    public void imprimeVector(int vector[]) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + "|\t");
        }
        System.out.println("");
    }
}
