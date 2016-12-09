package test.view.zhangtao.viewscrollbackdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
{
    CircleImageView userHeadImg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_back_layout);

        userHeadImg = (CircleImageView) findViewById(R.id.img_head);

        Picasso.with(this).load("http://192.168.1.101/userIcon.png").into(userHeadImg);
    }
}
