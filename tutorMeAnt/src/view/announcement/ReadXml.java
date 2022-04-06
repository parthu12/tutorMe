/*
 * Sample seed codes to be used in CS321 at
 * The University of Alabama in Huntsville.
 * These codes may contain errors, poor implementations, or
 * incorrect implementations. The user of these codes should
 * try to correct or improve them. The codes are for instructional
 * purposes. dmr CS 321 Fall 2016
 */
package view.announcement;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * Read xml document
 *
 * @author drochowi for CS 321 Fall 2015, 2016, 2017
 */
public class ReadXml {

    /**
     * Read the data in the xml file
     *
     */
    public void readXmlFile() {
        // Hard setting of path. This should be fixed
        // TODO Create parameter for file and refactor for common code with readXmlFileToList
        // TODO Investigate strings that can be used as message content in ui
        String place = System.getProperty("user.dir") + "\\src\\"
                + "xmlFiles\\student.xml";
        System.out.println("read place = " + place);
        File xmlFile = new File(place);

        // Get the document builder
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        // When working with files you need to use try-catch to handle exceptions
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            // Should not be here in final product. Developmental convenience for the moment.
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            // Looking for students
            NodeList nodeList = doc.getElementsByTagName("Announcement");
            // Now XML is loaded as Document in memory, so convert it to a student list
            List<Announcement> studentList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Student " + getStudent(nodeList.item(i)));
                studentList.add(getStudent(nodeList.item(i)));
            }
            // Print student list information. Might be enhanced to produce a string
            // that could be used by gui for messaging the end user.
            // Developmental convenience for the moment.
            for (Announcement stu : studentList) {
                System.out.println(stu.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            // Should be changed. Developmental convenience for the moment.
            e1.printStackTrace();
        }

    }

    /**
     * Read an xml file as an <ttArrayList</tt> of students
     *
     * @return the students as an <tt>ArrayList</tt> of <tt>Student</tt>
     */
    public ArrayList<Announcement> readXmlFileToList() {
        // Hard coding issue again. Would be good to abstract the whole operation
        // so that it would be more generally usable.
        // There a good deal of code that is the same as that used in readXmlFile
        // refactoring is in order.
        // TODO Create parameter for file and refactor for common code with readXmlFile
        String place = System.getProperty("user.dir") + "\\xmlFiles\\student.xml";
        System.out.println("read place = " + place);
        File xmlFile = new File(place);

        // Set up for document builder
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        // Create the ArrayList to be returned
        ArrayList<Announcement> studentList = new ArrayList<>();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            // Might be converted to a string that could be used by user interface
            // to messsage the end user
            // TODO Investigate strings that can be used as message content in ui
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Announcement");
            System.out.println("node list"+nodeList.getLength());

            // Now that the XML is loaded as Document in memory, 
            // let's convert it to a Student list.
            // This is an issue for the DOM parser. For larger files an alternative
            // parser is required if the file size is greater than the memory avilable.
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Student is " + getStudent(nodeList.item(i)));
                studentList.add(getStudent(nodeList.item(i)));
            }

            // Return the list. This is bad style since there are two returns.
            // Fix this so that there is only one return.
            // TODO Two returns in method should be one
            return studentList;

        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
        // The other return statement
        // TODO Two returns in method should be one
        return studentList;
    }

    /**
     * Get the student for the node
     *
     * @param node as an xml node
     * @return a student as Student
     */
    private static Announcement getStudent(Node node) {
        Announcement stu = new Announcement();
        System.out.println("node.getNodeType()"+node.getNodeType());
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            stu.setCourse(getTagValue("course", element));
            stu.setAnnouncement(getTagValue("announcement", element));
            stu.setDueDate(getTagValue("duedate", element));
            stu.setContactInfo(getTagValue("contactinfo", element));
        }
        return stu;
    }

    /**
     * Get a value given the xml tag and element
     *
     * @param tag
     * @param element
     * @return value as a string
     */
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
