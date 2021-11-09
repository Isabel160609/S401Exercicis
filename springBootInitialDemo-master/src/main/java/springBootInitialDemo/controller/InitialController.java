package springBootInitialDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBootInitialDemo.dto.UserResponseDto;
import springBootInitialDemo.service.IUserService;

@RestController
@RequestMapping("/")
public class InitialController {

    private final IUserService userService;

    @Autowired
    public InitialController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String helloGradle() {
        return "Hello world !";
    }

    @GetMapping("/{name}")
    public String saludoConNombre(@PathVariable(name="name")String name) {
        return String.format("Hello %s !",name);
        
    }
    
//    @PutMapping("/")
//    public String helloPut() {
//        return "HELLO PUT!!!";
//    }
//    @DeleteMapping("/")
//    public String helloDelete() {
//        return "HELLO DELETE!!!";
//    }
//    @PostMapping("/")
//    public String helloPost() {
//        return "HELLO POST!!!";
//    }
    
    @PutMapping(value ="", consumes = {"application/json"})
    @GetMapping("/user/{uuid}")
    public ResponseEntity<UserResponseDto> updatePrescription(
            @PathVariable(name="uuid") String user) throws Exception {


        UserResponseDto userResponseDto = userService.getUser("pp");

        System.out.println(userResponseDto.getName());
        System.out.println(userResponseDto.getSurname());
        System.out.println(userResponseDto.getGender());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);

    }


}
