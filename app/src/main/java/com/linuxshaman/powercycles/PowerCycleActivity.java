package com.linuxshaman.powercycles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.linuxshaman.powercycles.controllers.PowerCyclesManager;
import com.linuxshaman.powercycles.data.PowerCycle;
import com.linuxshaman.powercycles.data.PowerCyclesHelper;
import com.linuxshaman.powercycles.helpers.BundleKeys;


public class PowerCycleActivity extends ActionBarActivity {

    private int progress = 0;
    private int powerCycleId =  0;
    private PowerCycleActivity self = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        self = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        powerCycleId = (int)b.getLong(BundleKeys.SELECTED_POWER_CYCLE_ID_KEY);
        PowerCycle powerCycle = PowerCyclesManager.getInstance().getPowerCycles().get(powerCycleId);
        progress = PowerCyclesManager.getInstance().getCycleProgress(powerCycle);
        int count = powerCycle.getTrainings().size();
        String progressString = String.format("%d / %d trainings complete!", progress, count);

        setTitle(powerCycle.getName());
        TextView powerCycleTypeView = (TextView)findViewById(R.id.power_cycle_type_text_view);
        powerCycleTypeView.setText(getString(PowerCyclesHelper.getResourceFromPowerCycleType(powerCycle.getType())));

        TextView powerCycleWeightView = (TextView)findViewById(R.id.power_cycle_weight_text_view);
        powerCycleWeightView.setText(Float.toString(powerCycle.getWeight()));

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.power_cycle_progress_bar);
        progressBar.setProgress(100 * (progress / count));

        TextView progressTextView = (TextView)findViewById(R.id.progress_text_view);
        progressTextView.setText(progressString);

        Button startTrainingButtom = (Button)findViewById(R.id.start_training_button);
        startTrainingButtom.setOnClickListener(startTrainingButtonListner);
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

    View.OnClickListener startTrainingButtonListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putInt(BundleKeys.SELECTED_POWER_CYCLE_ID_KEY, powerCycleId);
            bundle.putInt(BundleKeys.SELECTED_TRAINING_ID_KEY, progress);
            Intent intent = new Intent(self, FullTrainingActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };
}
