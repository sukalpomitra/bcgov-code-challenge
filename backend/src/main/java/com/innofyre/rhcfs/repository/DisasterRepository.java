package com.innofyre.rhcfs.repository;

import com.innofyre.rhcfs.entity.Disaster;
import com.innofyre.rhcfs.model.DisasterStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisasterRepository extends JpaRepository<Disaster, Long> {

  @Query("SELECT v FROM Disaster v WHERE v.disasterStatus = :disasterStatus")
  public List<Disaster> findByDisasterStatus(DisasterStatus disasterStatus);
}
