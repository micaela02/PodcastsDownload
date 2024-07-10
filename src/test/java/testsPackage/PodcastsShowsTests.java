package testsPackage;

import org.junit.Before;
import org.junit.Test;
import podcastsData.PodcastDownload;
import utilies.PodcastDownloadReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PodcastsShowsTests {

    private PodcastDownloadReader podcastDownloadReader;

    @Before
    public void setUp() {
        podcastDownloadReader = new PodcastDownloadReader();
    }

    public List<PodcastDownload> readThroughPodcastsDownloadFile() throws IOException {
        final String jsonFilePath = "src/test/resources/podcastDownload.json";
        return podcastDownloadReader.podcastsDownloadParser(jsonFilePath);
    }


    /*
    3. Calculeaza si printeaza care este emisiunea de podcast (aceasta este identificata
    prin showId) cea mai ascultata (cea cu cele mai multe download-uri) din San Francisco
    precum si numarul de download-uri asociat acestei emisiuni.
     */


    @Test
    public void podcastShowWithTheMostDownloadsFromCityTest() throws IOException {

        Map<String, Long> downloadCountsFromCity = readThroughPodcastsDownloadFile().stream()
                .filter(podcastDownload -> "san francisco".equals(podcastDownload.getCity()))
                .collect(Collectors.groupingBy(podcastDownload -> podcastDownload.getDownloadIdentifier().getShowId(), Collectors.counting()));

        Map.Entry<String, Long> mostListenedShowFromCity = downloadCountsFromCity.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (mostListenedShowFromCity != null) {
            System.out.println("Most popular show is: " + mostListenedShowFromCity.getKey());
            System.out.println("Number of downloads is " + mostListenedShowFromCity.getValue());
        } else {
            System.out.println("No podcast shows were found for San Francisco!");
        }
    }

    /*
    Calculeaza si printeaza care este device-ul (aceasta este identificat prin deviceType;
    eg. desktops & laptops, mobiles & tablets, smart speakers, digital appliances)
    cel mai folosit pentru a asculta podcast-uri precum si numarul de download-uri
    asociat acestui device.
     */


    @Test
    public void podcastShowDownloadedOnDeviceTest() throws IOException {

        Map<String, Long> downloadCountsOnDevice = readThroughPodcastsDownloadFile().stream()
                .collect(Collectors.groupingBy(PodcastDownload::getDeviceType, Collectors.counting()));

        Map.Entry<String, Long> mostUsedDeviceToListenToPodcasts = downloadCountsOnDevice.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (mostUsedDeviceToListenToPodcasts != null) {
            System.out.println("Most popular device is: " + mostUsedDeviceToListenToPodcasts.getKey());
            System.out.println("Number of downloads is " + mostUsedDeviceToListenToPodcasts.getValue());
        } else {
            System.out.println("No podcast shows were downloaded on any device!");
        }
    }

    /*
    5. Calculeaza si printeaza cate oportunitati de a insera o reclama in preroll au existat pentru
     fiecare emisiune de podcast. Printeaza aceasta informatie in ordinea descrescatoare a numarului de
     oportunitati. Asta se traduce tehnic in: pentru fiecare showId, care este numarul de oportunitati
     care contin in lista aw_0_ais.adBreakIndex valoarea preroll.
     */

    @Test
    public void opportunitiesToInsertCommercialInPrerollTest() throws IOException {

        Map<String, Long> numberOfPrerollOpportunities = readThroughPodcastsDownloadFile().stream()
                .collect(Collectors.groupingBy(
                        podcastDownload -> podcastDownload.getDownloadIdentifier().getShowId(),
                        Collectors.flatMapping(podcastDownload -> podcastDownload.getOpportunities()
                                .stream().filter(opportunity -> opportunity.getPositionUrlSegments()
                                        .getAdBreakIndex().contains("preroll")), Collectors.counting())
                ));

        numberOfPrerollOpportunities.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> {
                    System.out.println("Show Id: " + entry.getKey() + " Preroll Opportunity Number: "
                            + entry.getValue());
                });
    }
}