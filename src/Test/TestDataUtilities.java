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
	public void testCalculateColumnTotal_WithValidRows()
	{
		DefaultKeyedValues2D values2d = new DefaultKeyedValues2D();
		// row 1
		values2d.addValue(1, 0, 0);
		values2d.addValue(2, 0, 1);
		values2d.addValue(3, 0, 2);
		// row 2
		values2d.addValue(4, 1, 0);
		values2d.addValue(5, 1, 1);
		values2d.addValue(6, 1, 2);
		// row 3
		values2d.addValue(7, 2, 0);
		values2d.addValue(8, 2, 1);
		values2d.addValue(null, 2, 2);
		
		int[] validRows1 = {3};
		int[] validRows2 = {0, 1};
		int[] validRows3 = {0, 1, 2};
		Assert.assertEquals(0, DataUtilities.calculateColumnTotal(values2d, 0, validRows1), 0.1);
		Assert.assertEquals(7, DataUtilities.calculateColumnTotal(values2d, 1, validRows2), 0.1);
		Assert.assertEquals(9, DataUtilities.calculateColumnTotal(values2d, 2, validRows3), 0.1);
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
