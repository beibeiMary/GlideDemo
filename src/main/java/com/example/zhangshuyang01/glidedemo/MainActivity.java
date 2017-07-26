package com.example.zhangshuyang01.glidedemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestManager;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String RESOURCE = "android.resource://";
    public static final String SLASH = "/";
    private Context context;
    private String path = "/androidesk/wallpapers/57484f7869401b103938f52a.jpg";
    private int resId = R.mipmap.ic_launcher;
    private String url_img = "http://images.cnitblog.com/blog/430074/201302/01220037-4e6a57c1199748fea9f8391e7e0548d7.jpg";
    private String url_gif = "http://pic.uuhy.com/uploads/2011/02/11/005.gif";
    ImageView iv;
    private Button btn1, btn2, btn3, btn4, btn5, btn6;
    private RequestManager glideRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        initView();
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.imageview_activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        glideRequest = Glide.with(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                //加载资源中的图片
                Glide.with(context).load(R.mipmap.ic_launcher).into(iv);
                break;
            case R.id.btn2:
                //加载网络图片
//        Glide.with(context).load(url_img).into(iv);
                Glide.with(context).load(url_img).centerCrop().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).priority(Priority.HIGH).crossFade().into(iv);
                break;
            case R.id.btn3:
                //加载Gif图片
                Glide.with(context).load(url_gif).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(iv);
                break;
            case R.id.btn4:
                //加载文件中的图片
                File file = new File(Environment.getExternalStorageDirectory().getPath() + path);
                Glide.with(context).load(file).into(iv);
                //加载Uri中的图片
//        Uri uri = Uri.parse(RESOURCE + getPackageName() + SLASH + resId);
//        Glide.with(context).load(uri).into(iv);
                break;
            case R.id.btn5:

                glideRequest.load(url_img).transform(new GlideCircleTransform(context)).into(iv);
                break;
            case R.id.btn6:

                glideRequest.load(url_img).transform(new GlideRoundTransform(context)).into(iv);

//                glideRequest.load("https://www.baidu.com/img/bdlogo.png").transform(new GlideRoundTransform(context, 10)).into(imageView);
                break;
        }
    }
}
