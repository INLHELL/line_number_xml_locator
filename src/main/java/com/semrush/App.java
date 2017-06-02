package com.semrush;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException {
        System.out.println( "Hello World!" );


        File f = new File("src/main/resources/instance.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class );

        Customer c = (Customer) jaxbContext.createUnmarshaller().unmarshal(f);

        System.out.println(c);
    }
}
