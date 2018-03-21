import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;



/**
 * @author Caglar
 *
 */
public class UserCollection {
	
	public static ArrayList<User> usersArray = new ArrayList<User>();
	
	private static HashMap<User, List> dictUsers = new HashMap<User, List>();  
	private static HashMap<String, User> dictName = new HashMap<String, User>();  
	private static HashMap<String, User> dictUserName = new HashMap<String, User>();  
	private static HashMap<Integer, User> dictID = new HashMap<Integer, User>();  
	
	private static ArrayList<String> userNamesArray = new ArrayList<String>();
	
	
	private static Integer IDCounter = 0;
	
	/**
	 * @param username username whose post shall currentuser show
	 */
	public static void showPosts(String username){
		for(User user : usersArray){
			userNamesArray.add(user.getUserName());
		}
		if(userNamesArray.contains(username)){
			if(dictName.get(username).getTextPostList().isEmpty()){
				System.out.println(username + " does not have any posts yet.");
			}
			else{
				System.out.println("**************\n" + username + "'s Posts\n" + "**************");
				for(Post post : dictName.get(username).getOnlyTextPostList()){
					
						Format format = new SimpleDateFormat("dd.MM.yyyy");
						String date = format.format(post.getOriginatedDate());
						if(post.getTaggedUsers().isEmpty()){
							System.out.print(post.getText() + "\n" +
									  		"Date: " + date + "\n" +
									  		"Location: " + post.getLocation() + "\n" );
							}
						else{
							System.out.print(post.getText() + "\n" +
									    	"Date: " + date + "\n" +
									    	"Location: " + post.getLocation() + "\n" + 
									    	"Friends tagged in this post: ");
					
						for(String taggedNames : post.getTaggedUsers()){
							System.out.print(dictName.get(taggedNames).getName());
							System.out.print(", ");
						}
						
						
					}
						
						System.out.println("----------------------");
				}//end first for
				
				for(ImagePost post2 : dictName.get(username).getImagePostList()){
					
					Format format = new SimpleDateFormat("dd.MM.yyyy");
					String date = format.format(post2.getOriginatedDate());
					if(post2.getTaggedUsers().isEmpty()){
						System.out.print(post2.getText() + "\n" +
								  		"Date: " + date + "\n" +
								  		"Location: " + post2.getLocation() + "\n" );
						}
					else{
						System.out.print(post2.getText() + "\n" +
								    	"Date: " + date + "\n" +
								    	"Location: " + post2.getLocation() + "\n" + 
								    	"Image: " + post2.getImageFilename() + "\n" +
								    	"Image resolution: " + post2.getImageResolution() + "\n" + 
								    	"Friends tagged in this post: ");
				
					for(String taggedNames : post2.getTaggedUsers()){
						System.out.print(dictName.get(taggedNames).getName());
						System.out.print(", ");
					}
					
					System.out.println();
					System.out.println("----------------------");
				}
				
			}//end second for
				for(VideoPost post : dictName.get(username).getVideoPostList()){
					
					Format format = new SimpleDateFormat("dd.MM.yyyy");
					String date = format.format(post.getOriginatedDate());
					if(post.getTaggedUsers().isEmpty()){
						System.out.print(post.getText() + "\n" +
								  		"Date: " + date + "\n" +
								  		"Location: " + post.getLocation() + "\n" );
						}
					else{
						System.out.print(post.getText() + "\n" +
								    	"Date: " + date + "\n" +
								    	"Location: " + post.getLocation() + "\n" + 
								    	"Video: " + post.getVideoFilename() + "\n" + 
								    	"Video duration: " + post.getVideoDuration() + " minutes\n" + 
								    	"Friends tagged in this post: ");
				
					for(String taggedNames : post.getTaggedUsers()){
						System.out.print(dictName.get(taggedNames).getName());
						System.out.print(", ");
					}
					
					System.out.println();
					System.out.println("----------------------");
				}
				
			}//end third for
			}
		}
		else{
			System.out.println("No such user!");
		}
	
	
	
	
	
	
	
	}

	public static String getTaggedUsers2(Post p, String username){
		ArrayList<String> array = new ArrayList<String>();
		//StringBuilder builder = new StringBuilder();
		String s = "Tagged Users: ";
		for(String taggedNames : p.getTaggedUsers()){
			if(UserCollection.getDictName().keySet().contains(taggedNames)){
				for(User friend : UserCollection.getDictName().get(username).getFriendList()){
					
					if(friend.getUserName().equals(taggedNames)){
						
						array.add(UserCollection.getDictName().get(taggedNames).getName());
						s +=  UserCollection.getDictName().get(taggedNames).getName() + ", ";
					}
				}
			}
		}
		return s;
	}
	
	/**
	 * @param username username
	 * @return user object whose name is name
	 */
	public static User objectUser(String username) {
		for(User user: UserCollection.getUsersArray()) {
			System.out.println(user.getUserName());
			
			if(user.getUserName().equals(username)) {return user;}
		}
		return null;
	}
	
	/**
	 * @param name name of user that will be created
	 * @param username username of user that will be created
	 * @param password password of user that will be created
	 * @param dateOfBirth date of birth of user that will be created
	 * @param graduatedSchool graduated school of user that will be created
	 * @throws ParseException throws exception if it can't parse
	 */
	public static void addUser(String name, String username, String password, String dateOfBirth, String graduatedSchool, String relationshipStatus) throws ParseException {
		IDCounter += 1;    
		List<String> infoArray = new ArrayList<String>();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(dateOfBirth);
		User user = new User(name, username, password, date, graduatedSchool, relationshipStatus);
		user.setUserID(IDCounter);
		usersArray.add(user);
		/*idArray.add(user.getUserID());
		nameArray.add(user.getUserName());*/
		
		infoArray.add(user.getName());
		infoArray.add(user.getUserName());
		infoArray.add(user.getPassword());
		infoArray.add(user.getDateofBirth().toString());
		infoArray.add(user.getSchoolGraduated());
		infoArray.add(user.getUserID().toString());
		infoArray.add(user.getRelationshipStatus());
		dictUsers.put(user, infoArray);
		dictName.put(user.getUserName(), user);
		//dictID.put(user.getUserID(), user);
		//System.out.println(user.getRelationshipStatus());
		//System.out.println(user.getName());
		//System.out.println(usersArray);
		//(String password, String name, String username, Date date, String schoolName)
	}//end addUser
	
	/**
	 * @param id user id who will be deleted from system
	 */
	public static void removeUser(String username){
		for(User user : UserCollection.usersArray){
			Iterator<User> iter = user.getFriendList().iterator();
			while(iter.hasNext()){
				if(iter.next().getUserName().equals(username)){
					iter.remove();
				}
			}
		}
		for(User user : UserCollection.usersArray){
			Iterator<User> iter = user.getBlockedFriendList().iterator();
			while(iter.hasNext()){
				if(iter.next().getUserName().equals(username)){
					iter.remove();
				}
			}
		}
		if(dictName.keySet().contains(username)){
			
			dictUsers.remove(dictName.get(username));
			
			dictName.remove(username);
		} else{System.out.println("No such user!");}
		
		for(User user : (ArrayList<User>) usersArray.clone()){
			if(user.getUserName().equals(username)){
				usersArray.remove(user);
			}
		}
		
	}//end removeUser
	
	
	
	
	/**
	 * @param username username whose will sign in to system
	 * @param password password whose who will sign in to system
	 */
	public static void signIn(String username, String password){
		try{
			if(dictName.get(username).getPassword().equals(password)){
				dictName.get(username).setSignedIn(true);
				//System.out.println("You have successfully signed in");
			}
			else{System.out.println();}
			
		}
		catch(Exception e){
			System.out.println();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @return hashmap takes string as key, gives user as value
	 */
	public static HashMap<String, User> getDictUserName() {return dictUserName;}
	/**
	 * @param dictUserName to set dictusername dictionary 
	 */
	public static void setDictUserName(HashMap<String, User> dictUserName) {UserCollection.dictUserName = dictUserName;}

	/**
	 * @return user's arraylist 
	 */
	public static ArrayList<User> getUsersArray() {return usersArray;}
	/**
	 * @param usersArray users array to set
	 */
	public static void setUsersArray(ArrayList<User> usersArray) {UserCollection.usersArray = usersArray;}


	/**
	 * @return returns id counter
	 */
	public static Integer getIDCounter() {return IDCounter;}
	/**
	 * @param iDCounter id counter
	 */
	public static void setIDCounter(Integer iDCounter) {IDCounter = iDCounter;}

	/**
	 * @return hashmap takes user object as key, gives list of user's information as value
	 */
	public static HashMap<User, List> getDictUsers() {return dictUsers;}
	/**
	 * @param dictUsers users dictionary
	 */
	public static void setDictUsers(HashMap<User, List> dictUsers) {UserCollection.dictUsers = dictUsers;}
	
	/**
	 * @return another hashmap of users
	 */
	public static HashMap<String, User> getDictName() {return dictName;}
	/**
	 * @param dictName hashmap of users 
	 */
	public static void setDictName(HashMap<String, User> dictName) {UserCollection.dictName = dictName;}
	
	/**
	 * @return hashmap of user's id
	 */
	public static HashMap<Integer, User> getDictID() {return dictID;}
	/**
	 * @param dictID hashmap of users id 
	 */
	public static void setDictID(HashMap<Integer, User> dictID) {UserCollection.dictID = dictID;}
	
	
	
	
	
	
	
	
}//end class
