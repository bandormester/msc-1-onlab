package hu.szurdok.msc.booking.controller;
import java.util.List;
import java.util.Optional;

import hu.szurdok.msc.booking.model.User;
import hu.szurdok.msc.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/register")
	public Boolean registerUser(@RequestBody User user)
	{
		User newUser = userRepository.save(user);

		System.out.println("register");

		return newUser.getUserName().equals(user.getUserName());
	}

	@GetMapping("/login")
	public String login(@RequestParam(value="userName") String userName,
						@RequestParam(value="password") String password){
		Optional<User> user = userRepository.findByUserName(userName);

		if(user.isPresent()){
			if(user.get().getPassword().equals(password)){
				return "Siker";
			}
			return "Wrong password";
		}
		return "Wrong username";
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	@GetMapping("/getUserById/{id}")
	public Optional<User> getUserById(@PathVariable(value="id") Long id)
	{
		return userRepository.findById(id);
	}

	@PutMapping("/updateUser/{id}")
	public User updateUser(@PathVariable(value="id") Long id, @RequestBody User userDetails)
	{
		Optional<User> user = userRepository.findById(id);
		User realUser=user.get();

		realUser.setUserName(userDetails.getUserName());
		realUser.setEmail(userDetails.getEmail());
		realUser.setFullName(userDetails.getFullName());
		realUser.setPassword(userDetails.getPassword());

		return userRepository.save(realUser);
	}

	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable(value="id") Long id)
	{
		Optional<User> user=userRepository.findById(id);
		User realUser=user.get();
		userRepository.delete(realUser);
	}
}