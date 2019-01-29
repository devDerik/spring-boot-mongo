package com.example.springbootmongo;

import com.example.springbootmongo.menu.Category;

import java.math.BigDecimal;

public class Score {

  private final Category category;
  private final BigDecimal relevance;

  public Score(Category category, BigDecimal relevance) {
    this.category = category;
    this.relevance = relevance;
  }

  @Override
  public String toString() {
    return "Score{" +
        "category=" + category +
        ", relevance=" + relevance +
        '}';
  }
}
