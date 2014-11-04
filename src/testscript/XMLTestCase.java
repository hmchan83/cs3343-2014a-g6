package testscript;

import java.io.FileNotFoundException;

import ioModule.IO;
import junit.framework.TestCase;

import org.junit.Test;


public class XMLTestCase extends TestCase{
	
	@Test
	public void testXML_1() {
		IO IO = new IO();
		try {
			IO.inputXML("xml/test1.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
