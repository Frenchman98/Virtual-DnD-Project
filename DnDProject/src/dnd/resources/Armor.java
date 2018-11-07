package dnd.resources;

public class Armor extends Resource
{
	private Integer protectionPoints;
	private String locationCovered;
	
	public Armor()
	{
		protectionPoints = null;
		locationCovered = "";
	}
	
	public Armor(Integer price, Integer protPoints, String name, String locCovered)
	{
		super(price, name);
		protectionPoints = protPoints;
		locationCovered = locCovered;
	}
	
	public Integer getProtectionPoints() {
		return protectionPoints;
	}
	public void setProtectionPoints(Integer protectionPoints) {
		this.protectionPoints = protectionPoints;
	}
	public String getLocationCovered() {
		return locationCovered;
	}
	public void setLocationCovered(String locationCovered) {
		this.locationCovered = locationCovered;
	}
	
	
}