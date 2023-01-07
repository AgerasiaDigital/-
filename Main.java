
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static String[] calc(String expression) throws Exception {
        Pattern r1 = Pattern.compile("^(\\d{1}|10)([+\\-*\\/]{1})(\\d{1}|10)$");
        var r2 = Pattern.compile("^(I{1,3}|IV|VI{0,3}|I{0,1}X)([+*/-])(I{1,3}|IV|VI{0,3}|I{0,1}X)$");
        var matcher1 = r1.matcher(expression);
        var matcher2 = r2.matcher(expression);
        if(matcher1.find())
            return new String[]{"a",matcher1.group(1),matcher1.group(2),matcher1.group(3)};
        else if(matcher2.find())
            return new String[]{"r",matcher2.group(1),matcher2.group(2),matcher2.group(3)};
        else throw new Exception("Неверное выражение");
    }
    public static int Calculation(int a,int b, String ch) throws Exception{
             switch(ch){
                 case "+": return a+b;
                 case "-": return a-b;
                 case "/": return a/b;
                 case "*": return a*b;
                 default:throw new Exception("Некорректный знак");
             }
    }
    public static int ConvertRToA(String d)throws Exception{
           switch (d){
               case "I":
                   return 1;
               case "II":
                   return 2;
               case "III":
                   return 3;
               case "IV":
                   return 4;
               case "V":
                   return 5;
               case "VI":
                   return 6;
               case "VII":
                   return 7;
               case "VIII":
                   return 8;
               case "IX":
                   return 9;
               case "X":
                   return 10;
               default: throw new Exception("Некорректное число");




           }
    }
    public static String ConvertAToR(int d) throws Exception {
        String result = "";
        while(d>=100){
              d-=100;
              result+="C";
        }
        while(d>=50) {d-=50;result+="L";}
        while(d>=10) {d-=10;result+="X";}
        if(d==9) result += "IX";
        if(d==8) result += "VIII";
        if(d==7) result += "VII";
        if(d==6) result += "VI";
        if(d==5) result += "V";
        if(d==4) result += "IV";
        if(d==3) result += "III";
        if(d==2) result += "II";
        if(d==1) result += "I";
        if(result == "") throw new Exception("Римские числа не могут быть равны нулю или отрицательным значениям");
        return result;
    }

    public static void main(String[] args) throws Exception {
         System.out.println("Введите");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().replaceAll(" ","").toUpperCase();
        var parts = calc(str);
        if(parts[0]=="a"){
            System.out.println(Calculation(Integer.parseInt(parts[1]), Integer.parseInt(parts[3]), parts[2]));
        }                             else{
            var a = ConvertRToA(parts[1]);
            var b = ConvertRToA(parts[3]);
            var result = Calculation(a,b,parts[2]);
            System.out.println(ConvertAToR(result));
        }
    }
}