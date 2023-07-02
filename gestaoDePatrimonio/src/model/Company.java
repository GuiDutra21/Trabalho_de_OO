package model;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe Company herda de Enterprises e simula o comportamento de uma compania
 * @author Julio Roberto e Guilherme Silva
 * @since 2023
 * @version 1.1
 */

public class Company extends Enterprises {
	
	// ATRIBUTES
	
	private List<Filial> filials;
	
	//Constructors
	/**
	 * Constroi uma Company com nome e endereço
	 * @param name Nome da compania
	 * @param adress Endereço da compania
	 */
	public Company(String name, Address adress) {
		this.setName(name);
		this.setAddress(adress);
		setFilials(new ArrayList<Filial>());
	}
	
	/**
	 * Constroi uma company com nome
	 * @param name Nome da company
	 */
	
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
	/**
	 * Retona o valor agregraddo de todas as filiais associadas a compania
	 * @return Double
	 */
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

	/**
	 * Adiciona uma filial na lista de filiais da compania. Se tentar inserir a mesma Filial novamente (mesmo nome)
	 * o metodo retorna FALSE , caso contrário retorna True. 
	 * @param filial Filial
	 * @return boolean
	 */
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
	
	/**
	 * Cria uma filial, com nome e endereço, e adiciona-a a lista de filiais da compania. Se tentar criar uma filial com o mesmo
	 * nome de uma ja registrada ou com o nome vazio, o metodo retorna FALSE, caso constrario retorna True.
	 * @param name Nome da filial
	 * @param address endereço da filial
	 * @return boolean
	 */
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
	/**
	 * Cria uma filial e adiciona-a a lsta de filiais da compania. Se tentar criar uma filial com o mesmo
	 * nome de uma ja registrada ou com o nome vazio, o metodo retorna FALSE, caso constrario retorna True.
	 * @param name Nome da filial
	 * @return boolean
	 */
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
	/**
	 * Adiciona um patrimonio a uma filial. Se tentar adicionar um Patrimonio com o mesmo nome de um outro ja
	 * registrado na filial o metodo retorna FALSE, caso Contrario retorna TRUE.
	 * @param filialName Nome da filial
	 * @param patrimony Patrimonio 
	 * @return boolean
	 */
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
	/**
	 * Muda o nome de uma filial. Se tentar mudar o nome pra um ja existente na lista de filiais da compania o metodo 
	 * retorna FALSE, caso contrário retorna TRUE.
	 * @param oldName Nome da filial
	 * @param newName Novo nome da filial
	 * @return boolean
	 */
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
	/**
	 * Edita o endeço de uma Filial dado o nome.
	 * @param name Nome da filial
	 * @param newAdress Novo endereço
	 */
	public void editFilial(String name, Address newAdress) {
		for(int i = 0; i < getFilials().size(); i++) {
			if(getFilials().get(i).getName().equals(name)) {
				getFilials().get(i).edit(newAdress);
			}
		}
	}
	
	//Edit the name of a Patrimony in the Filial mentioned
	/**
	 * Edita o nome de um patrimônio de uma determinada filial.
	 * @param filialName
	 * @param oldPatName
	 * @param newPatName
	 * @return boolean
	 */
	
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
	/**
	 * Edita o valor de um patrimônio em uma determinada filial.
	 * @param filialName Nome da Filial
	 * @param patName Nome do patrimõnio
	 * @param newPatValue Novo valor do patrimõnio
	 */
	
	public void edit(String filialName, String patName, double newPatValue) {
		for(int i = 0; i < getFilials().size(); i++){
			if(getFilials().get(i).getName().equals(filialName)) {
				getFilials().get(i).editPatrimony(patName,newPatValue);
			}
		}
	}
	
	//Edit the amount of a Patrimony in the Filial name passed
	/**
	 * Edita a quantidade de um patrimõnio em uma determinada filial.
	 * @param filialName Nome da filial
	 * @param patName Nome do patrimõnio
	 * @param newPatAmount Quantidade de itens do patrimõnio
	 */
	public void edit(String filialName, String patName, int newPatAmount) {
		for(int i = 0; i < getFilials().size();i++) {
			if(getFilials().get(i).getName().equals(filialName)) {
				getFilials().get(i).editPatrimony(patName,newPatAmount);
			}
		}
	}
	
	//remove a Filial based in it name
	/**
	 * Remove uma determinada filial, a partir de seu nome, da lista de filial da compania. Se remover com sucesso retorna TRUE, caso
	 * contrário retorna FALSE.
	 * @param filialName Nome da filial
	 * @return boolean
	 */
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
	/**
	 * Remove uma filial da lista de filiais da compania. Se remover com sucesso retorna TRUE, caso 
	 * contrário retorna FALSE.
	 * @param f Filial
	 * @return boolean
	 */
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
	
	/**
	 * Remove um patrimõnio de uma determinada filial.
	 * @param filialName Nome da filial
	 * @param patrimonyName Nome do patrimõnio
	 * @return boolean
	 */
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
	
	/**
	 * Sobreescrita do metoo do to String de Object e Enterprises. Retorna uma String com todas as informações da compania e
	 * de suas filiais.
	 * @return String
	 */
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