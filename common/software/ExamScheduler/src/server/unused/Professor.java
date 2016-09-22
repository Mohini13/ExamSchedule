package server.unused;

import server.AdminUser;


/**
 * Created by ivan on 12/11/15.
 */

// UserClass should be used instead!
public final class Professor {
	public static AdminUser getNewProfessor(int _userId, String name, String password){
		return new AdminUser(_userId, name, password);
	}
}
