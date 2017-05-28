package com.example.golu.songs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {
    ImageView im1, im2, im3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        im1 = (ImageView) findViewById(R.id.english_song);
        im2 = (ImageView) findViewById(R.id.hindi_song);
        im3 = (ImageView) findViewById(R.id.motivation_song);

        Picasso.with(this)
                .load("http://idealog.co.nz/media/VERSIONS/articles/2016/03/lpv_950x700--upscale.jpg")
                .placeholder(R.mipmap.picholder)
                .error(R.mipmap.ic_error)
                .resize(400, 400)
                .into(im1);

        Picasso.with(this)
                .load("https://i.ytimg.com/vi/Yv0vBtr_INM/maxresdefault.jpg")
               .placeholder(R.mipmap.picholder)
             .error(R.mipmap.ic_error)
                .resize(400, 400)
                .into(im2);
        Picasso.with(this)
                .load("http://whycauseican.com/wp-content/uploads/2016/08/tamiko-experience-hope.jpg")
               .placeholder(R.mipmap.picholder)
               .error(R.mipmap.ic_error)
                .resize(400, 400)
                .into(im3);



}
    public void onSelectCategory(View view) {

        String category = "";

        if (view.getId() == R.id.english) {
            category = "english";

        } else if (view.getId() == R.id.hindi) {
            category = "hindi";
        } else if (view.getId() == R.id.motivation) {
            category = "motivation";
        }

        //pass the category selected to next activity
        Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
        i.putExtra("id", category);
        startActivity(i);

    }
}

