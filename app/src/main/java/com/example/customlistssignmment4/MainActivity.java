package com.example.customlistssignmment4;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customlistssignmment4.CustomExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int lastExpandedGroup = -1;
    private ExpandableListView expandableListView;
    private CustomExpandableListAdapter adapter;
    private List<String> groupList;
    private HashMap<String, List<String>> childMap;
    private int[] images = {R.drawable.one, R.drawable.two, R.drawable.three};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandableListView);

        // Prepare data
        groupList = new ArrayList<>();
        childMap = new HashMap<>();

        groupList.add("CSE");
        groupList.add("EEE");
        groupList.add("CIVIL");

        List<String> cseList = new ArrayList<>();
        cseList.add("Section");
        cseList.add("Batch");
        cseList.add("Group");

        List<String> eeeList = new ArrayList<>();
        eeeList.add("Section");
        eeeList.add("Batch");
        eeeList.add("Group");

        List<String> civilList = new ArrayList<>();
        civilList.add("Section");
        civilList.add("Batch");
        civilList.add("Group");

        childMap.put(groupList.get(0), cseList);
        childMap.put(groupList.get(1), eeeList);
        childMap.put(groupList.get(2), civilList);

        // Set up adapter
        adapter = new CustomExpandableListAdapter(this, groupList, childMap, images);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupExpandListener(groupPosition -> {
            if (lastExpandedGroup != -1 && lastExpandedGroup != groupPosition) {
                expandableListView.collapseGroup(lastExpandedGroup); // Collapse previously expanded group
            }
            lastExpandedGroup = groupPosition;
        });
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String child = childMap.get(groupList.get(groupPosition)).get(childPosition);
            Toast.makeText(MainActivity.this, "Clicked: " + child, Toast.LENGTH_SHORT).show();
            return true;
        });

        expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            Toast.makeText(MainActivity.this, "Group Clicked: " + groupList.get(groupPosition), Toast.LENGTH_SHORT).show();
            return false;
        });
    }
}
