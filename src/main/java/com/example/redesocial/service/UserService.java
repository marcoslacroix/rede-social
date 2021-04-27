package com.example.redesocial.service;

import com.example.redesocial.dto.ContactDto;
import com.example.redesocial.dto.UserDto;
import com.example.redesocial.model.entity.Contact;
import com.example.redesocial.model.entity.User;
import com.example.redesocial.repository.ContactRepository;
import com.example.redesocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;

    public UserDto add() {

        // create user
        User u = User.builder()
                .name("Marcos")
                .lastName("Lacroix")
                .password("1234567")
                .email("marcoslacroix@gmail.com")
                .uuid(String.valueOf(UUID.randomUUID()))
                .birthdate(LocalDate.now())
                .build();

        // create contact
        Contact contact = Contact.builder()
                .uuid(String.valueOf(UUID.randomUUID()))
                .user(u)
                .cellPhone(991835294L)
                .dddCell(48)
                .dddHome(48)
                .homePhone(32624762L)
                .build();

        // cria lista de contato
        if (isNull(u.getContacts())) {
            u.setContacts(new ArrayList<>());
        }

        // adiciona o contato na lista de usuário
        u.getContacts().add(contact);

        // salva user
        userRepository.save(u);
        // salva contato
        contactRepository.save(contact);

        // parse user para userdto
        UserDto userDto = UserDto.builder()
                .id(u.getId())
                .name(u.getName())
                .lastName(u.getLastName())
                .password(u.getPassword())
                .email(u.getEmail())
                .uuid(u.getUuid())
                .birthdate(u.getBirthdate())
                .build();

        // cria lista de contato do userdto
        if (isNull(userDto.getContacts())) {
            userDto.setContacts(new ArrayList<>());
        }

        // cria o contatodto
        ContactDto contactDto = ContactDto.builder()
                .id(contact.getId())
                .uuid(contact.getUuid())
                .cellPhone(contact.getCellPhone())
                .dddCell(contact.getDddCell())
                .dddHome(contact.getDddHome())
                .homePhone(contact.getHomePhone())
                .build();

        // salva o contato na lista de userdto
        userDto.getContacts().add(contactDto);

        return userDto;

    }
}
