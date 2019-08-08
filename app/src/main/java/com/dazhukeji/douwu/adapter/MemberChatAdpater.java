package com.dazhukeji.douwu.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dazhukeji.douwu.R;

import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.callback.GetUserInfoCallback;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.UserInfo;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/11/28 10:36
 * 功能描述：
 */
public class MemberChatAdpater extends BaseQuickAdapter<Conversation,BaseViewHolder> {
    public MemberChatAdpater(int layoutResId, @Nullable List<Conversation> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Conversation item) {
        JMessageClient.getUserInfo(item.getTargetId(), item.getTargetAppKey(), new GetUserInfoCallback() {
            @Override
            public void gotResult(int i, String s, UserInfo userInfo) {
                helper.setText(R.id.nameTv,userInfo.getUserName());
            }
        });
            helper.setText(R.id.contentTv,item.getLatestText());
    }
}
