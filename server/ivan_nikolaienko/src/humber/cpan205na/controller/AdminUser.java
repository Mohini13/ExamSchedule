package humber.cpan205na.controller;

import java.util.HashMap;

/**
 * Created by ivan on 11/11/15.
 */
public final class AdminUser extends UserClass {

    public AdminUser(String _userName, String _passwd) {
        super(_userName, _passwd);
        defaultProfileId = 1;
        profiles.put( defaultProfileId, new SecurityProfile(defaultProfileId, "Admin"));
    }

    public boolean logout() {
        return false;
    }
}
