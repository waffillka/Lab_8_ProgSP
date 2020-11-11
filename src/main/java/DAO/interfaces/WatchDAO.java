package DAO.interfaces;

import Models.Watch;

import java.util.List;

public interface WatchDAO {
    void insert(Watch watch);

    boolean updateWatch(Watch watch);

    Watch selectWatch(int id);

    List<Watch> selectWatch(String typeWatch);

    List<Watch> selectWatch(int price, String typeWatch);

    List<Watch> selectWatchCountry(String country);

    List<Watch> selectAllWatch();

    void deleteWatch(int id);
}
