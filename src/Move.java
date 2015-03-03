
public class Move {
	public int transition;
	public int speed;
	public int position;
	public int numBodyPartsUsed;
	
	public Move(int transition, int speed, int position, int numBodyPartsUsed) {
		this.transition = transition;
		this.speed = speed;
		this.numBodyPartsUsed = numBodyPartsUsed;
		this.position = position;
	}	
}
