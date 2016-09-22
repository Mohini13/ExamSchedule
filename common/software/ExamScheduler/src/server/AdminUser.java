package server;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

/**
 * Created by ivan on 11/11/15.
 */
public final class AdminUser extends UserClass {

    public AdminUser(int _userId, String _userName, String _passwd) {
        super(_userId, _userName, _passwd);
        defaultProfileId = 1;
        profiles.put( defaultProfileId, new SecurityProfile(defaultProfileId, "Admin"));
    }
    
    public AdminUser(int _userId, String _userName, String _passwd, String _firstName, String _lastName) {
        super(_userId, _userName, _passwd, _firstName, _lastName);
        defaultProfileId = 1;
        profiles.put( defaultProfileId, new SecurityProfile(defaultProfileId, "Admin"));
    }

    @Override
    public boolean login(String _passwdToVerify) {
        boolean result = false;

        try{
            result = PasswdClass.validatePassword (_passwdToVerify, this.passwd);
        }catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }catch (InvalidKeySpecException e2) {
            e2.printStackTrace();
        }

        return result;
    }

    public boolean logout() {
        // unlock used objects and remove from session table
        return false;
    }

}
