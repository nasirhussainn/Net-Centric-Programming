public class Part2 {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            System.out.print("\nTable of : "+i+"\n");
            for(int j=1;j<=10;j++){
                int mul = i*j;
                System.out.print(i+" * "+j+" = "+mul+"\n");
            }
        }
    }
}
