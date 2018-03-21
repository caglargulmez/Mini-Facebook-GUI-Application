
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tagFriend extends JFrame {

	private JPanel contentPane;

	
	public User friend(Object object){
		for(User user : UserCollection.getUsersArray()){
			if(user.getName().equals(object)){
				return user;
			}
		}
		return null;
	}
	/**
	 * Create the frame.
	 */
	public tagFriend(ProfilePage p, Post post) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 358, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		DefaultListModel<String> listModel = new DefaultListModel<>();
		JList list = new JList(listModel);
		for(User user : UserCollection.getUsersArray()){
			if(user.isSignedIn()){
				for(User friend : user.getFriendList()){
					if(post.getTaggedUsers().contains(friend.getUserName())) {
						
					}
					else{
					//System.out.println("girdi");
					listModel.addElement(friend.getName());
					//list.addElement(friend.getName());
					}
				}
			}
		}
		
		list.setBounds(24, 64, 270, 195);
		contentPane.add(list);
		
		
		JButton btnNewButton = new JButton("Tag Friend");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(User user : UserCollection.getUsersArray()){
					if(user.isSignedIn()){
						//System.out.println(post.getTaggedUsers());
						if(post.getTaggedUsers().contains(friend(list.getSelectedValue()).getUserName())){
							
						}else{
							post.getTaggedUsers().add(friend(list.getSelectedValue()).getUserName());
						}
						//System.out.println(post.getTaggedUsers());
						p.panelPostsUser.removeAll();
							for(Post post2 : user.getTextPostList()){	
									
									JPanel minnakPanel = new JPanel();
									//minnakPanel.setSize(483, 45);
									minnakPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									minnakPanel.setLayout(new BorderLayout(0,0));
									minnakPanel.setMaximumSize(new Dimension(600,70));
									
									JLabel labelForPost = new JLabel("<html>" + post2.getText() + "</html>");
									labelForPost.setForeground(Color.BLUE);
									
									
									JLabel labelForTagged = new JLabel(UserCollection.getTaggedUsers2(post2, user.getUserName()));
									JButton btnTagFriend = new JButton("Tag Friends");
									btnTagFriend.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											new tagFriend(p, post2).setVisible(true);
											//p.setVisible(false);
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
				p.setVisible(true);
				dispose();
				}
				
			
			
		});
		btnNewButton.setBounds(28, 283, 266, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblTaggableFriends = new JLabel("Taggable Friends");
		lblTaggableFriends.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaggableFriends.setBounds(21, 21, 119, 28);
		contentPane.add(lblTaggableFriends);
	}
}
