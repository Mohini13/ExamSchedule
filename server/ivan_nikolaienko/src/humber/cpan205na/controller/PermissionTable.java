package humber.cpan205na.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 11/11/15.
 */
public final class PermissionTable {

    private List<ProfileUrl> permissions;

    public PermissionTable() {
        permissions = new ArrayList<>();
        // load data from db into the permissions list
        // permissions = DbAPI.getPermissions();
        setData();
    }

    // _id is a profile id
    public boolean validatePermission(int _id, String _url) {
        boolean result = false;

        if(!permissions.isEmpty()) {
            //result = permissions.containsKey(_id) && permissions.containsValue(_url);
            for(ProfileUrl pfu : permissions) {
                if(pfu.toString().equals(_id + _url)) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    // test only
    private void setData() {
        permissions.add(new ProfileUrl(0, "/exam?action=view"));
        permissions.add(new ProfileUrl(1, "/exam?action=edit"));
        permissions.add(new ProfileUrl(1, "/exam?action=delete"));
        permissions.add(new ProfileUrl(1, "/courses?action=view"));
        permissions.add(new ProfileUrl(1, "/courses?action=edit"));
        permissions.add(new ProfileUrl(1, "/courses?action=delete"));
        permissions.add(new ProfileUrl(1, "/professors?action=view"));
        permissions.add(new ProfileUrl(2, "/professors?action=edit"));
        permissions.add(new ProfileUrl(2, "/professors?action=delete"));
        permissions.add(new ProfileUrl(2, "/professors?action=passwd"));
    }

    // for debug only
    public void displayAllPermissions() {
        System.out.println(getClass().getName() + " has the following content: ");
        // Entry displays only unique values!
        /*for(HashMap.Entry<Integer, String> permission : permissions.entrySet()) {
            System.out.println(permission.getKey() + " " + permission.getValue());
        }*/
        // un only
        //permissions.forEach( (k, v) -> System.out.println(k + " " + v));

        //System.out.println(permissions.size());
        for(ProfileUrl pfu : permissions) {
            System.out.println(pfu.toString());
        }

    }

    // for test only
    public String getRandomUrl() {
        int idx = (int)(Math.random()*permissions.size());
        return ((ProfileUrl)permissions.get(idx)).getUrl();
    }

}
