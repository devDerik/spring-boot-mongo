package com.example.springbootmongo.menu;

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
@EqualsAndHashCode(of={"uuid"})
public class Menu implements Serializable {
  private static final long serialVersionUID = -4184644171877667025L;

  private UUID uuid;
  private Category category;
  private BigDecimal unitPrice;
}
