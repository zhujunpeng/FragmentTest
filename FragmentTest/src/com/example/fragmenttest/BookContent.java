package com.example.fragmenttest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ClipData.Item;

public class BookContent {

	public static class Book {
		public int id;
		public String title;
		public String desc;
		public Book(int id, String title, String desc) {
			super();
			this.id = id;
			this.title = title;
			this.desc = desc;
		}
		@Override
		public String toString() {
			return title;
		}
	}
	
	// ʹ��List���ϼ�¼ϵͳ��������Book����
	public static List<Book> ITEMS = new ArrayList<Book>();
	// ʹ��Map���ϼ�¼ϵͳ��������Book����
	public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, Book>();
	static {
		// ʹ�þ�̬��ʼ�����룬��Book������ӵ�List�����У�map���ϸ���
		addItem(new Book(1, "���ݿ⡣��", "����һ�������ݿ���飬�о���������"));
		addItem(new Book(2, "java", "����һ�������ݿ���飬�о���������"));
		addItem(new Book(3, "ios", "����һ�������ݿ���飬�о���������"));
		addItem(new Book(4, "���android����", "���Android���彲����ϸ�����ʺ���ߵ�ʱ���Ķ�"));
		addItem(new Book(5, "C++", "����һ�������ݿ���飬�о���������"));
	}
	
	private static void addItem(Book book){
		ITEMS.add(book);
		ITEM_MAP.put(book.id,book);
	}
 }
