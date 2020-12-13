package com.lyr;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(new Main().Probability(4));
    }

    /**
     * 掷硬币
     * @param n
     * @return
     */
    public String Probability (int n) {
        // write code here
        if (n <= 0) { return "0.00"; }
        double p = 1 / 2.0;
        double ret = 1.0D;
        for (int i = 0; i < n; i++) { ret = ret * p; }
        ret = ret * 2;
        String rets = String.valueOf(ret);
        char[] retsc = rets.toCharArray();
        if (retsc.length <= 4) {
            if (retsc.length == 3) { return rets + '0';}
            else { return rets; }
        }
        else {
            if (retsc[4] <= '4') {
                return rets.substring(0,4);
            }
            else {
                if (retsc[3] == '9') {
                    retsc[3] = '0';
                    if (retsc[2] == '9') {
                        retsc[2] = '0';
                        retsc[0] = '1';
                    } else {
                        retsc[2]++;
                    }
                } else {
                    retsc[3]++;
                }
                return String.valueOf(retsc, 0, 4);
            }
        }
    }
}
