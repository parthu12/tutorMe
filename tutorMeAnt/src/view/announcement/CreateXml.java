/*
 * Sample seed codes to be used in CS321 at
 * The University of Alabama in Huntsville.
 * These codes may contain errors, poor implementations, or
 * incorrect implementations. The user of these codes should
 * try to correct or improve them. The codes are for instructional
 * purposes. dmr CS 321 Fall 2016
 */
package view.announcement;

/**
 * Create an xml document. The xml file provides long term storage of data,
 * other wise called persistence. This allows changes in one session to persist
 * into the next section. This class creates an appropriate xml file.
 *
 * @author drochowi for CS 321 Fall 2015, 2016, 2017
 */

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * The class creates xml files to store data between sessions.
 *
 * @author drochowi for CS 321 Fall 2015, 2016, 2017
 */
public class CreateXml {

    /**
     * Create an xml file of students with some initial students. This gathering
     * of students should be separated from this class since this class should
     * only be responsible for creating the storage file.
     *
     */
    public void createXML() {
        // This should be improved. There is duplicated code with writeStudentsToXml.
        // Refactoring would help. The file is almost hard coded and the methods should
        // be refactored to use a parameter.
        // TODO Provide a parameter for the file and refactor into common methods with writeStudentsToXml
        try {
            // Need to use try-catch when working with files.
            // See docs for more information
            // Set up the document builder
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentFactory
                    .newDocumentBuilder();

            // Define root elements for the document
            Document document = documentBuilder.newDocument();
            // Note the hard coding that starts here
            Element rootElement = document.createElement("school");
            document.appendChild(rootElement);

            // Add the data. This is hard coded should be fixed.
            rootElement.appendChild(getStudent(document, "1", "Dan", "Roch", "ddr@this.com", "3412344"));
            rootElement.appendChild(getStudent(document, "2", "Joe", "desJ", "dj@this.com", "1213434"));
            rootElement.appendChild(getStudent(document, "3", "bob", "carguy", "cg@this.com", "9999434"));
            // Creating and writing to xml file. Note the location of the file.
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            // This should not be here, but it does provide a bit of help while developing.
            // Note this is using a String and not a File object so quoting '\' with '\' is required
            // Note also that this uses the user's currently running directory 
            // rather than the user's home directory. Problems abound. Note that
            // properties or preferences might help.
            String place = System.getProperty("user.dir") + "\\xmlFiles\\student.xml";
            System.out.println("place = " + place);

            //Send the xml document to the file
            File filePlace = new File(place);
            StreamResult streamResult = new StreamResult(filePlace);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, streamResult);

            // This should not be here but it does provide a bit of help while developing.      
            System.out.println("File saved to specified path!");

        } catch (ParserConfigurationException | TransformerException pce) {
            // Rather unhelful but ok for the moment.
            pce.printStackTrace();
        }
    }

    /**
     * Write a list of students to the xml file. This is another place that
     * needs work. There are two things being done in this class: creating the
     * xml file and populating it with initial data. Many believe that a class
     * should have only one purpose. Many more believe that a method should have
     * only one purpose.
     *
     * @param students as an <tt>ArrayList</tt> of <tt>Student</tt>
     */
    public void writeStudentsToXml(ArrayList<Announcement> students) {
        // This should be improved. There is duplicated code.
        // Refactoring would help. The file is hard coded and the method should
        // be refactored to use a parameter.
        // TODO Provide a parameter for the file and refactor into commonly with createXml
        try {
            // Set up the document builder
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentFactory
                    .newDocumentBuilder();

            // Define root elements
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("school");
            document.appendChild(rootElement);
            // need to generate an id
            int id = 1;

            // Count blank fields. If it is four, then don't write. Why?
            int blanks = 0;

            // Loop through the student list 
            for (Announcement stu : students) {
                // Check to make sure that the blank element of the list 
                // is not processed. This only checks the first name,
                // so if there is no first name but there is other data
                // the record is not copied.
                // TODO CreateXml fix this next about blank fields
                if (stu.getCourse().trim().isEmpty() || stu.getCourse().trim().equals(" ")) {
                    stu.setCourse("*");
                    blanks++;
                }
                if (stu.getAnnouncement().trim().isEmpty() || stu.getAnnouncement().trim().equals(" ")) {
                    stu.setAnnouncement("*");
                    blanks++;
                }
                if (stu.getDueDate().trim().isEmpty() || stu.getDueDate().trim().equals(" ")) {
                    stu.setDueDate("*");
                    blanks++;
                }
                if (stu.getContactInfo().trim().isEmpty() || stu.getContactInfo().trim().equals(" ")) {
                    stu.setContactInfo("*");
                    blanks++;
                }
                // If all of the fileds are not blank, then write
                if (blanks < 4) {
                    rootElement.appendChild(getStudent(document, Integer.toString(id), stu.getCourse(),
                            stu.getAnnouncement(), stu.getDueDate(), stu.getContactInfo()));
                    id++;
                }
            }

            // Creating and writing to xml file
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "html");
            DOMSource domSource = new DOMSource(document);

            // Change this so that it will send back information to the user
            // interface about the location of the file rather than sending
            // to the console. Separation of model, view and control is
            // important. Also note that you might want to use a log file
            // while developing the implementation.
            String place = System.getProperty("user.dir") + "\\xmlFiles\\student.xml";
            System.out.println("place = " + place);
            // Make a file
            File filePlace = new File(place);
            // Make a stream result for output
            StreamResult streamResult = new StreamResult(filePlace);
            // Use indentation in the file
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // Transform to xml and write
            System.out.println("source " + domSource + " StreamResult " + streamResult);
            transformer.transform(domSource, streamResult);
            // Change this so that it will send back information to the 
            // user interface about the success of the save
            System.out.println("File saved to specified path!");

        } catch (ParserConfigurationException | TransformerException pce) {
            // Again this is not the most helpful thing but it will do for now.
            pce.printStackTrace();
        }
    }

    /**
     * Create a student xml node element. Is this an odd name for the method?
     *
     * @param doc the xml as a <tt>Document</tt>
     * @param id the generated id as a <tt>String</tt>
     * @param firstname the first name as a <tt>String</tt>
     * @param lastname the last name as a <tt>String</tt>
     * @param email the email address as a <tt>String</tt> with no validation
     * @param phone the phone number as a <tt>String</tt> with no validation
     * @return an xml node element
     */
    private static Node getStudent(Document doc, String id, String firstname,
            String lastname, String email, String phone) {
        Element student = doc.createElement("Announcement");

        // Set id attribute
        student.setAttribute("id", id);

        // Create firstname element
        student.appendChild(getStudentElements(doc, student, "course", firstname));

        // Create lastname element
        student.appendChild(getStudentElements(doc, student, "announcement", lastname));

        // Create email element
        student.appendChild(getStudentElements(doc, student, "duedate", email));

        // Create phone element
        student.appendChild(getStudentElements(doc, student, "contactinfo", phone));

        return student;
    }

    /**
     * Get the student elements to be appended and return an xml node
     *
     * @param doc the xml document as <tt>Document</tt>
     * @param element the element to be used as the node as <tt>Element</tt>
     * @param name the <tt>String</tt> for the name of the element
     * @param value the <tt>String</tt> for the value to append
     * @return a xml node of type <tt>Node</tt>
     */
    private static Node getStudentElements(Document doc, Element element,
            String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
