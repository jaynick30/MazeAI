package maze.heuristics;

import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;

public class Manhattan implements BestFirstHeuristic<MazeExplorer>{
	public int getDistance(MazeExplorer node, MazeExplorer goal) {
		int manhattanDistance = goal.getLocation().getManhattanDist(node.getLocation());
		
        return manhattanDistance;
	}

}
