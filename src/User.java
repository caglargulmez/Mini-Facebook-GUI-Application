import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Caglar
 *
 */
public class User {
	
	/**
	 * arraylist of friend
	 */
	private ArrayList<User> friendList;
	/**
	 * arraylist of blocked friend
	 */
	private ArrayList<User> blockedFriendList;
	/**
	 * arraylist of blocked users
	 */
	private ArrayList<User> blockedUserList;
	
	/**
	 * arraylist of general posts 
	 */
	private ArrayList<Post> textPostList;
	/**
	 * arraylist of image posts
	 */
	private ArrayList<ImagePost> imagePostList;
	/**
	 * arraylist of video posts
	 */
	private ArrayList<VideoPost> videoPostList;
	/**
	 * arraylist of only text post
	 */
	private ArrayList<TextPost> onlyTextPostList;
	
	/**
	 * user id
	 */
	private Integer userID;
	/**
	 * user name
	 */
	private String name;
	/**
	 * user username
	 */
	private String username;
	/**
	 * user password
	 */
	private String password;
	/**
	 * user date of birth
	 */
	private Date dateofBirth;
	/**
	 * user school graduated
	 */
	private String schoolGraduated;
	/**
	 * user sign out date
	 */
	private Date lastLogin;
	/**
	 * checks if signed in
	 */
	private boolean signedIn = false;
	private String relationshipStatus;
	//private static HashMap<User, ArrayList<User>> dictFriends = new HashMap<User, ArrayList<User>>();
	

	/**
	 * @param name user's name that will be created
	 * @param username user's username that will be created
	 * @param password user's password that will be created
	 * @param date user's date of birth that will be created
	 * @param schoolName user's schoolName that will be created
	 */
	public User(String name, String username, String password, Date date, String schoolName, String relationshipStatus	) {
		ArrayList<User> friendList = new ArrayList<User>();
		ArrayList<User> blockedFriendList = new ArrayList<User>();
		ArrayList<User> blockedUserList = new ArrayList<User>();
		
		ArrayList<Post> textPostList = new ArrayList<Post>();
		ArrayList<ImagePost> imagePostList = new ArrayList<ImagePost>();
		ArrayList<VideoPost> videoPostList = new ArrayList<VideoPost>();
		ArrayList<TextPost> onlyTextPostList = new ArrayList<TextPost>();
		
		this.setOnlyTextPostList(onlyTextPostList);
		this.setTextPostList(textPostList);
		this.setImagePostList(imagePostList);
		this.setVideoPostList(videoPostList);
		this.setRelationshipStatus(relationshipStatus);
		this.setBlockedFriendList(blockedFriendList);
		this.setBlockedUserList(blockedUserList);
		this.setFriendList(friendList);
		
		this.setPassword(password);
		this.setName(name);
		this.setUserName(username);
		this.setDateofBirth(date);
		this.setSchoolGraduated(schoolName);
		
	}
	
	/**
	 * @param name new name of current user
	 * @param dateOfBirth new date Of Birth of current user
	 * @param schoolGraduated new school Graduated of current user
	 * @throws ParseException throws exception if it can't parse the date
	 */
	public void updateProfile(String name, String dateOfBirth, String schoolGraduated) throws ParseException{
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(dateOfBirth);
		
		//System.out.println("old     " + this.getDateofBirth());
		this.setDateofBirth(date);
		//System.out.println("new     " + this.getDateofBirth());
		
		//System.out.println("old     " + this.getName());
		this.setName(name);
		//System.out.println("new     " + this.getName());
		
		//System.out.println("old     " + this.getSchoolGraduated());
		this.setSchoolGraduated(schoolGraduated);
		//System.out.println("new     " + this.getSchoolGraduated());
		
		//System.out.println();
		//System.out.println();
		System.out.println("Your user profile has been successfully updated.");
	}
	
	/**
	 * displays all friends of current user
	 */
	public void listFriends(){
		/*System.out.println(this.getDateofBirth());
		Format format = new SimpleDateFormat("dd-MM-yyyy");
		String s = format.format(this.getDateofBirth());
		System.out.println(s);*/
		if(this.getFriendList().isEmpty()){
			System.out.println("You haven't added any friends yet!");
		}
		else{
			for(User friend : this.getFriendList()){
				
				Format format = new SimpleDateFormat("dd/MM/yyyy");
				String birthDay = format.format(friend.getDateofBirth());
				System.out.println("Name: " + friend.getName() + "\n" +
								   "Username: " + friend.getUserName() + "\n" +
								   "Date of Birth: " + birthDay + "\n" +
								   "School: " + friend.getSchoolGraduated() + "\n" +
								   "---------------------------");
			}
		}
	}

	/**
	 * displays all users
	 */
	public void listUsers(){
		for(User user : UserCollection.getUsersArray()){
			
			Format format = new SimpleDateFormat("dd/MM/yyyy");
			String birthDay = format.format(user.getDateofBirth());
			System.out.println("Name: " + user.getName() + "\n" +
							   "Username: " + user.getUserName() + "\n" +
							   "Date of Birth: " + birthDay + "\n" +
							   "School: " + user.getSchoolGraduated() + "\n" +
							   "---------------------------");
		}
	}
	
	/**
	 * displays blocked friends
	 */
	public void showBlockedFriend(){
		if((this.getBlockedFriendList().isEmpty()) && (this.getBlockedUserList().isEmpty())){
			System.out.println("You haven't blocked any users yet!");
		}
		else if(this.getBlockedFriendList().isEmpty()){
			System.out.println("You haven't blocked any friends yet!");
		}
		else if(this.getBlockedFriendList().size() > 0){
			for(User friendBlocked : this.getBlockedFriendList()){
				Format format = new SimpleDateFormat("dd/MM/yyyy");
				String birthDay = format.format(friendBlocked.getDateofBirth());
				System.out.println("Name: " + friendBlocked.getName() + "\n" +
						   "Username: " + friendBlocked.getUserName() + "\n" +
						   "Date of Birth: " + birthDay + "\n" +
						   "School: " + friendBlocked.getSchoolGraduated() + "\n" +
						   "---------------------------");
			}
			
		}
	}
	
	/**
	 * displays blocked users
	 */
	public void showBlockedUsers(){
		if(this.getBlockedUserList().isEmpty()){
			System.out.println("You haven't blocked any users yet!");
		}
		else{
				
			for(User friendBlocked2 : this.getBlockedFriendList()){
				Format format = new SimpleDateFormat("dd/MM/yyyy");
				String birthDay = format.format(friendBlocked2.getDateofBirth());
				System.out.println("Name: " + friendBlocked2.getName() + "\n" +
						   "Username: " + friendBlocked2.getUserName() + "\n" +
						   "Date of Birth: " + birthDay + "\n" +
						   "School: " + friendBlocked2.getSchoolGraduated() + "\n" +
						   "---------------------------");
			}
		}
	}
	
	/**
	 * @param friend friend name that will be add
	 */
	public void addFriend(String friend){
		if(UserCollection.getDictName().containsKey(friend)){   
				
			if(this.getFriendList().contains(UserCollection.getDictName().get(friend))){System.out.println();
			}
			else{
				this.getFriendList().add(UserCollection.getDictName().get(friend));
				//System.out.println(friend + " has been successfully added to your friend list.");
			}
		}
		else{
			System.out.println();
		}
	}
	
	public void blockFriend(String name){
		if(UserCollection.getDictName().containsKey(name)){
			
			System.out.println(name + " has been successfully blocked.");
			this.getBlockedUserList().add(UserCollection.getDictName().get(name));
		}
		else{
			System.out.println("No such user!");
			
		}
	}
	
	/**
	 * @param name username that will be block
	 */
	public void block(String name){
		
		/*for(Map.Entry m : UserCollection.getDictName().entrySet()){
			System.out.println(m.getKey() + " " + m.getValue());
			
		}*/
		if(UserCollection.getDictName().containsKey(name)){
			
			//System.out.println(name + " has been successfully blocked.");
			this.getBlockedUserList().add(UserCollection.getDictName().get(name));
		}
		else{
			//System.out.println("No such user!");
			System.out.println();
			
		}
		for(User user : this.getBlockedUserList()){
			if(UserCollection.getDictName().containsKey(name)){
			if(user.getUserName().equals(UserCollection.getDictName().get(name).getUserName())){
				this.getBlockedFriendList().add(UserCollection.getDictName().get(name));
			}
			}
			else{
				continue;
			}
		}
		for(User user : UserCollection.getUsersArray()){
			
				Iterator<User> iter = this.getFriendList().iterator();
				while(iter.hasNext()){
					if(iter.next().getUserName().equals(name)){
						iter.remove();
						
					}
				}
			}
		}
	
	
	/**
	 * @param name username that will be unblock
	 */
	public void unBlock(String name){
		/*if(this.getBlockedFriendList().contains(UserCollection.getDictName().get(name))) {
			System.out.println(name + " has been successfully unblocked.");
			this.getBlockedFriendList().remove(UserCollection.getDictName().get(name));
		}*/
		if(this.getBlockedUserList().contains(UserCollection.getDictName().get(name))){
			System.out.println(name + " has been successfully unblocked.");
			this.getBlockedUserList().remove(UserCollection.getDictName().get(name));
			this.getBlockedFriendList().remove(UserCollection.getDictName().get(name));
		}
		else{
			System.out.println("No such user in your blocked users list!");
			System.out.println();
		}
	}
	
	/**
	 * @param name takes name returns object
	 * @return object if exist, null if doesn't exist
	 */
	public User friendUser(String name){
		for(User user : this.getFriendList()){
			if(user.getUserName().equals(name)){
				return user;
			}
		}
		return null;
	}
	
	/**
	 * @param name remove friend
	 */
	/*
	public void removeFriend(String name){
		if(this.getFriendList().contains(friendUser(name))){
			this.getFriendList().remove(friendUser(name));
			System.out.println(name + " has been successfully removed from your friend list.");
		}
		else{
			System.out.println("No such friend!");
		}
	}
	*/
	
																			/*
	public void changePassword(String oldOne, String newOne){
		
		if(this.getPassword().equals(oldOne)){
			this.setPassword(newOne);
		}
		else{
			System.out.println("Password mismatch! Please, try again.");
		}
	}																		*/
	
	/**
	 * sign out 
	 */
	public void signOut(){
		this.setSignedIn(false);
		Date currentDate = new Date();
		this.setLastLogin(currentDate);
		//System.out.println("You have successfully signed out.");
	}
		
	
	/**
	 * @param contents text contents
	 * @param longitude post location's longitude
	 * @param latitude post location's latitude
	 * @param tagged string array of tagged users
	 */
	public void addTextPost(String contents, Double longitude, Double latitude, String[] tagged){
		ArrayList<String> taggedUsers = new ArrayList<String>();
		Date currentDate = new Date();
		UUID postID = UUID.randomUUID(); 
		ArrayList<String> usersTagged = new ArrayList<String>();
		
		for(User friend : this.getFriendList()){
			usersTagged.add(friend.getUserName());
			}
		if(tagged == null){
			
		}
		else{
			for(String ifFriend : tagged){
				taggedUsers.add(UserCollection.getDictName().get(ifFriend).getUserName());
				/*if(usersTagged.contains(ifFriend)){
					taggedUsers.add(UserCollection.getDictName().get(ifFriend).getName());
				}
				else{
					System.out.println(ifFriend + " is not your friend, and will not be tagged!");
				}*/
		}
		
		}
		
		
		
		Location location = new Location(latitude, longitude);
		TextPost text = new TextPost(contents, currentDate, taggedUsers, location, postID);
		this.getTextPostList().add(text);
		this.getOnlyTextPostList().add(text);
		//System.out.println("The post has been successfully added.");
		
		/*for(Post post : this.getTextPostList()){
			for(String taggedd : post.getTaggedUsers()){
				System.out.println(taggedd);
				
			}
			System.out.println("-----------");
			for(User friend: this.getFriendList()){
				System.out.println("friend name:  " + friend.getUserName());
			}
		}*/
		/*for(Post post:this.getTextPostList()){
			System.out.println( post.getLocation() + "\n" + post.getText() + "\n" + post.getClass() + "\n" + post.getOriginatedDate() + "\n" + 
								post.getPostID() + "\n" +  post.getTaggedUsers());
			System.out.println("------------------------------------------------------------");
		}
		System.out.println("------------------------------------------------------------");
		*/
		
	}
	/**
	 * @param contents text contents
	 * @param longitude post location's longitude
	 * @param latitude post location's latitude
	 * @param tagged string array of tagged users
	 * @param imageFilename image's file name
	 * @param imageResolution iamge's resolution
	 */
	public void addImagePost(String contents, Double longitude, Double latitude, String[] tagged, String imageFilename, String imageResolution){
		Date currentDate = new Date();
		UUID postID = UUID.randomUUID(); 
		ArrayList<String> taggedUsers = new ArrayList<String>();
		ArrayList<String> usersTagged = new ArrayList<String>();
		for(User friend : this.getFriendList()){
			usersTagged.add(friend.getUserName());
			}
		if(tagged == null){
			
		}
		else{
			for(String ifFriend : tagged){
				taggedUsers.add(UserCollection.getDictName().get(ifFriend).getUserName());
				/*if(usersTagged.contains(ifFriend)){
					taggedUsers.add(ifFriend);
				}
				else{
					System.out.println(ifFriend + " is not your friend, and will not be tagged!");
				}*/
		}
		
		}
		
		Location location = new Location(latitude, longitude);
		ImagePost text = new ImagePost(contents, currentDate, taggedUsers, imageFilename, imageResolution, postID, location);
		
		this.getTextPostList().add(text);
		this.getImagePostList().add(text);
		//System.out.println("The post has been successfully added.");
	}
	/**
	 * @param contents text contents
	 * @param longitude post location's longitude
	 * @param latitude post location's latitude
	 * @param tagged string array of tagged users
	 * @param videoFilename video's file name
	 * @param videoDuration video's total time
	 */
	public void addVideoPost(String contents, Double longitude, Double latitude, String[] tagged, String videoFilename, String videoDuration){
		Date currentDate = new Date();
		UUID postID = UUID.randomUUID(); 
		ArrayList<String> taggedUsers = new ArrayList<String>();
		ArrayList<String> usersTagged = new ArrayList<String>();
		for(User friend : this.getFriendList()){
			usersTagged.add(friend.getUserName());
			}
		if(tagged == null){
			
		}
		else{
			for(String ifFriend : tagged){
				taggedUsers.add(UserCollection.getDictName().get(ifFriend).getUserName());
				/*if(usersTagged.contains(ifFriend)){
					taggedUsers.add(ifFriend);
				}
				else{
					System.out.println(ifFriend + " is not your friend, and will not be tagged!");
				}*/
		}
		
		}
		
		Location location = new Location(latitude, longitude);
		VideoPost text = new VideoPost(contents, currentDate, taggedUsers, videoFilename, videoDuration, postID, location);
		this.getTextPostList().add(text);
		this.getVideoPostList().add(text);
		
		//System.out.println("The post has been successfully added.");
		
	}
	/**
	 * removes last post if there is any
	 */
	/*public void removeLastPost(){
		// i should delete last post from 
		// -textPostList
		// -imagePostList
		// -videoPostList
		// but first i should delete it from general list which called textpostlist
		
		
		if(this.getTextPostList().size()>0){
			
			if(this.getOnlyTextPostList().contains(this.getTextPostList().get(this.getTextPostList().size()-1))){
				this.getOnlyTextPostList().remove(this.getOnlyTextPostList().size()-1);
			}
			else if(this.getVideoPostList().contains(this.getTextPostList().get(this.getTextPostList().size()-1))){
				this.getVideoPostList().remove(this.getVideoPostList().size()-1);
			}
			else if(this.getImagePostList().contains(this.getTextPostList().get(this.getTextPostList().size()-1))){
				this.getImagePostList().remove(this.getImagePostList().size()-1);			}
			System.out.println("Your last post has been successfully removed.");
			this.getTextPostList().remove(this.getTextPostList().size()-1);
		}
		else{
			System.out.println("Error: You don't have any posts.");
		}
		
	}*/
	
	
	
	
	/**
	 * @return user id 
	 */
	public Integer getUserID() {return userID;}
	public void setUserID(Integer userID) {this.userID = userID;}
	
	/**
	 * @return gets general post list
	 */
	public ArrayList<Post> getTextPostList() {return textPostList;}
	public void setTextPostList(ArrayList<Post> textPostList) {this.textPostList = textPostList;}

	/**
	 * @return gets images post list
	 */
	public ArrayList<ImagePost> getImagePostList() {return imagePostList;}
	public void setImagePostList(ArrayList<ImagePost> imagePostList) {this.imagePostList = imagePostList;}

	/**
	 * @return gets videos post list
	 */
	public ArrayList<VideoPost> getVideoPostList() {return videoPostList;}
	public void setVideoPostList(ArrayList<VideoPost> videoPostList) {this.videoPostList = videoPostList;}

	/**
	 * @return gets blocked friend list
	 */
	public ArrayList<User> getBlockedFriendList() {return blockedFriendList;}
	public void setBlockedFriendList(ArrayList<User> blockedFriendList) {this.blockedFriendList = blockedFriendList;}

	/**
	 * @return gets blocked users list
	 */
	public ArrayList<User> getBlockedUserList() {return blockedUserList;}
	public void setBlockedUserList(ArrayList<User> blockedUserList) {this.blockedUserList = blockedUserList;}

	/**
	 * @return gets friend list
	 */
	public ArrayList<User> getFriendList() {return friendList;}
	public void setFriendList(ArrayList<User> friendList) {this.friendList = friendList;}
	
	/**
	 * @return gets user's password
	 */
	public String getPassword() {return password;}
	/**
	 * @param password password to set
	 */
	public void setPassword(String password) {this.password = password;}


	/**
	 * @return gets user's name
	 */
	public String getName() {return name;}
	/**
	 * @param name sets user's name
	 */
	public void setName(String name) {this.name = name;}


	/**
	 * @return gets user's username
	 */
	public String getUserName() {return username;}
	/**
	 * @param username sets user's username
	 */
	public void setUserName(String username) {this.username = username;}


	/**
	 * @return gets user's date of Birth
	 */
	public Date getDateofBirth() {return dateofBirth;}
	/**
	 * @param dateofBirth sets user's date of Birth
	 */
	public void setDateofBirth(Date dateofBirth) {this.dateofBirth = dateofBirth;}


	/**
	 * @return gets user's school Graduated
	 */
	public String getSchoolGraduated() {return schoolGraduated;}
	/**
	 * @param schoolGraduated sets user's school Graduated
	 */
	public void setSchoolGraduated(String schoolGraduated) {this.schoolGraduated = schoolGraduated;}


	/**
	 * @return gets lastLogin
	 */
	public Date getLastLogin() {return lastLogin;}
	/**
	 * @param lastLogin sets last login
	 */
	public void setLastLogin(Date lastLogin) {this.lastLogin = lastLogin;}


	/**
	 * @return gets user if signed in 
	 */
	public boolean isSignedIn() {return signedIn;}
	/**
	 * @param signedIn sets user if signed in or not
	 */
	public void setSignedIn(boolean signedIn) {this.signedIn = signedIn;}

	/**
	 * @return gets user's only Text Post List
	 */
	public ArrayList<TextPost> getOnlyTextPostList() {return onlyTextPostList;}
	/**
	 * @param onlyTextPostList sets user's only Text Post List
	 */
	public void setOnlyTextPostList(ArrayList<TextPost> onlyTextPostList) {this.onlyTextPostList = onlyTextPostList;}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}


}
