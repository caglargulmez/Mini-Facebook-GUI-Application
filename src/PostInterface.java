import java.util.Date;
import java.util.UUID;

/**
 * @author Caglar
 *
 */
public interface PostInterface {
	
	/**
	 * @return nothing because it's in the interface
	 */
	public String getText();			//implemented in post
	/**
	 * sets text
	 */
	public void setText();				//implemented in post
	/**
	 * @return nothing because it's in the interface
	 */
	public UUID getPostID();			//implemented in post
	/**
	 * @return nothing because it's in the interface
	 */
	public Date getOriginatedDate();	//implemented in post
	
	
}
