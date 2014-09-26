import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class RegEx {

	public static void main(String[] args) {

		try {
			File inXML = new File ("courses.xml");
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
					Course newCourse = new Course();
					CourseList.add(newCourse);
					CourseList.get(temp).setCourseIDandCourseName(courseid, coursename);

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
							CourseList.get(temp).addSection(newSection);

						}
					}
				}
			}

			for (int j=0;j<CourseList.size()-1;j++) {
				System.out.println(CourseList.get(j).getCourseID());
				for (int k=0;k<CourseList.get(j).getSec().size();k++) {
					System.out.println(((Section) CourseList.get(j).getSec().get(k)).getSectionID());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
