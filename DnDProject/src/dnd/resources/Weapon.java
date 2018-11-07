package dnd.resources;

public class Weapon extends Resource
{
	private Integer Damage;
	private String Type;
	
	public Weapon()
	{
		Damage = null;
		Type = "";
	}
	
	public Weapon(Integer price, Integer damage, String name, String type)
	{
		super(price, name);
		Damage = damage;
		Type = type;
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