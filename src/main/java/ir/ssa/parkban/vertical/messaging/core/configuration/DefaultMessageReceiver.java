package ir.ssa.parkban.vertical.messaging.core.configuration;

import ir.ssa.parkban.vertical.messaging.core.MessageReceiver;
import ir.ssa.parkban.vertical.messaging.enums.MessageStatus;

import java.util.Date;

/**
 * Created by hadoop on 7/22/16.
 */
public class DefaultMessageReceiver extends DefaultUser implements MessageReceiver {

    private Date receiveDate;
    private String receiverRole;
    private MessageStatus status;

    @Override
    public MessageStatus getStatus() {
        return status;
    }

    @Override
    public Date getReceiveDate() {
        return receiveDate;
    }

    @Override
    public String getReceiverRole() {
        return receiverRole;
    }

    @Override
    public void setStatus(MessageStatus messageStatus) {
        this.status = messageStatus;
    }

    @Override
    public void setReceiveDate(Date date) {
        this.receiveDate = date;
    }

    @Override
    public void setReceiverRole(String receiverRole) {
        this.receiverRole = receiverRole;
    }
}
