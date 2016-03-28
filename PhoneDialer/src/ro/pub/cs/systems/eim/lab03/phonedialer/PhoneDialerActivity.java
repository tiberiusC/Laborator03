package ro.pub.cs.systems.eim.lab03.phonedialer;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends Activity {

	EditText numberPhone;
	ImageButton btnBack;
	ImageButton btnCall;
	ImageButton btnCancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_dialer);
		List<Integer> listaId = new ArrayList<Integer>();
		listaId.add(R.id.idUnu);
		listaId.add(R.id.idDoi);
		listaId.add(R.id.idTrei);
		listaId.add(R.id.idPatru);
		listaId.add(R.id.idCinci);
		listaId.add(R.id.idSase);
		listaId.add(R.id.idSapte);
		listaId.add(R.id.idOpt);
		listaId.add(R.id.idNoua);
		listaId.add(R.id.idZero);
		listaId.add(R.id.idStar);
		listaId.add(R.id.idDiez);
		numberPhone = (EditText)findViewById(R.id.idPhoneNumber);
		btnBack = (ImageButton)findViewById(R.id.idDelete);
		btnCall = (ImageButton)findViewById(R.id.idCall);
		btnCancel = (ImageButton)findViewById(R.id.idCancel);
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(numberPhone.getText().toString().length()!=0)
				{
					numberPhone.setText(numberPhone.getText().toString().substring(0, numberPhone.getText().toString().length()-1));
				}
			}
		});
		
		btnCall.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:"+numberPhone.getText().toString()));
				startActivity(intent);
			}
		});
		
		btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		for(int i=0;i<listaId.size();i++)
		{
			final Button button = (Button)findViewById(listaId.get(i));
			button.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					numberPhone.setText(numberPhone.getText().toString()+button.getText().toString());
				}
			});
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_dialer, menu);
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
