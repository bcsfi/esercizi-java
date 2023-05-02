public class reverse  {

    static String reverseStr(String content)
    {
        String newContent = "";

            for(int b=content.length()-1; b > -1; b--){
                newContent += content.charAt(b);
            }

        return newContent;
    }
}
