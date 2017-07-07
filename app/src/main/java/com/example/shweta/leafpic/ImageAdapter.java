package com.example.shweta.leafpic;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Shweta on 7/4/2017.
 */
public class ImageAdapter  extends BaseAdapter{
    private Context mContext;
    private final String[] Name ;
    private final int[] Images;

//    public int [] Images={R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p};
//public String[] Name={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};

    public ImageAdapter(Context c,String[]Name,int[]Images){
        mContext= c;
        this.Name=Name;
        this.Images=Images;
    }

    @Override
    public int getCount() {
       return Images.length;

    }

    @Override
    public Object getItem(int position) {
       return Images[position];

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class Holder {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View Grid;
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       Holder holder = new Holder();
        Grid = new View(mContext);
        Grid = inflater.inflate(R.layout.custom_grid, null);
       holder.tv = (TextView) Grid.findViewById(R.id.TextGrid);
        holder.img= (ImageView) Grid.findViewById(R.id.ImageGrid);
//        ImageView imageView = new ImageView(mContext);
//     imageView.setImageResource(Images[position]);
       holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setLayoutParams(new GridView.LayoutParams(355, 355));
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Image Clicked: "+position,Snackbar.LENGTH_SHORT).show();
            }
        });
        holder.img.setImageResource(Images[position]);
        holder.tv.setText(Name[position]);
        return Grid;
    }

}
