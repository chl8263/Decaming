package com.example.user.decaming;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by User on 2017-05-13.
 */


public class ImageDialog extends Activity {
    final int REQUEST_PICTURE = 1111;
    final int REQUEST_PICTURE2 = 2222;
    private Display display;
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_img);
        displayset();
        imageView1 = (ImageView) findViewById(R.id.couple1);
        imageView2 = (ImageView) findViewById(R.id.couple2);
        createimg();
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoAlbum();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoAlbum2();
            }
        });
    }

    private void createimg() {
        String aaa = Preference.getPreferences(this, "couple");
        String bbb = Preference.getPreferences(this, "couple2");
        Uri uri = Uri.parse(Preference.getPreferences(this, "couple"));
        Uri uri2 = Uri.parse(Preference.getPreferences(this, "couple2"));
        if (aaa == "asd") {
            Picasso.with(this).load(R.drawable.couple).into(imageView1);
        } else if (aaa != "asd") {
            Picasso.with(this).load(uri).into(imageView1);
        }
        if (bbb == "asd") {
            Picasso.with(this).load(R.drawable.couple).into(imageView2);
        } else if (bbb != "asd") {
            Picasso.with(this).load(uri2).into(imageView2);
        }
    }

    private void displayset() {
        display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int) (display.getWidth() * 0.9);
        int height = (int) (display.getHeight() * 0.5);
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;

    }

    private void photoAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_PICTURE);
    }

    private void photoAlbum2() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_PICTURE2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PICTURE) {
            if (data == null) {
                Uri uri1 = Uri.parse(Preference.getPreferences(getApplicationContext(), "couple"));
                Picasso.with(this).load(uri1).into(imageView1);
                finish();
            } else if (data != null) {
                Cursor c = getContentResolver().query(data.getData(), null, null, null, null);
                c.moveToNext();
                String path = c.getString(c.getColumnIndex(MediaStore.MediaColumns.DATA));
                Uri uri = Uri.fromFile(new File(path));
                c.close();
                String ddd = uri.toString();
                Preference.setPreferances(getApplicationContext(), "couple", ddd);
                Picasso.with(this).load(uri).into(imageView1);
                setResult(1);
            }
        } else if (requestCode == REQUEST_PICTURE2) {
            if (data == null) {
                Uri uri1 = Uri.parse(Preference.getPreferences(getApplicationContext(), "couple2"));
                Picasso.with(this).load(uri1).into(imageView2);
                finish();
            } else if (data != null) {
                Cursor c = getContentResolver().query(data.getData(), null, null, null, null);
                c.moveToNext();
                String path = c.getString(c.getColumnIndex(MediaStore.MediaColumns.DATA));
                Uri uri = Uri.fromFile(new File(path));
                c.close();
                String ddd = uri.toString();
                Preference.setPreferances(getApplicationContext(), "couple2", ddd);
                Picasso.with(this).load(uri).into(imageView2);
                setResult(2);
            }
        }
    }
}
