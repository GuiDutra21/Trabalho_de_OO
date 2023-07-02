package view;

import javax.swing.*;

import controler.ControlerCompany;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class FilialMenu implements ActionListener {
	private ControlerCompany c;
	private double filialValue;
	private List<JLabel> labels;
	private List<JButton> buttons;
	private List<JPanel> panels;
	private JFrame jf;
	private String name;
	private JButton voltar;
	private JButton add;
	private JButton add1;	

	public FilialMenu(ControlerCompany c,String name){
		
		super();
		this.c = c;
		this.name = name;
		voltar = new JButton("Voltar");
		voltar.setBounds(30,30 , 200, 30);
		voltar.addActionListener(this);
		
		panels = new ArrayList<JPanel>();
		buttons = new ArrayList<JButton>();
		labels = new ArrayList<JLabel>();
		
		jf = new JFrame();
		jf.setSize(1500,1500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//To put in full Screen when we run the application 
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		panels.add(new JPanel());			
		
		panels.get(0).setLayout(null);
		panels.get(0).setBackground(new Color(100, 145, 255));
		panels.get(0).add(voltar);
		
		//to catch the screenSize
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
		
		FontMetrics fontMetrics;
		int labelWidth;
		Font font = new Font("Times New Roman", Font.BOLD, 30);
		
		//the name of the filial JLabel
		labels.add(new JLabel(name));
		labels.get(0).setFont(new Font("Times New Roman", Font.BOLD, 20));
		fontMetrics = labels.get(0).getFontMetrics(new Font("Times New Roman", Font.BOLD, 20));
		labelWidth = fontMetrics.stringWidth(labels.get(0).getText());
		labels.get(0).setBounds(screenWidth/2 - labelWidth/2, 23, labelWidth + 10, 30);
		labels.get(0).setOpaque(true);
		labels.get(0).setBackground(new Color(220, 220, 220, 220));
		panels.get(0).add(labels.get(0));
		
		//the JLabel 'Filial' 
		labels.add(new JLabel("Filial :"));
		labels.get(1).setBounds(screenWidth/2 - labelWidth/2 - 150, 20, 150, 30);
		labels.get(1).setFont(new Font("Times New Roman", Font.BOLD, 30));
		panels.get(0).add(labels.get(1));
		
		buttons.add( new JButton("Editar"));
		buttons.get(0).setBounds(1200, 23, 150, 30);
		panels.get(0).add(buttons.get(0));
		
		//the JLabel of 'Endereço'
		labels.add(new JLabel(c.getFilial(name).getAddress().toString()));
		labels.get(2).setFont(new Font("Times New Roman", Font.BOLD, 20));
		fontMetrics = labels.get(2).getFontMetrics(new Font("Times New Roman",Font.BOLD, 20));
		labelWidth = fontMetrics.stringWidth(labels.get(2).getText());
		labels.get(2).setBounds(screenWidth/2 - labelWidth/2, 100,labelWidth + 10,30);
		labels.get(2).setOpaque(true);
		labels.get(2).setBackground(new Color(220, 220, 220, 220));
		
		//the JLabel 'Endereço'
		labels.add(new JLabel("Endereço :"));
		labels.get(3).setFont(new Font("Times New Roman", Font.BOLD, 25));
		labels.get(3).setBounds(screenWidth/2 - labelWidth/2 - 190, 100, 200,30);
		panels.get(0).add(labels.get(3));

		panels.get(0).add(labels.get(2));
		
		buttons.add(new JButton("Editar"));
		buttons.get(1).setBounds(1200, 100, 150, 30);
		panels.get(0).add(buttons.get(1));
		
		//the JLabel of 'Patrimônio líquido'
		labels.add(new JLabel("R$ " + Double.toString(c.getFilial(name).getValue())));
		labels.get(4).setFont(new Font("Times New Roman", Font.BOLD, 22));
		fontMetrics = labels.get(4).getFontMetrics(new Font("Times New Roman", Font.BOLD, 25));
		labelWidth = fontMetrics.stringWidth(labels.get(4).getText());
		labels.get(4).setBounds(screenWidth/2 - labelWidth/2, 170, labelWidth, 50);
		labels.get(4).setOpaque(true);
		labels.get(4).setBackground(new Color(220, 220, 220, 220));
		panels.get(0).add(labels.get(4));
		
		//the JLabel 'Patrimônio líquido da Filial' 
		labels.add(new JLabel("Patrimônio líquido da Filial :"));
		labels.get(5).setBounds(screenWidth/2 - labelWidth/2 - 400, 170, 350, 50);
		labels.get(5).setFont(new Font("Times New Roman", Font.BOLD, 22));
		panels.get(0).add(labels.get(5));
				
		labels.add( new JLabel("<html><u>Patrimônios Cadastrados :</u></html>"));
		labels.get(6).setBounds(640, 250, 350, 50);
		labels.get(6).setFont(new Font("Times New Roman", Font.BOLD, 25));
		panels.get(0).add(labels.get(6));
		
		if(c.getPatrimonys(name).size() != 0)
		{
			buttons.add(new JButton("Adicionar Veículo"));
			buttons.get(2).setBounds(450, 375, 200, 30);
			panels.get(0).add(buttons.get(2));
			
			buttons.add(new JButton("Adicionar Propriedade"));
			buttons.get(3).setBounds(850, 375, 200, 30);
			panels.get(0).add(buttons.get(3));
			
			int squareHeight = 700;
			
			//create the gray square
			panels.add(new JPanel());
			panels.get(1).setBackground(new  Color(200, 200, 200));
			panels.get(1).setBounds(125, 330, 1250, 50 + (c.getPatrimonys(name).size() * squareHeight));
			
			for (int i = 0; i < c.getPatrimonys(name).size(); i++) {
				int labelsQtd = labels.size();
			
				panels.add(new JPanel());
				
				if(c.isVehicle(name,c.getPatrimonys(name).get(i).getName()) == false)
				{						
					panels.get(panels.size() - 1).setBounds(200, 440 + (i * squareHeight), 1100, 580);
					panels.get(panels.size() - 1).setBackground((new  Color(0, 180, 0)));

					
					labels.add(new JLabel("<html><u>Nome :</u></html>"));
					labels.get(labelsQtd).setBounds(500, 480 + (i * squareHeight), 200, 30);	
					labels.get(labelsQtd).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd));
					
					labels.add(new JLabel((c.getBuildings(name,c.getPatrimonys(name).get(i).getName())).getName()));
					labels.get(labelsQtd + 1).setBounds(720, 482 + (i * squareHeight), 400, 30);
					labels.get(labelsQtd + 1).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 1));
					
					labels.add(new JLabel("<html><u>Valor :</u></html>"));
					labels.get(labelsQtd + 2).setBounds(300, 600 + (i * squareHeight), 200, 30);
					labels.get(labelsQtd + 2).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 2));
					
					labels.add(new JLabel(String.valueOf((c.getBuildings(name,c.getPatrimonys(name).get(i).getName())).getValue())));
					labels.get(labelsQtd + 3).setBounds(500, 602 + (i * squareHeight), 400, 30);
					labels.get(labelsQtd + 3).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 3));
					
					labels.add(new JLabel("<html><u>Unidades :</u></html>"));
					labels.get(labelsQtd + 4).setBounds(850, 600 + (i * squareHeight), 200, 30);	
					labels.get(labelsQtd + 4).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 4));
					
					labels.add(new JLabel(String.valueOf((c.getBuildings(name,c.getPatrimonys(name).get(i).getName())).getAmount())));
					labels.get(labelsQtd + 5).setBounds(1050, 602 + (i * squareHeight), 400, 30);	
					labels.get(labelsQtd + 5).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 5));
					
					labels.add(new JLabel("<html><u>Quantidade de andares :</u></html>"));
					labels.get(labelsQtd + 6).setBounds(850, 660 + (i * squareHeight), 200, 100);
					labels.get(labelsQtd + 6).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 6));
					
					labels.add(new JLabel(String.valueOf((c.getBuildings(name,c.getPatrimonys(name).get(i).getName())).getFloorsQtd())));
					//labels.add(new JLabel("Nao informado"));
					labels.get(labelsQtd + 7).setBounds(1050, 695 + (i * squareHeight), 400, 30);	
					labels.get(labelsQtd + 7).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 7));
					
					labels.add(new JLabel("<html><u>Metros Quadrados :</u></html>"));
					labels.get(labelsQtd + 8).setBounds(300, 660 + (i * squareHeight), 200, 100);
					labels.get(labelsQtd + 8).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 8));
					
					labels.add(new JLabel(String.valueOf(((c.getBuildings(name,c.getPatrimonys(name).get(i).getName())).getArea()))));
					labels.get(labelsQtd + 9).setBounds(500, 695 + (i * squareHeight), 400, 30);	
					labels.get(labelsQtd + 9).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 9));
					
					labels.add(new JLabel("<html><u>Endereço :</u></html>"));
					labels.get(labelsQtd + 10).setBounds(350, 815 + (i * squareHeight), 400, 30);
					labels.get(labelsQtd + 10).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 10));
					
					labels.add(new JLabel(String.valueOf(((c.getBuildings(name,c.getPatrimonys(name).get(i).getName())).getAddress()))));
					labels.get(labelsQtd + 11).setBounds(550, 817 + (i * squareHeight), 400, 30);	
					labels.get(labelsQtd + 11).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 11));				
					
					if(i == 0)
					{
						buttons.add(new JButton("Editar"));
						buttons.get(4).setBounds(450,930,200,30);
						panels.get(0).add(buttons.get(4 ));
						
						buttons.add(new JButton("Remover"));
						buttons.get(5).setBounds(850,930 ,200,30);
						panels.get(0).add(buttons.get(5));// nao ta aparecendo
					}
					else
					{	
						buttons.add(new JButton("Editar"));
						buttons.get(buttons.size() - 1).setBounds(450,930 + (i * 700),200,30);
						panels.get(0).add(buttons.get(buttons.size() - 1));
						
						buttons.add(new JButton("Remover"));
						buttons.get(buttons.size() - 1).setBounds(850,930 + (i * 700),200,30);
						panels.get(0).add(buttons.get(buttons.size() - 1));
					}			
				}
				else
				{	
					
					panels.get(panels.size() - 1).setBounds(200, 440 + (i * squareHeight), 1100, 580);
					panels.get(panels.size() - 1).setBackground((new  Color(0, 180, 0)));					
						
					
					labels.add(new JLabel("<html><u>Nome :</u></html>"));
					labels.get(labelsQtd).setBounds(500, 480 + (i * squareHeight), 200, 30);	
					labels.get(labelsQtd).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd));
					
					labels.add(new JLabel((c.getVehicle(name,c.getPatrimonys(name).get(i).getName()).getName())));
					labels.get(labelsQtd + 1).setBounds(720, 482 + (i * squareHeight), 400, 30);
					labels.get(labelsQtd + 1).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 1));
					
					labels.add(new JLabel("<html><u>Valor :</u></html>"));
					labels.get(labelsQtd + 2).setBounds(300, 600 + (i * squareHeight), 200, 30);
					labels.get(labelsQtd + 2).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 2));
					
					labels.add(new JLabel(String.valueOf((c.getVehicle(name,c.getPatrimonys(name).get(i).getName()).getValue()))));
					labels.get(labelsQtd + 3).setBounds(500, 602 + (i * squareHeight), 400, 30);
					labels.get(labelsQtd + 3).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 3));
					
					labels.add(new JLabel("<html><u>Unidades :</u></html>"));
					labels.get(labelsQtd + 4).setBounds(850, 600 + (i * squareHeight), 200, 30);	
					labels.get(labelsQtd + 4).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 4));
					
					labels.add(new JLabel(String.valueOf((c.getVehicle(name,c.getPatrimonys(name).get(i).getName()).getAmount()))));
					labels.get(labelsQtd + 5).setBounds(1050, 602 + (i * squareHeight), 400, 30);	
					labels.get(labelsQtd + 5).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 5));
					
					labels.add(new JLabel("<html><u>Modelo :</u></html>"));
					labels.get(labelsQtd + 6).setBounds(480, 690 + (i * squareHeight), 200, 30);	
					labels.get(labelsQtd + 6).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 6));
					
					labels.add(new JLabel(((c.getVehicle(name,c.getPatrimonys(name).get(i).getName()).getModel()))));
					labels.get(labelsQtd + 7).setBounds(680, 692 + (i * squareHeight), 400, 30);	
					labels.get(labelsQtd + 7).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 7));
					
					labels.add(new JLabel("<html><u>Marca :</u></html>"));
					labels.get(labelsQtd + 8).setBounds(300, 780 + (i * squareHeight), 200, 30);	
					labels.get(labelsQtd + 8).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 8));
					
					labels.add(new JLabel(String.valueOf((c.getVehicle(name,c.getPatrimonys(name).get(i).getName()).getBrand()))));
					labels.get(labelsQtd + 9).setBounds(500, 782 + (i * squareHeight), 400, 30);	
					labels.get(labelsQtd + 9).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 9));
					
					labels.add(new JLabel("<html><u>Ano de Produção :</u></html>"));
					labels.get(labelsQtd + 10).setBounds(850, 750 + (i * squareHeight), 200, 80);	
					labels.get(labelsQtd + 10).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 10));
					
					labels.add(new JLabel(String.valueOf((c.getVehicle(name,c.getPatrimonys(name).get(i).getName()).getProductionYear()))));
					labels.get(labelsQtd + 11).setBounds(1050, 765 + (i * squareHeight), 400, 30);	
					labels.get(labelsQtd + 11).setFont(new Font("Times New Roman", Font.BOLD, 30));
					panels.get(0).add(labels.get(labelsQtd + 11));
					
					if(i == 0)
					{
						buttons.add(new JButton("Editar"));
						buttons.get(4).setBounds(450,930,200,30);
						panels.get(0).add(buttons.get(4 ));
						
						buttons.add(new JButton("Remover"));
						buttons.get(5).setBounds(850,930 ,200,30);
						panels.get(0).add(buttons.get(5));// nao ta aparecendo
					}
					else
					{	
						
						buttons.add(new JButton("Editar"));
						buttons.get(buttons.size() - 1).setBounds(450,930 + (i * 700),200,30);
						panels.get(0).add(buttons.get(buttons.size() - 1));
						
						buttons.add(new JButton("Remover"));
						buttons.get(buttons.size() - 1).setBounds(850,930 + (i * 700),200,30);
						panels.get(0).add(buttons.get(buttons.size() - 1));
					}
				}
				
				panels.get(0).add(panels.get(panels.size() - 1));
			}
			
//			for(int i = 0; i < buttons.size(); i++)
//			{
//				buttons.get(i).addActionListener(this);
//			}
			
			panels.get(0).add(panels.get(1));//add the panel gray
		} 
		else 
		{
			
			add = new JButton("Adicionar Veículo");
			add.setBounds(500, 320 , 200, 30);
			add.addActionListener(this);
			panels.get(0).add(add);
			
			add1 = new JButton("Adicionar Propriedade");
			add1.setBounds(800, 320 , 200, 30);
			add1.addActionListener(this);
			panels.get(0).add(add1);
		}
		
		for(int i = 0; i < buttons.size(); i++)
		{
			buttons.get(i).addActionListener(this);
		}
		
		panels.get(0).setPreferredSize(new Dimension(200, 450 + (c.getPatrimonys(name).size() * 700)));//allow to create the scroll
		
		JScrollPane scrollPane = new JScrollPane(panels.get(0));
		jf.setContentPane(scrollPane);	
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jf.setVisible(true);
		
//		for(int i = 0; i < buttons.size(); i++) {
//			buttons.get(i).addActionListener(this);
//		}
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(voltar)) 
		{
			jf.dispose();
			new CompanyMenu(c);
		}
//-------------------------------Button 0 --------------------------------------------------------------		
		if(e.getSource().equals(buttons.get(0))) 
		{
			boolean verifica = false;
			while(verifica == false) 
			{
				String novoNome = JOptionPane.showInputDialog(jf, "Digite o novo nome:");
				if(novoNome != null) 
				{
					if(novoNome.isEmpty()) 
					{
						verifica = true;
					} else {
						if(c.getCompany().editFilial(this.name, novoNome))
						{
							this.name = novoNome;
							//labels.get(0).setText(novoNome);
							new FilialMenu(c,novoNome);
							verifica = true;
							
						} 
						else 
						{
							JOptionPane.showMessageDialog(jf, "Nome utilizado");
						}
						
					}
				}
				else 
				{
					verifica = true;
					new FilialMenu(c,novoNome);
				}
			}
		}
//------------------------------------Button(1)--------------------------------------------------
		if(e.getSource().equals(buttons.get(1)))
		{
			
			c.editAddress(c,ControlerCompany.IS_FILIAL, name);
			jf.dispose();
			jf = null;
				
		}
//-----------------------------------Button add ---------------------------------------------------
		if(e.getSource().equals(add))
		{
			jf.dispose();;
			new PatrimonyScreen(PatrimonyScreen.Tipo.VEHICLE,c, name);
			
		}
		
		if(e.getSource().equals(add1))
		{
			jf.dispose();
			new PatrimonyScreen(PatrimonyScreen.Tipo.BUILDINGS,c , name);
			
		}
//-----------------------------------------------------------------------------------------------------
		if(buttons.size() > 2 )
		{
			if(e.getSource().equals(buttons.get(2)))
			{
				jf.dispose();
				new PatrimonyScreen(PatrimonyScreen.Tipo.VEHICLE,c, name);
			}
			else if(e.getSource().equals(buttons.get(3)))
			{
				jf.dispose();
				new PatrimonyScreen(PatrimonyScreen.Tipo.BUILDINGS,c , name);
			}
		}
		
		if(buttons.size() > 4) {
			int labelsindice = 8;
			for(int i = 4; i < buttons.size(); i++) 
			{
				if(i % 2 == 0) 
				{
					if(e.getSource().equals(buttons.get(i)))
					{
						if(c.isVehicle(name, labels.get(labelsindice).getText()))
						{
							System.out.println(i);
							System.out.println(labelsindice);
							jf.dispose();
							new EditPatrimony(labels.get(labelsindice).getText(),PatrimonyScreen.Tipo.VEHICLE,c,name);
						}
						else
						{
							jf.dispose();
							new EditPatrimony(labels.get(labelsindice).getText(),PatrimonyScreen.Tipo.BUILDINGS,c, name);
						}
					}
				}
				else 
				{
					if(e.getSource().equals(buttons.get(i)))
					{
						c.getCompany().remove(name,labels.get(labelsindice).getText());
						jf.dispose();
						new FilialMenu(c,name);
						
					}
					labelsindice+= 12;
					
				}
				
			}
		}
	
		
	}
}