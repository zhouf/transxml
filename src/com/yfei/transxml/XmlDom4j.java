package com.yfei.transxml;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XmlDom4j {

	public static void main(String[] args) {
		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read("d:/temp/sysinfo.xml");
			List list = document.selectNodes("//xml/sysInfo");
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Attribute attribute = (Attribute) iter.next();
				System.out.println("XmlDom4j.main()->attribute.getText():" + attribute.getText());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
