package humber.cpan205na.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

/**
 * Created by ivan on 11/11/15.
 */
public abstract class UserClass {

    protected int userId;
    protected String userName;
    protected String passwd;
    protected int defaultProfileId;
    // Integer is a profile id, SecurityProfile is an object itself
    protected HashMap<Integer, SecurityProfile> profiles; // static ? and implement public enum Profile = {PUBLIC, ADMIN, SUPER};

    // by default all users have Public permission 0
    protected UserClass(String _name){
        //userId = _userId; // enable later
        userName = _name;
        passwd = generatePasswordHash(""); // just an empty password to satisfy login() method
        initializeData();
    }

    // this constructor is used by AdminUser and SuperUser
    protected UserClass(String _name, String _pass) {
        userName = _name;
        passwd = generatePasswordHash(_pass);
        initializeData();
    }

    protected void initializeData() {
        profiles = new HashMap<>();
        defaultProfileId = 0;
        profiles.put( defaultProfileId, new SecurityProfile(defaultProfileId, "Public") );
    }

    public boolean validatePermission(PermissionTable _permTab, String _url) {
        boolean result = false;

        int profileId = 0;

        // check all profiles if the first profile has permission to the url then stop and grant permission
        for(HashMap.Entry<Integer, SecurityProfile> profile : profiles.entrySet()) {
            profileId =  profile.getKey();
            if( _permTab.validatePermission(profileId, _url) ) {
                result = true;
                break;
            }
        }

        return result;
    }

    protected int getId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswd() {
        return passwd;
    }

    protected HashMap<Integer, SecurityProfile> getProfiles() {
        return profiles;
    }

    protected void setProfiles(HashMap<Integer, SecurityProfile> _profiles) {
        profiles = _profiles;
    }

    public String toString() {
        String result = userName;

        result += " [";
        for(HashMap.Entry<Integer, SecurityProfile> profile : profiles.entrySet()) {
            result += " " + profile.getKey() + " " + ((SecurityProfile)profile.getValue()).getProfileName();
        }
        result += "]";

        return result;
    }

    protected String generatePasswordHash (String _plainPasswd) {
        String result = "k38djk29-k28_k328dak38jk89b92aJhn*3";

        try {
            result = PasswdClass.generateStorngPasswordHash(_plainPasswd);
        }catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }catch (InvalidKeySpecException e2) {
            e2.printStackTrace();
        }


        return result;
    }

    // verify new and stored passwords
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

}
