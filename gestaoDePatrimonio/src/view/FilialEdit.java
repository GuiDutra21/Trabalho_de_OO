package view;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controler.ControlerCompany;
import model.Address;

/**
 * Classe responsável por gerar a tela de edição da Filial
 * @author Guillherme Silva Dutra and Julio Roberto
 * @since 2023
 * @version 1.1
 */
public class FilialEdit implements ActionListener{
		
		private JFrame jf;
		private ControlerCompany c;
		private List<JLabel> labels;
		private List<JTextField> textFields;
		private JButton button;	
		private String filialName;
		
		/**
		 * Constutor que gera a tela de edição
		 * @param c Controler 
		 * @param filialName Nome da Filial
		 */
		public FilialEdit(ControlerCompany c, String filialName)
		{
			this.c = c;
			this.filialName = filialName;
			jf = new JFrame();
			jf.setLayout(null);
			
			jf.getContentPane().setBackground(new Color(100,150,255));
			jf.setSize( 500, 500);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			labels = new ArrayList<JLabel>();
			textFields = new ArrayList<JTextField>();
			
			
			labels.add(new JLabel("Edit os dados da Filial"));
			labels.get(0).setFont(new Font("Times New Roman",Font.BOLD, 25));
			labels.get(0).setBounds(630,10,350,50);
			
			labels.add(new JLabel("Nome da Filial :"));
			labels.get(1).setFont(new Font("Times New Roman", Font.BOLD, 20));
			labels.get(1).setBounds(420, 150, 200, 30);
			
			textFields.add(new JTextField(filialName));
			textFields.get(0).setBounds(627, 150, 285, 30);
			
			labels.add(new JLabel("<html><u>Cadastre o endereço da Filial :</html></u>"));
			labels.get(2).setBounds(637, 280, 350, 30);
			labels.get(2).setFont(new Font("Times New Roman",Font.BOLD,20));
			
			labels.add(new JLabel("País :"));
			labels.get(3).setBounds(480, 360, 100, 30);
			labels.get(3).setFont(new Font("Times New Roman",Font.BOLD, 19));
			
			textFields.add(new JTextField(c.getFilial(filialName).getAddress().getCountry()));
			textFields.get(1).setBounds(615, 360, 300, 30);
			
			labels.add(new JLabel("Estado :"));
			labels.get(4).setBounds(480, 410, 100, 30);//set the position
			labels.get(4).setFont(new Font("Times New Roman", Font.BOLD,19));//set the Font
			
			//Create the TextField of "Estado"
			textFields.add(new JTextField(c.getFilial(filialName).getAddress().getState()));
			textFields.get(2).setBounds(615, 410, 300, 30);//set the position
			
			//Create a label
			labels.add( new JLabel("Cidade :"));
			labels.get(5).setBounds(480, 460, 250, 30);//set the position
			labels.get(5).setFont(new Font("Times New Roman", Font.BOLD,19));//set the Font
			
			//Create the TextField of "Cidade"
			textFields.add(new JTextField(c.getFilial(filialName).getAddress().getCity()));
			textFields.get(3).setBounds(615, 460, 300, 30);//set the position
			
			//Create a label
			labels.add(new JLabel("Rua :"));
			labels.get(6).setBounds(480, 510, 250, 30);//set the position
			labels.get(6).setFont(new Font("Times New Roman", Font.BOLD, 19));//set the Font
			
			///Create the TextField of "Rua"
			textFields.add(new JTextField(c.getFilial(filialName).getAddress().getStreet()));
			textFields.get(4).setBounds(615, 510, 300, 30);//set the position
			
			//Create the tenth label
			labels.add( new JLabel("Número :"));
			labels.get(7).setBounds(480, 560, 260, 30);//set the position
			labels.get(7).setFont(new Font("Times New Roman",Font.BOLD, 19));//set the Font
			
			//Create the TextField of "Numero"
			textFields.add(new JTextField(c.getFilial(filialName).getAddress().getNumber()));
			textFields.get(5).setBounds(615, 560, 300, 30);//set the position
			
			button = new JButton("CADASTRAR");
			button.setBounds(660, 640, 200, 30);
			button.setBackground(Color.green);
			
			jf.add(labels.get(0));
			jf.add(labels.get(1));
			jf.add(labels.get(2));
			jf.add(labels.get(3));
			jf.add(labels.get(4));
			jf.add(labels.get(5));
			jf.add(labels.get(6));
			jf.add(labels.get(7));
			
			jf.add(textFields.get(0));
			jf.add(textFields.get(1));
			jf.add(textFields.get(2));
			jf.add(textFields.get(3));
			jf.add(textFields.get(4));
			jf.add(textFields.get(5));
			
			jf.add(button);
			
			
			textFields.get(0).addActionListener(this);
			textFields.get(1).addActionListener(this);
			textFields.get(2).addActionListener(this);
			textFields.get(3).addActionListener(this);
			textFields.get(4).addActionListener(this);
			textFields.get(5).addActionListener(this);
			
			button.addActionListener(this);
			
			jf.setVisible(true);
		}
		
		public List<JLabel> getLabels(){
			return this.labels;
		}

		
		public List<JTextField> getTextF(){
			return textFields;
		}
		
		/**
		 * Sobreescrita do Método actionPerformed da Interface ActionListener reposável por tratar os eventos dos JButtons
		 * @param e evento
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(button)) 
			{
				if(textFields.get(0).getText().isEmpty() && textFields.get(0).getText().isEmpty() && textFields.get(0).getText().isEmpty() &&
						textFields.get(0).getText().isEmpty() && textFields.get(0).getText().isEmpty() && textFields.get(0).getText().isEmpty() )
				{
					new CompanyMenu(c);
					jf.dispose();
					jf = null;
					
				} else  {
					if(textFields.get(0).getText().isEmpty()) 
					{
						JOptionPane.showMessageDialog(jf, "O nome deve ser preenchido:");
						
					} else
						{
						
							boolean verifica = false;
						
							int number = 0;
							String v = "";
							while(verifica == false && textFields.get(5).getText().isEmpty() == false) 
							{	
								try 
								{
									number = Integer.parseInt(textFields.get(5).getText());
									verifica = true;
								} catch (NumberFormatException m)
									{
										 try
										 {
											 v = JOptionPane.showInputDialog(jf, "Insira um numero ou deixe em branco:");
											 number = Integer.parseInt(v);
											 verifica = true;
										 }catch (NumberFormatException m2)
										 	{
											 	if(v.isEmpty()) 
											 	{
											 		verifica = true;
											 	}
										 	}
									}	
							}
							boolean ver = false;
							
							if(textFields.get(0).getText().equals(filialName)) 
							{
								ver = true;
							} 
							else
							{
								 ver = c.getCompany().editFilial(filialName,textFields.get(0).getText());
							}
								
							
							if(ver) {
								c.creatAddresstoFilial(textFields.get(0).getText());
								c.getFilial(textFields.get(0).getText()).getAddress().setCountry(textFields.get(1).getText());
								c.getFilial(textFields.get(0).getText()).getAddress().setState(textFields.get(2).getText());
								c.getFilial(textFields.get(0).getText()).getAddress().setCity(textFields.get(3).getText());
								c.getFilial(textFields.get(0).getText()).getAddress().setStreet(textFields.get(4).getText());
								c.getFilial(textFields.get(0).getText()).getAddress().setNumber(number);
								new CompanyMenu(c);
								jf.dispose();
								jf = null;
							} else {
								JOptionPane.showMessageDialog(jf, "Nome ja utilizado");
					
							}
						
						
						}
				}
			}
		}
	}