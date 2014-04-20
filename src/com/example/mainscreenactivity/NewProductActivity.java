package com.example.mainscreenactivity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewProductActivity  extends Activity{
	
	private ProgressDialog pDialog;
	
	JSONParser jsonParser = new JSONParser();
	EditText inputName;
	EditText inputPrice;
	EditText inputDesc;
	
	private static String url_create_product = "http://androidprojectmahimna.comoj.com/create_product.php";
	
	private static final String TAG_SUCCESS = "success";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_products);
		
		inputName = (EditText) findViewById(R.id.inputName);
		inputPrice = (EditText) findViewById(R.id.inputPrice);
		inputDesc = (EditText) findViewById(R.id.inputDesc);
		
		Button btnCreateProduct = (Button) findViewById(R.id.btnCreateProduct);
		
		btnCreateProduct.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CreateNewProduct task = new CreateNewProduct();
				task.execute();
			}
			
			
		});
	}
	
	class CreateNewProduct extends AsyncTask<String,String,String> {

			
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDialog = new ProgressDialog(NewProductActivity.this);
			pDialog.setMessage("Creating Product..");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			
			String name = inputName.getText().toString();
			String price = inputPrice.getText().toString();
			String description = inputDesc.getText().toString();
			
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair ("name",name));
			params.add(new BasicNameValuePair ("price",price));
			params.add(new BasicNameValuePair("description",description));
			
			JSONObject json = jsonParser.makeHttpRequest(url_create_product,"POST",params);
			
			Log.d("Create Response", json.toString());
			
			try{
				int success = json.getInt(TAG_SUCCESS);
				
				if(success==1){
					Intent i = new Intent(getApplicationContext(),AllProductsActivity.class);
					startActivity(i);
					
					finish();
					
				} else {
					
				}
				
			} catch(JSONException e){
				e.printStackTrace();
			}
					
			
			return null;
		}

		@Override
		protected void onPostExecute(String file_url) {
			// TODO Auto-generated method stub
			pDialog.dismiss();
		}
		
	
		
	}
	
}