package com.example.peerexchange.Exeptions;

public class RecordNotFoundException extends RuntimeException {
    private final Long serialVersionUID = 1L;

    public RecordNotFoundException() {

        super();

    }

    public RecordNotFoundException(String message) {

        super(message);

    }

}
