package org.vascoom.vascoomspring.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.vascoom.vascoomspring.entities.Users;
import org.vascoom.vascoomspring.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> findAllActiveUsers(int skip, int take) {
        if (skip != 0 && take != 0) {
            int pageNumber = Math.ceilDiv(skip, take);
            Pageable pageable = PageRequest.of(pageNumber, take);
            return usersRepository.findAllByIsActiveTrue();
        } else {
            return usersRepository.findAllByIsActiveTrue();
        }
    }

    public List<Users> findAllUsers(int skip, int take) {
        if (skip != 0 && take != 0) {
            int pageNumber = Math.ceilDiv(skip, take);
            Pageable pageable = PageRequest.of(pageNumber, take);
            return (List<Users>) usersRepository.findAll(pageable);
        } else {
            return usersRepository.findAll();
        }
    }

    public Users createUser(Users users) {
        return usersRepository.save(users);
    }

    public Users updateUser(Users newUsers, Long user) {
        Users users = usersRepository.findById(user).get();
        if (newUsers.getEmail() != null) {
            users.setEmail(newUsers.getEmail());
        }
        if (newUsers.getPassword() != null) {
            users.setPassword(newUsers.getPassword());
        }
        return usersRepository.save(users);
    }

    public Users deleteUser(Long user) {
        Users users = usersRepository.findById(user).get();
        users.setActive(false);
        return usersRepository.save(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Not Found"));
    }
}
