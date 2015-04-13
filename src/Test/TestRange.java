package Test;

import org.jfree.data.Range;
import org.junit.Assert;
import org.junit.Test;

public class TestRange {
	@Test
	public void testCombine_WithTwoSameRange()
	{
		Range aRange1 = new Range(0, 0);
		Range aRange2 = new Range(0, 0);
		Range result = Range.combine(aRange1, aRange2);
		Assert.assertEquals(0, result.getLength(), 0.000001);
		Assert.assertEquals(0, result.getLowerBound(), 0.000001);
		Assert.assertEquals(0, result.getUpperBound(), 0.000001);
		Assert.assertEquals(0, result.getCentralValue(), 0.000001);
	}
	
	@Test
	public void testCombine_WithTwoIntersectRange()
	{
		Range aRange1 = new Range(-1, 1);
		Range aRange2 = new Range(-0.5, 5);
		Range result = Range.combine(aRange1, aRange2);
		Assert.assertEquals(6, result.getLength(), 0.000001);
		Assert.assertEquals(-1, result.getLowerBound(), 0.000001);
		Assert.assertEquals(5, result.getUpperBound(), 0.000001);
		Assert.assertEquals(2, result.getCentralValue(), 0.000001);
	}
	
	@Test
	public void testCombine_WithTwoUnintersectRange()
	{
		Range aRange1 = new Range(-1, 0);
		Range aRange2 = new Range(0, 9);
		Range result = Range.combine(aRange1, aRange2);
		Assert.assertEquals(10, result.getLength(), 0.000001);
		Assert.assertEquals(-1, result.getLowerBound(), 0.000001);
		Assert.assertEquals(9, result.getUpperBound(), 0.000001);
		Assert.assertEquals(4, result.getCentralValue(), 0.000001);
	}
	
	@Test
	public void testCombine_WithFirstEmptyRange()
	{
		Range aRange1 = null;
		Range aRange2 = new Range(0, 9);
		Range result = Range.combine(aRange1, aRange2);
		Assert.assertEquals(aRange2.getLength(), result.getLength(), 0.000001);
		Assert.assertEquals(aRange2.getLowerBound(), result.getLowerBound(), 0.000001);
		Assert.assertEquals(aRange2.getUpperBound(), result.getUpperBound(), 0.000001);
		Assert.assertEquals(aRange2.getCentralValue(), result.getCentralValue(), 0.000001);
	}
	
	@Test
	public void testCombine_WithSecondEmptyRange()
	{
		Range aRange1 = new Range(-1, 0);
		Range aRange2 = null;
		Range result = Range.combine(aRange1, aRange2);
		Assert.assertEquals(aRange1.getLength(), result.getLength(), 0.000001);
		Assert.assertEquals(aRange1.getLowerBound(), result.getLowerBound(), 0.000001);
		Assert.assertEquals(aRange1.getUpperBound(), result.getUpperBound(), 0.000001);
		Assert.assertEquals(aRange1.getCentralValue(), result.getCentralValue(), 0.000001);
	}
	
	@Test
	public void testConstrain()
	{
		Range aRange = new Range(-1, 1);
		Assert.assertEquals(1, aRange.constrain(1), 0.000001);
		Assert.assertEquals(-1, aRange.constrain(-1), 0.000001);
		Assert.assertEquals(0, aRange.constrain(0), 0.000001);
		Assert.assertEquals(0.1, aRange.constrain(0.1), 0.000001);
		Assert.assertEquals(-0.1, aRange.constrain(-0.1), 0.000001);
		Assert.assertEquals(1, aRange.constrain(99), 0.000001);
		Assert.assertEquals(-1, aRange.constrain(-99), 0.000001);
	}
	
	@Test
	public void testContains()
	{
		Range aRange = new Range(-1, 1);
		Assert.assertFalse(aRange.contains(-1.1));
		Assert.assertTrue(aRange.contains(-1));
		Assert.assertTrue(aRange.contains(0));
		Assert.assertTrue(aRange.contains(1));
		Assert.assertFalse(aRange.contains(1.1));
	}
	
	@Test
	public void testGetCentralValue_WithNegativeRange()
	{
		Range aRange = new Range(-10, -5);
		Assert.assertEquals(-7.5, aRange.getCentralValue(), 0.000001);
	}
	
	@Test
	public void testGetCentralValue_WithNegativeAndPositiveRange()
	{
		Range aRange = new Range(-8, 6);
		Assert.assertEquals(-1, aRange.getCentralValue(), 0.000001);
	}
	
	@Test
	public void testGetCentralValue_WithPositiveRange()
	{
		Range aRange = new Range(1, 6);
		Assert.assertEquals(3.5, aRange.getCentralValue(), 0.000001);
	}
	
	@Test
	public void testGetLength_WithNegativeRange()
	{
		Range aRange = new Range(-10, -5);
		Assert.assertEquals(5, aRange.getLength(), 0.000001);
	}
	
	@Test
	public void testGetLength_WithNegativeAndPositiveRange()
	{
		Range aRange = new Range(-8, 6);
		Assert.assertEquals(14, aRange.getLength(), 0.000001);
	}
	
	@Test
	public void testGetLength_WithPositiveRange()
	{
		Range aRange = new Range(1, 6);
		Assert.assertEquals(5, aRange.getLength(), 0.000001);
	}
}
