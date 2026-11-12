/**
 * מחלקה המייצגת ניהול פרויקט מבוסס זמנים,
 * המחשבת את הזמן המקסימאלי הנדרש לכל שלב ואת זמן סיום הפרוייקט הכןלל
 */
public class TimedPert extends Pert {

    private double[] timeArr;
    private double currentTime;

    /**
     * בנאי המחלקה - מאתחל את גרף התלויות ואת מערך זמני הביצוע לכל משימה
     * @param n מספר המישמות הכולל
     * @param timeArr מערך המכיל את משך הזמן הדרוש לביצוע כל משימה
     */
    public TimedPert(int n, double[] timeArr){
        super(n);
        this.timeArr = timeArr;
    }

    /**
     * דורסת את התודת ההדפסה, ומדפיסה את הזמן שדורשת המשימה ואת מספרה
     * @param taskID מספר המשימה להדפסה
     */
    @Override
    protected void printTask(int taskID){
        System.out.println(this.timeArr[taskID] + " = time " + taskID);
    }

    /**
     * דורסת את מתודת הדפסת השלב.
     * מחשבת את זמן המשימה הארוכה ביותר בשלב הנוכחי כדי לקדם את שעון הפרויקט הכולל,
     * ומדפיסה את זמני ההתחלה והסיום של השלב יחד עם המשימות שבו.
     * @param stageNumber המספר הסידורי של השלב הנוכחי
     * @param taskInCurrentStage מערך בוליאני המייצג אילו משימות שייכות לשלב זה
     */
    @Override
    protected void printStage(int stageNumber, boolean[] taskInCurrentStage) {
        System.out.println("Start time of stage " + stageNumber + " : " + this.currentTime);

        double maxTimeInStage = 0;

        for (int i = 0; i < taskInCurrentStage.length; i++){
            if (taskInCurrentStage[i]){
                printTask(i);
                if (this.timeArr[i] > maxTimeInStage){
                    maxTimeInStage = this.timeArr[i];
                }
            }
        }
        //קידום השעון שלנו לפי המשימה הארוכה ביותר בשלב
        this.currentTime += maxTimeInStage;
        System.out.println("End time of stage " + stageNumber + ": " + this.currentTime);
    }
    //הפעלת האלגוריתם printStage

    /**
     * דורסת את מתודת האלגוריתם הראשית לאתחול זמן הפרוייקט הכולל,
     * מפעילה אלגוריתם מציאת השלבים של מחךקת האב ולבסוף מדפיסה את הזמן הכולל
     */
    @Override
    public void printStages() {
        this.currentTime = 0;//אתחול השעון
        super.printStages();
        System.out.println("Total project finish time: " + this.currentTime);//הדפסת הזמן הכולל שלקח הפרוייקט בסיום
    }
}
