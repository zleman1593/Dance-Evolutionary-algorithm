
public class Move {
	

	
	
	public Transition transition;
	public Speed speed;
	public Position position;
	public int[] numBodyPartsUsed;
	
	public Move(Transition transition, Speed speed, Position position, int[] numBodyPartsUsed) {
		this.transition = transition;
		this.speed = speed;
		this.numBodyPartsUsed = numBodyPartsUsed;
		this.position = position;
	}	
}
