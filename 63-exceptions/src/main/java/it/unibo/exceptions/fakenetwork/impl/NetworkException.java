package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException{
    private String myMessage;

    public NetworkException() {
        this.myMessage = "Network error: no response";
    }

    public NetworkException(String stringa) {
        this.myMessage = "Network error while sending message: " + stringa;
    }

    
}
