package com.example.aeliao.hw2todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                list);
        ListView taskList = (ListView) findViewById(R.id.taskList);
        taskList.setOnItemClickListener(this);
        taskList.setOnItemLongClickListener(this);
    }

    public void addTask(View view) {
        EditText input = (EditText) findViewById(R.id.input);
        String inputText = input.getText().toString();
        if (!inputText.equals("")) {
            list.add(inputText);
            input.setText("");
            ListView taskList = (ListView) findViewById(R.id.taskList);
            taskList.setAdapter(adapter);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Hint: Long click to complete a task", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        list.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Congrats on a finishing a task!", Toast.LENGTH_SHORT).show();
        return false;
    }
}
