/**
 * 
 */


import java.net.*;
import java.util.Date;
import java.util.Set;

import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * @author Rajitha Hasith
 * 
 */
public class XMLParser {

	static long ID;
	static String Title;
	Set<String> Platforms;
	Date RealeaseDate;
	Set<String> Genres;
	int PlayersNo;
	String CoOP;
	URL YoutubeLink;
	String Publisher;
	String Developer;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		URL url = new URL("http://thegamesdb.net/api/GetGame.php?id=1");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.addRequestProperty("User-Agent", "Mozilla/4.76");

	/*	XMLInputFactory xmlif = null;
		try {
			xmlif = XMLInputFactory.newInstance();
			xmlif.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES,
					Boolean.TRUE);
			xmlif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,
					Boolean.FALSE);
			// set the IS_COALESCING property to true , if application desires
			// to
			// get whole text data as one event.
			xmlif.setProperty(XMLInputFactory.IS_COALESCING, Boolean.FALSE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}*/


		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(conn.getInputStream());

		NodeList nl = doc.getElementsByTagName("*");
		Node n;

		for (int i = 0; i < nl.getLength(); i++) {
			n = nl.item(i);
			PrintFile(n);

		}
	}

	public static void PrintFile(Node node) {

		Node child;
		int nType = node.getNodeType();
		switch (nType) {
		case Node.ELEMENT_NODE:

			if (node.getNodeName() == "id") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("ID: \"" + child.getNodeValue()
								+ "\"");
					}
				}

			}

			if (node.getNodeName() == "GameTitle") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("Title: \"" + child.getNodeValue()
								+ "\"");
					}
				}
				
			}
			
			
			if (node.getNodeName() == "Platform") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("Platform: \"" + child.getNodeValue()
								+ "\"");
					}
				}
				
			}
			
			if (node.getNodeName() == "ReleaseDate") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("Release Date: \"" + child.getNodeValue()
								+ "\"");
					}
				}				
			}
			
			if (node.getNodeName() == "Overview") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("Overview: \"" + child.getNodeValue()
								+ "\"");
					}
				}				
			}
			
			if (node.getNodeName() == "genre") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("genre: \"" + child.getNodeValue()
								+ "\"");
					}
				}				
			}
			
			if (node.getNodeName() == "Players") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("No of Players: \"" + child.getNodeValue()
								+ "\"");
					}
				}				
			}
			
			if (node.getNodeName() == "Co-op") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("Co-op: \"" + child.getNodeValue()
								+ "\"");
					}
				}				
			}
			
			if (node.getNodeName() == "Youtube") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("Youtube Link: \"" + child.getNodeValue()
								+ "\"");
					}
				}				
			}
			
			if (node.getNodeName() == "Publisher") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("Publisher: \"" + child.getNodeValue()
								+ "\"");
					}
				}				
			}
			
			if (node.getNodeName() == "Developer") {
				child = node.getFirstChild();

				String val = child.getNodeValue();
				if (val != null) {
					if (val.trim().equals("")) {
						// Whitespace
						System.out.print("[WS]");
					} else {
						System.out.println("Developer: \"" + child.getNodeValue()
								+ "\"");
					}
				}				
			}
			
			
			break;
		}

	}

}
