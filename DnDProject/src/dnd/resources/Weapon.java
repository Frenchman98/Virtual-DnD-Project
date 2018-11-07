package dnd.resources;

public class Weapon extends Resource
{
	private Integer Damage;
	private String Type;
	
	Weapon()
	{
		Damage = null;
		Type = "";
	}
	
	public Integer getDamage() {
		return Damage;
	}
	public void setDamage(Integer damage) {
		Damage = damage;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
}