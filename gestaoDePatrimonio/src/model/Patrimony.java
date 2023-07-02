package model;


/**
 * Classe abstrata Patrimony que simula o comportamento de um patrimônio genérico.
 * @author Guilherme Silva Dutra and Julio Roberto
 * @since 2023
 * @version 1.1
 *
 */
public abstract class Patrimony {
	
	// ATRIBUTES	
	
	private String name;
	private double value;
	private int amount = 1;
	
	//Constructors
	
	/**
	 * Construtor Principal que atribui valor para todos os atributos.
	 * @param name Nome
	 * @param amount Quantidade do prórpio Patrimonio
	 * @param value Valor 
	 */
	public Patrimony(String name, int amount, double value) {
		setName(name);
		setAmount(amount);
		setValue(value);
	}
	/**
	 * Sobrescrita do construtor que atribui o valor do parâmetro para o atributo nome.
	 * Atribui ao atributo amount o valor de 1, 
	 * pois não tem como criar algo que não tenha qunatidade.
	 * Atribui ao atributo value o valor de 0 
	 * @param name Nome 
	 */
	public Patrimony(String name) {
		this(name, 1, 0);
	}
	
	/**
	 * Sobrescrita do construtor que atribui o valor dos parâmetros 
	 * para os respectivos atributos name e value.
	 * Atribui ao atributo amount o valor de 1,
	 * pois não tem como criar algo que não tenha quantidade
	 * @param name nome 
	 * @param value valor
	 */
	public Patrimony(String name, double value) {
		this(name,1,value);
	}
	
	/**
	 * Sobrescrita do construtor que atribui o valor dos parâmetros
	 * para os respectivos atributos name e amount
	 * @param name nome
	 * @param amount quantidade do respectivo patrimônio 
	 */
	public Patrimony(String name, int amount) {
		this(name,amount,0);
	}
	
	// GETTERS AND SETTERS
	
	/**
	 * Método Setter que atribui valor ao nome.
	 * Caso seja passado um valor Nullo é atribuido como 'Não Informado'
	 * @param name nome
	 */
	public void setName(String name) {
		if(name == null) {
			this.name = "Nao informado";
		} else {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}
	
	/**
	 * Método Setter que atribui valor ao atributo value.
	 * Apenas atribui valor se o valor passado no parâmetro seja maior que zero
	 * @param value valor
	 */
	public void setValue(double value) {
		if(value > 0){
			this.value = value;
		}
	}

	public double getValue() {
		return value;
	}
	
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Método setter que atribui valor ao atributo amount.
	 * apenas atrubui valor caso o valor passado no parâmtro seja maior do que um
	 * @param amount quantidade do respectivo patrimônio
	 */
	public void setAmount(int amount) {
		if(amount > 1) {
			this.amount = amount;
		}
	}
	
	//Methods
	
	//Method that edits the name, the amount and the value
	
	/**
	 * Método que edita o valor dos atributos name, amount e value.
	 * @param name nome 
	 * @param amount quantiadade do respectivo patrimônio 
	 * @param value valor
	 */
	public void edit(String name, int amount, double value) {
		setName(name);
		setAmount(amount);
		setValue(value);
	}
	
	//Method that edits the name 
	
	/**
	 * Método que edita o nome do patrimônio.
	 * @param name nome
	 */
	public void edit(String name) {
		setName(name);
	}
	
	//Method that edits the value
	
	/**
	 * Método que edita o valor do Patrimônio.
	 * @param value valor
	 */
	public void edit(double value) {
		setValue(value);
	}
	
	//Method that edits the amount
	
	/**
	 * Método que edita a quantidade do respectivo patrimônio.
	 * @param amount quanitdade do respectivo patrimônio 
	 */
	public void edit(int amount) {
		setAmount(amount);
	}
	
	//Method that edits the name and the value
	
	/**
	 * Método que edita o nome e o valor
	 * @param name nome 
	 * @param value valor
	 */
	public void edit(String name, double value) {
		setName(name);
		setValue(value);
	}
	
	//method that edits the name and the amount
	
	/**
	 * Método que edita o nome e a quantidade do respectivo Patrimônio
	 * @param name nome
	 * @param amount quantidade do respectivo patrimônio
	 */
	public void edit(String name, int amount) {
		setName(name);
		setAmount(amount);
	}
	
	//method that edits the name and the value
	
	/**
	 * Métod que edita a quantidade do respectio patrimônio e o valor
	 * @param amount quantidade do respectivo patrimônio 
	 * @param value valor
	 */
	public void edit(int amount, double value) {
		setAmount(amount);
		setValue(value);
	}
		
	//Method toString that returns the name and value of a Patrimony into a formated String
	/**
	 * Sobrescrita do método toString() das classes Object e Patrimony.
	 * Constroi uma String contendo os valores de todos os atributos da classe Patrimony separados por virgula
	 * @return String
	 */
	public String toString() {
		String patrimony = String.format("Nome: %s, Unidades: %d, Valor unitario: %.2f",getName(),getAmount(),getValue());
		return patrimony;
	}
	
	
}