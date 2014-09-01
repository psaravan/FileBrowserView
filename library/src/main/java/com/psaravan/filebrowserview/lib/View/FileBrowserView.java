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
package com.psaravan.filebrowserview.lib.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.psaravan.filebrowserview.lib.GridLayout.GridLayoutView;
import com.psaravan.filebrowserview.lib.ListLayout.ListLayoutView;

/**
 * Base View class for the library.
 *
 * @author Saravan Pantham
 */
public class FileBrowserView extends View {

    //Context.
    private Context mContext;

    //Current layout type selection/view reference.
    private int mFileBrowserLayoutType = FILE_BROWSER_LIST_LAYOUT;
    private View mFileBrowserLayout;

    //Layout type constants.
    public static final int FILE_BROWSER_LIST_LAYOUT = 0;
    public static final int FILE_BROWSER_GRID_LAYOUT = 1;

    public FileBrowserView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public FileBrowserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public FileBrowserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    /**
     * Initialize the file browser view and set it up for use.
     */
    private void init() {
        //Inflate the view's layout based on the selected layout.
        if (getFileBrowserLayoutType()==FILE_BROWSER_LIST_LAYOUT)
            mFileBrowserLayout = new ListLayoutView(mContext).init();
        else
            mFileBrowserLayout = new GridLayoutView(mContext).init();



    }

    /**
     * Sets the layout type (list or grid) of this FileBrowserView instance.
     *
     * @param layoutType Use one of the following two options: {@link #FILE_BROWSER_LIST_LAYOUT} or
     *                   {@link #FILE_BROWSER_GRID_LAYOUT}.
     */
    public void setFileBrowserLayoutType(int layoutType) {
        mFileBrowserLayoutType = layoutType;
    }

    public int getFileBrowserLayoutType() {
        return mFileBrowserLayoutType;
    }

}
