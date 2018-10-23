package Token;
import TypeOfToken.Tokentype;

public abstract class Token {
    protected Tokentype tokentype;
    public int tokenLines;
    public int tokenPosition;

    public Tokentype getTokentype(){
        return tokentype;
    }

    public void setTokenLines(int tokenLines){
        this.tokenLines = tokenLines;
    }

    public int getTokenLines(){
        return tokenLines;
    }

    public void setTolenPosition(int tokenPosition){
        this.tokenPosition = tokenPosition;
    }

    public int getTokenPosition(){
        return tokenPosition;
    }


}
