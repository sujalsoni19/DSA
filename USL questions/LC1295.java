// LC: 1295. Find Numbers with Even Number of Digits

public class LC1295 {
    public static void main(String[] args) {
        int[] arr = {10,123,4567,1,23,12578,12,45,365};
        int evencount=0;
        int oddcount=0;

        for(int a:arr){
            int count = 0;
            while(a>0){
                a=a/10;
                count++;
            }

            // shortcut to count digits in a number
            // int count = (int)(Math.log10(a)+1);
            if(count%2==0){
                evencount++;
            }
            else{
                oddcount++;
            }
        }
        System.out.println(evencount + "  " + oddcount);
    }
}
