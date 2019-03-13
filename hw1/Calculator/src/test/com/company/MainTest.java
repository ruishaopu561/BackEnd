package test.com.company; 

import com.company.Interface;
import com.company.Main;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Main Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 9, 2019</pre> 
* @version 1.0 
*/ 
public class MainTest { 

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
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
    Main m = new Main();
//    m.equals(new Interface());
//    m.
}


} 
