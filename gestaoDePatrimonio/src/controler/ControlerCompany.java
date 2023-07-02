package controler;
import java.util.ArrayList;
import java.util.List;

import model.*;
import view.CompanyMenu;
import view.InsertAddress;

/**
 * Classe ControlerCompany que realiza a conexão entre as classes modelos e
 * as classes das telas.
 * @author Guilherme Silva Dutra and Julio Roberto
 * @since 2023
 * @version 1.1
 */
public class ControlerCompany {
	private Company company;
	private String companyName;
	public static int IS_COMPANY = 0, IS_FILIAL = 1;
	
	/**
	 * Construtor que instancia uma classe Company com o nome.
	 * @param nome
	 */
	public ControlerCompany(String name) {
		this.company = new Company(name);
		this.companyName = name;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Company getCompany() {
		return company;
	}
	
	/**
	 * Método que instância e atribui o endereço na filial.
	 * @param pais 
	 * @param estado
	 * @param cidade
	 * @param rua
	 * @param numero
	 */
	public void login(String pais, String estado, String cidade, String rua, int numero) {
		Address a = new Address(pais,estado,cidade,rua,numero);
		company.setAddress(a);
		
	}
	
	/**
	 * Método que instancia a tela de CompanyMenu
	 */
	public void companyScreean() {
		new CompanyMenu(this);
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * método setter que atribui valor ao nome da compania
	 * @param name nome da compania
	 */
	public void setCompanyName(String name) {
		company.setName(name);
		this.companyName = name;
	}
	
	public String getCompanyAddress() {
		return company.getAddress().toString();
	}
	/**
	 * Método que chama a tela InsertAdress para alterar o endereço.
	 * Caso o valor do parâmetro t seja 0 irá alterar posteriomente o endereço
	 * da classe Copmpany.
	 * Caso o valor do parâmetro t seja 1 irá alterar posteriomente o endereço
	 * da classe Filial. 
	 * @param c
	 * @param t
	 */
	public void editAddress(ControlerCompany c, int t)
	{
		new InsertAddress(c,t);
	}
	/**
	 * ver com o julio
	 * @param c
	 * @param t
	 * @param filialName
	 */
	public void editAddress(ControlerCompany c, int t, String filialName)
	{
		new InsertAddress(c,t,filialName);
	}
	
	/**
	 * Método que retorna um array com o nome dos patrimônios de uma dada filial
	 * @param f filial que desejamos capturar os nomes dos patrimônios
	 * @return  Arrray de String com os nomes desejados.
	 */
	public String[] patrimonyNames(Filial f)
	{
		String[] nomes = new String[f.getPatrimony().size()];
		for(int i = 0; i < f.getPatrimony().size(); i++)
		{
			 nomes[i] = f.getPatrimony().get(i).getName();
		}
		
		return nomes;
	}
	
	/**
	 * Método que retorna um array com os patrimônios de uma dada filial.
	 * @param filialName Nome da Filial que desejamos obter os patrimônios
	 * @return List<Patrimony>
	 */
	public List<Patrimony> getPatrimonys(String filialName)
	{
		List<Patrimony> t = null;
		for(int i = 0; i < company.getFilials().size(); i++)
		{
			if(company.getFilials().get(i).getName() == filialName)
				t = company.getFilials().get(i).getPatrimony();
		}
		return t; //return an Array empty in case the 'if' is false for all elements
	}
	
	/**
	 * Método que retorna uma Filial dada o seu nome.
	 * @param name nome da filial desejada
	 * @return Filial desejada
	 */
	public Filial getFilial(String name)
	{
		Filial f = null;
		for(int i = 0; i < company.getFilials().size(); i++)
		{
			if(company.getFilials().get(i).getName().equals(name)) {
				f = company.getFilials().get(i);
			}
		}
		
		return f;
	}
	
	/**
	 * Método que retorna um Patrimony baseado no seu nome e na filial que ele é relacionado.
	 * @param filialName Nome da filial que o patrimônio está contido
	 * @param patrimonyName Nome do patrimônio que desejamos
	 * @return Patrimony desejado
	 */
	public Patrimony getPatrimony(String filialName, String patrimonyName) 
	{
		Patrimony a = null;
		for(int i = 0; i < this.getFilial(filialName).getPatrimony().size(); i ++)
		{
			if(this.getFilial(filialName).getPatrimony().get(i).getName().equals(patrimonyName)) {
				a =  this.getFilial(filialName).getPatrimony().get(i);
			}
		}
		
		return a;
	}
	
	/**
	 * Método que retorna um Vehicle baseado no seu nome e no nome da filial que ele é relacionado.
	 * @param filialName Nome da filial que o patrimônio está contido
	 * @param patrimonyName Nome do Vehicle que desejamos
	 * @return Vehicle desejado
	 */
	public Vehicle getVehicle(String filialName, String patrimonyName) 
	{
		Vehicle a = null;
		for(int i = 0; i < this.getFilial(filialName).getPatrimony().size(); i ++)
		{
			if(this.getFilial(filialName).getPatrimony().get(i).getName().equals(patrimonyName)) {
				a = (Vehicle) this.getFilial(filialName).getPatrimony().get(i);
				return a;
			}
		}
		
		return a;
	}
	
	/**
	 * Método que retorna um Buildings baseado no seu nome e no nome da filial que ele é relacionado.
	 * @param filialName Nome da filial que o patrimônio está contido
	 * @param patrimonyName Nome do Vehicle que desejamos
	 * @return Buildings desejado
	 */
	public Buildings getBuildings(String filialName, String patrimonyName) 
	{
		Buildings a = null;
		for(int i = 0; i < this.getFilial(filialName).getPatrimony().size(); i ++)
		{
			if(this.getFilial(filialName).getPatrimony().get(i).getName().equals(patrimonyName)) {
				a = (Buildings) this.getFilial(filialName).getPatrimony().get(i);
			}
		}
		
		return a;
	}
	
	/**
	 * Método que cria um Vehicle baseado no nome da Filial onde desejamos criar 
	 * e no nome que o Vehicle terá.
	 * Retorna TRUE se a operação for bem sucedida ou FALSE caso contrário.
	 * @param filialName Nome da filial onde será criado o Vehicle
	 * @param name Nome do Vehicle que desejamos criar
	 * @return TRUE ou FALSE
	 */
	public boolean creatV(String filialName,String name)
	{
		boolean verifica = company.add(filialName, new Vehicle(name));
		return verifica;
	}
	
	/**
	 * Método que cria um Buildings baseado no nome da Filial onde desejamos criar 
	 * e no nome que o Buildings terá.
	 * Retorna TRUE se a operação for bem sucedida ou FALSE caso contrário.
	 * @param filialName Nome da filial onde será criado o Buildings
	 * @param name Nome do Buildings que desejamos criar
	 * @return TRUE ou FALSE
	 */
	public boolean creatB(String filialName,String name)
	{
		boolean verifica = company.add(filialName, new Buildings(name));
		return verifica;
	}
	
	/**
	 * Método que isntancia em um Buildgs um endereço baseado no nome dele e da filial 
	 * segundo a qual ele está relacionado
	 * @param filialName Nome da filial que o Buildings está relacioando
	 * @param name Nome do Buildgs que desejamos instanciar um Address
	 */
	public void creatAddresstoBuil(String filialName, String name) {
		this.getBuildings(filialName, name).setAddress(new Address());
	}
	
	/**
	 * Método que instancia um Address na filial desejada.
	 * @param filialName Nome da filial que desejamos instanciar o Address.
	 */
	public void creatAddresstoFilial(String filialName)
	{
		getFilial(filialName).setAddress(new Address());
	}
	
	/**
	 * Método que realiza a busca de Patrimony pelo nome.
	 * retornar um ArrayList de Patrimony caso a String usado na busca esteja contida no nome do(s) patrimony. 
	 * @param searchedName Nome utiliazado na busca
	 * @return Array de Patrimony buscados
	 */
	public List<Patrimony> searchPatrimony(String searchedName)
	{	 searchedName = searchedName.toLowerCase();
		List<Patrimony> list = new ArrayList<>();
		String[] namesArray;
	
		for(int i = 0; i < company.getFilials().size(); i++)
		{
			for(int j = 0; j < company.getFilials().get(i).getPatrimony().size(); j++)
			{	
				namesArray = new String[company.getFilials().get(i).getPatrimony().get(j).getName().length()];
				namesArray = company.getFilials().get(i).getPatrimony().get(j).getName().toLowerCase().split(searchedName);
				if(namesArray.length != 1 && 
						namesArray.length != company.getFilials().get(i).getPatrimony().get(j).getName().length())
				{	
					list.add(company.getFilials().get(i).getPatrimony().get(j));
				}
			}
		}
		return list;
	}
	
	/**
	 * Método que baseado nos Patrimony cujos forma buscado(s) retorna 
	 * um ArrayList das Filiais que cada um dele(s) está relacionado
	 * 
	 * @param searchedName Nome utilizado par buscar o(s) Patrimony
	 * @return Array de Strings que representa o nome das Filial
	 */
	public List<String> getFilialsName(String searchedName)
	{	
		List<String> namesList = new ArrayList<>();
		String[] namesArray;
		searchedName = searchedName.toLowerCase();
		for(int i = 0; i < company.getFilials().size(); i++)
		{
			for(int j = 0; j < company.getFilials().get(i).getPatrimony().size(); j++)
			{	
				namesArray = new String[company.getFilials().get(i).getPatrimony().get(j).getName().length()];
				namesArray = company.getFilials().get(i).getPatrimony().get(j).getName().toLowerCase().split(searchedName);
				if(namesArray.length != 1 && 
						namesArray.length != company.getFilials().get(i).getPatrimony().get(j).getName().length())
				{	
					//add the name of the patrimony
					namesList.add(company.getFilials().get(i).getName());
				}
			}
		}
		return namesList;
	}
	
	/**
	 * Método que retorna se um dado patrimony é um Vehicle ou não. 
	 * Retorna TRUE caso o Patrimony seja do tipo Vehicle e retora FALSE caso contrário
	 * @param filialName Nome da filial em que o Patrimony está contido
	 * @param patrimonyName Nome do Patrimony
	 * @return TRUE OU FALSE
	 */
	public boolean isVehicle(String filialName,String patrimonyName)
    
    {
         boolean verifica = false;
         for(int i = 0; i < getFilial(filialName).getPatrimony().size(); i++)
         {
             if(getFilial(filialName).getPatrimony().get(i).getName().equals(patrimonyName))
             {
                 if(getFilial(filialName).getPatrimony().get(i) instanceof Vehicle)
                 {
                     return true;
                 }
                 else 
                 {
                     return false;
                 }
             }
         }

         return verifica;
    }
}