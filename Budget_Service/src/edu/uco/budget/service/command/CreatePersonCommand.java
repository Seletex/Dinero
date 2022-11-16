package edu.uco.budget.service.command;

import edu.uco.budget.domain.PersonDTO;

public interface CreatePersonCommand {

	void execute(PersonDTO budget) throws Throwable;
}
