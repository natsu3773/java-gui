package BLL;

public class GenEmployeeUsername implements IAutoID{
    //local variables for employee access types in the enum
    AccessTypes Clerk = AccessTypes.Clerk;
    AccessTypes Admin = AccessTypes.Admin;
    AccessTypes LoanOfficer =AccessTypes.LoanOfficer;

    private String EmployeeID=null;

    @Override
    public String GenerateID(String access, String name,String surname) {

        if(access.equalsIgnoreCase(Clerk.toString())){
            EmployeeID = "CL".concat(name.substring(0,1)).concat(surname.substring(0,1));
        }
        if(access.equalsIgnoreCase(Admin.toString())){
            EmployeeID = "AD".concat(name.substring(0,1)).concat(surname.substring(0,1));
        }
        if(access.equalsIgnoreCase(LoanOfficer.toString())){
            EmployeeID = "LO".concat(name.substring(0,1)).concat(surname.substring(0,1));
        }
        return EmployeeID;
    }
}
