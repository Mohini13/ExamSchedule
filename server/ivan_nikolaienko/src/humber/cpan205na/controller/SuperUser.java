package humber.cpan205na.controller;

/**
 * Created by ivan on 11/11/15.
 */
public final class SuperUser extends UserClass {

    public SuperUser(String _userName, String _passwd) {
        super(_userName, _passwd);
        defaultProfileId = 2;
        profiles.put( defaultProfileId, new SecurityProfile(defaultProfileId, "Super") );
        profiles.put( 1, new SecurityProfile(1, "Admin") );
    }

}
