package com.mad.homeworkgroup20.inclass10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatroomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        apiCalls.activity=this;
      //  token =getIntent().getExtras().getString(MainActivity.KEY_TOKEN);
        String threadName = getIntent().getExtras().getString(MainActivity.KEY_NAME);
         final String threadId =getIntent().getExtras().get(MainActivity.KEY_USERID).toString();
        TextView displayName= (TextView) findViewById(R.id.displayName);
        displayName.setText(threadName);

        ImageButton home = findViewById(R.id.homeImage);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
       final apiCalls caller = new apiCalls();
        caller.getMessages("",threadId);
         ImageButton add = findViewById(R.id.addMessage);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView   newMessage = findViewById(R.id.messageName);
              caller.addMessage(newMessage.getText().toString(),threadId);


            }
        });

      //  Log.d(TAG, "onCreate: threads token"+token);

    }
}
