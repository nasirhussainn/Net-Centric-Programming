public class Part6 {

    public static int countText(char s, String temp) {
        int count = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (s == temp.charAt(i)) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args){
        String myString = new String();
        myString = "Nasir Hussain";
        System.out.print(myString+"\n");
        System.out.print("Counting Text\n");
        myString = myString.toLowerCase();
        for(int i=0;i<myString.length();i++){
            char c = myString.charAt(i);
            int count = countText(c,myString);
            System.out.print("Letter : ["+c+"] appear "+count+" times \n");
            String temp = Character.toString(c);
            myString = myString.replaceAll(temp,"");
            i--;
        }
    }
}
