package com.excelr.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//@entity creates table so remove this annotation for POJO
@Data
@AllArgsConstructor
public class JwtRequest {
  private String username;
  private String password;
}
