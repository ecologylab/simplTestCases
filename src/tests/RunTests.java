package tests;

import java.util.ArrayList;

import tests.circle.*;
import tests.person.*;

public class RunTests
{
	private ArrayList<TestCase>	testCases	= new ArrayList<TestCase>();

	public RunTests()
	{
		testCases.add(new Point());
		testCases.add(new Circle());
		testCases.add(new CollectionOfCircles());
		testCases.add(new Person());
		testCases.add(new Faculty());
		testCases.add(new Student());
		testCases.add(new StudentDirectory());
		testCases.add(new PersonDirectory());
	}

	public void runTestCases()
	{
		System.out.println("*****Executing " + testCases.size() + " Test Cases******** ");
		System.out.println();
		int i = 1;

		for (TestCase testCase : testCases)
		{
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Test Case " + i++ + " : " + testCase.getClass().getCanonicalName());
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
			testCase.runTest();
		}
		System.out.println("*****End********");
	}

	public static void main(String[] args)
	{
		RunTests runTests = new RunTests();
		runTests.runTestCases();
	}
}
