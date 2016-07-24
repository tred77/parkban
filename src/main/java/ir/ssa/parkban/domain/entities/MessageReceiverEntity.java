package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.vertical.messaging.core.MessageReceiver;
import ir.ssa.parkban.vertical.messaging.enums.MessageStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Yeganeh
 */
@Entity(name = "TBL_Message_Receiver_Entity")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "MESSAGE_RECEIVER_SEQ")
public class MessageReceiverEntity extends DomainEntity implements MessageReceiver{

    @Column(name = "RECEIVE_DATE")
    private Date receiveDate;

    @Column(name = "RECEIVER_ROLE")
    private String receiverRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECEIVER")
    private User receiver;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private MessageStatus status;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE")
    private MessageEntity message;

    public MessageEntity getMessage() {
        return message;
    }

    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    @Override
    public String getReceiverRole() {
        return receiverRole;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Override
    public void setReceiverRole(String receiverRole) {
        this.receiverRole = receiverRole;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    @Override
    public String getFirstName() {
        return receiver.getFirstName();
    }

    @Override
    public String getLastName() {
        return receiver.getLastName();
    }

    @Override
    public String getUsername() {
        return receiver.getUsername();
    }

    @Override
    public void setFirstName(String firstName) {
        if (receiver == null ){
            receiver = new User();
        }
        this.getReceiver().setFirstName(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        if (receiver == null ){
            receiver = new User();
        }
        this.getReceiver().setLastName(lastName);
    }

    @Override
    public void setUsername(String userName) {
        if (receiver == null ){
            receiver = new User();
        }
        this.getReceiver().setUsername(userName);
    }
}
