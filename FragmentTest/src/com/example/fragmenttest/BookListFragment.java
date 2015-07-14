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
		// ΪListFragment����adapter
		setListAdapter(adapter);
	}
	/***
	 * ��Fragment����ӣ���ʾ��Activity��ʱ���ص��÷���
	 * */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		// ���Activityû�е�Activityʱ���ص��÷���
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("BookListFragment���ڵ�Activityû��ʵ��Callback�ӿ�");
		}
		// �Ѹ�Activity����callback�ӿ�
		mCallbacks = (Callbacks) activity;
	}
	/*
	 * ��Fragment����������Activity�б�ɾ����ʱ����ø÷���
	 * 
	 * */
	@Override
	public void onDetach() {
		super.onDetach();
		
		// ��mCallback��Ϊnull
		mCallbacks = null;
	}
	// ������ĳ�б����ʱ����ø÷���
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// ����mCallback��OnitemSelected����
		mCallbacks.onItemSelected(BookContent.ITEMS.get(position).id);
	}
	
	public void setActivityOnItemClick(boolean activityOnItemClick){
		getListView().setChoiceMode(activityOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
	}
}
