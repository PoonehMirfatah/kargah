public class Main {
    public static void main(String[] args) {
        Name[] arrayNames = new Name[5];
        arrayNames[3]=new Name("Pooneh","Mirfatah");
        System.out.println(arrayNames[3].getFirstName());
    }
}

class Name {
    private String firstName;
    private String lastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
ediiiiie
    2nd ediiit
    3d ediit
}
