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

public class UserActivity extends Activity{
	Firebase myFirebaseRef;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity1);
    
 //       Firebase.setAndroidContext(this);
        
 //       myFirebaseRef = new Firebase("https://visavalet.firebaseio.com");
 //       myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");
        
    }
	
	public void findlawyer(View v){
		Intent i = new Intent(UserActivity.this,LawyerActivity.class);
		startActivity(i);
	}
	
}
