package quiz20200403;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MoreRecursion 
{
	public static int destructiveSum(List<Integer> list) 
	{
		if (list.isEmpty()) return 0;
		int x = list.get(0);
		list.remove(0);
		return x + destructiveSum(list);
	}

	public static <T> List<T> copy(List<T> list) {
		List<T> retList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			retList.add(list.get(i));
		return retList;	
	}

	public static <T> List<T> copy(List<T> list, int from, int to) {
		List<T> retList = new ArrayList<>();
		for(int i = from; i < to; i++)
			retList.add(list.get(i));
		return retList;
	}

	public static int sum(List<Integer> list) {
		if (list.isEmpty())
			return 0;
		List<Integer> list1 = copy(list, 1, list.size());
		return sum(list1) + list.get(0);
	}
	
	public static <T> List<List<T>> sublistsIncEmpty(List<T> list) {
		List<List<T>> emptyList = new ArrayList<>();
		List<T> listT = new ArrayList<>();
		emptyList.add(listT);
		if (list == null)
			return null;
		if (list.isEmpty())
			return emptyList;
		T x = list.get(list.size()-1);
		List<List<T>> returnList = sublistsIncEmpty(copy(list, 0, list.size()-1));
		List<List<T>> tempList = new ArrayList<>();
		for(List<T> e : returnList) {
			List<T> temp = copy(e);
			temp.add(x);
			tempList.add(temp);
		}
		returnList.addAll(tempList);
		return returnList;
	}

	public static <T> List<List<List<T>>> partitions(List<T> list) {
		if (list.isEmpty())
			return new ArrayList<>();
		if (list.size() == 1) {
			List<List<T>> list1 = new ArrayList<>();
			list1.add(list);
			List<List<List<T>>> list2 = new ArrayList<>();
			list2.add(list1);
			return list2;
		}
		var smaller = copy(list, 0, list.size()-1);
		T end = list.get(list.size()-1);
		List<T> endList = new ArrayList<>();
		endList.add(end);
		var recursiveList = partitions(smaller);
		List<List<List<T>>> returnList = new ArrayList<>();
		for (List<List<T>> elem : recursiveList) {
			List<List<T>> elem1 = copy(elem);
			elem1.add(endList);
			returnList.add(elem1);
		}
		for (List<List<T>> elem : recursiveList) {
			List<T> elem1 = copy(elem.get(elem.size()-1));
			elem1.add(end);
			elem.set(elem.size()-1, elem1);
			returnList.add(elem);
		}
		return returnList;
	}
	
	public static void main(String[] args) 
	{
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		System.out.println("List: " + list);
		System.out.println("DestructiveSum returns: " + destructiveSum(list));
		System.out.println("List is now: " + list);
		System.out.println("DestructiveSum now returns: " + destructiveSum(list));

		List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		System.out.println("List: " + list1);
		System.out.println("Sum returns: " + sum(list1));
		System.out.println("List is now: " + list1);
		System.out.println("Sum now returns: " + sum(list1));

		System.out.println(sublistsIncEmpty(list1));
		
		list = new ArrayList<>(Arrays.asList(1,7,2,9));
		System.out.println(partitions(list));
	}
}