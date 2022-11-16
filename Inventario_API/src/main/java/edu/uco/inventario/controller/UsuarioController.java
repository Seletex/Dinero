package edu.uco.inventario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uco.inventario.controller.response.Response;
import edu.uco.inventario.controller.validator.Validator;
import edu.uco.inventario.controller.validator.usuario.CreateUsuarioValidator;
import edu.uco.inventario.crosscutting.exception.BudgetCustomException;
import edu.uco.inventario.crosscutting.messages.Message;

import edu.uco.inventario.service.command.implementation.CreateUsuarioCommandImpl;
import edu.uco.inventario.domain.UsuarioDTO;
import edu.uco.inventario.service.command.CreateUsuarioCommand;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	private CreateUsuarioCommand createBudgetCommand = new CreateUsuarioCommandImpl();

	@GetMapping("/dummy")
	public UsuarioDTO holaMundo() {
		return new UsuarioDTO();
	}

	@PostMapping
	public ResponseEntity<Response<UsuarioDTO>> create(@RequestBody UsuarioDTO budget) {
		
		Response<UsuarioDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;
		
		
		try {
			Validator<UsuarioDTO> validator = new CreateUsuarioValidator();
			List<Message> messages = validator.validate(budget);
			if(messages.isEmpty()) {
				createBudgetCommand.execute(budget);
				final List<UsuarioDTO> data = new ArrayList<>();
				data.add(budget);
				response.setData(data);
				response.addSuccessMessage("The budget has been created succesfully");
			}else {
				httpStatus = HttpStatus.BAD_REQUEST;
				
			}
			
			// Ok 200
		}catch(BudgetCustomException exception) {
			httpStatus = HttpStatus.BAD_REQUEST;
			if(exception.isTchnicalException()) {
				response.addSuccessMessage("There was an error trying to create the budget. Please try again ....");
			}else {
				response.addErrorMesssge(exception.getMessage());
			}
				
		}catch(Exception exception) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.addFatalMessage("There was an unexpected error trying to create the budget. Please try again ....");
		}
		
		return new ResponseEntity<>(response,httpStatus);
	}

}
