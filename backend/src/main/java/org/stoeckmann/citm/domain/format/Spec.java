package org.stoeckmann.citm.domain.format;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 Spec:
 {
 machine: <int>, (Samsung, IPhone, Laptop, Smatphone) -> Geraetetyp
 0: unknown
 1: iphone
 2: android
 3: Laptop
 4: MacBook
 os: <int>, (iOS, Android, Windows, ...) 
 0: unknown
 1: windows
 2: linux
 3: IOS
 4: macos
 5: android
 browser: [<int>,<int>]
 0: unknown
 1: FF
 2: Chrome
 3: IE
 4: Safari
 browser-history: [
 "http://......",
 "......"
 ],
 adMap: [
 "google": [ urls....]
 ]
 email: <string>, (Adresse)
 }
 */
public class Spec {
    private int machine;
    private int os;
    private Collection<Integer> browser;
    private Collection<String> browserHistory = new TreeSet<>();
    private Map<String, Collection<String>> adMap = new TreeMap<>();;
    private String eMail;

    public int getMachine() {
        return machine;
    }

    public void setMachine(int machine) {
        this.machine = machine;
    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public Collection<Integer> getBrowser() {
        return browser;
    }

    public void setBrowser(Collection<Integer> browser) {
        this.browser = browser;
    }

    public Collection<String> getBrowserHistory() {
        return browserHistory;
    }

    public void setBrowserHistory(Collection<String> browserHistory) {
        this.browserHistory = browserHistory;
    }

    public Map<String, Collection<String>> getAdMap() {
        return adMap;
    }

    public void setAdMap(Map<String, Collection<String>> adMap) {
        this.adMap = adMap;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
