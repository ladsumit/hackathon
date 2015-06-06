package com.visa.valet;
import com.firebase.client.Firebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class LawyerDetailActivity extends Activity {
	Firebase myFirebaseRef;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyer_profile);
        Intent i=this.getIntent();
        String[] lawyer = i.getStringArrayExtra("lawyer");
 //       Firebase.setAndroidContext(this);
        TextView name=(TextView)findViewById(R.id.textView1);
        name.setText(lawyer[0]);
 //       myFirebaseRef = new Firebase("//https://visavalet.firebaseio.com");
 //       myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");
        
    }
	
	public void lawyerselect(View v){
		Intent i = new Intent(LawyerDetailActivity.this,UserActivity1.class);
		startActivity(i);
	}
}
