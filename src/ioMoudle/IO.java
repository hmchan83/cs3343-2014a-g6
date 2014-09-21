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
				System.out.println("enter the id,name&no. of section of course "+(i+1));
				String courseID = scanner.next();
				String courseName = scanner.next();
				Course currCourse = new Course(courseID,courseName);
				int sectionNum = scanner.nextInt();
				for(int j=0; j < sectionNum;j++){
					System.out.println("enter the section of course");
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
			System.out.println("Course : "+list.get(i).getCourseID()+" - " + list.get(i).getCourseName());
			for(int j=0;j<list.get(i).getSec().size();j++){
				System.out.println("\tSession : "+list.get(i).getSec().get(j).getCRN()+" - "+list.get(i).getSec().get(j).getSectionID());
			}
		}
	}
	
	public void out(String str){
		System.out.println(str);
	}

}
/*
CSXXXX XXXXXXXX 2
	C01 Fri 12:00 13:00 
	C02 Mon 11:00 12:00
*/