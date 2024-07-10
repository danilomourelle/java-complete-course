import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.entities.Seller;

public class App {
	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Seller> sellers = new ArrayList<>();
		sellers.add(new Seller("Carl Purple", "carl@gmail.com", LocalDate.parse("22/04/1985", formatter), 3000.0, 4));
		sellers.add(new Seller("Alex Blue", "alex@gmail.com", LocalDate.parse("15/08/1990", formatter), 4000.0, 2));

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO seller " +
							"(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
							"VALUES " +
							"(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			for (Seller seller : sellers) {
				st.setString(1, seller.getName());
				st.setString(2, seller.getEmail());
				st.setDate(3, java.sql.Date.valueOf(seller.getBirthDate()));
				st.setDouble(4, seller.getBaseSalary());
				st.setInt(5, seller.getDepartmentId());
				st.addBatch();
			}

			int[] rowsAffected = st.executeBatch();

			for (int i : rowsAffected) {
				if (i == 0) {
					throw new SQLException("Insertion failed.");
				}
			}

			try (ResultSet rs = st.getGeneratedKeys()) {
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! ID = " + id);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}