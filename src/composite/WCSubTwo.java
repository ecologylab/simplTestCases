package composite;

public class WCSubTwo extends WCBase
{
	
	@simpl_scalar	
	Boolean myBool;
	
	public WCSubTwo()
	{
		myBool = false;
	}
	
	public WCSubTwo(Boolean myBool)
	{
		this.myBool = myBool;
		this.x = 5;
	}
}