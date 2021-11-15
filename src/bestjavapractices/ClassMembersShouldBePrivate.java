package bestjavapractices;
/**
 *
 * @author Diego
 */
public class ClassMembersShouldBePrivate {
 /* Rule 4:
    Class Members should be private
    Example:
 */
    public class Student {
        
       private String name;
       private int age;
       
       public void setName(String name){
           if(name == null || name.length()==0){
               throw new IllegalArgumentException("Name cannot be Null or Empty");
           }
           this.name = name;
       }
       
       public void setAge(int age) throws IllegalAccessException{
           if(age < 1 || age > 100){
               throw new IllegalAccessException("Age is Wrong");
           }
           this.age = age;
       }
    }
}
