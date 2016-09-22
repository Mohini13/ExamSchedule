package humber.cpan205na.controller;

/**
 * Created by ivan on 15/11/15.
 *
 * Class store profile information. Different profiles allow different url acces.
 *
 * 0 - public user
 * 1 - admin
 * 2 - super
 *
 */
public final class SecurityProfile {
    private int profileId;
    private String profileName;

    public SecurityProfile(int _id, String _name) {
        profileId = _id;
        profileName = _name;
    }

    public int getProfileId() {
        return profileId;
    }

    public String getProfileName() {
        return profileName;
    }
}
