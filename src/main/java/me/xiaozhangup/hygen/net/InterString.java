package me.xiaozhangup.hygen.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class InterString {

    String url;

    public InterString(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public InterString placeholder(String old, String place) {
        return new InterString(this.url.replace(old, place));
    }

    public Optional<String> request() {
        try {
            URL url = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(500);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream inputStream = conn.getInputStream();
            return Optional.of(readInputStream(inputStream));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private String readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toString(StandardCharsets.UTF_8);
    }

}
