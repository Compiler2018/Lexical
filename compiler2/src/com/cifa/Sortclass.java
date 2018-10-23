package com.cifa;

public class Sortclass {
    public String getSortclass(char opts){
        String sortclass = null;
        /**switch(opts) {
            case 'n':
                sortclass = "DIGIT";
            case '+':
                sortclass = "ADD";
            case '-':
                sortclass = "MINUS";
            case '*':
                sortclass = "MUL";
            case '/':
                sortclass = "DIV";
            /**case "<<":
                sortclass = "left_shift";
            case ">>":
                sortclass = "right_shift";
             */
         /**   case '(':
                sortclass = "LEFTBRACKED";

            case ')':
                sortclass = "RIGHTBRACKED";
             default:
                    sortclass = "NONE";
                    break;


        }
        */
         if(opts == 'n')
             sortclass = "OPERAND";
         else if(opts =='+')
             sortclass = "ADD";
         else if(opts == '-')
             sortclass = "MIN";
         else if(opts == '*')
             sortclass = "MULT";
         else if(opts == '/')
             sortclass = "MOD";
         else if(opts == '(')
             sortclass = "LEFT_BRACKET";
         else if(opts == ')')
             sortclass = "RIGHT_BRACKET";

        return sortclass;
    }
}
