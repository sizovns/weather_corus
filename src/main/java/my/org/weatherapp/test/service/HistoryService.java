package my.org.weatherapp.test.service;

import my.org.weatherapp.test.dao.HistoryRepository;
import my.org.weatherapp.test.model.History;
import org.springframework.beans.factory.annotation.Autowired;

public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;
}
