package maze.heuristics;

import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;


//Monotonic
public class MazeSweeper implements BestFirstHeuristic<MazeExplorer> {
	
	public int getDistance(MazeExplorer node, MazeExplorer goal) {
    	int closest = 0;
    	
    	node.getAllTreasure().removeAll(node.getTreasureFound());
    	
    	for(int i = 0; i < node.getAllTreasure().size()-1; i ++){
    		closest = Math.min(node.getAllTreasure().get(i).getManhattanDist(node.getLocation()), node.getAllTreasure().get(i+1).getManhattanDist(node.getLocation()));
    	}
    	
    	int manhattan = node.getLocation().getManhattanDist(goal.getLocation());
    	
    	
    	return closest + manhattan;
    }

}
