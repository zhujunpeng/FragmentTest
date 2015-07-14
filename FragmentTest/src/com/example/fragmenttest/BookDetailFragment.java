package com.example.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BookDetailFragment extends Fragment{
	
	public static final String ITEM_ID = "item_id";
	// 保存改Fragment显示的Book对象
	BookContent.Book book;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 如果启动改Fragment时包含了ITEM_ID参数
		if (getArguments().containsKey(ITEM_ID)) {
			book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
		}
	}
	/*
	 * 重写该方法，该方法返回的View将作为Fragment的显示组件
	 * */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_book_detail, container,false);
		if (book != null) {
			// 让Book_title显示文本框中Book的title属性
			TextView book_title = (TextView) rootView.findViewById(R.id.book_detail);
			book_title.setText(book.title);
			TextView book_desc = (TextView) rootView.findViewById(R.id.book_desc);
			book_desc.setText(book.desc);
		}
		
		return rootView;
	}
}
