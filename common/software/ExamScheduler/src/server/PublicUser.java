package server;

/**
 * Created by ivan on 11/11/15.
 */
public final class PublicUser extends UserClass {

    public PublicUser(int _userId, String _userName) {
        super(_userId, _userName);
    }

    // for public user login is always valid (true)
    @Override
    public boolean login(String _passwdToVerify) { return true; }
}
