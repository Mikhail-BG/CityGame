package by.htp.cityname.logic;

import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.cityname.entity.CitySet;

public class XMLReader {
	
	public XMLReader(CitySet cities){
		readerXML(cities);
	}
	
	public void readerXML(CitySet cities){
		try {
			org.xml.sax.XMLReader reader = XMLReaderFactory.createXMLReader();
			InputSource source = new InputSource("files/rocid.xml");
			XMLSAXHandler handler = new XMLSAXHandler(cities);
			reader.setContentHandler(handler);
			
			try {
				reader.parse(source);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
