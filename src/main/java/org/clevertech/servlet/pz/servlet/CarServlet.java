package org.clevertech.servlet.pz.servlet;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.clevertech.servlet.pz.dto.CarDto;
import org.clevertech.servlet.pz.service.CarService;
import org.clevertech.servlet.pz.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "car-servlet", value = "/v1/cars")
@Slf4j
public class CarServlet extends HttpServlet {

    private final Service<CarDto> carService = CarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String description = req.getParameter("description");
        Integer year =
                null != req.getParameter("year") ? Integer.parseInt(req.getParameter("year")) : null;
        String ownerPhone = req.getParameter("ownerPhone");
        Double minCost =
                null != req.getParameter("minCost") ? Double.parseDouble(req.getParameter("minCost")) : null;
        Double maxCost =
                null != req.getParameter("maxCost") ? Double.parseDouble(req.getParameter("maxCost")) : null;

        List<CarDto> carDtoList = carService.findByParams(brand, model, description,
                year, ownerPhone, minCost, maxCost);
        String json = new Gson().toJson(carDtoList);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(200);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDto accountDto = new Gson().fromJson(req.getReader(), CarDto.class);
        String json = new Gson().toJson(carService.save(accountDto));
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(201);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID uuid = req.getParameter("uuid") != null ? UUID.fromString(req.getParameter("uuid")) : null;

        carService.delete(new CarDto().setUuid(uuid));
    }
}
