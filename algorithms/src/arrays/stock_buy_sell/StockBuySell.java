class Tuple<X, Y>{
    public X x;
    public Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}

public class StockBuySell {
    
    public static Tuple<Integer, Integer> findBuySellStockPrices(int[] stockPrices){
        Tuple<Integer, Integer> tuple = new Tuple<>(-1, -1);
        if(stockPrices == null || stockPrices.length < 2){
            return tuple;
        }

        int currentProfit = Integer.MIN_VALUE;
        int currentBuy = stockPrices[0];
        int globalSell = stockPrices[1];
        int globalProfit = globalSell - currentBuy;

        for (int i = 1; i < stockPrices.length; i++) {
            currentProfit = stockPrices[i] - currentBuy;
            if(currentProfit > globalProfit){
                globalProfit = currentProfit;
                globalSell = stockPrices[i];
            }
            if(stockPrices[i] < currentBuy){
                currentBuy = stockPrices[i];
            }
        }

         tuple.x = globalSell- globalProfit; tuple.y = globalSell;
         return tuple;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        Tuple result = null;
        result = findBuySellStockPrices(array);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

        int[] array2 = {8, 6, 5, 4, 3, 2, 1};
        result = findBuySellStockPrices(array2);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));
    }
}
