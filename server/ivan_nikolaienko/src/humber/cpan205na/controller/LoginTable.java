package humber.cpan205na.controller;

import java.util.HashMap;

/**
 * Created by ivan on 18/11/15.
 */
public final class LoginTable {
    // this table will store <session_id, userName>.

    private HashMap<Integer, String> loggedInUsers;

    public LoginTable(){
        loggedInUsers = new HashMap<>();
    }

    public void addUser(int _session_id, String _userName) {
        loggedInUsers.put(_session_id, _userName);
    }

    public String getUserNameBySessionId(int _id) {
        String result = null;

        if(!loggedInUsers.isEmpty()) {
            result = loggedInUsers.get(_id);
        }

        return result;
    }

    public int getSessionIdByUserName(String _name) {
        int result = -1;

        if(!loggedInUsers.isEmpty()) {
            for(HashMap.Entry<Integer, String> session_user : loggedInUsers.entrySet()) {
                if(session_user.getValue().equals(_name)) {
                    result = session_user.getKey();
                    break;
                }
            }
        }

        return result;
    }


}
