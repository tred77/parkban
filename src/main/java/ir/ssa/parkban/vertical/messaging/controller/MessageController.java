package ir.ssa.parkban.vertical.messaging.controller;

import ir.ssa.parkban.vertical.messaging.MessagingProvider;
import ir.ssa.parkban.vertical.messaging.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yeganeh
 */
@RestController
public class MessageController {

    @Autowired
    MessagingProvider messagingProvider;

    @RequestMapping(value = "/getUserNewMessages/{username}", method = RequestMethod.GET)
    public List<Message> getUserNewMessages(@PathVariable("username") String username){
        return (List<Message>)messagingProvider.getUserNewMessages(username);
    }

    @RequestMapping(value = "/getUserAllMessages/{username}", method = RequestMethod.GET)
    public List<Message> getUserAllMessages(@PathVariable("username") String username){
        return (List<Message>)messagingProvider.getUserAllMessages(username);
    }

    @RequestMapping(value = "/sendNewMessage", method = RequestMethod.POST)
    public void sendNewMessage(@RequestBody Message message){
        //return (List<Message>)messagingProvider.getUserAllMessages(username);
    }

}
