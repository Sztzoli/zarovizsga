package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private final DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        country = country.toUpperCase();
        String sql = "SELECT `name` FROM `dog_types` WHERE `country`= ? ORDER BY `name`";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, country);
            return namesFromResultSet(ps);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by SELECT", sqle);
        }
    }

    private List<String> namesFromResultSet(PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()) {
            List<String> result = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name").toLowerCase();
                result.add(name);
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by ResultSet", sqle);
        }
    }
}
