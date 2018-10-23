package Token;

import TypeOfToken.Tokentype;
import TypeOfToken.Valuetype;

public abstract class Value extends Token{
    protected Valuetype valuetype;
    private int intValue;
    private char chatValue;
    private String stringValue;
    private boolean booleanValue;

    public Value(Valuetype type){
        tokentype = Tokentype.VALUE;
        valuetype = type;
    }

    public Valuetype getValuetype() {
        return valuetype;
    }

    public void setValuetype(Valuetype valuetype) {
        this.valuetype = valuetype;
    }

    public char getChatValue() {
        return chatValue;
    }

    public void setChatValue(char chatValue) {
        this.chatValue = chatValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int inValue) {
        this.intValue = inValue;
    }
}
