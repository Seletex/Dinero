package edu.uco.budget.service.usecase.person;

import edu.uco.budget.domain.PersonDTO;

public interface CreatePersonUseCase {
	void execute(PersonDTO person);
}
