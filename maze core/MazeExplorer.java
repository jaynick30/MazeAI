package maze.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import search.core.BestFirstObject;

public class MazeExplorer implements BestFirstObject<MazeExplorer> {
	private Maze m;
	private MazeCell location;
	private TreeSet<MazeCell> treasureFound; 
	private ArrayList<MazeCell> treasureDesired;
	
	public MazeExplorer(Maze m, MazeCell location) {
		this.m = m;
		this.location = location;
		treasureFound = new TreeSet<MazeCell>();
		treasureDesired = new ArrayList<MazeCell>();
		treasureDesired.addAll(m.getTreasures());
	}
	
	public MazeCell getLocation() {return location;}

	@Override
	public ArrayList<MazeExplorer> getSuccessors() {
		ArrayList<MazeExplorer> result = new ArrayList<MazeExplorer>();
		// TODO: It should add as a successor every adjacent, unblocked neighbor square.
				
		for(int i = 0; i < Direction.values().length; i++){
			if(!m.blocked(getLocation(), Direction.values()[i]) && m.within(Direction.values()[i].successor(getLocation()))){
				MazeCell cell = new MazeCell(Direction.values()[i].successor(getLocation()));
				
				MazeExplorer explorer = new MazeExplorer(m, cell);
				if(m.isTreasure(cell)){
					explorer.treasureFound.add(cell);
				}
				explorer.addTreasures(getTreasureFound());
				result.add(explorer);
			}
		}
		
		return result;
        
	}
	
	public ArrayList<MazeCell> getAllTreasure(){
		return treasureDesired;
	}
	
	public void addTreasures(Collection<MazeCell> treasures) {
		treasureFound.addAll(treasures);
	}
	
	public SortedSet<MazeCell> getTreasureFound() {
		return Collections.unmodifiableSortedSet(treasureFound);
	}
	
	public String toString() {
		StringBuilder treasures = new StringBuilder();
		for (MazeCell t: treasureFound) {
			treasures.append(";");
			treasures.append(t.toString());
		}
		return "@" + location.toString() + treasures.toString();
	}
	
	@Override
	public int hashCode() {return toString().hashCode();}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof MazeExplorer) {
			return achieves((MazeExplorer)other);
		} else {
			return false;
		}
	}

	@Override
	public boolean achieves(MazeExplorer goal) {
		return this.location.equals(goal.location) && this.treasureFound.equals(goal.treasureFound);
	}

}
