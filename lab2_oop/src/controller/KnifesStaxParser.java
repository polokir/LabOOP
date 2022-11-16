package controller;

import models.KnifesDesc;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class KnifesStaxParser {
    private KnifesDocHandler docHandler = new KnifesDocHandler();

    private void startElement(String localName, Attributes attrs) {
        try {
            docHandler.startElement(null, null, localName, attrs);
        } catch (SAXException e) {
            System.out.println("StAX parser: error while parsing document");
        }
    }

    private void endElement(String localName) {
        try {
            docHandler.endElement(null, null, localName);
        } catch (SAXException e) {
            System.out.println("StAX parser: error while parsing document");
        }
    }

    public List<KnifesDesc> parseDocument(String filename) {
        try {
            // get the default factory instance
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(filename));

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamReader.START_DOCUMENT:
                        System.out.println("StAX parser start...");
                        break;

                    case XMLStreamReader.END_DOCUMENT:
                        System.out.println("End of document");
                        break;

                    case XMLStreamReader.START_ELEMENT:
                        // get the list of all attributes
                        MyAttributes attrs = null;
                        if (reader.getAttributeCount() > 0) {
                            attrs = new MyAttributes();

                            for (int i = 0; i < reader.getAttributeCount(); ++i) {
                                attrs.addAttribute(reader.getAttributeLocalName(i),
                                        reader.getAttributeValue(i));
                            }
                        }
                        startElement(reader.getLocalName(), attrs);
                        break;

                    case XMLStreamReader.CHARACTERS:
                        docHandler.characters(reader.getTextCharacters(),
                                reader.getTextStart(), reader.getTextLength());
                        break;

                    case XMLStreamReader.END_ELEMENT:
                        endElement(reader.getLocalName());
                        break;

                    default:
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("StAX parser: error while parsing the document");
        }

        return docHandler.getKnifes();
    }
}


class MyAttributes implements Attributes {
    Map<String, String> attrs = new HashMap<>();

    public String addAttribute(String name, String value) {
        return attrs.put(name, value);
    }

    @Override
    public int getLength() {
        return attrs.size();
    }

    @Override
    public String getValue(String qName) {
        return attrs.get(qName);
    }


    //The next methods are not implemented!!!!
    @Override
    public int getIndex(String qName) {
        return 0;
    }

    @Override
    public int getIndex(String uri, String localName) {
        return 0;
    }

    @Override
    public String getLocalName(int index) {
        return null;
    }

    @Override
    public String getQName(int index) {
        return null;
    }

    @Override
    public String getType(int index) {
        return null;
    }

    @Override
    public String getType(String qName) {
        return null;
    }

    @Override
    public String getType(String uri, String localName) {
        return null;
    }

    @Override
    public String getURI(int index) {
        return null;
    }

    @Override
    public String getValue(int index) {
        return null;
    }

    @Override
    public String getValue(String uri, String localName) {
        return null;
    }

}