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

		return fitness;
	}

	private int turn(ArrayList<Integer> candidate) {

		return 0;
	}

	private int transition(ArrayList<Integer> candidate) {
		int sum = 0;
		for (int i = 0; i < candidate.size(); i++) {
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
			}

		}

		return sum;
	}

	private int energy(ArrayList<Integer> candidate) {

		return 0;
	}

	private int repeats(ArrayList<Integer> candidate) {

		return 0;
	}

	private int sequence(ArrayList<Integer> candidate) {

		return 0;
	}

}
