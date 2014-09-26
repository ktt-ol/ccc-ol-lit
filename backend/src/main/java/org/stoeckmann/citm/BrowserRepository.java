package org.stoeckmann.citm;

import java.util.HashMap;
import java.util.Map;

import net.sf.uadetector.ReadableUserAgent;

public class BrowserRepository {
  private static final Map<String, Browser> MAPPING = new HashMap<>();

  static {
    MAPPING.put("Apple Inc.", Browser.safari);
    MAPPING.put("Google", Browser.chrome);
    MAPPING.put("Google Inc.", Browser.chrome);
    MAPPING.put("Google Inc. and contributors", Browser.chrome);
    MAPPING.put("Microsoft", Browser.internetexplorer);
    MAPPING.put("Microsoft Corporation", Browser.internetexplorer);
    MAPPING.put("Mozilla Foundation", Browser.firefox);
    MAPPING.put("Mozilla Labs", Browser.firefox);
    MAPPING.put("Netscape Communications Corp.", Browser.firefox);
    MAPPING.put("SAMSUNG", Browser.chrome);
    MAPPING.put("Samsung", Browser.chrome);
  }

  public static Browser getBrowser(ReadableUserAgent agent) {
    return MAPPING.getOrDefault(agent.getProducer(), Browser.unknown);
  }
}
