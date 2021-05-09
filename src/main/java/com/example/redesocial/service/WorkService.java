package com.example.redesocial.service;

import com.example.redesocial.dto.work.WorkDto;
import com.example.redesocial.dto.work.create.WorkCreateDto;
import com.example.redesocial.entity.Work;
import com.example.redesocial.mapper.work.WorkCreateMapper;
import com.example.redesocial.mapper.work.WorkMapper;
import com.example.redesocial.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkService {

    private final WorkRepository workRepository;

    public WorkDto create(WorkCreateDto workCreateDto) {
        return WorkMapper.INSTANCE.toDto(
                workRepository.save(
                        WorkCreateMapper.INSTANCE.toWork(workCreateDto)
                )
        );
    }
}
