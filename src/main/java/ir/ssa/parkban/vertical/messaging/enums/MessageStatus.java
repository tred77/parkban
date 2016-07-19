package ir.ssa.parkban.vertical.messaging.enums;

import java.util.Arrays;

/**
 * @author Yeganeh
 */
public enum MessageStatus {

    N("New"),
    S("Sent");

    private String value;

    MessageStatus(String value){
        this.value=value;
    }

    public static MessageStatus fromValue(String value){
        return Arrays.stream(MessageStatus.values()).filter(v-> v.value.equals(value)).
                findFirst().orElseThrow(()-> new IllegalArgumentException());
    }

}
