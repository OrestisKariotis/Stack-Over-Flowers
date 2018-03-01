package gr.ntua.ece.softeng.kidspiration;

public class Location {

	private double longtit;
	private double langtit;
	
	public Location(double longtit,double langtit) {
		this.longtit=longtit;
		this.langtit=langtit;
	}
	
	 public double getY() {
	        return langtit;
	    }

	    public void setY(Double langtit) {
	        this.langtit = langtit;
	    }
	    
	    
	    
	    public double getX() {
	        return longtit;
	    }

	    public void setX(Double longtit) {
	        this.longtit = longtit;
	    }
}
