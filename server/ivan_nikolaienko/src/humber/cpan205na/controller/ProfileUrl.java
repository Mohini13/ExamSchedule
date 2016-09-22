package humber.cpan205na.controller;

/**
 * Created by ivan on 16/11/15.
 *
 * This class holds a pair of profile id and url
 *
 */
public final class ProfileUrl {
    private int profileId;
    private String url;

    public ProfileUrl(int _profileId, String _url) {
        profileId = _profileId;
        url = _url;
    }

    public String getUrl(){
        return url;
    }

    @Override
    public String toString() {
        return profileId + url;
    }
}
