package com.obob.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	/**
	 * 字母异位词分组
	 * 思路：将每个单词按照字典升序排序（如：key变成eky）进行分组
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs) {
        	//使用快速排序进行排序
        	String key = sortStr(str);
        	if(map.containsKey(key)) {
        		List<String> list = map.get(key);
        		list.add(str);
        	}else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(key, list);
			}
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        for(String key: map.keySet()) {
        	res.add(map.get(key));
        }
		
		return res;
    }
	
	//快排进行排序
	public String sortStr(String str) {
		if(str == null || str == "") {
			return null;
		}
		char[] arr = str.toCharArray();
		quickSort(arr, 0, arr.length-1);
		return new String(arr);
	}
	
	//快排
	public void quickSort(char[] arr, int start, int end) {
		if(start >= end) {
			return ;
		}
		int left = start, right = end;
		//选取基准值(left)
		char temp = arr[left];
		while(left < right) {
			//从右往左，找到比基准值小的，填到基准值的坑1(arr[left])里
			while(left< right && arr[right] >= temp) {
				right--;
			}
			arr[left] = arr[right];
			//从左往右，找到比基准值大的，填到基准值的坑2(arr[right])里
			while(left<right && arr[left]<=temp) {
				left++;
			}
			arr[right] = arr[left];
		}
		//将基准值填到坑3里
		arr[left] = temp;
		//此时，一遍已完成，开始递归基准值左右子集
		quickSort(arr, start, left-1);
		quickSort(arr, left+1, end);
		
	}
	
	public static void main(String[] args) {
		GroupAnagrams test = new GroupAnagrams();
		String [] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(test.groupAnagrams(strs));
	}
}
