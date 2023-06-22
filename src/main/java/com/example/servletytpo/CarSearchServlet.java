package com.example.servletytpo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarSearchServlet extends HttpServlet {
    private List<Car> cars;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carType = req.getParameter("type");
        cars = loadCarsFromDB();
        List<Car> filteredCars = filterCarsByType(carType);
        req.setAttribute("cars", filteredCars);
        req.getRequestDispatcher("/result").forward(req, resp);
    }

    private List<Car> loadCarsFromDB() {
        List<Car> cars = new ArrayList<>();
        String connectionString = "jdbc:sqlserver://db-mssql.pjwstk.edu.pl:1433;databaseName=2019SBD;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(connectionString);
                 Statement statement = connection.createStatement()) {
                String selectQuery = "SELECT * FROM Car";
                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    String brand = resultSet.getString("brand");
                    String model = resultSet.getString("model");
                    String type = resultSet.getString("type");
                    int fuelConsumption = resultSet.getInt("fuelConsumption");
                    int year = resultSet.getInt("year");

                    Car car = new Car(brand, model, type, fuelConsumption, year);
                    cars.add(car);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Błąd połączenia z bazą");
            }
        return cars;
    }


    private List<Car> filterCarsByType(String carType) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getType().equalsIgnoreCase(carType)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }
}
