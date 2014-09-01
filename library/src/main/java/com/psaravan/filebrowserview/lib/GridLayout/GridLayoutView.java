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
import android.view.View;
import android.widget.GridView;

import com.psaravan.filebrowserview.lib.View.FileBrowserView;

/**
 * Grid layout view implementation for the file browser.
 *
 * @author Saravan Pantham
 */
public class GridLayoutView extends View {

    //Context.
    private Context mContext;

    //Parent file browser view.
    private FileBrowserView mFileBrowserView;

    //View children.
    private GridView mGridView;

    public GridLayoutView(Context context, FileBrowserView fileBrowserView) {
        super(context);
        mContext = context;
        mFileBrowserView = fileBrowserView;
        init();
    }

    /**
     * Inflates the grid layout and initializes each individual View child.
     *
     * @return An reference to this view's instance.
     */
    public GridLayoutView init() {

        return this;
    }

}
