package com.marcelo.controle.services;


import com.marcelo.controle.domain.Record;
//import com.marcelo.controle.domain.User;
import com.marcelo.controle.domain.User;
import com.marcelo.controle.domain.enums.DayOfWeekEnum;
import com.marcelo.controle.domain.enums.StatusEnum;
import com.marcelo.controle.dto.RecordDTO;
import com.marcelo.controle.dto.RecordNewDTO;
import com.marcelo.controle.dto.UserNewDTO;
import com.marcelo.controle.repository.RecordRepository;
import com.marcelo.controle.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public Record find(Integer id) {
        Optional<Record> obj = recordRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo" + Record.class.getName()));
    }

    public Record insert(Record obj) {
        obj.setId(null);
        return recordRepository.save(obj);
    }



    public Record update(Record obj) {
        Record newObj = find(obj.getId());
        updateData(newObj, obj);
        return recordRepository.save(newObj);
    }

    private void updateData(Record newObj, Record obj){
        newObj.setDia(obj.getDayOfWeek());
        newObj.setTimes(obj.getTimes());
        newObj.setDate(obj.getDate());
//        newObj.setUser(obj.getUser());
    }

    public void delete(Integer id){
        find(id);
        try{
            recordRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possivel excluir um fucionario com registro no banco de horas");
        }

    }

    public List<Record> findAll(){
        return recordRepository.findAll();
    }

    public Record fromDTO(RecordDTO objDto) {
        //return new Record(objDto.getId(),null,objDto.getTimes(),objDto.getDate(),objDto.getUser());

        throw new UnsupportedOperationException();
    }


    public Record fromDTO(RecordNewDTO objDTO){
        Record reg = new Record(null, DayOfWeekEnum.toEnum(objDTO.getDayOfWeek()), objDTO.getTimes(), objDTO.getDate(), StatusEnum.toEnum(objDTO.getStatus()));
        User user = new User(null, objDTO.getName(), objDTO.getDepartament(), objDTO.getRoles(), objDTO.getRecord);
//        funcionario.getRecords().add(reg);
        reg.getUsers().add(user);
        return reg;


    }




}
