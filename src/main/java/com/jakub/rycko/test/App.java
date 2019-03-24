package com.jakub.rycko.test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bname = false;
                boolean bsurname = false;
                boolean bage = false;
                boolean bcity = false;
                boolean bphone = false;
                boolean bemail = false;
                boolean bicq = false;
                boolean bjabber = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {



                    if (qName.equalsIgnoreCase("name")){
                        bname = true;
                    }

                    if (qName.equalsIgnoreCase("surname")){
                        bsurname = true;
                    }

                    if (qName.equalsIgnoreCase("age")){
                        bage = true;
                    }

                    if (qName.equalsIgnoreCase("city")){
                        bcity = true;
                    }

                    if (qName.equalsIgnoreCase("phone")){
                        bphone = true;
                    }

                    if (qName.equalsIgnoreCase("email")){
                        bemail = true;
                    }

                    if (qName.equalsIgnoreCase("Icq")){
                        bicq = true;
                    }

                    if (qName.equalsIgnoreCase("jabber")){
                        bjabber = true;
                    }

                }

                public void endElement(String uri, String localName, String qName) throws SAXException {


                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bname) {
                        System.out.println("\n" + "Name: " + new String(ch, start, length));
                        bname = false;
                    }

                    if (bsurname) {
                        System.out.println("Surname: " + new String(ch, start, length));
                        bsurname = false;
                    }

                    if (bage) {
                        System.out.println("Age: " + new String(ch, start, length));
                        bage = false;
                    }

                    if (bcity) {
                        System.out.println("City: " + new String(ch, start, length));
                        bcity = false;
                    }

                    if (bphone) {
                        System.out.println("Phone: " + new String(ch, start, length));
                        bphone = false;
                    }

                    if (bemail) {
                        System.out.println("Email: " + new String(ch, start, length));
                        bemail = false;
                    }

                    if (bicq) {
                        System.out.println("ICQ: " + new String(ch, start, length));
                        bicq = false;
                    }

                    if (bjabber) {
                        System.out.println("Jabber: " + new String(ch, start, length));
                        bjabber = false;
                    }
                }
            };

            saxParser.parse("c:\\dane-osoby.xml", handler);

        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
}
