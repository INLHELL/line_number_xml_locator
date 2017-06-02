package com.semrush;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException, IOException, SAXException {
        System.out.println( "Hello World!" );


        File f = new File("src/main/resources/instance.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class );

        Customer c = (Customer) jaxbContext.createUnmarshaller().unmarshal(f);

        System.out.println(c);


        byte[] xmlString = Files.readAllBytes(Paths.get(f.getPath()));
        InputStream is = new ByteArrayInputStream(xmlString);
        Document doc = PositionalXMLReader.readXML(is);
        is.close();


        Node node = doc.getElementsByTagName("name").item(0);
        System.out.println(node.getTextContent());
        System.out.println("Line number: " + node.getUserData("lineNumber"));
    }
}
