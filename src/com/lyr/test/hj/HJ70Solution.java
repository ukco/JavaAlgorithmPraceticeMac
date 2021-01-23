package com.lyr.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author lyr
 * @Date 1/18/21 3:15 PM
 * @Version 1.0
 * @Description HJ70. 举证乘法计算量估计
 */
public class HJ70Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int num = Integer.parseInt(str);
            int[][] arr = new int[num][2];
            for (int i = 0; i < num; i++) {
                String[] sa = read.readLine().split(" ");
                arr[i][0] = Integer.parseInt(sa[0]);
                arr[i][1] = Integer.parseInt(sa[1]);
            }
            int n = arr.length - 1;
            char[] ca = read.readLine().toCharArray();
            Stack<Integer> stack = new Stack<>();
            int sum = 0;
            for (int i = ca.length - 1; i >= 0 ; i--) {
                char one = ca[i];
                if (one == ')') { stack.push(-1); }
                else if (one == '(') {
                    // 前一个矩阵
                    int n1 = stack.pop();
                    // 后一个矩阵
                    int n2 = stack.pop();
                    sum += arr[n1][0] * arr[n2][0] * arr[n2][1];
                    // 新矩阵
                    arr[n1][1] = arr[n2][1];
                    // 去掉一个右括号
                    stack.pop();
                    // 将新矩阵压入栈中
                    stack.push(n1);
                } else {
                    // 压入第n个矩阵
                    stack.push(n);
                    n--;
                }
            }
            System.out.println(sum);
        }
    }
}
