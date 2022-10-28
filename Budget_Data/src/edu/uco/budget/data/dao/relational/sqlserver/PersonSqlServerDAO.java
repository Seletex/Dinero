package edu.uco.budget.data.dao.relational.sqlserver;

import static edu.uco.budget.crosscutting.helper.StringHelper.getUUIDAsString;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.crosscutting.exception.data.DataCustomException;
import edu.uco.budget.crosscutting.helper.ObjectHelper;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.PersonDTO;

public class PersonSqlServerDAO extends DAORelational implements PersonDAO {

	public PersonSqlServerDAO(final Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void create(PersonDTO person) {
		final var sql = "INSERT INTO BUDGET(  id,   idCard,   firstName,   secondName, firstSurname,   secondSurname) VALUES (?, ?, ?,?,?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getIdCard());
			preparedStatement.setString(3, person.getFirstName());
			preparedStatement.setString(4, person.getSecondName());
			preparedStatement.setString(5, person.getFirstSurname());
			preparedStatement.setString(6, person.getSecondSurname());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			String message = Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_CREATE_PERSON.concat(person.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			String message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_PERSON
					.concat(person.getIdAsString());
			DataCustomException.createTechnicalException(message, exception);

		}
	}

	@Override
	public final List<PersonDTO> find(PersonDTO person) {
		var results = new ArrayList<PersonDTO>();
		boolean setWhere = true;
		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("SELECT         Id As IdYear, ");
		sqlBuilder.append("              IdCard As Card, ");
		sqlBuilder.append("              firstName As FirstName, ");
		sqlBuilder.append("              secondName As SecondName, ");
		sqlBuilder.append("              firstSurname As FirstSurname,firstName,   secondName, firstSurname,   secondSurname ");
		sqlBuilder.append("              secondSurname As SecondSurname, ");

		sqlBuilder.append(" FROM Year  ");

		if (!ObjectHelper.isNull(person)) {
			if (!UUIDHelper.isDefualtUUID(person.getId())) {
				sqlBuilder.append("WHERE Bu.id = ? ");
				setWhere = false;
				paramenters.add(person.getIdAsString());
			}

		}

		sqlBuilder.append("ORDER BY firstSurname ASC ");
		

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {
			for (int index = 0; index < paramenters.size(); index++) {
				preparedStatement.setObject(index + 1, paramenters.get(index));
			}
			try (final var resultSet = preparedStatement.executeQuery()) {
				// fill the list with the results
			}
		} catch (SQLException exception) {
			final var message = Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_FIND_PERSON
					.concat(person.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (Exception exception) {
			final var message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FIND_PERSON
					.concat(person.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}

		return results;
	}

	@Override
	public final void update(PersonDTO person) {
		final var sql = "UPDATE YEAR SET idYearNumber=? WHERE id=?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, person.getIdAsString());
			preparedStatement.setString(2, person.getIdCard());
			preparedStatement.setString(3, person.getFirstName());
			preparedStatement.setString(4, person.getSecondName());
			preparedStatement.setString(5, person.getFirstSurname());
			preparedStatement.setString(6, person.getSecondSurname());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.PersonSqlServerDAO.TECHNICAL_PROBLEM_UPDATE_PERSON
					.concat(person.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			final var message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_PERSON
					.concat(person.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}
	}

	@Override
	public final void delete(UUID id) {
		final var sql = "DELETE INTO YEAR WHERE id=?";
		final var idAsString = getUUIDAsString(id);

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, idAsString);

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PERSON;
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {

			final var message = Messages.PersonSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_PERSON;
			throw DataCustomException.createTechnicalException(message, exception);
		}
	}

}
