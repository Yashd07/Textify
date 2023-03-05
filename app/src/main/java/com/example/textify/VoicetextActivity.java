package com.example.textify;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Locale;

@SuppressWarnings("ALL")
public class VoicetextActivity extends AppCompatActivity {

    private TextView voiceOutput;
    private MaterialButton copyVoiceTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voicetext);
        voiceOutput = findViewById(R.id.idTVVoiceOutput);
        copyVoiceTxt = findViewById(R.id.idBtnCopyVoiceText);


        copyVoiceTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String voiceTxt = voiceOutput.getText().toString();
                if(voiceTxt.equals("Your result appear here")){
                    Toast.makeText(VoicetextActivity.this, "Please perform the translation process", Toast.LENGTH_SHORT).show();
                }else{
                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("MyData",voiceTxt);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(VoicetextActivity.this, "Text copied in Clipboard", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getSpeechInput(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try{
            startActivityForResult(intent , 10);
        }catch(Exception e){
            Toast.makeText(this, "Your Device Don't support Voice Speech Input "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
            if(resultCode == RESULT_OK && data != null){
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                voiceOutput.setText(result.get(0));
            }
            break;
        }
    }
}