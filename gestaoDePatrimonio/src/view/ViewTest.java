package view;
import model.Buildings;
import model.Patrimony;
import model.Vehicle;
import model.Company;
import model.Address;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import controler.ControlerCompany;

public class ViewTest {
	public static void main(String[] args)
	{
		
		ControlerCompany c = new ControlerCompany("");
		
		Login l = new Login(c);
		
		c.getCompany().createFilial("loja 1", new Address("", "", "", "", 12));
		c.getCompany().createFilial("loja 2", new Address("", "", "", "", 15));
		c.getCompany().createFilial("loja 3", new Address("", "", "", "", 18));
		
		for(int i = 0; i  < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(j % 2 == 0)
				{
					String n = String.format("CARRO %d",j);
					Vehicle a = new Vehicle(n);
					c.getCompany().getFilials().get(i).add(a);
				}
				else
				{
					String n = String.format("APT %d",j);
					Buildings b = new Buildings(n);
					b.edit(new Address("", "", "", "", 12));
					c.getCompany().getFilials().get(i).add(b);

				}
			}
		}
		
//		ArrayList<Patrimony> pats = new ArrayList<>();
//		ArrayList<String> nomes = new ArrayList<>();
//		for(int i = 0; i < 6; i++)
//		{
//			pats.add(new Vehicle("teste carro"));
//			pats.add(new Buildings("teste predio"));
//			nomes.add("um nome qualuqer");
//		}
//		
//		
//		SearchedPatrimonys k = new SearchedPatrimonys(pats,nomes,"ameba", 6);
		
	}
}