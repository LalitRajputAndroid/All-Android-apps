package com.example.saxparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview_id);

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){

                boolean name = false;
                boolean roll_no = false;
                boolean age = false;


                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("name")){
                        name = true;
                    }
                    if (qName.equalsIgnoreCase("rollno")){
                        roll_no = true;
                    }
                    if (qName.equalsIgnoreCase("age")){
                        age = true;
                    }

                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {

                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (name) {

                        textView.setText(textView.getText()+"\nName: "+new String(ch,start,length));
                        name=false;
                    }
                    if (roll_no){

                        textView.setText(textView.getText()+"\nRoll.No : "+new String(ch,start,length));
                        roll_no = false;

                    }
                    if (age){

                        textView.setText(textView.getText()+"\nAge : "+new String(ch,start,length)+"\n");
                        age = false;
                    }
                }
            };
            InputStream stream = getAssets().open("file.xml");
            saxParser.parse(stream,handler);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}