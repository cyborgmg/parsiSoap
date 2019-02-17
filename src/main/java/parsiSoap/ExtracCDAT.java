package parsiSoap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ExtracCDAT {
	
	private String xml="";

	
	private void findCdata(NodeList nodeList ) {

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node.getNodeName().contains("cdata-section")) {
				this.xml = node.getNodeValue();
			}else {
				findCdata(node.getChildNodes());
			}
		}
		
	}
	
	public String getCdat(InputStream inputStream) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse( inputStream );

	    this.findCdata(document.getDocumentElement().getChildNodes());
	    

	    return xml;
		
	}

}
