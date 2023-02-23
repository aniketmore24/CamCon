package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beans.User;
import com.service.LoginService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/about")
public class HomeController {
	
	
	@Autowired
	LoginService lservice;
	
	@PostMapping("/a")
	public ResponseEntity<List<Integer>> as() {
		List<Integer> plist = new ArrayList<>();
		plist.add(2);
		plist.add(3);
		
		return ResponseEntity.ok(plist);
		 
	}

	
	@PostMapping("/authenticate")
	public ResponseEntity authenticate(@RequestBody User user) {
		
		return ResponseEntity.ok("OKKKk");
		
		
		
		
	}
}
