package com.linuxshaman.powercycles;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Spinner;

import com.linuxshaman.powercycles.controllers.PowerCyclesManager;
import com.linuxshaman.powercycles.data.PowerCycleType;
import com.linuxshaman.powercycles.data.PowerCyclesHelper;

import java.util.ArrayList;
import java.util.List;


public class CreateNewCycleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_cycle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_new_cycle, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        initPowerCycleList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id == android.R.id.home){
            createNewCycle();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        createNewCycle();
        super.onBackPressed();
    }

    private void createNewCycle(){
        EditText newCycleNameEditText = (EditText)findViewById(R.id.newCycleNameEditText);
        EditText newCycleWeight = (EditText)findViewById(R.id.newCycleWeightEditText);
        String name = newCycleNameEditText.getText().toString();
        float weight = Float.valueOf(newCycleWeight.getText().toString());
        Spinner powerCyclesTypes = (Spinner)findViewById(R.id.powerCycleTypeList);
        long selectedPowerCycleTypeId = powerCyclesTypes.getSelectedItemId();
        PowerCycleType type = PowerCycleType.values()[(int)selectedPowerCycleTypeId];
        PowerCyclesManager.getInstance().addNewCycle(name, weight, type);
    }

    protected void initPowerCycleList(){
        Spinner powerCyclesTypes = (Spinner)findViewById(R.id.powerCycleTypeList);
        List<String> list = new ArrayList<String>();
        for(PowerCycleType type : PowerCycleType.values()){
            int stringId = PowerCyclesHelper.getResourceFromPowerCycleType(type);
            if(stringId > Integer.MIN_VALUE) {
                String val = getApplicationContext().getString(stringId);
                list.add(val);
            }
        }
        ArrayAdapter<String> powerCyclesTypesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        powerCyclesTypesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        powerCyclesTypes.setAdapter(powerCyclesTypesAdapter);
    }
}
