package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.domain.enums.ParkTimeStatus;
import ir.ssa.parkban.vertical.messaging.core.Message;
import ir.ssa.parkban.vertical.messaging.core.MessageReceiver;
import ir.ssa.parkban.vertical.messaging.core.MessageUser;
import ir.ssa.parkban.vertical.messaging.enums.MessageStatus;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * @author hym
 */
@Entity(name = "TBL_Message_entity")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "MESSAGE_SEQ")
public class MessageEntity extends DomainEntity implements Message {

    @Column(name = "SENT_DATE")
    private Date sentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SENDER")
    private User sender;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "SENDER_ROLE")
    private String senderRole;

    @Column(name = "TEXT")
    private String text;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "message", cascade = {CascadeType.PERSIST})
    private Set<MessageReceiverEntity> receivers;



    @Override
    public void setSenderRole(String senderRole) {
        this.senderRole = senderRole;
    }

    @Override
    public void setSender(MessageUser messageSender) {
        this.sender = (User)messageSender;
    }

    @Override
    public void setReceivers(Collection<? extends MessageReceiver> messageReceivers) {
        this.receivers = (Set<MessageReceiverEntity>)messageReceivers;
    }

    public Date getSentDate() {
        return sentDate;
    }

    @Override
    public String getSenderRole() {
        return senderRole;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public User getSender() {
        return sender;
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

    public Set<MessageReceiverEntity> getReceivers() {
        return receivers;
    }

}
