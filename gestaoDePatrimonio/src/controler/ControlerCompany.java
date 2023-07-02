package controler;
import java.util.ArrayList;
import java.util.List;

import model.*;
import view.CompanyMenu;
import view.InsertAddress;


public class ControlerCompany {
	private Company company;
	private List<String> filialsName;
	private String companyName;
	public static int IS_COMPANY = 0, IS_FILIAL = 1;
	
	
	public ControlerCompany(String name) {
		this.company = new Company(name);
		this.companyName = name;
		this.filialsName = new ArrayList<>();

	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void login(String pais, String estado, String cidade, String rua, int numero) {
		Address a = new Address(pais,estado,cidade,rua,numero);
		company.setAddress(a);
		
	}
	
	public void companyScreean() {
		new CompanyMenu(this);
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String name) {
		company.setName(name);
		this.companyName = name;
	}
	
	public String getCompanyAddress() {
		return company.getAddress().toString();
	}
	
	public void editAddress(ControlerCompany c, int t)
	{
		new InsertAddress(c,t);
	}
	
	public void editAddress(ControlerCompany c, int t, String filialName)
	{
		new InsertAddress(c,t,filialName);
	}
	
	public String[] patrimonyNames(Filial f)
	{
		String[] nomes = new String[f.getPatrimony().size()];
		for(int i = 0; i < f.getPatrimony().size(); i++)
		{
			 nomes[i] = f.getPatrimony().get(i).getName();
		}
		
		return nomes;
	}
	
	//para passar no construtor da tela filialMenu
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
	
	public boolean creatV(String filialName,String name)
	{
		boolean verifica = company.add(filialName, new Vehicle(name));
		return verifica;
	}
	
	public boolean creatB(String filialName,String name)
	{
		boolean verifica = company.add(filialName, new Buildings(name));
		return verifica;
	}
	
	public void creatAddresstoBuil(String filialName, String name) {
		this.getBuildings(filialName, name).setAddress(new Address());
	}
	
	public void creatAddresstoFilial(String filialName)
	{
		getFilial(filialName).setAddress(new Address());
	}
	
	//return a list of patrimonys based in a name
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
	
	//return a list of filials name
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