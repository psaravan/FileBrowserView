/*
 * Copyright (C) 2014 Saravan Pantham
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.psaravan.filebrowserview.demo.MainActivity;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.psaravan.filebrowserview.demo.DialogFragment.DialogFragment;
import com.psaravan.filebrowserview.demo.GridActivity.GridActivity;
import com.psaravan.filebrowserview.demo.ListActivity.ListActivity;
import com.psaravan.filebrowserview.demo.R;
import com.psaravan.filebrowserview.demo.TabbedBrowsingActivity.TabbedListActivity;

/**
 * Launcher class that displays all the options and FileBrowserView samples.
 *
 * @author Saravan Pantham
 */
public class MainActivity extends ActionBarActivity {

    //Context.
    private Context mContext;

    //ListView reference.
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();

        mListView = (ListView) findViewById(R.id.mainActivityListView);
        String[] adapterData = mContext.getResources().getStringArray(R.array.mainActivityList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                                                                android.R.layout.simple_expandable_list_item_1,
                                                                adapterData);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(mContext, ListActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(mContext, GridActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        FragmentManager fragmentManager = getFragmentManager();
                        DialogFragment fragment = new DialogFragment();
                        fragment.show(fragmentManager, "dialogFragment");
                        break;
                    case 3:
                        intent = new Intent(mContext, TabbedListActivity.class);
                        startActivity(intent);
                        break;
                }

            }

        });

    }

}
