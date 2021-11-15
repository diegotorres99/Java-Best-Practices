/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestjavapractices;

import java.util.List;

/**
 *
 * @author Diego 
 * Ordering Class members by scopes, example in the next class
 * StudentManager
 */
public class OrderingClassMembersByScopes {

    public class StudentManager {

        private String errorMessage;
        private long numberOfColumns;
        private long numberOfRows;

        float columnWidth;
        float rowHeight;

        protected String[] columnNames;
        protected List<H2DataBase.Student> listStudents;

        public long numberOfStudents;
        public String title;
    }
}
