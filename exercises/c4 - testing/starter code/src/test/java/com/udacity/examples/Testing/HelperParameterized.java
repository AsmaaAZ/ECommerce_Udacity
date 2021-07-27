package com.udacity.examples.Testing;
// @author asmaa **

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HelperParameterized {
  private String input;
  private String output;

  public HelperParameterized(String input, String output) {
    super();
    this.input = input;
    this.output = output;
  }

  @Parameters
  public static Collection initData(){
    String names[][] = {{"yo","you"}, {"yo","yee"},{"yee","ye"}};
    return Arrays.asList(names);
  }

  @Test
  public void verifyNames(){
    Assert.assertNotEquals(input,output);
  }
}
