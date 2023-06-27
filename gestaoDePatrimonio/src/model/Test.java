package model;

public class Test {
	public static void main(String[] args) {
		Patrimony a[] = new Patrimony[2];
		a[0] = new Vehicle("Carro");
		a[1] = new Buildings("Apart");
		
		Filial f = new Filial("Nike");
		
		f.add(a[0]);
		f.add(a[1]);
		
		f.edit(a[0],null, null, 0,1.500, "Nissan", "Toyota", -8, 0, 0.0);
		Vehicle b = (Vehicle) a[0];
		
		System.out.println(b.getBrand());
		
	}
}