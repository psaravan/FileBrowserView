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
import android.widget.AbsListView;

/**
 * The base layout that is extended by {@link com.psaravan.filebrowserview.lib.ListLayout.ListLayoutView}
 * and {@link com.psaravan.filebrowserview.lib.GridLayout.GridLayoutView}.
 *
 * @author Saravan Pantham
 */
public abstract class BaseLayoutView extends View {

    /**
     * The ListView/GridView that displays the file system.
     */
    protected AbsListView mAbsListView;

    /**
     * Default constructor.
     */
    public BaseLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /**
     * @return The ListView/GridView that displays the file system.
     */
    public AbsListView getAbsListView() {
        return mAbsListView;
    }

}
