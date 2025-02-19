package com.keyin.rest.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {
    @Autowired
    private AircraftRepository aircraftRepository;

    public Aircraft addAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public List<Aircraft> findAllAircrafts() {
        return (List<Aircraft>) aircraftRepository.findAll();
    }

    public Aircraft findAircraftById(long id) {
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);

        return aircraftOptional.orElse(null);
    }

    public Aircraft createAircraft(Aircraft newAircraft) {
        return aircraftRepository.save(newAircraft);
    }

    public Aircraft findAircraftByName(String name) {
        return aircraftRepository.findByAircraftName(name);
    }

    public Aircraft updateAircraft(Aircraft updatedAircraft) {
        Aircraft aircraftToUpdate = findAircraftById(updatedAircraft.getId());

        if (aircraftToUpdate != null) {
            aircraftToUpdate.setAirlineName(updatedAircraft.getAirlineName());
            aircraftToUpdate.setType(updatedAircraft.getType());
            aircraftToUpdate.setNumberOfPassengers(updatedAircraft.getNumberOfPassengers());

//            aircraftToUpdate.setPassengers(checkIfExistsOrCreate(updatedAircraft.getPassengers()));

            aircraftRepository.save(aircraftToUpdate);
        }

        return aircraftToUpdate;
    }

//    private List<Passenger> checkIfExistsOrCreate(List<Passenger> passengers) {
//        if (passengersToCheck != null) {
//            for (Passenger passenger : passengersToCheck) {
//                Passenger registeredStudentFound = registeredStudentService.findByEmailAddress(student.getEmailAddress());
//
//                if (registeredStudentFound == null) {
//                    registeredStudentFound = registeredStudentService.createRegisteredStudent(student);
//                } else {
//                    student.setId(registeredStudentFound.getId());
//                }
//            }
//        }
//
//        return studentsToCheck;
//    }
}