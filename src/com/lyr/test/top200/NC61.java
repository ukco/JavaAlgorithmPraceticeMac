package com.lyr.test.top200;

import java.util.HashMap;

/**
 * @Author lyr
 * @Date 3/22/21 11:56 PM
 * @Version 1.0
 * @Description NC61. 两数之和
 */
public class NC61 {
    public int[] twoSum (int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}
