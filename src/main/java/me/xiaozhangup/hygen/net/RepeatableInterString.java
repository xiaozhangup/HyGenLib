package me.xiaozhangup.hygen.net;

import java.util.Optional;

public class RepeatableInterString {

    String url;
    String holder;

    public RepeatableInterString(String url, String holder) {
        this.url = url;
        this.holder = holder;
    }

    public String getUrl() {
        return this.url;
    }

    public Optional<String> request(String place) {
        var request = this.url.replace(this.holder, place);
        InterString internetString = new InterString(request);
        return internetString.request();
    }

}
