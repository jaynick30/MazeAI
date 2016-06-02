package maze.heuristics;

import search.core.BestFirstHeuristic;
import maze.core.MazeExplorer;

//Non-Monotonic
public class GreedyTreasure implements BestFirstHeuristic<MazeExplorer>  {

	 public int getDistance(MazeExplorer node, MazeExplorer goal) {
	    	int closest = 0;
	    	
	    	node.getAllTreasure().removeAll(node.getTreasureFound());
	    	
	    	if(node.getAllTreasure().size() > 0){
	    		for(int i = 0; i < node.getAllTreasure().size()-1; i ++){
	    			closest = Math.min(node.getAllTreasure().get(i).getManhattanDist(node.getLocation()), node.getAllTreasure().get(i+1).getManhattanDist(node.getLocation()));
	    		}
	    	
	    	}
	    	return closest;
	    }
}
