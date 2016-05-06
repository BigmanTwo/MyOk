package com.example.asus.myok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.asus.myok.adapter.MyBookAdapter;
import com.example.asus.myok.bean.BookZ;
import com.example.asus.myok.bean.Books;
import com.example.asus.myok.bean.BooksM;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    static final String URLS="http://japi.juhe.cn/book/recommend.from?key=06eaf41326d2ea338fdf6847e10f58e9";
    private List<Books> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView)findViewById(R.id.list_view);
        getDate();
    }

    private void getDate() {
        OkHttpClient okHttpClient=new OkHttpClient();
        final Request request=new Request.Builder().get().url(URLS).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson=new Gson();
                BooksM booksm=gson.fromJson(response.toString(),BooksM.class);
                BookZ bookz=booksm.getResult();
                mList=bookz.getData();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MyBookAdapter adapter=new MyBookAdapter(mList,MainActivity.this);
                        mListView.setAdapter(adapter);
                    }
                });


            }
        });
    }
}
