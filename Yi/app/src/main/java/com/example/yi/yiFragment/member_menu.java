package com.example.yi.yiFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yi.R;

public class member_menu extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.member_menu, container, false);

        TextView bilibiliView = (TextView)view.findViewById(R.id.bilibili);
        bilibiliView.setSelected(true);
        setOnClickListener(bilibiliView, "https://www.bilibili.com/");

        TextView baidu = (TextView)view.findViewById(R.id.baidu);
        baidu.setSelected(true);
        setOnClickListener(baidu, "https://www.baidu.com/");

        TextView biying = (TextView)view.findViewById(R.id.biying);
        biying.setSelected(true);
        setOnClickListener(biying, "https://cn.bing.com/");

        TextView github = (TextView)view.findViewById(R.id.github);
        github.setSelected(true);
        setOnClickListener(github, "https://github.com/");

        TextView tencent_video = (TextView)view.findViewById(R.id.tencent_video);
        tencent_video.setSelected(true);
        setOnClickListener(tencent_video, "https://v.qq.com/");

        return view;
    }

    private void setOnClickListener(TextView textView, final String url) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
