package model;

public class Buildings extends Patrimony {
	
	private int floorsQtd;
	private double area;
	private	Address address;
	
	//Constructors
	
	public Buildings(String name, int amount, double value, int floorsQtd, double area, Address address) {
		super(name,amount,value); 
		this.floorsQtd = floorsQtd;
		this.area = area;
		this.address = address;
	}
	
	public Buildings(String name, int amount, double value, int floorsQtd, double area) {
		this(name, amount,value, floorsQtd, area, null);
	}
	
	public Buildings(String name, int amount, double value, int floorsQtd) {
		this(name, amount, value, floorsQtd, 0.0, null);
	}
	
	public Buildings(String name,int amount, double value) {
		this(name, amount, value, 0, 0.0, null);
	}
	
	public Buildings(String name, int amount) {
		this(name, amount,0.0, 0, 0.0, null);
	}
	
	public Buildings(String name, double value) {
		this(name, 1, value, 0, 0.0, null);
	}
	
	public Buildings(String name) {
		this(name, 1, 0.0, 0, 0.0, null);
	}
	
	//Getters and Setters
	
	public int getFloorsQtd() {
		return floorsQtd;
	}

	public void setFloorsQtd(int floorsQtd) {
	
		if(floorsQtd > 0){
			this.floorsQtd = floorsQtd;
		}
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		if(area > 0)
		{
			this.area = area;
		}
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		if(address != null) {
			this.address = address;
		}
	}
	
	//Methods
	
	public void edit(int floorsQtd)
	{
		setFloorsQtd(floorsQtd);
	}
	
	public void edit(double area)
	{
		setArea(area);
	}
	
	public void edit(Address address)
	{
		setAddress(address);
	}
	
	public void edit(int foorsQtd,double area )
	{
		setFloorsQtd(floorsQtd);
		setArea(area);
	}
	
	public void edit(int foorsQtd,double area, Address address)
	{
		setFloorsQtd(floorsQtd);
		setArea(area);
		setAddress(address);
	}
	
	public String toString()
	{
		String buildings = String.format("Nome: %s,\nUnidades: %d,\nValor unitario: %.2f,\n"
				+ "Quantidade de Andares : %d,\nMetros Quadrados : %2.f,\n"
				+ "Endereco : %s",getName(),getAmount(),getValue(),getFloorsQtd(),getArea(),getAddress());
		return buildings;
	}
	
}	
