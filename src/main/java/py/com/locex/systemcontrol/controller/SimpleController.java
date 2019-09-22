package py.com.locex.systemcontrol.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/simple")
public class SimpleController {

	@GetMapping(value="/")
	public ResponseEntity<Object> buscarClientes(){
            System.out.println("OK PAPA PURETE");
            return new ResponseEntity<>(HttpStatus.OK);
	}
}
