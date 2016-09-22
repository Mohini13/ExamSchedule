package humber.cpan205na.model;

import java.util.ArrayList;


/**
 * Created by ivan on 15/11/15.
 */
public class NnListCheck {

    // this is just for test
    public NnListCheck(){
        ArrayList<String> steps = new ArrayList<>();
        steps.add("chop");
        steps.add("stir");
        steps.add("wipe");
        steps.add("boil");

        int idx = (int)(Math.random() * steps.size());
        steps.set(idx, null);

        for( String st : steps) {
            //if(st != null)
                System.out.println( st );
        }
    }
}
