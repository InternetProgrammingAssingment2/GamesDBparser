import java.net.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;


public class GetGames {

	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 10000 ; i++) {
			Document xml = GetXML(i);
			
			if(GameExist(xml)){
				
				NodeList nl = xml.getElementsByTagName("*");
				Node n;
				for (int k = 0; k < nl.getLength(); k++) {

					n = nl.item(k);
					PrintFile(n);

				}				
				
				
			}
			
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println();
			
			
		}
				

	}
	
	private static Document GetXML(int id) throws Exception   {		
		
		URL url = new URL("http://thegamesdb.net/api/GetGame.php?id=" + id);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.addRequestProperty("User-Agent", "Mozilla/4.76");
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(conn.getInputStream());

		return doc;
		
	}
	
	private static Boolean GameExist(Document doc) {
		NodeList nl = doc.getElementsByTagName("*");
		
		if(nl.getLength() > 2 || nl.item(0).getNodeName() == "Error")
			return true;
		else 
			return false;		
			
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
						System.out.println("Platform: \""
								+ child.getNodeValue() + "\"");
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
						System.out.println("Release Date: \""
								+ child.getNodeValue() + "\"");
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
						System.out.println("Overview: \""
								+ child.getNodeValue() + "\"");
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
						System.out.println("No of Players: \""
								+ child.getNodeValue() + "\"");
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
						System.out.println("Youtube Link: \""
								+ child.getNodeValue() + "\"");
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
						System.out.println("Publisher: \""
								+ child.getNodeValue() + "\"");
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
						System.out.println("Developer: \""
								+ child.getNodeValue() + "\"");
					}
				}
			}

			break;
		}

	}
	

}
