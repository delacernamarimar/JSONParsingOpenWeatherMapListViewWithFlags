package com.example.weatherjson;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	Context context;
	ArrayList<Weather> list;
	LayoutInflater inflater;
	public MyAdapter(Context context, ArrayList<Weather> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ContactHandler handler=null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.countrydetails, null);
			handler=new ContactHandler();
			handler.iv=(ImageView) convertView.findViewById(R.id.imageView1);
			handler.capital=(TextView) convertView.findViewById(R.id.TextView02);
			handler.country=(TextView) convertView.findViewById(R.id.TextView01);
			handler.temp=(TextView) convertView.findViewById(R.id.textView1);
			handler.lon=(TextView) convertView.findViewById(R.id.textView3);
			handler.lat=(TextView) convertView.findViewById(R.id.textView2);

			convertView.setTag(handler);
		}
		else{
			handler = (ContactHandler) convertView.getTag();
			//dri nko vid 16:58
		}
		/// populating the individual listview  item
		handler.iv.setImageResource(list.get(arg0).getPic());
		handler.country.setText(list.get(arg0).getCountry());
		handler.capital.setText(list.get(arg0).getCapital());
		handler.temp.setText(list.get(arg0).getTemp()+"°F");
		handler.lon.setText("lon: "+list.get(arg0).getLon());
		handler.lat.setText("lat: "+list.get(arg0).getLat());
		return convertView;
	}
	

	static class ContactHandler{
		ImageView iv;
		TextView country,capital,temp, lon, lat;
	}
}
