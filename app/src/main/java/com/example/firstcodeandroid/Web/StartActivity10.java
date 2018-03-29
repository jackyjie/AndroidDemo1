package com.example.firstcodeandroid.Web;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.firstcodeandroid.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StartActivity10 extends AppCompatActivity {

    private static final String TAG = "StartActivity10";
    private TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start10);
        responseText = (TextView)findViewById(R.id.web_text);
        Button btn = (Button)findViewById(R.id.web_btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity10.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
        Button btn2 = (Button)findViewById(R.id.web_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sendRequestWithHttpUrlConnection();
            }
        });

        Button btn3 = (Button)findViewById(R.id.okHttp);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp();
            }
        });

        Button btn4 = (Button)findViewById(R.id.xmlPull);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertXMLByPull();
            }
        });
        Button btn5 = (Button)findViewById(R.id.xmlSax);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertXMLBySax();
            }
        });
        Button btn6 = (Button)findViewById(R.id.jsonObject);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertJson();
            }
        });
        Button btn7 = (Button)findViewById(R.id.jsonGson);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertJsonWithGson();
            }
        });
    }

    private void paseJsonWithGson(String data){
        Gson gson = new Gson();
        UserJson list = gson.fromJson(data, new TypeToken<UserJson>(){}.getType());
        for(User user:list.Data){
            Log.d(TAG, "paseJsonWithGson: " + user.getUserId() + "|" + user.getUserName() );
        }
    }

    private void convertJsonWithGson(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://10.0.2.2:8101/api/user/list")
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    paseJsonWithGson(data);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    private void paseJsonWithJsonObject(String json){
        try{
            JSONObject json1 = new JSONObject(json);
            JSONArray jsonArray =json1.getJSONArray("Data");
            for(int i = 0 ;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String userId = jsonObject.getString("userId");
                String userName = jsonObject.getString("userName");

                Log.d(TAG, "paseJsonWithJsonObject: " + userId + "|" + userName);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void convertJson(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://10.0.2.2:8101/api/user/list")
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    paseJsonWithJsonObject(data);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    private void paseXMLWithSax(String data){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = factory.newSAXParser().getXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader(data)));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void convertXMLBySax(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://10.0.2.2:8101/demo.xml")
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    paseXMLWithSax(data);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    private void paseXMLWithPull(String data){
        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser  xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(data));
            int eventType = xmlPullParser.getEventType();
            String id = "";
            String name = "";
            while (eventType != xmlPullParser.END_DOCUMENT){
                String nodeName = xmlPullParser.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("d2p1:userId".equals(nodeName)){
                            id = xmlPullParser.nextText();
                        }
                        else if("d2p1:userName".equals(nodeName)){
                            name = xmlPullParser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("d2p1:t_user".equals(nodeName)){
                            Log.d(TAG, "paseXMLWithPull: "+id+"|"+name);
                        }
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void convertXMLByPull(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://10.0.2.2:8101/demo.xml")
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    paseXMLWithPull(data);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    private void sendRequestWithOkHttp(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    /*
                    * RequestBody body = new FormBody.Builder()
                    *   .add("userName", "123")
                    *   .add("password", "123")
                    *   .build();
                    *   request.post(body);
                    * */

                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://baidu.com")
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    showResponse(data);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    private void sendRequestWithHttpUrlConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    /*
                     * post
                     * connect.setRequestMethod("POST");
                     * DataOutputStream out = new DataOutputStream(connection.getOutputStream())
                     * out.writeBytes("username=admin&password=123456");
                     *  */

                    URL url = new URL("https://www.baidu.com/");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    reader =new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line=reader.readLine())!=null){

                        response.append(line);
                    }
                    showResponse(response.toString());
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {
                    if(connection!=null){
                        connection.disconnect();
                    }
                    if(reader !=null){
                        try {
                            reader.close();
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    private void showResponse(final String str){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: " + str);
                responseText.setText(str);
            }
        });
    }
}
