package com.example.fragmenttest;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookListFragment extends ListFragment{
	
	private Callbacks mCallbacks;
	public interface Callbacks{
		public void onItemSelected(Integer id);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayAdapter<BookContent.Book> adapter = new ArrayAdapter<BookContent.Book>(getActivity(), 
				android.R.layout.simple_list_item_activated_1,android.R.id.text1,BookContent.ITEMS);
		// 为ListFragment设置adapter
		setListAdapter(adapter);
	}
	/***
	 * 当Fragment被添加，显示到Activity上时，回调该方法
	 * */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		// 如果Activity没有到Activity时，回调该方法
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("BookListFragment所在的Activity没有实现Callback接口");
		}
		// 把该Activity当成callback接口
		mCallbacks = (Callbacks) activity;
	}
	/*
	 * 当Fragment从他所属的Activity中被删除的时候调用该方法
	 * 
	 * */
	@Override
	public void onDetach() {
		super.onDetach();
		
		// 将mCallback设为null
		mCallbacks = null;
	}
	// 当单击某列表项的时候调用该方法
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// 激发mCallback的OnitemSelected方法
		mCallbacks.onItemSelected(BookContent.ITEMS.get(position).id);
	}
	
	public void setActivityOnItemClick(boolean activityOnItemClick){
		getListView().setChoiceMode(activityOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
	}
}
