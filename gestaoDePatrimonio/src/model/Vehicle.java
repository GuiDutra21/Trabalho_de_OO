package model;

public class Vehicle extends Patrimony{
	private String model;
	private String brand;
	private int productionYear;
	
	// Constructs
	
	public Vehicle(String name, int amount, double value, String model, String brand, int productionYear) {
		super(name, amount, value);
		
		if(model == null || model.equals("")) {
			this.model = "Nao informado";
		} else {
			this.model = model;
		}
		
		if(brand == null || brand.equals("")) {
			this.brand = "Nao informado";
		} else {
			this.brand = model;
		}
	
		if(productionYear >= 0) {
			this.productionYear = productionYear;
		} else {
			this.productionYear = 0;
		}
		
	}
	
	public Vehicle(String name, double value) {
		this(name,0,value,null,null,0);
	}
	
	public Vehicle(String name) {
		this(name,0,0.0,null,null,0);
	}
	
	public Vehicle(String name, int amount) {
		this(name, amount,0.0,null,null,0);
	}
	
	public Vehicle(String name, int amount, double value) {
		this(name, amount, value,null,null,0);
		
	}
	
	public Vehicle(String name, int amount, double value, String model) {
		this(name, amount, value,model,null,0);
	}
	
	public Vehicle(String name, int amount, double value, String model,String brand) {
		this(name, amount, value,model,brand,0);
	}
	
	
	//////////////////////////////////////////////////////
	
	// Setters e getters
	
	public void setModel(String model) {
		if(model == null || model.equals("")) {
			this.model = "Nao informado";
		} else {
			this.model = model;
		}
	}
	
	public String getModel() {
		return model;
	}
	
	public void setBrand(String brand) {
		if(brand == null || brand.equals("")) {
			this.brand = "Nao informado";
		} else {
			this.brand = brand;
		}
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setProductionYear(int productionYear) {
		if(productionYear > 1800 ) {
			this.productionYear = productionYear;
		}
	}
	
	public int getProductionYear() {
		return productionYear;
	}
	///////////////////////////////////////////////////////////
	
	public void editModel(String model)
	{
		setModel(model);
	}
	
	public void editBrand(String brand)
	{
		setBrand(brand);
	}
	
	public void editProductionYear(int productionYear)
	{
		setProductionYear(productionYear);
	}
	
	public String toString()
	{
		String vehicle = String.format("Nome: %s,\nUnidades: %d,\nValor unitario: %.2f,\n"
				+ "Marca : %s,\nModelo : %s,\n"
				+ "Ano de Producao : %d",this.getName(),getAmount(),getValue(), getBrand(), getModel(),getProductionYear());
		return vehicle;
	}
	
	
	
	
}