/**
 * 
 * @author ydli
 * 
 */
package com.xiaodevil.views;



import java.util.ArrayList;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xiaodevil.contacts.R;
import com.xiaodevil.models.PhoneNumber;
import com.xiaodevil.models.User;
import com.xiaodevil.utils.UserInfoAdapter;

public class UserInfoActivity extends ActionBarActivity {
	
	private final static String TAG = "com.xiaodevil.views.UserInfoActivity";
	private ListAdapter listAdapter;
	
	private TextView ContactName;
	private ImageView Infobackground;
	private Button dia;
	private Button msg;
	private ListView UserInfo;
	private User user;
	private Intent intent;
	private String[] color = {"#eae8ff","#d8d5d8","#adacb5","#2d3142","#b0d7ff"};
	
	protected void onCreate(Bundle savedInstanceState ){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_info);
		Log.i(TAG,"UserInfoActivity start");
		ContactName = (TextView) findViewById(R.id.name);
		Infobackground = (ImageView) findViewById(R.id.info_avatar_bg);
		Random rdm = new Random(System.currentTimeMillis());
		int index = Math.abs(rdm.nextInt())%5;
		Infobackground.setBackgroundColor(android.graphics.Color.parseColor(color[index]));
		
		//dia = (Button)findViewById(R.id.dia);
		//msg = (Button)findViewById(R.id.msg);
		
		intent = this.getIntent();

		
		
		setupViews();
//		msg.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				
//				Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:"+user.getPhoneNumber()));
//				intent.putExtra("sms_body","绍林好美");
//				startActivity(intent);
//				
//				
//			}
//		});
//		
//		dia.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//			
//				Intent intent = new Intent();
//				intent.setAction(Intent.ACTION_CALL);
//				intent.setData(Uri.parse("tel:"+user.getPhoneNumber()));
//				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				startActivity(intent);
//				
//			}
//		});
		

	}
	
	
	
	private void setupViews(){
		ContactName = (TextView) findViewById(R.id.name);
		Infobackground = (ImageView) findViewById(R.id.info_avatar_bg);
		UserInfo = (ListView) findViewById(R.id.user_phone_number_list);
		Random rdm = new Random(System.currentTimeMillis());
		int index = Math.abs(rdm.nextInt())%4;
		Infobackground.setBackgroundColor(android.graphics.Color.parseColor(color[index]));
		
		user = (User)intent.getSerializableExtra(MainActivity.SER_KEY);
		if(user != null){
			ContactName.setText(user.getUserName());
		}
		
		
		
	//	listAdapter = new UserInfoAdapter(this, R.layout.userinfo_item, user.getPhoneNumbers());
		
		//UserInfo.setAdapter(listAdapter);
		
	}
}
