package maze.heuristics;

import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;

//Monotonic
public class ManhattanTreasure implements BestFirstHeuristic<MazeExplorer> {
    public int getDistance(MazeExplorer node, MazeExplorer goal) {
    	int manhattanDistance = node.getLocation().getManhattanDist(goal.getLocation());
    	
    	int furthest = 0;
    	
    	node.getAllTreasure().removeAll(node.getTreasureFound());
    	
    	for(int i = 0; i < node.getAllTreasure().size()-1; i ++){
    		furthest = Math.max(node.getAllTreasure().get(i).getManhattanDist(goal.getLocation()), node.getAllTreasure().get(i+1).getManhattanDist(goal.getLocation()));
    	}
    	
    	return manhattanDistance + furthest;
    }
}
