package com.psaravan.filebrowserview.demo.MainActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.psaravan.filebrowserview.demo.R;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;


public class MainActivity extends ActionBarActivity {

    //Context.
    private Context mContext;

    //FileBrowserView reference.
    private FileBrowserView mFileBrowserView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();

        //Grab a reference handle on the view, just like you'd do with any other view.
        mFileBrowserView = (FileBrowserView) findViewById(R.id.fileBrowserView);

        //Customize the view.
        mFileBrowserView.setFileBrowserLayoutType(FileBrowserView.FILE_BROWSER_LIST_LAYOUT) //Set the type of view to use.
                        .setDefaultDirectory("/") //Set the default directory to show.
                        .setShowHiddenFiles(true) //Set whether or not you want to show hidden files.
                        .init(); //Loads the view. You MUST call this method, or the view will not be displayed.

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
