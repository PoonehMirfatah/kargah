package University;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        University.getUniversity("UI");
        Student std1 = new Student("Poone", 18, Faculity.COMPUTER, 1402);
        Student std2 = new Student("Darya", 10, Faculity.CHEMISTRY, 1402);
        Student std3 = new Student("Zahra", 13, Faculity.COMPUTER, 1402);
        Student std4 = new Student("Ali", 19, Faculity.ECONOMIY, 1400);
        Student std5 = new Student("Reza", 15, Faculity.COMPUTER, 1400);

        Lesson math = new Lesson("Math", Lesson.lessonKinds.CORE, 3);
        Lesson physics = new Lesson("Physics", Lesson.lessonKinds.MAJOR, 3);
        Lesson chemistry = new Lesson("Chemistry", Lesson.lessonKinds.LAB, 2);
        Lesson biology = new Lesson("Biology", Lesson.lessonKinds.LAB, 2);
        Lesson dini = new Lesson("Dini", Lesson.lessonKinds.ELECTIVE, 1);

        University.getUniversity().addStudent(std1);
        University.getUniversity().addStudent(std2);
        University.getUniversity().addStudent(std3);
        University.getUniversity().addStudent(std4);
        University.getUniversity().addStudent(std5);

        University.getUniversity().addLesson(math);
        University.getUniversity().addLesson(physics);
        University.getUniversity().addLesson(chemistry);
        University.getUniversity().addLesson(biology);
        University.getUniversity().addLesson(dini);

        Section Math01 = new Section(math, 40);
        Section Math02 = new Section(math, 45);
        Section Math03 = new Section(math, 40);

        Section physics04 = new Section(physics, 30);
        Section physics05 = new Section(physics, 35);

        Section chemistry06 = new Section(chemistry, 20);

        Section biology07 = new Section(biology, 3);
        Section biology08 = new Section(biology, 35);
        Section biology09 = new Section(biology, 35);
        Section biology010 = new Section(biology, 30);

        Section dini011 = new Section(dini, 35);
        Section dini012 = new Section(dini, 35);
        University.getUniversity().addSection(math, Math01);
        University.getUniversity().addSection(math, Math02);
        University.getUniversity().addSection(math, Math03);

        University.getUniversity().addSection(physics, physics04);
        University.getUniversity().addSection(physics, physics05);
        University.getUniversity().addSection(chemistry, chemistry06);
        University.getUniversity().addSection(biology, biology07);
        University.getUniversity().addSection(biology, biology08);
        University.getUniversity().addSection(biology, biology09);
        University.getUniversity().addSection(biology, biology010);
        University.getUniversity().addSection(dini, dini011);
        University.getUniversity().addSection(dini, dini012);
        //show Lessons & Sections
        System.out.println(University.getUniversity().seeSections());
        //choose unit for std4
        System.out.print(std4.chooseUnit("Math03"));

        System.out.print(std4.chooseUnit("Physics05"));

        System.out.print(std4.chooseUnit("Chemistry06"));

        //same lesson
        System.out.print(std1.chooseUnit("Math01"));
        System.out.println(std1.chooseUnit("Math01"));

        //out of limit section for darya
        System.out.print(std2.chooseUnit("Math01"));
        System.out.print(std2.chooseUnit("Biology07"));
        System.out.print(std2.chooseUnit("Physics04"));
        System.out.println(std2.chooseUnit("Dini010"));

        //number of students of a section
        System.out.print(std1.chooseUnit("Physics04"));
        System.out.println(std5.chooseUnit("Physics04"));
        System.out.println(std3.chooseUnit("Dini011"));
        System.out.println("Section Info:\n"+physics04);

        //out of limit capacity
        System.out.println(std5.chooseUnit("Biology07"));
        System.out.print(std3.chooseUnit("Biology07"));
        System.out.println(std1.chooseUnit("Biology07"));

        if (std1.chooseUnit("Biology07").equals("the section is full!    " +
                "1.You can choose another section instead " +
                "  2.Go to waitlist")) {
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            System.out.println(std1.filledSectionPage(input));
        }

        //second person in waitlist
        System.out.println(std4.chooseUnit("Biology07"));

        if (std4.chooseUnit("Biology07").equals("the section is full!    " +
                "1.You can choose another section instead " +
                "  2.Go to waitlist")) {
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            System.out.println(std4.filledSectionPage(input));
        }
        //sections of std4
        System.out.println("std4\n" + std4.seeSelectedSections());
        //wait sections of std4
        System.out.println("std4\n" + std1.seeWaitSections());
        // sections before delete
        System.out.println("std1\n" + std1.seeSelectedSections());
        //waitsectons
        System.out.println("std1\n" +std1.seeWaitSections());
        std1.deleteSec("Physics04");

        //sections after delete
        System.out.println("std1\n" + std1.seeSelectedSections());

        //show student Info
        System.out.println("std1 Info:\n"+std1);

        //delete biology07 by std3
        System.out.println("std3\n" + std3.seeSelectedSections());
        std3.deleteSec("Biology07");
        System.out.println("std3\n" + std3.seeSelectedSections());
        //Automatic replace first student in wait list of section biology07
        System.out.println("std1\n" + std1.seeSelectedSections());

        System.out.println("std1\n" +std1.seeWaitSections());


    }
}

class Student {
    private long stdNumber;

    public long getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(long stdNumber) {
        this.stdNumber = stdNumber;
    }

    private String firstAndLastname;

    public String getFirstAndLastname() {
        return firstAndLastname;
    }

    public void setFirstAndLastname(String firstAndLastname) {
        this.firstAndLastname = firstAndLastname;
    }

    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private Faculity faculity;

    public void setFaculity(Faculity faculity) {
        this.faculity = faculity;
    }

    public Faculity getFaculity() {
        return faculity;
    }

    Section[] sectionList;

    public void setSectionList(Section[] sectionList) {
        this.sectionList = sectionList;
    }

    public void setSectionCount(int sectionCount) {
        this.sectionCount = sectionCount;
    }
    private ArrayList<Section> waitSections=new ArrayList<>();

    public ArrayList<Section> getWaitSections() {
        return waitSections;
    }

    public void setWaitSections(ArrayList<Section> waitSections) {
        this.waitSections = waitSections;
    }

    private int GPA;

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    private int sectionCount;

    public int getSectionCount() {
        return sectionCount;
    }

    private int maxSection;

    public int getMaxSection() {
        return maxSection;
    }

    public void setMaxSection(int maxSection) {
        this.maxSection = maxSection;
    }

    private static int studentCounter;

    public static int getStudentCount() {
        return studentCounter;
    }

    public static void setStudentCount(int studentCount) {
        Student.studentCounter = studentCount;
    }

    private int deleteCounter=0;
    public void setDeleteCounter(int deleteCounter) {
        this.deleteCounter = deleteCounter;
    }

    public int getDeleteCounter() {
        return deleteCounter;
    }
     int lessonIndex=0;
    int sectionIndex=0;
    int delsectionIndex=0;

    Student(String firstAndLastname, int GPA, Faculity faculity, int year) {
        String stdNum;
        studentCounter++;
        stdNum = String.format("402%d000", faculity.getCode());
        this.stdNumber = Integer.valueOf(stdNum) + studentCounter;


        this.firstAndLastname = firstAndLastname;
        this.faculity = faculity;
        this.year = year;
        this.GPA = GPA;
        if (this.GPA < 12) {
            maxSection = 3;
        } else if ((this.GPA >= 12) && (this.GPA <= 17)) {
            maxSection = 5;
        } else if (this.GPA > 17) {
            maxSection = 7;
        }
        sectionList = new Section[maxSection];
    }

    String chooseUnit(String sectionCode) {
        StringBuilder nameOfLesson = new StringBuilder();
        if (this.GPA < 12 && sectionCount >= 3) {
            return "You can choose just 3 section!";
        } else if (this.GPA >= 12 && this.GPA <= 17 && sectionCount >= 5) {
            return "You can choose just 5 section!";
        } else if (this.GPA > 17 && sectionCount >= 7) {
            return "You can choose just 7 section!";
        }
        for (char chr: sectionCode.toCharArray()) {
            if (!(Character.isDigit(chr))) {
                nameOfLesson.append(chr);
            }
        }
        for (int i = 0; i < University.getLessonIndex(); i++) {
            if (University.getUniversity().getUniLessons()[i].getLessonName().equals( nameOfLesson.toString())) {
                lessonIndex=i;
            }
        }

        for (int i = 0; i <sectionList.length; i++) {
            if (!(sectionList[i] == null)) {
                if (sectionList[i].getLesson().getLessonName().equals(nameOfLesson.toString())) {
                    return "You cant choose 2 section of a lesson";
                }
            }
        }

        for ( int j = 0; j <University.getUniversity().sectionLessons[lessonIndex].size(); j++) {
            if (University.getUniversity().sectionLessons[lessonIndex].get(j).sectionCode.equals(sectionCode)) {
                sectionIndex=j;
                if (University.getUniversity().sectionLessons[lessonIndex].get(j).getCapacity() > University.getUniversity().sectionLessons[lessonIndex].get(j).studentCount) {
                    sectionList[sectionCount++] = University.getUniversity().sectionLessons[lessonIndex].get(j);
                    sectionList[sectionCount - 1].studentCount++;

                } else {
                    StringBuilder filledSectonMessage=new StringBuilder();
                    filledSectonMessage.append("the section is full!    " +
                            "1.You can choose another section instead " +
                            "  2.Go to waitlist");
                    return String.valueOf(filledSectonMessage);
                    }
                }
            }
        return "";
    }
     String filledSectionPage(int input){
        StringBuilder unfilledSections=new StringBuilder();
        switch (input){
            case 1:
                unfilledSections.append("You can choose this sections instead!   ");
                for (int i = 0; i < University.getUniversity().sectionLessons[lessonIndex].size(); i++) {
                    if( University.getUniversity().sectionLessons[lessonIndex].get(i).getCapacity() > University.getUniversity().sectionLessons[lessonIndex].get(i).studentCount){
                        unfilledSections.append("\n"+University.getUniversity().sectionLessons[lessonIndex].get(i).sectionCode);
                    }
                }
                return String.valueOf(unfilledSections);
            case 2:
                University.getUniversity().sectionLessons[lessonIndex].get(sectionIndex).getWaitList().add(this);
                waitSections.add( University.getUniversity().sectionLessons[lessonIndex].get(sectionIndex));
                return "You are aded to the waitlist of section";

        }
        return "";
    }
    String seeSelectedSections(){
        StringBuilder sectiosOfStudent=new StringBuilder();
        sectiosOfStudent.append("Your selected Sections:\n");
        for (int i = 0; i < getSectionCount(); i++) {
           sectiosOfStudent.append(sectionList[i].sectionCode+"\n");
      }
        return String.valueOf(sectiosOfStudent);
    }
    String seeWaitSections(){
        StringBuilder waitSectiosOfStudent=new StringBuilder();
        waitSectiosOfStudent.append("Your wait Sections:\n");
        for (int i = 0; i < getWaitSections().size(); i++) {
            waitSectiosOfStudent.append(waitSections.get(i).sectionCode+"\n");
        }
        return String.valueOf(waitSectiosOfStudent);
    }

    String deleteSec(String sectionCode) {
        if (deleteCounter < 3) {
            for (int i = 0; i < sectionCount; i++) {
                if (sectionList[i].sectionCode.equals(sectionCode)) {
                    sectionList[i].studentCount--;

                for (int k = i+ 1; k <sectionCount; k++) {
                    sectionList[k-1] = sectionList[k];
                }
                    sectionCount--;
                    deleteCounter++;
                     sectionList[i].replaceStudent(sectionList[i]);
                }
            }

            for (int i = 0; i <waitSections.size(); i++) {
                if (waitSections.get(i).sectionCode.equals(sectionCode)) {
                    waitSections.remove(waitSections.get(i));
                    waitSections.get(i).getWaitList().remove(this);

                    deleteCounter++;


                }
            }
        }else{
            return "You Can Delete Only 3 Sections!";
        }
        return"";
    }

    @Override
    public String toString() {
            return "StudentId:" + stdNumber + "\n" + " Name:" + firstAndLastname + "\n" +
                    " Entrance Year:" + year + "\n" + "Faculity:" + faculity + "\n" +
                    "GPA:" + GPA + "\n";
        }
    }
    enum Faculity {
        COMPUTER(36), ECONOMIY(19), CHEMISTRY(32);
        private int code;

        Faculity(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    }

    class Lesson {
        private String lessonName;

        public String getLessonName() {
            return lessonName;
        }

        public void setLessonName(String lessonName) {
            this.lessonName = lessonName;
        }

         enum lessonKinds {
            MAJOR, ELECTIVE, LAB, CORE;
        }

        public void setLessonkind(lessonKinds lessonkind) {
            this.lessonkind = lessonkind;
        }

        public lessonKinds getLessonkind() {
            return lessonkind;
        }

        private lessonKinds lessonkind;

        private int unitCount;
        public int getUnitCount() {
            return unitCount;
        }

        public void setUnitCount(int unitCount) {
            this.unitCount = unitCount;
        }

        Lesson(String lessonName, lessonKinds lessonkind, int unitCount) {
            this.lessonkind = lessonkind;
            this.lessonName = lessonName;
            this.unitCount = unitCount;
        }

        String seeLessonInfo() {
            return "Lesson name:" + lessonName + "\nlesson Kind:" + lessonkind + "\nNumber of unit:" + unitCount;
        }
        @Override
        public String toString(){
            return "Lesson =>"+lessonName;
        }
    }
    class Section {
        private Lesson lesson;

        public Lesson getLesson() {
            return lesson;
        }

        public void setLesson(Lesson lesson) {
            this.lesson = lesson;
        }

        String sectionCode;

        public static int getSectionCount() {
            return sectionCount;
        }

        public static void setSectionCount(int sectionCount) {
            Section.sectionCount = sectionCount;
        }

        private ArrayList<Student> waitList=new ArrayList<>();

        public ArrayList<Student> getWaitList() {
            return waitList;
        }

        public void setWaitList(ArrayList<Student> waitList) {
            this.waitList = waitList;
        }

        private int capacity;

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        int studentCount=0;

        public void setStudentCount(int studentCount) {
            this.studentCount = studentCount;
        }

        public int getStudentCount() {
            return studentCount;
        }
        private static int sectionCount;

        Section(Lesson lesson, int capacity) {
            sectionCount++;
            this.capacity = capacity;
            this.lesson = lesson;
            //code section
            sectionCode = String.format("%s0%d", lesson.getLessonName(), sectionCount);
        }

        String seeSectionsInfo() {
            return "Lesson:" + lesson.getLessonName() + "\nSectoin Code:" + sectionCode + "\nCapacity:" + capacity +
                    "\nnumbers of student: " + studentCount;
        }

      void replaceStudent(Section section) {
          boolean isFirst=false;
          if (section.waitList.size() != 0) {
              for (Student std : section.waitList) {
                  if (std.getSectionCount() < std.getMaxSection()&& isFirst==false) {
                      isFirst=true;
                      std.sectionList[std.getSectionCount()] = section;
                      section.studentCount++;
                      std.setSectionCount(std.getSectionCount()+1);
                      std.getWaitSections().remove(section);
                      //section.getWaitList().remove(std);
                  }
              }
          }
      }
            @Override
            public String toString () {
                return "Lesson:" + lesson.getLessonName() + "\nSection code:" + sectionCode +
                        "\nCapacity:" + capacity + "\nNumberof students:" + studentCount;
            }

    }
         class University {
           private Lesson[] uniLessons = new Lesson[10];

             public Lesson[] getUniLessons() {
                 return uniLessons;
             }

             public void setUniLessons(Lesson[] uniLessons) {
                 this.uniLessons = uniLessons;
             }
             private ArrayList<Student> students = new ArrayList<>();

             public ArrayList<Student> getStudents() {
                 return students;
             }

             public void setStudents(ArrayList<Student> students) {
                 this.students = students;
             }

             private String uniName;

             public String getUniName() {
                 return uniName;
             }

             public void setUniName(String uniName) {
                 this.uniName = uniName;
             }
             private static int lessonIndex = 0;

             public static void setLessonIndex(int lessonIndex) {
                 University.lessonIndex = lessonIndex;
             }

             public static int getLessonIndex() {
                 return lessonIndex;
             }

             ArrayList<Section>[] sectionLessons;

             public void setSectionLessons(ArrayList<Section>[] sectionLessons) {
                 this.sectionLessons = sectionLessons;
             }

             public void getSectionLessons(ArrayList<Section>[] sectionLessons) {
                 this.sectionLessons = sectionLessons;
             }

             private University(String uniName) {
                this.uniName = uniName;
                sectionLessons = new ArrayList[10];
                for (int i = 0; i < lessonIndex; i++) {
                    sectionLessons[i] = new ArrayList<>();
                }

            }

            void addLesson(Lesson lesson) {

                if (lessonIndex + 1 < 10) {
                    uniLessons[lessonIndex++] = lesson;
                }
            }

            void addSection(Lesson lesson, Section section) {
                for (int i = 0; i < uniLessons.length; i++) {
                    if (uniLessons[i] == lesson) {
                        if (!(sectionLessons[i] == null)) {
                        } else {
                            sectionLessons[i] = new ArrayList<>();
                        }
                        sectionLessons[i].add(section);
                    }
                }
            }

            void addStudent(Student student) {
                students.add(student);
            }


            String seeSections() {
                 StringBuilder sectionAndlessons=new StringBuilder();
                sectionAndlessons.append("Sections & Lessons:\n");
                for (int i = 0; i < getLessonIndex(); i++) {
                    sectionAndlessons.append(getUniLessons()[i] + ":\n");
                    for (int j = 0; j < sectionLessons[i].size(); j++) {
                        sectionAndlessons.append(sectionLessons[i].get(j).sectionCode+"\n");
            }
        }
                return String.valueOf(sectionAndlessons);
    }

            private static University university;

            public static University getUniversity(String name) {
                if (university == null) {
                    university=new University(name);
                    return university;
                } else {
                    return university;
                }
            }

            public static University getUniversity() {
                return university;
            }
        }


