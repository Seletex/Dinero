package edu.uco.inventario.controller.validator.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.inventario.controller.validator.Validator;
import edu.uco.inventario.crosscutting.helper.UUIDHelper;
import edu.uco.inventario.crosscutting.messages.Message;
import edu.uco.inventario.crosscutting.messages.MessageUser;
import edu.uco.inventario.crosscutting.messages.enumeration.UsuarioLevel;
import edu.uco.inventario.domain.UsuarioDTO;

public class CreateUsuarioValidator implements Validator<UsuarioDTO> {

	@Override
	public List<MessageUser> validate(UsuarioDTO dto) {
		List<MessageUser> messagesUser = new ArrayList<>();
		List<Message> messages = new ArrayList<>();
		validarUsuarioId(dto.getId(), messages);
		despedirEmpleadoEmplado(dto.getId(), messagesUser, UsuarioLevel.EMPLEADO,
				dto.getCargo());

		return messagesUser;
	}

	private void validarUsuarioId(UUID usuarioId, List<Message> message) {
		if (UUIDHelper.isDefualtUUID(usuarioId)) {
			message.add(
					Message.createErrorMessage("Usuario id is equal to default value "));
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	private void despedirEmpleadoEmplado(UUID usuarioid, List<MessageUser> messages,
			UsuarioLevel level, String cargo) {
		if (usuarioid.equals(usuarioid)) {
			if (cargo.equals(UsuarioLevel.EMPLEADO)) {
				messages.add(MessageUser.createErrorEmpleadoMessageUser(
						"Es imposible despedir a alguien en este cargo, solo es posible presnetar un informe a la empresa"));
			}
			if(cargo.equals(UsuarioLevel.SUPERVISOR)) {
				messages.add(MessageUser.createImpossibleSupervisorMessageUser("Es imposible que un superviso despida a un empleado"));
			}
		}
	}
}
