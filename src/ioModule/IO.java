package ioModule;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import store.*;
/**
 * temporary I/O handler
 * @author Marcus
 *
 */
public class IO {
	
	public ArrayList<Course> inputXML(String filePath) throws FileNotFoundException{
		//scanner = new Scanner(System.in);
		//System.out.print("Enter the path of course.xml: ");
		//String filePath = scanner.nextLine();
		//scanner.close();
		XMLparser xmlParser = new XMLparser();
		return xmlParser.parseXML(filePath);
	}
	
	public void out(ArrayList<Course> list){// test only
		if(list.isEmpty()==true) System.out.println("No such result.");
		else{
			for(int i=0; i<list.size();i++){
				System.out.println("\tCourse : "+list.get(i).toString());
				for(int j=0;j<list.get(i).getSec().size();j++){
					System.out.println("\t\tSession : "+list.get(i).getSec().get(j).toString());
				}
			}
		}
	}
	
	public void out(String str){
		System.out.println(str);
	}

}
/*

 Test Case 1.1:
2
CS0001 TEST1 2 true
C01 Fri 1200 1300 AC2 LT6 12345 3
C02 Mon 1100 1200 AC2 LT8 12346 3 
CS0002 TEST2 1
C01 Fri 1200 1300 AC3 LT6 12347 3
 */