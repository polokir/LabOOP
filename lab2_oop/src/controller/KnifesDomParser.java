package controller;

import models.KnifesDesc;
import models.KnifesDesc.KnifeVisual.KnifeBlade;
import models.KnifesDesc.KnifeVisual.KnifeHandle;
import models.KnifesDesc.KnifeVisual.KnifeHandle.Wood;
import models.MetalType;
import models.WoodType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class KnifesDomParser {


    public Document getDocument(String filename) throws
            ParserConfigurationException, IOException, SAXException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File(filename));

        return doc;
    }


    public List<KnifesDesc> parseDocument(String filename) {
        List<KnifesDesc> knifes = new ArrayList<>();
        KnifesDesc knife = null;
        Node currentNode = null;

        try {
            Document doc = getDocument(filename);
            NodeList records = doc.getDocumentElement().getElementsByTagName("knife");

            for (int i = 0; i < records.getLength(); ++i) {
                currentNode = records.item(i);

                // create new knife instance
                knife = new KnifesDesc();

                // get name
                knife.setName(((Element) currentNode).getAttribute("name"));

                // get child tags
                NodeList children = currentNode.getChildNodes();

                for (int j = 0; j < children.getLength(); ++j) {
                    Node node = children.item(j);

                    if (node instanceof Element) {
                        switch (node.getNodeName()) {
                            case "knifeType":
                                knife.setKnifeType(node.getTextContent());
                                break;

                            case "knifeHandy":
                                knife.setKnifeHandy(Integer.parseInt(node.getTextContent()));
                                break;

                            case "knifeOrigin":
                                knife.setKnifeOrigin(node.getTextContent());
                                break;

                            case "knifeVisual":
                                knife.setKnifeVisual(new KnifesDesc.KnifeVisual());
                                NodeList visualAttrs = node.getChildNodes();
                                for (int k = 0; k < visualAttrs.getLength(); ++k) {
                                    Node visualNode = visualAttrs.item(k);

                                    if (visualNode instanceof Element) {
                                        switch (visualNode.getNodeName()) {

                                            case "knifeBlade":

                                                KnifeBlade blade = new KnifeBlade();

                                                blade.setLength(new BigInteger(((Element) visualNode).getAttribute("length")));
                                                blade.setWidth(new BigInteger(((Element) visualNode).getAttribute("width")));
                                                blade.setMetal(MetalType.fromValue(((Element) visualNode).getAttribute("metal")));
                                                knife.getKnifeVisual().setKnifeBlade(blade);
                                                break;

                                            case "knifeHandle":
                                                knife.getKnifeVisual().setKnifeHandle(new KnifeHandle());

                                                // check wood
                                                NodeList woodNode = ((Element) visualNode).getElementsByTagName("wood");

                                                if (woodNode.getLength() > 0) {
                                                    Wood wood = new Wood();
                                                    wood.setType(WoodType.fromValue(((Element) woodNode.item(0)).getAttribute("type")));
                                                    knife.getKnifeVisual().getKnifeHandle().setWood(wood);
                                                    break;
                                                }

                                                // check leatherCoated
                                                if (((Element) visualNode).getElementsByTagName("leatherCoated").getLength() > 0) {
                                                    knife.getKnifeVisual().getKnifeHandle().setLeatherCoated(new Object());
                                                    break;
                                                }

                                                // check plastic
                                                if (((Element) visualNode).getElementsByTagName("plastic").getLength() > 0) {
                                                    knife.getKnifeVisual().getKnifeHandle().setPlastic(new Object());
                                                    break;
                                                }

                                            default:
                                                knife = null;
                                                throw new IllegalArgumentException();
                                        }
                                    }
                                }

                                break;


                            case "collection":
                                knife.setCollection(Boolean.parseBoolean(node.getTextContent()));
                                break;

                            default:
                                knife = null;
                                throw new IllegalArgumentException();
                        }
                    }
                }

                knifes.add(knife);
            }

        } catch (Exception e) {
            System.out.println("DOM parser: error while parsing document");
        }

        return knifes;
    }
}