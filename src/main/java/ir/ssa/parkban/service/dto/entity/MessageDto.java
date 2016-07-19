package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.domain.entities.DomainEntity;
import ir.ssa.parkban.domain.entities.MessageReceiverEntity;
import ir.ssa.parkban.domain.entities.User;
import ir.ssa.parkban.vertical.messaging.core.Message;
import ir.ssa.parkban.vertical.messaging.core.MessageReceiver;
import ir.ssa.parkban.vertical.messaging.core.MessageUser;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * @author hym
 */
public class MessageDto extends DomainEntityDto {

    private Date sentDate;
    private UserDto sender;
    private String subject;
    private String text;


    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public UserDto getSender() {
        return sender;
    }

    public void setSender(UserDto sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
