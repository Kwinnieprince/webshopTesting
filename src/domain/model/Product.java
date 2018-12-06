package domain.model;

public class Product {
	private int productId;
	private String name;
	private String description;
	private double price;
	
	public Product() {
		
	}
	
	public Product(int productId, String name, String description, double d) {
		setProductId(productId);
		setName(name);
		setDescription(description);
		setPrice(d);
	}
	public Product(String name, String description, double d) {
		setName(name);
		setDescription(description);
		setPrice(d);
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.isEmpty()) {
			throw new DomainException("No name given");
		}
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if (description.isEmpty()) {
			throw new DomainException("No description given");
		}
		
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if (price<0.01) {
			throw new DomainException("Give a valid price");
		}else if (price >= Double.MAX_VALUE){
			throw new DomainException("But why?");
		}
		this.price = price;
	}
	public void setPrice(String price) {
		if (price.isEmpty()) {
			throw new DomainException("No price given");
		}
		setPrice(Double.valueOf(price));
	}
	
	@Override
	public String toString(){
		return getName() + ": " + getDescription() + " - " + getPrice();
	}

	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(o instanceof Product) {
			Product p = (Product) o;
			if(p.productId == this.productId) return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.productId;
	}
}
