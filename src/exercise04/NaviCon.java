package exercise04;

public class NaviCon implements NaviConInterface {

	private GeoLocationManager geoManager= null;
	private Point now;
	@Override
	public void setGeoLocationManager(GeoLocationManager geoManager) {
		// TODO Auto-generated method stub
		this.geoManager = geoManager;
	}

	@Override
	public Point getCurrentPosition() throws InstantiationException,
			NullPointerException {
	if(geoManager == null)
	{
		throw new NullPointerException("NoGeoManager");
	}
		try{
			now = geoManager.currentLocation().moved(1, -1); 
		}
		catch(IllegalAccessException e)
		{
			this.getCurrentPosition();
		}
	
	return now;
	}
}
