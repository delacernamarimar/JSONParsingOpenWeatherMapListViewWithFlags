package com.example.weatherjson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ListView lv;	
	ArrayList<Weather>list=new ArrayList<Weather>();
	MyAdapter adapter;
	private BufferedReader reader;
	int pic;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lv=(ListView) this.findViewById(R.id.listView1);
        //for api level 9+
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().build();
	    //StrictMode.setThreadPolicy(policy);
	    
        //dynamically getData from openweather
        getData("philippines");
        getData("china");
        getData("iraq");
        getData("japan");
        getData("libya");
        getData("afghanistan");
        getData("southkorea");
        getData("taiwan");
        getData("thailand");
	    
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void getData(String count){
    	//connect and get data from the site
	      DefaultHttpClient   httpclient = new DefaultHttpClient(new BasicHttpParams());
	      HttpPost httppost = new HttpPost("http://api.openweathermap.org/data/2.5/weather?q="+count+",uk&appid=44db6a862fba0b067b1930da0d769e98");
	      InputStream inputStream = null;
	      String result = null;
	      try {
	          HttpResponse response = httpclient.execute(httppost);           
	          HttpEntity entity = response.getEntity();
	          inputStream = entity.getContent();
	          reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
	          StringBuilder sb = new StringBuilder();
	          String line = null;
	          while ((line = reader.readLine()) != null)
	          {
	              sb.append(line + "\n");
	          }
	          result = sb.toString();
	       
	      } catch (Exception e) { 
	          // Oops
	      }
	      finally {
	          try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
	      }
	      
	      
	      try {
	    	  //get non array JSONObject
	    	  JSONObject json = new JSONObject(result);
	    	  JSONObject json1 = json.getJSONObject("coord");
	    	  double lon = Double.parseDouble(json1.getString("lon"));
	    	  double lat = Double.parseDouble(json1.getString("lat"));
	    	  JSONObject json2 = json.getJSONObject("sys");
	    	  String country = json2.getString("country");
	    	  String name = json.getString("name");	  
	    	  JSONObject json3 = json.getJSONObject("main");
	    	  double temp = Double.parseDouble(json3.getString("temp"));
	    	 
	    	  
	    	  
	    
	    	//lon lat temp capital country pic
	   
	    	
	    	  
	    	  if(count.equals("philippines")){	    	      
	    	    	  pic = R.drawable.philippines;}
	    	  else{ if(count.equals("afghanistan"))	    	   
	    	    	  pic = R.drawable.afghanistan;
	    	  else if(count.equals("china"))	    	    
	    	    	  pic = R.drawable.china;
	    	  else if(count.equals("iraq")) 	
	    	    	  pic = R.drawable.iraq;
	    	  else if(count.equals("japan")) 
	    	    	  pic = R.drawable.japan;
	    	  else if(count.equals("libya")) 
	    	    	  pic = R.drawable.libya;
	    	  else if(count.equals("southkorea")) 
	    	    	  pic = R.drawable.southkorea;
	    	  else if(count.equals("spain")) 
	    	    	  pic = R.drawable.spain;
	    	  else if(count.equals("taiwan")) 
	    	    	  pic = R.drawable.taiwan;
	    	  else if(count.equals("thailand"))
	    	    	  pic = R.drawable.thailand;
	    	  }
	
	    	  
	          this.list.add(new Weather(lon, lat, temp, country, name, pic));
	          this.adapter=new MyAdapter(this,list);
	          this.lv.setAdapter(adapter);
	    	
	    	
//	    	  String name = json.getString("name");	    	  
//	    	  output2.setText("Country"+name);
	    	  
	    	  //get a JSONObject in an JSONArray
//	    	  JSONArray weather = json.getJSONArray("weather");
//	    	  JSONObject j = weather.getJSONObject(0);
//	    	  String icon = j.getString("icon");
	    	  
	    	  //get an image in a site
//	    	  try {
//	    	        InputStream is = (InputStream) new URL("http://openweathermap.org/img/w/"+icon+".png").getContent();
//	    	        Drawable d = Drawable.createFromStream(is, "src name");
//	    	        img.setImageDrawable(d);
//	    	    } catch (Exception e) {
//	    	      
//	    	    }
	    	  
			} catch (JSONException e) {
				e.printStackTrace();
			}

    }
    
}
