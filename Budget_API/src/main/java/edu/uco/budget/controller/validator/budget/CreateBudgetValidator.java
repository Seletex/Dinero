package edu.uco.budget.controller.validator.budget;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.controller.validator.Validator;
//import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.inventario.crosscutting.helper.UUIDHelper;
import edu.uco.inventario.crosscutting.messages.Message;

public class CreateBudgetValidator implements Validator<BudgetDTO> {

	@Override
	public List<Message> validate(BudgetDTO dto) {
		List<Message> messages = new ArrayList<>();
		validatePersonId(dto.getPersona().getId(),messages );
		return messages;
	}

	private void validatePersonId(UUID personId, List<Message> message) {
		if (UUIDHelper.isDefualtUUID(personId)) {
			message.add(
					Message.createErrorMessage("Person Id is equal to default value "));
		}
	}

}
