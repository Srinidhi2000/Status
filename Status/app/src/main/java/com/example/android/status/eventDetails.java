package com.example.android.status;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class eventDetails extends AppCompatActivity {
    TextView hello;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.event_details);
hello=findViewById(R.id.ID);
Bundle extras=getIntent().getExtras();
if(extras!=null)
{   obj current=(obj)extras.getSerializable("Event");
    hello.setText(current.getId());
}
    }
}
