package model;

/**
 * Classe abstrata Enterprises que simula o comportamento de um empresa genérica.
 * @author Guilherme Silva Dutra and Julio ROberto
 * @Since 2023
 * @version 1.1
 */
public abstract class Enterprises{
	
	// ATRIBUTES
	private String name;
	private Address address;

	// GETTERS AND SETTERS

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAddress(Address adress) {
		this.address = adress;
	}

	public Address getAddress() {
		return address;
	}
	
	//Methods
	
	/**
	 * Método que edita o nome 
	 * @param name Nome
	 */
	public void edit(String name) {
		setName(name);
	}
	
	/**
	 * Método que edita o Endereço 
	 * @param address Endereço
	 */
	public void edit(Address adress) {
		setAddress(adress);
	}
	/**
	 * Método que edita o nome e o Endereço
	 * @param name Nome
	 * @param address Endereço
	 */
	public void edit(String name, Address address) {
		setAddress(address);
		setName(name);
	}
	
}