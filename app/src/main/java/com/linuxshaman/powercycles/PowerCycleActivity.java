package com.linuxshaman.powercycles;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.linuxshaman.powercycles.controllers.PowerCyclesManager;
import com.linuxshaman.powercycles.data.PowerCycle;
import com.linuxshaman.powercycles.data.PowerCyclesHelper;
import com.linuxshaman.powercycles.helpers.BundleKeys;


public class PowerCycleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        int id = (int)b.getLong(BundleKeys.SELECTED_POWER_CYCLE_ID_KEY);
        PowerCycle powerCycle = PowerCyclesManager.getInstance().getPowerCycles().get(id);
        setTitle(powerCycle.getName());
        TextView powerCycleTypeView = (TextView)findViewById(R.id.power_cycle_type_text_view);
        powerCycleTypeView.setText(getString(PowerCyclesHelper.getResourceFromPowerCycleType(powerCycle.getType())));

        TextView powerCycleWeightView = (TextView)findViewById(R.id.power_cycle_weight_text_view);
        powerCycleWeightView.setText(Float.toString(powerCycle.getWeight()));

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.power_cycle_progress_bar);
        progressBar.setProgress(50);

        TextView progressTextView = (TextView)findViewById(R.id.progress_text_view);
        progressTextView.setText("8 / 16 trainings complete!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_training, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
