package com.marcelo.controle;

import com.marcelo.controle.domain.Record;
import com.marcelo.controle.domain.User;
import com.marcelo.controle.domain.enums.DayOfWeekEnum;
import com.marcelo.controle.domain.enums.StatusEnum;
import com.marcelo.controle.repository.UserRepository;
import com.marcelo.controle.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

import static java.util.Arrays.asList;

@SpringBootApplication
public class ControleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ControleApplication.class, args);
	}



	private Record time = new Record();
	private  Record data = new Record();
	private  Record status = new Record();


	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RecordRepository recordRepository;


	@Override
	public void run(String... args) throws Exception {





		Record reg1 = new Record(null, DayOfWeekEnum.TUESDAY, time.getTimes(), data.getDate(), StatusEnum.ENTRADA);
        Record reg2 = new Record(null, DayOfWeekEnum.TUESDAY, time.getTimes(), data.getDate(),StatusEnum.ENTRADA);
		Record reg3 = new Record(null, DayOfWeekEnum.TUESDAY, time.getTimes(), data.getDate(),StatusEnum.SAÍDA_INTERVALO);
		Record reg4 = new Record(null, DayOfWeekEnum.TUESDAY, time.getTimes(), data.getDate(),StatusEnum.SAÍDA_INTERVALO);


		User user1 = new User(null, "Marcos Alberto", "Marketing", "Analista de Marketing",reg1);
		User user2 = new User(null, "Mikael Anderson", "Comercial", "Analista Finenceiro", reg2);

//		user1.getUsers().addAll(Arrays.asList(reg1));
//		user2.getUsers().addAll(Arrays.asList(reg2));
		reg1.getUsers().addAll(Arrays.asList(user1));
		reg2.getUsers().addAll(Arrays.asList(user2));

		recordRepository.saveAll(asList(reg1,reg2));
       	userRepository.saveAll(asList(user1, user2));



    }



}

