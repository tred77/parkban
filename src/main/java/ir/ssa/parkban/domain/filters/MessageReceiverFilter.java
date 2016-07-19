package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.DomainEntity;
import ir.ssa.parkban.domain.entities.MessageEntity;
import ir.ssa.parkban.domain.entities.QMessageReceiverEntity;
import ir.ssa.parkban.domain.entities.User;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;
import ir.ssa.parkban.vertical.messaging.core.MessageReceiver;
import ir.ssa.parkban.vertical.messaging.enums.MessageStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Yeganeh
 */
public class MessageReceiverFilter extends BaseFilter{

    private DateFilter receiveDate;
    private StringFilter receiverRole;
    private UserFilter receiver;
    private EnumFilter status;
    private MessageFilter message;

    public EnumFilter getStatus() {
        return status;
    }

    public void setStatus(EnumFilter status) {
        this.status = status;
    }

    public DateFilter getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(DateFilter receiveDate) {
        this.receiveDate = receiveDate;
    }

    public StringFilter getReceiverRole() {
        return receiverRole;
    }

    public void setReceiverRole(StringFilter receiverRole) {
        this.receiverRole = receiverRole;
    }

    public UserFilter getReceiver() {
        return receiver;
    }

    public void setReceiver(UserFilter receiver) {
        this.receiver = receiver;
    }

    public MessageFilter getMessage() {
        return message;
    }

    public void setMessage(MessageFilter message) {
        this.message = message;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QMessageReceiverEntity.messageReceiverEntity;
    }
}
