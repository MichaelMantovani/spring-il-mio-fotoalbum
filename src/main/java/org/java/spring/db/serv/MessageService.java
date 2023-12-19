package org.java.spring.db.serv;

import java.util.List;

import org.java.spring.db.pojo.Message;
import org.java.spring.db.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messRepo;
	
	
	public List<Message> findAll() {
		return messRepo.findAll();
	}
	
	public Message findById(int id) {
		return messRepo.findById(id).get();
	}
	
	public List<Message> findByMessage(String message) {

		return messRepo.findByMessageContainingIgnoreCase(message);
	}
	
	public void delete(Message message) {
		messRepo.delete(message);
	}
	
	
	public void save(Message message) {
		messRepo.save(message);
	}
}
