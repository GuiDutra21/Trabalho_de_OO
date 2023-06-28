package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.Patrimony;
import model.Buildings;
import model.Vehicle;
import model.Company;
import controler.ControlerCompany;


public class SearchedPatrimonys implements ActionListener {
	
	private JFrame jf;
	private List<JPanel> panels;
	private List<JLabel> labels;
	private List<JButton> buttons;
	private JScrollPane scroll;
	private ControlerCompany c;
	private String searchedName;

	
	//constructor 
	SearchedPatrimonys(ControlerCompany c, String searchedName){
		this.searchedName = searchedName;
		this.c = c;
		
		searchedName = searchedName.trim().replaceAll("\\s+", " ");
		//Create the Frame
		jf = new JFrame();
		
		//The Layout null permitted us to choose the position of the elements  
		jf.setLayout(null);
		
		//Design the Size of the Frame
		jf.setSize(300, 200);
		
		//Method that stop the Frame when we close it 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//To put in full Screen when we run the application 
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//Create the panels
		panels = new ArrayList<>();
		
		//Add the main Panel
		panels.add(new JPanel());
		panels.get(0).setLayout(null);
		panels.get(0).setBackground(new Color(100, 145, 255));
		
		
		labels = new ArrayList<>();
		buttons = new ArrayList<>();
		
		//to catch the screenSize
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
		
        //String h = String.format("%d",screenWidth);=>1536
        
        //The font
        Font font = new Font("Time News Roman",Font.BOLD, 30);
        
        //The variables to catch the JLabels size
        FontMetrics fontMetrics;
        int labelWidth;
        
        
		labels.add(new JLabel("Patrimônio(s) encontrado(s) dado o seguinte nome :"));
		labels.get(0).setBounds(screenWidth/2 - labels.get(0).getText().length()*7,20,1200, 50);
		labels.get(0).setFont(font);
		panels.get(0).add(labels.get(0));
		
		//The JLabel representing the Name that was looked up
		labels.add(new JLabel(searchedName));
		labels.get(1).setFont(font);
		fontMetrics = labels.get(1).getFontMetrics(font);//to catch the Dimensions occupied by the JLabel
		labelWidth = fontMetrics.stringWidth(searchedName);//to catch the width occupied by the JLabel
		labels.get(1).setBounds(screenWidth/2 - labelWidth/2,90, labelWidth + 10, 50);
		if(labels.get(1).getText().length() != 0)
		{
			labels.get(1).setOpaque(true);
			labels.get(1).setBackground(new Color(220, 220, 220));
		}
		panels.get(0).add(labels.get(1));
		
		//the height of the greens Squares
		int squareHeight = 900;
		
		//The gray JPanel behind
		panels.add(new JPanel());
		panels.get(1).setBounds(125, 230, 1250, c.searchPatrimony(searchedName).size() * squareHeight);
		panels.get(1).setBackground(new Color(220, 220, 220));
		
		int labelsQtd = labels.size();
		
		for (int i = 0; i < c.searchPatrimony(searchedName).size(); i++) {
			
			labelsQtd = labels.size();
		
			panels.add(new JPanel());
			
			if(c.searchPatrimony(searchedName).get(i) instanceof Buildings)
			{	
				panels.get(panels.size() - 1).setBounds(200, 300 + (i * squareHeight), 1100, 700);
				panels.get(panels.size() - 1).setBackground((new  Color(0, 180, 0)));
				
				labels.add(new JLabel((c.getBuildings(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getName())));
				fontMetrics = labels.get(labelsQtd).getFontMetrics(font);
				labelWidth = fontMetrics.stringWidth(labels.get(labelsQtd).getText());
				labels.get(labelsQtd).setBounds(screenWidth/2 - labelWidth/2, 352 + (i * squareHeight), labelWidth + 5, 30);
				labels.get(labelsQtd).setOpaque(true);
				labels.get(labelsQtd).setBackground(new Color(210,180,140));
				labels.get(labelsQtd).setFont(font);
				panels.get(0).add(labels.get(labelsQtd));
				
				labels.add(new JLabel("<html><u>Nome :</u></html>"));
				labels.get(labelsQtd + 1).setBounds(screenWidth/2 - labelWidth/2 - 150, 350 + (i * squareHeight), 200, 30);	
				labels.get(labelsQtd + 1).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 1));
				
				labels.add(new JLabel("Filial relacionada: "));
				labels.get(labelsQtd + 2).setBounds(400, 450 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 2).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 2));
				
				labels.add(new JLabel(c.getFilialsName(searchedName).get(i)));
				labels.get(labelsQtd + 3).setBounds(720, 452 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 3).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 3));
				
				labels.add(new JLabel("<html><u>Valor :</u></html>"));
				labels.get(labelsQtd + 4).setBounds(300, 550 + (i * squareHeight), 200, 30);
				labels.get(labelsQtd + 4).setFont(new Font("Times New Roman", Font.BOLD, 30));
				panels.get(0).add(labels.get(labelsQtd + 4));
				
				labels.add(new JLabel(String.valueOf((c.getBuildings(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getValue()))));
				labels.get(labelsQtd + 5).setBounds(500, 552 + (i * squareHeight), 400, 30);
				labels.get(labelsQtd + 5).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 5));
				
				labels.add(new JLabel("<html><u>Unidades :</u></html>"));
				labels.get(labelsQtd + 6).setBounds(850, 550 + (i * squareHeight), 200, 30);	
				labels.get(labelsQtd + 6).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 6));
				
				labels.add(new JLabel(String.valueOf((c.getBuildings(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getAmount()))));
				labels.get(labelsQtd + 7).setBounds(1050, 552 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 7).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 7));
				
				labels.add(new JLabel("<html><u>Quantidade de andares :</u></html>"));
				labels.get(labelsQtd + 8).setBounds(850, 650 + (i * squareHeight), 200, 100);
				labels.get(labelsQtd + 8).setFont(new Font("Times New Roman", Font.BOLD, 30));
				panels.get(0).add(labels.get(labelsQtd + 8));
				
				labels.add(new JLabel(String.valueOf((c.getBuildings(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getFloorsQtd()))));
				labels.get(labelsQtd + 9).setBounds(1050, 675 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 9).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 9));
				
				labels.add(new JLabel("<html><u>Metros Quadrados :</u></html>"));
				labels.get(labelsQtd + 10).setBounds(300, 650 + (i * squareHeight), 200, 100);
				labels.get(labelsQtd + 10).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 10));
				
				labels.add(new JLabel(String.valueOf((c.getBuildings(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getArea()))));
				labels.get(labelsQtd + 11).setBounds(500, 675 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 11).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 11));
				
				labels.add(new JLabel("<html><u>Endereço :</u></html>"));
				labels.get(labelsQtd + 12).setBounds(400, 800 + (i * squareHeight), 400, 30);
				labels.get(labelsQtd + 12).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 12));
				
				labels.add(new JLabel(String.valueOf((c.getBuildings(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getAddress()))));
				labels.get(labelsQtd + 13).setBounds(600, 802 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 13).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 13));				
				
				
					buttons.add(new JButton("Editar"));
					buttons.get(buttons.size() - 1).setBounds(450,930 + (i * squareHeight),200,30);
					panels.get(0).add(buttons.get(buttons.size() - 1));
					
					buttons.add(new JButton("Remover"));
					buttons.get(buttons.size() - 1).setBounds(850,930 + (i * squareHeight),200,30);
					panels.get(0).add(buttons.get(buttons.size() - 1));
			}			
			else
			{	
				panels.get(panels.size() - 1).setBounds(200, 300 + (i * squareHeight), 1100, 700);
				panels.get(panels.size() - 1).setBackground((new  Color(0, 180, 0)));					
					
				labels.add(new JLabel(c.getVehicle(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getName()));
				fontMetrics = labels.get(labelsQtd).getFontMetrics(font);
				labelWidth = fontMetrics.stringWidth(labels.get(labelsQtd).getText());
				labels.get(labelsQtd).setBounds(screenWidth/2 - labelWidth/2, 352 + (i * squareHeight), labelWidth + 5, 30);
				labels.get(labelsQtd).setOpaque(true);
				labels.get(labelsQtd).setBackground(new Color(210,180,140));
				labels.get(labelsQtd).setFont(font);
				panels.get(0).add(labels.get(labelsQtd));
				
				labels.add(new JLabel("<html><u>Nome :</u></html>"));
				labels.get(labelsQtd + 1).setBounds(screenWidth/2 - labelWidth/2 - 150, 350 + (i * squareHeight), 200, 30);	
				labels.get(labelsQtd + 1).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 1));
				
				
				labels.add(new JLabel("Filial relacionada: "));
				labels.get(labelsQtd + 2).setBounds(400, 450 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 2).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 2));
				
				labels.add(new JLabel(c.getFilialsName(searchedName).get(i)));
				labels.get(labelsQtd + 3).setBounds(720, 452 + (i * squareHeight), 500, 30);	
				labels.get(labelsQtd + 3).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 3));
				
				labels.add(new JLabel("<html><u>Valor :</u></html>"));
				labels.get(labelsQtd + 4).setBounds(300, 550 + (i * squareHeight), 200, 30);
				labels.get(labelsQtd + 4).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 4));
				
				labels.add(new JLabel(String.valueOf(c.getVehicle(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getValue())));
				labels.get(labelsQtd + 5).setBounds(500, 552 + (i * squareHeight), 400, 30);
				labels.get(labelsQtd + 5).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 5));
				
				labels.add(new JLabel("<html><u>Unidades :</u></html>"));
				labels.get(labelsQtd + 6).setBounds(850, 550 + (i * squareHeight), 200, 30);	
				labels.get(labelsQtd + 6).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 6));
				
				labels.add(new JLabel(String.valueOf(c.getVehicle(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getAmount())));
				labels.get(labelsQtd + 7).setBounds(1050, 552 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 7).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 7));
				
				labels.add(new JLabel("<html><u>Modelo :</u></html>"));
				labels.get(labelsQtd + 8).setBounds(480, 650 + (i * squareHeight), 200, 30);	
				labels.get(labelsQtd + 8).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 8));
				
				//labels.add(new JLabel(String.valueOf(vehicle.get(vehicleQtd).getBrand())));
				labels.add(new JLabel(c.getVehicle(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getModel()));
				labels.get(labelsQtd + 9).setBounds(680, 652 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 9).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 9));
				
				labels.add(new JLabel("<html><u>Marca :</u></html>"));
				labels.get(labelsQtd + 10).setBounds(300, 775 + (i * squareHeight), 200, 30);	
				labels.get(labelsQtd + 10).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 10));
				
				labels.add(new JLabel(String.valueOf(c.getVehicle(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getModel())));
				labels.get(labelsQtd + 11).setBounds(500, 777 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 11).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 11));
				
				labels.add(new JLabel("<html><u>Ano de Produção :</u></html>"));
				labels.get(labelsQtd + 12).setBounds(850, 750 + (i * squareHeight), 200, 80);	
				labels.get(labelsQtd + 12).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 12));
				
				labels.add(new JLabel(String.valueOf(c.getVehicle(c.getFilialsName(searchedName).get(i),
						c.searchPatrimony(searchedName).get(i).getName()).getProductionYear())));
				labels.get(labelsQtd + 13).setBounds(1050, 752 + (i * squareHeight), 400, 30);	
				labels.get(labelsQtd + 13).setFont(font);
				panels.get(0).add(labels.get(labelsQtd + 13));
					
					buttons.add(new JButton("Editar"));
					buttons.get(buttons.size() - 1).setBounds(450,900 + (i * squareHeight),200,30);
					panels.get(0).add(buttons.get(buttons.size() - 1));
					
					buttons.add(new JButton("Remover"));
					buttons.get(buttons.size() - 1).setBounds(850,900 + (i * squareHeight),200,30);
					panels.get(0).add(buttons.get(buttons.size() - 1));
			}
			panels.get(0).add(panels.get(panels.size() - 1));
		
		}
		
		for(int i = 0; i < buttons.size(); i++)
		{
			buttons.get(i).addActionListener(this);
		}
		
		
		
		if(c.searchPatrimony(searchedName).size() == 0)
		{
			labels.add(new JLabel("Nenhum patrimônio foi encontrado com esse nome ! :("));
			labelsQtd++;
			labels.get(labelsQtd - 1).setBounds(400, 250, 800, 40);
			labels.get(labelsQtd - 1).setFont(font);
			labels.get(labelsQtd - 1).setOpaque(true);
			labels.get(labelsQtd - 1).setBackground(new Color(250, 0, 0));
			panels.get(0).add(labels.get(labelsQtd - 1));
		}
		
		panels.get(0).add(panels.get(1));//add the panel gray
		
		panels.get(0).setPreferredSize(new Dimension (1500, c.searchPatrimony(searchedName).size() * squareHeight + 300));
		
		//Create the Scroll
		scroll = new JScrollPane(panels.get(0));
		jf.setContentPane(scroll);//add the ScrollPanel into the JFrame
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//set the position of the  ScrollPanels
		
	
		jf.setVisible(true);
	}
	
//	public static void main(String[] a ) {
//		
//		ControlerCompany ca = new ControlerCompany("ololol");
//		ca.getCompany().createFilial("minha filial");
//		
//		Buildings b = null;
//		Vehicle x = null;
//		
//		for(int i = 0; i < 5; i++)
//		{	
//			if(i%2 == 0)
//			{
//					String v = String.format("casa %d",i);
//					b = new Buildings(v,15,4000.5,3, 1500.00);
//					ca.getCompany().getFilials().get(0).add(b);
//					ca.creatAddresstoBuil("minha filial", v);
//					ca.getBuildings("minha filial", v).getAddress().setCountry("");
//					ca.getBuildings("minha filial", v).getAddress().setState("");
//					ca.getBuildings("minha filial", v).getAddress().setCity("");
//					ca.getBuildings("minha filial", v).getAddress().setStreet("");
//					ca.getBuildings("minha filial", v).getAddress().setNumber(0);
//					ca.getCompany().getFilials().get(0).add(b);
//				
//			}else {
//				String s = String.format("Carro %d",i);
//				x = new Vehicle(s,15, 20000,"Ferrari 480 Pista","Ferrari",2022);
//				ca.getCompany().getFilials().get(0).add(x);
//			}
//		}
//		SearchedPatrimonys g = new SearchedPatrimonys(ca,"   ca   ");
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int indiceLabels = 5;
		int indiceLabelsPName = 2;
		if(buttons.size() > 0)
		{
			for(int i = 0 ; i < buttons.size(); i++)
			{
				if(i % 2 == 0)
				{
					if(c.isVehicle(labels.get(indiceLabels).getText(), labels.get(indiceLabelsPName).getText()))
					{
						if(e.getSource().equals(buttons.get(i)))
						{
							jf.dispose();
							
							new EditPatrimony(labels.get(indiceLabelsPName).getText(), PatrimonyScreen.Tipo.VEHICLE,c, EditPatrimony.EDITAR,
									labels.get(indiceLabels).getText(),searchedName);
							
						}
						
					}
					
					else
					{
						if(e.getSource().equals(buttons.get(i)))
						{
							new EditPatrimony(labels.get(indiceLabelsPName).getText(), PatrimonyScreen.Tipo.BUILDINGS,c,EditPatrimony.EDITAR,
									labels.get(indiceLabels).getText(), searchedName);
						}
						
					}
					
					
				}
				else
				{
					if(e.getSource().equals(buttons.get(i)))
					{
						c.getFilial(labels.get(indiceLabels).getText()).remove(labels.get(indiceLabelsPName).getText());
						jf.dispose();
						new SearchedPatrimonys(c,searchedName);
						
					}
					
					indiceLabelsPName += 14;
					indiceLabels += 14;
					
					
				}
				
			}
		}
		
	}		
}