package com.example.hp.com.intentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view) {
        Intent intent = null, chooser = null;
        if (view.getId() == R.id.LaunchMap) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:37.755510,122.405078"));
            chooser = Intent.createChooser(intent, "Launch Maps");
            startActivity(chooser);
        }
        if (view.getId() == R.id.LaunchMarket) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.gameloft.android.ANMP.GloftM4HM"));
            chooser = Intent.createChooser(intent, "Launch Market");
            startActivity(chooser);
        }
        if (view.getId() == R.id.sendEmail) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"pmitul605@gmail.com", "mitulp534@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hi this was sent from my app");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello world");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Send Email");
            startActivity(chooser);


            if (view.getId() == R.id.sendImage) {
                Uri imageURI = Uri.parse("android.resource://com.hp.example.com/drawable" + R.drawable.camila);
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_STREAM, imageURI);
                intent.putExtra(Intent.EXTRA_TEXT, "Hey i have attached this image");
                chooser = Intent.createChooser(intent, "Send Image");
                startActivity(chooser);
            }

        }
    }
}

