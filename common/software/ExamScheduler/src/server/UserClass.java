package server;

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
    protected String firstName;
    protected String lastName;
    
    // by default all users have Public permission 0
    protected UserClass(int _userId, String _userName){
        userId = _userId;
        userName = _userName;
        passwd = generatePasswordHash(""); // just an empty password to satisfy login() method
        initializeData();
    }

    // this constructor is used by AdminUser and SuperUser
    protected UserClass(int _userId, String _userName, String _pass) {
        userId = _userId;
        userName = _userName;
        passwd = generatePasswordHash(_pass);
        initializeData();
    }
    
    protected UserClass(int _userId, String _userName, String _pass, String _firstName, String _lastName) {
        userId = _userId;
        userName = _userName;
        passwd = generatePasswordHash(_pass);
        initializeData();
        firstName = _firstName;
        lastName = _lastName;
    }

    protected void initializeData() {
        profiles = new HashMap<>();
        defaultProfileId = 0;
        profiles.put( defaultProfileId, new SecurityProfile(defaultProfileId, "Public") );
    }


    public boolean validatePermission(PermissionTable _permTab, String _url) {
        return _permTab.validatePermission(_url, this);
    }

    public int getId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setUserId(int _userId) {
        userId = _userId;
    }


    // public ?
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
            result += " " + profile.getKey() + " " + profile.getValue().getProfileName();
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

    // to verify new and stored passwords
    public abstract boolean login(String _passwdToVerify);

}
