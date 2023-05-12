import java.util.HashMap;
import java.util.Map;

public class UserManage {
    Map<String, String> userList = new HashMap<String, String>();

    private String nomeTitolare = null;
    private Integer soldiTitolare = 0;



    public boolean createUtente(String email, String password)
    {
        userList.put(email, password);

        if(userList.containsKey(email) && userList.containsValue(password)){return true;} else {
            return false;
        }

    }
}
