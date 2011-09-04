package tests.circle;

import tests.TestCase;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.serializers.Format;

public class Point extends TestCase
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
	public void runTest()
	{
		Point p = new Point(1, 2);

		test(p, TranslationScope.get("point", Point.class), Format.XML);
		test(p, TranslationScope.get("point", Point.class), Format.JSON);
	}
}
