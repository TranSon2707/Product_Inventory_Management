package product;

public abstract class Product {

	public String category;
	
    private String id;	// id can be String or integer with 3-4 digits (I am leaning towards integers)
    private String name;
    private double sellingPrice;
    private double purchasePrice;
    private int quantity;
    private double profit;

    Product(String id, String name, double sellingPrice, double purchasePrice, int quantity){
    	this.id = id;
    	this.name = name;
    	this.sellingPrice = sellingPrice;
    	this.purchasePrice = purchasePrice;
    	this.quantity = quantity;
    	this.profit = this.sellingPrice - this.purchasePrice;
    }

    Product(Product otherProduct){
    	this.copy(otherProduct);
    }

	public Product() {
		super();
	}

	public void copy(Product otherProduct) {
		this.setId(otherProduct.getId());
		this.setName(otherProduct.getName());
		this.setSellingPrice(otherProduct.getSellingPrice());
		this.setPurchasePrice(otherProduct.getPurchasePrice());
		this.setQuantity(otherProduct.getQuantity());
    }

	public boolean isEqual(Product otherProduct) {
		if (this.getId().equals(otherProduct.getId())  && this.category.equals(otherProduct.category) && this.getName().equals(otherProduct.getName())) {
			return true;
		}
		else {
			return false;
		}
	}

	public void addProduct(Product otherProduct) {
		if (this.isEqual(otherProduct)) {
			this.quantity = this.quantity + otherProduct.quantity;
		}
	}

    //Product getter methods
    public String getId() {
    	return this.id;
    }
    public String getName() {
    	return this.name;
    }
    public double getSellingPrice() {
    	return this.sellingPrice;
    }
    public double getPurchasePrice() {
    	return this.purchasePrice;
    }
    public int getQuantity() {
    	return this.quantity;
    }
    public double getProfit() {
    	return this.profit;
    }

    //Product setter methods
    public void setId(String newId) {
    	this.id = newId;
    }
    public void setName(String newName) {
    	this.name = newName;
    }
    public void setSellingPrice(double newSellingPrice) {
    	this.sellingPrice = newSellingPrice;
    	this.profit = this.sellingPrice - this.purchasePrice;
    }
    public void setPurchasePrice(double newPurchasePrice) {
    	this.purchasePrice = newPurchasePrice;
    	this.profit = this.sellingPrice - this.purchasePrice;
    }
    public void setQuantity(int newQuantity) {
    	this.quantity = newQuantity;
    }

}
