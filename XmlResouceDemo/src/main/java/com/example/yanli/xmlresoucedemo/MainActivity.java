package com.example.yanli.xmlresoucedemo;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.annotation.XmlRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends Activity {
    Button bn;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn = (Button) findViewById(R.id.bn);
        show = (TextView) findViewById(R.id.show);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               XmlResourceParser xrp =  getResources().getXml(R.xml.books);

                try {
                    StringBuilder sb = new StringBuilder("");
                    while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT){
                        if(xrp.getEventType() == XmlResourceParser.START_TAG) {
                            String tagName = xrp.getName();
                            if (tagName.equals("book") ) {
                                String price = xrp.getAttributeValue(null, "price");
                                sb.append("Price is: " + price);
                                String publishDate = xrp.getAttributeValue(1);
                                sb.append("Publish date is: " + publishDate);
                                String bookName = xrp.nextText();
                                sb.append("Book name  is: " + bookName);

                            }sb.append("\n");

                        } xrp.next();
                    }
                        show.setText(sb.toString());
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
