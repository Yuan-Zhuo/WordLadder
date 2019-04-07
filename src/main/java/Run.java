import com.word.*;
import java.util.Scanner;

public class Run {
    public static void main(String[] args){
        System.out.println("Welcome to WordLadder!");
        while(true){
            try{
                Scanner input=new Scanner(System.in);

                System.out.print("Word #1(or Enter 'q' to quit):");
                String str1=input.next();
                if(str1.equals("q"))
                    return;

                System.out.print("Word #2(or Enter 'q' to quit):");
                String str2=input.next();
                if(str2.equals("q"))
                    return;

                String result=WordLadder.get_path(str1,str2);
                if(!result.equals("")){
                    System.out.println("The path from "+str2+" to "+str1+" is:");
                    System.out.println(result);
                }
            } catch (WordLadderExpcetion e){
                System.out.println(e.getMsgDes());
            }

            System.out.println();
        }
    }
}
