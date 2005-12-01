package org.junit.tests;

import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.extensions.Parameterized;
import org.junit.runner.extensions.Parameters;

public class ParameterizedTestTest {
	
	@RunWith(Parameterized.class)
	static public class FibonacciTest {
		@Parameters public static Object[] data() {
			return new int[][] {{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}};
		}
		
		private int fInput; 
		private int fExpected;
		
		public FibonacciTest(int input, int expected) {
			fInput= input;
			fExpected= expected;
		}
		
		@Test public void test() {
			assertEquals(fExpected, fib(fInput));
		}

		private int fib(int x) {
			return 0;
		}
	}

	@Test public void count() {
		Result result = JUnitCore.runClasses(FibonacciTest.class);
		assertEquals(7, result.getRunCount());
		assertEquals(6, result.getFailureCount());
	}
	
	private static String fLog;
	@RunWith(Parameterized.class)
	static public class EmptyTest {
		@BeforeClass public static void before() {
			fLog+= "before ";
		}
		@AfterClass public static void after() {
			fLog+= "after ";
		}
	}
	
	@Test public void beforeAndAfterClassAreRun() {
		fLog= "";
		JUnitCore.runClasses(EmptyTest.class);
		assertEquals("before after ", fLog);
	}
	
	static public junit.framework.Test suite() {
		return new JUnit4TestAdapter(ParameterizedTestTest.class);
	}
}
