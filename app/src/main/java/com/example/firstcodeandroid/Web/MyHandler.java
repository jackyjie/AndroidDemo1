package com.example.firstcodeandroid.Web;

import android.media.MediaCodec;
import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JackR on 2018/3/28.
 */

public class MyHandler extends DefaultHandler {

    private String nodeName;
    private StringBuilder id;
    private StringBuilder name;
    private static final String TAG = "MyHandler";

    @Override
    public void startDocument() throws SAXException {
        id = new StringBuilder();
        name = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nodeName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if("userId".equals(nodeName)){
            id.append(ch, start, length);
        }
        else if("userName".equals(nodeName)) {
            name.append(ch, start, length);
        }
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("t_user".equals(localName)){
            Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(id);
            Matcher s = p.matcher(name);
            Log.d(TAG, "endElement: " +  m.replaceAll("") + "|" + s .replaceAll(""));
            id.setLength(0);
            name.setLength(0);
        }
    }
}
