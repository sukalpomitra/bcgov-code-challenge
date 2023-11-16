package com.innofyre.rhcfs.service;

import com.innofyre.rhcfs.model.OrderDiscount;
import com.innofyre.rhcfs.model.Volunteer;
import com.innofyre.rhcfs.model.VolunteerRequest;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService {
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private SpringLiquibase liquibase;

    /**
     * This is only for testing,
     * not completed yet
     * @param volunteer
     * @return
     * @throws LiquibaseException
     */
    public Volunteer createVolunteer(VolunteerRequest volunteerRequest) throws LiquibaseException {
        // Drools logic here
        Volunteer volunteer1 = new Volunteer();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("volunteer", volunteer1);
        kieSession.insert(volunteer1);
        kieSession.fireAllRules();
        kieSession.dispose();


        // Liquibase logic here
        liquibase.afterPropertiesSet(); // Run Liquibase changesets

        return volunteer1;
    }
}
