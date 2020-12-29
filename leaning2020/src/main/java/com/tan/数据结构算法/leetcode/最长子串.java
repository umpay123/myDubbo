package com.tan.数据结构算法.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/09/18:50
 * @Description:
 */
public class 最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
      if (s.length()<=1){
          return s.length();
      }
      Set set = new HashSet<>();
       int cur=0,res =0;
       int tmp = 0;
      for (int i=0;i<s.length();i++){
          if (i!=0){
             set.remove(s.charAt(i-1));
          }

          while (cur<s.length()&& !set.contains(s.charAt(cur))){
              set.add(s.charAt(cur++));
              tmp++;
          }
          res = Math.max(res,tmp-i);
         // cur = cur+1;
      }
      return res;
    }
}



