package d2.p51;

public class ArrayCopyExample {
    public static void main(String[] args) {
        int[] oldInArray = {1, 2, 3};
        int[] newIntArray = new int[5];

        for(int i=0; i<oldInArray.length; i++) {
            newIntArray[i] = oldInArray[i];
        }

        for(int i=0; i<newIntArray.length; i++) {
            System.out.print(newIntArray[i] + " ");
        }
    }
}
