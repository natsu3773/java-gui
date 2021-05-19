package sample;

public class Validation {
    //method to validate firstname and last name
    public void nameValid(String name){
        if (name.length() > 1 && name.matches("[a-zA-Z]+")) {
            System.out.println("valid");
        }else{
            System.out.println("error");
        }
    }

    /*A return type Method to validate South African id number
    if it's valid it return true else false*/
    public static Boolean idNumberValid(Long idNumber){
        char[] idarr = idNumber.toString().toCharArray();
        int even = 0;
        int odd  = 0;
        /*Check the positon of integer if is at odd number add it to a
        variable called odd or else add it to a variable called even*/
        for (int i = 0; i < idarr.length - 1; i++) {
            int digit = Character.getNumericValue(idarr[i]);
            if ((i % 2) == 0) {
                odd += digit;
            } else {
                int num = digit * 2;
                even += digit < 5 ? num : num - 9;
            }
        }

        int sum = even + odd;
        int lastDigitId = Character.getNumericValue(idarr[idarr.length - 1]);
        int finalTotal = 10 - (sum % 10);

        // compare the last integer on an idnumber with final total after calculation
        return finalTotal == lastDigitId;

    }
    
}
