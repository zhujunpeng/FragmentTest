package com.example.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BookDetailFragment extends Fragment{
	
	public static final String ITEM_ID = "item_id";
	// �����Fragment��ʾ��Book����
	BookContent.Book book;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// ���������Fragmentʱ������ITEM_ID����
		if (getArguments().containsKey(ITEM_ID)) {
			book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
		}
	}
	/*
	 * ��д�÷������÷������ص�View����ΪFragment����ʾ���
	 * */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_book_detail, container,false);
		if (book != null) {
			// ��Book_title��ʾ�ı�����Book��title����
			TextView book_title = (TextView) rootView.findViewById(R.id.book_detail);
			book_title.setText(book.title);
			TextView book_desc = (TextView) rootView.findViewById(R.id.book_desc);
			book_desc.setText(book.desc);
		}
		
		return rootView;
	}
}
