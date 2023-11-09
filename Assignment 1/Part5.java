public class Part5 {
    public static String temp = "";

    public static String myLoop(String s) {
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            temp += s.charAt(i);
        }
        return temp;
    }

    public static String myRecursion(String s){
        if (s.length()!=0){
            char replaced = s.charAt(s.length() - 1);
            s = s.substring(0, s.length() - 1);
            temp += replaced;
            myRecursion(s);
        }
        return temp;
    }

    public static void main(String[] args) {
        String myName = "Nasir Hussain";
        int myLength = myName.length();
        String nameLoop = myLoop(myName);
        String temp = "";
        String nameRecursion = myRecursion(myName);
        System.out.print("Original Name : "+myName+"\n");
        System.out.print("Loop Reverse Name : "+nameLoop+"\n");
        System.out.print("Recursion Reverse Name : "+nameRecursion+"\n");
    }
}
