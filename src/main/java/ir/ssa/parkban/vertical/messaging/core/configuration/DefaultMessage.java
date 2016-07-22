package ir.ssa.parkban.vertical.messaging.core.configuration;

import ir.ssa.parkban.vertical.messaging.core.Message;
import ir.ssa.parkban.vertical.messaging.core.MessageReceiver;
import ir.ssa.parkban.vertical.messaging.core.MessageUser;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Created by hadoop on 7/21/16.
 */
public class DefaultMessage implements Message{

    private Date sentDate;
    private MessageUser sender;
    private String subject;
    private String text;
    private Collection<? extends MessageReceiver> receivers;
    private String senderRole;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public MessageUser getSender() {
        return sender;
    }

    @Override
    public Collection<? extends MessageReceiver> getReceivers() {
        return receivers;
    }

    @Override
    public Date getSentDate() {
        return sentDate;
    }

    @Override
    public String getSenderRole() {
        return senderRole;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setText(String messageText) {
        this.text = messageText;
    }

    @Override
    public void setSender(MessageUser messageSender) {
        this.sender = messageSender;
    }

    @Override
    public void setReceivers(Collection<? extends MessageReceiver> messageReceivers) {
        receivers = messageReceivers;
    }

    @Override
    public void setSentDate(Date messageSentDate) {
        this.sentDate = messageSentDate;
    }

    @Override
    public void setSenderRole(String senderRole) {
        this.senderRole = senderRole;
    }

    @Override
    public void setSubject(String messageSubject) {
        this.subject = messageSubject;
    }
}
