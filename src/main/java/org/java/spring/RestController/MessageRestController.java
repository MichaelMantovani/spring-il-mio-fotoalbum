package org.java.spring.RestController;

import org.java.spring.db.pojo.Message;
import org.java.spring.db.serv.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/message")
public class MessageRestController {

	@Autowired
	private MessageService messServ;

	@PostMapping("/create")
	public ResponseEntity<Message> createNewMessage(@RequestBody Message message) {
		messServ.save(message);

		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
