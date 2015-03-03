import java.util.ArrayList;

//Store Results for Averaging
public class Results {
	
	public String algorithm;
	public long executionTime;
	public int[] assignment;
	public int bestgeneration;

	// Constructor.
	public Results(String algorithm, long executionTime, int[] assignment, int bestgeneration) {
		this.algorithm = algorithm;
		this.executionTime = executionTime;
		this.assignment = assignment;
		this.bestgeneration = bestgeneration;
	}
}
