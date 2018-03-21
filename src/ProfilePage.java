
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Scrollbar;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.List;
import java.awt.Button;
import javax.swing.border.TitledBorder;
import javax.swing.text.Position;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ProfilePage extends JFrame {
	static DefaultListModel<String> listModelRadio= new DefaultListModel<>();
	DefaultListModel<String> listModel2 = new DefaultListModel<>();
	private JPanel contentPaneFriend;
	private JPanel contentPane;
	private JTextField textFieldDateOfBirth1;
	private JTextField textFieldSchool1;
	private JTextField txtXd;
	private JTextField textField_2;
	JList searchList = new JList(listModel2);
	JPanel panelPostsUser = new JPanel();
	JPanel panelPostsFriends = new JPanel();
	JPanel panelPostsUser2 = new JPanel();
	JPanel panelPostsFriends2 = new JPanel();
	JScrollPane scrollPane = new JScrollPane(panelPostsUser);
	private JTextField textFieldSearch;
	
	
	public static User currentUser() {								
		for(User user: UserCollection.getUsersArray()) {	
			//System.out.println(user.getName());
			if(user.isSignedIn()) {return user;}					
		}																		
		return null;															
	}
	
	public User friend(Object object){
		for(User user : UserCollection.getUsersArray()){
			if(user.getName().equals(object)){
				return user;
			}
		}
		return null;
	}
	public User friend2(String object){
		for(User user : UserCollection.getUsersArray()){
			if(user.getUserName().equals(object)){
				return user;
			}
		}
		return null;
	}
	
	public ProfilePage getPage(){
		return this;
	}
	/**
	 * Create the frame.
	 */
	public ProfilePage() {
		setTitle("Profile Page");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 856, 877);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		getPage().setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Create Post");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddPost(getPage()).setVisible(true);
				
			}
		});
		btnNewButton.setBounds(577, 5, 142, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 34, 150, 152);
		lblNewLabel.setIcon(new ImageIcon(ProfilePage.class.getResource("/img/personicon8.png")));
		contentPane.add(lblNewLabel);
		
		JLabel lblDateOfBirth1 = new JLabel("Date of Birth");
		lblDateOfBirth1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfBirth1.setBounds(29, 247, 126, 14);
		contentPane.add(lblDateOfBirth1);
		
		JLabel lblSchool = new JLabel("School Graduated");
		lblSchool.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSchool.setBounds(29, 291, 126, 14);
		contentPane.add(lblSchool);
		
		JLabel lblRelationshipStatus = new JLabel("Relationship Status");
		lblRelationshipStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelationshipStatus.setBounds(29, 335, 126, 14);
		contentPane.add(lblRelationshipStatus);
		
		JLabel relationshiplabel = new JLabel("");
		relationshiplabel.setBounds(29, 348, 126, 23);
		contentPane.add(relationshiplabel);
		JComboBox<String> comboBoxRelationShip = new JComboBox<String>();
		comboBoxRelationShip.setVisible(false);
		for(User user : UserCollection.getUsersArray()){
			if(user.isSignedIn()){
				relationshiplabel.setText(user.getRelationshipStatus());
				//comboBox_1.setSelectedItem(user.getRelationshipStatus());
				
			}
		}
		comboBoxRelationShip.setEditable(false);
		comboBoxRelationShip.setBounds(29, 349, 151, 20);
		contentPane.add(comboBoxRelationShip);
		
		
		
		JList list = new JList(listModelRadio);
		list.setBounds(19, 496, 190, 167);
		contentPane.add(list);
		
		JLabel lblNewLabel_3 = new JLabel("Friends");
		lblNewLabel_3.setBounds(20, 457, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		
		
		JRadioButton btonNormal = new JRadioButton("Normal");
		listModelRadio.clear();
		for(User user : UserCollection.getUsersArray()){
			if(user.isSignedIn()){
				for(User friend : user.getFriendList()){
					listModelRadio.addElement(friend.getUserName());
				}
			}
		}
		btonNormal.setSelected(true);
		
		btonNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModelRadio.clear();
				for(User user : UserCollection.getUsersArray()){
					if(user.isSignedIn()){
						for(User friend : user.getFriendList()){
							listModelRadio.addElement(friend.getUserName());
						}
					}
				}
			}
		});
		btonNormal.setBounds(70, 453, 73, 23);
		contentPane.add(btonNormal);
		
		JRadioButton btnBlocked = new JRadioButton("Blocked");
		btnBlocked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModelRadio.clear();
				for(User user : UserCollection.getUsersArray()){
					if(user.isSignedIn()){
						for(User blocked : user.getBlockedUserList()){
							listModelRadio.addElement(blocked.getUserName());
						}
					}
				}
			}
		});
		btnBlocked.setBounds(142, 453, 81, 23);
		contentPane.add(btnBlocked);
		
		ButtonGroup group = new ButtonGroup();
		group.add(btonNormal);
		group.add(btnBlocked);
		
		
		JButton btnNewButton_2 = new JButton("Remove Selected User");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBlocked.isSelected()){
					for(User user : UserCollection.getUsersArray()){
						if(user.isSignedIn()){
							Iterator<User> iter = user.getBlockedUserList().iterator();
							while(iter.hasNext()){
								if(iter.next().getUserName().equals(list.getSelectedValue())){
									iter.remove();
									listModelRadio.removeElement(list.getSelectedValue());
								}
							}
						}
					}
				}
				else if(btonNormal.isSelected()){
					for(User user : UserCollection.getUsersArray()){
						if(user.isSignedIn()){
							/*Iterator<Post> iter3 = user.getTextPostList().iterator();
							while(iter3.hasNext()){
								if(iter3.next().getTaggedUsers().contains(list.getSelectedValue())){
									System.out.println(iter3.next().getText() + iter3.next().getTaggedUsers());
									iter3.remove();
									System.out.println(iter3.next().getText() + iter3.next().getTaggedUsers());
								}
							}*/
							Iterator<User> iter2 = user.getFriendList().iterator();
							while(iter2.hasNext()){
								if(iter2.next().getUserName().equals(list.getSelectedValue())){
									iter2.remove();
									listModel2.removeElement(UserCollection.getDictName().get((String) list.getSelectedValue()).getName());
									listModelRadio.removeElement(list.getSelectedValue());
									//listModel2.remove(listModel2.indexOf(iter2.next().getName())-1);
									//listModel2.removeElement(iter2.next().getName());
									//System.out.println(user.getFriendList().size());
								}
							}
							
							panelPostsUser.removeAll();
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
										/*
									 	JButton btnNewButton_3 = new JButton("Tag Users");
										btnNewButton_3.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												new tagFriend(getPage()).setVisible(true);;
											}
										});
										btnNewButton_3.setBounds(729, 189, 89, 23);
										contentPane.add(btnNewButton_3);
										*/
										
										
										JLabel labelForTagged = new JLabel(UserCollection.getTaggedUsers2(post, user2.getUserName()));
										
										JButton btnTagFriend = new JButton("Tag Friends");
										btnTagFriend.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												new tagFriend(getPage(), post).setVisible(true);
												//getPage().setVisible(false);
											}
										});
										minnakPanel.add(btnTagFriend);
										
										JLabel labelForWord = new JLabel(post.getClass().getSimpleName().substring(0, 1));
										
										minnakPanel.add(btnTagFriend, BorderLayout.EAST);
										labelForWord.setFont(new Font("Tahoma", Font.BOLD, 40));
										minnakPanel.add(labelForWord, BorderLayout.LINE_START);
										minnakPanel.add(labelForTagged, BorderLayout.SOUTH);
										minnakPanel.add(labelForPost, BorderLayout.NORTH);
										minnakPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
										minnakPanel.validate();
										minnakPanel.repaint();
										panelPostsUser.add(minnakPanel);
									}
								}
							}
							panelPostsFriends.removeAll();
							for(User user3 : UserCollection.getUsersArray()){
								if(user3.isSignedIn()){
									for(User friend : user3.getFriendList()){
										for(Post p : friend.getTextPostList()){
											JPanel minnakPanel = new JPanel();
											//minnakPanel.setSize(483, 45);
											minnakPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
											minnakPanel.setLayout(new BorderLayout(0,0));
											minnakPanel.setMaximumSize(new Dimension(700,70));
											
											JLabel labelForPost = new JLabel("<html>" + p.getText() + "</html>");
											labelForPost.setForeground(Color.BLUE);
											
											JLabel sharedUser = new JLabel(friend.getName() + " has shared");
											
											JLabel labelForTagged = new JLabel(UserCollection.getTaggedUsers2(p, friend.getUserName()));
											
											JLabel labelForWord = new JLabel(p.getClass().getSimpleName().substring(0, 1));
											
											
											labelForWord.setFont(new Font("Tahoma", Font.BOLD, 40));
											minnakPanel.add(sharedUser, BorderLayout.NORTH);
											minnakPanel.add(labelForWord, BorderLayout.LINE_START);
											minnakPanel.add(labelForTagged, BorderLayout.SOUTH);
											minnakPanel.add(labelForPost, BorderLayout.CENTER);
											minnakPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
											minnakPanel.validate();
											minnakPanel.repaint();
											panelPostsFriends.add(minnakPanel);
										}
									}
								}
							}
							
						}
						
					}
					
				}
			}
		});
		btnNewButton_2.setBounds(19, 674, 190, 23);
		contentPane.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 486, 209, 222);
		contentPane.add(panel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(229, 223, 601, 604);
		contentPane.add(tabbedPane);
		
		panelPostsUser.setSize(600, 600);
		panelPostsFriends.setSize(600, 600);
		for(User user : UserCollection.getUsersArray()){
			if(user.isSignedIn()){
				for(User friend : user.getFriendList()){
					for(Post p : friend.getTextPostList()){
						JPanel minnakPanel = new JPanel();
						//minnakPanel.setSize(483, 45);
						minnakPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						minnakPanel.setLayout(new BorderLayout(0,0));
						minnakPanel.setMaximumSize(new Dimension(700,70));
						
						JLabel labelForPost = new JLabel("<html>" + p.getText() + "</html>");
						labelForPost.setForeground(Color.BLUE);
						
						JLabel sharedUser = new JLabel(friend.getName() + " has shared");
						
						JLabel labelForTagged = new JLabel(UserCollection.getTaggedUsers2(p, friend.getUserName()));
						
						JLabel labelForWord = new JLabel(p.getClass().getSimpleName().substring(0, 1));
						
						
						labelForWord.setFont(new Font("Tahoma", Font.BOLD, 40));
						minnakPanel.add(sharedUser, BorderLayout.NORTH);
						minnakPanel.add(labelForWord, BorderLayout.LINE_START);
						minnakPanel.add(labelForTagged, BorderLayout.SOUTH);
						minnakPanel.add(labelForPost, BorderLayout.CENTER);
						minnakPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
						minnakPanel.validate();
						minnakPanel.repaint();
						panelPostsFriends.add(minnakPanel);
					}
				}
			}
		}
		
		//scrollPane.setLayout(new BoxLayout(scrollPane, BoxLayout.Y_AXIS));
		for(User user : UserCollection.getUsersArray()){
			if(user.isSignedIn()){
				for(Post post : user.getTextPostList()){
					
					JPanel minnakPanel = new JPanel();
					//minnakPanel.setSize(483, 45);
					minnakPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
					minnakPanel.setLayout(new BorderLayout(0,0));
					minnakPanel.setMaximumSize(new Dimension(600,70));
					
					JLabel labelForPost = new JLabel("<html>" + post.getText() + "</html>");
					labelForPost.setForeground(Color.BLUE);
					/*
				 	JButton btnNewButton_3 = new JButton("Tag Users");
					btnNewButton_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							new tagFriend(getPage()).setVisible(true);;
						}
					});
					btnNewButton_3.setBounds(729, 189, 89, 23);
					contentPane.add(btnNewButton_3);
					*/
					
					
					JLabel labelForTagged = new JLabel(UserCollection.getTaggedUsers2(post, user.getUserName()));
					
					JButton btnTagFriend = new JButton("Tag Friends");
					btnTagFriend.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							new tagFriend(getPage(), post).setVisible(true);
							//getPage().setVisible(false);
						}
					});
					minnakPanel.add(btnTagFriend);
					
					JLabel labelForWord = new JLabel(post.getClass().getSimpleName().substring(0, 1));
					
					minnakPanel.add(btnTagFriend, BorderLayout.EAST);
					labelForWord.setFont(new Font("Tahoma", Font.BOLD, 40));
					minnakPanel.add(labelForWord, BorderLayout.LINE_START);
					minnakPanel.add(labelForTagged, BorderLayout.SOUTH);
					minnakPanel.add(labelForPost, BorderLayout.NORTH);
					minnakPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					minnakPanel.validate();
					minnakPanel.repaint();
					panelPostsUser.add(minnakPanel);
				}
			}
		}
		
		panelPostsUser.setLayout(new BoxLayout(panelPostsUser, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Posts", null, scrollPane, null);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane(panelPostsFriends);
		panelPostsFriends.setLayout(new BoxLayout(panelPostsFriends, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Friends' Posts", null, scrollPane_1, null);
		
		JLabel lblSearchFriends = new JLabel("Search Friends");
		lblSearchFriends.setForeground(Color.WHITE);
		lblSearchFriends.setBounds(91, 9, 89, 14);
		contentPane.add(lblSearchFriends);
		
		textFieldDateOfBirth1 = new JTextField();
		for(User user : UserCollection.getUsersArray()){
			if(user.isSignedIn()){
				Format format3 = new SimpleDateFormat("dd/MM/yyyy");
				String birthDay2 = format3.format(user.getDateofBirth());
				textFieldDateOfBirth1.setText(birthDay2);
			}
		}
		textFieldDateOfBirth1.setBorder(null);
		textFieldDateOfBirth1.setEditable(false);
		textFieldDateOfBirth1.setBounds(29, 260, 151, 20);
		contentPane.add(textFieldDateOfBirth1);
		textFieldDateOfBirth1.setColumns(10);
		
		textFieldSchool1 = new JTextField();
		for(User user : UserCollection.getUsersArray()){
			if(user.isSignedIn()){
				textFieldSchool1.setText(user.getSchoolGraduated());
			}
		}
		textFieldSchool1.setBorder(null);
		textFieldSchool1.setEditable(false);
		textFieldSchool1.setBounds(29, 305, 151, 20);
		contentPane.add(textFieldSchool1);
		textFieldSchool1.setColumns(10);
		comboBoxRelationShip.addItem("Single");
		comboBoxRelationShip.addItem("In Relationship");
		comboBoxRelationShip.addItem("Divorced");
		comboBoxRelationShip.addItem("Complicated");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener()   {
			public void actionPerformed(ActionEvent e) {
				
				
				for(User user : UserCollection.getUsersArray()){
					
					if(user.isSignedIn()){
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date date = null;
						try {
							date = format.parse(textFieldDateOfBirth1.getText());
							
							user.setDateofBirth(date);
							
							user.getDateofBirth();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							
							JOptionPane.showMessageDialog(contentPane,
								    "Invalid date",
								    "Warning",
								    JOptionPane.WARNING_MESSAGE);
							
						}
						finally{
							user.setSchoolGraduated(textFieldSchool1.getText());
							user.setRelationshipStatus((String) comboBoxRelationShip.getSelectedItem());
							Format format2 = new SimpleDateFormat("dd/MM/yyyy");
							String birthDay = format2.format(user.getDateofBirth());
							relationshiplabel.setText(user.getRelationshipStatus());
							comboBoxRelationShip.getSelectedItem();
							textFieldDateOfBirth1.setText(birthDay);
							textFieldSchool1.setText(user.getSchoolGraduated());
							textFieldDateOfBirth1.setEditable(false);
							textFieldSchool1.setEditable(false);
							txtXd.setEditable(false);
							comboBoxRelationShip.setVisible(false);
							btnSave.setVisible(false);
							relationshiplabel.setVisible(true);
							
							
						}
					}
				}
				
				
				
				for(User user : UserCollection.getUsersArray()){
					
					if(user.isSignedIn()){
						user.setSchoolGraduated(textFieldSchool1.getText());
						//System.out.println(user.getSchoolGraduated() + " " + user.getDateofBirth() + " " + user.getRelationshipStatus());
					}
				}
				
				
				
			}
		});
		btnSave.setBounds(29, 380, 89, 23);
		btnSave.setVisible(false);
		contentPane.add(btnSave);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relationshiplabel.setVisible(false);
				comboBoxRelationShip.setVisible(true);
				textFieldDateOfBirth1.setEditable(true);
				textFieldSchool1.setEditable(true);
				txtXd.setEditable(true);
				btnSave.setVisible(true);
				
			}
		});
		btnUpdate.setBounds(29, 380, 89, 23);
		contentPane.add(btnUpdate);
		
		txtXd = new JTextField();
		for(User user : UserCollection.getUsersArray()){
			if(user.isSignedIn()){
				txtXd.setText(user.getName());
			}
		}
		txtXd.setBorder(null);
		txtXd.setEditable(false);
		txtXd.setFont(new Font("Sitka Subheading", Font.BOLD, 40));
		txtXd.setBounds(142, 173, 462, 39);
		contentPane.add(txtXd);
		txtXd.setColumns(10);
		
		
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(729, 5, 101, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
		
		for(User user : UserCollection.getUsersArray()){
			if(user.isSignedIn()){
				for(User friend : user.getFriendList()){
					listModel2.addElement((friend.getName()));
				}
			}
		}
		
		
		
		
		JScrollPane scrollPaneSearch = new JScrollPane(searchList);
		scrollPaneSearch.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneSearch.setBounds(185, 27, 200, 140);
		scrollPaneSearch.setVisible(false);
		contentPane.add(scrollPaneSearch);
		
		textFieldSearch = new JTextField();
		
		textFieldSearch.addKeyListener(new KeyAdapter() {
			
			String text = "";
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				//System.out.println(textFieldSearch.getText());
				//text = text + arg0.getKeyChar();
				text = text + arg0.getKeyChar();
				if(textFieldSearch.getText().isEmpty()){
					text = "";
				}
				scrollPaneSearch.setVisible(true);
				searchList.setVisible(true);
				
				int indx = searchList.getNextMatch(text, 0, Position.Bias.Forward);
				searchList.setSelectedIndex(indx);
				
						
				
			}
		});
		textFieldSearch.setBounds(185, 6, 200, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		
		
		
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(User user : UserCollection.getUsersArray()){
					if(user.isSignedIn()){
						user.signOut();
						//user.setSignedIn(false);
						//System.out.println(user.isSignedIn());
					}
				}
				dispose();
			}
			
		});
		
		
		
		
		searchList.setBounds(528, 51, 108, 91);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 840, 34);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		
		
		
		
		searchList.setVisible(false);
		//contentPane.add(searchList);
		searchList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				scrollPaneSearch.setVisible(false);
				textFieldSearch.setText("");
				contentPane.setVisible(false);
				setTitle("Profile Page");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 856, 877);
				contentPaneFriend = new JPanel();
				contentPaneFriend.setBorder(new EmptyBorder(0, 0, 0, 0));
				setContentPane(contentPaneFriend);
				
				contentPaneFriend.setLayout(null);
				getPage().setLocationRelativeTo(null);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(5, 33, 150, 152);
				//lblNewLabel.setIcon(new ImageIcon(ProfilePage.class.getResource("/newPackage/personicon8.png")));
				lblNewLabel.setIcon(new ImageIcon(ProfilePage.class.getResource("/img/personicon8.png")));
				contentPaneFriend.add(lblNewLabel);
				
				JLabel lblDateOfBirth = new JLabel("Date of Birth");
				lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblDateOfBirth.setBounds(29, 247, 126, 14);
				contentPaneFriend.add(lblDateOfBirth);
				
				JLabel lblSchool = new JLabel("School Graduated");
				lblSchool.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblSchool.setBounds(29, 291, 126, 14);
				contentPaneFriend.add(lblSchool);
				
				JLabel lblRelationshipStatus = new JLabel("Relationship Status");
				lblRelationshipStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblRelationshipStatus.setBounds(29, 335, 126, 14);
				contentPaneFriend.add(lblRelationshipStatus);
				
				JLabel relationshiplabel = new JLabel("");
				relationshiplabel.setBounds(29, 348, 126, 23);
				contentPaneFriend.add(relationshiplabel);
				for(User user : UserCollection.getUsersArray()){
					if(searchList.getSelectedValue().equals(user.getName())){
						relationshiplabel.setText(user.getRelationshipStatus());
					}
				}
				
				JList list = new JList(listModelRadio);
				list.setBounds(19, 496, 190, 167);
				contentPaneFriend.add(list);
				
				JLabel lblNewLabel_3 = new JLabel("Friends");
				lblNewLabel_3.setBounds(20, 457, 46, 14);
				contentPaneFriend.add(lblNewLabel_3);
				
				
				
				JRadioButton btonNormal = new JRadioButton("Normal");
				listModelRadio.clear();
				for(User user : UserCollection.getUsersArray()){
					if(searchList.getSelectedValue().equals(user.getName())){
						for(User friend : user.getFriendList()){
							listModelRadio.addElement(friend.getUserName());
						}
					}
				}
				btonNormal.setSelected(true);
				
				btonNormal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						listModelRadio.clear();
						for(User user : UserCollection.getUsersArray()){
							if(searchList.getSelectedValue().equals(user.getName())){
								for(User friend : user.getFriendList()){
									listModelRadio.addElement(friend.getUserName());
								}
							}
						}
					}
				});
				btonNormal.setBounds(70, 453, 73, 23);
				contentPaneFriend.add(btonNormal);
				
				JRadioButton btnBlocked = new JRadioButton("Blocked");
				btnBlocked.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						listModelRadio.clear();
						for(User user : UserCollection.getUsersArray()){
							if(searchList.getSelectedValue().equals(user.getName())){
								for(User blocked : user.getBlockedUserList()){
									listModelRadio.addElement(blocked.getUserName());
								}
							}
						}
					}
				});
				btnBlocked.setBounds(142, 453, 81, 23);
				contentPaneFriend.add(btnBlocked);
				
				ButtonGroup group = new ButtonGroup();
				group.add(btonNormal);
				group.add(btnBlocked);
				
				
				
				
				JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane2.setBounds(229, 223, 601, 604);
				contentPaneFriend.add(tabbedPane2);
				panelPostsUser2.removeAll();
				panelPostsFriends2.removeAll();
				panelPostsUser2.setSize(600, 600);
				panelPostsFriends2.setSize(600, 600);
				for(User user : UserCollection.getUsersArray()){
					if(searchList.getSelectedValue().equals(user.getName())){
						for(User friend : user.getFriendList()){
							for(Post p : friend.getTextPostList()){
								JPanel minnakPanel = new JPanel();
								//minnakPanel.setSize(483, 45);
								minnakPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
								minnakPanel.setLayout(new BorderLayout(0,0));
								minnakPanel.setMaximumSize(new Dimension(700,70));
								
								JLabel labelForPost = new JLabel("<html>" + p.getText() + "</html>");
								labelForPost.setForeground(Color.BLUE);
								
								JLabel sharedUser = new JLabel(friend.getName() + " has shared");
								
								JLabel labelForTagged = new JLabel(UserCollection.getTaggedUsers2(p, friend.getUserName()));
								
								JLabel labelForWord = new JLabel(p.getClass().getSimpleName().substring(0, 1));
								
								
								labelForWord.setFont(new Font("Tahoma", Font.BOLD, 40));
								minnakPanel.add(sharedUser, BorderLayout.NORTH);
								minnakPanel.add(labelForWord, BorderLayout.LINE_START);
								minnakPanel.add(labelForTagged, BorderLayout.SOUTH);
								minnakPanel.add(labelForPost, BorderLayout.CENTER);
								minnakPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
								minnakPanel.validate();
								minnakPanel.repaint();
								panelPostsFriends2.add(minnakPanel);
							}
						}
					}
				}
				//scrollPane.setLayout(new BoxLayout(scrollPane, BoxLayout.Y_AXIS));
				for(User user : UserCollection.getUsersArray()){
					if(searchList.getSelectedValue().equals(user.getName())){
						for(Post post : user.getTextPostList()){
							
							JPanel minnakPanel = new JPanel();
							//minnakPanel.setSize(483, 45);
							minnakPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							minnakPanel.setLayout(new BorderLayout(0,0));
							minnakPanel.setMaximumSize(new Dimension(600,70));
							
							JLabel labelForPost = new JLabel("<html>" + post.getText() + "</html>");
							labelForPost.setForeground(Color.BLUE);
							
							
							JLabel labelForTagged = new JLabel(UserCollection.getTaggedUsers2(post, user.getUserName()));
							JButton btnTagFriend = new JButton("Tag Friends");
							
							JLabel labelForWord = new JLabel(post.getClass().getSimpleName().substring(0, 1));
							
							minnakPanel.add(btnTagFriend, BorderLayout.EAST);
							labelForWord.setFont(new Font("Tahoma", Font.BOLD, 40));
							minnakPanel.add(labelForWord, BorderLayout.LINE_START);
							minnakPanel.add(labelForTagged, BorderLayout.SOUTH);
							minnakPanel.add(labelForPost, BorderLayout.NORTH);
							minnakPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
							minnakPanel.validate();
							minnakPanel.repaint();
							panelPostsUser2.add(minnakPanel);
						}
					}
				}
				JScrollPane scrollPane = new JScrollPane(panelPostsUser2);
				panelPostsUser2.setLayout(new BoxLayout(panelPostsUser2, BoxLayout.Y_AXIS));
				tabbedPane2.addTab("Posts", null, scrollPane, null);
				
				
				
				JScrollPane scrollPane_1 = new JScrollPane(panelPostsFriends2);
				panelPostsFriends2.setLayout(new BoxLayout(panelPostsFriends2, BoxLayout.Y_AXIS));
				tabbedPane2.addTab("Friends' Posts", null, scrollPane_1, null);
				
				
				
				
				textFieldDateOfBirth1 = new JTextField();
				for(User user : UserCollection.getUsersArray()){
					if(searchList.getSelectedValue().equals(user.getName())){
						Format format3 = new SimpleDateFormat("dd/MM/yyyy");
						String birthDay2 = format3.format(user.getDateofBirth());
						textFieldDateOfBirth1.setText(birthDay2);
					}
				}
				textFieldDateOfBirth1.setBorder(null);
				textFieldDateOfBirth1.setEditable(false);
				textFieldDateOfBirth1.setBounds(29, 260, 151, 20);
				contentPaneFriend.add(textFieldDateOfBirth1);
				textFieldDateOfBirth1.setColumns(10);
				
				textFieldSchool1 = new JTextField();
				for(User user : UserCollection.getUsersArray()){
					if(searchList.getSelectedValue().equals(user.getName())){
						textFieldSchool1.setText(user.getSchoolGraduated());
					}
				}
				textFieldSchool1.setBorder(null);
				textFieldSchool1.setEditable(false);
				textFieldSchool1.setBounds(29, 305, 151, 20);
				contentPaneFriend.add(textFieldSchool1);
				textFieldSchool1.setColumns(10);
				
				
				
				txtXd = new JTextField();
				for(User user : UserCollection.getUsersArray()){
					if(searchList.getSelectedValue().equals(user.getName())){
						txtXd.setText(user.getName());
					}
				}
				txtXd.setBorder(null);
				txtXd.setEditable(false);
				txtXd.setFont(new Font("Sitka Subheading", Font.BOLD, 40));
				txtXd.setBounds(142, 173, 462, 39);
				contentPaneFriend.add(txtXd);
				txtXd.setColumns(10);
				
				JButton btnBlockThisPerson = new JButton("Block This Person");
				btnBlockThisPerson.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						/*for(User user : UserCollection.getUsersArray()){
							if(user.isSignedIn()){
								if(user.getBlockedFriendList().contains(searchList.getSelectedValue()));
									
								}else{
									user.block(friend(searchList.getSelectedValue()).getUserName());
								}
						}*/
						
						
					}

				});
				
				btnBlockThisPerson.setBounds(642, 211, 158, 23);
				contentPaneFriend.add(btnBlockThisPerson);
				
				
				
				JButton btnNewButton_1 = new JButton("Logout");
				btnNewButton_1.setBounds(729, 5, 101, 23);
				contentPaneFriend.add(btnNewButton_1);
				
				
				JButton btnHome = new JButton("Home");
				btnHome.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPane.setVisible(true);
						contentPaneFriend.setVisible(false);
						setContentPane(contentPane);
					}
				});
				btnHome.setBounds(5, 5, 70, 23);
				contentPaneFriend.add(btnHome);
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.textHighlight);
				panel.setBounds(0, 0, 840, 34);
				contentPaneFriend.add(panel);
				panel.setLayout(null);
				
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for(User user : UserCollection.getUsersArray()){
							if(user.isSignedIn()){
								user.signOut();
								//user.setSignedIn(false);
								//System.out.println(user.isSignedIn());
							}
						}
						dispose();
					}
					
				});
				
				
			}
		});
		
		
		
		
		
		
	}
}
