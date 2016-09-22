package humber.cpan205na.controller.dbapi;

import humber.cpan205na.controller.serverapi.Exam;

import java.util.HashMap;

/**
 * Created by ivan on 12/11/15.
 */
public interface IdbExam {

    Exam createExam(int _id, String _name); //throws DBException;
    Exam setExam(int _id, String _name);
    boolean deleteExam(int _id);

    static Exam getExam(int _id) {
        return new Exam();
    }

    static HashMap<Integer, Exam> getExams() { // <id_Exam, Exam object itself>
        return new HashMap<Integer, Exam>();
    }
}
