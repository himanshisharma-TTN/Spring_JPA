package com.springJPA2.JPA2.Ques3.single_table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    TrainRepository trainRepository;

    @Autowired
    LocalTrainRepository localTrainRepository;

    @Autowired
    ExpressTrainRepository expressTrainRepository;

    @GetMapping
    public List<Train> getTrainsList() {
        return trainRepository.findByCapacityGreaterThan(500);
    }

    @GetMapping("/local")
    public List<Train> getLocalList() {
        return localTrainRepository.findByCapacityGreaterThan(520);
    }

    @PostMapping("/add-local")
    public Train createLocal() {
        LocalTrain localTrain = new LocalTrain();
        int random = (int) (Math.random() * 100);
        localTrain.setTrainName("Local " + random);
        localTrain.setTrainNumber(123 + random);
        localTrain.setCategory("LocalType");
        localTrain.setCapacity(500 + random);
        localTrain.setLocalId(random * 10L + 2 * 19L);
        return localTrainRepository.save(localTrain);
    }

    @PostMapping("/add-express")
    public Train createExpress() {
        ExpressTrain expressTrain = new ExpressTrain();
        int random = (int) (Math.random() * 100);
        expressTrain.setTrainName("Local " + random);
        expressTrain.setTrainNumber(123 + random);
        expressTrain.setCategory("ExpressType");
        expressTrain.setCapacity(500 + random);
        return expressTrainRepository.save(expressTrain);
    }

    @PutMapping("/update-local")
    public Train updateTrain() {
        LocalTrain localTrain = localTrainRepository.findById(145L).orElse(null);
        if (localTrain == null) return null;
        localTrain.setTrainName("Local 78");
        return localTrainRepository.save(localTrain);
    }


}
