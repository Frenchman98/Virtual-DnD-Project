package dnd.resources;

public class Resource 
{
	private Integer Price;
	private String Name; 
	
	public Resource()
	{
		Price = null;
		Name = "";
	}
	
	public Resource(Integer price, String name)
	{
		Price = price;
		Name = name;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
}