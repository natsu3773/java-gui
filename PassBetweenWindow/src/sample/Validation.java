package sample;

import BLL.IValidateID;
import BLL.Text;

public class Validation extends Text implements IValidateID {
    private boolean Valid;

    public boolean isValid() {
        return Valid;
    }

    public void setValid(boolean valid) {
        Valid = valid;
    }

    @Override
    public boolean ValidateText(String input) {

        if (input.length()>1 && input.matches("[a-zA-Z]+")) {
            setValid(true);
        }else{
            setValid(false);
        }
        return isValid();
    }

    /*A  Method to validate South African id number
    if it's valid it return true else false*/
    @Override
    public boolean ValidateID(String input) {
        Long idNumber = Long.parseLong(input);
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

