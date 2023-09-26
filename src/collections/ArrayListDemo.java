package collections;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
//		ArrayList  list = new ArrayList();
//		list.add(20);
//		list.add("s");
//		
		//Vector->sync
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(13);
		list.add(130);
		list.add(100);
		list.add(25);
		list.add(13);
	
		System.out.println(list);
		list.remove(0);
		System.out.println(list);

		
		System.out.println(list.get(0));
		System.out.println(list.contains(300));
		System.out.println(list.contains(25));
		
		list.set(0, 200);
		System.out.println(list);
		list.add(0,300);
		System.out.println(list);
		
	}
}
