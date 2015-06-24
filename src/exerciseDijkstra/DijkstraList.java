package exerciseDijkstra;

import java.util.*;

public class DijkstraList {

	HashMap<City, Boolean> list = null;
	
	public DijkstraList()
	{
		list = new HashMap<City,Boolean>();
	}
	public void addElement(String c)
	{
		list.put(new City(c), false);
	}
	public City getCitybyName(String name)
	{
		City searched= null;
		for(City c : list.keySet())
			if(c.getName().equals(name))
				searched = c;
		return searched;
	}
	public City getNearestCity()
	{
		City[] all = list.keySet().toArray(new City[1]);
		City ausgabe =null;
		Arrays.sort(all);
		for(int i = 0;i<all.length;i++)
			if(!list.get(all[i]))
			{
				ausgabe = all[i];
				break;
			}
		return ausgabe;
	}
	public int unvisitedCities()
	{
		int count = 0;
		for(Boolean b: list.values())
			if(!b)
				count++;
		return count;
	}
	public void updateCity(City c, int distance)
	{
		boolean visited = list.get(c);
		if(!visited)
		{
			list.remove(c);
			c.setEntfernung(distance);
			list.put(c,visited);
		}
	}public void cityVisited(City c)
	{
		list.remove(c);
		list.put(c, true);
	}
	
}
