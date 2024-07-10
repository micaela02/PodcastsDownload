package utilies;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import podcastsData.PodcastDownload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PodcastDownloadReader {

    public PodcastDownloadReader() {

    }

    public List<PodcastDownload> podcastsDownloadParser(String filePath) throws IOException {

        String jsonStr = new String(Files.readAllBytes(Paths.get(filePath)));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, new TypeReference<>() {
        });
    }
}