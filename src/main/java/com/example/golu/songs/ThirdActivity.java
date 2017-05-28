package com.example.golu.songs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    String courseID;
    RecyclerView recyclerView;

    Bundle bundle;
    ArrayList<Data> al;
    MyAdapter myadapter;

    private String[] top_English_songs_videos = {
            "PSY - GANGNAM STYLE/9bZkp7q19f0/04:12",
            "Jennifer Lopez-On The Floor ft. Pitbull/t4H_Zoh7G5A/04:26",
            "Enrique Iglesias-I Like It/X9_n8jakvWU/04:03",
            "Justin Bieber-Baby ft. Ludacris/kffacxfA7G4/03:44",
            "Britney Spears-Criminal/s6b33PTbGxk/05:22",
            "Enrique Iglesias, Usher-Dirty Dancer ft. Lil Wayne/vHJAUuicC0Q/04:16",
            "Pitbull-International Love ft. Chris Brown/CdXesX6mYUE/04:08",
            "Katy Perry-Dark Horse (Official) ft. Juicy J/0KSOMA3QBU0/03:44",
            "Ellie Goulding-Love Me Like You Do (Official Video)/AJtDXIazrMo/04:09",
            "ARASH feat Helena- Broken Angel/whp15J2n_M/03:23",
    };

    private String[] top_Hindi_songs_videos = {
            "Enna Sona – OK Jaanu/1I2aa1sf5NA/02:56",
            "KAUN TUJHE /atVof3pjT-I/02:32",
            "Phir Bhi Tumko Chaahunga/bUDIm1SstAE/02:56",
            "Atif Aslam: Musafir Song/Sh3rF46yoKU/03:30",
            "Ae Dil Hai Mushkil/vUCM_0evdQY/02:58",
            "Toota Jo Kabhi Tara - Full Video/GTOdXVfrXF0/04:54",
            "Jeena Jeena - Tere naam pe Meri Zindagi/mbAhyj9OVIo/03:49",
            "'Khuda Bhi' FULL VIDEO Song/IgK5-PUeARg/22:08",
            "Baarish Yaariyan Full Video Song (Official)/Qvd-I7lTecI/03:48",
            "Jeene Laga Hoon Bollywood/qpIdoaaPa6U/03:48",
            "Chahun Main Ya Naa Full Video Song Aashiqui 2/VdyBtGaspss/04:00",
            "Pani Da Rang Vicky Donor/xqsgnXWUA4M/04:00",
            "Saiyaara - Full Song/A5pSnIwbpaM/02:40",
            "Tu Jaane Na - Ajab Prem Ki Ghazab Kahani/QrGvbM-bzak/03:51",
            "Tune Jo Na Kaha-New York/AILL_I-TdbM/05:06",
            "Teri Meri Prem Kahani Bodyguard/tyxswccv-VU/02:40",
            "Hamdard Full Video Song/FJ55SHCzt88/04:18",
            "Sun Saathiya Full Video/TGpG56pg3UU/03:15",
            "Humnava - Hamari Adhuri Kahani/ktPD6TMovxs/06:18",
    };
    private String[] top_Motivational_songs_videos = {
            "Zinda - Bhaag Milkha Bhaag/fP6MNznzVcQ/02:42",
            "Aashayein Full /1cIfRd0arB8/04:23",
            "Chak De India - Full Title Song/OSEw6kv70Xw/02:41",
            "Brothers Anthem - Akshay Kumar/IjBAgWKW12Y/6:18",
            "Dangal - Title Track/jMfvlh0tjyo/05:07",
            "Lakshya - Title Track/8DMF0U6xV78/0441",
            "Sultan - Full Title Song/abiL84EAWSY/04:12",
            "Allah Hafiz [Full Song]/ri3NctAmkWE/03:11",
            "Justin Bieber - Never Say Never ft. Jaden Smith/_Z5-P9v3F8w/03:49",
            "Jay Jaykara - Full Video /CT-Xp4Sl9gM/03:31",
            "Give Me Some Sunshine/HZu3bXWhnX4/02:27"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent i = getIntent();
        bundle = i.getExtras();
        courseID = bundle.getString("id");
        al = new ArrayList<Data>();
        myadapter = new MyAdapter();


        switch (courseID) {
            case "english":

                getStrng(top_English_songs_videos );

                break;
            case "hindi":

                getStrng(top_Hindi_songs_videos );

                break;
            case "motivation":

                getStrng(top_Motivational_songs_videos );

                break;
        }

        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setAdapter(myadapter);

        LinearLayoutManager mng=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mng);


    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // load row.xml
            View v=getLayoutInflater().inflate(R.layout.row ,parent,false);
            //pass row.xml to view Holder(Our Vie Holder
            ViewHolder viewHolder=new ViewHolder(v);

            return viewHolder; //Return ViewwHolder
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            //get data from source (Arraylist) based on position
            Data data=al.get(position);

            //Apply data onto row.xml(viewHolder)
            holder.tv1.setText(data.getSlno());
            holder.tv2.setText(data.getTopic());
            holder.tv3.setText(data.getDuration());
          /* holder.b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String video = data.getVideo().toString();
                    Intent i = new Intent(List.this,YoutubeView.class);
                    i.putExtra("videoId",video);
                    startActivity(i);

                }
            });*/

        }

        @Override
        public int getItemCount() {
            return al.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            //declare row xml in our case there is 3 TextView
            TextView tv1,tv2,tv3;
            Button b1;
            public ViewHolder(View itemView) {
                super(itemView);
                tv1=(TextView) itemView.findViewById(R.id.tv_count);
                tv2=(TextView) itemView.findViewById(R.id.tv_header);
                tv3=(TextView) itemView.findViewById(R.id.tv_duration);
                b1=(Button) itemView.findViewById(R.id.button_demo);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos=getAdapterPosition();
                        Data data=al.get(pos);
                        String youtube_videoId=data.getVideo();
                        Intent i = new Intent(ThirdActivity.this,YouTube.class);
                        i.putExtra("videoId",youtube_videoId);
                        startActivity(i);
                    }
                });
            }
        }
    }

    private void getStrng(String[] online_video_link) {

        for (int i = 0; i < online_video_link.length; i++) {

            String item=online_video_link[i];
            int first=item.indexOf("/");
            int second=item.indexOf("/",first+1);
            String videoName=item.substring(0,first);
            String video_YouTubeId=item.substring(first+1,second);
            String video_duration=item.substring(second+1);

            al.add(new Data("" + (i+1), videoName, video_duration,video_YouTubeId));

        }
        myadapter.notifyDataSetChanged();
    }
}
