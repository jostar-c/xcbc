import java.util.*;

public class Judge {
    public static int judge(String[] args) {
        int flag=0;
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String save1="零壹貮叁肆伍陆柒捌玖拾佰仟万亿元整";
        String[] save2=new String[]{"仟仟","亿亿","万万","佰佰","拾拾","零零"};
        String save3="壹貮叁肆伍陆柒捌玖";
        String save4="亿万仟佰拾";
        int lenth=s.length();
        for (int i=0;i<s.length();i++){
            if(s.substring(i,i+1).compareTo("0")>0&&s.substring(i,i+1).compareTo("9")<0){
                if (s.length()>12){
                    flag=0;
                    break;
                }
                if (flag==2){
                    flag=0;
                    break;
                }
                flag=1;
            }
            else if (save1.contains(s.substring(i,i+1))){
                if (flag==1){
                    flag=0;
                    break;
                }
                if (s.substring(i,i+1).compareTo("零")==0) {
                    if (save4.contains(s.substring(i - 1, i)) && save3.contains(s.substring(i + 1, i + 2))) {
                    } else {
                        flag = 0;
                        break;
                    }
                }

                for (int j=0;j< save2.length;j++){
                    if (s.contains(save2[j])){
                        System.out.println("输入错误");
                        flag=0;
                        break;
                    }else if (s.length()<3){
                        flag=0;
                        break;
                    }else if (s.substring(lenth-2,lenth-1).compareTo("元")!=0||s.substring(lenth-1,lenth).compareTo("整")!=0){
                        flag=0;
                        break;
                    }
                    else{
                        flag=2;
                    }
                }
                if (flag==0){
                    break;
                }
            }
            else{
                flag=0;
                break;
            }

        }
        if (s.compareTo("零元整")==0){
            flag=2;
        }
        if (flag==0){
            System.out.println("输入错误");
        }else if (flag==1){
            System.out.println("是小写");
        }else {
            System.out.println("是大写");
        }

        return flag;
    }
}
