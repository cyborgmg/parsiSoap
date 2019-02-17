package parsiSoap;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		System.out.println( (new ExtracCDAT()).getCdat( new FileInputStream("/tmp/arquivos_coaf/ENVIAR/coaf_file_pre_10786_ENVIAR.xml") ) );
		
	}

}
