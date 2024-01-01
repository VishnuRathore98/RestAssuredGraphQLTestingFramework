package com.qa.Serialization_Deserialization;


import org.apache.juneau.html.HtmlParser;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.xml.XmlParser;

// Deserialization: JSON/XML/HTML -> POJO
public class Deserialization {
    public static void main(String[] args) {

        // JSON -> POJO
        JsonParser jsonParser = JsonParser.DEFAULT;
        Product product1 = jsonParser.parse(Deserialization.json,Product.class);
        System.out.println("Parsing JSON to POJO:");
        System.out.println("-> "+product1);

        // XML -> POJO
        XmlParser xmlParser = XmlParser.DEFAULT;
        Product product2 = xmlParser.parse(Deserialization.xml, Product.class);
        System.out.println("\nParsing XML to POJO:");
        System.out.println("-> "+product2);

        // HTML -> POJO
        HtmlParser htmlParser = HtmlParser.DEFAULT;
        Product product3 = htmlParser.parse(Deserialization.xml, Product.class);
        System.out.println("\nParsing HTML to POJO:");
        System.out.println("-> "+product3+"\n");

    }

      static String json = "{\n" +
            "\t\"color\": \"Space-black\",\n" +
            "\t\"name\": \"MacBook Pro\",\n" +
            "\t\"price\": 150000,\n" +
            "\t\"sellerNames\": [\n" +
            "\t\t\"Neon Enterprises\",\n" +
            "\t\t\"Dixit Infotech Services Pvt Ltd\",\n" +
            "\t\t\"iValue Systech Pvt Ltd.\",\n" +
            "\t\t\"Zones Corporate Solutions Pvt Ltd\"\n" +
            "\t]\n" +
            "}";

       static String xml = "<object>\n" +
            "\t<color>Space-black</color>\n" +
            "\t<name>MacBook Pro</name>\n" +
            "\t<price>150000</price>\n" +
            "\t<sellerNames>\n" +
            "\t\t<string>Neon Enterprises</string>\n" +
            "\t\t<string>Dixit Infotech Services Pvt Ltd</string>\n" +
            "\t\t<string>iValue Systech Pvt Ltd.</string>\n" +
            "\t\t<string>Zones Corporate Solutions Pvt Ltd</string>\n" +
            "\t</sellerNames>\n" +
            "</object>\n";

       static String html = "<table>\n" +
            "\t<tr>\n" +
            "\t\t<td>color</td>\n" +
            "\t\t<td>Space-black</td>\n" +
            "\t</tr>\n" +
            "\t<tr>\n" +
            "\t\t<td>name</td>\n" +
            "\t\t<td>MacBook Pro</td>\n" +
            "\t</tr>\n" +
            "\t<tr>\n" +
            "\t\t<td>price</td>\n" +
            "\t\t<td>150000</td>\n" +
            "\t</tr>\n" +
            "\t<tr>\n" +
            "\t\t<td>sellerNames</td>\n" +
            "\t\t<td>\n" +
            "\t\t\t<ul>\n" +
            "\t\t\t\t<li>Neon Enterprises</li>\n" +
            "\t\t\t\t<li>Dixit Infotech Services Pvt Ltd</li>\n" +
            "\t\t\t\t<li>iValue Systech Pvt Ltd.</li>\n" +
            "\t\t\t\t<li>Zones Corporate Solutions Pvt Ltd</li>\n" +
            "\t\t\t</ul>\n" +
            "\t\t</td>\n" +
            "\t</tr>\n" +
            "</table>\n";

}
