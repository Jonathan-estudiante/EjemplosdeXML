/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo_de_leer_xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Personal
 */
public class Ejemplo_De_Leer_XML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File archivoXML = new File("C:\\Users\\Personal\\Desktop\\PROYECTO HOSTERÍA\\Ejemplo de archivo XML.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document documentoXML = builder.parse(archivoXML);
            documentoXML.getDocumentElement().normalize();
            
            System.out.println("Elemento raíz: " + documentoXML.getDocumentElement().getNodeName());
            
            NodeList FacturaElectronica = documentoXML.getElementsByTagName("Emisor");
            
            for (int i = 0; i < FacturaElectronica.getLength(); i++) {
                Node factura = FacturaElectronica.item(i);
                
                System.out.println("Nombre elemento actual: " + factura.getNodeName());
                if (factura.getNodeType()==Node.ELEMENT_NODE) {
                    Element element = (Element) factura;
                    
                    System.out.println("Nombre: " + element.getElementsByTagName("Nombre").item(0).getTextContent());
                    System.out.println("Indentificación" + "\nTipo: "+ element.getElementsByTagName("Tipo").item(0).getTextContent());
                    System.out.println("Número: "+ element.getElementsByTagName("Numero").item(0).getTextContent());
                    System.out.println("Ubicación" + "\nProvincia: "+ element.getElementsByTagName("Provincia").item(0).getTextContent());
                    System.out.println("Canton: "+ element.getElementsByTagName("Canton").item(0).getTextContent());
                    System.out.println("Barrio: "+ element.getElementsByTagName("Barrio").item(0).getTextContent());
                    System.out.println("Teléfono" + "\nCodigo del País: "+ element.getElementsByTagName("CodigoPais").item(0).getTextContent());
                    System.out.println("Número de Teléfono: "+ element.getElementsByTagName("NumTelefono").item(0).getTextContent());
                    System.out.println("Correo Electrónico: "+ element.getElementsByTagName("CorreoElectronico").item(0).getTextContent());

                }
            }
        } catch (IOException|ParserConfigurationException|SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
