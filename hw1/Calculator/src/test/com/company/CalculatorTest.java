package test.com.company; 

import com.company.Calculator;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Calculator Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 9, 2019</pre> 
* @version 1.0 
*/ 
public class CalculatorTest { 

@Before
public void before() throws Exception {
    System.out.println("Before:");
} 

@After
public void after() throws Exception {
    System.out.println("After.");
} 

/** 
* 
* Method: address(String input, String text) 
* 
*/ 
@Test
public void testAddress() throws Exception {
    Calculator cal = new Calculator();
    System.out.println(cal.address("cle", "1/2+3-1"));
    System.out.println(cal.address("del", "1+2+3*4"));
    System.out.println(cal.address("2", "1+2"));
    System.out.println(cal.address("=", "1+2"));
} 

/** 
* 
* Method: calculate(String input) 
* 
*/ 
@Test
public void testCalculate() throws Exception {
    Calculator cal = new Calculator();
    System.out.println(cal.calculate("1+2"));
    System.out.println(cal.calculate("3*2"));
    System.out.println(cal.calculate("12/3"));
    System.out.println(cal.calculate("-1+3"));
} 

/** 
* 
* Method: operation(String left, String right, String op) 
* 
*/ 
@Test
public void testOperation() throws Exception { 
    Calculator cal = new Calculator();
    System.out.println(cal.operation("2", "3", "+"));
    System.out.println(cal.operation("9", "4", "-"));
    System.out.println(cal.operation("3", "4", "*"));
    System.out.println(cal.operation("6", "3", "/"));
} 


} 
