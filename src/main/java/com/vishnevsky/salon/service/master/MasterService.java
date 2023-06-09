package com.vishnevsky.salon.service.master;

import com.vishnevsky.salon.dto.MasterCreateRequestDto;
import com.vishnevsky.salon.model.Master;

import java.util.List;

public interface MasterService {

    List<Master> findMasters(Integer rang);

    void saveMaster(Master master, String name, String surname, Integer rang);

    void deleteMaster(Master master);

    public void addMaster(MasterCreateRequestDto masterCreateRequestDto);



}
