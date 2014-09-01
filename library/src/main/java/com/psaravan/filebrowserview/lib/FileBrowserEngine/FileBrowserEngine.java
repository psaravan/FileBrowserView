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
package com.psaravan.filebrowserview.lib.FileBrowserEngine;

import android.content.Context;

/**
 * Convenience class that exposes the Android file system and provides a
 * way to browse it via {@link com.psaravan.filebrowserview.lib.View.FileBrowserView}.
 *
 * @author Saravan Pantham
 */
public class FileBrowserEngine {

    //Context.
    private Context mContext;

    public FileBrowserEngine(Context context) {
        mContext = context;
    }

    /**
     * Loads the specified folder.
     *
     * @param path The file path of the directory to load.
     */
    public void loadDir(String path) {

    }

}
