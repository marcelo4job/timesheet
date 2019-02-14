package com.marcelo.controle.services;


import com.marcelo.controle.domain.Record;
import com.marcelo.controle.domain.User;
import com.marcelo.controle.domain.enums.DayOfWeekEnum;
import com.marcelo.controle.domain.enums.StatusEnum;
import com.marcelo.controle.dto.UserDTO;
import com.marcelo.controle.dto.UserNewDTO;
import com.marcelo.controle.repository.UserRepository;
import com.marcelo.controle.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User find(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo" + User.class.getName()));
    }

    public User insert(User obj) {
        obj.setId(null);
        return userRepository.save(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getDepartament(), objDto.getRoles(), objDto.getRecord());
    }
//
//    public User fromDTO(UserNewDTO objDTO){
//        User funcionario = new User(null, objDTO.getName(), objDTO.getDepartament(), objDTO.getRoles(), objDTO.getRecord());
//        Record reg = new Record(null, DayOfWeekEnum.toEnum(objDTO.getDayOfWeek()), objDTO.getTimes(), objDTO.getDate(), StatusEnum.toEnum(objDTO.getSatatus()),objDTO.getRecordId());
//        funcionario.getRecords().add(reg);
//        return funcionario;
//
//    }

    public User update(User obj) {
        User newObj = find(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setRoles(obj.getRoles());
        newObj.setDepartament(obj.getDepartament());
    }

    public void delete(Integer id){
        find(id);
        try{
            userRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possivel excluir um fucionario com registro no banco de horas");
        }

    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
