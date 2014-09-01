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
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;

import com.psaravan.filebrowserview.lib.FileBrowserEngine.FileBrowserEngine;
import com.psaravan.filebrowserview.lib.GridLayout.GridLayoutView;
import com.psaravan.filebrowserview.lib.ListLayout.ListLayoutView;

import java.io.IOException;

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

    //File browser engine.
    private FileBrowserEngine mFileBrowserEngine;

    //Default directory to display.
    private String mDefaultDir;

    //Flag to show/hide hidden files.
    private boolean mShowHiddenFiles = false;

    //Layout type constants.
    public static final int FILE_BROWSER_LIST_LAYOUT = 0;
    public static final int FILE_BROWSER_GRID_LAYOUT = 1;

    public FileBrowserView(Context context) {
        super(context);
        mContext = context;

        try {
            mDefaultDir = Environment.getExternalStorageDirectory().getCanonicalPath().toString();
        } catch (IOException e) {
            e.printStackTrace();
            mDefaultDir = "/";
        }

    }

    public FileBrowserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        try {
            mDefaultDir = Environment.getExternalStorageDirectory().getCanonicalPath().toString();
        } catch (IOException e) {
            e.printStackTrace();
            mDefaultDir = "/";
        }

    }

    public FileBrowserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

        try {
            mDefaultDir = Environment.getExternalStorageDirectory().getCanonicalPath().toString();
        } catch (IOException e) {
            e.printStackTrace();
            mDefaultDir = "/";
        }

    }

    /**
     * Initializes the file browser view and fires it up for first use. Must be called to
     * properly display the file browser.
     */
    public void init() {

        //Initialize the file browser engine for this view instance.
        mFileBrowserEngine = new FileBrowserEngine(mContext, this);

        //Inflate the view's layout based on the selected layout.
        if (getFileBrowserLayoutType()==FILE_BROWSER_LIST_LAYOUT)
            mFileBrowserLayout = new ListLayoutView(mContext, this).init();
        else
            mFileBrowserLayout = new GridLayoutView(mContext, this).init();



    }

    /**
     * Sets the default directory to show when the FileBrowserView is initialized.
     *
     * @param directoryPath The path of the directory to display.
     *
     * @return An instance of this FileBrowserView to allow method chaining.
     */
    public FileBrowserView setDefaultDirectory(String directoryPath) {
        mDefaultDir = directoryPath;
        return this;
    }

    /**
     * Sets the layout type (list or grid) of this FileBrowserView instance.
     *
     * @param layoutType Use one of the following two options: {@link #FILE_BROWSER_LIST_LAYOUT} or
     *                   {@link #FILE_BROWSER_GRID_LAYOUT}.
     *
     * @return An instance of this FileBrowserView to allow method chaining.
     */
    public FileBrowserView setFileBrowserLayoutType(int layoutType) {
        mFileBrowserLayoutType = layoutType;
        return this;
    }

    /**
     * Sets whether hidden files should be shown or not.
     *
     * @param show Specifies whether hidden files should be shown or not.
     *
     * @return An instance of this FileBrowserView to allow method chaining.
     */
    public FileBrowserView showHiddenFiles(boolean show) {
        mShowHiddenFiles = show;
        return this;
    }

    /**
     * @return The current layout type for this FileBrowserView instance.
     */
    public int getFileBrowserLayoutType() {
        return mFileBrowserLayoutType;
    }

    /**
     * @return The default directory that is displayed for this FileBrowserView instance.
     */
    public String getDefaultDirectory() {
        return mDefaultDir;
    }

    /**
     * @return Whether or not hidden files/folders should be displayed.
     */
    public boolean shouldShowHiddenFiles() {
        return mShowHiddenFiles;
    }

    /**
     * @return The file browser engine instance for this view.
     */
    public FileBrowserEngine getFileBrowserEngine() {
        return mFileBrowserEngine;
    }

}
