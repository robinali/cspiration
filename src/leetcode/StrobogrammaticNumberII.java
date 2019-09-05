package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : StrobogrammaticNumberII
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 247. Strobogrammatic Number II
 */
public class StrobogrammaticNumberII {
    /**
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

     Find all strobogrammatic numbers that are of length = n.

     For example,
     Given n = 2, return ["11","69","88","96"].

     n = 3 :  ["101","609","808","906","111","619","818","916","181","689","888","986"]


     time : O(n^2) 不确定
     space : O(n)

     * @param n
     * @return
     */
    
    public List<String> findStrobogrammatic0(int n) {
        if(n == 0) return new ArrayList(Arrays.asList(""));
        
        List<String>[] dp = new List[n + 1];
        for(int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add("");
        dp[1].add("0");
        dp[1].add("1");
        dp[1].add("8");
        
        int i = n % 2 == 0 ? 0 : 1;
        while(i != n) {
            for(String str : dp[i]) {
                if(i + 2 != n) {
                    dp[i + 2].add("0" + str + "0");
                }
                dp[i + 2].add("1" + str + "1");
                dp[i + 2].add("6" + str + "9");
                dp[i + 2].add("8" + str + "8");
                dp[i + 2].add("9" + str + "6");
            }
            i += 2;
        }
        return dp[n];
    }
    
    
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    public List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}
