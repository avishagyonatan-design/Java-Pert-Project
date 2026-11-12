/**avishag yonatan
 * מחלקת הבסיסי המייצגת גרף תלויות לניהול וחישוב שלבי בצוע משימות
 */

public class Pert {


    private int n;
    private boolean[][] pertMat;
   // private int size;

    /**
     * בנאי המחלקה - מאתחל את המטריצה המייצגת את גרף התלויות
     * @param n מספקר המשימות הכולל
     */
    public Pert (int n){
        this.n = n;
        this.pertMat = new boolean[n][n];
    }

    /**
     * מגדירה תלויות בין שתי משימות
     * @param i מספר המשימה שמהווה תנאי קדם
     * @param j מספר המשימה התלויה
     */
    public void preRequisite(int i, int j) {
        if(i >= 0 && i < n && j >= 0 && j < n){
            this.pertMat[i][j] = true;
        }else {
            System.out.println("Error : Invalid task number ( " + i + "," + j + ")");
        }
    }

    /**
     * האלגוריתם המרכזי שמחשב ומדפיס את שלבי הביצוע של המשימות,
     * תןך זיהוי מעגליות במידה וקייימת
     */
    public void printStages(){
        //מערך ששומר כמה דרישות קדם חסרות לכל משימה
        int[] inDegree = new int[n];
        //מערך שזוכר אילו משימות כבר ביצענו
        boolean[] marked = new boolean[n];
        //חישוב דרגות הקדמות לכל לכל משימה
        for(int j = 0; j < n; j++){// לולאה חיצונית העוברת על כל משימה כדי לבדוק כמה דרישות קדם יש לה
            for(int i = 0; i < n; i++){//ללואה פנימית הבודקת את כל המשימןת האחרות
                if(pertMat[i][j] == true){// אם במערך המקורי מסומן ש-i חייבת לקרות ליפני J :
                    inDegree[j]++;
                }
            }
        }
        //משתני עזר
        int completedTask = 0;//כמה משימות סיימנו עד עכשיו
        int stageNumber = 1;// מספר השלב שאנחנו עומדים להדפיס
        //ריצה על כל השלביםעד שכל המשימות הושלמו
        while (completedTask < n){
            //מערך זמני שישמור רק את המשימות שאפשר לעשות בשלב הנוכחי
            boolean[] taskInCurrentStage = new boolean[n];
            boolean foundTaskForStage = true;
            //חיפוש משימות שאפשר לבצע כעת
            for(int i = 0; i < n; i++){
                //אם המשימה עוד לא בוצעה ומספר המשימות שהיא מחכה להן הוא 0
                if(marked[i] == false && inDegree[i] == 0){
                    taskInCurrentStage[i] =true;
                    foundTaskForStage = true;
                }
            }
            // הגנה מפני תלןת מעגלית
            if (foundTaskForStage == false){
                System.out.println("Error : a circular dependency between tasks was discovered.");
                break;
            }
            //הדפסת משימות של השלב הנוכחי ועדכון התלןיןת
            printStage(stageNumber, taskInCurrentStage);
            for(int i = 0; i < n; i++){
                //אם המשימה הזאת שייכת לשלב הנוכחי:
                if(taskInCurrentStage[i] == true){
                    marked[i] = true;// מסמנים שהמשימה בוצעה
                    completedTask++;// מעדכנים שסיימנו עוד משימה
                    //עכשיו נחפש את כל המשימות J שהיו תלויותבמשימה I שהרגע סיימנו
                    for (int j = 0; j < n; j++){
                        if (pertMat[i][j] == true){
                            inDegree[j]--;//מפחיתים להן את "החוב"
                        }
                    }
                }
            }
            System.out.println();
            stageNumber++;
        }

    }

    /**
     * מדפיסה משימה בודדת. נועדה לדריסה על ידי מחלקות ירושות.
     * @param taskID מספר המשימה להדפסה
     */
    protected void printTask(int taskID){
        System.out.println(taskID);
    }

    /**
     * מדפיסה את כל המשימות השייכות לשלב מסוים. נועדה לדריסה על ידי מחלקות יורשות
     * @param stageNumber המספר הסידורי של השלב הנוכחי
     * @param taskInCurrentStage מערך בוליאני המייצג אילו משימות שייכות לשלב זה
     */
    protected void printStage(int stageNumber, boolean[] taskInCurrentStage){
        System.out.println("Stage " + stageNumber);
        for (int i = 0; i < n; i++){
            if (taskInCurrentStage[i]){
                printTask(i);
            }
        }
    }
}
