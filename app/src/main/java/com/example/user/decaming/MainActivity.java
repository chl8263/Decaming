package com.example.user.decaming;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;


public class MainActivity extends AppCompatActivity {
    final private int COUPLE_CODE = 11;
    final private int COUPLE_CODE2 = 22;
    private Calc calc = new Calc();
    private TextView ing;
    private ImageView setting, people1, people2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ing = (TextView) findViewById(R.id.ing);
        ing.setText(calc.ing() + "일째");
        String aaa = Preference.getPreferences(this, "couple");

        imgcouple();
        imgset();
        listset();
    }

    private void imgcouple() {
        people1 = (ImageView) findViewById(R.id.people1);
        people2 = (ImageView) findViewById(R.id.people2);
        String aaa = Preference.getPreferences(this, "couple");
        String bbb = Preference.getPreferences(this, "couple2");
        Uri uri = Uri.parse(aaa);
        Uri uri2 = Uri.parse(bbb);
        if (aaa.equals("asd")) {
            Picasso.with(this).load(R.drawable.people).transform(new CropCircleTransformation()).into(people1);
        } else {
            Picasso.with(this).load(uri).transform(new CropCircleTransformation()).into(people1);

        }
        if (bbb.equals("asd")) {
            Picasso.with(this).load(R.drawable.people).transform(new CropCircleTransformation()).into(people2);
        } else {
            Picasso.with(this).load(uri2).transform(new CropCircleTransformation()).into(people2);
        }
    }

    private void imgset() {
        setting = (ImageView) findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageDialog.class);
                startActivityForResult(intent, COUPLE_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COUPLE_CODE) {
            if (resultCode == 1) {
                String ddd = Preference.getPreferences(getApplicationContext(), "couple");
                Uri uri = Uri.parse(ddd);
                Picasso.with(this).load(uri).transform(new CropCircleTransformation()).into(people1);
            }
            if (resultCode == 2) {
                String ddd = Preference.getPreferences(getApplicationContext(), "couple2");
                Uri uri = Uri.parse(ddd);
                Picasso.with(this).load(uri).transform(new CropCircleTransformation()).into(people2);
            }
        }

    }

    private void listset() {
        ListView listView;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        adapter.addItem("100일", "2017/06/23(금)", "D-" + calc.one());
        adapter.addItem("200일", "2017/10/01(일)", "D-" + calc.one1());
        adapter.addItem("보민이 생일", "2017/10/03(화)", "D-" + calc.one2());
        adapter.addItem("300일", "2018/01/09(화)", "D-" + calc.one3());
        adapter.addItem("1주년", "2018/03/16(금)", "D-" + calc.one4());
        adapter.addItem("원균이 생일", "2018/03/24(토)", "D-" + calc.one5());
        adapter.addItem("400일", "2018/04/19(목)", "D-" + calc.one6());
        adapter.addItem("500일", "2018/07/28(토)", "D-" + calc.one7());
        adapter.addItem("보민이 생일", "2018/10/03(수)", "D-" + calc.one8());
        adapter.addItem("600일", "2018/11/05(월)", "D-" + calc.one9());
        adapter.addItem("700일", "2019/02/13(수)", "D-" + calc.one10());
        adapter.addItem("2주년", "2019/03/16(토)", "D-" + calc.one11());
        adapter.addItem("원균이 생일", "2019/03/24(일)", "D-" + calc.one12());
        adapter.addItem("800일", "2019/05/24(금)", "D-" + calc.one13());
        adapter.addItem("900일", "2019/09/01(일)", "D-" + calc.one14());
        adapter.addItem("보민이 생일", "2019/10/03(목)", "D-" + calc.one15());
        adapter.addItem("1000일", "2019/12/10(화)", "D-" + calc.one16());
    }
}

