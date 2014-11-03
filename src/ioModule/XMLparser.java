package ioModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import store.Course;
import store.Section;

public class XMLparser {
	
	public XMLparser() {};
	
	public ArrayList<Course> parseXML(String filePath) {
		
		try {
			File inXML = new File (filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inXML);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("course");

			ArrayList<Course> CourseList = new ArrayList<>();

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);	    		

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					String courseid = eElement.getElementsByTagName("courseid").item(0).getTextContent();
					String coursename = eElement.getElementsByTagName("coursename").item(0).getTextContent();
					Boolean isCore = Boolean.parseBoolean(eElement.getElementsByTagName("core").item(0).getTextContent());
					Course newCourse = new Course();
					newCourse.setCourseID(courseid);
					newCourse.setCourseName(coursename);
					newCourse.setIsCore(isCore);
					CourseList.add(newCourse);

					NodeList secList = eElement.getElementsByTagName("section");

					for (int i = 0; i < secList.getLength(); i++) {

						Node secNode = secList.item(i);

						if (secNode.getNodeType() == Node.ELEMENT_NODE) {

							Element secElement = (Element) secNode;

							String crn = secElement.getElementsByTagName("crn").item(0).getTextContent();
							String sectionid = secElement.getElementsByTagName("sectionid").item(0).getTextContent();
							int credit = Integer.parseInt(secElement.getElementsByTagName("credit").item(0).getTextContent());
							String day = secElement.getElementsByTagName("day").item(0).getTextContent();
							String startTime = secElement.getElementsByTagName("startTime").item(0).getTextContent();
							String endTime = secElement.getElementsByTagName("endTime").item(0).getTextContent();
							String building = secElement.getElementsByTagName("building").item(0).getTextContent();
							String room = secElement.getElementsByTagName("room").item(0).getTextContent();

							Section newSection = new Section(sectionid, day, startTime, endTime, building, room, crn, credit);
							CourseList.get(temp).addSec(newSection);

						}
					}
				}
			}
			return CourseList;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ArrayList<Course>();
		} catch (DOMException e) {
			e.printStackTrace();
			return new ArrayList<Course>();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return new ArrayList<Course>();
		} catch (SAXException e) {
			e.printStackTrace();
			return new ArrayList<Course>();
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<Course>();
		}
	}
	
}
