package com.example.test;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Context mContext = MainActivity.this;
	private RequestQueue mQueue;
	private StringRequest strRequest;
	private TextView mTextView;
	private Button mButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTextView = (TextView) findViewById(R.id.tv_display);
		mButton = (Button) findViewById(R.id.btn);

		mQueue = Volley.newRequestQueue(mContext);
		
		mButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//转到新浪微博的授权页面
				
			}
			
		});

		strRequest = new StringRequest("http://www.baidu.com",
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						Toast.makeText(mContext, "success", Toast.LENGTH_SHORT).show();
					}

				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						Toast.makeText(mContext, "failed", Toast.LENGTH_SHORT).show();
					}
				});

		mQueue.add(strRequest);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
