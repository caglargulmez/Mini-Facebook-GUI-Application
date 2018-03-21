

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Window.Type;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.ListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
public class Main {
	static DefaultListModel<String> listModel = new DefaultListModel<>();
	private JFrame frmFdasgag;
	private JTextField textField;
	private JPasswordField passwordField;

	
	public static User userObject(String username){
		for(User user : UserCollection.getUsersArray()){
			if(user.getUserName().equals(username)){return user;}
		}
		return null;
	}
	
	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		
		Scanner scannerUsers = new Scanner(new FileReader(args[0]));
		Scanner scannerCommands = new Scanner(new FileReader(args[1]));
		
		String dataUsers;
		String dataCommands;
	
		while(scannerUsers.hasNextLine()) {
			dataUsers = scannerUsers.nextLine();
			String[] paramsUsers = dataUsers.split("\t");
			UserCollection.addUser(paramsUsers[0], paramsUsers[1], paramsUsers[2], paramsUsers[3], paramsUsers[4], paramsUsers[5]);
			
			//System.out.println(UserCollection.getUsersArray());
		}
		
		while(scannerCommands.hasNextLine()) {
			dataCommands = scannerCommands.nextLine();
			String[] paramsCommands = dataCommands.split("\t");
			switch(paramsCommands[0]) {
			
			case "ADDFRIEND":
				//System.out.println("-----------------------");
				//System.out.println("Command: " + dataCommands );
			
				try{
					userObject(paramsCommands[1]).addFriend(paramsCommands[2]);
					userObject(paramsCommands[2]).addFriend(paramsCommands[1]);
					//System.out.println(userObject(paramsCommands[1]).getFriendList());
					
				}
				catch(Exception e) {System.out.println("");}
			break;
			
			case "BLOCKFRIEND":
				//System.out.println("-----------------------");
				//System.out.println("Command: " + dataCommands );
				
				try{
					userObject(paramsCommands[1]).block(paramsCommands[2]);
					userObject(paramsCommands[2]).block(paramsCommands[1]);
				}
				catch(Exception e) {System.out.println("");}
			break;
			
			case "ADDPOST-TEXT":
				//System.out.println("-----------------------");
				//System.out.println("Command: " + dataCommands );
				
				String contents = paramsCommands[2];
				Double longitude = Double.parseDouble(paramsCommands[3]);
				Double latitude = Double.parseDouble(paramsCommands[4]);
				String[] tagged = paramsCommands[5].split(":");
				try{
				userObject(paramsCommands[1]).addTextPost(contents, longitude, latitude, tagged);
				}
				catch(Exception e){
					//System.out.println("Error: Please sign in and try again.");
					System.out.println();
				}
				break;
				
			case "ADDPOST-IMAGE":
				//System.out.println("-----------------------");
				//System.out.println("Command: " + dataCommands );
				String contents2 = paramsCommands[2];
				Double longitude2 = Double.parseDouble(paramsCommands[3]);
				Double latitude2 = Double.parseDouble(paramsCommands[4]);
				String[] tagged2 = paramsCommands[5].split(":");
				String filename = paramsCommands[6];
				String resolution = paramsCommands[7];
				
				try{
					userObject(paramsCommands[1]).addImagePost(contents2, longitude2, latitude2, tagged2, filename, resolution);
				}
				catch(Exception e){
					//System.out.println("Error: Please sign in and try again.");
					System.out.println();
				}
				
				break;
				
			case "ADDPOST-VIDEO":
				//System.out.println("-----------------------");
				//System.out.println("Command: " + dataCommands );
				String contents3 = paramsCommands[2];
				Double longitude3 = Double.parseDouble(paramsCommands[3]);
				Double latitude3 = Double.parseDouble(paramsCommands[4]);
				String[] tagged3 = paramsCommands[5].split(":");
				String filename2 = paramsCommands[6];
				String duration = paramsCommands[7];
				try{
					
						userObject(paramsCommands[1]).addVideoPost(contents3, longitude3, latitude3, tagged3, filename2, duration);
					
					}
					catch(Exception e){
						//System.out.println("Error: Please sign in and try again.");
						System.out.println();
					}
				
				break;
			
			
			
			}//end switch
		}//end while for commands
		
		
		
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Main window = new Main();
					window.frmFdasgag.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmFdasgag = new JFrame();
		
		frmFdasgag.setResizable(false);
		frmFdasgag.setTitle("Facebook Login Page");
		frmFdasgag.setBounds(500, 250, 550, 425);
		frmFdasgag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFdasgag.getContentPane().setLayout(new BoxLayout(frmFdasgag.getContentPane(), BoxLayout.X_AXIS));
		frmFdasgag.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frmFdasgag.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/img/Facebooklogo1.png")));
		lblNewLabel.setBounds(10, 27, 305, 108);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(325, 63, 60, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(325, 91, 60, 14);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(395, 65, 133, 20);
		panel.add(textField);
		textField.setColumns(10);
		JList list = new JList(listModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println(UserCollection.getDictName().get(list.getSelectedValue()).getPassword());
				//UserCollection.getDictUserName().get((String) list.getSelectedValue()).getPassword();
				textField.setText((String) list.getSelectedValue());
				passwordField.setText(UserCollection.getDictName().get(list.getSelectedValue()).getPassword());
				
			}
		});
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setVisibleRowCount(2);
		list.setBounds(10, 182, 518, 50);
		panel.add(list);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(UserCollection.getDictName().size());
				//System.out.println(UserCollection.getUsersArray().size());
				if(UserCollection.getDictName().get(list.getSelectedValue()).getPassword().equals(passwordField.getText())){
					UserCollection.signIn(textField.getText(), UserCollection.getDictName().get(list.getSelectedValue()).getPassword());
					JOptionPane.showMessageDialog(panel, "You have been successfully logged in");
					
					new ProfilePage().setVisible(true);
					
					
				}
				else{
					JOptionPane.showMessageDialog(panel, "The Username or Password is incorrect, please try again");
				}
				
				
			}
		});
		btnNewButton.setBounds(395, 122, 133, 23);
		panel.add(btnNewButton);
		
		for(User user : UserCollection.getUsersArray()){
			listModel.add(0, user.getUserName());
		}
		
		
		
		
		JLabel lblRegisteredUsers = new JLabel("Registered Users");
		lblRegisteredUsers.setBounds(10, 243, 109, 14);
		panel.add(lblRegisteredUsers);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(null, "Are you sure that you want to remove this user?", null, JOptionPane.YES_NO_OPTION);
				
				//listModel.remove(listModel.indexOf(UserCollection.getDictName().get(list.getSelectedValue())));
				if(check == JOptionPane.YES_OPTION){
					
					
					UserCollection.removeUser((String) list.getSelectedValue());
					listModel.removeElement(list.getSelectedValue());
					textField.setText("");
					passwordField.setText("");
					JOptionPane.showMessageDialog(panel, "The user was successfully removed");
				}
				else{
					System.out.println();
					
				}
		}});
		btnRemoveUser.setBounds(10, 347, 162, 23);
		panel.add(btnRemoveUser);
		
		JButton btnNewUser = new JButton("New User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new CreateUser().setVisible(true);
				
				
			}
		});
		
		btnNewUser.setBounds(375, 347, 153, 23);
		panel.add(btnNewUser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(395, 88, 133, 20);
		panel.add(passwordField);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 275, 518, 61);
		panel.add(scrollPane);
	}
}
