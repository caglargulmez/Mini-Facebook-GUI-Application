import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ImagePost extends TextPost{
	/**
	 * image's file name
	 */
	private String imageFilename;
	/**
	 * image's resolution
	 */
	private String imageResolution;
	
	/**
	 * @param text post's text content
	 * @param originatedDate post's originated date
	 * @param taggedUsers post's tagged users
	 * @param imageFilename post's image filename
	 * @param imageResolution post's image resolution
	 * @param postID post's post id
	 * @param location post's location
	 */
	public ImagePost(String text, Date originatedDate, ArrayList<String> taggedUsers, String imageFilename, String imageResolution, UUID postID, Location location) {
		super(text, originatedDate, taggedUsers, location, postID);
		this.setImageFilename(imageFilename);
		this.setImageResolution(imageResolution);
		
	}

	
	
	
	/**
	 * @return post's image file name
	 */
	public String getImageFilename() {return imageFilename;}
	/**
	 * @param imageFilename image file name to set
	 */
	public void setImageFilename(String imageFilename) {this.imageFilename = imageFilename;}

	/**
	 * @return post's image resolution
	 */
	public String getImageResolution() {return imageResolution;}
	/**
	 * @param imageResolution image resolution name to set
	 */
	public void setImageResolution(String imageResolution) {this.imageResolution = imageResolution;}
	
	
	
	
	
}
