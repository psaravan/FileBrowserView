package com.psaravan.filebrowserview.lib.ViewGroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Base View class for the library.
 *
 * @author Saravan Pantham
 */
public class FileBrowserView extends View {

    private Context mContext;

    public FileBrowserView(Context context) {
        super(context);
        mContext = context;
    }

    public FileBrowserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public FileBrowserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

}
