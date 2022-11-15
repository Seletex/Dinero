package edu.uco.budget.controller;

import java.util.ArrayList;
import java.util.List;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import edu.uco.budget.controller.validator.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uco.budget.controller.response.Response;

import edu.uco.budget.controller.validator.budget.CreateBudgetValidator;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.command.CreateBudgetCommand;
import edu.uco.budget.service.command.implementation.CreateBudgetCommandImpl;
import edu.uco.inventario.crosscutting.exception.BudgetCustomException;
import edu.uco.inventario.crosscutting.messages.Message;


@RestController
@RequestMapping("/api/budget")
public class BudgetController {

	private CreateBudgetCommand createBudgetCommand = new CreateBudgetCommandImpl();

	@GetMapping("/dummy")
	public BudgetDTO holaMundo() {
		return new BudgetDTO();
	}

	@PostMapping
	public ResponseEntity<Response<BudgetDTO>> create(@RequestBody BudgetDTO budget) {
		
		Response<BudgetDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;
		
		
		try {
			Validator<BudgetDTO> validator = new CreateBudgetValidator();
			List<Message> messages = validator.validate(budget);
			if(messages.isEmpty()) {
				createBudgetCommand.execute(budget);
				final List<BudgetDTO> data = new ArrayList<>();
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
