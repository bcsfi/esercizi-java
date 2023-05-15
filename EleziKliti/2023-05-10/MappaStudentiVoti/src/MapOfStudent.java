import java.util.HashMap;
import java.util.Map;

public class MapOfStudent {
    Map<String, Double> mapOfStudent = new HashMap<>();


    public boolean addStudent(String name, double vote){
        if(this.mapOfStudent.containsKey(name)){
            return false;
        }

        this.mapOfStudent.put(name, vote);
        return true;

    }

    public Double recoverStudentVoteByName(String name) throws StudentNotFoundException{
        if(this.mapOfStudent.get(name) == null){
            throw new StudentNotFoundException("Error");
        }
        return this.mapOfStudent.get(name);
    }

    public void updateVote(String name, double newVote) throws StudentNotFoundException {
        if(this.mapOfStudent.get(name) == null){throw new StudentNotFoundException("Error");} else {
            this.mapOfStudent.put(name, newVote);
        }
    }


    public void removeStudentFromMap(String name) throws StudentNotFoundException{
        if(this.mapOfStudent.get(name) == null){throw new StudentNotFoundException("Error");}
        this.mapOfStudent.remove(name);
    }


}
