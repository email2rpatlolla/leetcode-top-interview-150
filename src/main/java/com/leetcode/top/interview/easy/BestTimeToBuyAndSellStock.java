package com.leetcode.top.interview.easy;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        approach1(new int[]{7,1,5,3,6,4});
        approach1(new int[]{7,6,4,3,1});

        betterApproach(new int[]{7,1,5,3,6,4});
        betterApproach(new int[]{7,6,4,3,1});
    }

    private static int betterApproach(int[] prices) {
        var buyPrice = Integer.MAX_VALUE;
        var maxProfit = 0;

        for (int price: prices) {
            buyPrice = Math.min(price, buyPrice);
            maxProfit = Math.max(maxProfit, price - buyPrice);
        }
        System.out.println("Max profit:"+ maxProfit);
        return maxProfit;
    }

    private static int approach1(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            var buyPrice = prices[i];
            var maxPrice = Arrays.stream(prices).skip(i).max().getAsInt();
            maxProfit = Math.max(maxProfit, maxPrice - buyPrice);
        }
        System.out.println("Max profit:"+ maxProfit);
        return maxProfit;
    }
}
