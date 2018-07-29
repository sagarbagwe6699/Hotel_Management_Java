import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.List;

import javax.swing.JSeparator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.Color;

public class Main {

	String availableRooms;
	String a[] = new String[20];
	private JFrame frame;
	Hotel h = new Hotel();
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_8;
	JLabel lblNewLabel_7;
	JTextArea textArea;
	DefaultListModel DLM = new DefaultListModel();
	private JTextField textField_rn;
	private JTextField textField_price;
	private JTextField textField_ac;
	private JTextField textField_cirn;
	private JTextField textField_corn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String conv (String[]a){
		String s = "";
			for(int i=0;i<20;i++){
				s=s+a[i]+"  ";
			}
		return s;
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		for(int i=0;i<20;i++){
			a[i]="";
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 770, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hotel Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(190, 11, 369, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 734, 2);
		frame.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("Add Room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rn,p,ac;
				String s;
				s=textField_rn.getText();
				rn= Integer.parseInt(s);
				s=textField_price.getText();
				p= Integer.parseInt(s);
				s=textField_ac.getText();
				ac= Integer.parseInt(s);
				
				h.addRoom(p, rn, ac);
				
				lblNewLabel_4.setText("Room Added - Room number : "+rn);
				
				textField_rn.setText("");
				textField_price.setText("");
				textField_ac.setText("");
				lblNewLabel_7.setText("");
				lblNewLabel_8.setText("");
				//DLM.addElement(rn);
				//list.setModel(DLM);
				a[h.rooms]=Integer.toString(rn);
				textArea.setText(conv(a));
			}
		});
		btnNewButton.setBounds(38, 89, 132, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_rn = new JTextField();
		textField_rn.setBounds(240, 90, 86, 20);
		frame.getContentPane().add(textField_rn);
		textField_rn.setColumns(10);
		
		textField_price = new JTextField();
		textField_price.setBounds(417, 90, 86, 20);
		frame.getContentPane().add(textField_price);
		textField_price.setColumns(10);
		
		textField_ac = new JTextField();
		textField_ac.setBounds(578, 90, 86, 20);
		frame.getContentPane().add(textField_ac);
		textField_ac.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Room number");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(240, 121, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(417, 121, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("A/C");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(578, 121, 86, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 169, 734, 8);
		frame.getContentPane().add(separator_1);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.GREEN);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(38, 146, 626, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Check In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rn;
				String s;
				s=textField_cirn.getText();
				rn= Integer.parseInt(s);
				int c = h.bookRoom(rn);
				if(c==1){
					lblNewLabel_7.setText("Check In Sucessful.");
				}
				else if(c==-1){
					lblNewLabel_7.setText("Room does not exist");
				}
				else{
					lblNewLabel_7.setText("Rooms are full");
				}
				
				textField_cirn.setText("");
				lblNewLabel_8.setText("");
				lblNewLabel_4.setText("");
				//DLM.copyInto(a);
				//DLM.remove(0);
				//list.setModel(DLM);
				
				for(int i=0;i<20;i++){
					if(a[i].equals(Integer.toString(rn))){
						for(int j=i;j<19;j++){
							a[j]=a[j+1];
						}
					}
				}
				textArea.setText(conv(a));
				
			}
			
			
		});
		btnNewButton_1.setBounds(38, 188, 132, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 281, 369, 2);
		frame.getContentPane().add(separator_2);
		
		textField_cirn = new JTextField();
		textField_cirn.setBounds(180, 188, 86, 20);
		frame.getContentPane().add(textField_cirn);
		textField_cirn.setColumns(10);
		
		textField_corn = new JTextField();
		textField_corn.setBounds(180, 294, 86, 20);
		frame.getContentPane().add(textField_corn);
		textField_corn.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Check out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rn;
				String s;
				s=textField_corn.getText();
				rn= Integer.parseInt(s);
				int p = h.checkOut(rn);
				if(p==0){
					lblNewLabel_8.setText("Checkout Unsucessful. Room is empty");
				}else{
					lblNewLabel_8.setText("Checkout Sucessful. Total bill : "+p);
				}
				textField_corn.setText("");
				lblNewLabel_7.setText("");
				lblNewLabel_4.setText("");
				int c=0;
				while(a[c]!=""){
					c++;
				}
				a[c]=Integer.toString(rn);
				textArea.setText(conv(a));
			}
		});
		btnNewButton_2.setBounds(38, 294, 132, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("Room number");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(180, 215, 86, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Room number");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(178, 318, 88, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Enter the room number");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(10, 256, 353, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Enter the room number");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(10, 355, 353, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 381, 369, 14);
		frame.getContentPane().add(separator_3);
		
		JLabel lblNewLabel_9 = new JLabel("Available rooms");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(417, 192, 247, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		textArea = new JTextArea();
		textArea.setBounds(417, 215, 286, 257);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_10 = new JLabel("6699");
		lblNewLabel_10.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_10.setBounds(10, 479, 46, 14);
		frame.getContentPane().add(lblNewLabel_10);
	}
}
