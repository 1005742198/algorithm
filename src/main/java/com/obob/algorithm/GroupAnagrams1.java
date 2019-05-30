package com.obob.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams1 {
	
	/**
	 * 字母异位词分组
	 * 思路：将每个单词按照字典升序排序（如：key变成eky）进行分组
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs) {
        	char[] arr = str.toCharArray();
        	Arrays.sort(arr);
        	String key = String.valueOf(arr);
        	if(!map.containsKey(key)) {
        		map.put(key, new ArrayList<String>());
        	}
        	map.get(key).add(str);
        }
        
		return new ArrayList<List<String>>(map.values());
    }
	
	
	public static void main(String[] args) {
		GroupAnagrams1 test = new GroupAnagrams1();
		String [] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(test.groupAnagrams(strs));
	}
}
