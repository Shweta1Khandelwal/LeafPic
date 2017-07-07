package com.example.shweta.leafpic;

import android.annotation.TargetApi;
import android.content.Intent;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import  static  com.example.shweta.leafpic.R.drawable.add20w;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    FloatingActionButton fab;
    int [] Images={R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p};
    String[] Name={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
    ImageAdapter adapter;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter =new ImageAdapter(MainActivity.this,Name,Images);
        fab = (FloatingActionButton) findViewById(R.id.fab);
       // fab.setImageResource(R.drawable.sharethis40);
        SubActionButton.Builder builder=new SubActionButton.Builder(this);
        ImageView item1=new ImageView(this);

        item1.setImageResource(R.drawable.facebook15);
        ImageView item2=new ImageView(this);
        item2.setImageResource(R.drawable.instagram15);
        ImageView item3=new ImageView(this);
        item3.setImageResource(R.drawable.twitter15);
        SubActionButton button1=builder.setContentView(item1).build();
        SubActionButton button2=builder.setContentView(item2).build();
        SubActionButton button3=builder.setContentView(item3).build();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button1 clicked",Toast.LENGTH_SHORT).show();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button2 clicked",Toast.LENGTH_SHORT).show();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button3 clicked",Toast.LENGTH_SHORT).show();

            }
        });
        new FloatingActionMenu.Builder(this).addSubActionView(button1).addSubActionView(button2).addSubActionView(button3).attachTo(fab).build();
        //Circular fab end


        gridView=(GridView)findViewById(R.id.grid);
       gridView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(MainActivity.this,"Search Button Clicked",Toast.LENGTH_LONG).show();
                return true;
            case R.id.home:
                Toast.makeText(MainActivity.this,"Home Button Clicked",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
