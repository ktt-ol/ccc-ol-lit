package org.stoeckmann.citm;

import java.util.HashMap;
import java.util.Map;

import org.stoeckmann.citm.format.OperatingSystem;

import net.sf.uadetector.ReadableUserAgent;

public class OperatingSystemRepository {
  private static final Map<String, OperatingSystem> MAPPING = new HashMap<>();

  static {
    MAPPING.put("Android", OperatingSystem.android);
    MAPPING.put("Linux", OperatingSystem.linux);
    MAPPING.put("Mac OS", OperatingSystem.macos);
    MAPPING.put("OS X", OperatingSystem.macos);
    MAPPING.put("Windows", OperatingSystem.windows);
    MAPPING.put("iOS", OperatingSystem.ios);
  }

  public static OperatingSystem getOperatingSystem(ReadableUserAgent agent) {
    return MAPPING.getOrDefault(agent.getOperatingSystem().getFamilyName(), OperatingSystem.unknown);
  }
}
