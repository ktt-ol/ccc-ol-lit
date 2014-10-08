package org.stoeckmann.citm.domain;

import java.util.HashMap;
import java.util.Map;

import org.stoeckmann.citm.domain.format.Machine;

import net.sf.uadetector.ReadableUserAgent;

public class MachineRepository {
  private static final Map<String, Machine> MAPPING = new HashMap<>();

  static {
    MAPPING.put("Personal computer", Machine.laptop);
    MAPPING.put("Smartphone", Machine.android);
    MAPPING.put("Tablet", Machine.android);
    MAPPING.put("PDA", Machine.android);
    MAPPING.put("Wearable computer", Machine.android);
  }

  public static Machine getMachine(ReadableUserAgent agent) {
    return MAPPING.getOrDefault(agent.getDeviceCategory().getName(), Machine.unknown);
  }
}
