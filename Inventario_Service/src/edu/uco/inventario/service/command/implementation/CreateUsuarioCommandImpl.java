package edu.uco.inventario.service.command.implementation;

import edu.uco.inventario.crosscutting.exception.BudgetCustomException;
import edu.uco.inventario.data.daofactory.DAOFactory;
import edu.uco.inventario.data.enumeration.DAOFactoryType;

import edu.uco.inventario.domain.UsuarioDTO;
import edu.uco.inventario.service.command.CreateUsuarioCommand;
import edu.uco.inventario.service.usecase.usuario.CreateUsuarioUseCase;
import edu.uco.inventario.service.usecase.usuario.implementation.CreateUsuarioUseCaseImpl;

public class CreateUsuarioCommandImpl implements CreateUsuarioCommand{

	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER);
	private final CreateUsuarioUseCase useCase = new CreateUsuarioUseCaseImpl(factory);

	@Override
	public void execute(UsuarioDTO usuario) {
		try {
			factory.initTransaction();		//usecase execution
			useCase.execute(usuario);
			factory.confirmTransaction();
		}catch(BudgetCustomException exception) {
			
			factory.cancelTransaction();
			throw exception;
		}catch(final Exception exception) {
			factory.cancelTransaction();
		}finally {
			factory.closeConnection();
		}
		
	}
}
