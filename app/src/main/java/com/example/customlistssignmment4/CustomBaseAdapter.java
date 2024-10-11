package com.example.customlistssignmment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomBaseAdapter extends BaseAdapter {


    Context context;
    String[] Tittle;
    String[] Subtittle;
    int[] image;
    LayoutInflater inflater;
    public CustomBaseAdapter(Context context, String[] Tittle, String[] SubTittle, int[] image)
    {
        this.context = context;
        this.Tittle = Tittle;
        this.Subtittle = SubTittle;
        this.image = image;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Tittle.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_costom_list_view, null);
        TextView textView = (TextView) convertView.findViewById(R.id.tv_Tittle);
        TextView textView1 = (TextView) convertView.findViewById((R.id.tv_Subtittle));
        ImageView imageView = (ImageView) convertView.findViewById((R.id.ImageView));
        textView.setText(Tittle[position]);
        textView1.setText(Subtittle[position]);
        imageView.setImageResource(image[position]);
        return convertView;

    }
}
