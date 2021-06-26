package FullParser;

import java.io.Serializable;

public class LinhaIncorretaException extends Exception implements Serializable {
    public LinhaIncorretaException(){
        super();
    }

    public LinhaIncorretaException(String s){
        super(s);
    }
}
