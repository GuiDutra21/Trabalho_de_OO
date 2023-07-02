package model;

public class Address {
	
	// ATRIBUTES
	
	private String country;
	private String state;
	private String city;
	private String street;
	private int number;

	// Construct
	public Address()
	{
		
	}
	
	public Address(String country, String state, String city, String street, int number) {
		this.setCountry(country);

		this.setState(state);

		this.setCity(city);

		this.setStreet(street);

		this.setNumber(number);
	}
	
	// GETTERS AND SETTERS

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet() {
		return street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setNumber(int number) {
		if (number >= 0) {
			this.number = number;
		} else {
			this.number = 0;
		}
	}

	public int getNumber() {
		return number;
	}

	///
	//method toString that returns the elements of an Address into a formated a String
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