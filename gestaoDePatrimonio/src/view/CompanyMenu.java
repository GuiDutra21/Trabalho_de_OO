package view;

import javax.swing.*;

import controler.ControlerCompany;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a tela da Compania e herda da Classe ActionListener.
 * @author Guilherme Silva Dutra and Julio Roberto
 * @since 2023
 * @version 1.1
 */
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
	
	/**
	 * Método que retorna o tamanho necessário para ajustar a cor por trás da label desejada 
	 * @param label label que desejamos pintar por trás
	 * @return compriemento da pintura
	 */    
	public int textWidth(JLabel label)
	{
		FontMetrics fontMetrics = label.getFontMetrics(label.getFont());//catch the Metrics with the Font
		int textWidth = fontMetrics.stringWidth(label.getText());//into Metrics catch the width text
		int padding = 7;//to ensure that the name will appear completely 
		int labelWidth = textWidth + padding;
		return labelWidth;
	}
	
	/**
	 * Consturtor que gera a tela
	 * @param c Classe Controler
	 */
	public CompanyMenu(ControlerCompany c)
	{
		this.c = c;
		
		//create the JFrame
		jf = new JFrame();
		panels = new ArrayList<JPanel>();
		buttons = new ArrayList<JButton>();
		labels = new ArrayList<JLabel>();
		lists = new ArrayList<JList>();
		scrolls = new ArrayList<JScrollPane>();
		
		jf.setSize(1500,1500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to stop the execution when click on the red X
		
		//To put in full Screen when we run the application 
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//to catch the screenSize
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        
		FontMetrics fontMetrics;
		int labelWidth;
		Font font = new Font("Times New Roman", Font.BOLD, 30);
		
		//create the first label where all others things will be set
		panels.add(new JPanel());
		panels.get(0).setLayout(null);
		panels.get(0).setBackground(new Color(100, 145, 255));
		
		//the name of the Company 
		labels.add(new JLabel(c.getCompanyName()));
		labels.get(0).setFont(new Font("Times New Roman", Font.BOLD, 25));
		labels.get(0).setOpaque(true);
		labels.get(0).setBackground(new Color(220, 220, 220));
		fontMetrics = labels.get(0).getFontMetrics(new Font("Times New Roman", Font.BOLD, 25));//to catch the Dimensions occupied by the JLabel
		labelWidth = fontMetrics.stringWidth(labels.get(0).getText());//to catch the width occupied by the JLabel
		labels.get(0).setBounds(screenWidth/2 - labelWidth/2 + 5, 23,labelWidth,30);
		
		panels.get(0).add(labels.get(0));
		
		//the JLabel 'Company' 
		labels.add(new JLabel("Compania :"));
		labels.get(1).setBounds(screenWidth/2 - labelWidth/2 - 230, 20, 250, 30);
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
		fontMetrics = labels.get(2).getFontMetrics(new Font("Times New Roman", Font.BOLD, 20));//to catch the Dimensions occupied by the JLabel
		labelWidth = fontMetrics.stringWidth(labels.get(2).getText());//to catch the width occupied by the JLabel
		
		if(labelWidth >= 810)
		{
			labelWidth = 800;
		}
		//labelWidth = c.getCompanyAddress().length();
//		System.out.println(c.getCompanyAddress());
//		System.out.println(labelWidth);
//		System.out.println(c.getCompanyAddress().length());
		labels.get(2).setBounds(screenWidth/2 - labelWidth/2, 100, labelWidth + 15,30);
		
		//the JLabel 'Endereço'
		labels.add(new JLabel("Endereço :"));
		labels.get(3).setBounds(screenWidth/2 - labelWidth/2 - 200, 100, 200,40);
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
		fontMetrics = labels.get(4).getFontMetrics(font);//to catch the Dimensions occupied by the JLabel
		labelWidth = fontMetrics.stringWidth(labels.get(4).getText());//to catch the width occupied by the JLabel
		labels.get(4).setBounds(screenWidth/2 - labelWidth/2, 170, labelWidth, 40);
		panels.get(0).add(labels.get(4));
		
		//the JLabel 'Patrimônio líquido da Filial' 
		labels.add(new JLabel("Patrimônio líquido da Compania :"));
		labels.get(5).setFont(new Font("Times New Roman", Font.BOLD, 22));
		labels.get(5).setBounds(screenWidth/2 - labelWidth/2 - 400, 170, 350, 50);
		panels.get(0).add(labels.get(5));
		
		
		//JLabel 'Buscar pelo nome o(s) patrimônio(s) cadastrtado(s) :'
		labels.add( new JLabel("Buscar pelo nome o(s) patrimônio(s) cadastratado(s) :"));
		labels.get(6).setBounds(480, 300, 580, 50);
		labels.get(6).setFont(new Font("Times New Roman", Font.BOLD, 25));
		panels.get(0).add(labels.get(6));
		
		//Field where we will enter with the name of the patrimonys
		search = new JTextField();
		search.setBounds(500, 380, 500, 35);
		panels.get(0).add(search);
		
		//Button to search the patrimonys
		buttons.add(new JButton("Buscar"));
		buttons.get(2).setBounds(680, 460, 150, 30);;
		panels.get(0).add(buttons.get(2));
		
		//The panel that appear behind the space to search
		panels.add(new JPanel());
		panels.get(1).setBounds(380,275,750, 250);
		panels.get(1).setBackground(new Color(220, 220, 220));
		panels.get(0).add(panels.get(1));
		
		//The JLabel 'Filiais Cadastradas :'
		labels.add( new JLabel("<html><u>Filiais Cadastradas :</u><html>"));
		labels.get(7).setBounds(620, 600, 550, 50);
		labels.get(7).setFont(new Font("Times New Roman", Font.BOLD, 30));
		panels.get(0).add(labels.get(7));
		if(c.getCompany().getFilials().size() != 0)
		{
			//Create the big square gray 
			panels.add(new JPanel());
			panels.get(2).setBackground(new Color(200, 200, 200));
			panels.get(2).setBounds(200, 675, 1100, 100 + (c.getCompany().getFilials().size() * 660));
			
			//Create the Button to add a Filial
			buttons.add(new JButton("Adicionar Filial"));
			buttons.get(3).setBounds(640,725,200,30);
			buttons.get(3).setFont(new Font("Times New Roman", Font.BOLD, 17));
			panels.get(0).add(buttons.get(3));			 
			
			int panelsSize = 2;
			int labelsSize = 7;
			int listsSize = - 1;
			int scrollsSize = -1;
			int buttonsSize = 3;
			int squareHeight = 660;
			
			for(int j = 0; j < c.getCompany().getFilials().size(); j++)
			{	
				labels.add(new JLabel(c.getCompany().getFilials().get(j).getName()));
				labelsSize++;
				labels.get(labelsSize).setFont(new Font("Times New Roman", Font.BOLD, 25));
				fontMetrics = labels.get(2).getFontMetrics(font);//to catch the Dimensions occupied by the JLabel
				labelWidth = fontMetrics.stringWidth(labels.get(labelsSize).getText());//to catch the width occupied by the JLabel
				labels.get(labelsSize).setOpaque(true);
				labels.get(labelsSize).setBackground(new Color(220, 220, 220));
				labels.get(labelsSize).setBounds(screenWidth/2 - labelWidth/2 - 10, 860 + (j * squareHeight),
						textWidth(labels.get(labelsSize)), 40);
				panels.get(0).add(labels.get(labelsSize));
				
				labels.add(new JLabel("<html><u>Filial :</u></html>"));
				labelsSize++;
				labels.get(labelsSize).setFont(new Font("Times New Roman", Font.BOLD, 28));
				labels.get(labelsSize).setBounds(screenWidth/2 - labelWidth/2 - 150, 860 + (j * squareHeight), 300, 40);
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
			panels.get(0).setPreferredSize(new Dimension(200, 850 + (c.getCompany().getFilials().size() * 660)));
		}
		else
		{
			labels.add(new JLabel("Nenhuma filial cadastrada até o momento! :( "));
			labels.get(8).setBounds(510, 660, 470,50);
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
	/**
	 * Sobrescrista do método actionPerformed da Interface ActionListener que trata os eventos dos JButtons gerados na tela
	 * @param e evento
	 */
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
						jf.dispose();
						new CompanyMenu(c);
						verifica = true;
					}
				} else {
					jf.dispose();
					new CompanyMenu(c);
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