package com.springJPA2.JPA2.Ques3.joined_table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VechileController {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    BikeRepository bikeRepository;

    @GetMapping
    public List<Vehicle> getVehicle() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/car")
    public List<Car> getCar() {
        return carRepository.findAll();
    }

    @GetMapping("/bike")
    public List<Bike> getBike() {
        return bikeRepository.findAll();
    }

    @PostMapping("add-car")
    public Car createCar() {
        Car car = new Car();
        car.setBrand("Ford");
        car.setBluetooth(true);
        car.setNumberOfDoors(4);
        car.setYear(2019);
        car.setEngine("New Engine");
        return carRepository.save(car);
    }

    @PostMapping("add-bike")
    public Bike createBike() {
        Bike bike = new Bike();
        bike.setBrand("Yamaha");
        bike.setYear(2012);
        bike.setEngine("New Engine");
        bike.setMileage(3.4);
        return bikeRepository.save(bike);
    }

}
