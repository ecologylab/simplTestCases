package composite;


public class WCSubOne extends WCBase
{
	
	@simpl_scalar	
	String subString;
	
	public WCSubOne()
	{
		subString = "";
	}
	
	public WCSubOne(String subString)
	{
		this.subString = subString;
		this.x = 4;
	}
}
