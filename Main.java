import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
//2 com//com3
public class Main {
    public static void main(String[] args) {
        Admin.getAdmin("َAli Gloi","09133218088");
        Admin.getAdmin().addEmployee("Poone Mirfatah","09373133957",
                "FullTime",1402,12,26,40,20);
        Admin.getAdmin().addEmployee("Darya Zahiri","09444413339",
                "PartTime",1400,6,16,30,2);
        Admin.getAdmin().addEmployee("Mina Abbasi","09134567896",
                "ProjectEmployee",1402,3,6,10,5);
        System.out.println(Admin.getAdmin().showUsers());

        int i=1;
        for (Employee employee:Admin.getAdmin().getEmployeesList()) {
            employee.work(40);
            System.out.println("Employee "+i+" Salary"+":"+employee.getSalary());
            i++;
        }

    }
}
abstract class User{
    String nameAndLastName;
    String phoneNumber;


    User(String name,String phoneNumber){
        this.nameAndLastName=name;
        this.phoneNumber=phoneNumber;
    }
     String getBasicInformation(){
        return "Name:"+nameAndLastName+"\n"+"Phone Number:"+phoneNumber;
     }
}
abstract class Employee extends User{
    LocalDate hireDate;
    Employee(String name, String phoneNumber,int year,int month,int day) {
        super(name, phoneNumber);
        this.hireDate=LocalDate.of(year,month,day);
        Admin.getAdmin().getEmployeesList().add(this);
    }
    abstract long getSalary();
    abstract void work(int unpaidTime);
    @Override
    final String getBasicInformation(){
       return super.getBasicInformation()+"\nHire Date: "+this.hireDate;
    }

}
final class FullTimeEmployee extends Employee{
    int unpaidDays;
    final long monthSalary;

    FullTimeEmployee(String name,String phoneNumber,int year,int month, int day,int unpaidDays,long monthSalary) {
        super(name,phoneNumber,year,month,day);
        this.unpaidDays=unpaidDays;
        this.monthSalary = monthSalary;
    }

    @Override
    long getSalary() {
        long salary=0;
        salary= (unpaidDays/30)*monthSalary;
        unpaidDays=unpaidDays%30;
        return salary;
    }

    @Override
    void work(int unpaidDays) {
        this.unpaidDays+=unpaidDays;
    }
}
final class partTimeEmployee extends Employee{
    int unpaidHours;
    final long hourSalary;
    partTimeEmployee(String name,String phoneNumber,int year,int month, int day,int unpaidHours,long hourSalary){
        super(name,phoneNumber,year,month,day);
        this.unpaidHours=unpaidHours;
        this.hourSalary=hourSalary;
    }


    @Override
    long getSalary() {
        long salary;
        salary=unpaidHours*hourSalary;
        unpaidHours=0;
        return salary;
    }

    @Override
    void work(int unpaidHours) {
        this.unpaidHours+=unpaidHours;
    }
}
final class projectEmployee extends Employee{
    int unpaidProjects;
    final long projectSalary;
    projectEmployee(String name,String phoneNumber,int year,int month, int day,int unpaidProjects,long projectSalary){
        super(name,phoneNumber,year,month,day);
        this.unpaidProjects=unpaidProjects;
        this.projectSalary=projectSalary;
    }

    @Override
    long getSalary() {
        long salary;
        salary=unpaidProjects*projectSalary;
        unpaidProjects=0;
        return salary;
    }

    @Override
    void work(int unpaidProjects) {
        this.unpaidProjects+=unpaidProjects;
    }
}
class Admin extends User{
    private static Admin admin;
    private ArrayList<Employee> employeesList=new ArrayList<>();

    public ArrayList<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(ArrayList<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    private Admin(String name, String phoneNumber){
        super(name, phoneNumber);
    }

    public static Admin getAdmin(String name,String phoneNumber) {
        if (admin == null) {
            admin = new Admin(name,phoneNumber);
        }
        return admin;
    }

    public static Admin getAdmin() {
        return admin;
    }
    String showUsers(){
        StringBuilder usersString=new StringBuilder();
        usersString.append("Admin: \n"+this.getBasicInformation()+"\n\n");

        int i=1;
        for (Employee employee:employeesList) {
            usersString.append("Employee" + i++ +":\n"+ employee.getBasicInformation()+"\n\n");
        }
        return String.valueOf(usersString);
    }
    void addEmployee(String name,String phoneNumber,String employeeKind,int year,int month, int day,int unpaidWork,long workSalary){
        switch ((employeeKind)){
            case "FullTime":
                FullTimeEmployee employee1=new FullTimeEmployee(name,phoneNumber,year,month,day,unpaidWork,workSalary);
                break;
            case "PartTime":
                partTimeEmployee employee2=new partTimeEmployee(name,phoneNumber,year,month,day,unpaidWork,workSalary);
                break;
            case "ProjectEmployee":
                projectEmployee employee3=new projectEmployee(name,phoneNumber,year,month,day,unpaidWork,workSalary);
                break;
        }
    }
}

