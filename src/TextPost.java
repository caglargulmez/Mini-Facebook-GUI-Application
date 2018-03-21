import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class TextPost extends Post {

	/**
	 * @param text post's content
	 * @param originatedDate post's originated date
	 * @param taggedUsers post's tagged users array
	 * @param location post's location
	 * @param postID post's post id
	 */
	public TextPost(String text, Date originatedDate, ArrayList<String> taggedUsers, Location location, UUID postID) {
		super(text, originatedDate, taggedUsers, location, postID);
	}

	
	

	/* (non-Javadoc)
	 * @see Post#showTaggedUsers()
	 */
	@Override
	public void showTaggedUsers() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see Post#showPostLocation()
	 */
	@Override
	public void showPostLocation() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void setText() {
		// TODO Auto-generated method stub
		
	}

}
