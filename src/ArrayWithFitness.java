import java.util.ArrayList;
import java.util.Comparator;


public class ArrayWithFitness implements Comparable<ArrayWithFitness> {
	public int fitness;
	public ArrayList<Integer> individual;
	
public ArrayWithFitness(int fitness,ArrayList<Integer> individual){
	this.fitness = fitness;
	this.individual = individual;
}

public ArrayWithFitness(ArrayList<Integer> individual){
	this.individual = individual;
}


public int compareTo(ArrayWithFitness compareObject) {
	 
	int compareQuantity = ((ArrayWithFitness) compareObject).fitness; 

	//descending order
	return compareQuantity - this.fitness;

}

}