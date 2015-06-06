package com.visa.valet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
public class LawyerActivity extends Activity {
	Firebase myFirebaseRef;
	ArrayList<Lawyer> values = new ArrayList<Lawyer>();
	String array[];
	Map<String, Object> newPost;
	ListView l;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyerlist);
        l = (ListView)findViewById(R.id.listView1);
        Firebase.setAndroidContext(this);
        
        myFirebaseRef = new Firebase("https://visavalet.firebaseio.com/lawyers");
        
        Query queryRef = myFirebaseRef.orderByChild("years");

        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                Map<String, Object> value = (Map<String, Object>)snapshot.getValue();
                System.out.println(snapshot.getKey() + " was " + value.get("height") + " meters tall");
                Lawyer lawyer = new Lawyer();
                lawyer.setName(value.get("name").toString());
                lawyer.setReviews(value.get("reviews").toString());
        		lawyer.setYears(value.get("years").toString());
        		lawyer.setSuccess(value.get("success").toString());
        		values.add(lawyer);
        		MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(LawyerActivity.this,values);
                l.setAdapter(adapter);
            }
            // ....

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildMoved(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildRemoved(DataSnapshot arg0) {
				// TODO Auto-generated method stub
				
			}
        });
 

    }
	
	public void lawyerdetail(View v){
	//	v.getParent();
		View parentRow = (View) v.getParent();
		ListView listView = (ListView) parentRow.getParent();
		final int position = listView.getPositionForView(parentRow);

		Intent i = new Intent(LawyerActivity.this,LawyerDetailActivity.class);
		i.putExtra("lawyer", new String[] {values.get(position).getName(),values.get(position).getYears(),values.get(position).getSuccess(),values.get(position).getReviews()});
		Log.d("VISA", "Name is"+values.get(position).getName());
		startActivity(i);
	}
}
