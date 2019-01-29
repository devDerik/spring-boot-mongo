package com.example.springbootmongo;

import com.example.springbootmongo.order.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ScoreServiceTest {

  @Test
  public void calculateScoreTest() throws Exception {
    final byte[] jsonBytes = Files.readAllBytes(
        Paths.get(ScoreServiceTest.class.getClassLoader().getResource("order.json").toURI()));

    Order order = new ObjectMapper().readValue(jsonBytes, Order.class);
    System.out.println(order);
    new ScoreService().calculateScore(order);
  }
}
