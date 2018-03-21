import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @author Caglar
 *
 */
public abstract class Post implements PostInterface {

/*#############################################################################*/
/*	All posts have a unique "postID" which should be assigned as a random      */
/*  UUID (immutable universally unique identifier), "a text", " date" when the */
/*  post originated, "a location", and a "collection of tagged friends".       */
/*#############################################################################*/
/*  -postID 																   */
/* 	-text																	   */
/* 	-date																       */
/* 	-location																   */
/* 	-collectionOfTaggedFriends												   */
/*#############################################################################*/
	
	
	/**
	 * post's post id
	 */
	private UUID postID;       		// UUID randomUUO();      //all posts have a unique postID wihch should be assigned as a random
	/**
	 * post's originated date
	 */
	private Date originatedDate;    		 			 	  //a date when the post originated
	/**
	 * post's text contents
	 */
	private String text;
	/**
	 * post's tagged users arraylist
	 */
	private ArrayList<String> taggedUsers = new ArrayList<String>();
	/**
	 * post's location
	 */
	private Location location;
	
	/**
	 * @param text post's text
	 * @param originatedDate post's originated date
	 * @param taggedUsers post's tagged users
	 * @param location  post's location
	 * @param postID post's postID 
	 */
	public Post(String text, Date originatedDate, ArrayList<String> taggedUsers, Location location,  UUID postID){
		this.setOriginatedDate(originatedDate);
		this.setText(text);
		this.setTaggedUsers(taggedUsers);
		this.setLocation(location);
		this.setPostID(postID);
	}
	
	/**
	 * @return  post's location
	 */
	public String getLocation(){return (location.getLongitude() + ", " + location.getLatitude() );}
	
	/**
	 * @param date  post's date
	 * @return  post's originated date
	 */
	public Date getOriginatedDate(Date date){return date;}
	

	/**
	 * @param text post's text to set
	 */
	public void setText(String text) {this.text = text;}
	
	
	/* (non-Javadoc)
	 * @see PostInterface#getText()
	 */
	public String getText(){return text;}
	
	
/*########    Abstract Methods     #########*/
	/**
	 * abstract methods of abstract class
	 */
	public abstract void showTaggedUsers(); 
	/**
	 * abstract methods of abstract class
	 */
	public abstract void showPostLocation();
/*##########################################*/	
	
	
	
	/**
	 * @param location location to set
	 */
	public void setLocation(Location location) {this.location = location;}

	/**
	 * @return tagged users arrays
	 */
	public ArrayList<String> getTaggedUsers() {return taggedUsers;}
	/**
	 * @param taggedUsers tagged users to set
	 */
	public void setTaggedUsers(ArrayList<String> taggedUsers) {this.taggedUsers = taggedUsers;}

	/* (non-Javadoc)
	 * @see PostInterface#getPostID()
	 */
	public UUID getPostID() {return postID;}
	/**
	 * @param postID post id to set
	 */
	public void setPostID(UUID postID) {this.postID = postID;}
	
	/* (non-Javadoc)
	 * @see PostInterface#getOriginatedDate()
	 */
	public Date getOriginatedDate() {return originatedDate;}
	/**
	 * @param originatedDate originated date to set
	 */
	public void setOriginatedDate(Date originatedDate) {this.originatedDate = originatedDate;}
	
	
	
}
