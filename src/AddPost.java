import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPost extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldText;
	private JTextField textFieldLatitude;
	private JTextField textFieldLongitude;
	private JTextField textFieldFilename;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private JTextField textFieldDuration;

	

	/**
	 * Create the frame.
	 */
	public AddPost(ProfilePage p) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JLabel lblLatitude = new JLabel("Latitude: ");
		lblLatitude.setBounds(21, 90, 65, 14);
		contentPane.add(lblLatitude);
		
		textFieldLatitude = new JTextField();
		textFieldLatitude.setBounds(91, 87, 89, 20);
		contentPane.add(textFieldLatitude);
		textFieldLatitude.setColumns(10);
		
		JLabel lblLongitude = new JLabel("Longitude: ");
		lblLongitude.setBounds(185, 90, 65, 14);
		contentPane.add(lblLongitude);


		textFieldLongitude = new JTextField();
		textFieldLongitude.setBounds(248, 87, 89, 20);
		contentPane.add(textFieldLongitude);
		textFieldLongitude.setColumns(10);
		
		JLabel lblPostType = new JLabel("Post Type");
		lblPostType.setBounds(21, 34, 65, 14);
		contentPane.add(lblPostType);
		/* IMAGE POST STARTS COMPONENTS ARE WRITTEN BELOW */
		/* lblFilename, textFieldFilename*/
		/* lblWidth, textFieldWidth*/
		/* lblHeight, textFieldHeight*/
		JLabel lblFilename = new JLabel("Filename:");
		lblFilename.setBounds(21, 139, 62, 14);
		contentPane.add(lblFilename);
		lblFilename.setVisible(false);
		
		textFieldFilename = new JTextField();
		textFieldFilename.setBounds(91, 136, 182, 20);
		contentPane.add(textFieldFilename);
		textFieldFilename.setColumns(10);
		textFieldFilename.setVisible(false);
		
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setBounds(21, 164, 46, 14);
		contentPane.add(lblWidth);
		lblWidth.setVisible(false);
		
		textFieldWidth = new JTextField();
		textFieldWidth.setBounds(91, 161, 65, 20);
		contentPane.add(textFieldWidth);
		textFieldWidth.setColumns(10);
		textFieldWidth.setVisible(false);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(165, 164, 46, 14);
		contentPane.add(lblHeight);
		lblHeight.setVisible(false);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setBounds(208, 161, 65, 20);
		contentPane.add(textFieldHeight);
		textFieldHeight.setColumns(10);
		textFieldHeight.setVisible(false);
		
		/* VIDEO POST COMPONENTS : */
		/* lblFilename, textFieldFilename*/
		/* lblDuration, textFieldDuration*/
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setBounds(21, 164, 62, 14);
		contentPane.add(lblDuration);
		lblDuration.setVisible(false);
		
		textFieldDuration = new JTextField();
		textFieldDuration.setBounds(91, 161, 65, 20);
		contentPane.add(textFieldDuration);
		textFieldDuration.setColumns(10);
		textFieldHeight.setVisible(false);
		textFieldDuration.setVisible(false);
		/* IMAGE POST ENDS */
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedItem().equals("Text Post")){
					
					lblFilename.setVisible(false);
					textFieldFilename.setVisible(false);
					lblWidth.setVisible(false);
					textFieldWidth.setVisible(false);
					lblHeight.setVisible(false);
					textFieldHeight.setVisible(false);
					lblDuration.setVisible(false);
					textFieldDuration.setVisible(false);
				}
				
				else if(comboBox.getSelectedItem().equals("Image Post")){
					lblDuration.setVisible(false);
					textFieldDuration.setVisible(false);
					lblFilename.setVisible(true);
					textFieldFilename.setVisible(true);
					lblWidth.setVisible(true);
					textFieldWidth.setVisible(true);
					lblHeight.setVisible(true);
					textFieldHeight.setVisible(true);
				}
				else if(comboBox.getSelectedItem().equals("Video Post")){
					lblWidth.setVisible(false);
					textFieldWidth.setVisible(false);
					lblHeight.setVisible(false);
					textFieldHeight.setVisible(false);
					lblDuration.setVisible(true);
					textFieldDuration.setVisible(true);
					lblFilename.setVisible(true);
					textFieldFilename.setVisible(true);
				}
				
				
			}
		});
		comboBox.addItem("Text Post");
		comboBox.addItem("Image Post");
		comboBox.addItem("Video Post");
		comboBox.setBounds(91, 31, 120, 20);
		contentPane.add(comboBox);
		
		JButton btnAddPost = new JButton("Add Post");
		btnAddPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.panelPostsUser.removeAll();
				for(User user : UserCollection.getUsersArray()){
					if(user.isSignedIn()){
						if(comboBox.getSelectedItem().equals("Text Post")){
							String contents = textFieldText.getText();
							Double longitude = Double.parseDouble(textFieldLongitude.getText());
							Double latitude = Double.parseDouble(textFieldLatitude.getText());
							String tagged[] = null;
							user.addTextPost(contents, longitude, latitude, tagged);
							//user.getTextPostList().get(user.getTextPostList().size()-1)
							
							
							
							
						} else if(comboBox.getSelectedItem().equals("Image Post")){
							String contents = textFieldText.getText();
							Double longitude = Double.parseDouble(textFieldLongitude.getText());
							Double latitude = Double.parseDouble(textFieldLatitude.getText());
							String tagged[] = null;
							String imageFilename = textFieldFilename.getText();
							String imageResolution = textFieldWidth.getText() + "x" + textFieldHeight.getText();
							user.addImagePost(contents, longitude, latitude, tagged, imageFilename, imageResolution);
							
							
							
							
						} else if(comboBox.getSelectedItem().equals("Video Post")){
							String contents = textFieldText.getText();
							Double longitude = Double.parseDouble(textFieldLongitude.getText());
							Double latitude = Double.parseDouble(textFieldLatitude.getText());
							String tagged[] = null;
							String videoFilename = textFieldFilename.getText();
							String videoDuration = textFieldDuration.getText();
							user.addVideoPost(contents, longitude, latitude, tagged, videoFilename, videoDuration);
							
						
									}
						
						for(User user2 : UserCollection.getUsersArray()){
							if(user2.isSignedIn()){
								for(Post post : user2.getTextPostList()){
									
									JPanel minnakPanel = new JPanel();
									//minnakPanel.setSize(483, 45);
									minnakPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									minnakPanel.setLayout(new BorderLayout(0,0));
									minnakPanel.setMaximumSize(new Dimension(600,70));
									
									JLabel labelForPost = new JLabel("<html>" + post.getText() + "</html>");
									labelForPost.setForeground(Color.BLUE);
									
									
									JLabel labelForTagged = new JLabel(UserCollection.getTaggedUsers2(post, user2.getUserName()));
									
									JButton btnTagFriend = new JButton("Tag Friends");
									btnTagFriend.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											new tagFriend(p, post).setVisible(true);
											//getPage().setVisible(false);
										}
									});
									JLabel labelForWord = new JLabel(post.getClass().getSimpleName().substring(0, 1));
									
									minnakPanel.add(btnTagFriend, BorderLayout.EAST);
									labelForWord.setFont(new Font("Tahoma", Font.BOLD, 40));
									minnakPanel.add(labelForWord, BorderLayout.LINE_START);
									minnakPanel.add(labelForTagged, BorderLayout.SOUTH);
									minnakPanel.add(labelForPost, BorderLayout.NORTH);
									minnakPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
									minnakPanel.validate();
									minnakPanel.repaint();
									p.panelPostsUser.add(minnakPanel);
								}
							}
						}
						
					
					}
				}
				dispose();
				
			}
		});
		btnAddPost.setBounds(315, 30, 89, 23);
		contentPane.add(btnAddPost);
		
		textFieldText = new JTextField();
		textFieldText.setBounds(91, 62, 313, 20);
		contentPane.add(textFieldText);
		textFieldText.setColumns(10);
		
		JLabel lblText = new JLabel("Text:");
		lblText.setBounds(21, 65, 65, 14);
		contentPane.add(lblText);
		
		
		
		
	}
}
