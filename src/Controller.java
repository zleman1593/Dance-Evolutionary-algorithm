import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
	// Todo include ts sample size and winner size

	public static void main(String[] args) {
	

			int lengthOfDance = 20;
			int numberOfMoves = 20;
			int popSize = 1000;
			String selectionType = "ts";
			String crossoverType = "1c";
			Double crossoverProb = 0.7;
			Double mutationProb = 0.01;
			int maxIterations = 1000;

			// Run Genetic Algorithms.
			Genetic geneticAlgo = new Genetic(popSize, lengthOfDance, numberOfMoves, maxIterations, crossoverType, crossoverProb,
					mutationProb);
			geneticAlgo.evolve(selectionType);



	}


}
