package flow;

// import flow.*;
import flow.samples.TextAdapter;
import flow.samples.TextAgent;
import flow.samples.TextApp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;


@RunWith(JUnit4.class)
public class EmailTest 
{
	private Engine engine;

  @Test
  public void testRun_AdapterIsCompliantWithProtocol_AppHasHelloMessage() throws Exception 
  {
	  
	  
	      Map<String, IAdapter> adapters = new HashMap();
    adapters.put("TEXT", new TextAdapter());
    engine = new Engine(new TextAgent("hello"), adapters, new TextApp());
    engine.run();
    // System.out.print("test1");
	TextApp textApp = (TextApp) engine.getApp();
    Assert.assertEquals("ACK:hello", textApp.popResponse());
	
  }
  
}

