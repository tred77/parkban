package ir.ssa.parkban.domain.filters;

import com.mysema.query.types.path.EntityPathBase;
import ir.ssa.parkban.domain.entities.MessageReceiverEntity;
import ir.ssa.parkban.domain.entities.QMessageEntity;
import ir.ssa.parkban.domain.entities.User;
import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author hym
 */
public class MessageFilter extends BaseFilter {

    private DateFilter sentDate;
    private UserFilter sender;
    private StringFilter subject;
    private StringFilter text;
    private MessageReceiverFilter receivers;

    public DateFilter getSentDate() {
        return sentDate;
    }

    public void setSentDate(DateFilter sentDate) {
        this.sentDate = sentDate;
    }

    public UserFilter getSender() {
        return sender;
    }

    public void setSender(UserFilter sender) {
        this.sender = sender;
    }

    public StringFilter getSubject() {
        return subject;
    }

    public void setSubject(StringFilter subject) {
        this.subject = subject;
    }

    public StringFilter getText() {
        return text;
    }

    public void setText(StringFilter text) {
        this.text = text;
    }

    public MessageReceiverFilter getReceivers() {
        return receivers;
    }

    public void setReceivers(MessageReceiverFilter receivers) {
        this.receivers = receivers;
    }

    @Override
    protected EntityPathBase getEntityPath() {
        return QMessageEntity.messageEntity;
    }
}
