package com.qa.Serialization_Deserialization;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.xml.XmlSerializer;

// Serialization: POJO -> JSON/XML/HTML
public class Serialization {

    public static void main(String[] args) {

        String[]  sellerNames = {"Neon Enterprises","Dixit Infotech Services Pvt Ltd","iValue Systech Pvt Ltd.","Zones Corporate Solutions Pvt Ltd"};
        Product product = new Product("MacBook Pro",150000,"Space-black",sellerNames);

        // POJO -> JSON
        JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
        String json = jsonSerializer.serialize(product);
        System.out.println(json);

        // POJO -> XML
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        String xml = xmlSerializer.serialize(product);
        System.out.println(xml);

        // POJO -> HTML
        HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
        String html = htmlSerializer.serialize(product);
        System.out.println(html);


    }

}
