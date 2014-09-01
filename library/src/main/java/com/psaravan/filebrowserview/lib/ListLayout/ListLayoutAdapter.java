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
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.psaravan.filebrowserview.lib.FileBrowserEngine.AdapterData;
import com.psaravan.filebrowserview.lib.R;

/**
 * Adapter for the ListView layout.
 *
 * @author Saravan Pantham
 */
public class ListLayoutAdapter extends ArrayAdapter<String> {

    //Context.
    private Context mContext;

    //Adapter data.
    private AdapterData mAdapterData;

    public ListLayoutAdapter(Context context, int resource, AdapterData adapterData) {
        super(context, resource);
        mContext = context;
        mAdapterData = adapterData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FoldersViewHolder holder = null;
        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_view_item, parent, false);
            ListView.LayoutParams params = (ListView.LayoutParams) convertView.getLayoutParams();
            params.height = (int) mApp.convertDpToPixels(72.0f, mContext);
            convertView.setLayoutParams(params);

            holder = new FoldersViewHolder();
            holder.fileFolderIcon = (ImageView) convertView.findViewById(R.id.listViewLeftIcon);
            holder.fileFolderSizeText = (TextView) convertView.findViewById(R.id.listViewSubText);
            holder.fileFolderNameText = (TextView) convertView.findViewById(R.id.listViewTitleText);
            holder.overflowButton = (ImageButton) convertView.findViewById(R.id.listViewOverflow);
            holder.rightSubText = (TextView) convertView.findViewById(R.id.listViewRightSubText);

            holder.fileFolderIcon.setScaleX(0.5f);
            holder.fileFolderIcon.setScaleY(0.55f);
            holder.rightSubText.setVisibility(View.INVISIBLE);

            holder.fileFolderNameText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
            holder.fileFolderNameText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));

            holder.fileFolderSizeText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
            holder.fileFolderSizeText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));

            holder.overflowButton.setImageResource(UIElementsHelper.getIcon(mContext, "ic_action_overflow"));
            holder.overflowButton.setFocusable(false);
            holder.overflowButton.setFocusableInTouchMode(false);
            holder.overflowButton.setOnClickListener(overflowClickListener);

            convertView.setTag(holder);
        } else {
            holder = (FoldersViewHolder) convertView.getTag();
        }

        holder.fileFolderNameText.setText(mFileFolderNameList.get(position));
        holder.fileFolderSizeText.setText(mFileFolderSizeList.get(position));

        //Set the icon based on whether the item is a folder or a file.
        if (mFileFolderTypeList.get(position)==FilesFoldersFragment.FOLDER) {
            holder.fileFolderIcon.setImageResource(R.drawable.icon_folderblue);
            convertView.setTag(R.string.folder_list_item_type, FilesFoldersFragment.FOLDER);
            convertView.setTag(R.string.folder_path, mFileFolderPathsList.get(position));
            convertView.setTag(R.string.position, position);

        } else if (mFileFolderTypeList.get(position)==FilesFoldersFragment.AUDIO_FILE) {
            holder.fileFolderIcon.setImageResource(R.drawable.icon_mp3);
            convertView.setTag(R.string.folder_list_item_type, FilesFoldersFragment.AUDIO_FILE);
            convertView.setTag(R.string.folder_path, mFileFolderPathsList.get(position));
            convertView.setTag(R.string.position, position);

        } else if (mFileFolderTypeList.get(position)==FilesFoldersFragment.PICTURE_FILE) {
            holder.fileFolderIcon.setImageResource(R.drawable.icon_png);
            convertView.setTag(R.string.folder_list_item_type, FilesFoldersFragment.PICTURE_FILE);
            convertView.setTag(R.string.folder_path, mFileFolderPathsList.get(position));
            convertView.setTag(R.string.position, position);

        } else if (mFileFolderTypeList.get(position)==FilesFoldersFragment.VIDEO_FILE) {
            holder.fileFolderIcon.setImageResource(R.drawable.icon_avi);
            convertView.setTag(R.string.folder_list_item_type, FilesFoldersFragment.VIDEO_FILE);
            convertView.setTag(R.string.folder_path, mFileFolderPathsList.get(position));
            convertView.setTag(R.string.position, position);

        } else {
            holder.fileFolderIcon.setImageResource(R.drawable.icon_default);
            convertView.setTag(R.string.folder_list_item_type, FilesFoldersFragment.FILE);
            convertView.setTag(R.string.folder_path, mFileFolderPathsList.get(position));
            convertView.setTag(R.string.position, position);

        }

        return convertView;
    }

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
