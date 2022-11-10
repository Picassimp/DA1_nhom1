package com.example.da1.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.da1.R;
import com.example.da1.Views.HomeActivity;
import com.example.da1.Views.QuizCreationActivity;

import java.util.ArrayList;
import java.util.List;

public class ChooseSubjectAdapter extends BaseAdapter {

    private ArrayList<String> list;
    private Context context;

    public ChooseSubjectAdapter(ArrayList<String> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int _i, View _view, ViewGroup _viewGroup) {
        View view = _view;

        if(view == null) {
            view = View.inflate(_viewGroup.getContext(), R.layout.custom_subject_item, null);
            TextView tv_subjectItem_tenmon = view.findViewById(R.id.tv_subjectItem_tenmon);

            ViewHolder viewHolder = new ViewHolder(tv_subjectItem_tenmon);
            view.setTag(viewHolder);
        }

        String subName = (String) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tv_subjectItem_tenmon.setText(subName);
        return view;
    }

    private static class ViewHolder{
        private final TextView tv_subjectItem_tenmon;
        public ViewHolder(TextView tv_subjectItem_tenmon){
            this.tv_subjectItem_tenmon = tv_subjectItem_tenmon;

        }
    }
}
