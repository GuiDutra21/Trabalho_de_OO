package model;


/**
 * Classe Vehicle que simula o comportamento de um veículo e herda de patrimônio.
 * @author Guilherme Silva Dutra and Julio Roberto
 * @since 2023
 * @version 1.1
 */
public class Vehicle extends Patrimony{
	private String model;
	private String brand;
	private int productionYear;
	
	// Constructs
	/**
	 * Construtor principal que atribui o valor dos parâmetros para os atributos da classe.
	 * Caso o valor do parâmetro  model tenha o  valor nulo o atributo referente a ele receberá a String 'Nao informado'.
	 * Caso o valor do parâmetro  brand tenha o  valor nulo o atributo referente a ele receberá a String 'Nao informado'.
	 * Caso o valor do parâmetro  productionYear tenha o  valor menor do que zero o atributo referente a ele recebera o valor de zero.
	 * @param name nome
	 * @param amount quantidade do respectivo veículo.
	 * @param value	valor
	 * @param model modelo
	 * @param brand marca 
	 * @param productionYear ano de produção
	 */
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
	
	/**
	 * Sobrescrita do construtor que atribui o valor dos parâmetros respectivamente para os atributos name, amount, value, model e brand.
	 * Atribui ao atributo productionYear o valor zero
	 * @param name nome
	 * @param amount quantidade
	 * @param value valor
	 * @param model modelo
	 * @param brand maraca
	 */
	public Vehicle(String name, int amount, double value, String model,String brand) {
		this(name, amount, value,model,brand,0);
	}
	
	/**
	 * Sobrescrita do construtor que atribui o valor dos parâmetros respectivamente para os atributos name, amount, value e model.
	 * Atribui ao atributo brand um valor nulo
	 * Atribui ao atributo productionYear o valor zero
	 * @param name nome
	 * @param amount quantidade
	 * @param value valor
	 * @param model modelo
	 */
	public Vehicle(String name, int amount, double value, String model) {
		this(name, amount, value,model,null,0);
	}
	
	/**
	 * Sobrescrita do construtor que atribui o valor dos parâmetros respectivamente para os atributos name, amount  e value.
	 * Atribui ao atributo model e ao brand um valor nulo
	 * Atribui ao atributo productionYear o valor zero
	 * @param name nome
	 * @param amount quantidade
	 * @param value valor
	 */
	public Vehicle(String name, int amount, double value) {
		this(name, amount, value,null,null,0);
	}
	
	/**
	 * Sobrescrita do construtor que atribui o valor dos parâmetros respectivamente para os atributos name e valor.
	 * Atribui ao atributo quantidade o valor de 1.
	 * Atribui ao atributo model e ao brande um valor nulo
	 * Atribui ao atributo productionYear o valor zero
	 * @param name nome
	 * @param value valor
	 */
	public Vehicle(String name, double value) {
		this(name,1,value,null,null,0);
	}
	
	
	/**
	 * Sobrescrita do construtor que atribui o valor dos parâmetros respectivamente para os atributos name e amount.
	 * Atribui ao atributo value o valor de 0
	 * Atribui ao atributo model e ao brand um valor nulo
	 * Atribui ao atributo productionYear o valor zero
	 * @param name nome
	 * @param amount quantidade
	 */
	public Vehicle(String name, int amount) {
		this(name, amount,0.0,null,null,0);
	}
	
	 
	/**
	 * Sobrescita do construtor que atribio o valor do parâmetro para o atributo name.
	 * Atribui ao atributo value o valor de 0
	 * Atribui ao atributo quantidade o valor de 1.
	 * Atribui ao atributo model e ao brand um valor nulo
	 * Atribui ao atributo productionYear o valor zero
	 * @param name nome
	 */
	public Vehicle(String name) {
		this(name,1,0.0,null,null,0);
	}
	
	// Setters e getters
	
	/**
	 * Método setter que atribui valor ao atributo model.
	 * Caso o parâmtro seja nulo atribui a ao atributo model a String 'nao informado'.
	 * @param model modelo
	 */
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
	
	/**
	 * Método setter que atribui valor ao atributo brand.
	 * Caso o parâmetro seja nulo atribui ao atributo brand a String 'nao informado'.
	 * @param brand marca
	 */
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
	
	/**
	 * Método setter que atribui valor ao atributo prooductionYeat apenas se 
	 * o valor passado no parâmetro seja maior do que 1800.
	 * Ou seja, não aceita anos menores que 1800.
	 * @param productionYear
	 */
	public void setProductionYear(int productionYear) {
		if(productionYear > 1800 ) {
			this.productionYear = productionYear;
		}
	}
	
	public int getProductionYear() {
		return productionYear;
	}
	
	//Methods
	
	/**
	 * Método que edita o valor do atributo model.
	 * @param model modelo.
	 */
	public void editModel(String model)
	{
		setModel(model);
	}
	
	/**
	 * Método que edita o valor do atributo brand.
	 * @param brand marca
	 */
	public void editBrand(String brand)
	{
		setBrand(brand);
	}
	
	/**
	 * Método que edita o valor do atributo produvtionYear.
	 * @param productionYear ano de produção
	 */
	public void editProductionYear(int productionYear)
	{
		setProductionYear(productionYear);
	}
	
	/**
	 * Sobrescrita do método toString() das classe Object e Vehicle.
	 * * Constroi uma String contendo os valores de todos os atributos da classe Vehicle.
	 * @return String
	 */
	public String toString()
	{
		String vehicle = String.format("Nome: %s,\nUnidades: %d,\nValor unitario: %.2f,\n"
				+ "Marca : %s,\nModelo : %s,\n"
				+ "Ano de Producao : %d",this.getName(),getAmount(),getValue(), getBrand(), getModel(),getProductionYear());
		return vehicle;
	}
}