package podcastsData;

import java.util.Map;

public class Opportunity {

    private long originalEventTime;
    private int maxDuration;
    private Map<String, Zone> zones;
    private PositionUrlSegments positionUrlSegments;
    private int insertionRate;

    public Opportunity() {

    }

    public Opportunity(long originalEventTime, int maxDuration, Map<String, Zone> zones, PositionUrlSegments positionUrlSegments, int insertionRate) {
        this.originalEventTime = originalEventTime;
        this.maxDuration = maxDuration;
        this.zones = zones;
        this.positionUrlSegments = positionUrlSegments;
        this.insertionRate = insertionRate;
    }

    public long getOriginalEventTime() {
        return originalEventTime;
    }

    public void setOriginalEventTime(long originalEventTime) {
        this.originalEventTime = originalEventTime;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Map<String, Zone> getZones() {
        return zones;
    }

    public void setZones(Map<String, Zone> zones) {
        this.zones = zones;
    }

    public PositionUrlSegments getPositionUrlSegments() {
        return positionUrlSegments;
    }

    public void setPositionUrlSegments(PositionUrlSegments positionUrlSegments) {
        this.positionUrlSegments = positionUrlSegments;
    }

    public int getInsertionRate() {
        return insertionRate;
    }

    public void setInsertionRate(int insertionRate) {
        this.insertionRate = insertionRate;
    }
}