package Test;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.io.CSV;;

public class TestCSV {

	@Test
	public void testReadCategoryDataset() throws IOException
	{
		CSV csv = new CSV();
		StringReader stringReader = new StringReader(" , A,B\nC,1,2\nD,3,4");
		CategoryDataset categoryDataset = csv.readCategoryDataset(stringReader);
		Assert.assertEquals(2, categoryDataset.getColumnKeys().size());
		Assert.assertEquals(2, categoryDataset.getRowKeys().size());
		Assert.assertEquals(1.0, categoryDataset.getValue(0, 0));
		Assert.assertEquals(2.0, categoryDataset.getValue(0, 1));
		Assert.assertEquals(3.0, categoryDataset.getValue(1, 0));
		Assert.assertEquals(4.0, categoryDataset.getValue(1, 1));
	}
}
