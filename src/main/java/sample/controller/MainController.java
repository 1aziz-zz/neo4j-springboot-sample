package sample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.model.Disease;
import sample.model.Patient;
import sample.model.Treatment;
import sample.repository.DiseaseRepo;
import sample.repository.PatientRepo;
import sample.repository.TreatmentRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aziz on 23-3-17 :)
 */
@RestController

public class MainController {


    @RequestMapping(value = "/rest/addTestData", method = RequestMethod.GET, produces = "application/json")
    public void addPersons() {
        patientRepo.deleteAll();
        treatmentRepo.deleteAll();
        diseaseRepo.deleteAll();
        patientRepo.save(this.addTestData());
    }

    private List<Patient> addTestData() {
        List<Patient> results = new ArrayList<>();

        // KNOWLEDGE LEVEL
        Treatment treatment1 = new Treatment("Using medicines", "NA");
        Treatment treatment2 = new Treatment("Surgery", "NA");

        Disease disease1 = new Disease("Stroke", "When an artery in the brain is blocked or leaks");
        Disease disease2 = new Disease("Prostate Cancer", "A respiratory cancer");
        Disease disease3 = new Disease("HIV/AIDS", "HIV is short for human immunodeficiency virus");

        Patient patient1 = new Patient("Eric", 20, "male", 185, 80);
        Patient patient2 = new Patient("Jan", 66, "male", 175, 100);
        Patient patient3 = new Patient("Mary", 33, "female", 165, 55);
        Patient patient4 = new Patient("Peter", 18, "male", 190, 75);
        Patient patient5 = new Patient("Mark", 22, "male", 171, 85);

        // OPERATIONAL LEVEL
        disease1.addTreatment(treatment1);
        disease1.addTreatment(treatment2);
        disease2.addTreatment(treatment1);
        disease3.addTreatment(treatment1);


        patient1.isDiagnosedWith(disease1);
        patient2.isDiagnosedWith(disease2);
        patient3.isDiagnosedWith(disease3);
        patient4.isDiagnosedWith(disease1);
        patient5.isDiagnosedWith(disease1);

        patient1.setTreatment(treatment1);
        patient1.setTreatment(treatment2);
        patient2.setTreatment(treatment1);

        patient1.knows(patient4);
        patient4.knows(patient5);
        patient2.knows(patient3);
        patient3.knows(patient4);
        patient5.knows(patient2);

        results.add(patient1);
        results.add(patient2);
        results.add(patient3);
        results.add(patient4);
        results.add(patient5);

        return results;

    }

    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private DiseaseRepo diseaseRepo;
    @Autowired
    private TreatmentRepo treatmentRepo;


}
