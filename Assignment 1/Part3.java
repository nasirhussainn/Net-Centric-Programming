public class Part3 {
    public static int Maximum(int[] Galaxy) {
        int max = Galaxy[0];
        for (int i = 1; i < Galaxy.length; i++) {
            if (Galaxy[i] > max) {
                max = Galaxy[i];
            }
        }
        return max;
    }

    public static int Minimum(int[] Galaxy) {
        int min = Galaxy[0];
        for (int i = 1; i < Galaxy.length; i++) {
            if (Galaxy[i] < min) {
                min = Galaxy[i];
            }
        }
        return min;
    }

    public static int[] Ascending(int[] galaxy) {
        int total = galaxy.length;
        for (int i = 0; i < ( total - 1 ); i++) {
            for (int j = 0; j < total - i - 1; j++) {
                if (galaxy[j] > galaxy[j+1])
                {
                    int temp = galaxy[j];
                    galaxy[j] = galaxy[j+1];
                    galaxy[j+1] = temp;
                }
            }
        }
        return galaxy;
    }


    public static int[] Descending(int[] galaxy) {
        int[] temp = new int[galaxy.length];
        int j = 0;
        for (int i = galaxy.length - 1; i >= 0; i--) {
            temp[j] = galaxy[i];
            j++;
        }
        return temp;
    }


    public static void printArray(int[] Galaxy){
        for(int i=0;i<Galaxy.length;i++){
            System.out.print(Galaxy[i]+"\t");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] Galaxy = {23,45,67,133,12,78,54,23,87,12};
        int max = Maximum(Galaxy);
        int min = Minimum(Galaxy);
        System.out.print("Maximum : "+max+"\n");
        System.out.print("Minimum : "+min);
        int [] Ascending = Ascending(Galaxy);
        int [] Descending = Descending(Galaxy);
        System.out.print("\nAscending Order : ");
        printArray(Ascending);
        System.out.print("Descending Order : ");
        printArray(Descending);
    }
}
