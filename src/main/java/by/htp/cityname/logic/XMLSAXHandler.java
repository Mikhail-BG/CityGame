package by.htp.cityname.logic;

import java.util.HashSet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.cityname.entity.City;

public class XMLSAXHandler extends DefaultHandler {
	
	private String strThisElement;
	HashSet<City> cities = new HashSet<City>();
	
	public XMLSAXHandler(HashSet<City> cities){
		this.cities = cities;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		strThisElement = qName;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (strThisElement.equals("name")){
			City city = new City(new String(ch,start,length).toUpperCase());
			cities.add(city);
		}
	}
}
