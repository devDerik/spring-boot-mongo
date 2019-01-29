package com.example.springbootmongo.order;

import com.example.springbootmongo.menu.Category;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(of={"quantity", "menuUuid"})
public class Item implements Serializable {
  private static final long serialVersionUID = 4164408761280047513L;

  private Integer quantity;
  private UUID menuUuid;
  private BigDecimal menuUnitPrice;
  private Category menuCategory;

}
