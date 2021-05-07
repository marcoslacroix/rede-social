package com.example.redesocial.service;

import com.example.redesocial.dto.email.EmailDto;
import com.example.redesocial.entity.Email;
import com.example.redesocial.entity.User;
import com.example.redesocial.exception.EmailAlreadyFound;
import com.example.redesocial.mapper.email.EmailCreateMapper;
import com.example.redesocial.mapper.email.EmailMapper;
import com.example.redesocial.repository.EmailRepository;
import com.example.redesocial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;
    private final UserRepository userRepository;

    @Transactional
    public EmailDto create(Long userId, String email) {

        User userSearch = userRepository.findByEmailPrincipal(email);
        Email emailSearch = emailRepository.findByEmail(email);
        if (nonNull(userSearch) || nonNull(emailSearch)) {
            throw new EmailAlreadyFound(email);
        }

        Email newEmail = EmailCreateMapper.INSTANCE.toEmail(userId, email);
        emailRepository.save(newEmail);


        return EmailMapper.INSTANCE.toDto(newEmail);
    }

    @Transactional
    public void delete(Long emailId) {
        emailRepository.softDelete(emailId);
    }
}
