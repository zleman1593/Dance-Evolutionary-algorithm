import java.util.ArrayList;
import java.util.Random;

public class EvolAlgorithms {

	// The MAXSAT problem
	protected ArrayList<Move> moves;
	protected ArrayList<ArrayList<Integer>> satProblem = new ArrayList<ArrayList<Integer>>();
	// Random number generator
	protected Random randomGenerator = new Random();
	protected int bestGeneration;
	protected int currentGeneration;

	/* Fitness Function */
	public int evaluateCandidate(ArrayList<Integer> candidate) {
		int fitness = 0;

		fitness += transition(candidate);
		fitness += repeats(candidate);
		fitness += repeatMoveTwo(candidate);
		fitness += repeatSequence(candidate);

		return fitness;
	}

	private int turn(ArrayList<Integer> candidate) {

		return 0;
	}

	private int transition(ArrayList<Integer> candidate) {
		int sum = 0;
		for (int i = 0; i < candidate.size() - 1; i++) {
			if (moves.get(candidate.get(i)).transition == Transition.DOWN_TRANS) {
				if (moves.get(candidate.get(i + 1)).transition == Transition.DOWN_MOVE) {
					sum += 3;
				}
				if (moves.get(candidate.get(i + 1)).transition == Transition.UP_TRANS) {
					sum += 1;
				}
				if (moves.get(candidate.get(i + 1)).transition == Transition.UP_MOVE) {
					sum += -2;
				}
			} else if (moves.get(candidate.get(i)).transition == Transition.UP_TRANS) {
				if (moves.get(candidate.get(i + 1)).transition == Transition.UP_MOVE) {
					sum += 2;
				}
				if (moves.get(candidate.get(i + 1)).transition == Transition.DOWN_TRANS) {
					sum += 1;
				}
				if (moves.get(candidate.get(i + 1)).transition == Transition.DOWN_MOVE) {
					sum += -2;
				}
				
			}
			
		}

		return sum;
	}

	private int energy(ArrayList<Integer> candidate) {

		return 0;
	}

	private int repeats(ArrayList<Integer> candidate) {
		int sum = 0;
		int numConsec = 1;
		int moveRepeated = 0;
		for (int i = 0; i < candidate.size(); i++) {
			if (candidate.get(i) == moveRepeated && i != 0){

				numConsec++;
			}else{
				numConsec = 1;
			}
			
			 if(numConsec > 2){
				sum += -1;
			}
			moveRepeated = candidate.get(i);
		}
		
		
		return sum;
	}
	
	
	private int repeatMoveTwo(ArrayList<Integer> candidate) {
		int sum = 0;
		int numConsec = 0;
		for (int i = 0; i < candidate.size(); i++) {
			
			if(candidate.get(i) == (2-1)){
				numConsec++;
			}else{
				numConsec = 0;
			}
			
			if(numConsec == 2){
				sum+=2;
			} else if(numConsec > 2){
				sum += -1;
			}

		}
		
		
		
		return sum;
	}

	private int repeatSequence(ArrayList<Integer> candidate) {

		int sum = 0;
		int numConsec = 1;
		int firstMoveRepeated = 0;
		int secondMoveRepeated = 0;
		for (int i = 0; i < candidate.size() -1; i+=2) {
			if (candidate.get(i) == firstMoveRepeated && candidate.get(i+1) == secondMoveRepeated && i != 0){

				numConsec++;
			}else{
				numConsec = 1;
			}
			
			if(numConsec == 2){
				sum += 1;
			} else if(numConsec > 2){
				sum += -1;
			}
			 firstMoveRepeated = candidate.get(i);
			 secondMoveRepeated = candidate.get(i+1);
		}
		
		
		return sum;
	}

}
