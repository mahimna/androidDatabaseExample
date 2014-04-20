package com.example.mainscreenactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainScreenActivity extends Activity {

	Button btnViewProducts;
	Button btnNewProduct;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		
		btnViewProducts = (Button) findViewById(R.id.btnViewProducts);
		btnNewProduct = (Button) findViewById(R.id.btnCreateProduct);
		
		btnViewProducts.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),AllProductsActivity.class);
				startActivity(i);
			}
		});
		
		btnNewProduct.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),NewProductActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_screen, menu);
		return true;
	}

}
