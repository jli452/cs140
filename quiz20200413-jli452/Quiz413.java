package quiz20200413;

import java.util.ArrayList;
import java.util.List;

public class Quiz413 {
	public static List<String> substrings(String str) {
		List<String> retList = new ArrayList<>();
		if (str == null)
			return null;
		if (str.isEmpty()) {
			retList.add("");
			return retList;
		}
		List<String> list = substrings(str.substring(1));
		for (int i = 0; i < list.size(); i++) {
			String temp = str.charAt(0) + list.get(i);
			retList.add(temp);
		}
		retList.addAll(list);
		return retList;
	}
	
	public static List<String> substrings2(String str) {
		List<String> retList = new ArrayList<>();
		if (str == null)
			return null;
		if (str.isEmpty()) {
			retList.add("");
			return retList;
		}
		List<String> list = substrings(str.substring(1));
		for (int i = 0; i < list.size(); i++) {
			String temp = str.charAt(0) + list.get(i);
			retList.add(temp);
		}
		for (int i = 0; i < list.size(); i++) {
			if (!retList.contains(list.get(i)))
				retList.add(list.get(i));
		}
		return retList;
	}
	
	public static void main(String[] args) {
		System.out.println(substrings(null));
		System.out.println(substrings(""));
		System.out.println(substrings(" "));
		System.out.println(substrings("rum"));
		System.out.println(substrings("ooze"));
		
		System.out.println(substrings2(null));
		System.out.println(substrings2(""));
		System.out.println(substrings2(" "));
		System.out.println(substrings2("rum"));
		System.out.println(substrings2("ooze"));
	}
}
