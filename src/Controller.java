import java.util.ArrayList;
import java.util.Arrays;
public class Controller {
	// Todo include ts sample size and winner size
	

	public static void main(String[] args) {
		 ArrayList<Move> moves = new ArrayList<Move>();
		  

			  Move move1 = new Move(Transition.UP_MOVE, Speed.MEDIUM, Position.STANDING, );
			  moves.add(move1);
			  
			  Move move2 = new Move(Transition.UP_MOVE, Speed.FAST, Position.MULTIPLE, );
			  moves.add(move2);
			  
			  
			  Move move3 = new Move(Transition.DOWN_TRANS, Speed.FAST, Position.STANDING, );
			  moves.add(move3);
			  
			  Move move4 = new Move(Transition.UP_TRANS, Speed.SLOW, Position.MULTIPLE, );
			  moves.add(move4);
			  
			  Move move5 = new Move(Transition.UP_MOVE, Speed.FAST, Position.STANDING, );
			  moves.add(move5);
			  
			  Move move6 = new Move(Transition.UP_MOVE, Speed.SLOW, Position.STANDING, );
			  moves.add(move6);
			  
			  Move move7 = new Move(Transition.UP_MOVE, Speed.SLOW, Position.STANDING, );
			  moves.add(move7);
			  
			  Move move8 = new Move(Transition.UP_MOVE, Speed.SLOW, Position.STANDING, );
			  moves.add(move8);
			  
			  Move move9 = new Move(Transition.DOWN_TRANS, Speed.SLOW, Position.MULTIPLE, );
			  moves.add(move9);
			  
			  Move move10 = new Move(Transition.DOWN_MOVE, Speed.MEDIUM, Position.FLOOR, );
			  moves.add(move10);
			  
			  Move move11 = new Move(Transition.UP_TRANS, Speed.MEDIUM, Position.MULTIPLE, );
			  moves.add(move11);
			  
			  Move move12 = new Move(Transition.UP_MOVE, Speed.MEDIUM, Position.STANDING, );
			  moves.add(move12);
			  
			  Move move13 = new Move(Transition.DOWN_TRANS, Speed.FAST, Position.MULTIPLE, );
			  moves.add(move13);
			  
			  Move move14 = new Move(Transition.DOWN_MOVE, Speed.MEDIUM, Position.MULTIPLE, );
			  moves.add(move14);
			  
			  Move move15 = new Move(Transition.DOWN_MOVE, Speed.MEDIUM, Position.FLOOR, );
			  moves.add(move15);
			  
			  Move move16 = new Move(Transition.UP_TRANS, Speed.FAST, Position.STANDING, );
			  moves.add(move16);
			  
			  Move move17 = new Move(Transition.UP_MOVE, Speed.SLOW, Position.STANDING, );
			  moves.add(move17);
			  
			  Move move18 = new Move(Transition.UP_MOVE, Speed.SLOW, Position.FLOOR, );
			  moves.add(move18);
			  
			  Move move19 = new Move(Transition.UP_MOVE, Speed.FAST, Position.FLOOR, );
			  moves.add(move19);
			  
			  Move move20 = new Move(Transition.UP_MOVE, Speed.FAST, Position.MULTIPLE, );
			  moves.add(move20);

			int lengthOfDance = 20;
			int numberOfMoves = 20;
			int popSize = 200;
			String selectionType = "ts";
			String crossoverType = "1c";
			Double crossoverProb = 0.7;
			Double mutationProb = 0.01;
			int maxIterations = 1000;

			// Run Genetic Algorithm.
			Genetic geneticAlgo = new Genetic(popSize, lengthOfDance, numberOfMoves, maxIterations, crossoverType, crossoverProb,
					mutationProb,moves);
			geneticAlgo.evolve(selectionType);



	}


}
