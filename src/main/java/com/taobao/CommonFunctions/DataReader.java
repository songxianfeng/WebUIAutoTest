package com.taobao.CommonFunctions;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DataReader {   
	/*
	 * Xml文件读取操作
	 */
    public String readnodevalue(Document doc,String firsttag,String secondtag)
    {
        /**
         * 读取xml文件中节点的值
         * @param doc:xml对应该的Document对象
         * @param firsttag:一级节点对象
         * @param secondtag:二级节点对象
         */
       String result="";
       Element root=doc.getDocumentElement();
       NodeList childnode = root.getElementsByTagName(firsttag);
       NodeList resnode=childnode.item(0).getChildNodes();
       for(int i=0;i<resnode.getLength();i++)
       {
           if(resnode.item(i).getNodeName().equals(secondtag))
           {
              result=resnode.item(i).getTextContent();
              break;
           }
       }
       return result;
    }

}
