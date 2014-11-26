package RedNeuronalHopfield;

import java.util.ArrayList;
/**
 *
 * @author Alberto
 */
public class OperacionesFormula {

    public int multiplicacion(ArrayList L1, ArrayList L2) {
        int resultado = 0;
        for (int i = 0; i < L1.size(); i++) {
            resultado += Integer.parseInt(L1.get(i).toString()) * Integer.parseInt(L2.get(i).toString());
        }
        return resultado;
    }

    public int funcionActivacion(Object... args) {
        int valor = (int) args[0];
        if ((int) args[0] >= 0) {
            valor = 1;
        } else if ((int) args[0] < 0) {
            valor = -1;
        }
        return valor;
    }

    public boolean comparaVectores(int entrada[], int nuevo[]) {
        boolean voBo = true;
        for (int i = 0; i < entrada.length; i++) {
            if (entrada[i] == nuevo[i]) {
            } else {
                voBo = false;
            }
        }
        return voBo;
    }

    public void imprimeLista(ArrayList lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
}
