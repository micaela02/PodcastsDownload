package podcastsData;

import java.util.List;

public class PodcastDownload {

    private DownloadIdentifier downloadIdentifier;
    private List<Opportunity> opportunities;
    private int agency;
    private String deviceType;
    private String country;
    private String city;
    private String listenerId;

    public PodcastDownload() {

    }

    public PodcastDownload(DownloadIdentifier downloadIdentifier, List<Opportunity> opportunities, int agency, String deviceType, String country, String city, String listenerId) {
        this.downloadIdentifier = downloadIdentifier;
        this.opportunities = opportunities;
        this.agency = agency;
        this.deviceType = deviceType;
        this.country = country;
        this.city = city;
        this.listenerId = listenerId;
    }

    public podcastsData.DownloadIdentifier getDownloadIdentifier() {
        return downloadIdentifier;
    }

    public void setDownloadIdentifier(DownloadIdentifier downloadIdentifier) {
        this.downloadIdentifier = downloadIdentifier;
    }

    public List<podcastsData.Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getListenerId() {
        return listenerId;
    }

    public void setListenerId(String listenerId) {
        this.listenerId = listenerId;
    }
}
