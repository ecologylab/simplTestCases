package tests.circle;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.Format;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.StringFormat;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_scalar;

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

		TestingUtils.test(p, TranslationScope.get("point", Point.class), StringFormat.XML);
		TestingUtils.test(p, TranslationScope.get("point", Point.class), StringFormat.JSON);
	}
}
