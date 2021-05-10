package com.example.redesocial.service;

import com.example.redesocial.dto.work.WorkDto;
import com.example.redesocial.dto.work.create.WorkCreateDto;
import com.example.redesocial.dto.work.update.WorkUpdateDto;
import com.example.redesocial.entity.Work;
import com.example.redesocial.mapper.work.WorkCreateMapper;
import com.example.redesocial.mapper.work.WorkMapper;
import com.example.redesocial.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class WorkService {

    private final WorkRepository workRepository;

    @Transactional
    public WorkDto create(WorkCreateDto workCreateDto) {
        return WorkMapper.INSTANCE.toDto(
                workRepository.save(
                        WorkCreateMapper.INSTANCE.toWork(workCreateDto)));
    }

    @Transactional
    public WorkDto update(WorkUpdateDto workUpdateDto) {
        Work work = workRepository.findById(workUpdateDto.getId()).orElse(null);
        if (isNull(work)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Work not found");
        }
        work.setCompany(workUpdateDto.getCompany());
        work.setRole(workUpdateDto.getRole());
        work.setCity(workUpdateDto.getCity());
        work.setDescription(workUpdateDto.getDescription());
        work.setActive(workUpdateDto.getActive());
        work.setStart(workUpdateDto.getStart());
        work.setEnd(workUpdateDto.getEnd());

        return WorkMapper.INSTANCE.toDto(workRepository.save(work));

    }

    @Transactional
    public void delete(Long workId) {
        workRepository.softDelete(workId);
    }
}
