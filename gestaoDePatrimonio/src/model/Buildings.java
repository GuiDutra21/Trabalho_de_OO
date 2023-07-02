package model;


/**
 * Classe Buildings que simula o comportamento de uma propriedade e herda da classe Patrimony.
 * @author Guilherme Silva Dutra and Julio Roberto
 * @since 2023
 * @version 1.1
 */
public class Buildings extends Patrimony {
	
	
	private int floorsQtd;
	private double area;
	/**
	 * Uma propriedade possui logicamente um endereço
	 */
	private	Address address;
	
	//Constructors
	
	/**
	 * Contrutor principal que atribui valor a todos os atributos
	 * @param name Nome da propriedade
	 * @param amount Quantidade da respectiva Propriedade
	 * @param value Valor
	 * @param floorsQtd Quantidade de Andares 
	 * @param area Metros quadrados 
	 * @param Address Endereço
	 */
	public Buildings(String name, int amount, double value, int floorsQtd, double area, Address address) {
		super(name,amount,value); 
		this.floorsQtd = floorsQtd;
		this.area = area;
		this.address = address;
	}
	
	/**
	 * Sobrescrita do Construtor que atribui os valores dos parametros para os respectivos atributos name, amount, value, floorsQtd, area
	 * Para o atributo Address o valor foi definido como nulo
	 * @param name Nome da propriedade
	 * @param amount Quantidade da respectiva propriedade
	 * @param value Valor
	 * @param floorsQtd Quantidade de Andares
	 * @param area Mtros quadrados 
	 */
	public Buildings(String name, int amount, double value, int floorsQtd, double area) {
		this(name, amount,value, floorsQtd, area, null);
	}
	
	/*
	 * Sobrescrita do Construtor que atribui os valores dos parametros para os respectivos atributos name, amount, value, floorsQtd
	 * Para o atributo Area o valor for definido como 0
	 * Para o atributo Address o valor foi definido como nulo
	 * @param name Nome da propriedade
	 * @param amount Quantidade da  respectiva propriedade
	 * @param value Valor
	 * @param floorsQtd Quantidade de Andares 
	 */
	public Buildings(String name, int amount, double value, int floorsQtd) {
		this(name, amount, value, floorsQtd, 0.0, null);
	}
	
	/*
	 * Sobrescrita do Construtor que atribui os valores dos parametros para os respectivos atributos name, amount, value
	 * Para o atributo Area o valor for definido como 0
	 * Para o atributo floorsQtd o valor foi definido como 0
	 * Para o atributo Address o valor foi definido como nulo
	 * @param name Nome da propriedade
	 * @param amount Quantidade da respectiva Propriedade
	 * @param value Valor
	 */
	public Buildings(String name,int amount, double value) {
		this(name, amount, value, 0, 0.0, null);
	}
	
	/**
	 * Sobrescrita do Construtor que atribui os valores dos parametros para os respectivos atributos name, amount
	 * Para o atributo Area o valor for definido como 0
	 * Para o atributo floorsQtd o valor foi definido como 0
	 * Para o atributo value o valor foi definido como 0
	 * Para o atributo Address o valor foi definido como nulo
	 * @param name Nome da propriedade
	 * @param amount Quantidade da respectiva Propriedade
	 */
	public Buildings(String name, int amount) {
		this(name, amount,0.0, 0, 0.0, null);
	}
	
	/**
	 * Sobrescrita do Construtor que atribui os valores dos parametros para os respectivos atributos name, value
	 * Para o atributo Area o valor for definido como 0
	 * Para o atributo floorsQtd o valor foi definido como 0
	 * Para o atributo amount o valor foi definido como 1, pois não faria snetido criar uma prorpiedade que não tenha quantidade
	 * Para o atributo Address o valor foi definido como nulo
	 * @param name Nome da propriedade
	 * @param value valor
	 */
	public Buildings(String name, double value) {
		this(name, 1, value, 0, 0.0, null);
	}
	
	/**
	 * Sobrescrita do Construtor que atribui o valor do parametro para o respectivo atributo name
	 * Para o atributo Area o valor for definido como 0
	 * Para o atributo floorsQtd o valor foi definido como 0
	 * Para o atributo value o valor foi definido como 0
	 * Para o atributo amount o valor foi definido como 1, pois não faria snetido criar uma prorpiedade que não tenha quantidade
	 * Para o atributo Address o valor foi definido como nulo
	 * @param name Nome
	 */
	public Buildings(String name) {
		this(name, 1, 0.0, 0, 0.0, null);
	}
	
	//Getters and Setters

	public int getFloorsQtd() {
		return floorsQtd;
	}
	
	/**
	 * Atribui valor para o atributo floorsQtd apenas se ele for maior do que 0
	 * @param floorsQtd Quantidade de andares
	 */
	public void setFloorsQtd(int floorsQtd) {
	
		if(floorsQtd > 0){
			this.floorsQtd = floorsQtd;
		}
	}
	

	public double getArea() {
		return area;
	}
	
	/**
	 * Atribui valor para o atributo area apenas se ele for maior do que 0
	 *  * @param area Metros quadrados
	 */
	public void setArea(double area) {
		if(area > 0)
		{
			this.area = area;
		}
	}
	

	public Address getAddress() {
		return address;
	}
	
	/**
	 * Atribui valor para o atributo address caso ele não seja diferente de nulo
	 * @param address Endereço
	 */
	public void setAddress(Address address) {
		if(address != null) {
			this.address = address;
	}
	}
	
	//Methods
	
	/**
	 * Método que edita a quantidade de andares
	 * @param floorsQtd quanitdade de andares
	 */
	public void edit(int floorsQtd)
	{
		setFloorsQtd(floorsQtd);
	}
	
	/**
	 * Método que altera a quantidade de Metros quadrados
	 * @param area quantidade de metros quadrados
	 */
	public void edit(double area)
	{
		setArea(area);
	}
	
	/**
	 * Método que altera o Endereço
	 * @param address Endereço
	 */
	public void edit(Address address)
	{
		setAddress(address);
	}
	
	/**
	 * Método que altera a quantidade de andares e a quantidade de metros quadrados
	 * @param floorsQtd quantidade de andares
	 * @param area quantidade de metros quadrados
	 */
	public void edit(int foorsQtd,double area )
	{
		setFloorsQtd(floorsQtd);
		setArea(area);
	}
	
	/**
	 * Método que altera a quanitdade de andares, a quantidade de area e o Endereço
	 * @param floorsQtd quantidade de andares
	 * @param area quantidade de metros quadrados
	 * @param address Endereço
	 */
	public void edit(int foorsQtd,double area, Address address)
	{
		setFloorsQtd(floorsQtd);
		setArea(area);
		setAddress(address);
	}
	
	/**
	 * Sobrescrita do método toString() das classe Object e Buildings. 
	 * Constroi uma String contendo os valores de todos os atributos da classe Buildings separados por ponto e vírgula
	 * @return String
	 */
	public String toString()
	{
		String buildings = String.format("Nome: %s,\nUnidades: %d,\nValor unitario: %.2f,\n"
				+ "Quantidade de Andares : %d,\nMetros Quadrados : %2.f,\n"
				+ "Endereco : %s",getName(),getAmount(),getValue(),getFloorsQtd(),getArea(),getAddress());
		return buildings;
	}
	
}	