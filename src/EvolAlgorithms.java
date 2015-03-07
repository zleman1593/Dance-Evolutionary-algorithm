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

	/*
	 * Fitness Function uses a points based system, where a candidate gets more
	 * points for following certain patterns or having certain characteristics
	 */
	/* Points a subtracted if it has undesirable characteristics */
	public int evaluateCandidate(ArrayList<Integer> candidate) {
		int fitness = 0;
		// Call all the methods to evaluate different traits
		fitness += transition(candidate);
		fitness += repeats(candidate);
		fitness += repeatMoveTwo(candidate);
		fitness += repeatSequence(candidate);
		fitness += diversity(candidate);
		fitness += varyingSpeed(candidate);
		fitness += varyinyPosition(candidate);

		return fitness;
	}

	private int turn(ArrayList<Integer> candidate) {

		return 0;
	}

	/* Prevents the algorithm from repeating only a few moves over and over */
	private int diversity(ArrayList<Integer> candidate) {
		int sum = 0;
		int diversity = 0;
		for (int i = 0; i < candidate.size(); i++) {
			if (candidate.contains(i)) {
				diversity++;
			}
		}

		if (diversity < 7) {
			sum = -1;
		} else {
			sum = 2;
		}
		return sum;

	}

	/*
	 * This function makes sure that all transition moves in a sequence are
	 * followed immediately by a move that is at the appropriate level and that
	 * doesn't "jar" with the transition
	 */
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

	/*
	 * Deducts points if dance sequence has a move that is consecutively
	 * repeated more than once.
	 */
	private int repeats(ArrayList<Integer> candidate) {
		int sum = 0;
		int numConsec = 1;
		int moveRepeated = 0;
		for (int i = 0; i < candidate.size(); i++) {
			if (candidate.get(i) == moveRepeated && i != 0) {

				numConsec++;
			} else {
				numConsec = 1;
			}

			if (numConsec > 2) {
				sum += -1;
			}
			moveRepeated = candidate.get(i);
		}

		return sum;
	}

	/*
	 * Deducts points if dance sequence has consecutive moves that is use
	 * exclusively the same single body part.
	 */
	private int repeatBodyparts(ArrayList<Integer> candidate) {
		int sum = 0;
		/*
		 * int numConsec = 1; int moveRepeated = 0; for (int i = 0; i <
		 * candidate.size(); i++) { if (candidate.get(i) == moveRepeated && i !=
		 * 0){
		 * 
		 * numConsec++; }else{ numConsec = 1; }
		 * 
		 * if(numConsec > 2){ sum += -1; } moveRepeated = candidate.get(i); }
		 */
		return sum;
	}

	/*
	 * Add points if move 2 is done back to back, but not more than that
	 * consecutively
	 */
	private int repeatMoveTwo(ArrayList<Integer> candidate) {
		int sum = 0;
		int numConsec = 0;
		for (int i = 0; i < candidate.size(); i++) {

			if (candidate.get(i) == (2 - 1)) {
				numConsec++;
			} else {
				numConsec = 0;
			}

			if (numConsec == 2) {
				sum += 2;
			} else if (numConsec > 2) {
				sum += -1;
			}

		}

		return sum;
	}

	/* Adds points if dance move pattern ABAB exists */
	private int repeatSequence(ArrayList<Integer> candidate) {
		int sum = 0;
		int numConsec = 1;
		int firstMoveRepeated = 0;
		int secondMoveRepeated = 0;
		for (int i = 0; i < candidate.size() - 1; i += 2) {
			if (candidate.get(i) == firstMoveRepeated
					&& candidate.get(i + 1) == secondMoveRepeated && i != 0) {
				numConsec++;
			} else {
				numConsec = 1;
			}

			if (numConsec == 2) {
				sum += 1;
			} else if (numConsec > 2) {
				sum += -1;
			}
			firstMoveRepeated = candidate.get(i);
			secondMoveRepeated = candidate.get(i + 1);
		}
		return sum;
	}
	
	/* Add points if the sequence has 3 or more moves equal to or above MEDIUM speed.
	 * Subtract points if the sequence has more than 10 FAST moves.*/
	private int varyingSpeed(ArrayList<Integer> candidate) {
		int sum = 0;
		int variedSpeed = 0;
		int fastMoves = 0;
		
		for (int i = 0; i < candidate.size(); i++) {
			Speed speed = moves.get(candidate.get(i)).speed;
			if (speed == Speed.MEDIUM) {
				variedSpeed++;
			} else if (speed == Speed.FAST) {
				variedSpeed++;
				fastMoves++;
			}
		}
		
		if (variedSpeed > 3) {
			sum += 1;
		} 
		if (fastMoves > 10) {
			sum += -1;
		}
		
		return sum;
	}
	
	/* Add points if the sequence uses multiple positions 
	 * Subtract points if the entire sequence is in one position*/
	private int varyinyPosition(ArrayList<Integer> candidate) {
		int sum = 0;
		int numPosStanding = 0;
		int numPosFloor = 0;
		int numPosMultiple = 0;
		
		for (int i = 0; i < candidate.size(); i++) {
			Position pos = moves.get(candidate.get(i)).position;
			if (pos == Position.STANDING) {
				numPosStanding++;
			} else if (pos == Position.FLOOR) {
				numPosFloor++;
			} else {
				numPosMultiple++;
			}
		}
		
		if (numPosMultiple > 3) {
			sum += 1;
		} else if (numPosStanding == candidate.size()) {
			sum += -1;
		} else if (numPosFloor == candidate.size()) {
			sum += -2;
		}
		
		return sum;
	}

}
