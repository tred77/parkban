package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.repository.UserDAO;
import ir.ssa.parkban.service.bean.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Yeganeh
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.findByUsername(s);
    }
}
