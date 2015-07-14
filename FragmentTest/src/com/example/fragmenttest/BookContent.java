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
	
	// 使用List集合记录系统所包含的Book对象
	public static List<Book> ITEMS = new ArrayList<Book>();
	// 使用Map集合记录系统所包含的Book对象
	public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, Book>();
	static {
		// 使用静态初始化代码，将Book对象添加到List集合中，map级合格中
		addItem(new Book(1, "数据库。。", "就是一本将数据库的书，感觉还不错哒"));
		addItem(new Book(2, "java", "就是一本将数据库的书，感觉还不错哒"));
		addItem(new Book(3, "ios", "就是一本将数据库的书，感觉还不错哒"));
		addItem(new Book(4, "疯狂android讲义", "疯狂Android讲义讲解详细，很适合提高的时候阅读"));
		addItem(new Book(5, "C++", "就是一本将数据库的书，感觉还不错哒"));
	}
	
	private static void addItem(Book book){
		ITEMS.add(book);
		ITEM_MAP.put(book.id,book);
	}
 }
