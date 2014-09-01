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
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import com.psaravan.filebrowserview.lib.R;

/**
 * List layout view implementation for the file browser.
 *
 * @author Saravan Pantham
 */
public class ListLayoutView extends View {

    //Context.
    private Context mContext;

    //The view and its children.
    private ListLayoutView mView;
    private ListView mListView;

    public ListLayoutView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ListLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public ListLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    /**
     * Inflates the layout and
     *
     * @return A reference to this view's instance.
     */
    public ListLayoutView init() {
        //Inflate the view from the XML resource.
        mView = (ListLayoutView) inflate(mContext, R.layout.simple_list_file_browser, null);
        mListView = (ListView) mView.findViewById(R.id.file_browser_list_view);


        return mView;
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
