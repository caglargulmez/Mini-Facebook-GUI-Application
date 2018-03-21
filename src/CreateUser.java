
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import java.awt.Choice;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JEditorPane;

public class CreateUser extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public CreateUser() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 359, 419);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CreateUser.class.getResource("/img/Facebooklogo1.png")));
		label.setBounds(22, 19, 312, 75);
		contentPane.add(label);
		
		JLabel lblCreateUser = new JLabel("Create User");
		lblCreateUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCreateUser.setBounds(139, 105, 87, 14);
		contentPane.add(lblCreateUser);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 152, 107, 14);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(10, 177, 107, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password (re-type)");
		lblPassword.setBounds(10, 202, 113, 14);
		contentPane.add(lblPassword);
		
		JLabel lblName = new JLabel("Name Surname");
		lblName.setBounds(10, 227, 107, 14);
		contentPane.add(lblName);
		
		JLabel lblSchoolGraduated = new JLabel("School graduated");
		lblSchoolGraduated.setBounds(10, 252, 107, 14);
		contentPane.add(lblSchoolGraduated);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(10, 277, 107, 14);
		contentPane.add(lblBirthDate);
		
		JLabel lblRelations = new JLabel("Relationship status ");
		lblRelations.setBounds(10, 302, 107, 14);
		contentPane.add(lblRelations);
		
		textField = new JTextField();

		textField.setBounds(127, 149, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 174, 120, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 199, 120, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(127, 249, 200, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(127, 224, 200, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(127, 274, 120, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(127, 299, 121, 20);
		contentPane.add(comboBox);
		
		comboBox.addItem("Single");
		comboBox.addItem("In a relationship");
		comboBox.addItem("Divorced");
		comboBox.addItem("Complicated");
		
		
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(105, 348, 120, 23);
		contentPane.add(btnCreate);
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().equals(textField_2.getText())){
					if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty()){
						JOptionPane.showMessageDialog(contentPane,
							    "You have missed some information about user",
							    "Warning",
							    JOptionPane.WARNING_MESSAGE);
					} else{
						try {
							UserCollection.addUser(textField_3.getText(), textField.getText(), textField_1.getText(), textField_5.getText(), textField_4.getText(), (String) comboBox.getSelectedItem());
							Main.listModel.addElement(textField.getText());
							JOptionPane.showMessageDialog(contentPane, "The user was successfully created");
							dispose();
						} catch (ParseException e) {
							JOptionPane.showMessageDialog(contentPane, "Invalid date value, its format should be dd/MM/yyyy");
					}
					}
				} else{
					JOptionPane.showMessageDialog(contentPane,
						    "Passwords does not match",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				
				/*System.out.println(textField.getText() + " username : " + user.getUserName());
				System.out.println(textField_1.getText() + " password :  " +  user.getPassword());
				System.out.println(textField_2.getText() + " password : " +  user.getPassword());
				System.out.println(textField_3.getText() + " name surname : " +  user.getName());
				System.out.println(textField_4.getText() + " school graduated : " +  user.getSchoolGraduated());
				System.out.println(textField_5.getText() + " date of birth : " +  user.getDateofBirth());
				System.out.println(comboBox.getSelectedItem() + " relationship status : " +  user.getRelationshipStatus());*/
				
				
			
				
				
			}
			
		});
		
		
	
		
		
	}
}
