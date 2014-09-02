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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.psaravan.filebrowserview.lib.FileBrowserEngine.AdapterData;
import com.psaravan.filebrowserview.lib.FileBrowserEngine.FileBrowserEngine;
import com.psaravan.filebrowserview.lib.R;
import com.psaravan.filebrowserview.lib.Utils.Utils;
import com.psaravan.filebrowserview.lib.View.AbstractFileBrowserAdapter;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;

/**
 * Adapter for the ListView layout.
 *
 * @author Saravan Pantham
 */
public class ListLayoutAdapter extends AbstractFileBrowserAdapter {

    public ListLayoutAdapter(Context context, FileBrowserView fileBrowserView,
                             AdapterData adapterData) {
        super(context, fileBrowserView, adapterData.getNamesList());
        mContext = context;
        mAdapterData = adapterData;
        mFileBrowserView = fileBrowserView;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FoldersViewHolder holder = null;
        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_view_item, parent, false);
            ListView.LayoutParams params = (ListView.LayoutParams) convertView.getLayoutParams();
            params.height = (int) Utils.convertDpToPixels(72.0f, mContext);
            convertView.setLayoutParams(params);

            holder = new FoldersViewHolder();
            holder.fileFolderIcon = (ImageView) convertView.findViewById(R.id.listViewLeftIcon);
            holder.fileFolderSizeText = (TextView) convertView.findViewById(R.id.listViewSubText);
            holder.fileFolderNameText = (TextView) convertView.findViewById(R.id.listViewTitleText);
            holder.overflowButton = (ImageButton) convertView.findViewById(R.id.listViewOverflow);
            holder.rightSubText = (TextView) convertView.findViewById(R.id.listViewRightSubText);
            holder.rightSubText.setVisibility(View.INVISIBLE);

            //Show/hide any UI elements based on the user's preferences.
            if (!mFileBrowserView.shouldShowItemSizes()) {
                //Hide the item size TextViews.
                ((View) holder.fileFolderSizeText.getParent()).setVisibility(View.GONE);
                RelativeLayout.LayoutParams titleParams = (RelativeLayout.LayoutParams)
                        holder.fileFolderNameText.getLayoutParams();
                titleParams.addRule(RelativeLayout.CENTER_VERTICAL);
                holder.fileFolderNameText.setLayoutParams(titleParams);
            }

            if (!mFileBrowserView.shouldShowOverflowMenus()) {
                //Hide the overflow menus.
                holder.overflowButton.setVisibility(View.GONE);
            } else {
                holder.overflowButton.setImageResource(R.drawable.ic_action_overflow_universal);
                holder.overflowButton.setFocusable(false);
                holder.overflowButton.setFocusableInTouchMode(false);
                holder.overflowButton.setOnClickListener(overflowClickListener);

            }

            convertView.setTag(holder);
        } else {
            holder = (FoldersViewHolder) convertView.getTag();
        }

        holder.fileFolderNameText.setText(getNamesList().get(position));
        holder.fileFolderSizeText.setText(getSizesList().get(position));

        /*
         * Set the icon based on whether the item is a folder or a file.
         * Also make sure to set the type of the item as a tag for this
         * row.
         */
        if (getTypesList().get(position)==FileBrowserEngine.FOLDER) {
            holder.fileFolderIcon.setImageResource(R.drawable.icon_folderblue);
            convertView.setTag(R.string.type, FileBrowserEngine.FOLDER);

        } else if (getTypesList().get(position)==FileBrowserEngine.FILE_AUDIO) {
            holder.fileFolderIcon.setImageResource(R.drawable.icon_mp3);
            convertView.setTag(R.string.type, FileBrowserEngine.FILE_AUDIO);

        } else if (getTypesList().get(position)==FileBrowserEngine.FILE_PICTURE) {
            holder.fileFolderIcon.setImageResource(R.drawable.icon_png);
            convertView.setTag(R.string.type, FileBrowserEngine.FILE_PICTURE);

        } else if (getTypesList().get(position)==FileBrowserEngine.FILE_VIDEO) {
            holder.fileFolderIcon.setImageResource(R.drawable.icon_avi);
            convertView.setTag(R.string.type, FileBrowserEngine.FILE_VIDEO);

        } else {
            holder.fileFolderIcon.setImageResource(R.drawable.icon_default);
            convertView.setTag(R.string.type, FileBrowserEngine.FILE_GENERIC);

        }

        /* Save the path and position of the file/folder as this row's tag(s).
         * You MUST do this or the click listener for the list/grid view will not
         * work.
         */
        convertView.setTag(R.string.path, getPathsList().get(position));
        convertView.setTag(R.string.position, position);

        return convertView;
    }

    @Override
    public void onOverflowClick(View overflowView) {
        //TODO auto-generated method stub.
    }

    private View.OnClickListener overflowClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            onOverflowClick(view);
        }

    };

    /**
     * Holder class for the ListView layout.
     */
    static class FoldersViewHolder {
        public TextView fileFolderNameText;
        public TextView fileFolderSizeText;
        public ImageView fileFolderIcon;
        public ImageButton overflowButton;
        public TextView rightSubText;

    }

}
