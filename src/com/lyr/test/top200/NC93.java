package com.lyr.test.top200;

import java.util.*;

/**
 * @Author lyr
 * @Date 3/26/21 9:24 PM
 * @Version 1.0
 * @Description NC93. 设计LRU缓存结构
 */
public class NC93 {
    public int[] LRU(int[][] operators, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> list = new LinkedList<>();

        for (int[] operator : operators) {
            int key = operator[1];
            switch (operator[0]) {
                case 1:
                    int value = operator[2];
                    if (map.size() < k) { map.put(key, value); }
                    else {
                        Iterator iterator = map.keySet().iterator();
                        map.remove(iterator.next());
                        map.put(key, value);
                    }
                    break;
                case 2:
                    if (map.containsKey(key)) {
                        int val = map.get(key);
                        list.add(val);
                        map.remove(key);
                        map.put(key, val);
                    } else { list.add(-1); }
                    break;
                default:
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new NC93().LRU(new int[][] {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}}, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
