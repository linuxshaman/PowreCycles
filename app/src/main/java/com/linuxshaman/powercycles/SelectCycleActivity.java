package com.linuxshaman.powercycles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.linuxshaman.powercycles.controllers.PowerCyclesManager;
import com.linuxshaman.powercycles.data.PowerCycle;
import com.linuxshaman.powercycles.helpers.BundleKeys;
import com.linuxshaman.powercycles.helpers.IOHelper;

import java.util.List;


public class SelectCycleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cycle);
        IOHelper.setContext(this);
    }

    @Override
    protected void onResume() {
        PowerCyclesManager.getInstance();
        super.onResume();
        updateCyclesList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_cycle, menu);
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

    protected void addCurrentCyclesData(ArrayAdapter<String> selectCycleAdapter){
        List<PowerCycle> powerCycleList = PowerCyclesManager.getInstance().getPowerCycles();
        for(PowerCycle powerCycle : powerCycleList){
            selectCycleAdapter.add(powerCycle.getName());
        }
    }

    protected void addNewCycleItem(ArrayAdapter<String> selectCycleAdapter){
        selectCycleAdapter.add("Add New Cycle");
    }

    protected void updateCyclesList(){
        ListView selectCycleListView = (ListView)findViewById(R.id.select_cycle_list);
        ArrayAdapter<String> selectCycleAdapter = new ArrayAdapter<String>(this, R.layout.cycle_list_text_view);
        addCurrentCyclesData(selectCycleAdapter);
        addNewCycleItem(selectCycleAdapter);
        selectCycleListView.setAdapter(selectCycleAdapter);
        selectCycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id == parent.getCount() - 1) {
                    onAddNewCycleClick();
                } else {
                    onCycleClick(id);
                }
            }
        });
    }

    protected void onAddNewCycleClick(){
        Intent intent = new Intent(this, CreateNewCycleActivity.class);
        startActivity(intent);
    }

    protected void onCycleClick(long id){
        Intent intent = new Intent(this, PowerCycleActivity.class);
        Bundle b = new Bundle();
        b.putLong(BundleKeys.SELECTED_POWER_CYCLE_ID_KEY, id);
        intent.putExtras(b);
        startActivity(intent);
    }

//    public void sendMessage(View view) {
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }
}
