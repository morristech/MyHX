package com.yiw.circledemo2.widgets.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.viewpagerdemo.ui.MyApplication;
import com.xingkesi.foodapp.R;
import com.yiw.circledemo2.bean.ChildBean;
import com.yiw.circledemo2.bean.ChildBean;
import com.yiw.circledemo2.mvp.presenter.CirclePresenter;

/**
 * 
* @ClassName: CommentDialog 
* @Description: 评论长按对话框，保护复制和删除 
* @author yiw
* @date 2015-12-28 下午3:36:39 
*
 */
public class ChildCommentDialog extends Dialog implements
		View.OnClickListener {

	private Context mContext;
	private CirclePresenter mPresenter;
	private ChildBean mCommentItem;
	private int mCirclePosition;

	public ChildCommentDialog(Context context, CirclePresenter presenter,
							  ChildBean commentItem, int circlePosition) {
		super(context, R.style.comment_dialog);
		mContext = context;
		this.mPresenter = presenter;
		this.mCommentItem = commentItem;
		this.mCirclePosition = circlePosition;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_comment);
		initWindowParams();
		initView();
	}

	private void initWindowParams() {
		Window dialogWindow = getWindow();
		// 获取屏幕宽、高用
		WindowManager wm = (WindowManager) mContext
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		lp.width = (int) (display.getWidth() * 0.65); // 宽度设置为屏幕的0.65

		dialogWindow.setGravity(Gravity.CENTER);
		dialogWindow.setAttributes(lp);
	}

	private void initView() {
		TextView copyTv = (TextView) findViewById(R.id.copyTv);
		copyTv.setOnClickListener(this);
		TextView deleteTv = (TextView) findViewById(R.id.deleteTv);
		if (mCommentItem != null
				&&String.valueOf( MyApplication.getInstan().getUser().getData().getId()).equals(
						mCommentItem.getUser().getId())) {
			deleteTv.setVisibility(View.VISIBLE);
		} else {
			deleteTv.setVisibility(View.GONE);
		}
		deleteTv.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.copyTv:
			if (mCommentItem != null) {
				ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
				clipboard.setText(mCommentItem.getContent());
			}
			dismiss();
			break;
		case R.id.deleteTv:
			if (mPresenter != null && mCommentItem != null) {
				mPresenter.deleteComment(mCirclePosition, mCommentItem.getId()+"");
			}
			dismiss();
			break;
		default:
			break;
		}
	}

}
