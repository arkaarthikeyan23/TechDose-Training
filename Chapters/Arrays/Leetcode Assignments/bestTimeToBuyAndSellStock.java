public class bestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit=0;
        for(int i=1; i<prices.length; i++){
            int currProfit = prices[i]-minPrice;
            maxProfit = Math.max(maxProfit,currProfit);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}
