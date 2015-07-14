package com.example.fragmenttest;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class SelectBookActivity extends Activity implements BookListFragment.Callbacks{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_twopane);
		
		
	}

	// 实现callback接口实现的方法
	@Override
	public void onItemSelected(Integer id) {
		
		// 创建Bundle，准备向Fragment传入参数
		Bundle argument = new Bundle();
		argument.putInt(BookDetailFragment.ITEM_ID, id);
		// 创建BookdetailFragment对象
		BookDetailFragment fragment = new BookDetailFragment();
		// 向Fragment传入参数
		fragment.setArguments(argument);
		// 使用Fragment替换book_detail_container容器当前显示Fragment
		getFragmentManager().beginTransaction().replace(R.id.book_detail_container, fragment).commit();
//		Fragment newFragment = new example
//		FragmentTransaction transaction = getFragmentManager().beginTransaction();
//		transaction.replace(R.id.book_detail_container, fragment);
//		transaction.addToBackStack(null);
//		transaction.commit();
	}

}
