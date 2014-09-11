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

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.psaravan.filebrowserview.demo.R;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;

import java.io.File;

public class MainActivity extends ActionBarActivity {

    //Context.
    private Context mContext;

    //FileBrowserView reference.
    private FileBrowserView mFileBrowserView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();

        //Grab a reference handle on the view, just like you'd do with any other view.
        mFileBrowserView = (FileBrowserView) findViewById(R.id.fileBrowserView);

        //Customize the view.
        mFileBrowserView.setFileBrowserLayoutType(FileBrowserView.FILE_BROWSER_LIST_LAYOUT) //Set the type of view to use.
                        .setDefaultDirectory(new File("/")) //Set the default directory to show.
                        .setShowHiddenFiles(true) //Set whether or not you want to show hidden files.
                        .showItemSizes(true) //Shows the sizes of each item in the list.
                        .showOverflowMenus(true) //Shows the overflow menus for each item in the list.
                        .showItemIcons(true) //Shows the icons next to each item name in the list.
                        .init(); //Loads the view. You MUST call this method, or the view will not be displayed.

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
