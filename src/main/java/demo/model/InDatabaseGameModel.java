package demo.model;

import demo.entity.Game;
import demo.helper.ConnectionHelper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

public class InDatabaseGameModel implements GameModel {

    @Override
    public boolean save(Game game) {
        try {
            PreparedStatement preparedStatement = ConnectionHelper.getConnection()
                    .prepareStatement("insert into games (code, name, price, publicBy, publicDate) values (?,?,?,?,?)");
            preparedStatement.setString(1, game.getCode());
            preparedStatement.setString(2, game.getName());
            preparedStatement.setDouble(3, game.getPrice());
            preparedStatement.setString(4, game.getPublicBy());
            Calendar calendar = Calendar.getInstance();
            Date date = Date.valueOf(game.getPublicDate()); // dần chuyển sang Calendar.
            preparedStatement.setDate(5, date);
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Game> getList() {
        ArrayList<Game> articleArrayList = new ArrayList<>();
        try {
            String cmd = "select * from games"; // chưa có phân trang.
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(cmd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String publicBy = resultSet.getString("publicBy");
                Date date = resultSet.getDate("publicDate");
                String strPublicDate = date.toString();
                int status = resultSet.getInt("status");
                Game game = new Game(code, name, price, publicBy, strPublicDate, status);
                articleArrayList.add(game);
            }
        } catch (Exception ex) {
            System.err.println("Không thể lấy dữ liệu từ database. Message: " + ex.getMessage());
        }
        return articleArrayList;
    }
}
