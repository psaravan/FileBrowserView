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
package com.psaravan.filebrowserview.demo.GridActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.psaravan.filebrowserview.demo.R;
import com.psaravan.filebrowserview.lib.Interfaces.NavigationInterface;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;

import java.io.File;

/**
 * Example implementation for a grid representation of the view.
 *
 * @author Saravan Pantham
 */
public class GridActivity extends Activity {

    //Context.
    private Context mContext;

    //FileBrowserView reference.
    private FileBrowserView mFileBrowserView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_browser_view);
        mContext = this.getApplicationContext();

        //Grab a reference handle on the view, just like you'd do with any other view.
        mFileBrowserView = (FileBrowserView) findViewById(R.id.fileBrowserView);

        //Customize the view.
        mFileBrowserView.setFileBrowserLayoutType(FileBrowserView.FILE_BROWSER_GRID_LAYOUT) //Set the type of view to use.
                        .setDefaultDirectory(new File("/")) //Set the default directory to show.
                        .setShowHiddenFiles(true) //Set whether or not you want to show hidden files.
                        .showItemSizes(true) //Shows the sizes of each item in the list.
                        .showOverflowMenus(true) //Shows the overflow menus for each item in the list.
                        .showItemIcons(true) //Shows the icons next to each item name in the list.
                        .setNavigationInterface(navInterface) //Sets the nav interface instance for this view.
                        .init(); //Loads the view. You MUST call this method, or the view will not be displayed.

    }

    /**
     * Navigation interface for the view. Used to capture events such as a new
     * directory being loaded, files being opened, etc. For our purposes here,
     * we'll be using the onNewDirLoaded() method to update the ActionBar's title
     * with the current directory's path.
     */
    private NavigationInterface navInterface = new NavigationInterface() {

        @Override
        public void onNewDirLoaded(File dirFile) {
            //Update the action bar title.
            getActionBar().setTitle(dirFile.getAbsolutePath());
        }

        @Override
        public void onFileOpened(File file) {

        }

        @Override
        public void onParentDirLoaded(File dirFile) {

        }

        @Override
        public void onFileFolderOpenFailed(File file) {

        }

    };

    @Override
    public void onBackPressed() {
        if (mFileBrowserView!=null) {
            File parentDir = mFileBrowserView.getParentDir();

            if (parentDir!=null) {
                mFileBrowserView.getFileBrowserEngine().loadDir(parentDir);
            } else {
                super.onBackPressed();
            }

        }

    }

}
