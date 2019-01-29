package com.example.springbootmongo.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(of={"uuid"})
public class Order implements Serializable {

  private static final long serialVersionUID = 6532303515962349019L;

  private UUID uuid;
  private UUID customerUuid;
  private UUID restaurantUuid;
  private UUID addressUuid;
  private Date confirmedAt;
  private List<Item> items;

}
