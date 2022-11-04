package com.sicredipucrs.AvesDeRapina.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicredipucrs.AvesDeRapina.dto.BirdDTO;
import com.sicredipucrs.AvesDeRapina.entities.Bird;
import com.sicredipucrs.AvesDeRapina.repositories.BirdRepository;

@Service
public class BirdService {
    
    @Autowired
    private BirdRepository repository;

    @Transactional
    public BirdDTO insert(BirdDTO dto){
        Bird entity = new Bird();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new BirdDTO(entity);
    }

    private void copyDtoToEntity(BirdDTO dto, Bird entity) {
        entity.setNamePT(dto.getNamePT());
        entity.setNameEN(dto.getNameEN());
        entity.setNameLAT(dto.getNameLAT());
        entity.setSize(dto.getSize());
        entity.setGender(dto.getGender());
        entity.setColor(dto.getColor());
        entity.setFamily(dto.getFamily());
        entity.setHabitat(dto.getHabitat());
    }

    @Transactional(readOnly = true)
    public List<BirdDTO> findBird(String param){
        List<Bird> list = repository.findBirdContainingIgnoreCase(param);
        
        List<BirdDTO> listDTO = new ArrayList<>();
        for(Bird bird : list){
            listDTO.add(new BirdDTO(bird));
        }

        return listDTO;
    }

    @Transactional
    public BirdDTO update(Long id, BirdDTO dto) {
        try{
            Bird entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new BirdDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id " + id + " not found ");
        }
    }

    public void delete(Long id) {
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id " + id + " not found ");
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Integrity violation");
        }
    }

    
}
