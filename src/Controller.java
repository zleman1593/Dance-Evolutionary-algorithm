import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
	// Todo include ts sample size and winner size

	public static void main(String[] args) {
		 ArrayList<Move> moves = new ArrayList<Move>();
		  //for(int i = 0; i < 20;i++ ){

			  Move move1 = new Move();
			  moves.add(move1);
			  
			  Move move2 = new Move();
			  moves.add(move2);
			  
			  
			  Move move3 = new Move();
			  moves.add(move3);
			  
			  Move move4 = new Move();
			  moves.add(move4);
		  //}

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
