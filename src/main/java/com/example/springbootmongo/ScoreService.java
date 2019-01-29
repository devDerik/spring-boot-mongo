package com.example.springbootmongo;

import com.example.springbootmongo.menu.Category;
import com.example.springbootmongo.order.Item;
import com.example.springbootmongo.order.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreService {

  private static final int BIG_DECIMAL_SCALE = 9;

  //  Relevance = SQRT(IQ*IP*10000)
  //
  //  Whereas:
  //  IQ = (Menu Item Quantity in Order)/(Total Items Quantity in Order)
  //  IP = (Total Menu Item Price in Order)/(Total Order Price)
  public void calculateScore(Order order) {

    final List<Item> items = order.getItems();
    final BigDecimal totalItemQuantity =
        BigDecimal.valueOf(items.stream().mapToInt(Item::getQuantity).sum());
    final BigDecimal totalOrderPrice = BigDecimal.valueOf(
        items.stream().mapToDouble(item -> item.getQuantity() * item.getMenuUnitPrice().doubleValue()).sum());
    System.out.println("total item quantity " + totalItemQuantity);
    System.out.println("total order price " + totalOrderPrice);

    final List<Score> score = new ArrayList<>();
    final Map<Category, List<Item>> itemsPerCategory =
        items.stream().collect(Collectors.groupingBy(Item::getMenuCategory));
    itemsPerCategory.forEach((category, itemsOfCategory) -> {
      System.out.println("Category " + category);
      final BigDecimal itemQuantity = BigDecimal.valueOf(
          itemsOfCategory.stream().mapToDouble(Item::getQuantity).sum());
      final BigDecimal totalItemPrice = BigDecimal.valueOf(itemsOfCategory.stream()
          .mapToDouble(item -> item.getQuantity() * item.getMenuUnitPrice().doubleValue())
          .sum());
      final BigDecimal iQ = divide(itemQuantity, totalItemQuantity);
      System.out.println("IQ " + iQ);
      final BigDecimal iP = divide(totalItemPrice, totalOrderPrice);
      System.out.println("IP " + iP);
      score.add(new Score(category, calculateRelevance(iQ, iP)));
    });
    System.out.println(score);
  }

  private BigDecimal calculateRelevance(BigDecimal iQ, BigDecimal iP) {
    return BigDecimal.valueOf(
        Math.sqrt(iQ.multiply(iP).multiply(BigDecimal.valueOf(10000)).doubleValue()))
        .setScale(BIG_DECIMAL_SCALE, RoundingMode.HALF_UP);
  }

  private BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
    return dividend.divide(divisor, BIG_DECIMAL_SCALE, RoundingMode.HALF_UP);
  }
}
