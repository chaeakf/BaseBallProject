package com.tj.baseballproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tj.baseballproject.R;
import com.tj.baseballproject.datas.Chat;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<Chat> {

    Context mContext;
    List<Chat> mList;
    LayoutInflater inf;

    public ChatAdapter(Context context, List<Chat> list)  {

        super(context, R.layout.chat_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row == null) {

            row = inf.inflate(R.layout.chat_list_item, null);

        }

//        실제 Store데이터를 이용해서 row의 적재적소에 뿌려주기.

        Chat data = mList.get(position);

        FrameLayout userMsgFrameLayout = row.findViewById(R.id.userMsgFameLayout);
        FrameLayout computerMsgFrameLayout = row.findViewById(R.id.computerMsgFameLayout);
        TextView userMessageTxt = row.findViewById(R.id.userMessageTxt);
        TextView computerMessageTxt = row.findViewById(R.id.computerMessageTxt);


        if (data.userSaid) {
            userMsgFrameLayout.setVisibility(View.VISIBLE);
            computerMsgFrameLayout.setVisibility(View.GONE);

            userMessageTxt.setText(data.message);

        }
        else {

            userMsgFrameLayout.setVisibility(View.GONE);
            computerMsgFrameLayout.setVisibility(View.VISIBLE);

            computerMessageTxt.setText(data.message);

        }

        return row;

    }

}
