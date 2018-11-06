package dnd.skills;

import java.util.*;

public class Skill {
	
	private int Points;
	private String Name;
	private String Type;
	
	public Skill() {
		Points = 0;
		Name = "unknown";
		Type = "unknown";
	}
	
	public Skill(String name, String type, int points) {
		Points = points;
		Name = name;
		Type = type;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public String getType() {
		return this.Type;
	}
	
	public int getPoints() {
		return this.Points;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public void setType(String type) {
		this.Type = type;
	}
	
	public void setPoints(int points) {
		this.Points = points;
	}
	
}