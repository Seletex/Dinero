package edu.uco.inventario.controller.validator.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.inventario.controller.validator.Validator;
import edu.uco.inventario.crosscutting.helper.UUIDHelper;
import edu.uco.inventario.crosscutting.messages.Message;
import edu.uco.inventario.domain.UsuarioDTO;


public class CreateUsuarioValidator implements Validator<UsuarioDTO> {

	@Override
	public List<Message> validate(UsuarioDTO dto) {
		List<Message> messages = new ArrayList<>();
		validatePersonId(dto.getId(),messages );
		return messages;
	}

	private void validatePersonId(UUID usuarioId, List<Message> message) {
		if (UUIDHelper.isDefualtUUID(usuarioId)) {
			message.add(
					Message.createErrorMessage("Person Id is equal to default value "));
		}
	}
}
