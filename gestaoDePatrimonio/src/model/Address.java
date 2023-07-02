package model;

/**
 * Classe Address simula o endereço de imoveis e empresas.
 * @author Julio Roberto e Guilherme Silva
 * @since 2023
 * @version 1.1
 * 
 */

public class Address {
	
	// ATRIBUTES
	
	private String country;
	private String state;
	private String city;
	private String street;
	private int number;

	// Construct
	
	/**
	 *Constroi um endereço sem atribuir valor aos atributos da classe 
	 *
	 */
	public Address()
	{
		
	}
	
	/**
	 * Constroi um endereço e atribui valor a todos os atributos da classe
	 * 
	 * @param country Nome do pais
	 * @param state Nome do estado
	 * @param city Nome da cidade
	 * @param street Nome da rua
	 * @param number Numero da rua 
	 */
	
	public Address(String country, String state, String city, String street, int number) {
		this.setCountry(country);

		this.setState(state);

		this.setCity(city);

		this.setStreet(street);

		this.setNumber(number);
	}
	
	// GETTERS AND SETTERS
	
	/**
	 * Atualiza o atributo country
	 * @param country Nome do país
	 */
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Retorna o atributo country
	 * @return String
	 */

	public String getCountry() {
		return this.country;
	}
	
	/**
	 * Atualiza o atributo state
	 * @param state Nome do estado
	 */

	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Retorna o atributo state
	 * @return String
	 */

	public String getState() {
		return this.state;
	}
	
	/**
	 * Atualiza o atributo street
	 * @param street Nome da Rua
	 */

	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Retorna o atributo street
	 * @return String
	 */

	public String getStreet() {
		return street;
	}
	
	/**
	 * Atualiza o atributo city
	 * @param city Nome da cidade
	 */

	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Retorna o atributo city
	 * @return String
	 */

	public String getCity() {
		return city;
	}
	
	/**
	 * Atualiza o atributo number. Caso tente inserir um valor negativo, number recebe
	 * o valor zero
	 * @param number Numero da rua
	 */

	public void setNumber(int number) {
		if (number >= 0) {
			this.number = number;
		} else {
			this.number = 0;
		}
	}
	
	/**
	 * Retorna o atributo number.
	 * @return int
	 */

	public int getNumber() {
		return number;
	}

	///
	//method toString that returns the elements of an Address into a formated a String
	
	/**
	 * Sobrescreve o metodo toString() da classe Object. Constroi uma String com os valores
	 * das variaveis da classe Address
 	 * @return String
	 */
	public String toString() {
		String address = "";
		boolean country_Ok = (getCountry().isEmpty() ? false : true);
		boolean state_Ok = (getState().isEmpty() ? false : true);
		boolean city_Ok = (getCity().isEmpty() ? false : true);
		boolean street_Ok = (getStreet().isEmpty() ? false : true);
		
		boolean[] b = {country_Ok,state_Ok,city_Ok,street_Ok};
		String[] g = {getCountry(), getState() ,getCity(), getStreet()};
		int contador = 0;
		int contadorN = 0;
		
		for(int i = 0; i < 4; i ++) {
			
			
			if(b[i]) {
				contador++;
				if(contador == 1) {
					address = address.concat(g[i]);
				
				} else if(i < 3 && i >  0){
					address = address.concat(String.format("; %s",g[i]));
				} else if(b[3] == true) {
					address = address.concat(String.format("; %s; %d",g[i], getNumber()));
				} 
			}
			
			if(b[i] == false) {
				contadorN++;
				if(contadorN == 4) {
					address = "Nao informado";
				}
			}
		
		}
		
		
		return address;
	}	
	
	
}