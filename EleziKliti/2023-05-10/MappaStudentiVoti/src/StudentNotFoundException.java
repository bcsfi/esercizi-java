public class StudentNotFoundException extends Exception{
    StudentNotFoundException(String error){super(error);}

    public String getMessage(){return "Error, student not found.";}
}
