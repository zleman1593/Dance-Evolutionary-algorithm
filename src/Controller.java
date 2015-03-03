import java.util.ArrayList;
import java.util.Arrays;
public class Controller {
	// Todo include ts sample size and winner size
	
	public enum Transition {
	    DOWN_MOVE, DOWN_TRANS, UP_MOVE, UP_TRANS
	}
	
	public enum Speed {
		SLOW, MEDIUM, FAST
	}
	
	public enum Position {
		STANDING, CROUCHING, MULTIPLE
	}

	public static void main(String[] args) {
		 ArrayList<Move> moves = new ArrayList<Move>();
		  

			  Move move1 = new Move();
			  moves.add(move1);
			  
			  Move move2 = new Move();
			  moves.add(move2);
			  
			  
			  Move move3 = new Move();
			  moves.add(move3);
			  
			  Move move4 = new Move();
			  moves.add(move4);
			  
			  Move move5 = new Move();
			  moves.add(move5);
			  
			  Move move6 = new Move();
			  moves.add(move6);
			  
			  Move move7 = new Move();
			  moves.add(move7);
			  
			  Move move8 = new Move();
			  moves.add(move8);
			  
			  Move move9 = new Move();
			  moves.add(move9);
			  
			  Move move10 = new Move();
			  moves.add(move10);
			  
			  Move move11 = new Move();
			  moves.add(move11);
			  
			  Move move12 = new Move();
			  moves.add(move12);
			  
			  Move move13 = new Move();
			  moves.add(move13);
			  
			  Move move14 = new Move();
			  moves.add(move14);
			  
			  Move move15 = new Move();
			  moves.add(move15);
			  
			  Move move16 = new Move();
			  moves.add(move16);
			  
			  Move move17 = new Move();
			  moves.add(move17);
			  
			  Move move18 = new Move();
			  moves.add(move18);
			  
			  Move move19 = new Move();
			  moves.add(move19);
			  
			  Move move20 = new Move();
			  moves.add(move20);

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
