package com.yiw.circledemo2.mvp.view;

import com.yiw.circledemo2.bean.ChildBean;
import com.yiw.circledemo2.bean.CommentConfig;
import com.yiw.circledemo2.bean.ListBean;
import com.yiw.circledemo2.bean.RecordListBean;
import com.yiw.circledemo2.bean.ZanListBean;

import java.util.List;

/**
 * 
* @ClassName: ICircleViewUpdateListener 
* @Description: view,服务器响应后更新界面 
* @author yiw
* @date 2015-12-28 下午4:13:04 
*
 */
public interface ICircleView extends BaseView{

	public void update2DeleteCircle(String circleId);
	public void update2AddFavorite(int circlePosition, ZanListBean addItem);
	public void update2DeleteFavort(int circlePosition, String favortId);
	public void update2AddComment(int circlePosition, int circlePos, RecordListBean addItem, ChildBean childBean);
	public void update2DeleteComment(int circlePosition, String commentId);

	public void updateEditTextBodyVisible(int visibility, CommentConfig commentConfig);

	void update2loadData(int loadType, List<ListBean> datas);


}


