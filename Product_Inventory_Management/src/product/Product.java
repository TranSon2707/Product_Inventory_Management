package product;

public abstract class Product {

    private int id;	// id can be String or integer with 3-4 digits (I am leaning towards integers)
    private String name;
    private double sellingPrice;
    private double purchasePrice;
    private int quantity;
    private double profit;
    
    Product(int id, String name, double sellingPrice, double purchasePrice, int quantity){
    	this.id = id;
    	this.name = name;
    	this.sellingPrice = sellingPrice;
    	this.purchasePrice = purchasePrice;
    	this.quantity = quantity;
    	this.profit = this.sellingPrice - this.purchasePrice;
    }

    
    
    //Product getter methods
    public int getId() {
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
    public void setId(int newId) {
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
