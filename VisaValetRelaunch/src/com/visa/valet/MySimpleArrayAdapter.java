package com.visa.valet;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<Lawyer> {
  private final Context context;
  private final ArrayList<Lawyer> values;

  public MySimpleArrayAdapter(Context context, ArrayList<Lawyer> values) {
    super(context, -1, values);
    this.context = context;
    this.values = values;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
    TextView textView = (TextView) rowView.findViewById(R.id.textView1);
    TextView textView1 = (TextView) rowView.findViewById(R.id.TextView01);
    TextView textView2 = (TextView) rowView.findViewById(R.id.TextView02);
    TextView textView3 = (TextView) rowView.findViewById(R.id.TextView03);
 
    textView.setText(values.get(position).getName());
    textView1.setText("Years of Experience: "+values.get(position).getYears());
    textView2.setText("Success rate: "+values.get(position).getSuccess()+ "%");
    textView3.setText("Reviews: "+values.get(position).getReviews());
    
  /*
    Button details = (Button) convertView.findViewById(R.id.button1);
    
	details.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            
        	onButtonClick();
        }
    });*/
	
  
    return rowView;
  };
  
  public void onButtonClick(){
	  
	  Intent i = new Intent(this.getContext(),LawyerDetailActivity.class);
//	  i.putExtra("name", values.get().getName());
	  this.getContext().startActivity(i);
  }
} 
