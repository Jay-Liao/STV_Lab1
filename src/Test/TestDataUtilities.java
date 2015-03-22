package Test;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.junit.Assert;
import org.junit.Test;

public class TestDataUtilities {
	
	@Test
	public void testCalculateColumnTotal_WithInvalidColumnKey()
	{
		DefaultKeyedValues2D values2d = new DefaultKeyedValues2D();
		Assert.assertEquals(0, DataUtilities.calculateColumnTotal(values2d, -1), 0.1);
		Assert.assertEquals(0, DataUtilities.calculateColumnTotal(values2d, 0), 0.1);
		Assert.assertEquals(0, DataUtilities.calculateColumnTotal(values2d, 99), 0.1);
	}
	
	@Test
	public void testCalculateColumnTotal_WithEmptyValues()
	{
		DefaultKeyedValues2D values2d = new DefaultKeyedValues2D();
		Assert.assertEquals(0, DataUtilities.calculateColumnTotal(values2d, 0), 0.1);
	}
	
	@Test
	public void testCalculateColumnTotal_WithIncremententalValues()
	{
		DefaultKeyedValues2D values2d = new DefaultKeyedValues2D();
		for (int i = 0; i < 10; i++) 
		{
			values2d.addValue(i, i, i);
		}
		for (int i = 0; i < 10; i++) 
		{
			Assert.assertEquals(i, DataUtilities.calculateColumnTotal(values2d, i), 0.1);
		}
	}
	
	@Test
	public void testCalculateRowTotal_WithInvalidRowKey()
	{
		DefaultKeyedValues2D values2d = new DefaultKeyedValues2D();
		Assert.assertEquals(0, DataUtilities.calculateRowTotal(values2d, -1), 0.1);
		Assert.assertEquals(0, DataUtilities.calculateRowTotal(values2d, 0), 0.1);
		Assert.assertEquals(0, DataUtilities.calculateRowTotal(values2d, 99), 0.1);
	}
	
	@Test
	public void testCalculateRowTotal_WithEmptyValues()
	{
		DefaultKeyedValues2D values2d = new DefaultKeyedValues2D();
		Assert.assertEquals(0, DataUtilities.calculateRowTotal(values2d, 0), 0.1);
	}
	
	@Test
	public void testCalculateRowTotal_WithIncremententalValues()
	{
		DefaultKeyedValues2D values2d = new DefaultKeyedValues2D();
		for (int i = 0; i < 10; i++) 
		{
			values2d.addValue(i, i, i);
		}
		for (int i = 0; i < 10; i++) 
		{
			Assert.assertEquals(i, DataUtilities.calculateRowTotal(values2d, i), 0.1);
		}
	}
	
	@Test
	public void testClone()
	{
		double[][] target = new double[2][];
		target[0] = new double[3];
		target[1] = new double[5];
		for(int i = 0; i < target.length; i++) 
		{ 
            for(int j = 0; j < target[i].length; j++) 
            {
            	target[i][j] = j + 1; 
            }
        } 
		double[][] result = DataUtilities.clone(target);
		Assert.assertEquals(target.length, result.length);
		Assert.assertEquals(target[0].length, result[0].length);
		Assert.assertEquals(target[1].length, result[1].length);
		Assert.assertArrayEquals(target[0], result[0], 0.1);
		Assert.assertArrayEquals(target[1], result[1], 0.1);
	}
	
	@Test
	public void testCreateNumberArray()
	{
		double[] target = new double[3];
		for (int i = 0; i < target.length; i++)
		{
			target[i] = i;
		}
		Number[] aNumbers = DataUtilities.createNumberArray(target);
		Assert.assertEquals(target.length, aNumbers.length);
		for (int i = 0; i < aNumbers.length; i++)
		{
			Assert.assertEquals(i, aNumbers[i].doubleValue(), 0.1);
		}
	}
	
	@Test
	public void testEqual()
	{
		double[][] target = new double[2][];
		double[][] comparator = new double[2][];
		target[0] = new double[3];
		target[1] = new double[5];
		comparator[0] = new double[3];
		comparator[1] = new double[5];
		for(int i = 0; i < target.length; i++) 
		{ 
            for(int j = 0; j < target[i].length; j++) 
            {
            	target[i][j] = j + 1; 
            	comparator[i][j] = j + 1; 
            }
        } 
		Assert.assertTrue(DataUtilities.equal(target, comparator));
		comparator[0][0] = 99;
		Assert.assertFalse(DataUtilities.equal(target, comparator));
	}
}
