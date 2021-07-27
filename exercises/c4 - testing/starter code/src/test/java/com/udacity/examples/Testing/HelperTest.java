package com.udacity.examples.Testing;

import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class HelperTest {
	@BeforeClass
	public static void setup(){
		System.out.println("INITILIZE A TEST CLASS");
	}

	@AfterClass
	public static void teardown(){
		System.out.println("TEARDOWN TEST CLASS");
	}

	@Test
	public void getCountTest(){
		List<String> ls = Arrays.asList("sdf", "w3r", "", "", "3rede", "");

		Assert.assertEquals(3, Helper.getCount(ls));
	}

	@Test
	public void getStatsTest(){
		List<Integer> ls = Arrays.asList(1,2,3,4,5);

		Assert.assertEquals(5, Helper.getStats(ls).getMax());
	}

	@Test
	public void getStringsOfLength3Test(){
		List<String> ls = Arrays.asList("sdf", "w3r", "", "", "3rede", "");

		Assert.assertEquals(2, Helper.getStringsOfLength3(ls));
	}

	@Test
	public void getSquareListTest(){
		List<Integer> ls = Arrays.asList(1,2,3,4,5);
		List<Integer> sqls = Arrays.asList(1,4,9,16,25);

		Assert.assertEquals(sqls, Helper.getSquareList(ls));
	}

	@Test
	public void getMergedListTest(){
		List<String> ls = Arrays.asList("sdf", "w3r", "", "", "3rede", "");

		Assert.assertEquals("sdf, w3r, 3rede", Helper.getMergedList(ls));
	}

	@Test
	public void getFilteredListTest(){
		List<String> ls = Arrays.asList("sdf", "w3r", "", "", "3rede", "");
		List<String> actualList = Arrays.asList("sdf", "w3r", "3rede");

		Assert.assertEquals(actualList, Helper.getFilteredList(ls));
	}

}
