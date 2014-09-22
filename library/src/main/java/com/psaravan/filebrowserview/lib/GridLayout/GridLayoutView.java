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
package com.psaravan.filebrowserview.lib.GridLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.psaravan.filebrowserview.lib.FileBrowserEngine.AdapterData;
import com.psaravan.filebrowserview.lib.R;
import com.psaravan.filebrowserview.lib.View.BaseLayoutView;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;

import java.io.File;

/**
 * Grid layout view implementation for the file browser.
 *
 * @author Saravan Pantham
 */
public class GridLayoutView extends BaseLayoutView {

    //Context.
    private Context mContext;

    //Parent FileBrowserView and its children.
    private FileBrowserView mFileBrowserView;

    public GridLayoutView(Context context, AttributeSet attributeSet, FileBrowserView fileBrowserView) {
        super(context, attributeSet);
        mContext = context;
        mFileBrowserView = fileBrowserView;

    }

    /**
     * Inflates the layout and sets the grid's adapter.
     *
     * @param viewGroup The ViewGroup to inflate the layout into.
     * @return A reference to this view's instance.
     */
    public GridLayoutView init(ViewGroup viewGroup) {
        //Inflate the view from the XML resource.
        View.inflate(mContext, R.layout.simple_grid_file_browser, viewGroup);
        mAbsListView = (GridView) viewGroup.findViewById(R.id.file_browser_grid_view);

        //Display the default dir.
        showDir(mFileBrowserView.getDefaultDirectory());
        return this;
    }

    /**
     * Loads the directory structure of the specified dir and sets the GridView's adapter.
     *
     * @param directory The File object that points to the directory to load.
     */
    @Override
    protected void showDir(File directory) {

        //Call the interface callback method.
        if (mNavigationInterface!=null)
            mNavigationInterface.onNewDirLoaded(directory);

        //Grab the directory's data to feed to the grid adapter.
        AdapterData adapterData = mFileBrowserView.getFileBrowserEngine().loadDir(directory);

        //Check if the user wants to use a custom adapter.
        if (mFileBrowserView.getFileBrowserAdapter()!=null) {
            //The user called setFileBrowserAdapter() and is using a custom adapter.
            mFileBrowserView.getFileBrowserAdapter().setAdapterData(adapterData);

        } else {
            //Nope, no custom adapter, so fall back to the default adapter.
            GridLayoutAdapter adapter = new GridLayoutAdapter(mContext, mFileBrowserView, adapterData);
            mFileBrowserView.setCustomAdapter(adapter);

        }

        //Apply the adapter to the GridView.
        mAbsListView.setAdapter(mFileBrowserView.getFileBrowserAdapter());

        //Apply the click listener to the GridView.
        mAbsListView.setOnItemClickListener(onItemClickListener);

    }

    /**
     * Click listener for the GridView.
     */
    private GridView.OnItemClickListener onItemClickListener = new GridView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            File file = null;
            try {
                String newPath = mFileBrowserView.getFileBrowserAdapter().getPathsList().get(position);
                file = new File(newPath);
                showDir(file);

            } catch (Exception e) {
                e.printStackTrace();

                if (mNavigationInterface!=null)
                    mNavigationInterface.onFileFolderOpenFailed(file);

                //Display an error toast.
                if (file!=null && file.isDirectory()) {
                    Toast.makeText(mContext, R.string.unable_to_load_dir, Toast.LENGTH_SHORT).show();
                } else if (file!=null && !file.isDirectory()) {
                    Toast.makeText(mContext, R.string.unable_to_open_file, Toast.LENGTH_SHORT).show();
                }

            }

        }

    };

}
