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
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.BudgetDTO;

public class BudgetSqlServerDAO extends DAORelational implements BudgetDAO {

	public BudgetSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(BudgetDTO budget) {
		final var sql = "INSERT INTO BUDGET(id, idYear, idPerson) VALUES (?, ?, ?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, budget.getIdAsString());
			preparedStatement.setString(2, budget.getYear().getIdAsString());
			preparedStatement.setString(3, budget.getPersona().getIdAsString());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_CREATE_BUDGET
					.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {

			String message = Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET
					.concat(budget.getIdAsString());
			DataCustomException.createTechnicalException(message, exception);
		}
	}

	@Override
	public final List<BudgetDTO> find(BudgetDTO budget) {
		var results = new ArrayList<BudgetDTO>();
		boolean setWhere = true;
		var paramenters = new ArrayList<Object>();
		final StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("SELECT         Bu.Id As IdBudget, ");
		sqlBuilder.append("               Bu.IdYear As IdBudget, ");
		sqlBuilder.append("         Ye.year As NumberYear, ");
		sqlBuilder.append("        Bu.IdPerson As IdPerson, ");
		sqlBuilder.append("               Pe.IdCard As IdCardPerson, ");
		sqlBuilder.append("               Pe.firstName As FirstNamePerson, ");
		sqlBuilder.append("               Pe.secondName As secondNamePerson, ");
		sqlBuilder.append("              Pe.firstSurname As firstSurnamePerson, ");
		sqlBuilder.append("               Pe.secondSurname As secondSurnamePerson, ");
		sqlBuilder.append(" FROM Budget Bu ");
		sqlBuilder.append(" INNER JOIN Year ye ");
		sqlBuilder.append(" ON  Bu.idYear = ye.id ");
		sqlBuilder.append(" INNER JOIN Person pe ");
		sqlBuilder.append(" ON  Bu.idPerson = pe.id ");

		if (!ObjectHelper.isNull(budget)) {
			if (!UUIDHelper.isDefualtUUID(budget.getId())) {
				sqlBuilder.append("WHERE Bu.id = ? ");
				setWhere = false;
				paramenters.add(budget.getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(budget.getYear().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ").append("WHERE Bu.idYear = ? ");
				paramenters.add(budget.getYear().getIdAsString());
			}

			if (!UUIDHelper.isDefualtUUID(budget.getPersona().getId())) {
				sqlBuilder.append(setWhere ? "WEHERE " : "AND ").append("WHERE Bu.idPerson = ? ");
				paramenters.add(budget.getPersona().getIdAsString());
			}

		}

		sqlBuilder.append("ORDER BY Pe.idCard ASC, ");
		sqlBuilder.append("              Ye.year ASC.");

		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {
			for (int index = 0; index < paramenters.size(); index++) {
				preparedStatement.setObject(index + 1, paramenters.get(index));
			}
			try (final var resultSet = preparedStatement.executeQuery()) {
				// fill the list with the results
			}
		} catch (SQLException exception) {
			final var message = Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FIND_BUDGET
					.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (Exception exception) {
			final var message = Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FIND_BUDGET
					.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}

		return results;
	}

	@Override
	public final void update(BudgetDTO budget) {
		final var sql = "UPDATE BUDGET SET idYear=? ,idPerson=? WHERE id=?";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, budget.getIdAsString());
			preparedStatement.setString(2, budget.getYear().getIdAsString());
			preparedStatement.setString(3, budget.getPersona().getIdAsString());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_UPDATE_BUDGET
					.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			final var message = Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_BUDGET
					.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}
	}

	@Override
	public final void delete(UUID id) {
		final var sql = "DELETE INTO BUDGET WHERE id=?";
		final var idAsString = getUUIDAsString(id);

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, idAsString);

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			final var message = Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_DELETE_BUDGET;
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {

			final var message = Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_BUDGET;
			throw DataCustomException.createTechnicalException(message , exception);
		}
	}

}
