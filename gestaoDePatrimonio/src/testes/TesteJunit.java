package testes;
import controler.ControlerCompany;
import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteJunit {

	@Test
	void testAddFilial() {
		Company c = new Company("Nike");
		c.addFilial(new Filial("loja 1"));
		c.addFilial(new Filial("loja 1"));
		c.addFilial(new Filial("loja 2"));
		c.addFilial(new Filial("loja 2"));
		assertEquals(2,c.getFilials().size());
	}
	
	@Test
	void testIsVehicle()
	{
		ControlerCompany company = new ControlerCompany("Nike");
		company.getCompany().addFilial(new Filial("loja 1"));
		
		company.getCompany().getFilials().get(0).add(new Vehicle("Gol"));
		company.getCompany().getFilials().get(0).add(new Buildings("apt 1"));
		company.getCompany().getFilials().get(0).add(new Vehicle("Gol 2"));
		
		assertTrue(company.isVehicle("loja 1", "Gol"));
		assertFalse(company.isVehicle("loja 1", "apt 1"));
		assertTrue(company.isVehicle("loja 1", "Gol 2"));
		

	}
	
	@Test
	
	void testCreatVehicle()
	{
		ControlerCompany company = new ControlerCompany("Nike");
		company.getCompany().addFilial(new Filial("loja 1"));
		company.getCompany().addFilial(new Filial("loja 2"));
		
		assertTrue(company.creatV("loja 1", "Chuteira do messi"));
		assertFalse(company.creatV("loja 1", "Chuteira do messi"));
		
		assertTrue(company.creatV("loja 2", "Chuteira do messi"));
		assertFalse(company.creatV("loja 2", "Chuteira do messi"));
	}
	
	void testRemovePatrimony()
	{
		ControlerCompany company = new ControlerCompany("Nike");
		company.getCompany().addFilial(new Filial("loja 1"));
		company.getCompany().addFilial(new Filial("loja 2"));
		
		company.getCompany().getFilials().get(0).add(new Vehicle("Gol"));
		company.getCompany().getFilials().get(0).add(new Buildings("apt 1"));
		company.getCompany().getFilials().get(0).add(new Vehicle("Gol 2"));
		
		company.getCompany().getFilials().get(1).add(new Vehicle("Gol"));
		company.getCompany().getFilials().get(1).add(new Buildings("apt 1"));
		company.getCompany().getFilials().get(1).add(new Vehicle("Gol 2"));
		
		assertTrue(company.getCompany().getFilials().get(0).remove("Gol1"));
		assertFalse(company.getCompany().getFilials().get(0).remove("Gol3"));
		
		assertTrue(company.getCompany().getFilials().get(1).remove("Gol2"));
		assertFalse(company.getCompany().getFilials().get(1).remove("Batata"));
		assertFalse(company.getCompany().getFilials().get(1).remove("Gol2"));
		assertTrue(company.getCompany().getFilials().get(1).remove("apt 1"));
		
		assertEquals(2, company.getCompany().getFilials().get(0).getPatrimony().size());
		assertEquals(1, company.getCompany().getFilials().get(0).getPatrimony().size());
	}

}
