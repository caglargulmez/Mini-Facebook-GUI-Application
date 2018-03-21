import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class VideoPost extends TextPost{

	/**
	 * maximum video length
	 */
	static final double maxVideoLength = 10;
	/**
	 * video's filename
	 */
	private String videoFilename;
	/**
	 * video's duration
	 */
	private String videoDuration;
	
	
	
	/**
	 * @param text post's 
	 * @param originatedDate post's originated Date
	 * @param taggedUsers post's tagged Users
	 * @param videoFilename post's video Filename
	 * @param videoDuration post's video Duration
	 * @param postID post's post ID
	 * @param location post's location
	 */
	public VideoPost(String text, Date originatedDate, ArrayList<String> taggedUsers, String videoFilename, String videoDuration, UUID postID, Location location) {
		super(text, originatedDate, taggedUsers, location, postID);
		this.setVideoFilename(videoFilename);
		this.setVideoDuration(videoDuration);
	}



	/**
	 * @return post's video file name
	 */
	public String getVideoFilename() {return videoFilename;}
	/**
	 * @param videoFilename sets  video file name
	 */
	public void setVideoFilename(String videoFilename) {this.videoFilename = videoFilename;}
	
	/**
	 * @return post's video duration
	 */
	public String getVideoDuration() {return videoDuration;}
	/**
	 * @param videoDuration sets 
	 */
	public void setVideoDuration(String videoDuration) {this.videoDuration = videoDuration;}

	
	
	
	
	
	
}
