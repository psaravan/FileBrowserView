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
package com.psaravan.filebrowserview.lib.ListLayout;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.psaravan.filebrowserview.lib.FileBrowserEngine.AdapterData;
import com.psaravan.filebrowserview.lib.R;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;

/**
 * List layout view implementation for the file browser.
 *
 * @author Saravan Pantham
 */
public class ListLayoutView extends View {

    //Context.
    private Context mContext;

    //Parent FileBrowserView and its children.
    private FileBrowserView mFileBrowserView;
    private ListView mListView;

    public ListLayoutView(Context context, FileBrowserView fileBrowserView) {
        super(context);
        mContext = context;
        mFileBrowserView = fileBrowserView;
        init();
    }

    /**
     * Inflates the layout and sets the list's adapter.
     */
    public ListLayoutView init() {
        //Inflate the view from the XML resource.
        View.inflate(mContext, R.layout.simple_list_file_browser, mFileBrowserView);
        mListView = (ListView) mFileBrowserView.findViewById(R.id.file_browser_list_view);

        //Display the default dir.
        showDir(mFileBrowserView.getDefaultDirectory());
        return this;
    }

    /**
     * Loads the directory structure of the specified dir and sets the ListView's adapter.
     *
     * @param directoryPath The path of the directory to show.
     */
    private void showDir(String directoryPath) {
        //Grab the directory's data to feed to the list adapter.
        AdapterData adapterData = mFileBrowserView.getFileBrowserEngine().loadDir(directoryPath);

        //Check if the user wants to use a custom adapter.
        if (mFileBrowserView.getFileBrowserAdapter()!=null) {
            //The user called setFileBrowserAdapter() and is using a custom adapter.
            mFileBrowserView.getFileBrowserAdapter().setAdapterData(adapterData);

        } else {
            //Nope, no custom adapter, so fall back to the default adapter.
            ListLayoutAdapter adapter = new ListLayoutAdapter(mContext, adapterData);
            mFileBrowserView.setFileBrowserAdapter(adapter);

        }

        //Apply the adapter to the ListView.
        mListView.setAdapter(mFileBrowserView.getFileBrowserAdapter());

    }

    /**
     * Use this method to customize/modify the ListView used by FileBrowserView.
     *
     * @return The ListView instance used by this FileBrowserView.
     */
    public ListView getListView() {
        return mListView;
    }

}
