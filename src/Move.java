
public class Move {
	public Transition transition;
	public Speed speed;
	public Position position;
	
	public Move(Transition transition, Speed speed, Position position) {
		this.transition = transition;
		this.speed = speed;
		this.position = position;
	}	
}
