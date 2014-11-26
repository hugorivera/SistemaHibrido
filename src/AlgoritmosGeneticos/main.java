package AlgoritmosGeneticos;

/**
 *
 * @author Alberto
 */
public class main {

    public static void main(String[] args) {
       
        FitnessCalc.setSolution("1101000000000000111000000000010000000001110000000000000000001011");       
        
        Population myPop = new Population(50, true);
        
        int generationCount = 0;
        
        while (myPop.getFittest().getFitness()< FitnessCalc.getMaxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
            myPop = Algorithm.evolvePopulation(myPop);
            //El myPop.getFittest(); se envia a la red ART 
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());
    }

}
