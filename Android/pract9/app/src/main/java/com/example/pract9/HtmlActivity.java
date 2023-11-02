package com.example.pract9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class HtmlActivity extends AppCompatActivity {
    private static final String TAG_HTTP_URL_CONNECTION =
            "HTTP_URL_CONNECTION";
    private static final int REQUEST_CODE_SHOW_RESPONSE_TEXT = 1;
    private static final String KEY_RESPONSE_TEXT = "KEY_RESPONSE_TEXT";
    private static final String REQUEST_METHOD_GET = "GET";
    private EditText requestUrlEditor = null;
    private Button requestUrlButton = null;
    private TextView responseTextView = null;
    private Handler uiUpdater = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        setTitle("Html Downloader");
        initControls();
        requestUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reqUrl = requestUrlEditor.getText().toString();

                if(!TextUtils.isEmpty(reqUrl)) {
                    if(URLUtil.isHttpUrl(reqUrl) ||
                            URLUtil.isHttpsUrl(reqUrl)) {
                        startSendHttpRequestThread(reqUrl);
                    }else {
                        Toast.makeText(getApplicationContext(), "The request url is not a valid http or https url.", Toast.LENGTH_LONG).show();

                    }
                }else {
                    Toast.makeText(getApplicationContext(), "The request url can not be empty.",

                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void initControls()
    {
        if(requestUrlEditor == null) {
            requestUrlEditor =
                    (EditText)findViewById(R.id.et1);
        }
        if(requestUrlButton == null) {
            requestUrlButton =
                    (Button)findViewById(R.id.btn5);
        }
        if(responseTextView == null) {
            responseTextView =
                    (TextView)findViewById(R.id.txt1);
        }
        {
            uiUpdater = new Handler()
            {
                @Override
                public void handleMessage(Message msg) {
                    if(msg.what == REQUEST_CODE_SHOW_RESPONSE_TEXT)
                    {
                        Bundle bundle = msg.getData();
                        if(bundle != null)
                        {
                            String responseText =

                                    bundle.getString(KEY_RESPONSE_TEXT);
                            responseTextView.setText(responseText);
                        }
                    }
                }
            };
        }
    }
    private void startSendHttpRequestThread(final String reqUrl)
    {
        Thread sendHttpRequestThread = new Thread()
        {
            @Override
            public void run() {
                HttpURLConnection httpConn = null;
                InputStreamReader isReader = null;
                BufferedReader bufReader = null;
                StringBuffer readTextBuf = new StringBuffer();
                try {
                    URL url = new URL(reqUrl);
                    httpConn = (HttpURLConnection)url.openConnection();
                    httpConn.setRequestMethod(REQUEST_METHOD_GET);
                    httpConn.setConnectTimeout(10000);
                    httpConn.setReadTimeout(10000);
                    InputStream inputStream = httpConn.getInputStream();
                    isReader = new InputStreamReader(inputStream);
                    bufReader = new BufferedReader(isReader);
                    String line = bufReader.readLine();
                    while(line != null) {
                        readTextBuf.append(line);
                        line = bufReader.readLine();
                    }
                    Message message = new Message();
                    message.what = REQUEST_CODE_SHOW_RESPONSE_TEXT;
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_RESPONSE_TEXT,
                            readTextBuf.toString());
                    message.setData(bundle);
                    uiUpdater.sendMessage(message);
                }catch(MalformedURLException ex) {

                    Log.e(TAG_HTTP_URL_CONNECTION, ex.getMessage(), ex);
                }catch(IOException ex) {
                    Log.e(TAG_HTTP_URL_CONNECTION, ex.getMessage(), ex);
                }finally {
                    try {
                        if (bufReader != null) {
                            bufReader.close();
                            bufReader = null;
                        }
                        if (isReader != null) {
                            isReader.close();
                            isReader = null;
                        }
                        if (httpConn != null) {
                            httpConn.disconnect();
                            httpConn = null;
                        }
                    }catch (IOException ex) {
                        Log.e(TAG_HTTP_URL_CONNECTION, ex.getMessage(),
                                ex);
                    }
                }
            }
        };
        sendHttpRequestThread.start();
    }
}