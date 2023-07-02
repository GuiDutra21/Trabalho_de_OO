package model;

import java.util.List;
import java.util.ArrayList;
/**
 * Classe Filial herda de Enterprises e simula o comportamento de uma filial.
 * @author Julio Roberto e Guilherme Silva
 * @since 2023
 * @version 1.1
 */

public class Filial extends Enterprises {
	
	// ATRIBUTES
	private int value;
	private List<Patrimony> patrimony;
	
	//Constructor
	
	/**
	 * Contrutor que gera um Filila com nome apenas
	 * @param name nome da Filial
	 */
	public Filial(String name) {
		this(name,null);
	}
	
	/**
	 * Construtor que gera uma Filial com nome e Endereço
	 * @param name Nome da Filial
	 * @param adress Enfereço da Filial
	 */
	public Filial(String name, Address adress) {
		setName(name);
		setAddress(adress);
		setPatrimony(new ArrayList<Patrimony>());
	}

	// GETTERS AND SETTERS
	
	public void setPatrimony(ArrayList<Patrimony> patrimony) {
		this.patrimony = patrimony;
	}

	public List<Patrimony> getPatrimony() {
		return patrimony;
	}
	
	/**
	 * Métod que calcula o valor da filial retorna esse valor
	 * @return
	 */
	public double getValue() {
		double value = 0;
		
		for(int i = 0; i < getPatrimony().size(); i++) {
			value += getPatrimony().get(i).getValue() * getPatrimony().get(i).getAmount() ;
		}
		
		return value;
	}
	//Methods
	
	//Into a Filial create a Patrimony with all arguments
	
	/**
	 * Métod que cria um Veículo nessa Filial com todos os argumentos
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE 
	 * @param name Nome do patrimonio
	 * @param amount A quantida do patrimonio 
	 * @param value Valor do patrimonio 
	 * @param model Modelo do partimonio 
	 * @param brand marca do Patrimonio 
	 * @param productionYear ano de produção do patrimonio 
	 * @return True ou False
	 */
	public boolean creatV(String name,int amount, double value, String model, String brand, int productionYear) {
		boolean verifica = false;
		if(getPatrimony().size() == 0 && (name.isEmpty() == false)) {
			
			getPatrimony().add(new Vehicle(name, amount,value,  model,brand, productionYear));
			verifica = true;
			
		} else {
			if(name.isEmpty() == false) {
				for(int i = 0; i < getPatrimony().size(); i++) {
					if(getPatrimony().get(i).getName().toLowerCase().equals(name.toLowerCase())) {
						return false;
						
					} else if(i == getPatrimony().size() - 1) {
						patrimony.add(new Vehicle(name, amount,value,  model,brand, productionYear));
						verifica = true;
						return true;
					}
				}
			} else {
				return false;
			}
		}
		
		
		return verifica;
	
		
	}
	/**
	 * Método que cria um veículo com apenas name, value dentro desse Filial.
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE.
	 * @param name nome do veículo
	 * @param value velor do veículo
	 * @return True ou False
	 */
	public boolean creatV(String name, double value) {
		boolean verifica = false;
		
		if(getPatrimony().size() == 0 && (name.isEmpty() == false)) {
			getPatrimony().add(new Vehicle(name, value));
			verifica = true;
		} else {
			if(name.isEmpty() == false) {
				for(int i = 0; i < getPatrimony().size(); i++) {
					if(getPatrimony().get(i).getName().toLowerCase().equals(name.toLowerCase())) {
						return false;
					} else if(i == getPatrimony().size() - 1) {
						patrimony.add(new Vehicle(name, value));
						verifica = true;
						return true;
					}
				}
			} else {
				verifica = false;
				
			}
		}
		
		return verifica;
	
	}
	
	/**
	 * Método que cria um veículo com apenas  name, amount, value dentro desse Filial.
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE.
	 * @param name nome do veículo
	 * @param amoount a quantidade do veículo
	 * @param value velor do veículo
	 * @return True ou False
	 */
	public boolean creatV(String name,int amount, double value) {
		boolean verifica = false;
		
		if(getPatrimony().size() == 0 && (name.isEmpty() == false)) {
			getPatrimony().add(new Vehicle(name, amount, value));
			verifica = true;
		} else {
			if(name.isEmpty() == false) {
				for(int i = 0; i < getPatrimony().size(); i++) {
					if(getPatrimony().get(i).getName().toLowerCase().equals(name.toLowerCase())) {
						return false;
					} else if(i == getPatrimony().size() - 1) {
						patrimony.add(new Vehicle(name, amount, value));
						verifica = true;
						return true;
					}
				}
			} else {
				verifica = false;
			}
		}
		
		return verifica;
		
	}
	
	//Into a Filial create a Patrimony only with name
	/**
	 * Método que cria um veículo com apenas o Nome nessa Filial.
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE.
	 * @param name nome do veículo
	 * @return True ou False
	 */
	public boolean createV(String name) {
		boolean verifica = false;
		
		if(getPatrimony().size() == 0 && (name.isEmpty() == false)) {
			getPatrimony().add(new Vehicle(name));
			verifica = true;
		} else {
			if(name.isEmpty() == false) {
				for(int i = 0; i < getPatrimony().size(); i++) {
					if(getPatrimony().get(i).getName().toLowerCase().equals(name.toLowerCase())) {
						return false;
					} else if(i == getPatrimony().size() - 1){
						patrimony.add(new Vehicle(name));
						verifica = true;
						return true;
					}
				}
			} else {
				verifica = false;
			}
			
		}
		
		
		return verifica;
	
	}
	
	/**
	 * Método que cria uma propriedade com name, amount, value, floorsQtd, area
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE.
	 * @param name nome da propriedadae
	 * @param amount quantidade da propriedade
	 * @param value velor da propriedade
	 * @param floorsQtd quanitdade de andares da propriedade
	 * @param area metros quadreados da propriedade
	 * @return True ou False
	 */
	public boolean creatB(String name, int amount, double value, int floorsQTD, double area) {
		boolean verifica = false;
		
		if(getPatrimony().size() == 0 && (name.isEmpty() == false))  {
			getPatrimony().add(new Buildings(name, amount, value, floorsQTD, area));
			verifica = true;
			
		} else {
			if(name.isEmpty() == false) {
				for(int i = 0; i < getPatrimony().size(); i++) {
					if(getPatrimony().get(i).getName().toLowerCase().equals(name.toLowerCase())) {
						return false;
					} else if(i == getPatrimony().size() - 1){
						getPatrimony().add(new Buildings(name, amount, value, floorsQTD, area));
						verifica = true;
						return true;
					}
				}
			} else {
				verifica = false;
			}
		}
		
		return verifica;
		
	}
	
	public boolean creatB(String name, int amount ,double value) {
		boolean verifica = false;
		
		if(getPatrimony().size() == 0 && (name.isEmpty() == false)) {
			getPatrimony().add(new Buildings(name, amount, value));
			verifica = true;
		} 
		
		if(name.isEmpty() == false) {
			for(int i = 0; i < getPatrimony().size(); i++) {
				if(getPatrimony().get(i).getName().toLowerCase().equals(name.toLowerCase())) {
					return false;
				} else if(i == getPatrimony().size() - 1) {
					patrimony.add(new Buildings(name, amount, value));
					verifica = true;
					return true;
				}
			}
		} else {
			verifica = false;
		}
		
		return verifica;
		
	}

	/**
	 * Método que cria uma propriedade com name e value
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE.
	 * @param name nome da propriedadae
	 * @param value velor da propriedade
	 * @return True ou False
	 */
	public boolean creatB(String name, double value) {
		boolean verifica = false;
		
		if(getPatrimony().size() == 0 && (name.isEmpty() == false)) {
			getPatrimony().add(new Buildings(name, value));
			verifica = true;
		} 
		
		if(name.isEmpty() == false) {
			for(int i = 0; i < getPatrimony().size(); i++) {
				if(getPatrimony().get(i).getName().toLowerCase().equals(name.toLowerCase())) {
					return false;
				} else if(i == getPatrimony().size() - 1) {
					patrimony.add(new Buildings(name, value));
					verifica = true;
					return true;
				}
			}
		} else {
			verifica = false;
		}
		
		return verifica;
		
		
	}
	

	/**
	 * Método que cria uma propriedade com apenas o name
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE.
	 * @param name nome da propriedadae
	 * @return True ou False
	 */
	public boolean createB(String name) {
		boolean verifica = false;
		
		if(getPatrimony().size() == 0 && (name.isEmpty() == false)) {
			getPatrimony().add(new Buildings(name));
			verifica = true;
		} 
		
		if(name.isEmpty() == false) {
			for(int i = 0; i < getPatrimony().size(); i++) {
				if(getPatrimony().get(i).getName().toLowerCase().equals(name.toLowerCase())) {
					return false;
				} else if(i == getPatrimony().size() - 1){
					patrimony.add(new Buildings(name));
					verifica = true;
					return true;
				}
			}
		} else {
			verifica = false;
		}
		
		return verifica;
		
	}
	
	//Into a Filial add a Patrimony
	/**
	 * Método que adiciona um patrimonio nessa filial.
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE.
	 * @param patrimony o próprio patrimonio 
	 * @return TRUE ou FALSE
	 */
	public boolean add(Patrimony patrimony) {
		boolean verifica = false;
		if(getPatrimony().size()!= 0)
		{
			for(int i = 0; i < getPatrimony().size(); i++) {
				if(getPatrimony().get(i).getName().toLowerCase().equals(patrimony.getName().toLowerCase())) {
					return false;
				} else if(patrimony.getName().isEmpty() == false && i == getPatrimony().size() - 1) {
					getPatrimony().add(patrimony);
					verifica = true;
					return verifica;
					
				}
			}
		}
		
		else
		{
			getPatrimony().add(patrimony);
			verifica = true;
		}
	
		
		return verifica;
	}
	
	/**
	 * Métood que edita o nome do patrimonio
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE.
	 * @param oldName nome antigo
	 * @param newName nome novo
	 * @return TRUE ou FALSE
	 */
	public boolean editPatrimony(String oldName, String newName) {
		boolean verifica = false;
		for(int i = 0; i < getPatrimony().size(); i++) {
			if(getPatrimony().get(i).getName().toLowerCase().equals(newName.toLowerCase())) {
				return verifica;
				
			} else if(i == getPatrimony().size() - 1 && (newName.isEmpty() == false)) { // ter certeza que toda a lista foi verificada
				
				for(int j = 0; j < getPatrimony().size(); j ++) {
					if(getPatrimony().get(j).getName().equals(oldName)) {
						getPatrimony().get(j).edit(newName);
						verifica = true;
						return true;
					}
				}	
			}
		}
		
		return verifica;
	}
	
	/**
	 * método que altera o valor de um patrimonio
	 * @param name nome do patrimonio
	 * @param newValue novo valor
	 */
	public void editPatrimony(String name, double newValue) {
		
		name = name.toLowerCase();
		
		for (int i = 0; i < getPatrimony().size(); i++) {
			if(getPatrimony().get(i).getName().toLowerCase().equals(name)){
				getPatrimony().get(i).edit(newValue);
			}
		}
	}
	
	/**
	 * método que altera a quantidade de um determinado patrimonio
	 * @param patName noem do patrimonio
	 * @param amount nova quantidade desejada
	 */
	public void editPatrimony(String patName, int amount) {
		
		patName = patName.toLowerCase();
		for(int i = 0; i < getPatrimony().size();i++) {
			if(getPatrimony().get(i).getName().toLowerCase().equals(patName)) {
				getPatrimony().get(i).edit(amount);
			}
		}
	}

	/**
	 * Método que remove o patrimonio baseado no nome dele.
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE.
	 * @param patName Nome do patrimonio que deseja ser removido
	 * @return TRUE ou FALSE
	 */
	public boolean remove(String patName) {
		patName = patName.toLowerCase();
		boolean verifica = false;
		
		for (int i = 0; i < getPatrimony().size(); i++) {
			if (getPatrimony().get(i).getName().toLowerCase().equals(patName)) {
				getPatrimony().remove(getPatrimony().get(i));
				verifica = true;
			}
		}
		
		return verifica;
	}
	
	/**
	 * Método que remove o patrimonio passando já o patrimonio.
	 * Retorna TRUE caso seja bem sucedido, caso contrário retorna FALSE.
	 * @param p o patrimonio que deseja ser removido
	 * @return TRUE ou FALSE
	 */
	public boolean remove(Patrimony p) {
		boolean verifica = false;
		for(int i = 0; i < getPatrimony().size(); i++) {
			if(getPatrimony().get(i) == p) {
				getPatrimony().remove(p);
				verifica = true;
			}
		}
		
		return verifica;
	}

	//method toString that returns the Filial name, the Adress and the Array of Patrimony into a formated String  
	public String toString() {
		String filial = String.format("Nome: %s\nEndereco: %s\nPatrimonios registrados:\n",getName(),getAddress().toString());
		for(int i = 0; i < patrimony.size(); i++) {
			filial = filial.concat(getPatrimony().get(i).toString());
			filial = filial.concat("\n");
		}
		return filial;
	}
	
	
}