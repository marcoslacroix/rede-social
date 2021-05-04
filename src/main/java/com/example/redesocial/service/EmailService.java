package com.example.redesocial.service;

import com.example.redesocial.dto.email.EmailDto;
import com.example.redesocial.dto.email.create.EmailCreateDto;
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

import java.util.UUID;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;
    private final UserRepository userRepository;

    @Transactional
    public EmailDto create(EmailCreateDto emailCreateDto) {

        User userSearch = userRepository.findByEmailPrincipal(emailCreateDto.getEmail());
        Email emailSearch = emailRepository.findByEmail(emailCreateDto.getEmail());
        if (nonNull(userSearch) || nonNull(emailSearch)) {
            throw new EmailAlreadyFound(emailCreateDto.getEmail());
        }

        Email email = EmailCreateMapper.INSTANCE.toEmail(emailCreateDto);
        emailRepository.save(email);

        return EmailMapper.INSTANCE.toDto(email);
    }
}
