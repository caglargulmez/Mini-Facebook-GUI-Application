
/**
 * @author Caglar
 *
 */
/**
 * @author Caglar
 *
 */
public class Location {
/*##############################################################*/	
/*	   Location should be implemented as a separate class		*/    //-latitude
/*	   with the following attributes: latitude and longitude	*/    //-longitude
/*	   (stored as double values).								*/
/*##############################################################*/	
	
	/**
	 * location's latitude
	 */
	private double latitude;
	/**
	 * location's longitude
	 */
	private double longitude;
	
	/**
	 * @param latitude location's latitude
	 * @param longitude location's longitude
	 */
	public Location(Double latitude, Double longitude){
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}
	
	
	/**
	 * @return location's latitude
	 */
	public double getLatitude() {return latitude;}
	/**
	 * @param latitude location's latitude to set
	 */
	public void setLatitude(double latitude) {this.latitude = latitude;}
	
	/**
	 * @return location's longitude
	 */
	public double getLongitude() {return longitude;}
	/**
	 * @param longitude location's longitude to set
	 */
	public void setLongitude(double longitude) {this.longitude = longitude;}
	
	
	
}
