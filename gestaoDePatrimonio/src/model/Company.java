package model;

import java.util.List;
import java.util.ArrayList;

public class Company extends Enterprises {
	
	// ATRIBUTES
	
	private List<Filial> filials;
	
	//Constructors
	public Company(String name, Address adress) {
		this.setName(name);
		this.setAddress(adress);
		setFilials(new ArrayList<Filial>());
	}
	
	public Company(String name) {
		this(name, null);
	}

	// GETTERS AND SETTERS
	
	public void setFilials(ArrayList<Filial> filials) {
		this.filials = filials;
	}
	
	public List<Filial> getFilials() {
		return filials;
	}

	public int getAmount() {
		return getFilials().size();
	}
	
	public double getValue() {
		double value = 0.0;
		
		for(int i = 0; i < getFilials().size(); i++) {
			for(int j = 0; j < getFilials().get(i).getPatrimony().size(); j++) {
				value += getFilials().get(i).getPatrimony().get(j).getValue() * 
						getFilials().get(i).getPatrimony().get(j).getAmount() ;
			}
		}
		
		return value;
	}

	public boolean addFilial(Filial filial) {
		boolean verifica = false;
		if(getFilials().size() == 0 && filial.getName().isEmpty() == false) {
			
			getFilials().add(filial);
			verifica = true;
			
		} else {
			for(int i = 0; i < getFilials().size(); i++) {
				if(getFilials().get(i).getName().toLowerCase().equals(filial.getName().toLowerCase())) {
					return verifica;
				} else if (i == getFilials().size() - 1 && filial.getName().isEmpty() == false) {
					getFilials().add(filial);
					verifica  = true;
					return true;
				}
			}
		}

		return verifica;
		
	}
	
	//Methods
	
	//Create a Filial name with all arguments
	public boolean createFilial(String name, Address address) {
		boolean verifica = false;
		
		if(getFilials().size() == 0 && (name.isEmpty() == false)) {
			filials.add(new Filial(name, address));
			verifica = true;
			
		} else if(name.isEmpty() == false) {
			
			for(int i = 0; i < getFilials().size(); i++) {
				if(getFilials().get(i).getName().toLowerCase().equals(name.toLowerCase())) {
					return verifica;
				} else if(i == getFilials().size() - 1){
					filials.add(new Filial(name, address));
					verifica  = true;
					return true;
				}
			}
			
		}
		
		return verifica;
		
	}
	
	//Create a Filial only with a name
	public boolean createFilial(String name) {
		boolean verifica = false;
		
		if(getFilials().size() != 0 && (name.isEmpty() == false)) {
			for(int i = 0; i < getFilials().size(); i++) {
				if(getFilials().get(i).getName().toLowerCase().equals(name.toLowerCase())) {
					return verifica;
			}	else if(i == getFilials().size() - 1){
					filials.add(new Filial(name));
					verifica  = true;
					return true;
				}
			}
		} else if(name.isEmpty() == false) {
			
			filials.add(new Filial(name));
			verifica = true;
			return true;
			
		}
		
		return verifica;
		
	}

	//Add in a Filial a Patrimony
	public boolean add(String filialName, Patrimony patrimony) { 
		boolean verifica = false;
		for(int i = 0; i < getFilials().size(); i++) {
			if(getFilials().get(i).getName().equals(filialName)) {
				verifica = getFilials().get(i).add(patrimony);
				return verifica;
			}
		}
		return verifica;
	}

	//Edit the name of a Filial
	public boolean editFilial(String oldName, String newName) {
		boolean verifica = false;
		for(int i = 0; i < getFilials().size(); i++) {
			if(getFilials().get(i).getName().toLowerCase().equals(newName.toLowerCase())) {
				
				return false;
				
			} else if(i == getFilials().size() - 1 && (newName.isEmpty() == false)) {
				
				for(int j = 0; j < getFilials().size(); j++) {
					if(getFilials().get(j).getName().toLowerCase().equals(oldName.toLowerCase())) {
						getFilials().get(j).edit(newName);
						verifica = true;	
						return true;
					}
				}
			}
		}
		return verifica;
	}
	
	//Edit the Address of a Filial
	public void editFilial(String name, Address newAdress) {
		for(int i = 0; i < getFilials().size(); i++) {
			if(getFilials().get(i).getName().equals(name)) {
				getFilials().get(i).edit(newAdress);
			}
		}
	}
	
	//Edit the name of a Patrimony in the Filial mentioned
	public boolean edit(String filialName, String oldPatName, String newPatName) {
		boolean verifica = false;
		for(int i = 0; i < getFilials().size(); i++){
			if(getFilials().get(i).getName().equals(filialName)) {
				verifica = getFilials().get(i).editPatrimony(oldPatName,newPatName);
			}
		}
		return verifica; 
	}
	
	//Edit the value of a Patrimony in the Filial name passed
	public void edit(String filialName, String patName, double newPatValue) {
		for(int i = 0; i < getFilials().size(); i++){
			if(getFilials().get(i).getName().equals(filialName)) {
				getFilials().get(i).editPatrimony(patName,newPatValue);
			}
		}
	}
	
	//Edit the amount of a Patrimony in the Filial name passed
	public void edit(String filialName, String patName, int newPatAmount) {
		for(int i = 0; i < getFilials().size();i++) {
			if(getFilials().get(i).getName().equals(filialName)) {
				getFilials().get(i).editPatrimony(patName,newPatAmount);
			}
		}
	}
	
	//remove a Filial based in it name
	public boolean remove(String filialName) {
		boolean verifica = false;
		
		filialName = filialName.toLowerCase();
		for(int i = 0; i < filials.size(); i++) {
			if(filials.get(i).getName().toLowerCase().equals(filialName)) 
			{
				filials.remove(i);
				verifica = true;
				return true;
			}
			
		}
		
		return verifica;
	}
	
	public boolean remove( Filial f) {
		boolean verifica = false;
		for(int i = 0; i < getFilials().size(); i ++) {
			if(getFilials().get(i) == f) {
				getFilials().remove(f);
				verifica = true;
			}
		}
		
		return verifica;
	}
	
	//remove a Patrimony name based in the Filial name passed
	public boolean remove(String filialName, String patrimonyName) {
		
		boolean verifica = false;
		
		for(int i = 0; i < filials.size(); i++) {
			
			if(filials.get(i).getName().toLowerCase().equals(filialName.toLowerCase())) {
				for(int j = 0; j < filials.get(i).getPatrimony().size(); j++) {
					if(filials.get(i).getPatrimony().get(j).getName().toLowerCase().equals(patrimonyName.toLowerCase())){
						verifica = filials.get(i).remove(patrimonyName);
					}
				}
				
			}
		
		}
		
		return verifica;
	}	
	
	//method toString that returns the name of the Company, the Address and the Array of Filials into a formated String 
	public String toString() {
		String company = String.format("Nome da companhia: %s\nEndereco da Companhia: %s\n"
				+ "Filiais:\n",this.getName(),getAddress().toString());
		
		for(int i = 0; i < filials.size(); i++) {
			company = company.concat(filials.get(i).getName());
			company = company.concat("\n");
		}
		return company;
	}	
	

}