package com.visa.valet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;

public class ChatActivity extends Activity {
	Firebase myFirebaseRef;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    setContentView(R.layout.chat_activity);
    
 //       Firebase.setAndroidContext(this);
        
 //       myFirebaseRef = new Firebase("https://visavalet.firebaseio.com");
 //       myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");
        
    }
	
	public void send(View v){
		
	}
	
}
