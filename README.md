# Dance-Evolutionary-algorithm
Zackery Leman and Ivy Xing
 
The majority of the code ( besides the fitness function) was taken from the other Evolutionary Algorithm found in this repository and modified to work with this fitness function to evaluate dance sequences.

The following is a comprehensive readme:
 
1. Introduction
 
The goal of this algorithm was to create a fitness function that evaluated different sequences of dance moves. We started with a population of random sequences and evolved those sequences through a genetic algorithm to produce new sequences that may be considered better. We used a rule-based point system for our fitness function. Each rule represents a pattern we observed that contributes to whether we like or dislike a sequence. Judging by how much the pattern contributed to our conclusion, we then add/subtract certain number of points to/from sequences that follow such pattern.
 
 
2. Parameters
 
2.1: General Description
 
The parameters we chose are speed, position, and transition. Speed represents the average speed of the move; it has values “slow,” “medium,” and “fast.” Position represents the dancer’s body position; it has values “standing,” “floor, and “multiple.” Transition represents the change in position; it has values “down movement,” (mostly downward movements) “down transition” (dancer changes from upward movements to downward movements) “up movement” (mostly upward movements), and “up transition” (dancer changes from downward movements to upward movements).
 
2.2: Differences and Correlations Between Position and Transition
 
Note that the position parameter and the transition parameter consider two fundamentally different aspects of movement. Position describes the static space the body spans at different points in time; whereas transition attempts to address the overall “feeling,” or the dynamic and flow of movement as position continues to change over time.
 
Although these two parameters differ in nature, they are related in many ways. For example, most upward movements are associated with the standing position. Intuitively, standing allows more freedom for bodily expressions and thus may inspire movements that reach or expand upward. Another example is that most transitional movements are associated with multiple positions. Yet, since position and transition address different aspects of movement as aforementioned, there are of course exceptions to the general associations. For example, a move that mostly assumes a standing position and briefly concludes with a squatting position may only be categorized as “standing,” but it is by our definition a “down transition,” because it moves from higher space to lower space and thus allows a smooth transition to a move in floor position.  
 
2.3: Conclusion on Choice of Parameters
 
After observing and discussing various dance sequences, we learned that flow of movement and repetition of certain motions mostly determined whether we liked a sequence. Although there are many other factors such as energy and space that influence our perception of movement, we chose parameters in a way such that only the most important factors will be considered. The position and the transition parameters directly address flow and motion, and the speed parameter takes into account the overall dynamic of the sequence.  
 
 
3. Fitness Function
 
3.1: Diversity of Moves
 
We consider how many kinds of moves are involved in this sequence. We find that incorporating different dance moves usually makes the sequence more interesting.
	a. Positive rule:
    	-  If 9 or more moves are involved add 2 points.
	b. Negative rule:
    	-  If fewer than 9 moves are involved, subtract 1 point.
 
3.2: Smooth Transition
 
This is the MVP of the fitness function. It takes full advantage of the transition parameter and awards smooth flow of movement (and penalizes the lack thereof).
	a. Positive rules:
    	- If a “down move” follows a “down transition,” add 3 points.
    	- If an “up transition” follows a “down transition,” add 1 point.
    	- If an “up move” follows an “up transition,” add 2 points.
    	- If a “down transition” follows an “up transition,” add 1 point.
	b. Negative rules:
    	- If an “up move” follows a “down transition,” subtract 2 points.
    	- If a “down move” follows an “up transition,” subtract 2 points.
 
3.3: General Move Repetition
 
We find that if any move is repeated too many times, it makes the sequence less interesting.
	a. Negative rule:
    	- If a move is repeated more than twice, subtract 1 point for each time it is repeated after the second time.
 
3.4: Specific Move Repetition
 
We like it when dance move #2 is repeated exactly twice but not more than twice.
	a. Positive rule:
    	- If move #2 is repeated exactly twice, add 3 points.
	b. Negative rule:
    	- If move #2 is repeated more than twice, subtract 1 point for each time it is repeated after the second time.

 
3.5: Sequence of Move Repetition
 
We find that the repetition pattern ABAB makes the sequence more impressionable, though any further repetition may make the sequence less interesting.
	a. Positive rule:
    	- If consecutive moves repeat exactly once (ABAB), add 1 point.
	b. Negative rule:
    	- If consecutive moves repeat more times (ABABAB…), subtract 1 point.
 
3.6: Speed Variation
 
We find that if almost all the moves in the sequence are slow or if almost all of them are fast, the sequence is not as interesting as if it were to contain a combination of slow and fast movements.
	a. Positive rule:
    	-  If more than 3 moves have medium or fast speed, add 1 point.
	b. Negative rules:
    	- If more than 18 moves have slow speed, subtract 1 point.
  	 - If more than 18 moves have fast speed, subtract 1 point.
 
3.7: Position
 
The sequence becomes more interesting when positions vary. After all, we cannot have any up or down transition if the entire sequence is completed in one position (for example, standing).
	a. Positive rule:
    	- If more than 3 moves use multiple positions, add 1 point.
	b. Negative rules:
    	- If all moves are in standing position, subtract 1 point.
    	- If all moves are in floor position, subtract 2 points.

3.8: Parameter Settings

We initially ran our algorithm with the rule of thumb settings, but decided to make a couple of modifications. We ran the algorithm with a population of 400 to start with some more diversity, used Boltzmann selection with one-point crossover with a probability of 0.7, and a higher mutation probability of 0.1 for 2000 iterations. We picked 0.1 for mutation because we wanted to create a lot of diversity so that many different combinations of moves could be evaluated. We picked 2000 iterations because we thought it was enough iterations to find the most fit sequence. We also did not expect to see the fitness of any new individual created after 2000 iterations  to really surpass the currently found individual with maximum fitness, so we did not feel that it needed to run for a longer time.

4. Conclusion
 
4.1: Observations
 
Taking into account the array (!) of characteristics that influence how much we like each sequence, we conclude that we tend to like sequences that incorporate a variety of elements (body position, speed, transition, etc.) and have a small number of repetitions. We tend to dislike sequences that repeat any element too many times.
 
4.2: Results
 
 We picked the best two sequences and the worst two.
 
Best:
[16, 3, 10, 9, 10, 9, 14, 11, 9, 15, 9, 15, 13, 15, 2, 2, 4, 18, 4, 18]
[3, 10, 3, 10, 13, 15, 13, 15, 13, 14, 3, 14, 3, 14, 9, 14, 9, 14, 4, 2]
 
Worst:
[15, 4, 6, 11, 4, 2, 7, 17, 14, 19, 12, 1, 4, 1, 17, 19, 4, 2, 10, 17]
[12, 5, 17, 14, 14, 11, 18, 19, 3, 15, 4, 18, 4, 2, 1, 14, 15, 18, 6, 11]
 

The Fitness Function can be found in the evaluateCandidate function in the  EvolAlgorithms.java file.
