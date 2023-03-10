package com.arsen.springpaymentmanagementsystem.security;

import com.arsen.springpaymentmanagementsystem.models.Receive;
import com.arsen.springpaymentmanagementsystem.repositories.ReceiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReceiveDetailsService implements UserDetailsService {
    private final ReceiveRepository receiveRepository;

    @Autowired
    public ReceiveDetailsService(ReceiveRepository receiveRepository) {
        this.receiveRepository = receiveRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Receive> receive = receiveRepository.findByEmail(username);

        if(receive.isEmpty())
            throw new UsernameNotFoundException("Receive not found!");

        return new ReceiveDetails(receive.get());
    }
}
