// Copyright 2007-2013 Metaio GmbH. All rights reserved.
package es.unex.afrasilv.tfg.prop2met;

import android.content.Intent;
import android.view.View;

import com.metaio.sdk.ARELActivity;

public class ARELViewActivity extends ARELActivity {
	boolean sesionIniciada;

	@Override
	protected int getGUILayout() {
		// Attaching layout to the activity
		return R.layout.settings_button_view;
	}

	public void onClickSettings(View v) {
		Intent i = new Intent(ARELViewActivity.this, DialogActivity.class);
		i.putExtra("sesionIniciada", sesionIniciada);
		startActivity(i);
	}
}
