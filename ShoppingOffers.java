public class Solution {
    public int shoppingOffers(List<Integer> itemPrices, List<List<Integer>> specialOffers, List<Integer> requiredItems) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return findMinimumCost(itemPrices, specialOffers, requiredItems, memo);
    }

    public int findMinimumCost(List<Integer> itemPrices, List<List<Integer>> specialOffers, List<Integer> requiredItems, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(requiredItems))
            return memo.get(requiredItems);
        
        int i = 0, minCost = calculateTotalCost(requiredItems, itemPrices);
        for (List<Integer> offer : specialOffers) {
            ArrayList<Integer> remainingItems = new ArrayList<>(requiredItems);
            for (i = 0; i < requiredItems.size(); i++) {
                int remainingAmount = remainingItems.get(i) - offer.get(i);
                if (remainingAmount < 0)
                    break;
                remainingItems.set(i, remainingAmount);
            }
            if (i == requiredItems.size())
                minCost = Math.min(minCost, offer.get(i) + findMinimumCost(itemPrices, specialOffers, remainingItems, memo));
        }
        memo.put(requiredItems, minCost);
        return minCost;
    }

    public int calculateTotalCost(List<Integer> items, List<Integer> prices) {
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i) * prices.get(i);
        }
        return total;
    }
}
