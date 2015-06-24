package exerciseDijkstra;


public class City implements Comparable<City>{
	
	private String name;
	private int distance;
	
	public City(String name)
	{
		this.name = name;
		distance = Integer.MAX_VALUE;
	}
	public String getName()
	{
		return this.name;
	}
	public int getDistance()
	{
		return this.distance;
	}
	public void setEntfernung(int distance)
	{
		this.distance = this.distance > distance ? distance : this.distance;
	}
	@Override
	public int compareTo(City o) {
		return ((Integer)this.distance).compareTo(o.distance);
	}	

}
