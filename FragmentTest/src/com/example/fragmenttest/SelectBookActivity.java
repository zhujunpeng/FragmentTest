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

	// ʵ��callback�ӿ�ʵ�ֵķ���
	@Override
	public void onItemSelected(Integer id) {
		
		// ����Bundle��׼����Fragment�������
		Bundle argument = new Bundle();
		argument.putInt(BookDetailFragment.ITEM_ID, id);
		// ����BookdetailFragment����
		BookDetailFragment fragment = new BookDetailFragment();
		// ��Fragment�������
		fragment.setArguments(argument);
		// ʹ��Fragment�滻book_detail_container������ǰ��ʾFragment
		getFragmentManager().beginTransaction().replace(R.id.book_detail_container, fragment).commit();
//		Fragment newFragment = new example
//		FragmentTransaction transaction = getFragmentManager().beginTransaction();
//		transaction.replace(R.id.book_detail_container, fragment);
//		transaction.addToBackStack(null);
//		transaction.commit();
	}

}
