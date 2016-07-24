package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.domain.entities.MessageEntity;
import ir.ssa.parkban.domain.entities.MessageReceiverEntity;
import ir.ssa.parkban.domain.entities.User;
import ir.ssa.parkban.domain.filters.MessageFilter;
import ir.ssa.parkban.domain.filters.MessageReceiverFilter;
import ir.ssa.parkban.domain.filters.UserFilter;
import ir.ssa.parkban.repository.MessageDAO;
import ir.ssa.parkban.repository.MessageReceiverDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.UtilityService;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilterOperation;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.StringFilterOperation;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import ir.ssa.parkban.vertical.messaging.core.Message;
import ir.ssa.parkban.vertical.messaging.core.MessageReceiver;
import ir.ssa.parkban.vertical.messaging.enums.MessageStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yeganeh
 */
@Service
public class UtilityServiceImpl implements UtilityService {

    @Autowired
    MessageDAO messageDAO;

    @Autowired
    MessageReceiverDAO messageReceiverDAO;

    /* Messaging Section*/
    @Override
    public Collection<? extends Message> getUserNewMessages(String userName) {

        MessageFilter messageFilter = setUsernameIntoMessageFilter(userName);

        /*EnumFilter<MessageStatus> statusEnumFilter = new EnumFilter<>();
        statusEnumFilter.setElementOp(EnumFilterOperation.EQUAL);
        statusEnumFilter.setValues(new Enum[] {MessageStatus.N});

        messageFilter.getReceivers().setStatus(statusEnumFilter);*/

        BaseService.setEntityGraph(messageDAO, messageFilter, "findAll");
        return ObjectMapper.map(messageDAO.findAll(messageFilter.getCriteriaExpression()), MessageEntity.class);
    }

    @Override
    public Collection<? extends Message> getUserAllMessages(String userName) {
        MessageFilter messageFilter = setUsernameIntoMessageFilter(userName);
        BaseService.setEntityGraph(messageDAO, messageFilter, "findAll");
        return ObjectMapper.map(messageDAO.findAll(messageFilter.getCriteriaExpression()), MessageEntity.class);
    }

    @Override
    public Collection<? extends Message> getUserSentMessages(String userName) {
        return null;
    }

    @Override
    public void sendMessage(Message message) {
        MessageEntity messageEntity = ObjectMapper.map(message, MessageEntity.class);
        List<MessageReceiverEntity> listOfReceivers = ObjectMapper.map(message.getReceivers(), MessageReceiverEntity.class);
        listOfReceivers.stream().forEach( element -> {
                    //element.setReceiver(new User());
                    element.getReceiver().setId(element.getId());
                    element.setId(null);
                }
        );
        messageEntity.setReceivers(new HashSet<MessageReceiverEntity>(listOfReceivers));
        messageDAO.save(messageEntity);
    }

    private MessageFilter setUsernameIntoMessageFilter(String username){
        StringFilter stringFilter = new StringFilter();
        stringFilter.setElementOp(StringFilterOperation.EQUAL.getValue());
        stringFilter.setValues(new String[]{username});

        UserFilter userFilter = new UserFilter();
        userFilter.setUsername(stringFilter);

        MessageReceiverFilter messageReceiverFilter = new MessageReceiverFilter();
        messageReceiverFilter.setReceiver(userFilter);

        MessageFilter messageFilter = new MessageFilter();
        messageFilter.setReceivers(messageReceiverFilter);
        return messageFilter;
    }

    /* end of messaging section */
}
