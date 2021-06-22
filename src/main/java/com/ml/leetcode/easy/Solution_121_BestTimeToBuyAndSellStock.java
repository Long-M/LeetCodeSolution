package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/6/22
 *
 * 给定一个数组prices，它的第i个元素prices[i]表示一支给定股票第i天的价格。
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回0。
 *
 * 这道题的主要思路是在遍历过程中记录全局最小值，并不断更新，保证当前的minPrice是前i天的最低价格，
 * 采用贪心的思想，当前的股票价格大于minPrice时就卖出，并更新最大利润，保证最后的profit是全局最大利润。
 */
public class Solution_121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int profit = 0, minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 当前价格小于最小价格
            if (prices[i] < minPrice) {
                // 更新价格
                minPrice = prices[i];
            } else {
                // 更新最大利润
                profit = Math.max(profit, prices[i] - minPrice);
            }
        }
        return profit;
    }

}
