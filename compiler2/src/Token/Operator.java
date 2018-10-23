package Token;

import TypeOfToken.Tokentype;
import TypeOfToken.Operatortype;

import java.util.HashMap;

public abstract class Operator extends Token {
    protected static Operatortype Operatortype;


    public Operator(){
        tokentype = Tokentype.OPERATOR;
    }

    public static boolean isPrioriThan(Operatortype type1, Operatortype type2) {
        HashMap<Operatortype, Integer> priorityMap = new HashMap<Operatortype, Integer>();
        priorityMap.put(Operatortype.ADD, 1);
        priorityMap.put(Operatortype.SUB, 1);
        priorityMap.put(Operatortype.MULT, 2);
        priorityMap.put(Operatortype.DIV, 2);
        priorityMap.put(Operatortype.MOD,2);
        return priorityMap.get(type1) > priorityMap.get(type2);
    }

    public Operatortype getOperatorType() {
        return Operatortype;
    }
}
