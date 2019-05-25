package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        boolean result = versionHistoryMap.containsKey(rollbackVersion);
        if (result) {
            for (int i = 1; i <= versionHistoryMap.size(); i++) {
                versionHistoryMap.remove(rollbackVersion+i);
            }
            currentVersion = rollbackVersion;
        }

        return result;
    }
}
