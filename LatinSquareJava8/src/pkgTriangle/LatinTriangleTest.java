package pkgTriangle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LatinTriangleTest {

	@Test
	void GoodTriangle1() {
		int[][] square = new int[][] { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 1, 2 } };
		if (!ArrayTester.isLatin(square)) {
			fail("Not a Lain Square");
		}
	}
	
	@Test
	void GoodTriangle2() {
		int[][] square = new int[][] { { 10, 30, 20, 0 }, { 0, 20, 30, 10 }, { 30, 0, 10, 20 }, {20, 10, 0, 30} };
		if (!ArrayTester.isLatin(square)) {
			fail("Not a Lain Square");
		}
	}	
	
	@Test
	void BadTriangle1() {
		int[][] square = new int[][] { { 1, 2, 1}, {2, 1, 1}, {1, 1, 2} };
		if (ArrayTester.isLatin(square)) {
			fail("Not a Lain Square");
		}
	}		
	@Test
	void BadTriangle2() {
		int[][] square = new int[][] { { 1, 2, 3}, {3, 1, 2}, {7, 8, 9} };
		if (ArrayTester.isLatin(square)) {
			fail("Not a Lain Square");
		}
	}	
	@Test
	void BadTriangle3() {
		int[][] square = new int[][] { { 1, 2}, {1, 2} };
		if (ArrayTester.isLatin(square)) {
			fail("Not a Lain Square");
		}
	}	
}
