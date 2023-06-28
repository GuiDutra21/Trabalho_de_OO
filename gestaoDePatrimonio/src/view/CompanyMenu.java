package view;

import javax.swing.*;

import controler.ControlerCompany;
import model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CompanyMenu implements ActionListener{
	
	private List<JLabel> labels;
	private JButton button1;
	private List<JButton> buttons;
	private List<JPanel> panels;
	private List<JList> lists;
	private List<JScrollPane> scrolls;
	private JFrame jf;
	private ControlerCompany c;
	private JTextField search;
	
	public int textWidth(JLabel label)
	{
		FontMetrics fontMetrics = label.getFontMetrics(label.getFont());//catch the Metrics with the Font
		int textWidth = fontMetrics.stringWidth(label.getText());//into Metrics catch the width text
		int padding = 7;//to ensure that the name will appear completely 
		int labelWidth = textWidth + padding;
		return labelWidth;
	}
	
	public CompanyMenu(ControlerCompany c)
	{
		this.c = c;
		jf = new JFrame();
		panels = new ArrayList<JPanel>();
		buttons = new ArrayList<JButton>();
		labels = new ArrayList<JLabel>();
		lists = new ArrayList<JList>();
		scrolls = new ArrayList<JScrollPane>();
		
		//create the JFrame
		JFrame jf = new JFrame();
		jf.setSize(1500,1500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to stop the execution when click on the red X
		
		//To put in full Screen when we run the application 
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//create the first label where all others things will be set
		panels.add(new JPanel());
		panels.get(0).setLayout(null);
		panels.get(0).setBackground(new Color(100, 145, 255));
		
		int x = jf.getWidth()/2;
		
		//the name of the Company 
		labels.add(new JLabel(c.getCompanyName()));
		labels.get(0).setFont(new Font("Times New Roman", Font.BOLD, 25));
		labels.get(0).setOpaque(true);
		labels.get(0).setBackground(new Color(220, 220, 220));
		labels.get(0).setBounds(x - (labels.get(0).getText().length()*4), 23,textWidth(labels.get(0)),30);
		
		panels.get(0).add(labels.get(0));
		
		//the JLabel 'Company' 
		labels.add(new JLabel("Compania :"));
		labels.get(1).setBounds(x - (labels.get(0).getText().length()*4) - 240, 20, 250, 30);
		labels.get(1).setFont(new Font("Times New Roman", Font.BOLD, 30));
		panels.get(0).add(labels.get(1));
		
		//Button 'editar' to edit the Company Name
		buttons.add( new JButton("Editar"));
		buttons.get(0).setBounds(1200, 23, 150, 30);
		panels.get(0).add(buttons.get(0));
		
		//the JLabel of 'Endereço'
		labels.add(new JLabel(c.getCompanyAddress()));
		labels.get(2).setOpaque(true);
		labels.get(2).setBackground(new Color(220, 220, 220));
		labels.get(2).setFont(new Font("Times New Roman", Font.BOLD,20));
		labels.get(2).setBounds(x - (labels.get(2).getText().length()*4), 100,textWidth(labels.get(2)) + 10,30);
		
		//the JLabel 'Endereço'
		labels.add(new JLabel("Endereço :"));
		labels.get(3).setBounds(x - (labels.get(2).getText().length()*4) - 190, 100, 200,30);
		labels.get(3).setFont(new Font("Times New Roman", Font.BOLD, 25));
		panels.get(0).add(labels.get(3));

		//add the label to show in front of the JPanelz
		panels.get(0).add(labels.get(2));
		
		//The JButotn that edit the Address
		buttons.add( new JButton("Editar"));
		buttons.get(1).setBounds(1200, 100, 150, 30);
		panels.get(0).add(buttons.get(1));
		
		//the JLabel of 'Patrimônio líquido'
		labels.add(new JLabel("R$ " + Double.toString(c.getCompany().getValue())));
		labels.get(4).setFont(new Font("Times New Roman", Font.BOLD, 22));
		labels.get(4).setOpaque(true);
		labels.get(4).setBackground(new Color(220, 220, 220));
		labels.get(4).setBounds(x - (labels.get(4).getText().length()*4), 170, textWidth(labels.get(4)), 40);
		panels.get(0).add(labels.get(4));
		
		//the JLabel 'Patrimônio líquido da Filial' 
		labels.add(new JLabel("Patrimônio líquido da Compania :"));
		labels.get(5).setFont(new Font("Times New Roman", Font.BOLD, 22));
		labels.get(5).setBounds(x - (labels.get(4).getText().length()*4) - 420, 170, 350, 50);
		panels.get(0).add(labels.get(5));
		
		
		//JLabel 'Buscar pelo nome o(s) patrimônio(s) cadastrtado(s) :'
		labels.add( new JLabel("Buscar pelo nome o(s) patrimônio(s) cadastratado(s) :"));
		labels.get(6).setBounds(520, 300, 580, 50);
		labels.get(6).setFont(new Font("Times New Roman", Font.BOLD, 25));
		panels.get(0).add(labels.get(6));
		
		//Field where we will enter with the name of the patrimonys
		search = new JTextField();
		search.setBounds(520, 380, 510, 35);
		panels.get(0).add(search);
		
		//Button to search the patrimonys
		buttons.add(new JButton("Buscar"));
		buttons.get(2).setBounds(695, 460, 150, 30);;
		panels.get(0).add(buttons.get(2));
		
		//The panel that appear behind the space to search
		panels.add(new JPanel());
		panels.get(1).setBounds(395,275,750, 250);
		panels.get(1).setBackground(new Color(220, 220, 220));
		panels.get(0).add(panels.get(1));
		
		//The JLabel 'Filiais Cadastradas :'
		labels.add( new JLabel("<html><u>Filiais Cadastradas :</u><html>"));
		labels.get(7).setBounds(635, 600, 550, 50);
		labels.get(7).setFont(new Font("Times New Roman", Font.BOLD, 30));
		panels.get(0).add(labels.get(7));
		if(c.getCompany().getFilials().size() != 0)
		{
			//Create the big square gray 
			panels.add(new JPanel());
			panels.get(2).setBackground(new Color(200, 200, 200));
			panels.get(2).setBounds(200, 675, 1100, 575 + (c.getCompany().getFilials().size() * 560));
			
			//Create the Button to add a Filial
			buttons.add(new JButton("Adicionar Filial"));
			buttons.get(3).setBounds(665,725,200,30);
			buttons.get(3).setFont(new Font("Times New Roman", Font.BOLD, 17));
			panels.get(0).add(buttons.get(3));			 
			
			int panelsSize = 2;
			int labelsSize = 7;
			int listsSize = - 1;
			int scrollsSize = -1;
			int buttonsSize = 3;
			int squareHeight = 650;
			
			for(int j = 0; j < c.getCompany().getFilials().size(); j++)
			{	
				labels.add(new JLabel(c.getCompany().getFilials().get(j).getName()));
				labelsSize++;
				labels.get(labelsSize).setFont(new Font("Times New Roman", Font.BOLD, 25));
				labels.get(labelsSize).setOpaque(true);
				labels.get(labelsSize).setBackground(new Color(220, 220, 220));
				labels.get(labelsSize).setBounds(x - labels.get(labelsSize).getText().length()*4 - 25, 860 + (j * squareHeight),
						textWidth(labels.get(labelsSize)), 40);
				panels.get(0).add(labels.get(labelsSize));
				
				labels.add(new JLabel("<html><u>Filial :</u></html>"));
				labelsSize++;
				labels.get(labelsSize).setFont(new Font("Times New Roman", Font.BOLD, 28));
				labels.get(labelsSize).setBounds(x - labels.get(labelsSize - 1).getText().length()*4 - 160, 860 + (j * squareHeight), 300, 40);
				panels.get(0).add(labels.get(labelsSize));
				
				labels.add(new JLabel("<html><u>Patrimônios dessa Filial:</u></html>"));
				labelsSize++;
				labels.get(labelsSize).setFont(new Font("Times New Roman", Font.BOLD, 25));
				labels.get(labelsSize).setBounds(630, 985 + (j * squareHeight), 300, 40);
				panels.get(0).add(labels.get(labelsSize));
				
				lists.add(new JList<>(c.patrimonyNames(c.getCompany().getFilials().get(j))));
				listsSize++;
				lists.get(listsSize).setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				scrolls.add(new JScrollPane(lists.get(listsSize)));
				scrollsSize++;
				scrolls.get(scrollsSize).setBounds(580,1035 + (j * squareHeight), 340, 122);
				panels.get(0).add(scrolls.get(scrollsSize));
				
				buttons.add(new JButton("Consultar Filial"));
				buttonsSize++;
				buttons.get(buttonsSize).setBounds(650,1220 + (j * squareHeight), 200, 30);
				panels.get(0).add(buttons.get(buttonsSize));
				
				buttons.add(new JButton("Editar Filial"));
				buttonsSize++;
				buttons.get(buttonsSize).setBounds(510,1280 + (j * squareHeight), 200, 30);
				panels.get(0).add(buttons.get(buttonsSize));
				
				buttons.add(new JButton("Remover Filial"));
				buttonsSize++;
				buttons.get(buttonsSize).setBounds(790,1280 + (j * squareHeight), 200, 30);
				panels.get(0).add(buttons.get(buttonsSize));
				
				//The squares green
				panels.add(new JPanel());
				panelsSize++;
				panels.get(panelsSize).setBounds(400, 800 + (j * squareHeight), 700, 560);
				panels.get(panelsSize).setBackground(new Color(0, 180,0));
				panels.get(0).add(panels.get(panelsSize));
				
			}
			
			//add the square gray here to it appear behind the others elements in the Screen
			panels.get(0).add(panels.get(2));
			
			//method that allow to extend the screen with the ScrollPanel
			panels.get(0).setPreferredSize(new Dimension(200, 1650 + (c.getCompany().getFilials().size() * 510)));
		}
		else
		{
			labels.add(new JLabel("Nenhuma filial cadastrada até o momento!"));
			labels.get(8).setBounds(550, 660, 450,50);
			labels.get(8).setOpaque(true);
			labels.get(8).setBackground(Color.RED);
			labels.get(8).setFont(new Font("Times New Roman",Font.BOLD, 25));
			panels.get(0).add(labels.get(8));
			button1 = new JButton("Adicionar Filial");
			button1.setBounds(1200, 660, 150, 40);
			button1.addActionListener(this);
			panels.get(0).add(button1);
			
		}
			//create the ScrollPanel and pass the Panel 
			JScrollPane scrollPane = new JScrollPane(panels.get(0));
			jf.setContentPane(scrollPane);//add the ScrollPanel into the JFrame
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//set the position of the  ScrollPanels
			jf.setVisible(true);
			
			for(int i = 0; i < buttons.size(); i++) {
				buttons.get(i).addActionListener(this);
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(buttons.get(0))) {
			boolean verifica = false;
			while(verifica == false) {
				String novoNome = JOptionPane.showInputDialog(jf, "Digite o novo nome:");
				if(novoNome != null) {
					if(novoNome.isEmpty()) {
						verifica = true;
					} else {
						c.setCompanyName(novoNome);
						labels.get(0).setText(novoNome);
						verifica = true;
					}
				} else {
					verifica = true;
				}
			
				
			}
		}
		
		if(e.getSource().equals(buttons.get(1))){
			
			jf.dispose();
			c.editAddress(c, ControlerCompany.IS_COMPANY);
		}
		
		if(e.getSource().equals(buttons.get(2)))
		{	
			jf.dispose();
			new SearchedPatrimonys(c, search.getText());		
		}
		
		if(e.getSource().equals(button1)) {
			jf.dispose();
			new FilialScreen(c);
		
		}
		
		if(buttons.size() >=4  && e.getSource().equals( buttons.get(3))) {
			jf.dispose();
			new FilialScreen(c);
		}
		
		int indiceFiliais = -1;

		for(int i = 0; i < c.getCompany().getFilials().size() * 3;i+= 3) {
			indiceFiliais ++;
			
			if(e.getSource().equals(buttons.get(4 + i))) 
			{
				jf.dispose();
				new FilialMenu(c,c.getCompany().getFilials().get(indiceFiliais).getName());
			
			} 
			else if(e.getSource().equals(buttons.get(5 + i))) 
			{
				 jf.dispose();
				 new FilialEdit(c,c.getCompany().getFilials().get(indiceFiliais).getName());
			}
			else if(e.getSource().equals(buttons.get(6 + i)))
			{
				c.getCompany().remove(c.getCompany().getFilials().get(indiceFiliais));
				jf.dispose();
				new CompanyMenu(c);
			}
		
		}
		
		
		
	}
}