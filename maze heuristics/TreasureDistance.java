package maze.heuristics;


import maze.core.MazeCell;
import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;

//Non-Monotonic
public class TreasureDistance implements BestFirstHeuristic<MazeExplorer> {
	
    public int getDistance(MazeExplorer node, MazeExplorer goal) {
    	int furthest = 0;
    	
    	node.getAllTreasure().removeAll(node.getTreasureFound());
    	
    	for(int i = 0; i < node.getAllTreasure().size()-1; i ++){
    		furthest = Math.max(node.getAllTreasure().get(i).getManhattanDist(goal.getLocation()), node.getAllTreasure().get(i+1).getManhattanDist(node.getLocation()));
    	}
    	
    	
    	return (furthest);
    }
}
