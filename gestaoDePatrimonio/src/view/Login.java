package view;

import java.util.List;
import java.util.ArrayList;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

import controler.ControlerCompany;
import model.Address;

import java.awt.Font;

public class Login implements ActionListener{
	
	private JFrame jf;
	private List<JLabel> labels;
	private List<JTextField> textFields;
	private JButton ready;
	private ControlerCompany c;
	
	public Login()
	{
		jf = new JFrame();
		
		//The Layout null permitted us to choose the position of the elements  
		jf.setLayout(null);
		
		//Design the Size of the Frame
		jf.setSize(300, 200);
		
		//Method that stop the Frame when we close it 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set the color of Background 
		jf.getContentPane().setBackground(new Color(100,150,255));
		
		//To put in full Screen when we run the application 
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		labels = new ArrayList<JLabel>();
		textFields = new ArrayList<JTextField>();
		
		//create the fist Label
		labels.add(new JLabel("SEJA BEM-VINDO !"));
		labels.get(0).setBounds(655,30,230,20);//Set the position
		labels.get(0).setFont(new Font("Times New Roman",Font.BOLD,25));//set the Font
		labels.get(0).setBackground(Color.green);//set the color
		labels.get(0).setOpaque(true);//method that permited to show the color
		
		//Create the second label
		labels.add(new JLabel("<html><u>Cadastre a sua compania</u></html>"));//Tag in HTML to put the text in underline 
		labels.get(1).setBounds(610, 140, 450, 40);//set the position
		labels.get(1).setFont(new Font("Times New Roman",Font.BOLD,30));//set the Font
		
		//Create the third label
		labels.add(new JLabel("Insira o nome da sua compania : "));
		labels.get(2).setBounds(635, 250, 270, 40);//set the position
		labels.get(2).setFont(new Font("Times New Roman",Font.BOLD,19));//set the Font
		
		//Create the TextField of "Insira o nome da sua compania"
		textFields.add(new JTextField());
		textFields.get(0).setBounds(643, 300, 250, 30);
		
		//Create the fourth label
		labels.add(new JLabel("<html><u>Insira o endereço da sua compania</u></html>"));
		labels.get(3).setFont(new Font("Times New Roman",Font.BOLD,20));//set the Font
		labels.get(3).setBounds(620, 400, 350, 30);//set the position
		
		//Create the fifth label
		labels.add( new JLabel("País :"));
		labels.get(4).setBounds(550, 500,75, 30);//set the position
		labels.get(4).setFont(new Font("Times New Roman",Font.BOLD,19));//set the Font
		
		//Create the TextField of "pais"
		textFields.add(new JTextField());
		textFields.get(1).setBounds(643,500,250,30);//set the position
		
		//Create the sixth label
		labels.add(new JLabel("Estado : "));
		labels.get(5).setBounds(550, 545, 75, 30);//set the position
		labels.get(5).setFont(new Font("Times New Roman", Font.BOLD,19));//set the Font
		
		//Create the TextField of "Estado"
		textFields.add(new JTextField());
		textFields.get(2).setBounds(643, 545, 250, 30);//set the position
		
		//Create the seventh label
		labels.add( new JLabel("Cidade :"));
		labels.get(6).setBounds(550, 590, 250, 30);//set the position
		labels.get(6).setFont(new Font("Times New Roman", Font.BOLD,19));//set the Font
		
		//Create the TextField of "Cidade"
		textFields.add( new JTextField());
		textFields.get(3).setBounds(643, 590, 250, 30);//set the position
		
		//Create the eighth label
		labels.add( new JLabel("Rua : "));
		labels.get(7).setBounds( 550, 635, 250, 30);//set the position
		labels.get(7).setFont(new Font("Times New Roman", Font.BOLD, 19));//set the Font
		
		///Create the TextField of "Rua"
		textFields.add( new JTextField());
		textFields.get(4).setBounds(643, 635, 250, 30);//set the position
		
		//Create the tenth label
		labels.add( new JLabel("Número : "));
		labels.get(8).setBounds(550, 680, 260, 30);//set the position
		labels.get(8).setFont(new Font("Times New Roman",Font.BOLD, 19));//set the Font
		
		//Create the TextField of "Numero"
		textFields.add( new JTextField());
		textFields.get(5).setBounds(643, 680, 250, 30);//set the position
		
		//Create the button
		ready = new JButton("CADASTRAR");
		ready.setBounds(700, 750, 120, 30);//set the position
		ready.setBackground(Color.green);
		
		//methods that add events 
		textFields.get(0).addActionListener(this);
		textFields.get(1).addActionListener(this);
		textFields.get(2).addActionListener(this);
		textFields.get(3).addActionListener(this);
		textFields.get(4).addActionListener(this);
		textFields.get(5).addActionListener(this);
		
		//add all Labels to the Frame
		jf.add(labels.get(0));
		jf.add(labels.get(1));		
		jf.add(labels.get(2));
		jf.add(labels.get(3));
		jf.add(labels.get(4));
		jf.add(labels.get(5));
		jf.add(labels.get(6));
		jf.add(labels.get(7));
		jf.add(labels.get(8));
		jf.add(ready);
		
		//add all TextField to the Frame
		jf.add(textFields.get(0));
		jf.add(textFields.get(1));
		jf.add(textFields.get(2));
		jf.add(textFields.get(3));
		jf.add(textFields.get(4));
		jf.add(textFields.get(5));
		
		ready.addActionListener(this);
		
		//set the Frame visible
		jf.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer number = 0;
		String v = "";
		if(e.getSource().equals(ready)) {
			if(textFields.get(0).getText().isEmpty()) {
				JOptionPane.showMessageDialog(jf, "O nome dever ser preenchido");
			}else {
				c = new ControlerCompany(textFields.get(0).getText());
				boolean verifica = false;
				while(verifica == false && textFields.get(5).getText().isEmpty() == false) {
					try {
						number = Integer.parseInt(textFields.get(5).getText());
						verifica = true;
					}catch (NumberFormatException n){
						try {
							
							while(verifica == false) {
								v = JOptionPane.showInputDialog(jf, "Insira numeros ou deixe vazio:");
								number = Integer.parseInt(v);
								verifica = true;
							}
							
						}catch (NumberFormatException m) {
							if(v == null)
							{
								verifica = true;
							}
							else if(v.isEmpty())
							{
								verifica = true;
							}
						}
					}
				}	
				
				c.login(textFields.get(1).getText(), textFields.get(2).getText(), textFields.get(3).getText(),
						textFields.get(4).getText(), number);
				
				jf.dispose();
				c.companyScreean();
			}
		}
	}
		

			
	public ControlerCompany getC() {
		return c;
	}
	
	
	
}