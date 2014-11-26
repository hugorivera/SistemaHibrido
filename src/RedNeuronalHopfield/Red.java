package RedNeuronalHopfield;

import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public class Red {

    Matriz M = new Matriz();
    OperacionesFormula O = new OperacionesFormula();
    int pesos[][];

    public void FaseEntrenamiento(int entrenamiento[][]) {
        Entrenamiento(entrenamiento);
        M.imprimeMatriz(pesos);
        System.out.println("");
    }

    public void FaseFuncionamiento(int entrada[]) {
        Prueba(entrada, pesos);
    }

    public void Entrenamiento(int entrenamiento[][]) {
        pesos = M.matriz00(entrenamiento);
        ArrayList formulaFacil = M.formulaFacil(entrenamiento);
        pesos = M.Generacion(pesos, formulaFacil);
    }

    public void Prueba(int entrada[], int pesos[][]) {
        M.generaNuevoVector(entrada, pesos);
    }
    public void Error(int entrada [][]){
        M.calculaError(entrada);
    }
}
