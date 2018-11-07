package dnd.resources;

public class Armor extends Resource
{
	private Integer protectionPoints;
	private String locationCovered;
	
	Armor()
	{
		protectionPoints = null;
		locationCovered = "";
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