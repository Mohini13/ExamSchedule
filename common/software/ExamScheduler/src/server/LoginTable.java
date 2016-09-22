package server;

import java.util.HashMap;

/**
 * Created by ivan on 18/11/15.
 */
public final class LoginTable {
    // this table will store <session_id, UserClass>.

    private HashMap<Integer, UserClass> loggedInUsers;

    public LoginTable(){
        loggedInUsers = new HashMap<>();
    }

    public void addUser(int _session_id, UserClass _user) {
        loggedInUsers.put(_session_id, _user);
    }

    // test it
    public boolean delUser(UserClass _user) {
        boolean result = false;

        if(!loggedInUsers.isEmpty()) {
            loggedInUsers.remove(_user); // should it be done by key?
        }

        return result;
    }

    public UserClass getUserNameBySessionId(int _session_id) {
        UserClass result = null;

        if(!loggedInUsers.isEmpty()) {
            result = loggedInUsers.get(_session_id);
        }

        return result;
    }
/*
    public int getSessionIdByUser(UserClass _user) throws UserNotFoundException {
        int result = -1;

        if(!loggedInUsers.isEmpty()) {
            for(HashMap.Entry<Integer, UserClass> session_user : loggedInUsers.entrySet()) {
                if(session_user.getValue().equals(_user)) {
                    result = session_user.getKey();
                    break;
                }
            }
        }

        if(result == -1) throw new UserNotFoundException();

        return result;
    }
*/

}
