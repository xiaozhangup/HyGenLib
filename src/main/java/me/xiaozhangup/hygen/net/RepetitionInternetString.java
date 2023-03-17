package me.xiaozhangup.hygen.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class RepetitionInternetString {

    String url;
    String holder;

    public RepetitionInternetString(String url, String holder) {
        this.url = url;
        this.holder = holder;
    }

    public String getUrl() {
        return this.url;
    }

    public Optional<String> request(String place) {
        var request = this.url.replace(this.holder, place);
        InternetString internetString = new InternetString(request);
        return internetString.request();
    }

}
