package ioMoudle;

import java.util.ArrayList;
import java.util.Scanner;

import store.*;
/**
 * IO.IO
 * temporary I/O handler
 * @author Marcus
 *
 */
public class IO {
	
	private Scanner scanner;

	public ArrayList<Course> input(){// test only
		scanner = new Scanner(System.in);
		ArrayList<Course> list = new ArrayList<>();
			System.out.println("enter the number of course");
			int courseNum = scanner.nextInt();
			for(int i=0; i < courseNum;i++){
				System.out.println("enter the id, name, no. of section of course "+(i+1));
				String courseID = scanner.next();
				String courseName = scanner.next();
				Course currCourse = new Course(courseID,courseName);
				int sectionNum = scanner.nextInt();
				for(int j=0; j < sectionNum;j++){
					System.out.println("enter the section (ID,day,start,end,location,CRN,credit) of course");
					//Section(String sectionID, String day, String startTime,String endTime, String location, int cRN, int credit
					Section currSec = new Section(scanner.next(),scanner.next(),scanner.next(),scanner.next(),scanner.next(),scanner.nextInt(),scanner.nextInt());
					currCourse.addSec(currSec);
				}
				list.add(currCourse);
			}
			
		
		return list;
	}
	
	public void out(ArrayList<Course> list){// test only
		for(int i=0; i<list.size();i++){
			System.out.println("\tCourse : "+list.get(i).toString());
			for(int j=0;j<list.get(i).getSec().size();j++){
				System.out.println("\t\tSession : "+list.get(i).getSec().get(j).toString());
			}
		}
	}
	
	public void out(String str){
		System.out.println(str);
	}

}
/*
 Test Case 1:
2
CS0001 TEST1 2
C01 Fri 1200 1300 LT6 12345 3
C02 Mon 1100 1200 LT8 12346 3 
CS0002 TEST2 1
C01 Fri 1200 1300 LT6 12347 3
 */
/*
CSXXXX XXXXXXXX 2
	C01 Fri 12:00 13:00 Lt6 12345 3
	C02 Mon 11:00 12:00 Lt8 12346 3
*/