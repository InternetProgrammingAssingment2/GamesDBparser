/**
 * 
 */

import java.awt.List;
import java.io.*;
import java.net.*;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.SAXException;


/**
 * @author Rajitha Hasith
 *
 */
public class TestParser {
	
	long ID;
	String Title;
	Set<String> Platforms;
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		URL url = new URL("http://thegamesdb.net/api/GetGame.php?id=2");
		URLConnection conn = url.openConnection();
		
		XMLInputFactory xmlif = null ;
        try{
            xmlif = XMLInputFactory.newInstance();
            xmlif.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES,Boolean.TRUE);
            xmlif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,Boolean.FALSE);
            //set the IS_COALESCING property to true , if application desires to
            //get whole text data as one event.            
            xmlif.setProperty(XMLInputFactory.IS_COALESCING , Boolean.FALSE);
        }catch(Exception ex){
            ex.printStackTrace();
        }       
		
		
		
		//pass the file name.. all relative entity refernces will be resolved against this as
        //base URI.                                                
        XMLStreamReader xmlr = xmlif.createXMLStreamReader(conn.getInputStream());
        //when XMLStreamReader is created, it is positioned at START_DOCUMENT event.
        int eventType = xmlr.getEventType();
        //printEventType(eventType);
        printStartDocument(xmlr);
        //check if there are more events in the input stream
        while(xmlr.hasNext()){
            eventType = xmlr.next();                   
            //printEventType(eventType);

            //these functions prints the information about the particular event by calling relevant function
             printStartElement(xmlr);                    
             printEndElement(xmlr);                    
             printText(xmlr);                    
             printPIData(xmlr);
             printComment(xmlr);
        }

	}
        
        
        
        /*private static void printEventType(int eventType) {        
            System.out.println("EVENT TYPE("+eventType+") = " + getEventTypeString(eventType));
        }*/
        
        private static void printStartDocument(XMLStreamReader xmlr){
            if(xmlr.START_DOCUMENT == xmlr.getEventType()){
                System.out.println("<?xml version=\"" + xmlr.getVersion() + "\"" + " encoding=\"" + xmlr.getCharacterEncodingScheme() + "\"" + "?>");
            }
        }
        
        private static void printComment(XMLStreamReader xmlr){
            if(xmlr.getEventType() == xmlr.COMMENT){
                System.out.print("<!--" + xmlr.getText() + "-->");
            }
        }
                
        private static void printText(XMLStreamReader xmlr){
            if(xmlr.hasText()){
                System.out.print(xmlr.getText());
            }
        }
        
        private static void printPIData(XMLStreamReader xmlr){
            if (xmlr.getEventType() == XMLEvent.PROCESSING_INSTRUCTION){
                System.out.print("<?" + xmlr.getPITarget() + " " + xmlr.getPIData() + "?>") ;
            }
        }
        
        private static void printStartElement(XMLStreamReader xmlr){
            if(xmlr.isStartElement()){
                System.out.print("<" + xmlr.getName().toString());
                printAttributes(xmlr);
                System.out.print(">");
            }
        }
        
        private static void printEndElement(XMLStreamReader xmlr){
            if(xmlr.isEndElement()){
                System.out.print("</" + xmlr.getName().toString() + ">");
            }
        }
        
        private static void printAttributes(XMLStreamReader xmlr){
            int count = xmlr.getAttributeCount() ;
            if(count > 0){
                for(int i = 0 ; i < count ; i++) {
                    System.out.print(" ");
                    System.out.print(xmlr.getAttributeName(i).toString());
                    System.out.print("=");
                    System.out.print("\"");
                    System.out.print(xmlr.getAttributeValue(i));
                    System.out.print("\"");
                }            
            }
            
            count = xmlr.getNamespaceCount();
            if(count > 0){
                for(int i = 0 ; i < count ; i++) {
                    System.out.print(" ");
                    System.out.print("xmlns");
                    if(xmlr.getNamespacePrefix(i) != null ){
                        System.out.print(":" + xmlr.getNamespacePrefix(i));
                    }                
                    System.out.print("=");
                    System.out.print("\"");
                    System.out.print(xmlr.getNamespaceURI(i));
                    System.out.print("\"");
                }            
            }
        }

}
