package tests.circle;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.formatenums.Format;

public class Point implements TestCase
{

	@simpl_scalar
	private int	x;

	@simpl_scalar
	private int	y;

	public Point()
	{

	}

	public Point(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getX()
	{
		return x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getY()
	{
		return y;
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		Point p = new Point(1, 2);

		TestingUtils.test(p, SimplTypesScope.get("point", Point.class), Format.XML);
		TestingUtils.test(p, SimplTypesScope.get("point", Point.class), Format.JSON);		
		TestingUtils.test(p, SimplTypesScope.get("point", Point.class), Format.TLV);
	}
}
