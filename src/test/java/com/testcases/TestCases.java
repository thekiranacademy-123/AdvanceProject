package com.testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tka.MyListerner;
@Listeners(MyListerner.class)
public class TestCases {
	
	@Test
	void test1()
	{
	    Assert.assertEquals(3,4);
	}
	@Test
	void test2()
	{
	    Assert.assertEquals(3,3);
	}
	@Test
	void test3()
	{
	    Assert.assertEquals(3,4);
	}
	@Test
	void test4()
	{
	    Assert.assertEquals(3,4);
	}
	@Test
	void test5()
	{
	    throw new SkipException("");
	}
}
