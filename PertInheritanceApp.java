public class PertInheritanceApp
{
    public static void main(String[] args)
    {
        int n= 12;
        Courses coursesSW = new Courses(n);
        coursesSW.addCourse("Malam 61510");
        coursesSW.addCourse("Matam 61211");
        coursesSW.addCourse("Atam 61210");
        coursesSW.addCourse("Data Structures 61120");
        coursesSW.addCourse("OOP 61310");
        coursesSW.addCourse("Soft Eng 61101");
        coursesSW.addCourse("OS 61122");
        coursesSW.addCourse("OOP LANG 61313");
        coursesSW.addCourse("Real Time 61133");
        coursesSW.addCourse("Advanced Programming 61617");
        coursesSW.addCourse("Parallel Computing 61104");
        coursesSW.addCourse("Programming Languages 61110");
        coursesSW.preRequisite("Malam 61510","Matam 61211");
        coursesSW.preRequisite("Malam 61510","Atam 61210");
        coursesSW.preRequisite("Matam 61211","Soft Eng 61101");
        coursesSW.preRequisite("Atam 61210","Data Structures 61120");
        coursesSW.preRequisite("Matam 61211","Data Structures 61120");
        coursesSW.preRequisite("OS 61122","Parallel Computing 61104");
        coursesSW.preRequisite("OS 61122","Real Time 61133");
        coursesSW.preRequisite("Data Structures 61120",
                "Programming Languages 61110");
        coursesSW.preRequisite("Atam 61210","OS 61122");
        coursesSW.preRequisite("Data Structures 61120","OS 61122");
        coursesSW.preRequisite("Matam 61211","Programming Languages 61110");
        coursesSW.preRequisite("Matam 61211","Advanced Programming 61617");
        coursesSW.preRequisite("Matam 61211","OOP 61310");
        coursesSW.preRequisite("OOP 61310","OOP LANG 61313");
        coursesSW.preRequisite("OOP 61310","Soft Eng 61101");
        coursesSW.preRequisite("Data Structures 61120",
                "Advanced Programming 61617");
        System.out.println("**** Software Courses **** ");
        coursesSW.printStages();
        n = 7;
        double [] actionTimes = new double[]{2.2, 7.7, 3.3, 1.1, 5.5, 6.6, 4.4};
        TimedPert timedPert = new TimedPert(n, actionTimes);

        timedPert.preRequisite(3,1);
        timedPert.preRequisite(3,6);
        timedPert.preRequisite(4,6);
        timedPert.preRequisite(4,5);
        timedPert.preRequisite(1,2);
        timedPert.preRequisite(5,0);
        timedPert.preRequisite(6,2);
        System.out.println("**** Timed Tasks **** ");
        timedPert.printStages();


    } // main
} // RunPert
