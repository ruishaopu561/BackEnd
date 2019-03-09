import java.util.*;

public class Calculator{
    public String address(String input, String text)
    {
        String output = "";
        if (input == "cle") {
            output = "";
        } else if (input == "del") {
            if (text.length() > 0) {
                output = text.substring(0, text.length() - 1);
            }
        } else if (input == "=") {
            output = calculate(text);
            if(output == ""){
                output = "Error during calculation.";
            }
        } else if (input == "exit") {
            System.exit(0);
        } else {
            output = text + input;
        }
        return output;
    }

    public String calculate(String input)
    {
        String output = "";

        if (input.contains("*")) {
            String[] string = input.split("\\*");
            String left = calculate(string[0]);
            String right = calculate(string[1]);
            if(!(left == "") && !(right == "")){
                output = operation(left, right, "*");
            } else {
                System.out.println("Error input.");
                System.exit(0);
            }
        } else if (input.contains("/")) {
            String[] string = input.split("\\/");
            String left = calculate(string[0]);
            String right = calculate(string[1]);
            if(!(left == "") && !(right == "")){
                output = operation(left, right, "/");
            } else {
                System.out.println("Error input.");
                System.exit(0);
            }
        } else if (input.contains("+")) {
            String[] string = input.split("\\+");
            String left = calculate(string[0]);
            String right = calculate(string[1]);
            if(!(left == "") && !(right == "")){
                output = operation(left, right, "+");
            } else {
                System.out.println("Error input.");
                System.exit(0);
            }
        } else if (input.contains("-")) {
            int index = input.indexOf("-");
            if (index == 0)
            {
                String a = input.substring(1, input.length());
                if(a.contains("-")){
                    String[] string = a.split("-");
                    String left = calculate("-" + string[0]);
                    String right = calculate(string[1]);
                    if(!(left == "") && !(right == "")){
                        output = operation(left, right, "-");
                    }   
                }else{
                    output = input;
                }
            }else{
                String[] string = input.split("-");
                String left = calculate(string[0]);
                String right = calculate(string[1]);
                if(!(left == "") && !(right == "")){
                    output = operation(left, right, "-");
                } else {
                    System.out.println("Error input.");
                    System.exit(0);
                }
            }
        } else if(input.contains(".")) {
            String[] string = input.split(".");
            String left = string[0];
            String right = string[1];
            if(!left.contains(".") && !right.contains("."))
            {
                output = input;
            }
        }else{
            output = input;
        }
        
        return output;
    }

    public String operation(String left, String right, String op)
    {
        String output = "";
        boolean l = left.contains(".");
        boolean r = right.contains(".");
        int l1,r1;
        double l2,r2;
        if(!l && !r)
        {
            l1 = Integer.valueOf(left);
            r1 = Integer.valueOf(right);
            switch (op){
                case "+":{
                    output = String.valueOf(l1 + r1);
                    break;
                }
                case "-":{
                    output = String.valueOf(l1 - r1);
                    break;
                }
                case "*":{
                    output = String.valueOf(l1 * r1);
                    break;
                }
                case "/":{
                    output = String.valueOf(l1 / r1);
                    break;
                }
            }
        }else{
            l2 = Double.valueOf(left);
            r2 = Double.valueOf(right);
            switch (op){
                case "+":{
                    output = String.valueOf(l2 + r2);
                    break;
                }
                case "-":{
                    output = String.valueOf(l2 - r2);
                    break;
                }
                case "*":{
                    output = String.valueOf(l2 * r2);
                    break;
                }
                case "/":{
                    output = String.valueOf(l2 / r2);
                    break;
                }
            }
        }
        return output;
    }
}