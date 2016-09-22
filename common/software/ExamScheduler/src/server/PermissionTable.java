package server;

import java.util.*;

/**
 * Created by ivan on 11/11/15.
 *
 * This class stores a Map of url and SecurityProfile list
 *
 */
public final class PermissionTable {

    private HashMap<String, List<SecurityProfile> > urlPermissions;

    public PermissionTable() {
        urlPermissions = new HashMap<>();
        // load data from db into the permissions list
        // permissions = DbAPI.getPermissions();
        setData();
    }
    
    public PermissionTable(HashMap<String, List<SecurityProfile> >_urlPermissions) {
        urlPermissions = _urlPermissions;
    }

    public boolean validatePermission(String _url, UserClass _user) {
        boolean result = false;

        HashMap<Integer, SecurityProfile> securityProfilesForUser = _user.getProfiles();
        List<SecurityProfile> securityProfilesForUrl = urlPermissions.get(_url);

        for(SecurityProfile sp : securityProfilesForUrl) {
            if( securityProfilesForUser.containsKey(sp.getProfileId()) ) {
                result = true;
                break;
            }
        }

        return result;
    }

    // test only
    private void setData() {

        // everyone has permission to view an exam schedule
        urlPermissions.put("/exam?action=view", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(0, "PUBLIC") );
                add(new SecurityProfile(1, "ADMIN") );
                add(new SecurityProfile(2, "SUPER") );
            }
        } );

        // only admin and super can edit exam schedule
        urlPermissions.put("/exam?action=edit", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(1, "ADMIN") );
                add(new SecurityProfile(2, "SUPER") );
            }
        } );

        urlPermissions.put("/exam?action=delete", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(2, "SUPER") );
            }
        } );

        urlPermissions.put("/exam?action=edit", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(1, "ADMIN") );
                add(new SecurityProfile(2, "SUPER") );
            }
        } );

        urlPermissions.put("/courses?action=view", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(1, "ADMIN") );
                add(new SecurityProfile(2, "SUPER") );
            }
        } );


        urlPermissions.put("/courses?action=edit", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(1, "ADMIN") );
                add(new SecurityProfile(2, "SUPER") );
            }
        } );

        urlPermissions.put("/courses?action=delete", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(1, "ADMIN") );
                add(new SecurityProfile(2, "SUPER") );
            }
        } );

        urlPermissions.put("/professors?action=view", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(1, "ADMIN") );
                add(new SecurityProfile(2, "SUPER") );
            }
        } );

        urlPermissions.put("/professors?action=edit", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(2, "SUPER") );
            }
        } );

        urlPermissions.put("/professors?action=delete", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(2, "SUPER") );
            }
        } );

        urlPermissions.put("/professors?action=passwd", new ArrayList<SecurityProfile>(){
            {
                add(new SecurityProfile(2, "SUPER") );
            }
        } );

    }

    // for debug only
    public void displayAllPermissions() {
        System.out.println(getClass().getName() + " has the following content: ");

        System.out.println(urlPermissions);

        // Entry displays only unique values!
        /*for(HashMap.Entry<Integer, String> permission : permissions.entrySet()) {
            System.out.println(permission.getKey() + " " + permission.getValue());
        }*/
        // un only
        //permissions.forEach( (k, v) -> System.out.println(k + " " + v));

        //System.out.println(permissions.size());
        /*for(ProfileUrl pfu : permissions) {
            System.out.println(pfu.toString());
        }*/

    }

    // for test only
    public String getRandomUrl() {
        String result = "";

        Object[] urls = urlPermissions.keySet().toArray();

        int idx = (int)(Math.random() * urls.length);

        return (String)urls[ idx ];
    }

}
