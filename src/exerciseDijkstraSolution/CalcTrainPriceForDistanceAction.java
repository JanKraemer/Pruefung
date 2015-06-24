package exerciseDijkstraSolution;

public class CalcTrainPriceForDistanceAction extends CalcPriceForDistanceAction
{
	
	public int priceForDistance(int distance)
	{
		return distance * (distance>60 ? 30 : 50); 
	}
	
}
