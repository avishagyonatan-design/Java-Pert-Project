/**
 * מחלקה המייצגת תכנון וניהול קורסים(יורשת מPERT),
 * המאפשרת הגדרת תלויות בין קורסים על בסיס שמותיהם.
 */
public class Courses extends Pert {

    private String[] courseName;
    private int courseCount;

    /**
     * בנאי המחלקה - מאתחל את גרף התלויות ואת מערך שמות הקןרסים
     * @param n מספר הקורסים הכולל להקצאה
     */
    public Courses(int n){
        super(n);
        this.courseName = new String[n];
        this.courseCount = 0;
    }

    /**
     * מוסיפה קורס חדש למערך הקורסים, במידה ונותר אם קיים
     * @param str שמו של הקורס להוספה
     */
    public void addCourse(String str){
        if (this.courseCount < this.courseName.length){//בדיקת תקינות
            this.courseName[this.courseCount] = str;//שמירת הנתון
            this.courseCount++;
        }else {//במקרה שהוספנו יותר מידי קורסים נדפיס שגיאה
            System.out.println("Error : cannot add more courses. The array is full.");
        }
    }

    /**
     * מתודת עזר פרטית לחיפוש אינדקס של קורס במערך לפי שמו
     * @param name שם הקורס לחיפוש
     * @return האינדקס של הקורס במערך, או -1 במידה והקורס אינ ו קיים
     */
     private int getCourseIndex(String name){//מתודת עזר שמקבלת קורס ומחזירה את האינדקס שלן במערך
        for(int i = 0; i < this.courseCount; i++){
            if (this.courseName[i].equals(name)) {
                return i;
            }
        }
        return -1;//נחזיר -1 אם הקורס לא נימצא
     }

    /**
     * מגדירה תלות בין שני קורסים
     * מתרגמת את שמות הקורסים למספרים ומפעילה את מתודת מחלקת האב
     * @param courseName1 שם הקורס הקודם
     * @param courseName2 שם הקורס התלוי
     */
     public void preRequisite(String courseName1,String courseName2){
        //תרגום המחרוזות למספרים
        int index1 = getCourseIndex(courseName1);
        int index2 = getCourseIndex(courseName2);
         //הפעלת המתודה של מחלקת האב
         if (index1 != -1 && index2 != -1){
             super.preRequisite(index1,index2);
         }else {
             System.out.println("Error: One or both courses not found.");
         }
     }

    /**
     * דורסת את מתודת ההדפסה של המשימה, ומדפיסה את שם הקורס במקום את האינדקס שלו.
     * @param taskID מספר המשימה להדפסה
     */
     @Override
    protected void printTask(int taskID){
         System.out.println(this.courseName[taskID]);
     }


}
