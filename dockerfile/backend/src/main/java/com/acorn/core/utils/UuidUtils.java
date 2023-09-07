package com.acorn.core.utils;

import com.fasterxml.uuid.Generators;

public class UuidUtils {

  public static String getUUID() {
    String uuid = String.valueOf(Generators.timeBasedEpochGenerator().generate());
    return uuid.replaceAll("-", "");
  }
  public static int getRandom(int max, int min) {
    double random = Math.random();
    return (int)(random * max) + min;
  }
}
